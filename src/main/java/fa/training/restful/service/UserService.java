package fa.training.restful.service;

import fa.training.restful.dao.custom.CustomUserDetail;
import fa.training.restful.dao.custom.JwtGenerator;
import fa.training.restful.dao.entity.User;
import fa.training.restful.dto.request.UserLoginRequest;
import fa.training.restful.dto.response.UserLoginResponse;
import fa.training.restful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtGenerator jwtGenerator;
    

    public UserLoginResponse checkLoginUser(UserLoginRequest request){
        User user = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (user == null) {
            throw new UsernameNotFoundException(request.getUsername());
        }
        return new UserLoginResponse(user.getName(), jwtGenerator.returnToken(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetail(user);
    }
}