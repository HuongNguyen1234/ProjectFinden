package com.example.projectfinden.com.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.projectfinden.R;
import com.example.projectfinden.com.fragment.FragmentDetailTopic;
import com.example.projectfinden.com.model.Step;
import com.squareup.picasso.Picasso;



import java.util.List;

public class MyAdapter extends PagerAdapter {

    Context context;
    List<Step> stepList;
    LayoutInflater inflater;

    public MyAdapter(FragmentDetailTopic fragmentDetailTopic, List<Step> stepList) {
    }

    public MyAdapter(Context context, List<Step> stepList) {
        this.context = context;
        this.stepList = stepList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return stepList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view.equals(o);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //inflate view
        View view = inflater.inflate(R.layout.view_pager_item,container,false);
        //view
        ImageView movie_image = view.findViewById(R.id.movie_image);
        TextView movie_title = view.findViewById(R.id.movie_title);
        TextView movie_description = view.findViewById(R.id.movie_description);
//        FloatingActionButton btn_fav = view.findViewById(R.id.btn_fav);

        //set date
        Picasso.get().load(stepList.get(position).getImage()).into(movie_image);
        movie_title.setText(stepList.get(position).getDescription());
        movie_description.setText(stepList.get(position).getDescription());

        //event
//        btn_fav.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"Favourite Clicked", Toast.LENGTH_LONG).show();
//
//            }
//        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Movie Clicked", Toast.LENGTH_LONG).show();
            }
        });

        container.addView(view);

        return view;

    }
}
