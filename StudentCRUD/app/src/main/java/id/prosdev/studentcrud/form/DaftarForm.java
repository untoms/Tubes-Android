package id.prosdev.studentcrud.form;

import android.app.Activity;
import android.widget.ListView;

import id.prosdev.studentcrud.R;

/**
 * Created by Administrator on 12/24/2014.
 */
public class DaftarForm {

    private Activity activity;
    private ListView listView;

    public DaftarForm(Activity activity) {
        this.activity = activity;

        listView=(ListView) activity.findViewById(R.id.listStudent);
    }

    public Activity getActivity() {
        return activity;
    }

    public ListView getListView() {
        return listView;
    }
}
