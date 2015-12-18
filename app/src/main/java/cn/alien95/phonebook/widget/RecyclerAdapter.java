package cn.alien95.phonebook.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by llxal on 2015/12/17.
 */
public abstract class RecyclerAdapter<T> extends RecyclerView.Adapter<BaseViewHolder<T>> {

    private Context context;
    private int layoutId;
    private BaseViewHolder<T> viewHolder;
    private List<T> data;

    public RecyclerAdapter(Context context,int layoutId){
        this.context = context;
        this.layoutId = layoutId;
        viewHolder = new BaseViewHolder<>(context,layoutId);
        data = new ArrayList<>();
    }

    @Override
    public abstract BaseViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseViewHolder<T> holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public T getItem(int position){
        return data.get(position);
    }

    public void add(T data){
        this.data.add(data);
        notifyDataSetChanged();
    }

    public void add(T data,int potision){
        this.add(data,potision);
        notifyDataSetChanged();
    }

    public void addAll(List<T> data){
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public void addAll(T[] data){
        this.data.addAll(Arrays.asList(data));
        notifyDataSetChanged();
    }

    public Context getContext() {
        return context;
    }

    public int getLayoutId() {
        return layoutId;
    }
}
