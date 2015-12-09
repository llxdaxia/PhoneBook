package cn.alien95.phonebook.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cn.alien95.phonebook.model.Book;
import cn.alien95.phonebook.utils.Util;

/**
 * Created by llxal on 2015/12/9.
 */
public class BookListAdapter extends ArrayAdapter<Book>{


    public BookListAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setTextSize(16);
        textView.setPadding(Util.dip2px(16),Util.dip2px(16),Util.dip2px(16),Util.dip2px(16));
        textView.setText(getItem(position).getId()+"  " +getItem(position).getName());
        return textView;
    }
}
