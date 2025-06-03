package byps.gen.ts;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Bootleg dependency injection without support for inheritance.
 */
public class DependencyContainer {
	
	/**
	 * Set of classnames that are allowed to be instantiated by the container.
	 */
	private static final Set<String> registeredClasses = new HashSet<>();
	/**
	 * Map of instances of by class names that have been manually or automatically registered before.
	 */
	private static final HashMap<String, Object> instances = new HashMap<>();
	
	/**
	 * Registers an instance of the given class to the container.
	 * Also registers the class to allow injection of the instance.
	 *
	 * @param instance - Instance to register, class is extrapolated from the class not resolving extends.
	 */
	public static <T> void addInstance(T instance) {
		instances.put(instance.getClass().getName(), instance);
		registeredClasses.add(instance.getClass().getName());
	}
	
	/**
	 * Register a class to allow it to be instantiated by the container.
	 *
	 * @param serviceClass - Class to register. An instance is not created until requested.
	 */
	public static void registerClass(Class<?> serviceClass) {
		DependencyContainer.registeredClasses.add(serviceClass.getName());
	}
	
	/**
	 * Checks whether the given class is registered.
	 *
	 * @param serviceClass - Class to check
	 * @return whether the class is registered.
	 */
	public static boolean isRegistered(Class<?> serviceClass) {
		return DependencyContainer.registeredClasses.contains(serviceClass.getName());
	}
	
	/**
	 * Obtain the instance of a given class
	 *
	 * @param dependency - Class of the dependency to get.
	 * @return Optional of the instance if it exists or an empty optional otherwise.
	 */
	private static <T> Optional<T> getIfPresent(Class<T> dependency) {
		if (instances.containsKey(dependency.getName())) {
			//noinspection unchecked Based on how instances are registered this should always return type T.
			return Optional.of((T) instances.get(dependency.getName()));
		}

		return Optional.empty();
	}
	
	/**
	 * Obtain the instance of a given class or create a new instance of the class.
	 * All constructor parameters will be resolved recursively
	 *
	 * @param dependency - Class of the instance to get.
	 * @return the instance with all constructor parameters resolved.
	 */
	public static <T> T get(Class<T> dependency) {
		return getIfPresent(dependency).orElseGet(() -> instantiate(dependency));
	}
	
	/**
	 * Creates a new instance of the class recursively gathering instances of the constructor parameters if necessary.
	 * Will also add the instance to the dependency container.
	 *
	 * @param dependency - Class of the instance to get
	 * @return the new instance with all constructor parameters resolved.
	 */
	private static <T> T instantiate(Class<T> dependency) {
		if (!DependencyContainer.isRegistered(dependency)) {
			throw new RuntimeException(
				"Trying to instantiate a class that wasn't registered to the container: " + dependency.getName());
		}

		//noinspection unchecked we do not modify the array so we can be sure it's of type T
		Constructor<T>[] constructors = (Constructor<T>[]) dependency.getConstructors();

		if (constructors.length != 1) {
			throw new RuntimeException(
				"Either no or too many accessible constructors are present for class " + dependency.getName() + ": Found " + constructors.length + " constructors.");
		}

		Constructor<T> constructor = constructors[0];

		Parameter[] parameters = constructor.getParameters();
		Object[] instances = new Object[parameters.length];

		for (int i = 0; i < parameters.length; i++) {
			Class<?> type = parameters[i].getType();
			instances[i] = DependencyContainer.get(type);
		}

		try {
			T instance = constructor.newInstance(instances);
			DependencyContainer.addInstance(instance);
			return instance;
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
