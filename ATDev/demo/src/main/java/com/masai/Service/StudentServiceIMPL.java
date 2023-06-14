package com.masai.Service;

import com.masai.Bean.Student;
import com.masai.Exception.StudentException;
import com.masai.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceIMPL implements StudentService{

    @Autowired
    private StudentRepo ad;

    @Override
    public Student RegisterStudent(Student add) throws StudentException {

        Student str = ad.save(add);
        return add;
    }

    @Override
    public Student DeleteStudent(int id) throws StudentException {
        Optional<Student> str = ad.findById(id);

        if(str.isPresent()) {
            ad.deleteById(id);
        }

        else {
            throw new StudentException("Invalid ID for delete Student");
        }
        return str.get();
    }



    @Override
    public Student UpdaterStudent(Student up) throws StudentException {
        Optional<Student> upd = ad.findById(up.getStudentID());

        if(upd.isEmpty()) {
            throw new StudentException("Id not found ");
        }else {
            ad.save(up);
        }
        return upd.get();
    }

    @Override
    public Student SearchStudentnByID(int id) throws StudentException {
        Optional<Student> sid = ad.findById(id);

        if(sid.isEmpty()) {
            throw new StudentException("No Id Found");
        }else {
            return sid.get();
        }
    }

    @Override
    public List<Student> ViewAllStudent() throws StudentException {
        List<Student> adm = ad.findAll();
        if(adm==null) {
            throw new StudentException("No Student registered");
        }else {
            return adm;
        }
    }
}
