package com.ra.session5.service.impl;

import com.ra.session5.entity.UserRoleInsert;
import com.ra.session5.model.RoleGrantRequest;
import com.ra.session5.repository.UserRoleRepository;
import com.ra.session5.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private final UserRoleRepository userRoleRepository;

    public RoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public void grantRole(RoleGrantRequest request) {
        List<UserRoleInsert> newRoles = request.getRoles().stream()
                .map(x -> new UserRoleInsert(request.getUserId(), x))
                .collect(Collectors.toList());
        // remove old roles
        userRoleRepository.deleteByUserId(request.getUserId());
        // add new roles
        userRoleRepository.saveAll(newRoles);
    }
}
