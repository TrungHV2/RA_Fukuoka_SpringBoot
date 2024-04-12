package com.ra.session5.repository;

import com.ra.session5.entity.UserRoleEntity;
import com.ra.session5.entity.UserRoleEntityPK;
import com.ra.session5.entity.UserRoleInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleInsert, UserRoleEntityPK> {
    @Modifying
    @Transactional
    int deleteByUserId(String userId);
}
