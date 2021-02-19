package com.justin761002.invoice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@lombok.Data
@ApiModel("手機條碼歸戶載具查詢")
public class CarrierAggregateResponse {
    @ApiModelProperty(value = "版本號碼", example = "1.0")
    private String v;

    @ApiModelProperty(value = "訊息回應碼", example = "903")
    private String code;

    @ApiModelProperty(value = "以 Base64(HMac-SHA256(UTF8(Serial))) 後的結果", example = "zJmi4y6byURiat1VmH/vZfwNibU=")
    private String hashSerial;

    @ApiModelProperty(value = "系統回應訊息", example = "參數錯誤")
    private String msg;

    @ApiModelProperty(value = "卡別", example = "3J0002")
    private String cardType;

    @ApiModelProperty(value = "手機條碼", example = "/ABC.122")
    private String cardNo;

    @ApiModelProperty("歸戶載具")
    private List<Carrier> carriers;
}
