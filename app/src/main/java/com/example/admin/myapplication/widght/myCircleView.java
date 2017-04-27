package com.example.admin.myapplication.widght;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.ColorInt;
import android.support.annotation.IntDef;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.admin.myapplication.R;

/**
 * Created by Admin on 2017/4/26.
 */

public class myCircleView extends View {
    private float strokeWidth;
    private float mLargeSize;
    private float mSmallSize;
    private float mPadding;
    private int radius;
    private int mWidth;
    private int mHeight;


    @ColorInt
    private int mCircleColor = 0X60CCCCCC;
    @ColorInt
    private int mPathColor = 0X60CCCCCC;
    @ColorInt
    private int mTextColor = 0XFF000000;

    private String mText="跳过";
    private int mDuration=3;


    private Path mPath;
    private Paint mPaint;
    private PathMeasure mPathMeasure;
    private float mAnimatorValue;
    private Path mDst;
    private float mLength;


    private  ValueAnimator valueAnimator;

    public myCircleView(Context context) {
        this(context,null);
    }

    public myCircleView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public myCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable
                .myCircleView);

        strokeWidth = typedArray.getDimension(R.styleable
                .myCircleView_myView_circle_width, DensityUtils.dp2px(context, 3));
        mPadding=typedArray.getDimension(R.styleable
                .myCircleView_myView_circle_padding, DensityUtils.dp2px(context, 1));

        mLargeSize=typedArray.getDimension(R.styleable
                .myCircleView_myView_large_textsize, DensityUtils.sp2px(context, 12));
        mSmallSize=typedArray.getDimension(R.styleable
                .myCircleView_myView_small_textsize, DensityUtils.sp2px(context, 10));


        mCircleColor=typedArray.getColor(R.styleable
                .myCircleView_myView_circle_color,mCircleColor);
        mTextColor=typedArray.getColor(R.styleable
                .myCircleView_myView_text_color,mTextColor);

        mPathColor=typedArray.getColor(R.styleable
                .myCircleView_myView_path_color,mPathColor);

        mPathColor=typedArray.getColor(R.styleable
                .myCircleView_myView_path_color,mPathColor);

        mDuration = typedArray.getInt(R.styleable.myCircleView_duration_time,
                mDuration);

        if (typedArray.getString(R.styleable.myCircleView_circle_text)!=null)
        {
            mText=typedArray.getString(R.styleable.myCircleView_circle_text);
        }
        typedArray.recycle();

        init();
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mPath.addCircle(mWidth/2, mHeight/2, radius, Path.Direction.CW);
        mPathMeasure.setPath(mPath, false);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        radius= (int) (Math.min(getMeasuredWidth(),getMeasuredHeight())/2-strokeWidth/2);


        mWidth=getMeasuredWidth();
        mHeight=getMeasuredHeight();


        setMeasuredDimension(getMeasuredWidth(),getMeasuredHeight());
    }


    private void init()
    {
        mPath = new Path();
        mDst = new Path();
        mPathMeasure = new PathMeasure();


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setColor(mPathColor);




        valueAnimator= ValueAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mAnimatorValue = (float) valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(mDuration*1000);



    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawPathCircle(canvas);
    }

    private void drawPathCircle(Canvas canvas)
    {
        mDst.reset();
        mDst.lineTo(0,0);
        float stop = mPathMeasure.getLength() * mAnimatorValue;
        mPathMeasure.getSegment(0, stop, mDst, true);
        canvas.drawPath(mDst, mPaint);
    }

    public void startAnimation()
    {
        valueAnimator.start();
    }

}
