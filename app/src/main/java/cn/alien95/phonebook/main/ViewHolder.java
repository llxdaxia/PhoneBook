package cn.alien95.phonebook.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by llxal on 2015/12/12.
 */
public class ViewHolder {

    private static Context mContext;
    private static LayoutInflater inflater;
    private Map<Integer,View> recycle;
    private static View item;

    public ViewHolder(){
        inflater = LayoutInflater.from(mContext);
        recycle = new HashMap<>();
    }

    public static ViewHolder getViewHolder(Context context,View convertView,int layoutId){
        mContext = context;
        if(convertView == null){
            ViewHolder viewHolder = new ViewHolder();
            item = inflater.inflate(layoutId,null);
            item.setTag(viewHolder);
            return viewHolder;
        }else {
            return (ViewHolder) convertView.getTag();
        }
    }

    public<T extends View> T getItemView(int id){
        T view = (T) recycle.get(id);
        if(view == null){
            view = (T) item.findViewById(id);
            recycle.put(id,view);
        }
        return view;
    }

    public View getItem(){
        return item;
    }
}