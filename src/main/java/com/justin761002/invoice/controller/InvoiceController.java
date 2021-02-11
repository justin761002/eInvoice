package com.justin761002.invoice.controller;

import com.justin761002.invoice.dto.CarrierAggregate;
import com.justin761002.invoice.dto.WinningListResponse;
import com.justin761002.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eInvoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/winningList")
    public ResponseEntity<WinningListResponse> queryWinningList(@RequestParam String yyyMM) {
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
