package com.example.musiccloud.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musiccloud.Activity.PlayNhacActivity;
import com.example.musiccloud.Model.BaiHat;
import com.example.musiccloud.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHolder>{

    Context context;
    ArrayList<BaiHat> baihatArrayList;

    public BaihathotAdapter(Context context, ArrayList<BaiHat> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bai_hat_hot, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baihat = baihatArrayList.get(position);
        holder.txtcasi.setText(baihat.getCaSi());
        holder.txtten.setText(baihat.getTenBaiHat());
        Picasso.get().load(baihat.getHinhBaiHat()).into(holder.imghinh);
    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtten, txtcasi;
        ImageView imghinh, imgluotthich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textviewtenbaihethot);
            txtcasi = itemView.findViewById(R.id.textviewcasibaihathot);
            imghinh = itemView.findViewById(R.id.imageviewbaihathot);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthich);
            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, PlayNhacActivity.class);
                intent.putExtra("cakhuc", baihatArrayList.get( this.getLayoutPosition() ));
                context.startActivity(intent);
            });
        }
    }
}
