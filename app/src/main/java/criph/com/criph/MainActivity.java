package criph.com.criph;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

public class MainActivity extends AppCompatActivity
{

    private Button encButton;
    private Button decButton;
    private Button conButton;
    private ConfigSettings _config;
    private Intent _i=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        _config=new ConfigSettings(getApplicationContext());

        //check if is firstTime, yes:go to config Activity, no:show Home Layout
        if(_config.isFirstTime()){
            _i= new Intent(getBaseContext(),ConfigActivity.class);
            startActivity(_i);
        }else{

            setContentView(R.layout.activity_main);


            encButton= (Button) findViewById(R.id.criptografar);
            decButton= (Button) findViewById(R.id.descriptografar);
            conButton= (Button) findViewById(R.id.configuracao);


            //Buttons Actions
            encButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    changeActivity(v);
                }
            });

            decButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    changeActivity(v);

                }
            });

            conButton.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {

                    changeActivity(v);
                }
            });
        }
    }



    public void changeActivity(View v){


            if(v.equals(encButton)){
                _i= new Intent(getBaseContext(),EncActivity.class);
            }else if(v.equals(decButton)){
                _i= new Intent(getBaseContext(),DecActivity.class);

            }else{
                _i= new Intent(getBaseContext(),ConfigActivity.class);
            }
            startActivity(_i);
    }



}
