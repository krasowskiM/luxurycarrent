package com.maciek.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maciek.security.AuthenticatedUser;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by Maciek on 2017-05-22.
 */
public class TokenHelper {
    private static final String HMAC_ALGO = "HmacSHA256";
    private static final String SEPARATOR = ".";
    private static final String SEPARATOR_SPLITTER = "\\.";

    private final Mac hmac;

    public TokenHelper(byte[] secretKey){
        try {
            hmac = Mac.getInstance(HMAC_ALGO);
            hmac.init(new SecretKeySpec(secretKey, HMAC_ALGO));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalStateException("failed to initialize HMAC: " + e.getMessage(), e);
        }
    }

    public AuthenticatedUser parseAuthenticatedUserFromToken(String token){
        final String[] parts = token.split(SEPARATOR_SPLITTER);
        if(parts.length == 2 && parts[0].length() > 0 && parts[1].length() > 0){
            try{
                final byte[] userBytes = fromBase64(parts[0]);
                final byte[] hash = fromBase64(parts[1]);
                
                boolean validHash = Arrays.equals(createHmac(userBytes), hash);
                if(validHash){
                    return fromJSON(userBytes);
                }
            } catch (IllegalArgumentException ex){

            }
        }
        return null;
    }
    
    public String createTokenForUser(AuthenticatedUser user){
        byte[] userBytes = toJSON(user);
        byte[] hash = createHmac(userBytes);
        final StringBuilder builder = new StringBuilder(170);
        builder.append(toBase64(userBytes));
        builder.append(SEPARATOR);
        builder.append(toBase64(hash));
        return builder.toString();
    }



    private AuthenticatedUser fromJSON(byte[] userBytes) {
        try{
            return new ObjectMapper().readValue(new ByteArrayInputStream(userBytes), AuthenticatedUser.class);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private byte[] toJSON(AuthenticatedUser user){
        try{
            return new ObjectMapper().writeValueAsBytes(user);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    private synchronized byte[] createHmac(byte[] content) {
        return hmac.doFinal(content);
    }

    private String toBase64(byte[] content) {
        return DatatypeConverter.printBase64Binary(content);
    }

    private byte[] fromBase64(String part) {
        return DatatypeConverter.parseBase64Binary(part);
    }
}
