package shop.configuration;

import org.springframework.security.web.RedirectStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class NoRedirectStrategy implements RedirectStrategy {
    /**
     * No redirection is required with pure REST
     * @param request
     * @param response
     * @param url
     * @throws IOException
     */
    @Override
    public void sendRedirect(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final String url) throws IOException {}
}
