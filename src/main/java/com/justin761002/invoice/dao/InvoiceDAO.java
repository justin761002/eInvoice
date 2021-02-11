package com.justin761002.invoice.dao;

import com.justin761002.invoice.dto.WinningListRequest;
import com.justin761002.invoice.dto.WinningListResponse;
import com.justin761002.invoice.util.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class InvoiceDAO {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceDAO.class);

    @Value("${application.app.id}")
    private String appId;

    @Value("${application.api.key}")
    private String apiKey;

    @Value("${invoice.url.winning}")
    private String urlQryWinningList;

    @Autowired
    private EncryptUtil encryptUtil;

    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<WinningListResponse> queryWinningList(String yyyMM) {

        WinningListRequest request = new WinningListRequest();
        request.setInvTerm(yyyMM);

        StringBuffer url = new StringBuffer(urlQryWinningList);
        url.append("?action=").append(request.getAction());
        url.append("&appID=").append(appId);
        url.append("&invTerm=").append(request.getInvTerm());
        url.append("&version=").append(request.getVersion());

        logger.debug("url={}", url);
        return restTemplate.postForEntity(url.toString(), null, WinningListResponse.class);
    }
}
