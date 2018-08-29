package com.sth.vc.model;

public class LoginReqModel {

    private String machineCode;
    private String phone;
    private String code;

    public LoginReqModel() {

    }

    public LoginReqModel(String machineCode, String phone, String code) {
        this.machineCode = machineCode;
        this.phone = phone;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
