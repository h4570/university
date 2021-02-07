package pl.edu.pjwstk.mpr.middleware;

public class ServerStatusMiddleware extends Middleware {

    private String ip;

    public ServerStatusMiddleware(String ip) {
        this.ip = ip;
    }

    public boolean check(String email) {
        if (isServerOnline() && getServerVersion().equals("PRD"))
            return checkNext(email);
        return false;
    }

    private boolean isServerOnline() {
        if (ping(this.ip)) return true;
        return false;
    }

    private String getServerVersion() {
        if (this.isIpLengthOk() && this.ip.substring(this.ip.length() - 2).equals("10"))
            return "PRD";
        return "STG";
    }

    private boolean isIpLengthOk() {
        return this.ip.length() > 10;
    }

    private boolean ping(String ip) {
        return true;
    }

}