package com.justin761002.invoice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@lombok.Data
@ApiModel("載具")
public class Carrier {

    @ApiModelProperty(value = "載具類別", example = "1K0001")
    private String carrierType;

    @ApiModelProperty(value = "手機條碼/卡片(載具)隱碼", example = "12a9124C")
    private String carrierId2;

    @ApiModelProperty(value = "載具名稱", example = "悠遊卡")
    private String carrierName;
}
