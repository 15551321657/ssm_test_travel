package hs.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }




    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String password="root";
        String encode = passwordEncoder.encode(password);
        System.out.println(encode);

        System.out.println("分割---");
        String s = encodePassword(password);
        System.out.println(s);


    }
}
