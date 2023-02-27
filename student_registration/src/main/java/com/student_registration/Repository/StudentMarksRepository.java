package com.student_registration.Repository;

import com.student_registration.Entities.StudentMarks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentMarksRepository extends JpaRepository<StudentMarks,Long> {

 List<StudentMarks> findByStudentInfoId(long std_id);


}
