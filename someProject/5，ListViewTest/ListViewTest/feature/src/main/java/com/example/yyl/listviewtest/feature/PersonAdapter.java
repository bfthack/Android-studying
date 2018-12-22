package com.example.yyl.listviewtest.feature;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<Person> {
    private int resourceId;

    public PersonAdapter(Context context, int textViewResourceId
    , List<Person> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person person = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView personImage = (ImageView) view.findViewById(R.id.person_image);
        TextView personName = (TextView) view.findViewById(R.id.person_name);
        personImage.setImageResource(person.getImageId());
        personName.setText(person.getName());

        return view;
    }
}
