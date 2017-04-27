package com.example.admin.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.admin.myapplication.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void WaterRipples(View view)
    {
        Intent intent=new Intent(this,WaterRipplesActivity.class);
        startActivity(intent);
    }
    public void Expose(View view)
    {
        Intent intent=new Intent(this,ExposeActivity.class);
        startActivity(intent);
    }
    public void Operational(View view)
    {
        Intent intent=new Intent(this,OperationalBehaviorActivity.class);
        startActivity(intent);

//        startActivity(intent,
//                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    public void CurveMovement(View view)
    {
        Intent intent=new Intent(this,CurveMovementActivity.class);
        startActivity(intent);
    }

    public void ViewChange(View view)
    {
        Intent intent=new Intent(this,ViewChangeActivity.class);
        startActivity(intent);
    }


}
