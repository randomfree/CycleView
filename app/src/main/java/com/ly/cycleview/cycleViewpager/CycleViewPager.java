package com.ly.cycleview.cycleViewpager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;

import com.ly.cycleview.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by txw_pc on 2017/4/24.
 * 自动轮播viewpager主要需要完成就是开handler来自动翻页
 *
 */

public class CycleViewPager extends ViewPager{
    private Context context;
    private int pagePosition = 0;
    private final int CYCLE_INTERVAL = 2000;//轮播间隔
    private String[] imgs;
    private Timer timer;
    private TimerTask timerTask;
    private CyclePagerAdapter adapter;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("main","msg.waht==="+msg.what);
            CycleViewPager.this.setCurrentItem(msg.what);
        }
    };

    public CycleViewPager(Context context) {
        super(context);
        init(context);
    }

    public CycleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        this.context = context;
        adapter = new CyclePagerAdapter(context);
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(++pagePosition);
            }
        };
    }
    public void setImages(String[] imgs){
        if (imgs==null||imgs.length==0) return;
        this.imgs = imgs;
        adapter.setImages(imgs);
        this.setAdapter(adapter);
    }

    public void start(){
        if (imgs==null||imgs.length==0) return;
        timer.schedule(timerTask,1000,CYCLE_INTERVAL);
    }



}
