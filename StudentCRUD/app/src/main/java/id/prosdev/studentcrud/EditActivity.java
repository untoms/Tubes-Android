package id.prosdev.studentcrud;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import id.prosdev.studentcrud.database.StudentDB;
import id.prosdev.studentcrud.form.BuatForm;
import id.prosdev.studentcrud.model.Gender;
import id.prosdev.studentcrud.model.Student;

/**
 * Created by Administrator on 12/27/2014.
 */
public class EditActivity extends Activity implements View.OnClickListener {

    private BuatForm form;
    private StudentDB db;
    private Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buat);

        form = new BuatForm(this);
        form.getSimpan().setOnClickListener(this);

        db = new StudentDB(this);

        Bundle bun = this.getIntent().getExtras();
        id=bun.getLong("id");
        form.getNim().setText(bun.getString("nim"));
        form.getNama().setText(bun.getString("name"));
        if (bun.getString("gender").equals(String.valueOf(Gender.FEMALE))) {
            form.getFemale().setChecked(true);
        } else if (bun.getString("gender").equals(String.valueOf(Gender.MALE))) {
            form.getMale().setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {

        if (form.getNim().getText().equals("") ){

        }

        Student student=new Student();
        student.setId(id);
        student.setNim(form.getNim().getText().toString());
        student.setName(form.getNama().getText().toString());
        if (form.getFemale().isChecked()){
            student.setGender(Gender.FEMALE);
        }else if(form.getMale().isChecked()){
            student.setGender(Gender.MALE);
        }
        db.updateStudent(student);
        form.reset();
    }
}

