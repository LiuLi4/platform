package com.bjfu.inspect.common;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    /**利用MD5进行加密*/
    public static String EncoderByMd5(String str) {
        String ans = str;
        try {
            // 加密对象，指定加密方式
            MessageDigest md5 = MessageDigest.getInstance("md5");
            // 准备要加密的数据
            byte[] bype = str.getBytes();
            // 加密
            byte[] digest = md5.digest(bype);
            // 十六进制的字符
            char[] chars = new char[] { '0', '1', '2', '3', '4', '5',
                    '6', '7' , '8', '9', 'A', 'B', 'C', 'D', 'E','F' };
            StringBuffer sb = new StringBuffer();
            // 处理成十六进制的字符串(通常)
            for (byte bb : digest) {
                sb.append(chars[(bb >> 4) & 15]);
                sb.append(chars[bb & 15]);
            }
            ans = new String(sb);
        } catch (NoSuchAlgorithmException e) {
            Log.info(MD5Util.class, e.getMessage());
        }
        return ans;
    }

    public static boolean checkPassword(String newpasswd, String oldpasswd){
        if(newpasswd != null && EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }
}