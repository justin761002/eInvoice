package com.justin761002.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class CarrierAggregateRequest {
    String action;
    String appID;
    String cardEncrypt;
    String cardNo;
    String cardType;
    String serial;
    String signature;
    long timeStamp;
    String uuid;
    String version;
}
