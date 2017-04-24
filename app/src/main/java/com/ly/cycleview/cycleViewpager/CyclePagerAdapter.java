package com.ly.cycleview.cycleViewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.BitmapTypeRequest;
import com.bumptech.glide.DrawableTypeRequest;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by txw_pc on 2017/4/24.
 * 自动轮播viewpager的适配器
 * 主要思想就是将viewpager的count设置的非常大，在通过%的算法让图片循环返回
 */

public class CyclePagerAdapter extends PagerAdapter{

    private Context context;
    private String[] imgs;
    private List<ImageView> imageViews = new ArrayList<>();
    public CyclePagerAdapter(Context context){
        this.context = context;
    }

    public void setImages(String[] imgs){
        this.imgs = imgs;
        if (this.imgs!=null&&this.imgs.length>0){
            for (String imgUrl : this.imgs) {
                ImageView imageview = new ImageView(context);
                imageview.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                Glide.with(context).load(imgUrl).into(imageview);
                imageViews.add(imageview);
            }
        }
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int index = position%imageViews.size();
        Log.e("main","index==="+index);
        ImageView imageview = imageViews.get(index);
        container.addView(imageview);
        return imageview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
