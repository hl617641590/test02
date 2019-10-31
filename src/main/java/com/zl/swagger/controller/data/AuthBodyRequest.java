package com.zl.swagger.controller.data;

import javax.validation.constraints.NotBlank;

public class AuthBodyRequest {

    @NotBlank(message = "包名不能为空")
    private String packageName;

    private String macAddress;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
