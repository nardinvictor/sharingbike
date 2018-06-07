package sharing.bike;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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


    }
}