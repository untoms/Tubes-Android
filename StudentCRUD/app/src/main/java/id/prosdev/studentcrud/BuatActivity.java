package id.prosdev.studentcrud;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import id.prosdev.studentcrud.database.StudentDB;
import id.prosdev.studentcrud.form.BuatForm;
import id.prosdev.studentcrud.model.Gender;
import id.prosdev.studentcrud.model.Student;

/**
 * Created by Administrator on 12/24/2014.
 */
public class BuatActivity extends Activity implements View.OnClickListener {

    private BuatForm form;
    private StudentDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buat);

        form =new BuatForm(this);
        form.getSimpan().setOnClickListener(this);

        db=new StudentDB(this);
    }

    @Override
    public void onClick(View v) {

        if (form.getNim().getText().equals("") ){

        }

        Student student=new Student();
        student.setNim(form.getNim().getText().toString());
        student.setName(form.getNama().getText().toString());
        if (form.getFemale().isChecked()){
            student.setGender(Gender.FEMALE);
        }else if(form.getMale().isChecked()){
            student.setGender(Gender.MALE);
        }
        db.createStudent(student);
        form.reset();
    }
}
