package com.example.yyl.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                //上下文，目标活动
//                startActivity(intent);//执行Intent
                startActivityForResult(intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //数据源，数据结果，data
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String result_data = data.getStringExtra("data_return");

                    Toast.makeText(MainActivity.this, result_data, Toast.LENGTH_LONG).show();//Toast显示
                    Log.d("MainActiity",result_data);
                }
        }
    }
}
