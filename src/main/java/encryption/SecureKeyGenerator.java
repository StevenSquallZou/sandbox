package encryption;


import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


public class SecureKeyGenerator {

    public static String generateSecureRandomString(int length) {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
    }


    public static String generateHmacSha256Key() {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to generate key", e);
        }
    }


    public static void main(String[] args) {
        // Generate a 32-character secure random string (256 bits)
        String randomSecret = generateSecureRandomString(32);
        System.out.println("Random Secret: " + randomSecret);

        // Generate HMAC-SHA256 specific key
        String hmacKey = generateHmacSha256Key();
        System.out.println("HMAC-SHA256 Key: " + hmacKey);

        // For JWT HS256, you need exactly 256 bits (32 bytes)
        String jwtSecret = generateSecureRandomString(32);
        System.out.println("JWT HS256 Secret: " + jwtSecret);
    }

}
