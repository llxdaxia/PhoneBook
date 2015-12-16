package cn.alien95.phonebook.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.alien95.phonebook.utils.Util;

/**
 * Created by llxal on 2015/12/15.
 */
public abstract class ListAdapter<T> extends BaseAdapter {

    private List<T> data = new ArrayList<>();
    private Context mContext;
    private int layoutId;

    public ListAdapter(Context context,int layoutId,List<T> data){
        mContext = context;
        this.layoutId = layoutId;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public T getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(mContext,convertView,layoutId);
        makeViewData(viewHolder,position);
        Util.log("ConvertView:" + (viewHolder.getConvertView()==null));
        return viewHolder.getConvertView();
    }

    public void add(T itemData){
        data.add(itemData);
        notifyDataSetChanged();  //这里是去通知数据源改变，即观察getCount,getItem方法的改变
    }

    public void insert(T itemData,int postion){
        data.add(postion, itemData);
        notifyDataSetChanged();
    }

    public void addAll(List<T> list){
        data.addAll(list);
//        notifyDataSetChanged();
    }

    public void addAll(T[] array){
        data.addAll(Arrays.asList(array));
        notifyDataSetChanged();
    }

    public void delete(T object){
        data.remove(object);
        notifyDataSetChanged();
    }

    public void delete(int position){
        data.remove(position);
        notifyDataSetChanged();
    }

    public void update(int position,T object){
        if(position < data.size()){
            data.set(position,object);
            notifyDataSetChanged();
        }
    }

    public abstract void makeViewData(ViewHolder viewHolder,int position);
}
