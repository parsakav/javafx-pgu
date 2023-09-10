package com.parsakav.pgukala.controller;

import com.parsakav.pgukala.entity.Cart;
import com.parsakav.pgukala.entity.Stuff;
import com.parsakav.pgukala.entity.User;
import com.parsakav.pgukala.service.CartService;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class BuyController implements Initializable {
    @FXML
    private MFXButton buy;
    @FXML

    private ImageView stuffIcon;
    @FXML
    private Label title;
@FXML
    private HBox st;
    private Stuff stuff;

    public void buyBtnClickAction(ActionEvent actionEvent) {
        Cart c= new Cart();
        c.setToken(new Date().getTime()+User.currentUser.getId());
        c.setU(User.currentUser);
        CartService.carts.put(c,stuff);
        CartService.update();
     /* for(Cart c:  CartService.carts.keySet()){
          if(c.getU().getId()== User.currentUser.getId()){

          }
      }*/
        System.out.println(stuff.toString());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.title.setText(stuff.getName());
        title.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(stuff.getStuffType().getName());
                alert.setHeaderText(stuff.getName());
                alert.setContentText(stuff.getDescription()+"\nprice:"+stuff.getPrice());

                alert.show();
            }
        });
        stuffIcon.setImage(new Image(stuff.getImagePath()));
        stuffIcon.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String path = stuff.getImagePath();
                String expr = "rundll32 \"C:\\Program Files (x86)\\Windows Photo Viewer\\PhotoViewer.dll\", ImageView_Fullscreen " + path;
                try {
                    Runtime.getRuntime().exec(expr);
                } catch (IOException e) {
e.printStackTrace();
                }
            }
        });



    }

    public void setStuff(Stuff stuff) {
        this.stuff=stuff;
    }

}
