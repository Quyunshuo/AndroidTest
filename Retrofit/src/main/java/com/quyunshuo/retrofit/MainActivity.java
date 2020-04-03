package com.quyunshuo.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.quyunshuo.retrofit.data.Item;
import com.quyunshuo.retrofit.data.SOAnswersResponse;
import com.quyunshuo.retrofit.data.remote.SOService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SOService mService;
    private AnswersAdapter mAdapter;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService = ApiUtils.getSOService();
        mRecyclerView = findViewById(R.id.recycler);
        mTextView = findViewById(R.id.text);
        mAdapter = new AnswersAdapter(this, new ArrayList<Item>(0), new AnswersAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "Post id is " + id, Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        loadAnswers();
    }

    private void loadAnswers() {
//        mService.getAnswers().enqueue(new Callback<List<SOAnswersResponse>>() {
//            @Override
//            public void onResponse(Call<List<SOAnswersResponse>> call, Response<List<SOAnswersResponse>> response) {
//                if (response.isSuccessful()) {
//                    mAdapter.updateAnswers((List<Item>) response.body().listIterator());
//                } else {
//                    int statusCode = response.code();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<SOAnswersResponse>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "请求失败", Toast.LENGTH_SHORT).show();
//            }
//        });
        mService.getAnswers().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    mTextView.setText(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
