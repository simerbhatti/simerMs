package creational.Singleton;
/**
 * Singleton is singleton per class loader.
 * (per JVM if in tomcat classpath)
 *
 */
public class Singleton {

	private static Singleton instance = new Singleton();

	private Singleton(){

	}
	public static Singleton getInstance() {
		return instance;
	}

	public static void setInstance(Singleton instance) {
		Singleton.instance = instance;
	}

}
