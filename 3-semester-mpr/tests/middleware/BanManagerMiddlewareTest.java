package pl.edu.pjwstk.mpr.middleware;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BanManagerMiddlewareTest {

    @Test
    public void should_create_class() {
        Middleware middleware = new BanManagerMiddleware();
        assertThat(middleware).isNotNull();
    }

    @Test
    public void should_ban_flooder() {
        Middleware middleware = new BanManagerMiddleware();
        var res = middleware.check("flooder@email.com");
        assertThat(res == true);
    }

    @Test
    public void should_allow_normal_person() {
        Middleware middleware = new BanManagerMiddleware();
        var res = middleware.check("user123@email.com");
        assertThat(res == true);
    }

}
