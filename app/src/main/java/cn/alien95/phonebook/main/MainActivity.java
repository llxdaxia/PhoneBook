package cn.alien95.phonebook.main;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.widget.TextView;

import cn.alien95.phonebook.R;

public class MainActivity extends Activity {

    private ViewPager viewPager;
    private PagerAdapter adapter;
    private TextView callPhone,bookPhone;
    private int NORMAL_COLOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callPhone = (TextView) findViewById(R.id.call_phone);
        bookPhone = (TextView) findViewById(R.id.phone_book);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        NORMAL_COLOR = callPhone.getCurrentTextColor();   //这里
        adapter = new PagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(adapter);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    class PagerAdapter extends FragmentStatePagerAdapter implements ViewPager.OnPageChangeListener{

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new BookFragment();
                case 1:
                    return new BookFragment();
                default:
                    return new BookFragment();
            }

        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            switch (position){
                case 0:
                    //设置的参数是int型，而R.color.orange是#123456这样的，所以需要转换，在R类中没有对应的id对应了一个int型常量
                    callPhone.setTextColor(getResources().getColor(R.color.orange));
                    bookPhone.setTextColor(NORMAL_COLOR);
                    break;
                case 1:
                    bookPhone.setTextColor(getResources().getColor(R.color.orange));
                    callPhone.setTextColor(NORMAL_COLOR);
                    break;
            }
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
