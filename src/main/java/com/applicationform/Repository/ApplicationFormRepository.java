package com.applicationform.Repository;

import com.applicationform.entities.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationFormRepository extends JpaRepository<ApplicationForm,Long> {
}
