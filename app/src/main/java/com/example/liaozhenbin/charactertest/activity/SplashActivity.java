package com.example.liaozhenbin.charactertest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.liaozhenbin.charactertest.R;

public class SplashActivity extends Activity {
    private ImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        splash = (ImageView) findViewById(R.id.splash_image);

        //透明动画
        AlphaAnimation alpha = new AlphaAnimation(0,1);
        alpha.setDuration(1000);

        //旋转动画
        RotateAnimation rotate = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5F,
                RotateAnimation.RELATIVE_TO_SELF, 0.5F);
        rotate.setDuration(1000);

        //缩放动画
        ScaleAnimation scale = new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5F,
                ScaleAnimation.RELATIVE_TO_SELF,0.5F);
        scale.setDuration(1000);

        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(1200);
        animationSet.addAnimation(alpha);
        animationSet.addAnimation(rotate);
        animationSet.addAnimation(scale);

        final Long start = System.currentTimeMillis();
        splash.startAnimation(animationSet);
        final Long end = System.currentTimeMillis();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if ((end-start)< 2500){
                    try {
                        Thread.sleep(2500-(end-start));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        startActivity(new Intent(SplashActivity.this,MainActivity.class));
                        finish();
                    }
                }
            }
        }
        ).start();
    }
}
