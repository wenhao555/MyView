package com.example.myview.weight;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class CustomView extends View
{
    private Scroller scroller;

    public CustomView(Context context)
    {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    @Override
    public void computeScroll()
    {
        super.computeScroll();
        if (scroller.computeScrollOffset())
        {
            ((View) getParent()).scrollTo(scroller.getCurrX(), scroller.getCurrY());
            invalidate();//每次滑动调用该方法进行不断的重绘，重绘就会调用computeScroll方法
        }
    }

    public void smoothScrollTo(int destX, int destY)
    {
        int scroollX = getScrollX();
        int delta = destX - scroollX;
        scroller.startScroll(scroollX, 0, delta, 0, 2000);
        invalidate();//无效

    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    private int lastX;
    private int lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int x = (int) event.getX();//得到距离父控件左边距
        int y = (int) event.getY(); //得到距离父控件顶边距
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算移动的距离
                int offsetX = x - lastX;//移动的X轴距离
                int offsetY = y - lastY;//移动的Y轴距离
                //-------------------------------------方法一--------------------------------------
                //调用layout方法来重新放置它的位置
//                layout(getLeft() + offsetX,//当前距离父边距的左边的距离  +   移动的X轴距离
//                        getTop() + offsetY,
//                        getRight() + offsetX,
//                        getBottom() + offsetY);·
//
//-------------------------------------方法二--------------------------------------
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);
//-------------------------------------方法三--------------------------------------
                //写法一
//                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();//父控件是什么就用什么布局下的LayoutParams
//                layoutParams.leftMargin = getLeft() + offsetX;
//                layoutParams.topMargin = getTop() + offsetY;
//                setLayoutParams(layoutParams);
                //写法二  可以使用ViewGroup
//                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();//父控件是什么就用什么布局下的LayoutParams
//                marginLayoutParams.leftMargin = getLeft() + offsetX;
//                marginLayoutParams.topMargin = getTop() + offsetY;
//                setLayoutParams(marginLayoutParams);
//-------------------------------------方法四--------------------------------------
//                ((View) getParent()).scrollBy(-offsetX,-offsetY);
//                ((View) getParent()).scrollTo(-offsetX, -offsetY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

}
