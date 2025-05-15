package byps.gen.ts;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Bootleg dependency injection
 */
public class DependencyContainer {

	private static final Set<String> registeredClasses = new HashSet<>();
	private static final HashMap<String, Object> instances = new HashMap<>();

	public static <T> void addInstance(Class<T> serviceClass, T instance) {
		instances.put(serviceClass.getName(), instance);
		registeredClasses.add(serviceClass.getName());
	}

	public static void registerClass(Class<?> serviceClass) {
		DependencyContainer.registeredClasses.add(serviceClass.getName());
	}

	public static boolean isRegistered(Class<?> serviceClass) {
		return DependencyContainer.registeredClasses.contains(serviceClass.getName());
	}

	private static <T> Optional<T> getIfPresent(Class<T> dependency) {
		if (instances.containsKey(dependency.getName())) {
			//noinspection unchecked Based on how instances are registered this should always return type T.
			return Optional.of((T) instances.get(dependency.getName()));
		}

		return Optional.empty();
	}

	public static <T> T get(Class<T> dependency) {
		return getIfPresent(dependency).orElseGet(() -> instantiate(dependency));
	}

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
			DependencyContainer.addInstance(dependency, instance);
			return instance;
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

}
