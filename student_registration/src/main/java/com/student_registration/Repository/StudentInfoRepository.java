package com.student_registration.Repository;

import com.student_registration.Entities.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentInfoRepository extends JpaRepository<StudentInfo,Long>{

}

