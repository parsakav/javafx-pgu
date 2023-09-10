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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public MFXButton login;
    @FXML
    private MFXTextField username;
    @FXML
    private MFXPasswordField pass;
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void loginBtnClickAction(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        if (username.getText().equals("admin") && pass.getText().equals("admin")) {
            User u = new User();
            u.setUsername(username.getText());
            u.setPassword(username.getText());
            u.setId(-1);
            User.currentUser = u;
            try {
                UIUtils.showPage("Admin Panel", "admin.fxml", st, 310, 400);
            } catch (IOException e) {

                e.printStackTrace();
            }
        } else if(!username.getText().isEmpty() && !pass.getText().isEmpty()){
            User u=userRepository.find(username.getText());
            if(u!=null && username.getText().equals(u.getUsername())
             && pass.getText().equals(u.getPassword())){
                User.currentUser=u;
                try {
                    UIUtils.showPage("User Panel", "user.fxml", st, 310, 400);
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        }

    }

    public void signupPageClickAction(ActionEvent actionEvent) {
        Hyperlink btn = (Hyperlink) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        try {
            UIUtils.showPage("signup", "signup.fxml", st, 310, 448);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
