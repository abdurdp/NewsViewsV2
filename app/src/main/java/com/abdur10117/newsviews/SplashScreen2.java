package com.abdur10117.newsviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        ImageView imageView = findViewById(R.id.splash_imageView);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_animation);
        imageView.startAnimation(animation);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(getApplicationContext(),SplashScreen3.class);
                    startActivity(intent);

                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                    finish();
                }
            }
        };
        thread.start();
    }
    public void onStop(){
        super.onStop();
        finish();
    }
}
