package com.justin761002.invoice.data;

import lombok.Data;

@Data
public class WinningListRequest {
    private String version;
    private String action;
    private String invTerm;
    private String UUID;
    private String appID;
}
