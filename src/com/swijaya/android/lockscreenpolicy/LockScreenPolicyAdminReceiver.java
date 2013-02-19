package com.swijaya.android.lockscreenpolicy;

import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LockScreenPolicyAdminReceiver extends DeviceAdminReceiver {
	
	private static final String TAG = "LockScreenPolicyAdminReceiver";
	
	@Override
	public void onEnabled(Context context, Intent intent) {
		Log.d(TAG, "Device Admin enabled");
	}
	
	@Override
	public void onDisabled(Context context, Intent intent) {
		Log.d(TAG, "Device Admin disabled");
	}
	
	@Override
	public void onPasswordFailed(Context context, Intent intent) {
		Log.d(TAG, "Password failed");
		DevicePolicyManager dpm = (DevicePolicyManager) context.getSystemService(Context.DEVICE_POLICY_SERVICE);
		int numFailedAttempts = dpm.getCurrentFailedPasswordAttempts();
		Log.i(TAG, "Password failed attempts: " + numFailedAttempts);
	}
	
	@Override
	public void onPasswordSucceeded(Context context, Intent intent) {
		Log.d(TAG, "Password succeeded");
	}

}
