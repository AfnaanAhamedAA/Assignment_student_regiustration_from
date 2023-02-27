package com.student_registration.Payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfoDto {
    private long id;
    private String std_name;
    private String std_address;
    private String std_email;
    private String std_phoneno;
    private String std_section;
    private String std_grade;


}
