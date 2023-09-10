package com.parsakav.pgukala.utils;

import com.parsakav.pgukala.HelloApplication;
import com.parsakav.pgukala.entity.User;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UIUtils {

    public static void showPage(String title, String pageName, Stage stage, double width, double height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(pageName));
        Scene scene = new Scene(fxmlLoader.load(), width, height);
      addCloseRequestToStage(stage,width,height);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }   public static void showPage(Object controller,String title, String pageName, Stage stage, double width, double height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(pageName));
    fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), width, height);

      addCloseRequestToStage(stage,width,height);

        stage.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    private static void addCloseRequestToStage(Stage stage,double width,double height){

        stage.setOnCloseRequest(windowEvent ->

        {
            Platform.runLater(() -> {
                Stage stage1 = (Stage) windowEvent.getSource();
                try {

                    if (!stage1.getTitle().equalsIgnoreCase("login")) {
                        {
                           if (stage1.getTitle().equals("User Panel")) {
                                Platform.exit();
                            } else if (stage1.getTitle().equals("Admin Panel")) {
                                Platform.exit();
                            }
                        }
                        {
                            if (User.currentUser != null && User.currentUser.getId() == -1) {


                                showPage("Admin Panel", "admin.fxml", stage, width, height);

                            } else if (User.currentUser != null) {
                                showPage("User Panel", "user.fxml", stage, 310, 400);

                            } else {
                                showPage("Login", "login.fxml", stage, width, height);

                            }
                        }
                    } else {
                        Platform.exit();
                    }


                } catch (IOException e) {

                    e.printStackTrace();
                }
            });


        });

    }

}
