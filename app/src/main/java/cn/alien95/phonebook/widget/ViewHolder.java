package cn.alien95.phonebook.widget;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by llxal on 2015/12/12.
 */
public class ViewHolder {

    private SparseArray<View>  recycle;
    private static View mConvertView;

    public ViewHolder(Context context,int layoutID){
        recycle = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutID,null);
        mConvertView.setTag(this);
    }

    public static ViewHolder getViewHolder(Context context,View convertView,int layoutId){
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder(context,layoutId);
        }else {
            mConvertView = convertView;  //我日了狗了，着他妈少了这句话就不行了
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return viewHolder;
    }

    public<T extends View> T getItemView(int id){
        T view = (T) recycle.get(id);
        if(view == null){
            view = (T) mConvertView.findViewById(id);
            recycle.put(id,view);
        }
        return view;
    }

    public View getConvertView(){
        return mConvertView;
    }
}
