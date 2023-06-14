package com.masai.Service;

import com.masai.Bean.Student;
import com.masai.Exception.StudentException;

import java.util.List;

public interface StudentService {

    public Student RegisterStudent(Student add) throws StudentException;

    public Student DeleteStudent(int id) throws StudentException;

    public Student UpdaterStudent(Student up) throws StudentException;

    public Student SearchStudentnByID(int id) throws StudentException;

    public List<Student>  ViewAllStudent() throws StudentException;



}
