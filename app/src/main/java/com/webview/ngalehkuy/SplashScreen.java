package com.webview.ngalehkuy;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

		SharedPreferences sharedPreferences;
		Boolean firstTime;
		sharedPreferences = getSharedPreferences("Splash", MODE_PRIVATE);
		firstTime = sharedPreferences.getBoolean("firstTime", true);


		int SPLASH_TIME_OUT = 5000;
		new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
				Intent i;

				if (!firstTime) {
					i = new Intent(SplashScreen.this, MainActivity.class);
				} else {
					i = new Intent(SplashScreen.this, WelcomeActivity.class);
				}

                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
