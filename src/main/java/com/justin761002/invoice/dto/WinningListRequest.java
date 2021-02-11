package com.justin761002.invoice.dto;

import org.springframework.beans.factory.annotation.Value;

@lombok.Data
public class WinningListRequest {
    private String action = "QryWinningList";

    private String appId;

    private String invTerm;

    private String UUID;

    private String version = "0.2";
}
