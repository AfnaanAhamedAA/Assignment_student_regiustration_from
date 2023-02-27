package com.student_registration.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="student_info")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String std_name;
    private String std_address;
    private String std_email;
    private String std_phoneno;
    private String std_section;
    private String std_grade;

    @OneToMany(mappedBy = "studentInfo",cascade = CascadeType.ALL)
    private Set<StudentMarks> studentMarks = new HashSet<>();


}
