package cn.alien95.phonebook.main;

import android.content.Context;
import android.widget.TextView;

import java.util.List;

import cn.alien95.phonebook.R;
import cn.alien95.phonebook.model.Book;
import cn.alien95.phonebook.widget.ListAdapter;
import cn.alien95.phonebook.widget.ViewHolder;

/**
 * Created by llxal on 2015/12/9.
 */
public class BookListAdapter extends ListAdapter<Book> {

    private TextView content;

    public BookListAdapter(Context context, int layoutId,List<Book> data) {
        super(context, layoutId,data);
    }

    @Override
    public void makeViewData(ViewHolder viewHolder, int position) {
        content = viewHolder.getItemView(R.id.name);
        content.setText(getItem(position).getId() + " " + getItem(position).getName());
    }
}
