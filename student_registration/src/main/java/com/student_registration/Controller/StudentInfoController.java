package com.student_registration.Controller;


import com.student_registration.Payload.StudentInfoDto;

import com.student_registration.Service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/details/")
public class StudentInfoController {

    @Autowired
    private StudentInfoService stdInfoService;


    @PostMapping
    public ResponseEntity<String> createDetails(@RequestBody List<StudentInfoDto> stdInfoDto){
        List<StudentInfoDto> details = stdInfoService.createDetails(stdInfoDto);
        long count = details.stream().count();
        return new ResponseEntity<>(count+" "+"Records Inserted Successfully", HttpStatus.CREATED);
    }


    @GetMapping
    public List<StudentInfoDto> getAllDetails(){
         return stdInfoService.getAllDetails();
    }



    }


