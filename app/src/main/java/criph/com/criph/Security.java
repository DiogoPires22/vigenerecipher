package criph.com.criph;

/**
 * Created by usuario on 11/11/16.
 */

public class Security {

    static String encrypt(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z'){
                res+=c;
                continue;
            }
            // ascII A=65 A problem=0 ascii A -65= A prob;em

            int pi=c-65;
            int kj=key.toUpperCase().charAt(j)-65;


            res += (char)(((pi + kj) % 26)+65);
            j = ++j % key.length();
        }
        return res;
    }

    static String decrypt(String text, final String key) {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
}
