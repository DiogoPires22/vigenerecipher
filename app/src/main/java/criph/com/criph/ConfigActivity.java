package criph.com.criph;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class ConfigActivity extends AppCompatActivity {


    private KeyRepository _r;
    private ConfigSettings _config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        _config=new ConfigSettings(getApplicationContext());
        //change status if a first time
        if(_config.isFirstTime())
            _config.setFirstTime();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);


        //bind a alter button
        final Button alterButton = (Button) findViewById(R.id.alterButton);
        final EditText key = (EditText) findViewById(R.id.key);


        //instance of key repository
        _r = new KeyRepository(this.getApplicationContext());


        final Key hash=_r.GetHash();

        key.setText(hash.getHash());
        //create a listener for alter Button click
        alterButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                hash.setHash(key.getText().toString());

                if(hash.Validate()){
                    _r.Add(hash);

                    Intent i= new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Chave Inválida!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }


}

