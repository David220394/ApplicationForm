package com.applicationform.Controller;

import com.applicationform.Config.StageManager;
import com.applicationform.entities.ApplicationForm;
import com.applicationform.entities.Education;
import com.applicationform.entities.FxmlView;
import com.applicationform.entities.Subject;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class Form2Controller implements Initializable {

    @FXML
    private TextField sSchool;

    @FXML
    private DatePicker ssFrom;

    @FXML
    private DatePicker ssTo;

    @FXML
    private TextField level;

    @FXML
    private TextField sub1;

    @FXML
    private ChoiceBox res1;

    @FXML
    private TextField sub2;

    @FXML
    private ChoiceBox res2;

    @FXML
    private TextField sub3;

    @FXML
    private ChoiceBox res3;

    @FXML
    private TextField sub4;

    @FXML
    private ChoiceBox res4;

    @FXML
    private TextField sub5;

    @FXML
    private ChoiceBox res5;

    @FXML
    private TextField sub6;

    @FXML
    private ChoiceBox res6;

    @FXML
    private TextField sub7;

    @FXML
    private ChoiceBox res7;

    @FXML
    private TextField sub8;

    @FXML
    private ChoiceBox res8;

    private ApplicationForm applicationForm;

    @FXML
    private Button next2;

    @FXML
    private ImageView image;

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        image.setImage(new Image(getClass().getClassLoader().getResource("static/image/education.jpg").toString()));
        setComboBox();
    }

    public void next2(ActionEvent event) throws IOException {
        if(sSchool.getText() !=null && !sSchool.getText().equalsIgnoreCase("") &&
            level.getText() !=null && !level.getText().equalsIgnoreCase("") &&
            ssFrom.getValue() != null &&
            ssTo.getValue() != null) {
            Parent rootNode = stageManager.getParentView(FxmlView.FORM3);
            Form3Controller form3Controller = stageManager.getSpringFXMLLoader().getLoader().getController();
            ApplicationForm a = applicationForm;
            Education e = from2To3();
            List<Subject> subjects = setSubjects();
            System.out.println(ssFrom.getValue());
            form3Controller.setApplicationForm(a);
            form3Controller.setEducation(e);
            form3Controller.setSubjects(subjects);
            stageManager.show(rootNode, FxmlView.FORM3.getTitle());
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

    public void setApplicationForm(ApplicationForm applicationForm){
        this.applicationForm = applicationForm;
    }

    private Education from2To3(){
        Education education = new Education();
        education.setApplicationForm(applicationForm);
        education.setSecondarySchools(sSchool.getText());
        education.setHighestLevelAttained(level.getText());
        education.setFromYear(ssFrom.getValue().getYear());
        education.setToYear(ssTo.getValue().getYear());
        return education;
    }

    private List<Subject> setSubjects(){
        List<Subject> subjects = new ArrayList<>();
        if(res1.getValue() != null){ subjects.add(new Subject(sub1.getText(),res1.getValue().toString()));}
        if(res2.getValue() != null){ subjects.add(new Subject(sub2.getText(),res2.getValue().toString()));}
        if(res3.getValue() != null){ subjects.add(new Subject(sub3.getText(),res3.getValue().toString()));}
        if(res4.getValue() != null){ subjects.add(new Subject(sub4.getText(),res4.getValue().toString()));}
        if(res5.getValue() != null){ subjects.add(new Subject(sub5.getText(),res5.getValue().toString()));}
        if(res6.getValue() != null){ subjects.add(new Subject(sub6.getText(),res6.getValue().toString()));}
        if(res7.getValue() != null){ subjects.add(new Subject(sub7.getText(),res7.getValue().toString()));}
        if(res8.getValue() != null){ subjects.add(new Subject(sub8.getText(),res8.getValue().toString()));}
        return subjects;
    }

    private void setComboBox(){
        String[] results = {"A*","A","B","C","D","E","F"};
        res1.getItems().addAll(results);
        res2.getItems().addAll(results);
        res3.getItems().addAll(results);
        res4.getItems().addAll(results);
        res5.getItems().addAll(results);
        res6.getItems().addAll(results);
        res7.getItems().addAll(results);
        res8.getItems().addAll(results);

    }

}
