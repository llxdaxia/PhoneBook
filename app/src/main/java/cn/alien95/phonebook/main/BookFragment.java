package cn.alien95.phonebook.main;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.alien95.phonebook.R;
import cn.alien95.phonebook.model.Book;
import cn.alien95.phonebook.model.BookModel;
import cn.alien95.phonebook.model.Callback;
import cn.alien95.phonebook.utils.Util;

/**
 * Created by llxal on 2015/12/9.
 */
public class BookFragment extends Fragment implements View.OnTouchListener,AdapterView.OnItemSelectedListener{

    private ListView listView;
    private BookListAdapter adapter;
    private List<Book> data;
    private BookModel bookModel;
    private TextView phoneNum;
    private View mainView;
    private boolean IS_FIRST_POSTION = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new ArrayList<>();
        adapter = new BookListAdapter(getActivity(),1,data);
        bookModel = new BookModel(getActivity());
        bookModel.getAddressList(new Callback<List<Book>>() {
            @Override
            public void callback(List<Book> data , int count) {
                BookFragment.this.data = data;
                adapter.addAll(data);
                Util.log("count:"+count);
                phoneNum.setText(count + "位联系人");
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booklist,container,false);
        phoneNum = (TextView) view.findViewById(R.id.phoneNum);
        listView = (ListView) view.findViewById(R.id.listview);
        mainView = view.findViewById(R.id.main);
        listView.setAdapter(adapter);
        return view;
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        float y;
        if(IS_FIRST_POSTION){
            y = event.getY();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            if(y < phoneNum.getHeight()){
                layoutParams.setMargins(0, (int)y,0,0);
            }else
                layoutParams.setMargins(0, phoneNum.getHeight(),0,0);
            mainView.setLayoutParams(layoutParams);
            return true;
        }else
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
            IS_FIRST_POSTION = true;
        }else
            IS_FIRST_POSTION = false;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
