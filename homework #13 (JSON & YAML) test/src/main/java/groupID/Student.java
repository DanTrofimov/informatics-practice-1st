package groupID;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public String  gender;
    public long date;
    public long group;

    public Student() {};

    public Student(String name, long date) {
        this.name = name;
        this.date = date;
    }

    public Student(String name, String gender, long date, long group) {
        this.name = name;
        this.gender = gender;
        this.date = date;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getDate() {
        return date;
    }

    public void setDate(int data) {
        this.date = data;
    }

    public long getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "{" + this.name + ", " + this.gender + ", " + this.date + ", " + this.group + "}";
    }
}