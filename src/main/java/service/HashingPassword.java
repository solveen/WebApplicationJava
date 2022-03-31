package service;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashingPassword {
//    public static String  encode(String value) throws UnsupportedEncodingException {
//        Base64.Encoder e = Base64.getEncoder();
//        return e.encodeToString(value.getBytes(StandardCharsets.UTF_8));
//
//    }
//    public static String decode(String encrypted) throws UnsupportedEncodingException{
//        byte[] b = Base64.getDecoder().decode(encrypted);
//        return new String(b,StandardCharsets.UTF_8);
//    }
//
        public static String encode(String value)
        {
            String generatedPassword = null;

            try
            {
                // Create MessageDigest instance for MD5
                MessageDigest md = MessageDigest.getInstance("MD5");

                // Add password bytes to digest
                md.update(value.getBytes());

                // Get the hash's bytes
                byte[] bytes = md.digest();

                // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }

                // Get complete hashed password in hex format
                generatedPassword = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return generatedPassword;
        }
    }






