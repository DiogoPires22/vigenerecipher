package criph.com.criph;

/**
 * Created by usuario on 11/11/16.
 */

public class Security {

    static String encrypt(String text, final String key) {
        String res = "";
        //loop for characters in string
        for (int i = 0, j = 0; i < text.length(); i++) {

            //get a character by index
            char c = text.toUpperCase().charAt(i);

            //if character is not alpha return the original character and go to next character
            if (c < 'A' || c > 'Z'){
                res+=c;
                continue;
            }
            /*
                a-A(problem)=0
                a-A(ascII)=65

             */
            int pi=c-65;
            int kj=key.toUpperCase().charAt(j)-65;

            //
            char result=(char)(((pi + kj) % 26)+65);


            // if the character uppercase is equals the original character return uppercase else return lowercase
            res +=text.charAt(i)==c?result:String.valueOf(result).toLowerCase();
            j = ++j % key.length();
        }
        return res;
    }

    static String decrypt(String text, final String key) {
        String res = "";
        //loop for characters in string
        for (int i = 0, j = 0; i < text.length(); i++) {

            //get a character by index
            char c = text.toUpperCase().charAt(i);

            if (c < 'A' || c > 'Z'){
                res+=c;
                continue;
            }

             /*
                a-A(problem)=0
                a-A(ascII)=65

             */
            int pi=c-65;
            int kj=key.toUpperCase().charAt(j)-65;
            int sub=pi - kj;
            int mod=sub % 26;
            //if modules is negative number add 26
            if (mod<0) mod += 26;

            char result=(char)(mod+65);


            // if the character uppercase is equals the original character return uppercase else return lowercase
            res +=text.charAt(i)==c?result:String.valueOf(result).toLowerCase();
            j = ++j % key.length();

//            res += (char)((c - key.charAt(j) + 26) % 26 + 'A');
//            j = ++j % key.length();
        }
        return res;
    }
}
