package by.pvt.predkel.security;

import by.pvt.predkel.parameters.Path;
import by.pvt.predkel.parameters.WebConstants;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    private Logger logger = Logger.getLogger(this.getClass());
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private MessageSource messageSource;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException {
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request,
                          HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            logger.info(WebConstants.UNABLE_TO_REDIRECT + targetUrl);
            return;
        }
//        request.getSession().setAttribute("errorLoginOrPassword", messageSource.getMessage("message.loginerror", null, request.getLocale()));
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        boolean isClient = false;
        boolean isAdmin = false;
        boolean isSuperAdmin = false;
        String pagePath;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals(WebConstants.ROLE_USER)) {
                isClient = true;
                break;
            } else if (grantedAuthority.getAuthority().equals(WebConstants.ROLE_ADMIN)) {
                isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals(WebConstants.ROLE_SUPER_ADMIN)) {
                isSuperAdmin = true;
                break;
            }
        }

        if (isClient || isAdmin || isSuperAdmin) {
            pagePath = "/" + Path.FUNCTIONS_PATH;
        } else {
            pagePath = /*"/" + */Path.INDEX_PATH;
        }
        return pagePath;
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session;
        session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}