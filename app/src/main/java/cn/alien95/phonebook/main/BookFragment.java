package cn.alien95.phonebook.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.alien95.phonebook.R;
import cn.alien95.phonebook.model.Book;
import cn.alien95.phonebook.model.BookModel;
import cn.alien95.phonebook.model.Callback;

/**
 * Created by llxal on 2015/12/9.
 */
public class BookFragment extends Fragment {

    private ListView listView;
    private BookListAdapter adapter;
    private List<Book> data;
    private BookModel bookModel;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ArrayList<>();
        adapter = new BookListAdapter(getActivity(),1,data);
        bookModel = new BookModel(getActivity());
        bookModel.getAddressList(new Callback<List<Book>>() {
            @Override
            public void callback(List<Book> data) {
                BookFragment.this.data = data;
                adapter.addAll(data);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booklist,container,false);
        listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        return view;
    }


}
