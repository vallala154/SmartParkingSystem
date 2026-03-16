package util;

import java.security.MessageDigest;

public class HashUtil {

    public static String hashPassword(String password){

        try{

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder hex = new StringBuilder();

            for(byte b : hash){
                String h = Integer.toHexString(0xff & b);

                if(h.length()==1){
                    hex.append('0');
                }

                hex.append(h);
            }

            return hex.toString();

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}