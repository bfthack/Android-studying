package com.example.yyl.recylerviewtest2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder>{
    private List<Person> mPList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View personview;
        ImageView personImage;
        TextView personName;

        public ViewHolder(View view){
            super(view);
            personview = view;
            personImage = (ImageView) view.findViewById(R.id.person_image);
            personName = (TextView) view.findViewById(R.id.person_name);
        }
    }

    public PersonAdapter(List<Person> personList){
        mPList = personList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_item,viewGroup,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.personview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Person person = mPList.get(position);
                Toast.makeText(v.getContext(),"you have clicked view "+person.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.personImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int pos = holder.getAdapterPosition();
                Person person = mPList.get(pos);
                Toast.makeText(v.getContext(),"you have clicked image" + person.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = mPList.get(position);
        holder.personImage.setImageResource(person.getImageId());
        holder.personName.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return mPList.size();
    }
}