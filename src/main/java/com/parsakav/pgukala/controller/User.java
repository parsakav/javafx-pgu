package com.parsakav.pgukala.controller;

import com.parsakav.pgukala.utils.UIUtils;
import javafx.stage.Stage;

import java.io.IOException;

public interface User {
    default void  logout(Stage st){
        com.parsakav.pgukala.entity.User.currentUser=null;
        try {
            UIUtils.showPage("Login", "login.fxml", st, 310, 400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
