package com.rocky.loghelper;

import java.util.logging.Level;
import java.util.logging.Logger;

import androidx.annotation.NonNull;


public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static Logger logger = Logger.getLogger(UncaughtExceptionHandler.class.getName());

    private Thread.UncaughtExceptionHandler oldUncaughtExceptionHandler;

    public UncaughtExceptionHandler() {
    }

    UncaughtExceptionHandler(Thread.UncaughtExceptionHandler oldUncaughtExceptionHandler) {
        this.oldUncaughtExceptionHandler = oldUncaughtExceptionHandler;
    }

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        logger.log(Level.SEVERE, throwable.getMessage(), throwable);
        if (oldUncaughtExceptionHandler != null) {
            oldUncaughtExceptionHandler.uncaughtException(thread, throwable);
        }
    }
}