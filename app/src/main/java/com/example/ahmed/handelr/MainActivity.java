package com.example.ahmed.handelr;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
ProgressBar progress ;
    Handler hand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
progress= (ProgressBar) findViewById(R.id.progressBar);

        Thread my = new Thread(new bacgroundthread());
        my.start();
hand=new Handler();

    }

    class bacgroundthread implements Runnable {

int i;
        @Override
        public void run() {


            for ( i = 0; i <100 ; i++) {
hand.post(new Runnable() {
                    @Override
                    public void run() {
                        progress.setProgress(i);
                    }
                }

);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
