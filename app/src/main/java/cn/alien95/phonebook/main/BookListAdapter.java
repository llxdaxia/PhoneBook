package cn.alien95.phonebook.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import cn.alien95.phonebook.R;
import cn.alien95.phonebook.model.Book;

/**
 * Created by llxal on 2015/12/9.
 */
public class BookListAdapter extends ArrayAdapter<Book>{


    public BookListAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(getContext(),convertView, R.layout.item_book);
        return viewHolder.getItem();
    }

}
