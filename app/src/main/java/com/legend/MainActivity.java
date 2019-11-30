package com.legend;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.legend.account.ui.AccountLogonActivity;
import com.legend.account.ui.DownLoadActivity;
import com.legend.account.ui.UpdateUserHeadActivity;
import com.library.base.BaseActivity;
import com.library.imageload.ImageLoader;
import com.utilcode.util.ActivityUtils;


import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_text)
    TextView tv_text;
    @BindView(R.id.netword_image)
    ImageView netword_image;
    @BindView(R.id.local_image)
    ImageView local_image;


    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }


    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        tv_text.setText("控件绑定示例\n" + tv_text.getText());
        ImageLoader.display(this, netword_image, "http://b-ssl.duitang.com/uploads/item/201709/07/20170907152318_YX2Ax.jpeg");
        ImageLoader.display(this, local_image, R.mipmap.ic_launcher);
    }

    @OnClick({R.id.login, R.id.upload, R.id.download})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                ActivityUtils.startActivity(AccountLogonActivity.class);
                break;
            case R.id.upload:
                ActivityUtils.startActivity(UpdateUserHeadActivity.class);
                break;
            case R.id.download:
                ActivityUtils.startActivity(DownLoadActivity.class);
                break;
        }
    }
}
