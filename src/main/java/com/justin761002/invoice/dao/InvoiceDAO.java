package com.justin761002.invoice.dao;

import com.justin761002.invoice.dto.WinningListResponse;
import com.justin761002.invoice.util.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

@Repository
public class InvoiceDAO {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceDAO.class);

    @Value("${application.app.id}")
    private String appId;

    @Value("${application.api.key}")
    private String apiKey;

    @Value("${invoice.url.winning}")
    private String urlQryWinningList;

    @Value("${invoice.url.carrier.aggregate}")
    private String urlCarrierAggregate;

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * 查詢中獎發票號碼清單
     * @param invTerm 民國年月
     */
    public ResponseEntity<WinningListResponse> queryWinningList(String invTerm) {
        String action = "QryWinningList";
        String uuid = "0000000001";
        String version = "0.2";

        StringBuffer url = new StringBuffer(urlQryWinningList);
        url.append("?action=").append(action);
        url.append("&appID=").append(appId);
        url.append("&invTerm=").append(invTerm);
        url.append("&version=").append(version);
        url.append("&UUID=").append(uuid);

        logger.info("requestUrl={}", url);
        ResponseEntity<WinningListResponse> response = restTemplate.postForEntity(url.toString(), null, WinningListResponse.class);
        logger.info("response={}", response);
        return response;
    }

    /**
     * 手機條碼歸戶載具查詢
     * @param cardNo 手機條碼
     * @param cardEncrypt 手機條碼驗證碼
     * @param cardType 卡別
     */
    public ResponseEntity<String> queryAggregateCarrier(String cardNo, String cardEncrypt, String cardType) {
        EncryptUtil encryptUtil = new EncryptUtil();
        String action = "qryCarrierAgg";
        String version = "1.0";
        String serial = "0000000001";
        long timeStamp = Instant.now().getEpochSecond() + 100;
        String uuid = "justin_test";

        String signature;
        StringBuffer queryUrl = new StringBuffer();
        queryUrl.append("action=").append(action);
        queryUrl.append("&appID=").append(appId);
        queryUrl.append("&cardEncrypt=").append(cardEncrypt);
        queryUrl.append("&cardNo=").append(cardNo);
        queryUrl.append("&cardType=").append(cardType);
        queryUrl.append("&serial=").append(serial);
        queryUrl.append("&timeStamp=").append(timeStamp);
        queryUrl.append("&uuid=").append(uuid);
        queryUrl.append("&version=").append(version);
        signature = encryptUtil.hmacSHA256(queryUrl.toString(), apiKey);
        logger.info("signature={}", signature);

        URI uri = null;
        UriComponentsBuilder builder;
        try {
            builder = UriComponentsBuilder.fromUriString(urlCarrierAggregate);
            builder.queryParam("action", URLEncoder.encode(action, StandardCharsets.UTF_8.name()));
            builder.queryParam("appID", URLEncoder.encode(appId, StandardCharsets.UTF_8.name()));
            builder.queryParam("cardEncrypt", URLEncoder.encode(cardEncrypt, StandardCharsets.UTF_8.name()));
            builder.queryParam("cardNo", URLEncoder.encode(cardNo, StandardCharsets.UTF_8.name()));
            builder.queryParam("cardType", URLEncoder.encode(cardType, StandardCharsets.UTF_8.name()));
            builder.queryParam("serial", URLEncoder.encode(serial, StandardCharsets.UTF_8.name()));
            builder.queryParam("timeStamp", timeStamp);
            builder.queryParam("uuid", URLEncoder.encode(uuid, StandardCharsets.UTF_8.name()));
            builder.queryParam("version", URLEncoder.encode(version, StandardCharsets.UTF_8.name()));
            builder.queryParam("signature", URLEncoder.encode(signature, StandardCharsets.UTF_8.name()));
            uri = builder.build(true).toUri();
            logger.info(uri.toString());
        } catch (UnsupportedEncodingException e) {
            logger.error("build url failed.", e);
        }

        ResponseEntity<String> response = restTemplate.postForEntity(uri, null , String.class);
        logger.info("response={}", response);
        return response;
    }
}
