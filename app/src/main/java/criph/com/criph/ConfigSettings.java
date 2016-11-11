package criph.com.criph;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by usuario on 11/11/16.
 */

public  class ConfigSettings {



    private Context c;
    private SharedPreferences preferences;

    public ConfigSettings(Context applicationContext) {
        c=applicationContext;
        preferences= PreferenceManager.getDefaultSharedPreferences(c);
    }

    public  Boolean isFirstTime(){
        SharedPreferences preferences= PreferenceManager.getDefaultSharedPreferences(c);
        String firstTime=preferences.getString("firstTime","");

        return firstTime!=null && firstTime.isEmpty();
    }



    public void setFirstTime(){
        preferences.edit().putString("firstTime","1").apply();
    }
}
