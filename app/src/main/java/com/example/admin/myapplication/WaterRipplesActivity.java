package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.myapplication.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

public class WaterRipplesActivity extends AppCompatActivity {
    private RecyclerView rec;
    private TestAdapter adapter;
    private List<String> musicList=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_ripples);

        rec= (RecyclerView) findViewById(R.id.rec);
        setList();
        setRecSetting();
        setAdapter();

    }


    private void setList()
    {
        for (int i=0;i<20;i++)
        {
            musicList.add((i+1)+"");
        }

    }
    private void setAdapter()
    {
        adapter=new TestAdapter(WaterRipplesActivity.this,R.layout.item,musicList);
        rec.setAdapter(adapter);
    }
    private void setRecSetting()
    {
        LinearLayoutManager line=new LinearLayoutManager(this);
        line.setOrientation(LinearLayoutManager.VERTICAL);
        rec.setLayoutManager(line);
        rec.setItemAnimator(new DefaultItemAnimator());
        //设置分割线
        // rec.addItemDecoration(new DividerItemDecoration(this,R.drawable.divider_bg));
    }
}
