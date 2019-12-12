package com.example.myview.weight;

import android.view.View;

public class MyView {
    private View mTarget;

    public MyView(View mTarget) {
        this.mTarget = mTarget;

    }

    public int getWidth() {
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width) {
        this.mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }
}
