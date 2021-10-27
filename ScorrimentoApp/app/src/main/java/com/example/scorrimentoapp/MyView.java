package com.example.scorrimentoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyView extends PagerAdapter {

    private Context context;
    LayoutInflater inflater;

    public  int []images={R.drawable.cane,R.drawable.bigliettoauguri,R.drawable.download};


    public  MyView(Context context){

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View v=inflater.inflate(R.layout.slide_layout, container, false);
       ImageView imageView=v.findViewById(R.id.imageView);

       imageView.setImageResource(images[position]);

       container.addView(v);

       return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
