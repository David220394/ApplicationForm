package com.applicationform.Controller;

import com.applicationform.Config.StageManager;
import com.applicationform.Service.ApplicationFormService;
import com.applicationform.entities.ApplicationForm;
import com.applicationform.entities.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class RegistrationController implements Initializable {

    @FXML
    private TextField post;

    @FXML
    private TextField fName;

    @FXML
    private TextField lName;

    @FXML
    private TextField address;
    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private TextField mobile;

    @FXML
    private Button next1;

    @FXML
    private ImageView image;

    @Lazy
    @Autowired
    private StageManager stageManager;

    public void next1(ActionEvent event) throws IOException {
        if(fName.getText() != null && !fName.getText().equalsIgnoreCase("") &&
            lName.getText() != null && !lName.getText().equalsIgnoreCase("") &&
            address.getText() != null && !address.getText().equalsIgnoreCase("") &&
            post.getText() != null && !post.getText().equalsIgnoreCase("") &&
            email.getText() !=null && !email.getText().equalsIgnoreCase("")) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("template/form2.fxml"));
            Parent rootNode = stageManager.getParentView(FxmlView.FORM2);
            Form2Controller form2Controller = stageManager.getSpringFXMLLoader().getLoader().getController();
            ApplicationForm a = from1To2();
            form2Controller.setApplicationForm(a);
            stageManager.show(rootNode, FxmlView.FORM2.getTitle());
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Empty Field");
            alert.setContentText("Fill in all the field before proceeding");

            alert.showAndWait();
        }
    }

    public void cancel(ActionEvent event){
        stageManager.switchScene(FxmlView.INDEX);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image.setImage(new Image(getClass().getClassLoader().getResource("static/image/front.jpg").toString()));
    }

    private ApplicationForm from1To2(){
        ApplicationForm form = new ApplicationForm();
        form.setPost(post.getText());
        form.setFirstName(fName.getText());
        form.setLastName(lName.getText());
        form.setAddress(address.getText());
        form.setEmailAddress(email.getText());
        form.setPhoneNumber(phone.getText());
        form.setMobilePhoneNumber(mobile.getText());
        return form;
    }






}
