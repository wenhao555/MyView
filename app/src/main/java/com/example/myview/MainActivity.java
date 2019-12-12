package com.example.myview;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myview.weight.CustomView;

public class MainActivity extends AppCompatActivity
{
    private Context context;
    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        mCustomView = findViewById(R.id.mCustomView);
        mCustomView.smoothScrollTo(-400, 0);
        mCustomView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
            }
        });
//        mCustomView.setAnimation(AnimationUtils.loadAnimation(context, R.anim.translate));
//        ObjectAnimator.ofFloat(mCustomView, "translationX", 0, 300).setDuration(1000).start();


        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mCustomView, "translationX", 200);
        objectAnimator.setDuration(300);
        objectAnimator.start();
    }


    private void getHeight()
    {
        TextView textView = new TextView(context);
        textView.getHeight();//获取控件高度
        textView.getWidth();//获取控件宽度
        textView.getTop();//获取View自身 顶边到其父布局顶边 的距离
        textView.getBottom();//获取View自身 底边 到其父布局顶边 的距离

        textView.getLeft();//获取View自身左边 到其父布局左边的距离
        textView.getRight();//获取View自身右边 到其父布局左边的距离
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float x = event.getX();//获取点击事件距离控件左边的距离，即视图坐标
        float y = event.getY();//获取 点击事件距离控件顶边的距离，即视图坐标

        float rawX = event.getRawX();//获取点击事件距离整个屏幕左边的距离，及绝对坐标
        float rawY = event.getRawY();//获取点击事件距离整个屏幕顶边的距离，及绝对坐标
        return super.onTouchEvent(event);
    }
}
