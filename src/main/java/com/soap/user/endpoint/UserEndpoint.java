package com.soap.user.endpoint;

import com.soap.user.generated.*;
import com.soap.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://soap.com/user/schemas";

    @Autowired
    private IUserService userService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {
        System.out.println("ID recibido: " + request.getId());
        GetUserResponse response = new GetUserResponse();
        
        User user = userService.getUserById(request.getId())
            .orElse(createUser(0, "Usuario no encontrado", ""));
            
        response.setUser(user);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllUsersRequest")
    @ResponsePayload
    public GetAllUsersResponse getAllUsers(@RequestPayload GetAllUsersRequest request) {
        GetAllUsersResponse response = new GetAllUsersResponse();
        response.getUsers().addAll(userService.getAllUsers());
        return response;
    }

    private User createUser(int id, String name, String email) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        return user;
    }
}