package com.example.myapplication;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class VibratorUtils {
    private static Vibrator vibrator;

    public static void init(Context context) {
        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

    }

    public static void vibrate(long milliseconds) {
        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(milliseconds,VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else{
                vibrator.vibrate(milliseconds);
            }
        }
    }
}
