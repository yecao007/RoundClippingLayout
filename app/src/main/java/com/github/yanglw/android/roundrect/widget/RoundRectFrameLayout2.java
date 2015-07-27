package com.github.yanglw.android.roundrect.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;

/**
 * 使用 {@link BitmapShader} 实现圆角 Layout 。
 */
public class RoundRectFrameLayout2 extends BaseFrameLayout
{
    private RectF mRectF = new RectF();
    private Paint mPaint;

    public RoundRectFrameLayout2(Context context)
    {
        super(context);
    }

    public RoundRectFrameLayout2(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public RoundRectFrameLayout2(Context context, AttributeSet attrs, int defStyle)
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
        Canvas c = new Canvas(bitmap);
        super.draw(c);

        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);

        mRectF.set(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(mRectF, radius, radius, mPaint);
    }
}
