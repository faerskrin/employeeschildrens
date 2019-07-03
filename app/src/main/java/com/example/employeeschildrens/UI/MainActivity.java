package com.example.employeeschildrens.UI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.employeeschildrens.App.App;
import com.example.employeeschildrens.Data.Employees;
import com.example.employeeschildrens.R;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lastname_emp)
    EditText lastnameEmp;
    @BindView(R.id.name_emp)
    EditText nameEmp;
    @BindView(R.id.middlename_emp)
    EditText middlenameEmp;
    @BindView(R.id.birthday_emp)
    EditText birthdayEmp;
    @BindView(R.id.position_emp)
    EditText positionEmp;
    @BindView(R.id.button_ok)
    Button buttonOk;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_name)
    TextView toolbarName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        toolbarName.setText("Добавление сотрудника");


    }

    @OnClick(R.id.button_ok)
    public void onViewClicked() {

        if (lastnameEmp.getText().toString().matches("") || nameEmp.getText().toString().matches("") || middlenameEmp.getText().toString().matches("") || birthdayEmp.getText().toString().matches("") || positionEmp.getText().toString().matches("")) {
            Toast.makeText(getBaseContext(), "Заполнены не все поля", Toast.LENGTH_SHORT).show();
        } else {
            App.dmManager.addEmployees(new Employees(UUID.randomUUID(), lastnameEmp.getText().toString(), nameEmp.getText().toString(), middlenameEmp.getText().toString(), birthdayEmp.getText().toString(), positionEmp.getText().toString(), null));
            Intent intent = new Intent(MainActivity.this, EmployeesActivity.class);
            startActivity(intent);
            finish();
        }
    }


}
