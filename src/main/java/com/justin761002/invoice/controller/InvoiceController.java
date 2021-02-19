package com.justin761002.invoice.controller;

import com.justin761002.invoice.dto.CarrierAggregateResponse;
import com.justin761002.invoice.dto.WinningListResponse;
import com.justin761002.invoice.service.InvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Invoice")
@RestController
@RequestMapping("/eInvoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @ApiOperation(value = "查詢中獎發票號碼清單", notes = "依開獎期別(雙數月)取得查詢期別,中獎獎別、號碼及中獎各獎獎金金額。")
    @GetMapping(value = "/winningList")
    public ResponseEntity<WinningListResponse> queryWinningList(
            @ApiParam(value = "輸入民國年月（ex: 10906）") @RequestParam String invTerm) {
        return invoiceService.queryWinningList(invTerm);
    }

    @ApiOperation(value = "手機條碼歸戶載具查詢", notes = "查詢單一手機條碼目前有效的歸戶載具。")
    @GetMapping(value = "/carrier/aggregate", produces = MediaType.APPLICATION_JSON_VALUE)
    public CarrierAggregateResponse aggregateCarrier(
            @ApiParam(value = "手機條碼") @RequestParam String cardNo,
            @ApiParam(value = "手機條碼驗證碼") @RequestParam String cardEncrypt,
            @ApiParam(value = "卡別") @RequestParam String cardType) {
        return invoiceService.queryAggregateCarrier(cardNo, cardEncrypt, cardType);
    }

}
