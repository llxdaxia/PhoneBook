package cn.alien95.phonebook.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

/**
 * Created by llxal on 2015/12/17.
 */
public class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(Context context,int layoutId) {
        super(LayoutInflater.from(context).inflate(layoutId,null));
    }

    public void setData(T data){}

}
