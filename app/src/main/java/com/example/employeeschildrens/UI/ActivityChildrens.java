package com.example.employeeschildrens.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.employeeschildrens.App.App;
import com.example.employeeschildrens.Data.Childrens;
import com.example.employeeschildrens.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityChildrens extends AppCompatActivity {

    @BindView(R.id.lastname_child)
    EditText lastnameChild;
    @BindView(R.id.name_child)
    EditText nameChild;
    @BindView(R.id.middlename_child)
    EditText middlenameChild;
    @BindView(R.id.birthday_child)
    EditText birthdayChild;
    @BindView(R.id.button_ok)
    Button buttonOk;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_name)
    TextView toolbarName;
    private List<Childrens> mChild = new ArrayList<>();
    private int position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childrens);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        mToolbar.setNavigationIcon(R.drawable.back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbarName.setText("Добавление ребенка");
        Intent intent = getIntent();
        position = intent.getIntExtra("UUID", 0);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(R.id.button_ok)
    public void onViewClicked() {
        if (lastnameChild.getText().toString().matches("") || nameChild.getText().toString().matches("") || middlenameChild.getText().toString().matches("") || birthdayChild.getText().toString().matches("")) {
            Toast.makeText(getBaseContext(), "Заполнены не все поля", Toast.LENGTH_SHORT).show();
        } else {
            mChild.add(new Childrens(lastnameChild.getText().toString(), nameChild.getText().toString(), middlenameChild.getText().toString(), birthdayChild.getText().toString()));
            App.dmManager.setChild(position, mChild);
            finish();
        }
    }
}
