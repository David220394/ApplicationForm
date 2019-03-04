package com.applicationform.Controller;

import com.applicationform.Config.StageManager;
import com.applicationform.Service.ApplicationFormService;
import com.applicationform.entities.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class LoginController implements Initializable {

    @Autowired
    private ApplicationFormService formService;

    @FXML
    private TextField txt_username;

    @FXML
    private TextField txt_password;

    @FXML
    private Button excelgen;

    @Lazy
    @Autowired
    private StageManager stageManager;

    public void login(ActionEvent event){
        if(txt_username.getText().equalsIgnoreCase("admin")){
            System.out.println("Success");
            excelgen.setVisible(true);
        }else{

        }
    }

    public void cancel(ActionEvent event){
        stageManager.switchScene(FxmlView.INDEX);
    }

    public void excel(ActionEvent event){
        formService.generateExcelReport();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
