package com.parsakav.pgukala.controller;

import com.parsakav.pgukala.utils.UIUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;

import java.io.IOException;

public class UserController implements User{
    public void logout(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
  logout(st);

    }


    public void buy(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        try {
            UIUtils.showPage("Menue", "selectstufftype.fxml", st, 310, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void cart(ActionEvent actionEvent) {
        Control btn = (Control) actionEvent.getSource();
        Stage st= (Stage) btn.getScene().getWindow();
        try {
            UIUtils.showPage("Cart","cart.fxml",st,312,400);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
