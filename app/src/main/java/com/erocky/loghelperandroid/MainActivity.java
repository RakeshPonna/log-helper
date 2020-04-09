package com.erocky.loghelperandroid;

import android.os.Bundle;
import android.view.View;

import com.rocky.loghelper.LogHelper;

import java.util.logging.Level;
import java.util.logging.Logger;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static Logger logger = Logger.getLogger(MainActivity.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogHelper.shareLog(MainActivity.this, null, "This is a LogHelper demo", "This is the optional body text");
            }
        });
        logSomething();
    }

    private void logSomething() {

        if (logger.isLoggable(Level.FINE)) {
            logger.fine("This is a debug log entry");
        }
        logger.info("This is a info log entry");
        logger.warning("This is a warning");
        logger.severe("This is a error");

        try {
            throw new RuntimeException("This is a runtime exception");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        }

        logger.log(Level.WARNING, "this is a formatted {0}", new Object[]{"message"});
        logger.fine("This is a 2nd debug log entry");
    }
}
