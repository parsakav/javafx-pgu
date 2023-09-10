package com.parsakav.pgukala.controller;

import com.parsakav.pgukala.entity.User;
import com.parsakav.pgukala.repository.UserRepository;
import com.parsakav.pgukala.repository.UserRepositoryImpl;
import com.parsakav.pgukala.utils.UIUtils;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Control;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {
    @FXML
    private MFXPasswordField pass;
    @FXML
    private MFXPasswordField reenterpass;
    @FXML
    private MFXTextField phoneNumber;
    @FXML
    private MFXTextField username;

    @FXML
    private MFXButton signupBtn;

    private UserRepository userRepository = new UserRepositoryImpl();

    public void signupBtnClickAction(ActionEvent actionEvent) {
        if(!pass.getText().equals(reenterpass.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Passwords are not the same");
            alert.show();
            return;
        }else{
            User u = new User(username.getText(),pass.getText(),phoneNumber.getText());
           userRepository.save(u);
            loginPageClickAction(actionEvent);
        }
    }

    public void loginPageClickAction(ActionEvent actionEvent) {
        Control btn = (Control) actionEvent.getSource();
        Stage st= (Stage) btn.getScene().getWindow();
        try {
            UIUtils.showPage("login","login.fxml",st,310,400);
        } catch (IOException e) {
e.printStackTrace();

        }
    }
}
