package com.gara.utils;

import javax.xml.bind.DatatypeConverter;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import com.gara.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtils {
    private static Logger logger = LoggerFactory.getLogger(StringUtils.class);

    public static String encryptMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());

            byte[] byteData = md.digest();
            String myHash = DatatypeConverter
                    .printHexBinary(byteData).toLowerCase();
            return myHash;
        } catch (EnumConstantNotPresentException | NoSuchAlgorithmException e) {
            logger.error(e.getMessage(), e);
        }
        return "";
    }

}
