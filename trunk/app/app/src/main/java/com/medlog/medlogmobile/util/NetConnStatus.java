package com.medlog.medlogmobile.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by Dan on 11/20/2016.
 */

public class NetConnStatus {
    private static NetConnStatus instance = new NetConnStatus();
    private static Context context;
    private ConnectivityManager connectivityManager;
//    NetworkInfo networkWifi, mobileInfo;
    private boolean connFound = false;

    public static NetConnStatus getInstance(Context ctx) {
        setContext(ctx.getApplicationContext());
        return getInstance();
    }

    public static NetConnStatus getInstance() {
        return instance;
    }

    public static void setInstance(NetConnStatus instance) {
        NetConnStatus.instance = instance;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        NetConnStatus.context = context;
    }

    public boolean isOnline() {
        try {
            setConnectivityManager((ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE));
            NetworkInfo networkInfo = getConnectivityManager().getActiveNetworkInfo();
            setConnFound(networkInfo != null && networkInfo.isAvailable() &&
                    networkInfo.isConnected());
            return isConnFound();
        } catch (Exception e) {
            Log.w("NET", e.toString(), e);
        }
        return isConnFound();
    }

    protected ConnectivityManager getConnectivityManager() {
        return connectivityManager;
    }

    protected void setConnectivityManager(ConnectivityManager connectivityManager) {
        this.connectivityManager = connectivityManager;
    }

    public boolean isConnFound() {
        return connFound;
    }

    protected void setConnFound(boolean connFound) {
        this.connFound = connFound;
    }
}
