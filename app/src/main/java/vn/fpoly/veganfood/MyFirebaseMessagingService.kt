package vn.fpoly.veganfood

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import vn.fpoly.veganfood.feature.orderStatus.OrderStatusActivity
import vn.fpoly.veganfood.room.TokenDevice
import vn.fpoly.veganfood.room.TokenDeviceDatabase

const val channelId = "notification_channel"
const val channelName = "vn.fpoly.veganfood"

@SuppressLint("MissingFirebaseInstanceTokenRefresh")
class MyFirebaseMessagingService : FirebaseMessagingService() {
    // generate the notification
    // attach the notification created with the custom layout
    // show the notification

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        if (remoteMessage.notification !== null) {
            sendNotification(remoteMessage)
        }
        remoteMessage.notification?.let {
            val intent = Intent()
            intent.putExtra("extra", it.body)
            intent.action = "com.my.app.onMessageReceived"
            sendBroadcast(intent)
        }

    }

    @SuppressLint("RemoteViewLayout")
    private fun getRemoteView(title: String, mess: String): RemoteViews {
        val remoteView = RemoteViews("vn.fpoly.veganfood", R.layout.notification)

        remoteView.setTextViewText(R.id.title, title)
        remoteView.setTextViewText(R.id.description, mess)
        remoteView.setImageViewResource(R.id.app_logo, R.drawable.logo_tocotoco)

        return remoteView
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun sendNotification(remoteMessage: RemoteMessage) {
        val title: String?
        val mess: String?
        if (remoteMessage.notification?.title != null) {
            title = remoteMessage.notification?.title
            mess = remoteMessage.notification?.body
        } else {
            title = remoteMessage.data["title"]
            mess = remoteMessage.data["message"]
        }

        val notificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        var intent: Intent? = null
        intent = Intent(this, OrderStatusActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        // channel id, channel name
        var builder: NotificationCompat.Builder =
            NotificationCompat.Builder(applicationContext, channelId)
                .setSmallIcon(R.drawable.logo_tocotoco)
                .setAutoCancel(true)
                .setVibrate(longArrayOf(0, 1000, 500, 1000))
                .setOnlyAlertOnce(true)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

        builder = builder.setContent(getRemoteView(title!!, mess!!))


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(notificationChannel)
            builder.setChannelId(channelId)
        }
        notificationManager.notify(0, builder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        sendTokenToServer(token)
    }

    private fun sendTokenToServer(token: String) {
        Log.e("TOKEN", "onNewToken: $token")
        val tokenDevice = TokenDevice(token)
        TokenDeviceDatabase.getInstance(applicationContext).tokenDeviceDAO().insertToken(tokenDevice)
    }
}
