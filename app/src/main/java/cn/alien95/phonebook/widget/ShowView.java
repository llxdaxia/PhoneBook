package cn.alien95.phonebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by llxal on 2015/12/9.
 */
public class ShowView extends LinearLayout {

    public ShowView(Context context) {
        super(context);
    }

    public ShowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
