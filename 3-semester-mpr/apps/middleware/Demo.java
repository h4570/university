package pl.edu.pjwstk.mpr.middleware;

public class Demo {

    private static Middleware middleware;

    private static void init() {
        middleware = new ServerStatusMiddleware("192.168.0.10");
        middleware.linkWith(new BanManagerMiddleware())
                .linkWith(new EmailCheckMiddleware());
    }

    private static boolean resetEmail(String email) {
        if (middleware.check(email)) return true;
        return false;
    }

    public static void main(String[] args) {
        init();
        if (resetEmail("super@email.com")) {
            System.out.println("Email with password reset sent successfully!");
        } else {
            System.out.println("There was a problem with sending password reset email!");
        }
    }

}
