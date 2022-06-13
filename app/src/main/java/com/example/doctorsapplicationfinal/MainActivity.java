 package com.example.doctorsapplicationfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

 public class MainActivity extends AppCompatActivity {
     //Declaring Variables
TextInputEditText Username,Password;
Button LoginBtn;
TextView SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Connecting id with my Local Variables
        Intent intents=new Intent(MainActivity.this,ClickingPhotoActivity.class);
        startActivity(intents);
        Username=findViewById(R.id.username);
        Password=findViewById(R.id.password);
        LoginBtn=findViewById(R.id.login);
        SignUp=findViewById(R.id.signup);

   //Checking Username && Password Right or Wrong
        //LoginBtn
        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Creating method

                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                finish();
                startActivity(intent);


                LogiView();

            }
        });
        //SignUpActivity
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
                startActivity(intent);

            }
        });



        //From One Activity To Another Activiy

        //Intent intent=new Intent(this,MainActivity2.class);
      //  startActivity(intent);
    }

     private void validLogin() {
        BackgroundTask backgroundTask=new BackgroundTask(this);
        String usernameDb=null,passwrdDb=null;
        if (Username.equals(usernameDb)&&Password.equals(passwrdDb))
        {
            //if username and password is right go to main page
            Intent intent=new Intent(this,MainActivity2.class);
            startActivity(intent);


        }else
        {
            //if it is wrong then give Toast msg

            Toast.makeText(this,"Wrong Username or Passwrd",Toast.LENGTH_SHORT);

        }

     }
     public void LogiView()
     {
         String username=Username.getText().toString();
         String password=Password.getText().toString();
         String type="login";
         BackgroundTask backgroundTask=new BackgroundTask(this);
         backgroundTask.execute(type,username,password);
     }
 }