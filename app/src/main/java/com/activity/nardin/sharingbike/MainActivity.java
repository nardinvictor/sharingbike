package com.activity.nardin.sharingbike;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;



import sharing.bike.SignIn;
import sharing.bike.New;

public class MainActivity extends AppCompatActivity {
   // private DrawerLayout mDrawerLayout;
    //private ActionBarDrawerToggle mToggle ;
    //private Toolbar mToolbar;
    Button login,btnSignup;
     TextView txtslogan;
    // EditText usernameField,passwordField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         login = (Button) findViewById(R.id.login);
        btnSignup= (Button)findViewById(R.id.up);
        txtslogan = (TextView)findViewById(R.id.txtslogan);



       login.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view ){

            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view ){

            }
        });
       btnSignup.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View w ){
               Intent Sign = new Intent(MainActivity.this,New.class);
               startActivity(Sign);
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view ){

                   // String username = usernameField.getText().toString();
                    //String password = passwordField.getText().toString();

                    Intent log = new Intent(MainActivity.this,SignIn.class);
                    startActivity(log);


            }
        });
    }




}
