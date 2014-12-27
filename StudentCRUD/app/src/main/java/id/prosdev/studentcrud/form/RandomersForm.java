package id.prosdev.studentcrud.form;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import id.prosdev.studentcrud.R;

/**
 * Created by Administrator on 12/27/2014.
 */
public class RandomersForm {

   private Activity activity;
    private ListView listView;
    private Button random;
    private EditText numbers;

    public RandomersForm(Activity activity) {
        this.activity = activity;

        listView=(ListView) activity.findViewById(R.id.randomList);
        random=(Button) activity.findViewById(R.id.randomButton);
        numbers=(EditText) activity.findViewById(R.id.randomNumber);
    }

    public Activity getActivity() {
        return activity;
    }

    public ListView getListView() {
        return listView;
    }

    public Button getRandom() {
        return random;
    }

    public EditText getNumbers() {
        return numbers;
    }
}
