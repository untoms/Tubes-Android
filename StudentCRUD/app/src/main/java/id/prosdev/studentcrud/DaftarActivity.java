package id.prosdev.studentcrud;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import id.prosdev.studentcrud.database.StudentDB;
import id.prosdev.studentcrud.form.DaftarForm;
import id.prosdev.studentcrud.model.Student;

/**
 * Created by Administrator on 12/24/2014.
 */
public class DaftarActivity extends Activity {

    private DaftarForm daftarForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);

        daftarForm=new DaftarForm(this);

        loadstudent();

    }

    private void loadstudent(){

        StudentDB db=StudentDB.getInstance();
        List<Student> list=db.findAll();

        ArrayAdapter<Student> adapter=new ArrayAdapter<Student>(this,
                android.R.layout.simple_list_item_1,list);

        daftarForm.getListView().setAdapter(adapter);
    }
}
