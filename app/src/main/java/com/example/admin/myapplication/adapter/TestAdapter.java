package com.example.admin.myapplication.adapter;

import android.content.Context;

import com.example.admin.myapplication.R;
import com.example.admin.myapplication.baseApdater.RecBaseAdapter;
import com.example.admin.myapplication.baseApdater.ViewHolder;

import java.util.List;

/**
 * Created by Admin on 2016/12/29.
 */

public class TestAdapter extends RecBaseAdapter<String> {
    private Context mContent;
    public TestAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
        mContent=context;
    }

    @Override
    public void convert(ViewHolder holder, String s) {
        holder.setText(R.id.title,s);
    }
}
