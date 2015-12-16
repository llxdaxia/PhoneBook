package cn.alien95.phonebook.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;

import cn.alien95.phonebook.utils.Util;

/**
 * Created by llxal on 2015/12/12.
 */
public class ViewHolder {

    private SparseArray<View> recycle = new SparseArray<>();;
    private static View convertView;

    public ViewHolder(Context context,int layoutID){
        convertView = LayoutInflater.from(context).inflate(layoutID,null);
        convertView.setTag(this);
    }

    public static ViewHolder getViewHolder(Context context,View convertView,int layoutId){
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder(context,layoutId);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return viewHolder;
    }

    public<T extends View> T getItemView(int id){
        T view = (T) recycle.get(id);
        if(view == null){
            view = (T) convertView.findViewById(id);
            recycle.put(id,view);
        }
        return view;
    }

    public View getConvertView(){
        if(convertView == null)
        Util.log("convertView == null");
        return convertView;
    }
}
