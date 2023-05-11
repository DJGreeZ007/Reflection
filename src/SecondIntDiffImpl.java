/**
 * The SecondIntDiffImpl class is an implementation of the SecondInterface.
 * It provides an alternative implementation for the doAction() method.
 */
public class SecondIntDiffImpl implements SecondInterface {
    /**
     * Performs a different action than the default implementation in SecondInterface.
     * Prints "The other second interface says hello!" to the console.
     */
    public void doAction() {
        System.out.println("The other second interface says hello!");
    }
}