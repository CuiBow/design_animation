package com.example.admin.myapplication;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class CurveMovementActivity extends AppCompatActivity {
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curve_movement);
        img= (ImageView) findViewById(R.id.img);


        Path path = new Path();
        path.lineTo(500, 200);


        ObjectAnimator mAnimator;
        mAnimator = ObjectAnimator.ofFloat(img, img.X, img.Y, path);
        mAnimator.setDuration(2000);
        mAnimator.start();


    }
}
