package com.dyq.valueanimatordemo;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private Button btn_property_animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_property_animator=findViewById(R.id.btn_property_animator);

        setAnimator();

    }

    private void setAnimator() {
        //1、创建ValueAnimator对象并设置起始值（150，500）
        final ValueAnimator valueAnimator=ValueAnimator.ofInt(btn_property_animator.getLayoutParams().width,500);
        //2、设置动画属性(时长、重复模式、重复次数)
        valueAnimator.setDuration(2000);//动画时长
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);//动画重复模式
        valueAnimator.setRepeatCount(-1);//动画重复次数(-1表示无限循环)
        //3、把每次变化后的属性值赋值给对象的属性
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取动画的当前属性值
                int currentValue= (Integer) animation.getAnimatedValue();
                Log.e(TAG,"每次变化后的属性值currentValue="+currentValue);
                //把当前属性值赋值给对象的属性
                btn_property_animator.getLayoutParams().width=currentValue;
                //刷新视图，实现动画效果
                btn_property_animator.requestLayout();

            }
        });

        //启动动画
        valueAnimator.start();
    }
}
