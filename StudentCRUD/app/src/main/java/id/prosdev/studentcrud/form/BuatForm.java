package id.prosdev.studentcrud.form;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import id.prosdev.studentcrud.R;

/**
 * Created by Administrator on 12/24/2014.
 */
public class BuatForm {

    private Activity activity;
    private EditText nim;
    private EditText nama;
    private RadioButton male;
    private RadioButton female;
    private Button simpan;

    public BuatForm(Activity activity){
        this.activity=activity;

        nim= (EditText) activity.findViewById(R.id.editTextBuatNim);
        nama= (EditText) activity.findViewById(R.id.editTextBuatNama);
        male= (RadioButton) activity.findViewById(R.id.radioBuatMale);
        female= (RadioButton) activity.findViewById(R.id.radioBuatFemale);
        simpan=(Button) activity.findViewById(R.id.buttonBuatSimpan);

    }

    public void reset(){
        nim.setText("");
        nama.setText("");
        male.setChecked(false);
        female.setChecked(false);
    }

    public Activity getActivity() {
        return activity;
    }

    public EditText getNim() {
        return nim;
    }

    public EditText getNama() {
        return nama;
    }

    public RadioButton getMale() {
        return male;
    }

    public RadioButton getFemale() {
        return female;
    }

    public Button getSimpan() {
        return simpan;
    }
}
