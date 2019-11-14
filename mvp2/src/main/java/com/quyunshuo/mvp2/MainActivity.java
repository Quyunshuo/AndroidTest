package com.quyunshuo.mvp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.quyunshuo.mvp2.bean.Account;
import com.quyunshuo.mvp2.mvp.IView;
import com.quyunshuo.mvp2.mvp.MvpPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IView {

    private EditText mEditText;
    private TextView mTextView;
    private Button mButton;
    private MvpPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //对P层初始化
        mPresenter = new MvpPresenter(this);
        initView();
    }

    private void initView() {
        mEditText = findViewById(R.id.ed_text);
        mButton = findViewById(R.id.get_btn);
        mTextView = findViewById(R.id.tv);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mPresenter.getData(getUserInput());
    }

    @Override
    public String getUserInput() {
        return mEditText.getText().toString();
    }

    @Override
    public void showSuccessPage(Account account) {
        mTextView.setText("用户账号：" + account.getName() + "\n" + "用户等级：" + account.getGrade());
    }

    @Override
    public void showFailedPage() {
        mTextView.setText("获取数据失败");
    }
}
