package com.github.yanglw.android.roundrect.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.github.yanglw.android.roundrect.R;

/**
 *
 * Created by yanglw on 2015/7/20.
 */
public class BaseFrameLayout extends FrameLayout
{
    protected int radius = 15;

    public BaseFrameLayout(Context context)
    {
        super(context);
        init();
    }

    public BaseFrameLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    public BaseFrameLayout(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init();
    }

    protected void init()
    {
        radius= getResources().getDimensionPixelSize(R.dimen.radius);
    }
}
