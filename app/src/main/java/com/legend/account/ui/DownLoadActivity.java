package com.legend.account.ui;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.legend.R;
import com.library.base.BaseActivity;
import com.library.ihttp.IDownLoad;
import com.library.ihttp.load.download.DownloadCallback;
import com.library.ihttp.model.Download;
import com.utilcode.util.LogUtils;
import com.utilcode.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @创建人: Ailen
 * @创建时间: 2019/10/28 0028
 * @描述：下载示例
 */
public class DownLoadActivity extends BaseActivity {
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.tv_progress)
    TextView tv_progress;
    @BindView(R.id.start)
    TextView start;
    @BindView(R.id.delete)
    TextView delete;
    private   Download downloadEntity;
    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_download;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
         downloadEntity = new Download();
        downloadEntity.setServerUrl("http://dldir1.qq.com/weixin/android/weixin707android1520.apk");
        downloadEntity.setLocalUrl(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath()+"/1.apk");
        downloadEntity.setCallback(new DownloadCallback() {
            @Override
            public void onProgress(Download.State state, long currentSize, long totalSize, float prs) {
                int progressInt = (int) (prs * 100);
                tv_progress.setText(progressInt + "%");
                progress.setProgress(progressInt);
                start.setText(getStateText(state));
            }

            @Override
            public void onError(Throwable e) {
                LogUtils.e("下载失败");
            }

            @Override
            public void onSuccess(Download object) {
                LogUtils.e("下载成功");
            }
        });
    }

    @OnClick({R.id.start, R.id.delete})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
                setStart();
                break;
            case R.id.delete:
                reStartDownload(downloadEntity);
                break;
        }
    }
    
    public void setStart(){
        switch (downloadEntity.getState()) {
            case NONE:
            case PAUSE:
                IDownLoad.get().startDownload(downloadEntity);
                break;
            case WAITING:
            case LOADING:
            case ERROR:
                IDownLoad.get().stopDownload(downloadEntity);
                break;
            case FINISH:
                ToastUtils.showLong( "文件已下载完成");
                break;
        }
    }
    /**
     * 重新下载
     */
    private void reStartDownload(Download bean) {
        IDownLoad.get().removeDownload(bean, true);//移除下载
        IDownLoad.get().startDownload(bean);//开始下载
    }

    /**
     * 状态转换
     * @param state
     * @return
     */
    private String getStateText(Download.State state) {
        String stateText = "下载";
        switch (state) {
            case NONE:
                stateText = "下载";
                break;
            case WAITING:
                stateText = "等待中";
                break;
            case LOADING:
                stateText = "下载中";
                break;
            case PAUSE:
                stateText = "暂停中";
                break;
            case ERROR:
                stateText = "错误";
                break;
            case FINISH:
                stateText = "完成";
                break;
        }
        return stateText;
    }
}
