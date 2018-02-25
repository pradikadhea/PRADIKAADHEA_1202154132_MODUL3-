package com.example.user.pradika_1202154132_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private ArrayList<Air> mWaterData;
    private WaterAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecycleView = findViewById(R.id.recyclerview);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        mRecycleView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        mWaterData = new ArrayList<>();
        mAdapter = new WaterAdapter(this, mWaterData);
        mRecycleView.setAdapter(mAdapter);

        initializeData();
        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, swipeDirs) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(mWaterData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mWaterData.remove(viewHolder.getAdapterPosition());
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        helper.attachToRecyclerView(mRecycleView);
    }

    private void initializeData() {

        TypedArray watersImageRes = getResources().obtainTypedArray(R.array.water_images);
        String[] watersList = getResources().getStringArray(R.array.water_images);
        mWaterData.clear();

        for(int i=0;i<watersList.length;i++){
            String[] judul = {"Aqua", "Cleo", "Amidis", "Ades", "Vit", "Le Minerale",
                    "Nestle", "Equil", "Pristine", "Club", "Evian"};
            mWaterData.add(new Air(judul[i], "Ini adalah air minum merk "+judul[i], "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Pellentesque accumsan laoreet diam in viverra. Etiam consequat quis ligula id gravida." +
                    " Sed sed maximus nulla. Nunc pulvinar cursus justo eu luctus. Pellentesque pellentesque" +
                    " velit ut tortor imperdiet congue. Proin quam velit, luctus nec placerat eu, vehicula nec sapien. " +
                    "Vestibulum dapibus dictum dapibus. Sed a ipsum vel lectus pharetra auctor. " +
                    "Nam vel arcu quis orci elementum commodo. Duis luctus, risus in faucibus dapibus, diam augue " +
                    "feugiat enim, et eleifend libero augue ac massa.",
                    watersImageRes.getResourceId(i,0)));
        }
        watersImageRes.recycle();
        mAdapter.notifyDataSetChanged();
    }
}