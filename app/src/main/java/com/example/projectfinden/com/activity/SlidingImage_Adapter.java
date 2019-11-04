package com.example.projectfinden.com.activity;

import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.projectfinden.R;

import java.util.ArrayList;
import java.util.List;

public class SlidingImage_Adapter extends PagerAdapter {
    private List<String> urls= new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;
    private List<String> des= new ArrayList<>();


    public SlidingImage_Adapter(Context context, List<String> urls , List<String> des) {
        this.urls = urls;
        this.context = context;
        this.des = des;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View view1 = inflater.inflate(R.layout.slide_image, view, false);
//        urls.add("https://firebasestorage.googleapis.com/v0/b/projectfinden.appspot.com/o/b1BatTinh.png?alt=media&token=b30a4583-a93b-4608-bb47-3564004f7d9c");
//        des.add("dddddddd");
        assert view1 != null;
        final ImageView imageView = (ImageView) view1
                .findViewById(R.id.image);
        TextView textViewDes= view1.findViewById(R.id.textViewDes);
        textViewDes.setText(des.get(position));
        Glide.with(context)
                .load(urls.get(position))
                .into(imageView);

        view.addView(view1, 0);
        return view1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

}
