package fa.training.restful.service;

import fa.training.restful.dao.custom.JwtGenerator;
import fa.training.restful.dao.entity.User;
import fa.training.restful.dto.request.UserLoginRequest;
import fa.training.restful.dto.response.UserLoginResponse;
import fa.training.restful.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtGenerator jwtGenerator;

    public UserLoginResponse checkLoginUser(UserLoginRequest request){
        User user = userRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (user == null) {
            throw new NullPointerException();
        }
        return new UserLoginResponse(user.getName(), jwtGenerator.returnToken(user));
    }
}
