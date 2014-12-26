package id.prosdev.studentcrud.database;

import java.util.ArrayList;
import java.util.List;

import id.prosdev.studentcrud.model.Student;

/**
 * Created by Administrator on 12/19/2014.
 */
public class StudentDB {

    public static StudentDB STUDENT_DB=new StudentDB();

    public static StudentDB getInstance() {
        return StudentDB.STUDENT_DB;
    }

    public StudentDB(){

    }

    List<Student> list=new ArrayList<>();

    public void add(Student student){
        list.add(student);
    }

    public List<Student> findAll(){
        return list;
    }
}
