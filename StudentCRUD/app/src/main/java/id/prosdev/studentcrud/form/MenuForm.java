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

    public MenuForm(Activity activity){
        this.activity=activity;

        buttonAdd= (Button) activity.findViewById(R.id.buttonAdd);
        buttonList = (Button) activity.findViewById(R.id.buttonShow);
    }

    public Activity getActivity() {
        return activity;
    }

    public Button getButtonAdd() {
        return buttonAdd;
    }

    public Button getButtonList() {
        return buttonList;
    }
}
