package com.applicationform.Controller;

import com.applicationform.Config.StageManager;
import com.applicationform.Service.ApplicationFormService;
import com.applicationform.entities.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class Form3Controller implements Initializable {

    @Autowired
    private ApplicationFormService formService;

    @FXML
    private TextField tia1;

    @FXML
    private TextField course1;

    @FXML
    private DatePicker tFrom1;

    @FXML
    private DatePicker tTo1;

    @FXML
    private TextField tres1;

    @FXML
    private TextField tia2;

    @FXML
    private TextField course2;

    @FXML
    private DatePicker tFrom2;

    @FXML
    private DatePicker tTo2;

    @FXML
    private TextField tres2;

    @FXML
    private TextField company1;

    @FXML
    private DatePicker cFrom1;

    @FXML
    private DatePicker cTo1;

    @FXML
    private TextArea jD1;

    @FXML
    private TextField company2;

    @FXML
    private DatePicker cFrom2;

    @FXML
    private DatePicker cTo2;

    @FXML
    private TextArea jD2;

    @FXML
    private CheckBox accept;

    @FXML
    private Button submit;

    @Lazy
    @Autowired
    private StageManager stageManager;

    private ApplicationForm applicationForm;
    private List<Subject> subjects;
    private Education education;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void submit(ActionEvent event) throws IOException {
            if(accept.isSelected()) {
                formService.insert(applicationForm, education, subjects, setTEducation(), setJobs());
                stageManager.switchScene(FxmlView.INDEX);
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Accept Terms");
                alert.setContentText("Please accept the terms before proceeding");

                alert.showAndWait();
            }
    }

    public void cancel(ActionEvent event){
        stageManager.switchScene(FxmlView.INDEX);
    }

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    private List<TEducation> setTEducation(){
        List<TEducation> tEducations = new ArrayList<>();
        tEducations.add(new TEducation(tia1.getText(),course1.getText(),tFrom1.getValue().getYear(),tTo1.getValue().getYear(),tres1.getText()));
        tEducations.add(new TEducation(tia2.getText(),course2.getText(),tFrom2.getValue().getYear(),tTo2.getValue().getYear(),tres2.getText()));
        return tEducations;
    }

    private List<Job> setJobs(){
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(company1.getText(),cFrom1.getValue(),cTo1.getValue(),jD1.getText()));
        jobs.add(new Job(company2.getText(),cFrom2.getValue(),cTo2.getValue(),jD2.getText()));
        return jobs;
    }
}
