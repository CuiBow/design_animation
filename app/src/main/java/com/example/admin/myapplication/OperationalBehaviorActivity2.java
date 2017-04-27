package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class OperationalBehaviorActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operational_behavior2);

        final ImageView image_small = (ImageView) findViewById(R.id.image_large);
        image_small.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OperationalBehaviorActivity2.this.finishAfterTransition();
            }
        });
    }
}
