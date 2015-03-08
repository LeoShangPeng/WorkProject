package com.qianfeng.mgp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qianfeng.mgp.R;

/**
 * 游戏礼包界面
 */
public class GameBagFragment extends Fragment {
    public GameBagFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_bag, container, false);
    }


}
