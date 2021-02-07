package pl.edu.pjwstk.mpr.middleware;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCheckMiddleware extends Middleware {

    public EmailCheckMiddleware() {
    }

    public boolean check(String email) {
        if (isEmailValid(email))
            return checkNext(email);
        return false;
    }

    private boolean isEmailValid(String email) {
        String ePattern =
                "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(email);
        return m.matches();
    }

}