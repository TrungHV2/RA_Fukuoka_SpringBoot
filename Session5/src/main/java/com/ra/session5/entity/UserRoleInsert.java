package com.ra.session5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_role")
@IdClass(UserRoleEntityPK.class)
public class UserRoleInsert {
    @Id
    @Column(name = "userId", nullable = false, length = 36)
    private String userId;
    @Id
    @Column(name = "roleId", nullable = false, length = 36)
    private String roleId;

    public UserRoleInsert() {
    }

    public UserRoleInsert(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }
}
