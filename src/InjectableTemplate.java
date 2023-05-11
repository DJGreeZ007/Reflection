import java.io.IOException;

/**
 * The InjectableTemplate class represents a template for an injectable object.
 */
public class InjectableTemplate {
    @AutoInjectable
    private FirstInterface field1;
    @AutoInjectable
    private SecondInterface field2;

    /**
     * Prints the actions performed by the injected fields.
     */
    public void printActions() {
        field1.doAction();
        field2.doAction();
    }

    /**
     * The main method demonstrates the injection process using different configuration files.
     * @param args the command-line arguments.
     * @throws IOException if an I/O error occurs while reading the configuration file.
     * @throws ClassNotFoundException if the class specified in the configuration file cannot be found.
     * @throws InstantiationException if an error occurs during object instantiation.
     * @throws IllegalAccessException if there is an illegal access to a field during injection.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String[] filePaths = {
                "src/resources/test1.properties",
                "src/resources/test2.properties",
                "src/resources/test3.properties",
                "src/resources/test4.properties"
        };

        for (int i = 0; i < filePaths.length; i++) {
            System.out.println("("+ (i + 1) +")" + ':');

            // Create an instance of the Injector and inject dependencies into the InjectableTemplate
            InjectableTemplate test = (new Injector(filePaths[i])).inject(new InjectableTemplate());

            // Print the actions performed by the injected fields
            test.printActions();

            System.out.println("");
        }
    }
}
