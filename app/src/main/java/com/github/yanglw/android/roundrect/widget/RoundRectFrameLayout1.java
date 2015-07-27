package com.github.yanglw.android.roundrect.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * 使用 {@link Canvas#clipPath(Path)} 实现圆角 Layout 。
 */
public class RoundRectFrameLayout1 extends BaseFrameLayout
{
    private Path mPath = new Path();
    private RectF mRectF = new RectF();

    public RoundRectFrameLayout1(Context context)
    {
        super(context);
    }

    public RoundRectFrameLayout1(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public RoundRectFrameLayout1(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init()
    {
        super.init();
        fixClipPathUnsupportedOperationException(this);
    }

    @Override
    public void draw(Canvas canvas)
    {
        mPath.reset();
        mRectF.set(0, 0, getWidth(), getHeight());
        mPath.addRoundRect(mRectF, radius, radius, Path.Direction.CW);
        canvas.clipPath(mPath);

        super.draw(canvas);
    }

    /**
     * 修复 Android 11~17 中，{@link android.graphics.Canvas#clipPath(Path)} 引起的
     * {@link UnsupportedOperationException} 问题。
     * <p/>
     * 解决办法原文：<a href="http://stackoverflow.com/a/30354461">http://stackoverflow.com/a/30354461</a>
     */
    public static void fixClipPathUnsupportedOperationException(View view)
    {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2
            && Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            view.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
    }
}
