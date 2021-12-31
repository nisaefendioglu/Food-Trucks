package com.nisaefendioglu.food.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
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
        viewHolder.youtube.setText(items.get(position).getStrYoutube());
        Glide.with(holder.itemView).load(items.get(position).getStrMealThumb()).into(viewHolder.img);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

   class  ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name,desc,youtube;

       public ViewHolder(@NonNull View itemView) {
           super(itemView);

           img = itemView.findViewById(R.id.img);
           name = itemView.findViewById(R.id.name);
           desc = itemView.findViewById(R.id.desc);
           youtube = itemView.findViewById(R.id.youtube);
       }
   }
}
