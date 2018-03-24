package com.farenza.dompet;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView first = findViewById(R.id.TVFIRST);
        TextView second = findViewById(R.id.TVSECOND);
        ImageView logo = findViewById(R.id.IVLOGO);
        ImageView kota = findViewById(R.id.IVKOTA);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        //Absolute Coordinate x,y

        AnimatorSet intro = new AnimatorSet();
        intro.playTogether(
                //Y PROPERTY => fromYposition, toYposition
                ObjectAnimator.ofFloat(kota,"translationY",metrics.heightPixels,0),
                ObjectAnimator.ofFloat(logo,"translationY",-1000,0),
                ObjectAnimator.ofFloat(first,"translationX",-1000,0),
                ObjectAnimator.ofFloat(second,"translationX",1000,0)
        );
        intro.setDuration(3000);
        intro.setInterpolator(new AnticipateOvershootInterpolator());
        intro.start();
        intro.setInterpolator(new AnticipateOvershootInterpolator());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,SignInActivity.class));
                finish();
                overridePendingTransition(R.anim.transition_in_right,R.anim.transition_out_left);
            }
        },5000);
    }
}
