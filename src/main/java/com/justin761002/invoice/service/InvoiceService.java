package com.justin761002.invoice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justin761002.invoice.dao.InvoiceDAO;
import com.justin761002.invoice.dto.CarrierAggregateResponse;
import com.justin761002.invoice.dto.WinningListResponse;
import com.justin761002.invoice.persistence.model.WinningListEntity;
import com.justin761002.invoice.persistence.repository.WinningListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceService {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Autowired
    private InvoiceDAO invoiceDAO;

    @Autowired
    private WinningListRepository winningListRepository;

    /**
     * 查詢中獎發票號碼清單
     * @param invTerm 民國年月
     */
    public ResponseEntity<WinningListResponse> queryWinningList(String invTerm) {
        ResponseEntity<WinningListResponse> response;
        Optional<WinningListEntity> optionalResult = winningListRepository.findById(invTerm);
        if(optionalResult.isPresent()) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonStr = objectMapper.writeValueAsString(optionalResult.get());
                WinningListResponse winningListResponse = objectMapper.readValue(jsonStr, WinningListResponse.class);
                winningListResponse.setV("0.N");
                winningListResponse.setCode("200");
                winningListResponse.setMsg("查詢成功 by PostgreSQL Database");
                response = ResponseEntity.ok().body(winningListResponse);
            } catch (JsonProcessingException e) {
                logger.error(e.toString());
                response = ResponseEntity.notFound().build();
            }
       } else {
            response = invoiceDAO.queryWinningList(invTerm);
            WinningListResponse winningListResponse = response.getBody();
            if(winningListResponse != null && "200".equals(winningListResponse.getCode())) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    String jsonStr = objectMapper.writeValueAsString(winningListResponse);
                    logger.info(jsonStr);
                    WinningListEntity winningListEntity = objectMapper.readValue(jsonStr, WinningListEntity.class);
                    winningListRepository.save(winningListEntity);
                } catch (JsonProcessingException e) {
                    logger.error(e.toString());
                }
            }
        }
        return response;
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
