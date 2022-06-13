package com.example.doctorsapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
TextInputEditText names,mobilenumbers,passwords;
String name,mobilenumber,password;
Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        names=findViewById(R.id.name);
        mobilenumbers=findViewById(R.id.number);
        passwords=findViewById(R.id.password);
        signup=findViewById(R.id.signs);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=names.getText().toString();
                mobilenumber=mobilenumbers.getText().toString();
                password=passwords.getText().toString();
                regesternewAccount(name,mobilenumber,password);
            }
        });
       }
    public void  userReg(View view)
    {
        name=names.getText().toString();
        mobilenumber=mobilenumbers.getText().toString();
        password=passwords.getText().toString();
        String method="register";
     //   BackgroundTask backgroundTask=new BackgroundTask(this);
       // backgroundTask.execute(method,name,mobilenumber,password);

    }
    private  void  regesternewAccount(String name,String mobilenumber,String password)
    {
        ProgressDialog progressDialog=new ProgressDialog(SignUpActivity.this);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setTitle("Registering New Account");
        progressDialog.show();
        String loginurl="http://192.168.2.8/register.php";
        StringRequest request=new StringRequest(Request.Method.POST, loginurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Register Succesfull"))
                {
                    progressDialog.dismiss();
                    Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    progressDialog.dismiss();


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Intent intent=new Intent(SignUpActivity.this,MainActivity2.class);
                finish();
                startActivity(intent);

            }
        }){
            @Override
            protected Map<String, String> getParams() {

                HashMap<String,String> param =new HashMap<>();
                param.put("name",name);
                param.put("mobilenumber",mobilenumber);
                param.put("password",password);
                return  param;



            }
        };
        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Signleton.getmInstance(SignUpActivity.this).addToRequestQueue(request);



    }
}