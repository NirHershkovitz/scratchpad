import com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashAlgo {
    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static String guava(String input) {
        return Hashing.
                sha256().
                hashString(input, StandardCharsets.UTF_8).
                toString();
    }

    private static String pureJava(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return bytesToHex(MessageDigest.getInstance("SHA-256").digest(input.getBytes("UTF-8")));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String input = "XXXXX";
        System.out.println(guava(input));
        System.out.println(pureJava(input));
    }


}
