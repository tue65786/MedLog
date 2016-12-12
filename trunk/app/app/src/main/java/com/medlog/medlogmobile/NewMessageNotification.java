package com.medlog.medlogmobile;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Helper class for showing and canceling new message
 * notifications.
 * <p>
 * This class makes heavy use of the {@link NotificationCompat.Builder} helper
 * class to create notifications in a backward-compatible way.
 */
public class NewMessageNotification {
    /**
     * The unique identifier for this type of notification.
     */
    private static final String TAG = "NewMessage";
    private static final String EULATEEXT = " End-User License Agreement\n" +
            "    PLEASE READ THIS END-USER LICENSE AGREEMENT (\"AGREEMENT\") BEFORE SELECTING \"I ACCEPT\" TO OBTAIN ACCESS TO THE SOFTWARE. BY SELECTING \"I ACCEPT\" YOU INDICATE YOUR ACCEPTANCE OF THESE LICENSE TERMS. IF YOU DO NOT AGREE WITH THESE TERMS, YOU SHOULD NOT SELECT \"I ACCEPT.\"\n" +
            "\n" +
            "    1. No Representations or Warranties.\n" +
            "    (i) YOU EXPRESSLY ACKNOWLEDGE AND AGREE THAT USE OF THE LICENSED APPLICATION AND THE SERVICES IS AT YOUR SOLE RISK. TO THE MAXIMUM EXTENT PERMITTED BY APPLICABLE LAW, THE LICENSED APPLICATION AND ANY SERVICES ARE PROVIDED EXCLUSIVELY \"AS IS\" AND “AS AVAILABLE”, WITH ALL FAULTS AND WITHOUT ANY REPRESENTATION OR WARRANTY OF ANY KIND. APPLICATION PROVIDER HEREBY DISCLAIMS ALL REPRESENTATIONS, WARRANTIES AND CONDITIONS WITH RESPECT TO THE LICENSED APPLICATION AND THE SERVICES, EITHER EXPRESS, IMPLIED OR STATUTORY INCLUDING, BUT NOT LIMITED TO, ANY IMPLIED WARRANTIES AND/OR CONDITIONS OF MERCHANTABILITY, QUALITY, FITNESS FOR A PARTICULAR PURPOSE, ACCURACY, CONTINUOUS OPERATION, AND NON-INFRINGEMENT. APPLICATION PROVIDER HEREBY DISCLAIMS ALL LIABILITY AND RESPONSIBILITY ARISING FROM ANY RELIANCE PLACED ON THE LICENSED APPLICATION AND SERVICES BY YOU. APPLICATION PROVIDER ACCEPTS NO RESPONSIBILITY FOR KEEPING THE LICENSED APPLICATION OR SERVICES UP TO DATE OR COMPLETE OR LIABILITY FOR ANY FAILURE TO DO SO. APPLICATION PROVIDER DOES NOT WARRANT THAT ANY DEFECTS IN THE LICENSED APPLICATION OR SERVICES WILL BE CORRECTED. NO ORAL OR WRITTEN INFORMATION OR ADVICE GIVEN BY APPLICATION PROVIDER OR ITS AUTHORIZED REPRESENTATIVES SHALL CREATE ANY WARRANTY. SHOULD THE LICENSED APPLICATION OR SERVICES PROVE DEFECTIVE, YOU ASSUME THE ENTIRE COST OF ALL NECESSARY SERVICING, REPAIR OR CORRECTION.\n" +
            "    (ii)\tYou agree that the fees charged by Application Provider and paid by You are based on and reflective of the allocation of risk contemplated by this section and that the limitations in this section are an essential element of the agreement between You and Application Provider.\n" +
            "    (iii)\tSome jurisdictions do not allow the exclusion of implied warranties or limitations on applicable statutory rights of a consumer, so the above exclusion and limitations may not apply to You.\n" +
            "    2. Use of Licensed Application and Services.\n" +
            "    Use of Licensed Application and Services. You agree that the Licensed Application and Services are designed to be used solely by consumers under medical, physiotherapy or other appropriate medical professional supervision as part of a treatment plan prescribed by a qualified and licensed medical, physiotherapist or other appropriate medical practitioner. You warrant that You will not use, nor shall You permit, the Licensed Application or Services to be used except under such supervision and only as prescribed. The Licensed Application and Services do not constitute the practice of medicine and are neither professional medical nor physiotherapy advice. Moreover, Licensed Application and Services are not designed to be used as a substitute for professional medical or physiotherapy advice or judgment. Due to the large variety of potential applications for the Licensed Application and Services, neither the Services nor the Licensed Application have been tested for all conditions.\n" +
            "    3. Limitation of Liability.\n" +
            "    IN NO EVENT SHALL APPLICATION PROVIDER BE LIABLE FOR ANY PERSONAL INJURY, DEATH OR FOR ANY INCIDENTAL, SPECIAL, INDIRECT, PUNITIVE, EXEMPLARY OR CONSEQUENTIAL DAMAGES WHATSOEVER INCLUDING, WITHOUT LIMITATION, ANY LOST PROFITS, LOSS OF DATA, BUSINESS INTERRUPTION OR ANY OTHER DAMAGES OR LOSSES, ARISING OUT OF OR RELATED TO YOUR USE OR INABILITY TO USE THE LICENSED APPLICATION OR THE SERVICES HOWEVER CAUSED, REGARDLESS OF THE THEORY OF LIABILITY (CONTRACT, TORT OR OTHERWISE) AND EVEN IF APPLICATION PROVIDER HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. SOME JURISDICTIONS DO NOT ALLOW OR RESTRICT THE LIMITATION OF LIABILITY FOR PERSONAL INJURY, DEATH, OR OF INCIDENTAL OR CONSEQUENTIAL DAMAGES, SO THIS LIMITATION MAY NOT APPLY TO YOU. In no event shall Application Provider’s total liability to you for all damages (other than as may be required by applicable law in cases involving personal injury or death) exceed the amount of two hundred dollars (US$200.00). The foregoing limitations will apply even if the above stated remedy fails of its essential purpose.\n" +
            "    4. The Licensed Application together with all intellectual property rights associated therewith or incorporated therein shall at all times remain the exclusive property of Application Provider and its licensors. The Licensed Application is protected by copyright under both United States and foreign laws.\n" +
            "\n" +
            "Copyrights\n" +
            "© 2015 THE GANG THAT COULDNT SHOOT STRAIGHT PC.  All rights reserved.\n" +
            "This documentation and the corresponding Software are the property of GTCSS and are licensed to Users under the terms of the End-User License Agreement. Unauthorized use or copying of the Software, documentation, or any other associated materials is a violation of state and federal laws. These materials must be returned to GTCSS if so demanded.\n" +
            "\n" +
            "[ADDRESS]\n" +
            "1810 Broad Street, Philadelphia, PA 19104-2614";
    public static AlertDialog.Builder  eulaAlert(final Activity mActivity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity)
                .setTitle(" End-User License Agreement")
                .setMessage(EULATEEXT)
                .setPositiveButton(android.R.string.ok, new Dialog.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Mark this version as read.
                        SharedPreferences sp = mActivity.getPreferences(Context.MODE_PRIVATE);


                        SharedPreferences.Editor editor = sp.edit();
                        editor.putBoolean(mActivity.getString(R.string.PREF_EULA), true);
                        editor.commit();
                        dialogInterface.dismiss();
                    }
                })
                .setNegativeButton(android.R.string.cancel, new Dialog.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Close the activity as they have declined the EULA
                        mActivity.finish();
                    }

                });
        return builder;
    }
    /**
     * Shows the notification, or updates a previously shown notification of
     * this type, with the given parameters.
     * <p>
     * TODO: Customize this method's arguments to present relevant content in
     * the notification.
     * <p>
     * TODO: Customize the contents of this method to tweak the behavior and
     * presentation of new message notifications. Make
     * sure to follow the
     * <a href="https://developer.android.com/design/patterns/notifications.html">
     * Notification design guidelines</a> when doing so.
     *
     * @see #cancel(Context)
     */
    public static void notify(final Context context,
                              final String userName, final int number) {
        notify(context, new String[]{userName}, number);
    }

    public static void notify(final Context context,
                              final String exampleString[], final int number) {
        final Resources res = context.getResources();

        // This image is used as the notification's large icon (thumbnail).
        // TODO: Remove this if your notification has no relevant thumbnail.
        final Bitmap picture = BitmapFactory.decodeResource(res, R.drawable.ml);

        final int stringLen = exampleString.length;
        if (stringLen != 4){

        }
        final String userName = exampleString[0];
        final String entries = exampleString[1];
        final String entryTitle = exampleString[2];
        final String entryBody = exampleString[3];
        final String date = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        final String sync = "";
        final String title = res.getString(
                R.string.new_message_notification_title_template, entryTitle);
        final String text = res.getString(
                R.string.new_message_notification_placeholder_text_template, date,userName , entries);

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(context)

                // Set appropriate defaults for the notification light, sound,
                // and vibration.
                .setDefaults(Notification.DEFAULT_ALL)

                // Set required fields, including the small icon, the
                // notification title, and text.
                .setSmallIcon(R.drawable.notification_template_icon_bg)//.ic_stat_new_message)
                .setContentTitle(title)
                .setContentText(text)

                // All fields below this line are optional.

                // Use a default priority (recognized on devices running Android
                // 4.1 or later)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                // Provide a large icon, shown with the notification in the
                // notification drawer on devices running Android 3.0 or later.
                .setLargeIcon(picture)

                // Set ticker text (preview) information for this notification.
                .setTicker(title)

                // Show a number. This is useful when stacking notifications of
                // a single type.
                .setNumber(number)

                // If this notification relates to a past or upcoming event, you
                // should set the relevant time information using the setWhen
                // method below. If this call is omitted, the notification's
                // timestamp will by set to the time at which it was shown.
                // TODO: Call setWhen if this notification relates to a past or
                // upcoming event. The sole argument to this method should be
                // the notification timestamp in milliseconds.
                //.setWhen(...)

                // Set the pending intent to be initiated when the user touches
                // the notification.
                .setContentIntent(
                        PendingIntent.getActivity(
                                context,
                                0,
                                new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.niftybull.com/MedLogRS")),
                                PendingIntent.FLAG_UPDATE_CURRENT))

                // Show expanded text content on devices running Android 4.1 or
                // later.
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(text)
                        .setBigContentTitle(title)
                        .setSummaryText(entryTitle))

                // Example additional actions for this notification. These will
                // only show on devices running Android 4.1 or later, so you
                // should ensure that the activity in this notification's
                // content intent provides access to the same actions in
                // another way.
                .addAction(
                        R.drawable.ic_action_stat_share,
                        res.getString(R.string.action_share),
                        PendingIntent.getActivity(
                                context,
                                0,
                                Intent.createChooser(new Intent(Intent.ACTION_SEND)
                                        .setType("text/plain")
                                        .putExtra(Intent.EXTRA_SUBJECT,title)
                                        .putExtra(Intent.EXTRA_TEXT, date+" : "+entryBody), context.getString(R.string.msg_jrv)),
                                PendingIntent.FLAG_UPDATE_CURRENT))
                .addAction(
                        R.drawable.ic_action_stat_reply,
                        res.getString(R.string.action_reply),
                        null)

                // Automatically dismiss the notification when it is touched.
                .setAutoCancel(true);

        notify(context, builder.build());
    }

    @TargetApi(Build.VERSION_CODES.ECLAIR)
    private static void notify(final Context context, final Notification notification) {
        final NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            nm.notify(TAG, 0, notification);
        } else {
            nm.notify(TAG.hashCode(), notification);
        }
    }

    /**
     * Cancels any notifications of this type previously shown using
     * {@link #notify(Context, String, int)}.
     */
    @TargetApi(Build.VERSION_CODES.ECLAIR)
    public static void cancel(final Context context) {
        final NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR) {
            nm.cancel(TAG, 0);
        } else {
            nm.cancel(TAG.hashCode());
        }
    }
}
