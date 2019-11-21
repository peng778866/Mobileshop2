package com.example.mobileshop2.activity;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mobileshop2.R;
import com.example.mobileshop2.common.BaseActivity;
import com.example.mobileshop2.http.ProgressDialogSubscriber;
import com.example.mobileshop2.http.entity.MemberEntity;
import com.example.mobileshop2.http.presenter.MemberPresenter;
import com.example.mobileshop2.utils.SystemCofig;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity{
    @BindView(R.id.et_username)
    EditText et_Username;
    @BindView(R.id.et_pwd)
    EditText et_pwd;
    @Override
    public int getContentViewId(){return R.layout.activity_login;}
    @OnClick(R.id.iv_back)
    void close(){finish();}
    @OnClick(R.id.bt_login)
    void login(){
        String userName=et_Username.getText().toString().trim();
        String pwd=et_pwd.getText().toString().trim();
        if(TextUtils.isEmpty(userName)){
            toastShort("请输入用户名");
            return;
        }
        if(TextUtils.isEmpty(pwd)){
            toastShort("请输入密码");
            return;
        }
        MemberPresenter.login2(new ProgressDialogSubscriber<MemberEntity>(this) {
            @Override
            public void onNext(MemberEntity memberEntity) {
                SystemCofig.setLogin(true);
                toastShort("登陆成功");
                SystemCofig.setLoginUserName(memberEntity.uname);
                SystemCofig.setLoginUserEmail(memberEntity.email);
                SystemCofig.setLoginUserHead(memberEntity.image);
                setResult(RESULT_OK);
                finish();
            }
        },userName,pwd);
    }
}