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
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import org.androidannotations.annotations.EActivity;

import java.sql.SQLOutput;

@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {
    public static String BEIYUN = "http://api.idothing.com/zhongzi/v2.php/Habit/getList";
    private ListView listView;
    private BitmapUtils bitmapUtils;
    /**
     * listview 设置监听  属性  adapter
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtils utils = new HttpUtils();
        RequestParams params = new RequestParams();
        params.addBodyParameter("user_id", "94347");
        params.addBodyParameter("appid", "100");
        utils.send(HttpRequest.HttpMethod.POST, BEIYUN, params, new RequestCallBack<Object>() {
            @Override
            public void onSuccess(ResponseInfo<Object> responseInfo) {
                System.out.println(responseInfo.result.toString());
            }

            @Override
            public void onFailure(HttpException error, String msg) {
            }
        });

    }


}
