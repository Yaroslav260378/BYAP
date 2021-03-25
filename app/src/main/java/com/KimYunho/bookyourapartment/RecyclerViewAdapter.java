package com.KimYunho.bookyourapartment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    String[] title;
    String[] status;
    int[] images;
    Context context;

    public RecyclerViewAdapter(Context ct, String[] s1, String[] s2, int[] img){
        context = ct;
        title = s1;
        status = s2;
        images = img;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(title[position]);
        holder.status.setText(status[position]);
        holder.ap_image.setImageResource(images[position]);

        //обработка нажатия на объект в списке
        holder.homeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ApartmentInfo.class);
                intent.putExtra("title", title[position]);
                intent.putExtra("status", status[position]);
                intent.putExtra("ap_image", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, status;
        ImageView ap_image;
        ConstraintLayout homeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ap_title);
            status = itemView.findViewById(R.id.ap_description);
            ap_image = itemView.findViewById(R.id.ap_image);
            homeLayout = itemView.findViewById(R.id.homeLayout);
        }
    }
}
