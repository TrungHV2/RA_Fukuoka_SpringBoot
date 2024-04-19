package com.ra.session5.api;

import com.ra.session5.model.RoleGrantRequest;
import com.ra.session5.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/roles")
public class RoleApi {
    private final RoleService roleService;

    public RoleApi(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String get() {
        return "ROLE API";
    }

    @PostMapping("/grant")
    public ResponseEntity grant(@RequestBody RoleGrantRequest request) {
        roleService.grantRole(request);
        return ResponseEntity.ok(null);
    }
}
