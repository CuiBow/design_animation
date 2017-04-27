package com.example.admin.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class OperationalBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        getWindow().setExitTransition(new Explode());

        setContentView(R.layout.activity_operational_behavior);

        final ImageView image_small = (ImageView) findViewById(R.id.image_small);
        image_small.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OperationalBehaviorActivity.this, OperationalBehaviorActivity2.class);
                ActivityOptions options = ActivityOptions
                        .makeSceneTransitionAnimation(OperationalBehaviorActivity.this, image_small, "same_name");
                startActivity(intent, options.toBundle());
            }
        });

//        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,
//                Pair.create(view1, "agreedName1"),
//                Pair.create(view2, "agreedName2"));



    }




}
