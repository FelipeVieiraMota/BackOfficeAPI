package com.backoffice.backoffice.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String getHash(String phrase, String algorithm){
        byte[] bytes = generateHash(phrase, algorithm);
        return stringHex(bytes);
    }

    private static byte[] generateHash(String phrase, String algorithm){
        try{
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(phrase.getBytes());
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private static String stringHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < bytes.length; i++){
            int highEnd = ( (bytes[i] >> 4) & 0xf ) << 4; // Essa operacao remove o bit 1 negativo caso ele exista.
            int lowerPart = bytes[i] & 0xf; // Essa operacao deixa somente os 4 bits menos relevantes;

            if(highEnd == 0) sb.append('0');

            sb.append(Integer.toHexString(highEnd | lowerPart));
        }
        return sb.toString();
    }
}
