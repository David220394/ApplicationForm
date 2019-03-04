package com.applicationform.Controller;

import com.applicationform.Service.ApplicationFormService;
import com.applicationform.entities.ApplicationForm;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ApplicationFormController {

    @Autowired
    private ApplicationFormService formService;

    @GetMapping("/")
    public String getHome(){
        formService.generateExcelReport();
        return "index";
    }

    @PostMapping("/")
    public String insertForm(ApplicationForm applicationForm){
        formService.insertApplication(applicationForm);
        return "index";
    }

    @GetMapping("/download")
    public void getFile(HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition",
                "attachment; filename= test.xlsx");
        try {
            formService.generateExcelReport();
            // get your file as InputStream
            InputStream is = new FileInputStream("test.xlsx");
            // copy it to response's OutputStream
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            throw new RuntimeException("IOError writing file to output stream");
        }

    }

}
