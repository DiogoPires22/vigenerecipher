package criph.com.criph;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by usuario on 11/11/16.
 *
 *
 *
 * It`s a prototype of repository , simulating a database connection
 */
public class KeyRepository {


    private Context c;
    private SharedPreferences preferences;


    //Keyrepository` constructor , set a application context
    public KeyRepository(Context applicationContext) {
        c=applicationContext;
        preferences= PreferenceManager.getDefaultSharedPreferences(c);
    }


    //this method get a hash
    public Key GetHash(){

        String hashText=preferences.getString("hash","");

        Key k= new Key();
        k.setHash(hashText==null?"":hashText);

        return k;
    }


    public void Add(Key k) {
        preferences.edit().putString("hash",k.getHash()).apply();

    }

}
