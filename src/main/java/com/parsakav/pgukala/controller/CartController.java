package com.parsakav.pgukala.controller;

import com.parsakav.pgukala.entity.Cart;
import com.parsakav.pgukala.service.CartService;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private ListView listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
     initList();

        listView.getSelectionModel().selectedItemProperty().addListener((ChangeListener<Long>) (observable, oldValue, newValue) ->
        {
            try {

                Cart c1=null;
            for(Cart c: CartService.carts.keySet()){
                if(c.getToken()==newValue) {
                    c1 = c;
                }


            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setHeaderText(CartService.carts.get(c1).getName());
            alert.setContentText(CartService.carts.get(c1).getDescription()+"\nprice"
                    +CartService.carts.get(c1).getPrice());
            alert.setTitle(CartService.carts.get(c1).getStuffType().getName());
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.CANCEL) {
                    CartService.carts.remove(c1);
                    CartService.update();
                Platform.runLater(() -> {

                listView.getItems().clear();
                initList();
        });
            }
            } catch (Throwable t){

            }
        });

    }
   private void initList(){
        for(Cart c: CartService.carts.keySet()){
            if(c.getU().getId()==com.parsakav.pgukala.entity.User.currentUser.getId())
                listView.getItems().add(c.getToken());


        }
    }
}
