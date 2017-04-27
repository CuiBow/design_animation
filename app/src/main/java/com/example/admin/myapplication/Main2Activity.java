package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.admin.myapplication.widght.myCircleView;

public class Main2Activity extends AppCompatActivity {
    private myCircleView mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mView= (myCircleView) findViewById(R.id.view);
    }

    public void click(View view)
    {
        mView.startAnimation();
    }
}
