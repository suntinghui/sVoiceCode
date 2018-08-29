package com.sth.vc.model;

public class UserInfoReqModel {

    private String machineCode;
    private String phone;

    public UserInfoReqModel() {

    }

    public UserInfoReqModel(String machineCode, String phone) {
        this.machineCode = machineCode;
        this.phone = phone;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
