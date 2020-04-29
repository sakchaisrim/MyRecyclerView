package com.softendev.myrecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CustomHolder extends RecyclerView.ViewHolder {
      public ImageView imageView;
      public TextView textViewJp;
      public TextView textViewTh;

      public CustomHolder(View convertView) {
            super(convertView);
            imageView = (ImageView)convertView.findViewById(R.id.imageView);
            textViewJp = (TextView)convertView.findViewById(R.id.textView_jp);
            textViewTh = (TextView)convertView.findViewById(R.id.textView_th);
      }
}
