package cn.alien95.phonebook.model;

import java.util.List;

/**
 * Created by llxal on 2015/12/9.
 */
public class Book {

    private int id;
    private String name;
    private List<String> phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }
}
