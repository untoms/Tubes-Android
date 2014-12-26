package id.prosdev.studentcrud.model;

/**
 * Created by Administrator on 12/19/2014.
 */
public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    private final String name;

    private  Gender (String name) {
        this.name=name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
