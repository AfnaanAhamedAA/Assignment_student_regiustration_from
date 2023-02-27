package com.student_registration.Payload;

import lombok.Data;

@Data
public class StudentMarksDto {
    private long id;
    private String std_session;
    private String semester;
    private int total_subject;
    private int total_marks;


}
