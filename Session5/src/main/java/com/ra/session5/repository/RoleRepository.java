package com.ra.session5.repository;

import com.ra.session5.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RolesEntity, String> {
}
