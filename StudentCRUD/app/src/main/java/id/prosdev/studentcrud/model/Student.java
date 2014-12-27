package id.prosdev.studentcrud.model;

/**
 * Created by Administrator on 12/19/2014.
 */
public class Student {

    private Long id;
    private String nim;
    private String name;
    private Gender gender;
    private String group;
    private Boolean choosen=Boolean.FALSE;

    public Boolean getChoosen() {
        return choosen;
    }

    public void setChoosen(Boolean choosen) {
        this.choosen = choosen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Id      : "+nim
                +"\nName      : "+name
                +"\nGender    : "+gender
                +"\nGroup     : "+group;
    }
}
