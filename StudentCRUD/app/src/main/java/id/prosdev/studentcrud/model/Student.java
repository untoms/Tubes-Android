package id.prosdev.studentcrud.model;

/**
 * Created by Administrator on 12/19/2014.
 */
public class Student {

    public String id;
    public String name;
    public Gender gender;

    @Override
    public String toString() {
        return "Id      : "+id
                +"Name      : "+name
                +"Gender    : "+gender;
    }
}
