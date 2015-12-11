package cn.alien95.phonebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import cn.alien95.phonebook.utils.Util;

/**
 * Created by llxal on 2015/12/10.
 */
public class PlayView extends ViewGroup {

    public PlayView(Context context) {
        super(context);
    }

    public PlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);  //-->这里的height为0

        int right = getWidth();
        int lengthX = 0;
        int lengthY = 0;
        int row = 0;
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View childView = getChildAt(i);
            int measureWidth = childView.getMeasuredWidth();
            int measureHeight = childView.getMeasuredHeight();
            if (measureWidth > width) {
                measureWidth = width;
                childView.measure(MeasureSpec.makeMeasureSpec(measureWidth, MeasureSpec.UNSPECIFIED), MeasureSpec.makeMeasureSpec(measureHeight, MeasureSpec.UNSPECIFIED));
            }
            lengthX += measureWidth;

            if (lengthX > width) {
                lengthX = measureWidth;
                row++;
            }

            lengthY = (row + 1) * measureHeight;

            if (height == 0) {
                height = lengthY;   //---->由于height==0，得自己计算出lengthy，并把它赋值给height
            }

            setMeasuredDimension(width, height);   //---->这个方法是把width，height设置进去
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int screenWidth = Util.getScreenWidth();
        int count = getChildCount();
        int maxHeight = 0;
        int sumTop = 0;
        Util.log("child -- count :" + count);

        for (int i = 0; i < count; i++) {
            int right = 0;
            int currentWidth = getChildAt(i).getMeasuredWidth();
            int currentHeight = getChildAt(i).getMeasuredHeight();
            if (currentHeight > maxHeight) {
                maxHeight = currentHeight;
                Util.log("max-height:" + maxHeight);
            }
            if (i > 0) {
                right = getChildAt(i - 1).getRight();
            }

            if ((right + currentWidth) > screenWidth) {
                sumTop += maxHeight;  //注意这里sumTop写在下面行代码上面
                getChildAt(i).layout(0, sumTop, currentWidth, sumTop + currentHeight);
                Util.log("sumtop:" + sumTop);
            } else
                getChildAt(i).layout(right, sumTop, right + currentWidth, sumTop + currentHeight);

        }
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(),attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
