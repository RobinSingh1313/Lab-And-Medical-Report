package com.example.doctorsapplicationfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
Button textView;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=findViewById(R.id.changepage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,ClickingPhotoActivity.class);
                startActivity(intent);
            }
        });
        //pie chart
        BottomNavigationView bottomNavigationItemView=findViewById(R.id.bottomnav);
        bottomNavigationItemView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,new PieGraph()).commit();


    }
    //Fragments
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener=new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selecteddfragmennt=null;
                    switch (item.getItemId())
                    {
                        case R.id.aboutproduct:
                            selecteddfragmennt=new PieGraph();


                            break;

                        case R.id.delivery:
                            selecteddfragmennt=new BarFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,selecteddfragmennt).commit();
                    return true;
                }
            };

}