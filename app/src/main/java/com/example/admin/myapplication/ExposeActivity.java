package com.example.admin.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;

public class ExposeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expose);
    }


    public void Expose1(View view)
    {
        expose1();

    }
    public void Expose2(View view)
    {
        expose2();

    }

    private void expose1()
    {
        View myView = findViewById(R.id.my_view);

        // 得到剪辑圈的中心
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;

        // 获得剪辑圈的最终半径
        int finalRadius = Math.max(myView.getWidth(), myView.getHeight());

        //为此视图创建动画师（起始半径为零）
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);

        //创建视图显示动画
        myView.setVisibility(View.VISIBLE);
        anim.start();
    }


    private void expose2()
    {
        final View myView = findViewById(R.id.my_view);
        int cx = (myView.getLeft() + myView.getRight()) / 2;
        int cy = (myView.getTop() + myView.getBottom()) / 2;


        int initialRadius = myView.getWidth();

        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                myView.setVisibility(View.INVISIBLE);
            }
        });
        anim.start();
    }

}
