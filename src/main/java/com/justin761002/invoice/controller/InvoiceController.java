package com.justin761002.invoice.controller;

import com.justin761002.invoice.data.CarrierAggregate;
import com.justin761002.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eInvoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/winningList")
    public String queryWinningList() {
        return invoiceService.queryWinningList();
    }

    @GetMapping("/carrier/aggregate")
    public ResponseEntity<String> aggregateCarrier(@RequestBody CarrierAggregate carrierAggregate) {
        return invoiceService.aggregateCarrier(carrierAggregate);
    }
}
