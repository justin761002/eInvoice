package com.justin761002.invoice.util;

import com.justin761002.invoice.dao.InvoiceDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Repository
public class EncryptUtil {
    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    public String hmacSHA256(String content, String key) {
        String HMAC_SHA256 = "HmacSHA256";
        Mac sha256Hmac;
        String result = null;

        try {
            final byte[] byteKey = key.getBytes(StandardCharsets.UTF_8);
            sha256Hmac = Mac.getInstance(HMAC_SHA256);
            SecretKeySpec keySpec = new SecretKeySpec(byteKey, HMAC_SHA256);
            sha256Hmac.init(keySpec);
            byte[] macData = sha256Hmac.doFinal(content.getBytes(StandardCharsets.UTF_8));

            // Can either base64 encode or put it right into hex
            result = Base64.getEncoder().encodeToString(macData);
            //result = bytesToHex(macData);
        } catch (InvalidKeyException e) {
            logger.error("InvalidKeyException: ", e);
        } catch (NoSuchAlgorithmException e) {
            logger.error("NoSuchAlgorithmException: ", e);
        } finally {
            // Put any cleanup here
        }
        return result;
    }
}
