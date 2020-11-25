package fa.training.restful.controllers;

import fa.training.restful.dto.request.UserLoginRequest;
import fa.training.restful.dto.response.UserLoginResponse;
import fa.training.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("login")
    public UserLoginResponse login(@Valid @RequestBody UserLoginRequest request){
        return userService.checkLoginUser(request);
    }
}
