package com.applicationform.Service;

import com.applicationform.Repository.ApplicationFormRepository;
import com.applicationform.entities.ApplicationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationFormService {

    @Autowired
    private ApplicationFormRepository formRepository;

    public void insertApplication(ApplicationForm applicationForm){
        formRepository.save(applicationForm);
    }

}
