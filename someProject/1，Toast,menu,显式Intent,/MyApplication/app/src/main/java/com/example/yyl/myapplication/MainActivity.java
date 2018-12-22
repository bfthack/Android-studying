package com.example.yyl.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"clicked add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.re_item:
                Toast.makeText(this,"clicked remove",Toast.LENGTH_SHORT).show();
                break;
        default:
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;//false则无法显示菜单
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);//在活动中加载Button01的布局

        /*
        在活动中使用Toast(提醒方式)
        触发点：点击按钮
         */
        final Button button1 = (Button)findViewById(R.id.button01);//根据ID找到BUTTON
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //若是按钮被点击
//                Toast.makeText(MainActivity.this,"you are clicked button 01",
//                        Toast.LENGTH_SHORT).show();
//                //context,text,time
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //上下文，目标活动
                startActivity(intent);//执行Intent
            }
        });

    }


}
