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
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            viewHolder.textView = new TextView(getContext());
            viewHolder.textView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            viewHolder.textView.setTextSize(16);
            viewHolder.textView.setPadding(Util.dip2px(16),Util.dip2px(16),Util.dip2px(16),Util.dip2px(16));
            convertView = viewHolder.textView;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(getItem(position).getId()+"  " +getItem(position).getName());
        return viewHolder.textView;
    }

    class ViewHolder{
        TextView textView;
    }

}
