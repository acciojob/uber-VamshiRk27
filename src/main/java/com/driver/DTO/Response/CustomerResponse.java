package com.driver.DTO.Response;

public class CustomerResponse {
    private Integer customerId;
    private String mobile;

    public CustomerResponse() {
    }

    public CustomerResponse(Integer customerId, String mobile) {
        this.customerId = customerId;
        this.mobile = mobile;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
