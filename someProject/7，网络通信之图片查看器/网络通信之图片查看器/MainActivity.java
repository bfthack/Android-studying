package com.example.yyl.httptest.feature;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //    private String textpath = "http://192.168.10.114:8080/ServLogin";
//    private String textpath = "http://www.baidu.com";

    private EditText textpath;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textpath = (EditText)findViewById(R.id.editText1);
        imageView = (ImageView)findViewById(R.id.imgView);
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new Onclicklisten());

    }
    private final class Onclicklisten implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String strpath = textpath.getText().toString();
            try {
                byte[] data = ImageService.getImage(strpath);
                Bitmap bitmap = BitmapFactory.decodeByteArray(data,0,data.length);
                imageView.setImageBitmap(bitmap);//显示图片
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(MainActivity.this,R.string.errogetimg,0).show();
            }

        }
    }

}

