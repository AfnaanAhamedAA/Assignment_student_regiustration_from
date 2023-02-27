package com.student_registration.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_marks")
public class StudentMarks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String std_session;
    private String semester;
    private int total_subject;
    private int total_marks;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="std_id",nullable = false)
    private StudentInfo studentInfo;


}
