package com.justin761002.invoice.service;

import com.justin761002.invoice.data.CarrierAggregate;
import com.justin761002.invoice.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class InvoiceService {

    @Value("${application.app.id}")
    private String appId;

    @Value("${application.api.key}")
    private String apiKey;

    @Value("${invoice.url.carrier.aggregate}")
    private String urlCarrierAggregate;

    @Autowired
    private EncryptUtil encryptUtil;

    public String queryWinningList() {
        return "queryWinningList";
    }

    public ResponseEntity<String> aggregateCarrier(CarrierAggregate carrierAggregate) {

        RestTemplate restTemplate = new RestTemplate();

        LinkedHashMap<String, Object> map= new LinkedHashMap<>();
        map.put("action", "qryCarrierAgg");
        map.put("appID", appId);
        map.put("cardEncrypt", carrierAggregate.getCardEncrypt());
        map.put("cardNo", carrierAggregate.getCardNo());
        map.put("cardType", carrierAggregate.getCardType());
        map.put("serial", carrierAggregate.getSerial());

        Date date = new Date();
        long timestamp = date.getTime();
        Long time = timestamp/1000 + 100;

        map.put("timeStamp", time);
        map.put("uuid", "justin_test");
        map.put("version", "1.0");

        String paramString = getParamString(map);
        String signature = encryptUtil.hmacSHA256(paramString, apiKey);

        String url = urlCarrierAggregate + "?" + paramString + "&signature=" + signature;
        return restTemplate.postForEntity( url, null , String.class );
    }

    private String getParamString(LinkedHashMap<String, Object> parameterMap) {
        StringBuilder stringBuilder = new StringBuilder();
        int counter = 0;
        for(Map.Entry<String, Object> entry : parameterMap.entrySet()) {
            if(counter > 0) {
                stringBuilder.append("&").append(entry.getKey()).append("=").append(entry.getValue());
            } else {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            }
            counter++;
        }
        return stringBuilder.toString();
    }

}
