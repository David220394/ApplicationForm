package com.applicationform.Service;

import com.applicationform.Repository.*;
import com.applicationform.entities.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


@Service
@Transactional
public class ApplicationFormService {

    @Autowired
    private ApplicationFormRepository formRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TEducationRepository tEducationRepository;

    public void insert(ApplicationForm applicationForm, Education education, List<Subject> subjects, List<TEducation> tEducations, List<Job> jobs){
        ApplicationForm form = formRepository.save(applicationForm);
        education.setApplicationForm(form);
        Education e = educationRepository.save(education);
        for(Subject s : subjects){
            if(s.getSubject() != null){
                s.setEducation(e);
                subjectRepository.save(s);
            }
        }
        for(TEducation te : tEducations){
            if(te.getCourse() != null) {
                te.setApplicationForm(form);
                tEducationRepository.save(te);
            }
        }
        for (Job j : jobs){
            if(j.getCompanyName() != null) {
                j.setApplicationForm(form);
                jobRepository.save(j);
            }
        }
    }

    public ApplicationForm insertApplication(ApplicationForm applicationForm){

        ApplicationForm form = formRepository.save(applicationForm);
        return form;
    }

    public void generateExcelReport(){

        List<ApplicationForm> forms = formRepository.findAll();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Applicant");

        int rowNum = 0;
        int c = 0;
        Row r = sheet.createRow(rowNum++);
        r.createCell(c++).setCellValue((String) "Post");
        r.createCell(c++).setCellValue((String) "First Name");
        r.createCell(c++).setCellValue((String) "Last Name");
        r.createCell(c++).setCellValue((String) "Address");
        r.createCell(c++).setCellValue((String) "Email");
        r.createCell(c++).setCellValue((String) "Phone");
        r.createCell(c++).setCellValue((String) "Mobile");
        r.createCell(c++).setCellValue((String) "Secondary School");
        r.createCell(c++).setCellValue((String) "From Year");
        r.createCell(c++).setCellValue((String) "To Year");
        r.createCell(c++).setCellValue((String) "Level");
        r.createCell(c++).setCellValue((String) "Subject 1");
        r.createCell(c++).setCellValue((String) "Result 1");
        r.createCell(c++).setCellValue((String) "Subject 2");
        r.createCell(c++).setCellValue((String) "Result 2");
        r.createCell(c++).setCellValue((String) "Subject 3");
        r.createCell(c++).setCellValue((String) "Result 3");
        r.createCell(c++).setCellValue((String) "Subject 4");
        r.createCell(c++).setCellValue((String) "Result 4");
        r.createCell(c++).setCellValue((String) "Subject 5");
        r.createCell(c++).setCellValue((String) "Result 5");
        r.createCell(c++).setCellValue((String) "Subject 6");
        r.createCell(c++).setCellValue((String) "Result 6");
        r.createCell(c++).setCellValue((String) "Subject 7");
        r.createCell(c++).setCellValue((String) "Result 7");
        r.createCell(c++).setCellValue((String) "Subject 8");
        r.createCell(c++).setCellValue((String) "Result 8");
        r.createCell(c++).setCellValue((String) "Tertiary Institutions Attended 1");
        r.createCell(c++).setCellValue((String) "Course 1");
        r.createCell(c++).setCellValue((String) "From Year");
        r.createCell(c++).setCellValue((String) "To Year");
        r.createCell(c++).setCellValue((String) "Result 1");
        r.createCell(c++).setCellValue((String) "Tertiary Institutions Attended 2");
        r.createCell(c++).setCellValue((String) "Course 2");
        r.createCell(c++).setCellValue((String) "From Year");
        r.createCell(c++).setCellValue((String) "To Year");
        r.createCell(c++).setCellValue((String) "Result 2");
        r.createCell(c++).setCellValue((String) "Company Name 1");
        r.createCell(c++).setCellValue((String) "Job Description");
        r.createCell(c++).setCellValue((String) "From Year");
        r.createCell(c++).setCellValue((String) "To Year");
        r.createCell(c++).setCellValue((String) "Company Name 2");
        r.createCell(c++).setCellValue((String) "Job Description");
        r.createCell(c++).setCellValue((String) "From Year");
        r.createCell(c++).setCellValue((String) "To Year");

        for (ApplicationForm form : forms){
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            row.createCell(colNum++).setCellValue((String) form.getPost());
            row.createCell(colNum++).setCellValue((String) form.getFirstName());
            row.createCell(colNum++).setCellValue((String) form.getLastName());
            row.createCell(colNum++).setCellValue((String) form.getAddress());
            row.createCell(colNum++).setCellValue((String) form.getEmailAddress());
            row.createCell(colNum++).setCellValue((String) form.getPhoneNumber());
            row.createCell(colNum++).setCellValue((String) form.getMobilePhoneNumber());
            if(form.getEducations() != null && form.getEducations().size() > 0) {
                row.createCell(colNum++).setCellValue((String) form.getEducations().get(0).getSecondarySchools());
                row.createCell(colNum++).setCellValue((Integer) form.getEducations().get(0).getFromYear());
                row.createCell(colNum++).setCellValue((Integer) form.getEducations().get(0).getToYear());
                row.createCell(colNum++).setCellValue((String) form.getEducations().get(0).getHighestLevelAttained());
                List<Subject> subjects = form.getEducations().get(0).getSubjects();
                while (subjects.size() != 8){ subjects.add(new Subject());}
                for(int i  = 0; i < 8; i++){
                    if(subjects.get(i).getSubject() != null && subjects.get(i).getResult() != null){
                        row.createCell(colNum++).setCellValue((String) subjects.get(i).getSubject());
                        row.createCell(colNum++).setCellValue((String) subjects.get(i).getResult());
                    }else{
                        colNum++;
                        colNum++;
                    }
                }
            }
            if(form.gettEducations() !=null){
                List<TEducation> tEducations = form.gettEducations();
                while(tEducations.size() != 2){
                    tEducations.add(new TEducation());
                }
                for(TEducation tEducation : tEducations){
                    if(tEducation.getCourse() != null){
                        row.createCell(colNum++).setCellValue((String) tEducation.gettName());
                        row.createCell(colNum++).setCellValue((String) tEducation.getCourse());
                        row.createCell(colNum++).setCellValue((Integer) tEducation.gettFrom());
                        row.createCell(colNum++).setCellValue((Integer) tEducation.gettTo());
                        row.createCell(colNum++).setCellValue((String) tEducation.getResult());
                    }else{
                        colNum +=5;
                    }
                }
            }
            if(form.getJobs() != null){
                List<Job> jobs = form.getJobs();
                while (jobs.size() != 2){
                    jobs.add(new Job());
                }
                for(Job job : jobs){
                    if(job.getCompanyName() != null){
                        row.createCell(colNum++).setCellValue((String) job.getCompanyName());
                        row.createCell(colNum++).setCellValue((String) job.getJobDesc());
                        row.createCell(colNum++).setCellValue((String) job.getjFrom().toString());
                        row.createCell(colNum++).setCellValue((String) job.getjTo().toString());
                    }else{
                        colNum +=4;
                    }
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream("test.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
