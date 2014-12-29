package id.prosdev.studentcrud;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import id.prosdev.studentcrud.database.StudentDB;
import id.prosdev.studentcrud.form.RandomersForm;
import id.prosdev.studentcrud.model.Gender;
import id.prosdev.studentcrud.model.Student;

/**
 * Created by Administrator on 12/27/2014.
 */
public class RandomersActivity extends Activity implements View.OnClickListener{

    private RandomersForm randomersForm;
    private StudentDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random);

        db=new StudentDB(this);

        randomersForm=new RandomersForm(this);
        randomersForm.getRandom().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Integer groups=Integer.valueOf(randomersForm.getNumbers().getText().toString());
        if(groups > 0){
            List<Student> list=generate();
            ArrayAdapter<Student> adapter=new ArrayAdapter<Student>(this,
                    android.R.layout.simple_list_item_1, list){
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    if(position%2 == 0){
//                        text.setBackgroundColor(Color.argb(25,255,255,255));
                        text.setBackgroundColor(Color.LTGRAY);
                    }else{
//                        text.setBackgroundColor(Color.argb(25,255,255,255));
                        text.setBackgroundColor(Color.DKGRAY);
                    }
                    return view;
                }
            };
            randomersForm.getListView().setAdapter(adapter);
        }

    }

    private List<Student> generate (){

        List<Student> list=db.getAllStudent();
        Integer semua=list.size();
        Integer groups=Integer.valueOf(randomersForm.getNumbers().getText().toString());

        List<Student> girls=new ArrayList<>();
        List<Student> boys=new ArrayList<>();
        List<Student> finalstudent=new ArrayList<>();

        for (Student student:list){
            if (student.getGender().equals(Gender.FEMALE)){
                girls.add(student);
            }else {
                boys.add(student);
            }
        }

        Double groupMembers = Math.ceil(semua.doubleValue()/groups.doubleValue()) +1;
        int x = 0,y=0;
        for (int i = 1; i < groupMembers; i++) {
            String klompok="Kelompok "+i;
            for (int j = 1; j <= groups; j++) {
                if (j%2 == 0) {
                    int random=0;
                    if (y<boys.size()) {
                        do {
                            random=(int) (Math.random()*boys.size());
                        } while (boys.get(random).getChoosen());
                        y=y+1;
                        Student hasil=boys.get(random);
                        hasil.setGroup(klompok);
                        hasil.setChoosen(Boolean.TRUE);
                        boys.get(random).setChoosen(Boolean.TRUE);

                        finalstudent.add(hasil);
                        if ((boys.size()+girls.size())==finalstudent.size()) {
                            break;
                        }
                    } else {

                        if (x < girls.size()) {
                            do {
                                random=(int) (Math.random()*girls.size());
                            } while (girls.get(random).getChoosen());
                            Student hasil=girls.get(random);
                            x=x+1;
                            hasil.setGroup(klompok);
                            hasil.setChoosen(Boolean.TRUE);
                            girls.get(random).setChoosen(Boolean.TRUE);

                            finalstudent.add(hasil);
                            if ((boys.size()+girls.size())==finalstudent.size()) {
                                break;
                            }
                        }

                    }

                } else {
                    int random=0;
                    if (x < girls.size()) {
                        do {
                            random=(int) (Math.random()*girls.size());
                        } while (girls.get(random).getChoosen());
                        Student hasil=girls.get(random);
                        x=x+1;
                        hasil.setGroup(klompok);
                        hasil.setChoosen(Boolean.TRUE);
                        girls.get(random).setChoosen(Boolean.TRUE);

                        finalstudent.add(hasil);
                        if ((boys.size()+girls.size())==finalstudent.size()) {
                            break;
                        }
                    } else {

                        if (y<boys.size()) {
                            do {
                                random=(int) (Math.random()*boys.size());
                            } while (boys.get(random).getChoosen());
                            y=y+1;
                            Student hasil=boys.get(random);
                            hasil.setGroup(klompok);
                            hasil.setChoosen(Boolean.TRUE);
                            boys.get(random).setChoosen(Boolean.TRUE);

                            finalstudent.add(hasil);
                            if ((boys.size()+girls.size())==finalstudent.size()) {
                                break;
                            }
                        }

                    }

                }


            }
        }

        return finalstudent;
    }
}
