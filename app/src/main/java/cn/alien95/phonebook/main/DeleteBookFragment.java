package cn.alien95.phonebook.main;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import cn.alien95.phonebook.R;
import cn.alien95.phonebook.model.BookModel;
import cn.alien95.phonebook.widget.CustomActivity;

/**
 * Created by llxal on 2015/12/10.
 */
public class DeleteBookFragment extends Fragment {

    private BookModel bookModel;
    private Button delete;
    private Button custom;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookModel = new BookModel(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete,container,false);
        delete = (Button) view.findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bookModel.deleteBook("");
                    }
                });
            }
        });
        custom = (Button) view.findViewById(R.id.custom);
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivity(new Intent(getActivity(), CustomActivity.class));
            }
        });
        return view;

    }
}
