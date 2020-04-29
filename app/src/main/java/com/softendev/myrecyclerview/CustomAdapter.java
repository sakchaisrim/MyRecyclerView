package com.softendev.myrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomHolder> {
      private Context mContext;
      private List<CustomItem> mItems;

      public CustomAdapter(Context context, List<CustomItem> items) {  //กำหนดเป็น ArrayList เหมือนเดิมก็ได้
            mContext = context;
            mItems = items;
      }

      public interface OnItemClickListener {
            void onItemClick(View item, int position);
      }

      private OnItemClickListener mListener;

      public void setOnClickListener(OnItemClickListener listener) {
            mListener = listener;
      }


      @Override
      public int getItemCount() {
            return mItems.size();
      }

      @Override
      public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            final View view = inflater.inflate(R.layout.custom_layout, parent, false);
            final CustomHolder vHolder = new CustomHolder(view);

            /*
            view.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        int pos = vHolder.getAdapterPosition();
                        String str = vHolder.textViewJp.getText().toString();
                        str += "  :  " + vHolder.textViewTh.getText().toString();
                        if(pos != RecyclerView.NO_POSITION) {
                              Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();
                        }
                  }
            });
            */

            view.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                        if(mListener != null) {
                              int pos = vHolder.getAdapterPosition();
                              if(pos != RecyclerView.NO_POSITION) {
                                    mListener.onItemClick(view, pos);
                              }
                        }
                  }
            });

            return vHolder;
      }

      @Override
      public void onBindViewHolder(CustomHolder vHolder, int position) {
            CustomItem item = mItems.get(position);
            vHolder.imageView.setImageResource(item.imgId);
            vHolder.textViewJp.setText(item.textJp);
            vHolder.textViewTh.setText(item.textTh);
      }
}
