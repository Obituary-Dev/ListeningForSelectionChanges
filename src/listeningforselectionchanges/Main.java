package listeningforselectionchanges;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Obituary
 */
public class Main extends Application {

    Stage window;
    Scene scene;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("ChoiceBox demo");

        button = new Button("Click me");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Apples", "Bananas", "Bacon", "Ham", "Meatballs");
        choiceBox.setValue("Apples");
        
        // Listen for selection changes
        // getSelectionModel: dropdownlist, one selection only
        // selectedItemProperty: selected item from the user has properties
        // addListener: sit on your item and wait for something to happen: click. Emmits 3 parameters
        // parameters on left hand side and code on the right: lambda expression
        // v list item, old value meatballs, and then select apple as new value
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> System.out.println(newValue) );
        
        
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(choiceBox, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();

    }

}