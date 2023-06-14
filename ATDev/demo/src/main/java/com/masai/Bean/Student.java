package com.masai.Bean;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentID;

    @NotNull
   @Column(unique = true)
    private int studentRollNo;

    @NotNull
    private String studentName;

    @NotNull
    private String studentAddress;


}
