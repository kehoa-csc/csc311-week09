package org.example.csc311week09;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.*;

public class HelloController {
    @FXML
    private Button addButton;

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField dobField;
    @FXML
    private TextField zipField;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label dobLabel;
    @FXML
    private Label zipLabel;

    private boolean firstNameValid;
    private boolean lastNameValid;
    private boolean emailValid;
    private boolean dobValid;
    private boolean zipValid;

    /// @param toCheck The string to check with RegEx.
    /// @param l The corresponding label to update if it's empty, valid, or invalid
    /// @param pattern The pattern to check toCheck with.
    /// @return If the pattern check is valid.
    /// @throws PatternSyntaxException If the pattern given is syntactically incorrect.
    /// @author Andrew Kehoe
    //Takes in a String and makes sure it is valid with the given pattern. Then updates its label to show the user the result.
    protected boolean checker(String toCheck, Label l, String pattern) throws PatternSyntaxException {
        if (toCheck.isEmpty()) {
            l.setText("Empty");
        } else if (toCheck.matches(pattern)) {
            l.setText("Valid");
            return true;
        } else {
            l.setText("Invalid");
        }
        return false;
    }

    //Gets input from the First Name text field, and checks if it's valid. Then checks if the button should be enabled.
    @FXML
    protected void checkFirstName() {
        String firstName = firstNameField.getText();
        String namePattern = "^[a-zA-Z]{2,99}$";
        firstNameValid = checker(firstName, firstNameLabel, namePattern);
        checkAll();
    }

    //Gets input from the Last Name text field, and checks if it's valid. Then checks if the button should be enabled.
    @FXML
    protected void checkLastName() {
        String lastName = lastNameField.getText();
        String namePattern = "^[a-zA-Z]{2,99}$";
        lastNameValid = checker(lastName,lastNameLabel,namePattern);
        checkAll();
    }

    //Gets input from the Email text field, and checks if it's valid. Then checks if the button should be enabled.
    @FXML
    protected void checkEmail() {
        String email = emailField.getText();
        String emailPattern = "^\\S+@farmingdale.edu$";
        emailValid = checker(email,emailLabel,emailPattern);
        checkAll();
    }

    //Gets input from the Date of Birth text field, and checks if it's valid. Then checks if the button should be enabled.
    @FXML
    protected void checkDob() {
        String dob = dobField.getText();
        String dobPattern = "^((0[1-9])|(1[0-2]))/((0[1-9])|([12][0-9])|(3[01]))/(\\d{4})$";
        dobValid = checker(dob,dobLabel,dobPattern);
        checkAll();
    }

    //Gets input from the ZIP code text field, and checks if it's valid. Then checks if the button should be enabled.
    @FXML
    protected void checkZip() {
        String zip = zipField.getText();
        String zipPattern = "^[0-9]{5}$";
        zipValid = checker(zip,zipLabel,zipPattern);
        checkAll();
    }

    //Enables the button only if all fields are valid.
    @FXML
    protected void checkAll() {
        if (firstNameValid && lastNameValid && emailValid && dobValid && zipValid ) {
            addButton.setDisable(false);
        } else {
            addButton.setDisable(true);
        }
    }

    //Switches to the view for when registration is finished.
    @FXML
    protected void switchToSecondary() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Secondary.fxml"));
        addButton.getScene().setRoot(fxmlLoader.load());
        System.out.println("prsd");
    }

    //Closes the application.
    @FXML
    protected void close() {
        System.exit(0);
    }
}