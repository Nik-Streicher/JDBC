package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import core.DatabaseHandler;

public class Controller {

    @FXML
    private TextField nameField;

    @FXML
    private PasswordField passwordField;


    @FXML
    void addUser(ActionEvent event) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.signUpUser(nameField.getText(),passwordField.getText());
    }
}