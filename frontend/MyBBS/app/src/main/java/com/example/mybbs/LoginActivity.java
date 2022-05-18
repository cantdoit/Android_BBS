package com.example.mybbs;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mybbs.databinding.ActivityLoginBinding;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    //private final String id_num = null;
    //private final String password = null;
    private EditText id_num = null;
    private EditText password = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        id_num = binding.editTextTextEmailAddress;
        password = binding.editTextTextPassword;
    }

    public void onClickLogin(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://43.138.74.119:8000/user/login");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    String user_id = id_num.getText().toString();
                    String user_password = password.getText().toString();
                    out.writeBytes("id_num="+user_id+"&password="+user_password);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) response.append(line);
                    Log.d("response", response.toString());
                    //如果登录成功，并且已经点击了“记住密码”，则会保存该密码
//                    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
//                    DialogFragment progressDialog;
                    if (response.toString().equals("login success") ){
                        Message msg = new Message();
                        msg.what = 0;
                        handle.sendMessage(msg);
                    }else if(response.toString().equals("login fail") ){
                        Message msg = new Message();
                        msg.what = 1;
                        handle.sendMessage(msg);
                    }else if(response.toString().equals("not exist") ){
                        Message msg = new Message();
                        msg.what = 2;
                        handle.sendMessage(msg);
                    }
                } catch (MalformedURLException e) {
                    Log.e("error", "url form wrong");
                } catch (IOException e) {
                    Log.e("error", "IOException 1:" + e.getMessage());
                } finally {
                    if (reader != null) {
                        try { reader.close(); }
                        catch (IOException e) { Log.e("error", "IOException 2:" +e.getMessage()); }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    public void onClickRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        String message = id_num.getText().toString();
        intent.putExtra("id_num",message );
        startActivity(intent);
    }

    public void sendRequest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://43.138.74.119:8000/user/login");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    DataOutputStream out = new DataOutputStream(connection.getOutputStream());
                    String user_id = id_num.getText().toString();
                    String user_password = password.getText().toString();
                    out.writeBytes("id_num="+user_id+"&password="+user_password);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) response.append(line);
                    Log.d("response", response.toString());

                    //!!!这是一个极大的错误：在线程里处理不能更新UI，Toast也是不能的
                    //Toast.makeText(LoginActivity.this,response.toString(),Toast.LENGTH_SHORT).show();

                    //如果登录成功，并且已经点击了“记住密码”，则会保存该密码
//                    SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
//                    DialogFragment progressDialog;
                    if (response.toString().equals("login success") ){
                        //关闭等待登录窗口
//                        progressDialog.dismiss();
//                        Message msg = new Message();
//                        msg.what = 0;
//                        handle.sendMessage(msg);

//                        if (rememberPass.isChecked())
//                        {
//                            String ac = id.getText().toString();
//                            String pa = password.getText().toString();
//                            editor.putBoolean("Remember_password", true);
//                            editor.putString("Account", ac);
//                            editor.putString("Password", pa);
//                        }
//                        else
//                        {
//                            editor.clear();
//                        }
//                        editor.apply();
                    }else if(response.toString().equals("login fail") ){
                        //关闭等待登录窗口
//                        progressDialog.dismiss();
                        Message msg = new Message();
                        msg.what = 1;
                        handle.sendMessage(msg);
//                        if (rememberPass.isChecked())
//                        {
//                            String ac = id.getText().toString();
//                            String pa = password.getText().toString();
//                            editor.putBoolean("Remember_password", true);
//                            editor.putString("Account", ac);
//                            editor.putString("Password", pa);
//                        }
//                        else
//                        {
//                            editor.clear();
//                        }
//                        editor.apply();
                    }else if(response.toString().equals("not exist") ){
                        //关闭等待登录窗口
//                        progressDialog.dismiss();
                        Message msg = new Message();
                        msg.what = 2;
                        handle.sendMessage(msg);
//                        if (rememberPass.isChecked())
//                        {
//                            String ac = id.getText().toString();
//                            String pa = password.getText().toString();
//                            editor.putBoolean("Remember_password", true);
//                            editor.putString("Account", ac);
//                            editor.putString("Password", pa);
//                        }
//                        else
//                        {
//                            editor.clear();
//                        }
//                        editor.apply();
                    }
                } catch (MalformedURLException e) {
                    Log.e("error", "url form wrong");
                } catch (IOException e) {
                    Log.e("error", "IOException 1:" + e.getMessage());
                } finally {
                    if (reader != null) {
                        try { reader.close(); }
                        catch (IOException e) { Log.e("error", "IOException 2:" +e.getMessage()); }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Toast.makeText(LoginActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    String message = id_num.getText().toString();
                    intent.putExtra("id_num",message );
                    startActivity(intent);
                    break;
                case 1:
                    Toast.makeText(LoginActivity.this,"密码错误！",Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(LoginActivity.this,"用户不存在！",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

}