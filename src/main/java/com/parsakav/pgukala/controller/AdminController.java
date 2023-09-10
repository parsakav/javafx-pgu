package com.parsakav.pgukala.controller;

import com.parsakav.pgukala.utils.UIUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController implements User {
    public void logout(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        logout(st);
    }


    public void addStuffPage(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        try {
            UIUtils.showPage("Add Stuff", "addstuff.fxml", st, 310, 500);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAndRemoveStuff(ActionEvent actionEvent) {

    }
}
