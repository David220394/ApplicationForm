package com.applicationform.Controller;

import com.applicationform.Application;
import com.applicationform.Config.StageManager;
import com.applicationform.entities.ApplicationForm;
import com.applicationform.entities.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class IndexController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private Button toRegister;


    public void toRegister(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.REGISTRATION);
    }

    public void login(ActionEvent event) throws IOException {

        stageManager.switchScene(FxmlView.LOGIN);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
