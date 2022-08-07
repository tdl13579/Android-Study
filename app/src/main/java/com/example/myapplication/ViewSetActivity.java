package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.utils.Utils;

public class ViewSetActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_set);
        TextView text = findViewById(R.id.text);
        // 获取text的布局参数
        ViewGroup.LayoutParams params = text.getLayoutParams();
        // 修改他的宽度 这里的单位是px ,要转化为设置好的dp转化为px
        params.width = Utils.dip2x(this,500);
        params.height = Utils.dip2x(this,200);
        text.setLayoutParams(params);
        text.setOnClickListener(this);
    }
//    private var MyBinder;
//    // 定义内部类
//    inner class MyBinder: Binder{
//
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text:
                Intent intent = new Intent();
                // 设置意图准备拨号
                intent.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse("tel:"+"1451435");
                intent.setData(uri);
                startActivity(intent);
                Toast.makeText(this,"text",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}