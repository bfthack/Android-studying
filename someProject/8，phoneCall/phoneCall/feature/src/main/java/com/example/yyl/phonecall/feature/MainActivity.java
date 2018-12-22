package com.example.yyl.phonecall.feature;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.mobile);
        Button button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(new ButtonClickListener());

    }

    private final class ButtonClickListener implements View.OnClickListener {
        public void onClick(View v) {
//            EditText editText = (EditText) findViewById(R.id.mobile);
            String phone = editText.getText().toString();
            Intent intent = new Intent();

            //查看系统自带的call活动，配置参数
            intent.setAction("android.intent.action.CALL");
//            intent.addCategory("android.intent.category.DEFAULT");//不需要
            intent.setData(Uri.parse("tel:" + phone));

            //将意图传给操作系统，激活activity
            startActivity(intent);//方法内部会自动为inent添加类别。android.intent.category.DEFAULT
            //！！！！但是需要申请权限，所以还要到清单文件去注册
// <uses-permission android:name="android.permission.CALL_PHONE"/>

        }
    }

}
