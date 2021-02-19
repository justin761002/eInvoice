package com.justin761002.invoice.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class WinningListRequest {
    private String action;
    private String appId;
    private String invTerm;
    private String UUID;
    private String version;
}
