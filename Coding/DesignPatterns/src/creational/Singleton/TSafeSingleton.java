package creational.Singleton;

/**
 * Two threads can get inside of the if statement concurrently when instance is
 * null . Then, one thread enters the synchronized block to initialize instance
 * , while the other is blocked. When the first thread exits the synchronized
 * block, the waiting thread enters and creates another Singleton object.
 *
 * Singleton can b broken by clone,reflection,serialization
 */
public class TSafeSingleton {
	private volatile static TSafeSingleton _instance = new TSafeSingleton();

	private TSafeSingleton() {
	}

	public static TSafeSingleton getInstanceDC() {
		if (_instance == null) {
			synchronized (Singleton.class)// Single Checked
			{
				if (_instance == null) { // Double checked
					_instance = new TSafeSingleton();
				}
			}
		}
		return _instance;
	}

	public static void setInstance(TSafeSingleton instance) {
		TSafeSingleton._instance = instance;
	}
}
