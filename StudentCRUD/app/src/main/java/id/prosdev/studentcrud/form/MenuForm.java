package id.prosdev.studentcrud.form;

import android.app.Activity;
import android.widget.Button;

import id.prosdev.studentcrud.R;

/**
 * Created by Administrator on 12/19/2014.
 */
public class MenuForm {

    private Activity activity;
    private Button buttonAdd;
    private Button buttonList;
    private Button buttonRandom;

    public MenuForm(Activity activity){
        this.activity=activity;

        buttonAdd= (Button) activity.findViewById(R.id.buttonAdd);
        buttonList = (Button) activity.findViewById(R.id.buttonShow);
        buttonRandom=(Button) activity.findViewById(R.id.buttonRandom);
    }

    public Activity getActivity() {
        return activity;
    }

    public Button getButtonRandom() {
        return buttonRandom;
    }

    public Button getButtonAdd() {
        return buttonAdd;
    }

    public Button getButtonList() {
        return buttonList;
    }
}
