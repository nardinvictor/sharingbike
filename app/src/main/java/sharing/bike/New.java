package sharing.bike;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.activity.nardin.sharingbike.MainActivity;
import com.activity.nardin.sharingbike.MapsActivity;
import com.activity.nardin.sharingbike.R;

public class New extends AppCompatActivity {
    EditText Phon, N, Pas, Repas, I, mail;
    Button sb, can;

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
        can= (Button) findViewById(R.id.Cancel);
        //can.setOnClickListener((View.OnClickListener) this);

        sb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View w ) {

                try {
                    String password = Pas.getText().toString();
                    String repas = Repas.getText().toString();
                    String name = N.getText().toString();
                    String id = I.getText().toString();
                    String phone = Phon.getText().toString();
                    String email = mail.getText().toString();
                    if (password.equals("") || name.equals("")|| id.equals("") || phone.equals("") || email.equals("")|| repas.equals("")) {
                        Toast.makeText(getApplicationContext(), "There is missing information!", Toast.LENGTH_LONG).show();
                    }
                        else{
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
    }
}