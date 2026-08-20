package abstractfactory;

import org.hamcrest.Factory;

public class Main {
    public static void main(String[] args) {
        // 1. Create a factory for a specific UI style (A or B)
        UIFactory factory = new BFactory();

        // 2. Use the factory to create UI components
        Button button = factory.createButton("Login");
        TextField textField = factory.createTextField("Username");
        Checkbox checkbox = factory.createCheckbox("Remember me");

        // 3. Printe elemnts from original UI components
        System.out.println("--- Original UI components ---");
        button.display();
        textField.display();
        checkbox.display();


        // 4. Display the UI components
        System.out.println("\n--- Text has been change ---");
        button.setText("Send");
        textField.setText("Password");
        checkbox.setText("Not accepting terms");

        // 5. Print the updated UI components
        button.display();
        textField.display();
        checkbox.display();

    }
}
