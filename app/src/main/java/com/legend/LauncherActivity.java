package com.legend;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;

import com.legend.R;
import com.jaeger.library.StatusBarUtil;
import com.library.base.BaseActivity;
import com.library.helper.DialogHelper;
import com.trello.rxlifecycle3.LifecycleProvider;
import com.utilcode.constant.PermissionConstants;
import com.utilcode.util.ActivityUtils;
import com.utilcode.util.PermissionUtils;

import java.util.List;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/16 0016
 * @描述：应用启动页
 */
public class LauncherActivity extends BaseActivity {
    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_launcher;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        PermissionUtils.permission(PermissionConstants.STORAGE)
                .rationale(new PermissionUtils.OnRationaleListener() {
                    @Override
                    public void rationale(final ShouldRequest shouldRequest) {
                        //二次询问 如果有永远拒绝的权限则会执行这里
                        DialogHelper.showRationaleDialog(shouldRequest);
                    }
                })
                .callback(new PermissionUtils.FullCallback() {
                    @Override
                    public void onGranted(List<String> permissionsGranted) {
                        //权限申请成功之后跳转登录页或主页
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                new Thread(){
                                    @Override
                                    public void run() {
                                        ActivityUtils.startActivity(MainActivity.class);
                                        ActivityUtils.finishActivity(LauncherActivity.this);
                                    }
                                }.start();
                            }
                        }, 3000);

                    }

                    @Override
                    public void onDenied(List<String> permissionsDeniedForever,
                                         List<String> permissionsDenied) {
                        if (!permissionsDeniedForever.isEmpty()) {
                            DialogHelper.showOpenAppSettingDialog(new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            });
                        } else {
                            finish();
                        }
                    }
                })
                .request();
    }

    @Override
    public void setStatusBar() {
        super.setStatusBar();
        StatusBarUtil.setTranslucentForImageView(this,0,null);

    }


}
