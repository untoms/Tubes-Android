package id.prosdev.studentcrud.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import id.prosdev.studentcrud.model.Gender;
import id.prosdev.studentcrud.model.Student;

/**
 * Created by Administrator on 12/19/2014.
 */
public class StudentDB {

    //inisialiasi SQLite Database
    private SQLiteDatabase database;

    //inisialisasi kelas DBHelper
    private DBHelper dbHelper;

    //ambil semua nama kolom
    private String[] allColumns = { DBHelper.COLUMN_ID,DBHelper.COLUMN_NIM,
            DBHelper.COLUMN_NAME, DBHelper.COLUMN_GENDER};

    //DBHelper diinstantiasi pada constructor
    public StudentDB(Context context)
    {
        dbHelper = DBHelper.getInstance(context);
    }

    //membuka/membuat sambungan baru ke database
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //menutup sambungan ke database
    public void close() {
        dbHelper.close();
    }

    //method untuk create/insert barang ke database
    public Student createStudent(Student student) {

        open();
        // membuat sebuah ContentValues, yang berfungsi
        // untuk memasangkan data dengan nama-nama
        // kolom pada database
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NAME, student.getName());
        values.put(DBHelper.COLUMN_NIM, student.getNim());
        values.put(DBHelper.COLUMN_GENDER, String.valueOf(student.getGender()));

        // mengeksekusi perintah SQL insert data
        // yang akan mengembalikan sebuah insert ID
        long insertId = database.insert(DBHelper.TABLE_NAME, null,
                values);

        // setelah data dimasukkan, memanggil
        // perintah SQL Select menggunakan Cursor untuk
        // melihat apakah data tadi benar2 sudah masuk
        // dengan menyesuaikan ID = insertID
        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, DBHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();

        // mengubah objek pada kursor pertama tadi
        // ke dalam objek barang
        Student newStudent = cursorToStudent(cursor);

        //close cursor
        cursor.close();
        close();

        //mengembalikan student baru
        return newStudent;
    }

    private Student cursorToStudent(Cursor cursor)
    {
        // buat objek student baru
        Student student = new Student();
        // debug LOGCAT
        //Log.v("info", "The getLONG "+cursor.getLong(0));
        //Log.v("info", "The setLatLng "+cursor.getString(1)+","+cursor.getString(2));

        // Set atribut pada objek student dengan
        // data kursor yang diambil dari database
        student.setId(cursor.getLong(0));
        student.setNim(cursor.getString(1));
        student.setName(cursor.getString(2));
        student.setGender(Gender.valueOf(cursor.getString(3)));

        //kembalikan sebagai objek student
        return student;
    }

    //mengambil semua data student
    public List<Student> getAllStudent() {
        open();
        ArrayList<Student> daftarStudent = new ArrayList<Student>();

        // select all SQL query
        Cursor cursor = database.query(DBHelper.TABLE_NAME,
                allColumns, null, null, null, null, null);

        // pindah ke data paling pertama
        cursor.moveToFirst();
        // jika masih ada data, masukkan data student ke
        // daftar student
        while (!cursor.isAfterLast()) {
            Student student = cursorToStudent(cursor);
            daftarStudent.add(student);
            cursor.moveToNext();
        }
        // Make sure to close the cursor
        cursor.close();
        close();
        return daftarStudent;
    }

    //ambil satu student sesuai id
    public Student getStudent(long id)
    {
        open();
        Student student; //inisialisasi student
        //select query
        Cursor cursor = database.query(DBHelper.TABLE_NAME, allColumns, "_id ="+id, null, null, null, null);
        //ambil data yang pertama
        cursor.moveToFirst();
        //masukkan data cursor ke objek student
        student = cursorToStudent(cursor);
        //tutup sambungan
        cursor.close();
        //return student
        close();
        return student;
    }

    //update student yang diedit
    public void updateStudent(Student b)
    {
        open();
        //ambil id student
        String strFilter = "_id=" + b.getId();
        //memasukkan ke content values
        ContentValues args = new ContentValues();
        //masukkan data sesuai dengan kolom pada database
        args.put(DBHelper.COLUMN_NAME, b.getName());
        args.put(DBHelper.COLUMN_GENDER, String.valueOf(b.getGender()));
        //update query
        database.update(DBHelper.TABLE_NAME, args, strFilter, null);
        close();
    }

    // delete barang sesuai ID
    public void deleteStudent(long id)
    {
        open();
        String strFilter = "_id=" + id;
        database.delete(DBHelper.TABLE_NAME, strFilter, null);
        close();
    }
}
