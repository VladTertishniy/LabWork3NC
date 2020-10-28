package edu.sumdu.labwork3.details;

import edu.sumdu.labwork3.model.User;
import edu.sumdu.labwork3.service.UserRoleService;
import edu.sumdu.labwork3.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final UserRoleService userRoleService;
    final static Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);

    public UserDetailsServiceImpl(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        return new UserDetailsImpl(userRoleService, user);
    }
}
