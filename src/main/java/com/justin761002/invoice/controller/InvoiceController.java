package com.justin761002.invoice.controller;

import com.justin761002.invoice.dto.CarrierAggregate;
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

    @ApiOperation(value = "查詢中獎發票號碼清單", notes = "輸入民國年月（偶數月）")
    @GetMapping("/winningList")
    public ResponseEntity<WinningListResponse> queryWinningList(
            @ApiParam(value = "輸入民國年月（ex: 10906）")
            @RequestParam String yyyMM) {
        return invoiceService.queryWinningList(yyyMM);
    }

    @GetMapping(value = "/carrier/aggregate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> aggregateCarrier(
            @RequestParam String serial,
            @RequestParam String cardType,
            @RequestParam String cardNo,
            @RequestParam String cardEncrypt) {
        CarrierAggregate carrierAggregate = new CarrierAggregate();
        carrierAggregate.setSerial(serial);
        carrierAggregate.setCardType(cardType);
        carrierAggregate.setCardNo(cardNo);
        carrierAggregate.setCardEncrypt(cardEncrypt);

        ResponseEntity<String> responseEntity = invoiceService.aggregateCarrier(carrierAggregate);
        return responseEntity;
    }

}
