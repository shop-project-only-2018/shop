package shop.configuration.security;

import org.springframework.security.web.util.matcher.*;

public interface SecurityRouting {
    RequestMatcher UNAUTHORIZED_API_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/sign-in")
    );

    RequestMatcher AUTHORIZED_API_URLS = new AndRequestMatcher(
            new NegatedRequestMatcher(UNAUTHORIZED_API_URLS),
            new OrRequestMatcher(
                    new AntPathRequestMatcher("/api/user/*", "GET")
            )
    );

    RequestMatcher USER_API_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/api/cart/**"),
            new AntPathRequestMatcher("/api/order")
    );

    RequestMatcher ADMIN_API_URLS = new AndRequestMatcher(
//            new NegatedRequestMatcher(USER_API_URLS),
//            new OrRequestMatcher(
//                    new AntPathRequestMatcher("/api/*", "POST"),
//                    new AntPathRequestMatcher("/api/*/*", "PUT"),
//                    new AntPathRequestMatcher("/api/*/*", "DELETE"),
//                    new AntPathRequestMatcher("/api/order/*")
//            )
            new OrRequestMatcher(
                    new AntPathRequestMatcher("/abc/*/*", "DELETE")
            )
    );

    RequestMatcher PROTECTED_URLS = new OrRequestMatcher(
            AUTHORIZED_API_URLS,
            ADMIN_API_URLS,
            USER_API_URLS
    );
}
