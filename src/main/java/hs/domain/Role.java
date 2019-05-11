package hs.domain;

import java.util.List;

/**
 * 角色表
 */
public class Role {
    private String id;
    private String roleName;    //角色名
    private String roleDesc;    //角色描述
    private List<Permission> permissions;   //角色对应的权限 多对多 一个角色可以有多个权限
    private List<UserInfo> users;   //角色对应的用户 一个用户可以被赋予多个角色 一个角色也可以被赋予多个用户

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public void setUsers(List<UserInfo> users) {
        this.users = users;
    }
}
