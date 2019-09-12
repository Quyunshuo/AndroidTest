package com.quyunshuo.greendaodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.quyunshuo.greendaodemo.greendao.DaoSession;
import com.quyunshuo.greendaodemo.greendao.StudentDao;
import com.quyunshuo.greendaodemo.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private StudentDao mDaoSession;
    private TextView textView;
    private String TAG = "MiYan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDaoSession = GreenDAOApplication.getDaoSession().getStudentDao();
        initView();
        dbInsert();
        Log.d(TAG, "onCreate: 共有" + dbLoad().size() + "条记录");
        textView.setText(dbLoad().get(0).getName());
        Log.d(TAG, "onCreate: setText");
        dbUpdate();
        Log.d(TAG, "dbUpdate: 更新后的数据Name：" + mDaoSession.load(1L).getName());
    }

    private void initView() {
        textView = findViewById(R.id.text);
    }

    //插入一条数据
    private void dbInsert() {
        mDaoSession.insertOrReplace(new Student(
                0L,
                201714339,
                21,
                "13287066276",
                "男",
                "MiYan",
                "济南市市中区",
                "赤子城",
                "1"));
        mDaoSession.insertOrReplace(new Student(
                1L,
                123456,
                18,
                "132123456789",
                "女",
                "HHH",
                "济南市市中区",
                "赤子城",
                "1"));
        Log.d(TAG, "dbInsert: 插入数据");
    }

    //查询全部
    private List<Student> dbLoad() {
        Log.d(TAG, "dbLoad: 查询全部数据");
        return mDaoSession.loadAll();
    }

    //更新数据
    private void dbUpdate() {
        Student student = dbLoad().get(1);
        student.setName("弥彦");
        mDaoSession.update(student);
    }
}
