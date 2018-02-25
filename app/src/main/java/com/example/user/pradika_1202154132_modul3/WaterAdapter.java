package com.example.user.pradika_1202154132_modul3;

/**
 * Created by User- on 2/25/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WaterAdapter extends RecyclerView.Adapter<WaterAdapter.WaterViewHolder> {
    private ArrayList<Air> mWaterData;
    private Context context;

    //adapter yang akan menyiapkan layout
    public WaterAdapter(Context context, ArrayList<Air> waters) {
        this.context = context;
        mWaterData = waters;
    }

    //membuat suatu tampilan dan mengembalikannya
    @Override
    public WaterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WaterViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    //menghubungkan data dengan viewholder
    @Override
    public void onBindViewHolder(WaterViewHolder holder, int position) {
        Air currentWater = mWaterData.get(position);
        holder.bindTo(currentWater);
    }

    //menghitung data yang akan ditampilkan
    @Override
    public int getItemCount() {
        return mWaterData.size();
    }

    class WaterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //deklarasi variable
        private TextView mTitle, mDescription;
        ImageView mWatersImage;
        public WaterViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title);
            mDescription = itemView.findViewById(R.id.subTitle);
            mWatersImage = itemView.findViewById(R.id.watersImage);
            itemView.setOnClickListener(this);
        }

        void bindTo(Air currentWater) {
            mTitle.setText(currentWater.getTitle());
            mDescription.setText(currentWater.getDescpription());
            mWatersImage.setImageResource(currentWater.getImage());
        }

        //membuat intent untuk mnengambil data
        @Override
        public void onClick(View view) {
            Air currentWater = mWaterData.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", currentWater.getTitle());
            intent.putExtra("image", currentWater.getImage());
            intent.putExtra("detail", currentWater.getDetail());
            context.startActivity(intent);
        }
    }
}