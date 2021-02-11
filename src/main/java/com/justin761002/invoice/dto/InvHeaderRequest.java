package com.justin761002.invoice.dto;

@lombok.Data
public class InvHeaderRequest {
    private String version;
    private String type;
    private String invNum;
    private String action;
    private String generation;
    private String invDate;
    private String uuid;
    private String appId;
}
