package pl.edu.pjwstk.mpr.middleware;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ServerStatusMiddlewareTest {

    @Test
    public void should_create_class() {
        Middleware middleware = new ServerStatusMiddleware("192.168.0.5");
        assertThat(middleware).isNotNull();
    }

    @Test
    public void should_allow_prd_server() {
        Middleware middleware = new ServerStatusMiddleware("192.168.0.10");
        var res = middleware.check("user123@email.com");
        assertThat(res == true);
    }

    @Test
    public void should_discard_stg_server() {
        Middleware middleware = new ServerStatusMiddleware("192.168.0.5");
        var res = middleware.check("user123@email.com");
        assertThat(res == false);
    }


}
