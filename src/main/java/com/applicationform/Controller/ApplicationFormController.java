package com.applicationform.Controller;

import com.applicationform.Service.ApplicationFormService;
import com.applicationform.entities.ApplicationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicationFormController {

    @Autowired
    private ApplicationFormService formService;

    @GetMapping("/")
    public String getHome(){
        return "index";
    }

    @PostMapping("/")
    public String insertForm(ApplicationForm applicationForm){
        formService.insertApplication(applicationForm);
        return "index";
    }

}
