package com.webview.ngalehkuy;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.io.IOException;
import java.net.URL;

public class Firebase extends FirebaseMessagingService {
	public void onNewToken(String s) {
		Log.d("TOKEN_REFRESHED ", s);		// printing new tokens in logcat
	}

	public void onMessageReceived(RemoteMessage message) {
		if (message.getNotification() != null) {
			sendMyNotification(message.getNotification().getTitle(), message.getNotification().getBody(), message.getNotification().getClickAction(), message.getData().get("uri"), message.getData().get("img"), message.getData().get("tag"), message.getData().get("nid"));
		}
	}

	private void sendMyNotification(String title, String message, String click_action, String uri, String img, String tag, String nid) {
		//On click of notification it redirect to this Activity
		Intent intent = new Intent(click_action);
		intent.putExtra("uri", uri);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

		int notification_id = nid!=null ? Integer.parseInt(nid) : MainActivity.ASWV_FCM_ID;

		Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, SmartWebView.ASWV_FCM_CHANNEL)
				.setSmallIcon(R.mipmap.ic_launcher)
				.setContentTitle(title)
				.setContentText(message)
				.setAutoCancel(true)
				.setSound(soundUri)
				.setContentIntent(pendingIntent);
		Notification noti = notificationBuilder.build();
		noti.flags = Notification.DEFAULT_LIGHTS | Notification.FLAG_AUTO_CANCEL;

		if (img != null) {
			try {
				URL url_img = new URL(img);
				Bitmap bigPicture = BitmapFactory.decodeStream(url_img.openConnection().getInputStream());
				notificationBuilder.setStyle(
						new NotificationCompat.BigPictureStyle().bigPicture(bigPicture).setSummaryText(message)
				);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			NotificationChannel channel = new NotificationChannel(
					SmartWebView.ASWV_FCM_CHANNEL , MainActivity.asw_fcm_channel, NotificationManager.IMPORTANCE_DEFAULT
			);

			channel.enableLights(true);
			channel.setLightColor(Color.BLUE);
			channel.enableVibration(false);
			channel.setVibrationPattern(new long[] { 100, 200, 300, 400 });
			channel.setShowBadge(true);
			channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
			channel.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION), null);

			assert notificationManager != null;
			notificationManager.createNotificationChannel(channel);
		} else {
			// For Android 7.1 or lower devices:
			notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH)
					.setSound(
							RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
					.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
					.setLights(Color.RED, 0, 1);
		}

		notificationManager.notify(0, notificationBuilder.build());



	}
}
