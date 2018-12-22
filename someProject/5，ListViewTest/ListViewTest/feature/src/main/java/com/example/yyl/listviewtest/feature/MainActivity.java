package com.example.yyl.listviewtest.feature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPersons();//初始化水果数据
        PersonAdapter adapter = new PersonAdapter(MainActivity.this,R.layout.person_item,personList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person person = personList.get(position);
                Toast.makeText(MainActivity.this, person.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initPersons(){
        for (int i = 0;i < 2;i++){
            Person p1 = new Person("p1",R.drawable.p1);
            personList.add(p1);

            Person p2 = new Person("p2",R.drawable.p2);
            personList.add(p2);

            Person p3 = new Person("p3",R.drawable.p3);
            personList.add(p3);

            Person p4 = new Person("p4",R.drawable.p4);
            personList.add(p4);

            Person p5 = new Person("p5",R.drawable.p5);
            personList.add(p5);

            Person p6 = new Person("p6",R.drawable.p6);
            personList.add(p6);

            Person p7 = new Person("p7",R.drawable.p7);
            personList.add(p7);

            Person p8 = new Person("p8",R.drawable.p8);
            personList.add(p8);

        }
    }
}
