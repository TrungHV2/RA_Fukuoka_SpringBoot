package com.ra.session5.service;

import com.ra.session5.entity.UsersEntity;
import com.ra.session5.model.TokenRequest;

public interface UserService {
    UsersEntity add(TokenRequest request);
}
