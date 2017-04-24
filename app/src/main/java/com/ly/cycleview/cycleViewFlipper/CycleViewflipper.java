package com.ly.cycleview.cycleViewFlipper;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.ly.cycleview.R;

/**
 * Created by txw_pc on 2017/4/24.
 */

public class CycleViewflipper extends ViewFlipper{

    private String[] imgs;
    private Context context;
    private final int FLIPPER_INTERVAL = 2000;
    public CycleViewflipper(Context context) {
        super(context);
        init(context);
    }

    public CycleViewflipper(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        this.context = context;
    }

    public void setImages(String[] imgs){
        //传进来空的啥也不干
        if (imgs==null||imgs.length==0){
            return;
        }
        //如果已经给过一次图片，第二次调用当做换图片处理
        if (this.imgs!=null&&this.imgs.length>0){
            this.removeAllViews();
        }

        this.imgs = imgs;
        for (String url:imgs) {
            ImageView imageView = new ImageView(context);
            Glide.with(context).load(url).into(imageView);
            this.addView(imageView);
        }

    }

    public void start(){
        this.setFlipInterval(FLIPPER_INTERVAL);
        this.startFlipping();
    }
}
