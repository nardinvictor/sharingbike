package sharing.bike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.activity.nardin.sharingbike.MapsActivity;
import com.activity.nardin.sharingbike.R;
//import com.activity.nardin.sharingbike.model.User;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;


public class SignIn extends AppCompatActivity {

    EditText editPassword,editPhone;
    Button login1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        editPassword = (EditText)findViewById(R.id.editText2);

        editPhone = (EditText)findViewById(R.id.editText);
        login1 = (Button) findViewById(R.id.login);
        //init firebase
       // final FirebaseDatabase database = FirebaseDatabase.getInstance();
        //final DatabaseReference table_user= database.getReference("User");
       /* login1.setOnClickListener(new View.OnClickListener() {
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
            public void onClick(View w ){
                Intent sss = new Intent(SignIn.this, MapsActivity.class);
                startActivity(sss);
            }
        });


    }

    }



