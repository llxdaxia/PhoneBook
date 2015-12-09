package cn.alien95.phonebook.model;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llxal on 2015/12/9.
 */
public class BookModel {
    private static final String ADDRESS_URI = "content://com.android.contacts/contacts";
    private List<Book> data = new ArrayList<>();
    private ContentResolver contentResolver;
    private Context mContext;
    private Handler handler;

    public BookModel(Context context){
        mContext = context;
        handler = new Handler();
    }

    public void getAddressList(final Callback<List<Book>> callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                //获取一个ContentResolver对象
                contentResolver = mContext.getContentResolver();
                //取得联系人中开始的游标
                Cursor cursor = contentResolver.query(Uri.parse(ADDRESS_URI),null,null,null,null);
                final int count = cursor.getCount();
                while (cursor.moveToNext()){
                    //获取联系人id,姓名
                    Book book = new Book();
                    List<String> phoneData = new ArrayList<>();
                    int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(android.provider.ContactsContract.Contacts._ID)));
                    book.setId(id);
                    book.setName(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
                    //获取手机号码,通过SQL语句过滤出对应的id的人的电话号码的数据库那一列,并且返回一个Curse
                    Cursor cursorPhone = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + id, null, null);

                    //多个号码的可能
                    while (cursorPhone.moveToNext()){
                        phoneData.add(cursorPhone.getString(cursorPhone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                    }
                    book.setPhone(phoneData);
                    data.add(book);
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.callback(data,count);
                    }
                });
            }
        }).start();
    }
}
