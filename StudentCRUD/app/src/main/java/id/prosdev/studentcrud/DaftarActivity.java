package id.prosdev.studentcrud;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import id.prosdev.studentcrud.database.StudentDB;
import id.prosdev.studentcrud.form.DaftarForm;
import id.prosdev.studentcrud.model.Student;

import static android.widget.Toast.LENGTH_SHORT;

/**
 * Created by Administrator on 12/24/2014.
 */
public class DaftarActivity extends ListActivity{

    private DaftarForm daftarForm;
    private StudentDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);

        daftarForm=new DaftarForm(this);
        db=new StudentDB(this);

        loadstudent();

    }

    private void loadstudent(){
        List<Student> list=db.getAllStudent();

        if (!list.isEmpty()){
            ArrayAdapter<Student> adapter=new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1,list);

            daftarForm.getListView().setAdapter(adapter);
        }


    }

    @Override
    protected void onListItemClick(final ListView l, View v, final int position, long id) {
        super.onListItemClick(l, v, position, id);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose action!");
        // Add the buttons
        builder.setPositiveButton(R.string.update, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                Student student = (Student) l.getAdapter().getItem(position);
                edit(student);
            }
        });
        builder.setNegativeButton(R.string.delete, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Student student = (Student) l.getAdapter().getItem(position);
                delete(student);
            }
        });
        // Set other dialog properties


        // Create the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void edit(Student student){
        Intent i = new Intent(this, EditActivity.class);
        Bundle bun = new Bundle();
        bun.putLong("id", student.getId());
        bun.putString("name", student.getName());
        bun.putString("nim", student.getNim());
        bun.putString("gender", String.valueOf(student.getGender()));
        i.putExtras(bun);
        finale();
        startActivity(i);
    }

    private void delete(Student student){
        db.deleteStudent(student.getId());
        Toast.makeText(this,"Student with id "+student.getNim()+" has been deleted!", LENGTH_SHORT).show();
        loadstudent();
    }


    //method yang dipanggil ketika edit data selesai
    public void finale()
    {
        this.finish();
        db.close();
    }
    @Override
    protected void onResume() {
        db.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        db.close();
        super.onPause();
    }
}
