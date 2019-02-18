package com.abdur10117.newsviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    private Thread thread2;
    private Thread thread3;

    // Thread thread2,thread3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final ImageView imageView = findViewById(R.id.splash_imageView);

        final TextView textView = findViewById(R.id.textView);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_animation);
        imageView.startAnimation(animation);
        textView.startAnimation(animation);



        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(6000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {




                }
            }
        };
        thread.start();
        tvanim2();


    }

    private void tvanim2() {

        final TextView textView2 = findViewById(R.id.textView2);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_animation);
        textView2.startAnimation(animation);

        thread2 = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {




                }
            }
        };
        tvanim3();
    }

    private void tvanim3() {

        final TextView textView3 = findViewById(R.id.textView3);
        final Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_animation);
        textView3.startAnimation(animation);

        thread3 = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(getApplicationContext(),SplashScreen2.class);

                    startActivity(intent);
                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
                    finish();

                }
            }
        };
        thread3.start();
    }

    public void onStop(){
        super.onStop();
        finish();
    }
}
