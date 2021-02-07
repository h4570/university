package pl.edu.pjwstk.mpr.middleware;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailCheckMiddlewareTest {

    @Test
    public void should_create_class() {
        Middleware middleware = new EmailCheckMiddleware();
        assertThat(middleware).isNotNull();
    }

    @Test
    public void should_discard_bad_email_1() {
        Middleware middleware = new EmailCheckMiddleware();
        var res = middleware.check("user@bad@email.com");
        assertThat(res == true);
    }

    @Test
    public void should_discard_bad_email_2() {
        Middleware middleware = new EmailCheckMiddleware();
        var res = middleware.check("@email.com");
        assertThat(res == true);
    }

    @Test
    public void should_allow_normal_email() {
        Middleware middleware = new EmailCheckMiddleware();
        var res = middleware.check("user123@email.com");
        assertThat(res == true);
    }

}
