package com.example.yyl.test2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yyl.test2.service.FileService;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText filepath;
    EditText fileContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fileContext = (EditText)findViewById(R.id.fileContext);
        filepath = (EditText)findViewById(R.id.filename);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new Onclicklistener());
    }
     private final class Onclicklistener implements View.OnClickListener{
        @SuppressLint("WrongConstant")
        @Override
        public void onClick(View v) {
            String path = filepath.getText().toString();
            String context = fileContext.getText().toString();
            FileService service = new FileService(getApplicationContext());
            try{
                service.save(path,context);
                Toast.makeText(MainActivity.this,path + " 保存成功",Toast.LENGTH_LONG).show();
            }catch (Exception e){
                Toast.makeText(MainActivity.this,path + " 保存失败",Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }
    }
}
