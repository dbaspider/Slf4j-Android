package com.example.sfl4j;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends AppCompatActivity {

    private static final Logger logger = LoggerFactory.getLogger(MainActivity.class);

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        logger.info("MainActivity onCreate");
    }

    private void init() {
        btn1 = findViewById(R.id.btn_test1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logger.info("View onClick id: {}", v.getId());
            }
        });

        btn2 = findViewById(R.id.btn_test2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logger.info("View onClick id: {}, Thread test will begin", v.getId());
                // Thread test
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        logger.info("Thread begin TID = {}", Thread.currentThread().getId());
                        for (int i = 0; i < 10; i++) {
                            logger.debug("count is {} ...", i);
                        }
                        logger.info("Thread end TID = {}", Thread.currentThread().getId());
                    }
                }).start();
            }
        });
    }
}