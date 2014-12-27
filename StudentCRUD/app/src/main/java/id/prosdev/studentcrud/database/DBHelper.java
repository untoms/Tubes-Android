package id.prosdev.studentcrud.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 12/27/2014.
 */
public class DBHelper extends SQLiteOpenHelper {

    /** deklarasi konstanta-konstanta yang digunakan pada database, seperti nama tabel,
     nama-nama kolom, nama database, dan versi dari database **/
    public static final String TABLE_NAME = "student";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NIM= "nim";
    public static final String COLUMN_GENDER = "gender";
    private static final String db_name ="cakacaka.db";
    private static final int db_version=1;

    private static DBHelper Instance = null;
    private Context context;

    public static DBHelper getInstance(Context context) {
        if (Instance == null){
            Instance = new DBHelper(context.getApplicationContext());
        }

        return Instance;
    }

    // Perintah SQL untuk membuat tabel database baru
    private static final String db_create = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID +" integer primary key autoincrement, "
            + COLUMN_NIM+ " varchar(50) not null, "
            + COLUMN_NAME+ " varchar(50) not null, "
            + COLUMN_GENDER+ " varchar(50) not null);";

    public DBHelper(Context context) {
        super(context, db_name, null, db_version);
        this.context=context;
        // Auto generated
    }

    //mengeksekusi perintah SQL di atas untuk membuat tabel database baru
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(db_create);
    }

    // dijalankan apabila ingin mengupgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(), "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}