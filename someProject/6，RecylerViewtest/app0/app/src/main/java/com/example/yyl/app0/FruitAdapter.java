package com.example.yyl.app0;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(), "you clicked image " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public static class MainActivity extends AppCompatActivity {

        private List<Fruit> fruitList = new ArrayList<Fruit>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initFruits();
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            StaggeredGridLayoutManager layoutManager = new
                    StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
            FruitAdapter adapter = new FruitAdapter(fruitList);
            recyclerView.setAdapter(adapter);
        }

        private void initFruits() {
            for (int i = 0; i < 2; i++) {
                Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple_pic);
                fruitList.add(apple);
                Fruit banana = new Fruit(getRandomLengthName("Banana"), R.drawable.banana_pic);
                fruitList.add(banana);
                Fruit orange = new Fruit(getRandomLengthName("Orange"), R.drawable.orange_pic);
                fruitList.add(orange);
                Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.drawable.watermelon_pic);
                fruitList.add(watermelon);
                Fruit pear = new Fruit(getRandomLengthName("Pear"), R.drawable.pear_pic);
                fruitList.add(pear);
                Fruit grape = new Fruit(getRandomLengthName("Grape"), R.drawable.grape_pic);
                fruitList.add(grape);
                Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.drawable.pineapple_pic);
                fruitList.add(pineapple);
                Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"), R.drawable.strawberry_pic);
                fruitList.add(strawberry);
                Fruit cherry = new Fruit(getRandomLengthName("Cherry"), R.drawable.cherry_pic);
                fruitList.add(cherry);
                Fruit mango = new Fruit(getRandomLengthName("Mango"), R.drawable.mango_pic);
                fruitList.add(mango);
            }
        }

        private String getRandomLengthName(String name) {
            Random random = new Random();
            int length = random.nextInt(20) + 1;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                builder.append(name);
            }
            return builder.toString();
        }

    }
}