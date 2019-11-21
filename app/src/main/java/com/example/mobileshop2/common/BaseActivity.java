package com.example.mobileshop2.common;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.mobileshop2.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initView();
        initData();
    }
    protected void initData(){

    }
    protected void initView(){

    }
        public abstract int getContentViewId();
    public void toastShort(String msg){Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();}
    public void toastLong(String msg){Toast.makeText(this,msg,Toast.LENGTH_LONG).show();}

}
