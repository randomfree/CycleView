package com.ly.cycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ly.cycleview.cycleViewFlipper.CycleViewflipper;
import com.ly.cycleview.cycleViewpager.CycleViewPager;

/**
 *主要用两种方式实现轮播图
 * 一种是viewpager传统的方式
 * 一种是viewfillter
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] imgs = new String[]{"http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
                "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
                "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
                "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
                "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"};

        CycleViewPager cycleViewPager = (CycleViewPager) findViewById(R.id.cyclerviewpager);
        cycleViewPager.setImages(imgs);
        cycleViewPager.start();

        CycleViewflipper cycleViewflipper = (CycleViewflipper) findViewById(R.id.viewflipper);
        cycleViewflipper.setImages(imgs);
        cycleViewflipper.start();
    }

}
