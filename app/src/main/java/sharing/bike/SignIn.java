package sharing.bike;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.activity.nardin.sharingbike.Contacts;
import com.activity.nardin.sharingbike.MapsActivity;
import com.activity.nardin.sharingbike.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
//import com.activity.nardin.sharingbike.model.User;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity  {

    EditText editPassword,editPhone;
    Button login1;
    ProgressDialog progressDialog;
    //int current=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPassword = (EditText)findViewById(R.id.editText2);

        editPhone = (EditText)findViewById(R.id.editText);
        login1 = (Button) findViewById(R.id.login);
       progressDialog = new ProgressDialog(this);
      // login1.setOnClickListener(this);
        //init firebase
       // final FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference table_user= database.getReference("User");
       /*login1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please Waiting...");
                mDialog.show();*/

               // table_user.addValueEventListener(new ValueEventListener(){
                    /*@Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //check if user not exist in database
                        if (dataSnapshot.child(editPhone.getText().toString()).exists()) {
                            //get user information
                            mDialog.dismiss();

                            User user = dataSnapshot.child(editPhone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(editPassword.getText().toString())) {
                                Toast.makeText(SignIn.this, "Sign in Successfully !", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(SignIn.this, "Sign in Failed !", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this, "User not exist in database ", Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError){

                    }
                });*/
       //     }
        //});
       login1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w ) {

                try {
                    String str = editPhone.getText().toString();
                    String st1 = editPassword.getText().toString();
                    if (str.equals("01234567890") && st1.equals("Nardin")) {
                        Intent sss = new Intent(SignIn.this, MapsActivity.class);
                        startActivity(sss);
                    } else {

                        Toast.makeText(getApplicationContext(), "There is incorrect information!", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {

                }
            }

        });


    }
   /* private void register(){

        final String str = editPhone.getText().toString().trim();
        final String st1 = editPassword.getText().toString().trim();
       progressDialog.setMessage("Registering user...");
       progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Contacts.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject json_array = new JSONObject(response);

                            Toast.makeText(getApplicationContext(), json_array.getString("message"), Toast.LENGTH_LONG).show();
                            if( current == json_array.getInt("success") ) {
                                Intent sss = new Intent(SignIn.this, MapsActivity.class);
                                startActivity(sss);
                            }


                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    progressDialog.hide();
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("phone_number", str);
                params.put("password", st1);
                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    public void onClick(View view){
        if ( view == login1 )
            register();
    }*/
    }





