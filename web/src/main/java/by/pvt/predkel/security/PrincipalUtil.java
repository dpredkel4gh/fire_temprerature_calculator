package by.pvt.predkel.security;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.parameters.Attributes;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class PrincipalUtil {

    public User getPrincipal() {
        User user = new User();
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof CustomUser) {
            user.setId(((CustomUser) principal).getUserId());
            user.setLogin(((CustomUser) principal).getUserLogin());
        } else {
            user = new User();
            user.setLogin(Attributes.ANONYMOUS_USER);
        }
        return user;
    }
}