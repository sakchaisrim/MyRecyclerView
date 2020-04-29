package com.softendev.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.rohit.recycleritemclicksupport.RecyclerItemClickSupport;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<CustomItem> items = new ArrayList<>();
        items.add(new CustomItem(R.drawable.ic_1, "Seiri", "สะสาง"));
        items.add(new CustomItem(R.drawable.ic_2, "Seiton", "สะดวก"));
        items.add(new CustomItem(R.drawable.ic_3, "Seiso", "สะอาด"));
        items.add(new CustomItem(R.drawable.ic_4, "Seiketsu", "สุขลักษณะ"));
        items.add(new CustomItem(R.drawable.ic_5, "Shitsuke", "สร้างนิสัย"));

        CustomAdapter adapter = new CustomAdapter(this, items);
        RecyclerView rcv = (RecyclerView)findViewById(R.id.recyclerView);
        rcv.setAdapter(adapter);
        rcv.setLayoutManager(new LinearLayoutManager(this));
//
//        adapter.setOnClickListener(new CustomAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View item, int position) {
//                String str = items.get(position).textJp;
//                Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
//            }
//        });
        RecyclerItemClickSupport.addTo(rcv).setOnItemClickListener(new RecyclerItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                String str = items.get(position).textJp;
                str += "  -  " + items.get(position).textTh;
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
