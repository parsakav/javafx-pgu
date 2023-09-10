package com.parsakav.pgukala.controller;

import com.parsakav.pgukala.entity.Stuff;
import com.parsakav.pgukala.entity.StuffType;
import com.parsakav.pgukala.repository.StuffRepository;
import com.parsakav.pgukala.repository.StuffRepositoryImpl;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AddStuffController implements Initializable {
    public MFXTextField price;
    @FXML
    private MFXTextField description;
    @FXML
    private MFXTextField name;
    @FXML
    private MFXComboBox stufftype;
    private final StuffRepository stuffRepository = new StuffRepositoryImpl();

    public void addBtnClick(ActionEvent actionEvent) {

        if (price.getText().isEmpty()||name.getText().isEmpty() || description.getText().isEmpty()) {
            return;
        }

        Control btn = (Control) actionEvent.getSource();
        Stage st = (Stage) btn.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Icon");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Jpeg Files", "*.jpeg")
                , new FileChooser.ExtensionFilter("Jpg Files", "*.jpg")
                , new FileChooser.ExtensionFilter("Png Files", "*.png")
                , new FileChooser.ExtensionFilter("Gif Files", "*.gif")
        );
        File file = fileChooser.showOpenDialog(st);
        if (file != null) {

            StuffType stu = null;
            for (StuffType s : StuffType.values()) {
                if (s.getName().equalsIgnoreCase((String) stufftype.getValue())) {
                    stu = s;
                }
            }
            Stuff stuff = new Stuff(name.getText(), description.getText(), file.getPath(), stu, Double.valueOf(price.getText()));
            stuffRepository.save(stuff);

            name.clear();
            price.clear();
            description.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for (StuffType s : StuffType.values()) {
            stufftype.getItems().add(s.getName());
        }
        stufftype.selectFirst();
    }
}
