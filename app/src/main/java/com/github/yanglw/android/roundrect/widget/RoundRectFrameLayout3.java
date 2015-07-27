package com.github.yanglw.android.roundrect.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * 使用 {@link android.graphics.PorterDuffXfermode} 实现圆角 Layout 。
 */
public class RoundRectFrameLayout3 extends BaseFrameLayout
{
    private Paint mPaint;
    private PorterDuffXfermode mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);

    public RoundRectFrameLayout3(Context context)
    {
        super(context);
    }

    public RoundRectFrameLayout3(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public RoundRectFrameLayout3(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void init()
    {
        super.init();

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    public void draw(Canvas canvas)
    {
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c1 = new Canvas(bitmap);
        super.draw(c1);

        Bitmap roundRectBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c2 = new Canvas(roundRectBitmap);
        mPaint.setXfermode(null);
        c2.drawRoundRect(new RectF(0, 0, getWidth(), getHeight()), radius, radius, mPaint);

        mPaint.setXfermode(mXfermode);
        c2.drawBitmap(bitmap, 0, 0, mPaint);

        mPaint.setXfermode(null);
        canvas.drawBitmap(roundRectBitmap, 0, 0, mPaint);
    }
}
