package com.justin761002.invoice.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@lombok.Data
@ApiModel("查詢中獎發票號碼清單")
public class WinningListResponse {
    @ApiModelProperty(value = "版本號碼", example = "0.2")
    private String v;

    @ApiModelProperty(value = "訊息回應碼", example = "200")
    private String code;

    @ApiModelProperty(value = "系統回應訊息",example = "查詢成功")
    private String msg;

    @ApiModelProperty(value = "查詢開獎期別(yyyyMM)", example = "10106")
    private String invoYm;

    @ApiModelProperty(value = "千萬特獎號碼", example = "29734661")
    private String superPrizeNo;

    @ApiModelProperty(value = "特獎號碼", example = "99028391")
    private String spcPrizeNo;

    @ApiModelProperty(value = "特獎號碼 2")
    private String spcPrizeNo2;

    @ApiModelProperty(value = "特獎號碼 3")
    private String spcPrizeNo3;

    @ApiModelProperty(value = "頭獎號碼 1", example = "91180939")
    private String firstPrizeNo1;

    @ApiModelProperty(value = "頭獎號碼 2", example = "12753377")
    private String firstPrizeNo2;

    @ApiModelProperty(value = "頭獎號碼 3", example = "22638178")
    private String firstPrizeNo3;

    @ApiModelProperty(value = "頭獎號碼 4")
    private String firstPrizeNo4;

    @ApiModelProperty(value = "頭獎號碼 5")
    private String firstPrizeNo5;

    @ApiModelProperty(value = "頭獎號碼 6")
    private String firstPrizeNo6;

    @ApiModelProperty(value = "頭獎號碼 7")
    private String firstPrizeNo7;

    @ApiModelProperty(value = "頭獎號碼 8")
    private String firstPrizeNo8;

    @ApiModelProperty(value = "頭獎號碼 9")
    private String firstPrizeNo9;

    @ApiModelProperty(value = "頭獎號碼 10")
    private String firstPrizeNo10;

    @ApiModelProperty(value = "六獎號碼 1", example = "258")
    private String sixthPrizeNo1;

    @ApiModelProperty(value = "六獎號碼 2", example = "066")
    private String sixthPrizeNo2;

    @ApiModelProperty(value = "六獎號碼 3")
    private String sixthPrizeNo3;

    @ApiModelProperty(value = "六獎號碼 4")
    private String sixthPrizeNo4;

    @ApiModelProperty(value = "六獎號碼 5")
    private String sixthPrizeNo5;

    @ApiModelProperty(value = "六獎號碼 6")
    private String sixthPrizeNo6;

    @ApiModelProperty(value = "千萬特獎金額", example = "10000000")
    private String superPrizeAmt;

    @ApiModelProperty(value = "特獎金額", example = "2000000")
    private String spcPrizeAmt;

    @ApiModelProperty(value = "頭獎金額", example = "0200000")
    private String firstPrizeAmt;

    @ApiModelProperty(value = "二獎金額", example = "0040000")
    private String secondPrizeAmt;

    @ApiModelProperty(value = "三獎金額", example = "0010000")
    private String thirdPrizeAmt;

    @ApiModelProperty(value = "四獎金額", example = "0004000")
    private String fourthPrizeAmt;

    @ApiModelProperty(value = "五獎金額", example = "0001000")
    private String fifthPrizeAmt;

    @ApiModelProperty(value = "六獎金額", example = "0000200")
    private String sixthPrizeAmt;
}
