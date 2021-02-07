package pl.edu.pjwstk.mpr.middleware;

import java.util.ArrayList;

public class BanManagerMiddleware extends Middleware {

    private ArrayList<String> banList;

    public BanManagerMiddleware() {
        banList = new ArrayList<>();
        banList.add("flooder@email.com");
    }

    public boolean check(String email) {
        if (email != null && !isOnBanList(email))
            return checkNext(email);
        return false;
    }

    private boolean isOnBanList(String email) {
        return banList.contains(email.trim().toLowerCase());
    }

}