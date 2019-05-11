package hs.domain;

import java.util.List;

/**
 * 权限表
 */
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    private List<Role> roles;   //权限对应的角色  一个权限可以被赋予多个角色 一个角色可以被赋予多个权限

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
