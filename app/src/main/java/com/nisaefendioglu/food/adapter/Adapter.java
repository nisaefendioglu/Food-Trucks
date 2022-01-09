package com.nisaefendioglu.food.adapter;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nisaefendioglu.food.DetailActivity;
import com.nisaefendioglu.food.R;
import com.nisaefendioglu.food.model.Meals;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Meals.Items> items;
    private LayoutInflater inflater;

    public Adapter(Context context, List<Meals.Items> items) {
        inflater = LayoutInflater.from(context);
        this.items = items;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Adapter.ViewHolder viewHolder = holder;
        viewHolder.name.setText(items.get(position).getStrMeal());
        viewHolder.desc.setText(items.get(position).getStrInstructions());
        Glide.with(holder.itemView).load(items.get(position).getStrMealThumb()).into(viewHolder.img);
        viewHolder.recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
                intent.setData(Uri.parse(items.get(position).getStrYoutube()));
                v.getContext().startActivity(intent);
            }
        });

        viewHolder.readmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("name", items.get(position).getStrMeal());
                intent.putExtra("desc", items.get(position).getStrInstructions());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

   class  ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name,desc,readmore;
        Button recipe;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);

           img = itemView.findViewById(R.id.img);
           name = itemView.findViewById(R.id.name);
           desc = itemView.findViewById(R.id.desc);
           readmore = itemView.findViewById(R.id.readmore);
           recipe = itemView.findViewById(R.id.recipe);
       }
   }
}
