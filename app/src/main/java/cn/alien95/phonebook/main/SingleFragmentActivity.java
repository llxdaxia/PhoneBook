package cn.alien95.phonebook.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.alien95.phonebook.R;
import cn.alien95.phonebook.model.Book;
import cn.alien95.phonebook.model.BookModel;
import cn.alien95.phonebook.model.Callback;
import cn.alien95.phonebook.widget.BaseViewHolder;
import cn.alien95.phonebook.widget.RecyclerAdapter;

public class SingleFragmentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_fragment);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this,R.layout.item_book);
        recyclerView.setAdapter(adapter);
        new BookModel(this).getAddressList(new Callback<List<Book>>() {
            @Override
            public void callback(List<Book> data, int count) {
                adapter.addAll(data);
            }
        });

    }

    class MyAdapter extends RecyclerAdapter<Book>{

        public MyAdapter(Context context, int layoutId) {
            super(context, layoutId);
        }

        @Override
        public BaseViewHolder<Book> onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(getContext(),getLayoutId());
        }
    }

    class MyViewHolder extends BaseViewHolder<Book>{

        private TextView content;
        public MyViewHolder(Context context, int layoutId) {
            super(context, layoutId);
            content = (TextView) itemView.findViewById(R.id.name);
        }

        @Override
        public void setData(Book book) {
            super.setData(book);
            content.setText(book.getId() + " " + book.getName());
        }
    }


}
