package criph.com.criph;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static criph.com.criph.R.id.msg;

public class EncActivity extends AppCompatActivity {


    private KeyRepository _k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enc);


        Button generate =(Button) findViewById(R.id.generate);
        Button goHome =(Button) findViewById(R.id.goHome);
        final TextView msgText =(TextView) findViewById(R.id.msg);
        final TextView resultText=(TextView) findViewById(R.id.returnText);
        generate.setOnClickListener(new Button.OnClickListener() {
               public void onClick(View v) {
                   _k =new KeyRepository(getApplicationContext());
                    String text=msgText.getText().toString();
//                    String resultText=
                   resultText.setText(Security.encrypt(text,_k.GetHash().getHash()));

               }
        });

        //event for go home button
        goHome.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent i= new Intent(getBaseContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }

}
