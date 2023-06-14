package com.masai.Controller;

import com.masai.Bean.Student;
import com.masai.Exception.StudentException;
import com.masai.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService ad;

    @PostMapping("/registerstudent")
    public ResponseEntity<Student> ResgisterStudent(@RequestBody Student adms)throws StudentException {

        Student add = ad.RegisterStudent(adms);

        return new ResponseEntity<Student>(add, HttpStatus.ACCEPTED);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent ( @PathVariable("id") int adms)throws StudentException{

        Student del = ad.DeleteStudent(adms);

        return new ResponseEntity<Student>(del, HttpStatus.ACCEPTED);
    }

    @GetMapping("/viewallStudent")
    public ResponseEntity<List<Student>>   viewAllStudent() throws StudentException{

        List<Student> vie = ad.ViewAllStudent();

        return new ResponseEntity<List<Student>>(vie, HttpStatus.ACCEPTED);
    }


    @GetMapping("/viwadbyid/{id}")
    public ResponseEntity<Student> viewbyid (@PathVariable("id") int adms)throws StudentException{

        Student byid = ad.SearchStudentnByID(adms);
        return new ResponseEntity<Student>(byid, HttpStatus.ACCEPTED);

    }

    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student adms)throws StudentException{
        Student up = ad.UpdaterStudent(adms);
        return new ResponseEntity<Student>(up, HttpStatus.ACCEPTED);

    }

}
