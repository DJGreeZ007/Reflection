import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * The Injector class is responsible for dependency injection.
 */
public class Injector {

    private File data;

    /**
     * Constructs an Injector object with the specified file path.
     * @param filePath the path to the configuration file.
     */
    public Injector(String filePath) {
        this.data = new File(filePath);
    }

    /**
     * Injects dependencies into the given object.
     * @param obj the object to inject dependencies into.
     * @param <T> the type of the object.
     * @return the object with injected dependencies.
     * @throws IOException if an I/O error occurs while reading the configuration file.
     * @throws ClassNotFoundException if the class specified in the configuration file cannot be found.
     * @throws InstantiationException if an error occurs during object instantiation.
     * @throws IllegalAccessException if there is an illegal access to a field during injection.
     */
    public <T> T inject(T obj) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties properties = new Properties();
        properties.load(new FileReader(data));

        Class objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field f: fields) {
            Annotation a = f.getAnnotation(AutoInjectable.class);

            // Set the field accessible to modify its value
            f.setAccessible(true);

            if (a != null) {
                // Retrieve the class name from the properties based on the field type
                String typeName = properties.getProperty(f.getType().getName());

                // Create an instance of the class using reflection
                Object classObject = Class.forName(typeName).newInstance();

                // Set the instance as the value of the field in the object
                f.set(obj, classObject);
            }
        }
        return obj;
    }
}