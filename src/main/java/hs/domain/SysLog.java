package hs.domain;

import java.util.Date;

/**
 * @Author: huangshun
 * @Date: 2019/5/13 9:13
 * @Version 1.0
 */
public class SysLog {
    private String id;
    private Date visitTime;         //访问的时间
    private String visitTimeStr;    //访问时间的字符串表示
    private String username;        //当前访问的用户名
    private String ip;              //访问的ip
    private String url;             //访问的url
    private Long executionTime;     //访问的时间
    private String method;          //访问的方法

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}