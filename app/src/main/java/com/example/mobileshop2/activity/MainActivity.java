package com.example.mobileshop2.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobileshop2.R;
import com.example.mobileshop2.R;
import com.example.mobileshop2.common.BaseActivity;
import com.example.mobileshop2.common.BaseFragment;
import com.example.mobileshop2.fragment.NavigationFragment;

public class MainActivity extends BaseActivity {
    @Override
    protected void initView(){
        super.initView();
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.fl_main,new NavigationFragment());
        transaction.commit();

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }
}
