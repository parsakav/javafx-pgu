package com.parsakav.pgukala.controller;

import com.parsakav.pgukala.HelloApplication;
import com.parsakav.pgukala.entity.Stuff;
import com.parsakav.pgukala.entity.StuffType;
import com.parsakav.pgukala.repository.StuffRepository;
import com.parsakav.pgukala.repository.StuffRepositoryImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StuffListController implements Initializable {
    private final StuffType stuffType;
    @FXML
    private VBox stuffbox;
    private final StuffRepository stuffRepository = new StuffRepositoryImpl();

    public StuffListController(StuffType stuffType){
        this.stuffType=stuffType;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stuff.fxml"));
        try {
  //          VBox vBox = fxmlLoader.load();

            for(Stuff stuff : stuffRepository.getAllStuff()) {
                if(stuff.getStuffType()==stuffType) {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stuff.fxml"));
                    BuyController buyController = new BuyController();
                    buyController.setStuff(stuff);
                    fxmlLoader.setController(buyController);
                    VBox vBox = fxmlLoader.load();

                    //  VBox vBox=FXMLLoader.load(HelloApplication.class.getResource("stuff.fxml"));
                    stuffbox.getChildren().add(vBox); // add on top
                }
            }


        } catch (IOException e) {
e.printStackTrace();        }
    }
}
