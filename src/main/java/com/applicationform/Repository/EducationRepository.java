package com.applicationform.Repository;

import com.applicationform.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository <Education,Long> {
}
