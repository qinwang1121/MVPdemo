package com.ningya.mvpdemo.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ningya.mvpdemo.MainActivity;
import com.ningya.mvpdemo.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText userName, passWord;
    private Button Enter;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progressBar);
        userName = findViewById(R.id.userName);
        passWord = findViewById(R.id.passWord);
        Enter =findViewById(R.id.button);
        Enter.setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        userName.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        passWord.setError(getString(R.string.password_error));
    }

    @Override
    public void setUserError() {
        Toast.makeText(this,
                "密码或用户名错误",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this,
                MainActivity.class));
//        finish();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(userName.getText().toString(),
                passWord.getText().toString());
    }
}