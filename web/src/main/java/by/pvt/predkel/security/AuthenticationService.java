package by.pvt.predkel.security;

import by.pvt.predkel.entities.User;
import by.pvt.predkel.exceptions.DaoException;
import by.pvt.predkel.parameters.WebConstants;
import by.pvt.predkel.serviceForDao.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("authenticationService")
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    @Transactional(readOnly = true)
    public CustomUser loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userService.getByLogin(login);
            if (user == null) {
                throw new UsernameNotFoundException(WebConstants.USER_NOT_FOUND);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return new CustomUser(user, true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(WebConstants.ROLE_PREFIX + user.getAccessLevelType().toString()));

//        for (AccessLevel access : user.getAccessLevels()) {
//            authorities.add(new SimpleGrantedAuthority(WebConstants.ROLE_PREFIX + access.getAccessLevelType().toString()));
//        }
        return authorities;
    }
}