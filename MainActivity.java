package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //code start
        Button animate=(Button)findViewById(R.id.btn);
       final IntValueStore intValueStore=new IntValueStore();


        animate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView horse=(ImageView)findViewById(R.id.img);
                horse.setImageResource(R.drawable.horse);
                AnimationDrawable runningHorse=(AnimationDrawable)horse.getDrawable();
                runningHorse.start();


            }
        });


        intValueStore.setValListener(new IntValueStore.ValueStoreListener()
        {
            @Override
            public void onChange()
            {
                Toast.makeText(MainActivity.this,"Changed "+intValueStore.val,Toast.LENGTH_LONG).show();
            }
        });


        SystemClock.sleep(7000);
        for(int i=0;i<3;i++) {
            SystemClock.sleep(1000);
            intValueStore.setVal(i);

        }

    }
}
