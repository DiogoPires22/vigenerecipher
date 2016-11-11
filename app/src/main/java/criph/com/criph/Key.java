package criph.com.criph;

import java.util.regex.Pattern;

/**
 * Created by usuario on 11/11/16.
 */

public class Key {

    private String hash;

    public String getHash() {
        return hash;
    }

    public void setHash(String h) {
        hash = h;
    }

    public Boolean Validate(){
        if(hash==""){
            return false;
        }

        return isAlpha(hash);
    }

    public boolean isAlpha(String name) {
        return name.matches("[a-zA-Z]+");
    }

}
