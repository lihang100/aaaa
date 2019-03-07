package link;

import java.io.IOException;
import java.util.Properties;
public class configuration {
	private static Properties pore;

	static {
		pore = new Properties();
		try {
			pore.load(configuration.class.getResourceAsStream("/peizhi.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return pore.getProperty(key);

	}

	public static void main(String[] args) {
		System.out.println(configuration.get("name"));

	}
}
