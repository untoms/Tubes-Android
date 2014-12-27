package id.prosdev.studentcrud;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import id.prosdev.studentcrud.form.DaftarForm;
import id.prosdev.studentcrud.form.MenuForm;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private MenuForm menuForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuForm=new MenuForm(this);
        menuForm.getButtonAdd().setOnClickListener(this);
        menuForm.getButtonList().setOnClickListener(this);
        menuForm.getButtonRandom().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==menuForm.getButtonAdd()){
            Intent intent=new Intent(this, BuatActivity.class);
            startActivity(intent);
        }else if(v==menuForm.getButtonList()){
            Intent intent=new Intent(this, DaftarActivity.class);
            startActivity(intent);
        }else if(v==menuForm.getButtonRandom()){
            Intent intent=new Intent(this, RandomersActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
