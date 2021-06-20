package com.user.information.system.pojos;


public class HealthStatus {
    public HealthStatus(int statusCode,String health) {
        this.statusCode = statusCode;
        this.health = health;
    }
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    private int statusCode;
    private String health;
}
