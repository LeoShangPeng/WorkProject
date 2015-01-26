package com.qianfeng.workproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.sql.SQLOutput;


public class MainActivity extends ActionBarActivity {
    public static String BEIYUN = "http://android.mengbaby.com/zhidao/index?v=1.0&urid=24221&page=1&token=H9q2drNf1t7KOzs9xVGSeN2PT4XLJVS5bCY3KJbwdTw&connectnet=wifi&mac=98%3Aff%3Ad0%3A89%3A30%3A37&zcid=128&udid=862326025366317&lang=zh&ctid=1001&dist=10";
    private ListView listView;
    private BitmapUtils bitmapUtils;

    /**
     *listview 设置监听  属性  adapter
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtils utils = new HttpUtils();
    }


}
