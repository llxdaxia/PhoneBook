package cn.alien95.phonebook.model;

/**
 * Created by llxal on 2015/12/9.
 */
public interface Callback<T> {
    void callback(T data , int count);
}
