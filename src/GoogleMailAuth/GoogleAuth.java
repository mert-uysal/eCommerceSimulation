package GoogleMailAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleAuth {
    public boolean GoogleAuthManager(String email){
        Pattern googlePattern = Pattern.compile("@gmail.com");
        Matcher matcher = googlePattern.matcher(email);
        return matcher.find();
    }
}
