package com.example.employeeschildrens.UI;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.employeeschildrens.App.App;
import com.example.employeeschildrens.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeesActivity extends AppCompatActivity implements AdapterEmployees.OnitemClick, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.recyc)
    RecyclerView mRecyc;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    AdapterEmployees mAdapter = new AdapterEmployees();
    @BindView(R.id.refresh)
    SwipeRefreshLayout mRefresh;
    @BindView(R.id.toolbar_name)
    TextView toolbarName;

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setMessage("Вы уверены что хотите выйти ?")
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                })
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.refresh();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        toolbarName.setText("Список сотрудников");
        mRefresh.setOnRefreshListener(this);
        mRefresh.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE);
        mRecyc.setLayoutManager(new LinearLayoutManager(this));
        mAdapter.setmEmployees(App.dmManager.getmEmployees());
        mAdapter.refresh();
        mAdapter.setOnitemClick(this);

        mRecyc.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.deletecash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_emp: {
                Intent intent = new Intent(EmployeesActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void addChild(int position) {
        Intent intent = new Intent(EmployeesActivity.this, ActivityChildrens.class);
        intent.putExtra("UUID", position);
        startActivity(intent);

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.refresh();
                mRefresh.setRefreshing(false);
            }
        }, 2000);
    }
}
