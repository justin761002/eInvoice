package com.justin761002.invoice.dto;

@lombok.Data
public class CarrierAggregate {
    String version;
    String serial;
    String action;
    String cardType;
    String cardNo;
    String cardEncrypt;
    String appID;
    long timeStamp;
    String uuid;
    String signature;
}
