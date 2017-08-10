package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import common.Direction;
import doorway.Path;
import exception.IllegalCommandException;
import exception.IllegalMapException;
import exception.IllegalPathException;
import item.Item;
import location.Location;

public class LevelBuilder {

	private static final Map<String, Class<?>> NAME_CLASS_MAP;

	private LevelBuilder() {

	}

	static {
		NAME_CLASS_MAP = new HashMap<>();
		String pkgName1 = Path.class.getPackage().getName();
		Reflections reflections1 = new Reflections(pkgName1);
		Set<Class<? extends Path>> subTypes1 = reflections1.getSubTypesOf(Path.class);
		for (Class<? extends Path> cls : subTypes1) {
			if (NAME_CLASS_MAP.put(cls.getSimpleName(), cls) != null)
				System.err.println("Duplicate class mapping detected");
		}

		String pkgName2 = Item.class.getPackage().getName();
		Reflections reflections2 = new Reflections(pkgName2);
		Set<Class<? extends Item>> subTypes2 = reflections2.getSubTypesOf(Item.class);
		for (Class<? extends Item> cls : subTypes2) {
			if (NAME_CLASS_MAP.put(cls.getSimpleName(), cls) != null)
				System.err.println("Duplicate class mapping detected");
		}
		
		String pkgName3 = Location.class.getPackage().getName();
		Reflections reflections3 = new Reflections(pkgName3);
		Set<Class<? extends Location>> subTypes3 = reflections3.getSubTypesOf(Location.class);
		for (Class<? extends Location> cls : subTypes3) {
			if (NAME_CLASS_MAP.put(cls.getSimpleName(), cls) != null)
				System.err.println("Duplicate class mapping detected");
		}
	}

	private static GameMap buildMap(File file) throws IllegalMapException {
		Location start = null;
		BufferedReader br = null;
		String readLine = null;
		try {
			br = new BufferedReader(new FileReader(file));
			int lip = 0;
			Map<String, Object> map = new HashMap<>();
			while ((readLine = br.readLine()) != null) {
				readLine = readLine.trim().replaceAll(" +", " ");
				if (readLine.startsWith("#")) continue;
				if (readLine.startsWith("Locations")) {
					lip = 1;
					continue;
				} else if (readLine.startsWith("Items")) {
					lip = 2;
					continue;
				} else if (readLine.startsWith("Paths")) {
					lip = 3;
					continue;
				}

				String[] words = readLine.split(" ");
				if (words.length < 1)
					continue;
				switch (lip) {
				case 1:					
					for (int i = 0; i < words.length; i++) {
						String[] args = words[i].split("#");
						Location loc = null;
						if (args.length  == 1) 
							loc = (Location) NAME_CLASS_MAP.get(args[0]).newInstance();
						else if (args.length == 2)
							loc = (Location) NAME_CLASS_MAP.get(args[0]).newInstance();
						map.put(words[i], loc);
						if (start == null)
							start = loc;
					}
					continue;
				case 2:
					Location loc = (Location) map.get(words[0]);
					for (int i = 1; i < words.length; i++) {
						Item item = (Item) NAME_CLASS_MAP.get(words[i]).newInstance();
						loc.addItems(item);
					}
					continue;
				case 3:
					Location from = (Location) map.get(words[0]);
					Location to = (Location) map.get(words[1]);
					Direction direction = Direction.getDirection(words[2]);
					Object[] params = { from, to, direction };
					Path path = (Path) NAME_CLASS_MAP.get(words[3])
							.getConstructor(Location.class, Location.class, Direction.class).newInstance(params);
					Location.addPath(path);
					continue;
				}
			}
		} catch (IOException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException | IllegalPathException e) {
			System.err.println(readLine);
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return new GameMap(start);
	}

	public static GameMap getMap(File file) throws IllegalPathException, IllegalMapException, IllegalCommandException {
		return buildMap(file);
	}
}
