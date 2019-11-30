package com.library.helper;
import android.app.Activity;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.library.R;
import com.utilcode.util.ActivityUtils;
import com.utilcode.util.PermissionUtils;
import com.utilcode.util.PermissionUtils.OnRationaleListener.*;
/**
 * @创建人: Ailen
 * @创建时间: 2019/10/16 0016
 * @描述：helper about dialog
 */
public class DialogHelper {
    public static void showRationaleDialog(final ShouldRequest shouldRequest) {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) return;
        new AlertDialog.Builder(topActivity)
                .setTitle(android.R.string.dialog_alert_title)
                .setMessage(R.string.permission_rationale_message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        shouldRequest.again(true);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        shouldRequest.again(false);
                    }
                })
                .setCancelable(false)
                .create()
                .show();

    }

    public static void showOpenAppSettingDialog(DialogInterface.OnClickListener clickListener) {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) return;
        new AlertDialog.Builder(topActivity)
                .setTitle(android.R.string.dialog_alert_title)
                .setMessage(R.string.permission_denied_forever_message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PermissionUtils.launchAppDetailsSettings();
                    }
                })
                .setNegativeButton(android.R.string.cancel, clickListener)
                .setCancelable(false)
                .create()
                .show();
    }
}
