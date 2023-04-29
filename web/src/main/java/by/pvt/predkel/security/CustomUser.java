package by.pvt.predkel.security;

import by.pvt.predkel.entities.Building;
import by.pvt.predkel.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class CustomUser extends org.springframework.security.core.userdetails.User {
    private User user;

    public CustomUser(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getLogin(), user.getPassword(), authorities);
        this.user = user;
    }

    public CustomUser(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(user.getLogin(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.user = user;
    }

    public String getUserLogin() {
        return user.getLogin();
    }

    public List<Building> getUserBuildings() {
        return user.getBuilding();
    }

    public Long getUserId() {
        return user.getId();
    }

}
