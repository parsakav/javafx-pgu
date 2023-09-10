package com.parsakav.pgukala.controller;

import com.parsakav.pgukala.entity.StuffType;
import com.parsakav.pgukala.utils.UIUtils;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectStuffController {
    public void elecapp(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        try {
            UIUtils.showPage(new StuffListController(StuffType.ELECTRICALAPPLIANCES),"Buy", "stuffslist.fxml", st, 260, 650);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void homeapp(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        try {
            UIUtils.showPage(new StuffListController(StuffType.HOMEAPPLIANCES),"Buy", "stuffslist.fxml", st, 260, 650);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clothing(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        try {
            UIUtils.showPage(new StuffListController(StuffType.CLOTHING),"Buy", "stuffslist.fxml", st, 260, 650);
        } catch (IOException e) {
            e.printStackTrace();
        }    }

    public void mobile(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        try {
            UIUtils.showPage(new StuffListController(StuffType.MOBILE),"Buy", "stuffslist.fxml", st, 260, 650);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
