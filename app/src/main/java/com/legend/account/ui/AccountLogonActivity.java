package com.legend.account.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.legend.R;
import com.legend.account.contract.AccountContract;
import com.legend.account.entity.UserEntity;
import com.legend.account.presenter.AccountPresenter;
import com.library.base.BaseActivity;
import com.utilcode.util.ActivityUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/18 0018
 * @描述：用户登录
 */
public class AccountLogonActivity extends BaseActivity implements AccountContract.AccountView {
    private AccountPresenter accountPresenter;

    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_account_login;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        accountPresenter = new AccountPresenter(this);
    }

    @OnClick({R.id.login})
    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                    return;
                }
                accountPresenter.ckLogin(userName,password);
                break;
        }
    }

    @Override
    public void showResult(UserEntity data) {
        tvResult.setText(data.toString());
        ActivityUtils.finishActivity(this);
    }
}
