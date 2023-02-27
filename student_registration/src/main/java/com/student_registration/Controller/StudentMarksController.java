package com.student_registration.Controller;

import com.student_registration.Payload.StudentInfoDto;
import com.student_registration.Payload.StudentMarksDto;
import com.student_registration.Service.StudentInfoService;
import com.student_registration.Service.StudentMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student/marks/details")
public class StudentMarksController {

    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private StudentMarksService stdMarksService;

    @PostMapping("/{std_id}")
    public ResponseEntity<String> createMarksDetail(@PathVariable(value = "std_id") long std_id, @RequestBody StudentMarksDto stdMarksDto){
        StudentMarksDto marksDetails = stdMarksService.createMarksDetails(std_id, stdMarksDto);
        return new ResponseEntity<>("Record Inserted syccessfully", HttpStatus.CREATED);
    }

    @GetMapping("/{std_id}")
    public ResponseEntity<Map<String, Object>> getStudentInfoandMarks(@PathVariable(value = "std_id") long stdId) {
        StudentInfoDto studentInfoById = studentInfoService.getStudentInfoById(stdId);
        List<StudentMarksDto> marksDetails = stdMarksService.getMarksDetails(stdId);
        Map<String, Object> response = new HashMap<>();
        response.put("Student_Info", studentInfoById);
        response.put("Student_Marks",marksDetails );
        return ResponseEntity.ok(response);
    }

}


