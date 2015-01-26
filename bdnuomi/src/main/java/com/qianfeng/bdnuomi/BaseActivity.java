package com.qianfeng.bdnuomi;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;

/**
 * @Package com.qianfeng.bdnuomi
 * @作 用:
 * @创 建 人: zhangwei
 * @日 期: 15/1/26
 * @修 改 人:
 * @日 期:
 */
public class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AppManager.getAppManager().finishActivity();
    }
}
