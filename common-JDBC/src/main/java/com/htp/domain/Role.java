package com.htp.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

public class Role {

    private Long roleId;
    private Long userId;
    private String roleName;
    private String roleType;

    public Role() {
    }

    public Role(Long roleId, Long userId, String roleName, String roleType) {
        this.roleId = roleId;
        this.userId = userId;
        this.roleName = roleName;
        this.roleType = roleType;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) &&
                Objects.equals(userId, role.userId) &&
                Objects.equals(roleName, role.roleName) &&
                Objects.equals(roleType, role.roleType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleId, userId, roleName, roleType);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
