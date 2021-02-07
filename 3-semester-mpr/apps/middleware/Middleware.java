package pl.edu.pjwstk.mpr.middleware;


public abstract class Middleware {
    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String email);

    protected boolean checkNext(String email) {
        if (next == null) {
            return true;
        }
        return next.check(email);
    }

}