package sharing.bike;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activity.nardin.sharingbike.Contacts;
import com.activity.nardin.sharingbike.MainActivity;
import com.activity.nardin.sharingbike.MapsActivity;
import com.activity.nardin.sharingbike.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class New extends AppCompatActivity {
   // int flag=1;
    EditText Phon, N, Pas, Repas, I, mail;
    Button sb, can;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Pas = (EditText) findViewById(R.id.editPassword);
        Repas = (EditText) findViewById(R.id.editRepassword);
        N = (EditText) findViewById(R.id.editName);
        I = (EditText) findViewById(R.id.editID);
        Phon = (EditText) findViewById(R.id.editPhone);
        mail = (EditText) findViewById(R.id.editEmail);
        sb = (Button) findViewById(R.id.Submit);
        //sb.setOnClickListener((View.OnClickListener) this);
        can = (Button) findViewById(R.id.Cancel);
        //can.setOnClickListener((View.OnClickListener) this);
        progressDialog = new ProgressDialog(this);
       // sb.setOnClickListener(this);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {

                try {
                    String password = Pas.getText().toString();
                    String repas = Repas.getText().toString();
                    String name = N.getText().toString();
                    String id = I.getText().toString();
                    String phone = Phon.getText().toString();
                    String email = mail.getText().toString();
                    if (password.equals("") || name.equals("") || id.equals("") || phone.equals("") || email.equals("") || repas.equals("")) {
                        Toast.makeText(getApplicationContext(), "There is missing information!", Toast.LENGTH_LONG).show();
                    } else {
                        Intent act = new Intent(New.this, MapsActivity.class);
                        startActivity(act);

                    }
                } catch (Exception ex) {

                }
            }

        });
        can.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w ) {
                Intent ttt = new Intent(New.this, MainActivity.class);
                startActivity(ttt);

            }

        });
  /*  }
    private void signup(){

        final String pass = Pas.getText().toString().trim();
        final String repass = Repas.getText().toString().trim();
        final String name = N.getText().toString().trim();
        final String id = I.getText().toString().trim();
        final String phone = Phon.getText().toString().trim();
        final String email = mail.getText().toString().trim();
        progressDialog.setMessage("Registering user...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Contacts.URL_SIGN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject json_array = new JSONObject(response);

                            Toast.makeText(getApplicationContext(), json_array.getString("message"), Toast.LENGTH_LONG).show();
                            if( flag == json_array.getInt("success") ) {
                                Intent sss = new Intent(New.this, MapsActivity.class);
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
                params.put("phone_number", phone);
                params.put("password", pass);
                params.put("confirm_password", repass);
                params.put("name", name);
                params.put("national_ID", id);
                params.put("email", email);
                return params;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
    public void onClick(View view){
        if ( view == sb )
            signup();
    }*/
    }
}