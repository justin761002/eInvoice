package com.justin761002.invoice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin761002.invoice.dao.InvoiceDAO;
import com.justin761002.invoice.dto.CarrierAggregateResponse;
import com.justin761002.invoice.dto.WinningListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Autowired
    private InvoiceDAO invoiceDAO;

    /**
     * 查詢中獎發票號碼清單
     * @param invTerm 民國年月
     */
    public ResponseEntity<WinningListResponse> queryWinningList(String invTerm) {
        return invoiceDAO.queryWinningList(invTerm);
    }

    /**
     * 手機條碼歸戶載具查詢
     * @param cardNo 手機條碼
     * @param cardEncrypt 手機條碼驗證碼
     * @param cardType 卡別
     */
    public CarrierAggregateResponse queryAggregateCarrier(String cardNo, String cardEncrypt, String cardType) {
        String response = invoiceDAO.queryAggregateCarrier(cardNo, cardEncrypt, cardType).getBody();
        ObjectMapper mapper = new ObjectMapper();
        CarrierAggregateResponse carrierAggregateResponse = null;
        try {
            carrierAggregateResponse = mapper.readValue(response, CarrierAggregateResponse.class);
        } catch (JsonProcessingException e) {
            logger.error("queryAggregateCarrier", e);
        }
        return carrierAggregateResponse;
    }

}
