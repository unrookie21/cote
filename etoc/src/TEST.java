import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TEST {

    public static void main(String[] args) {
        try {
            // AES-256 키 생성 (256 bits = 32 bytes)
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey secretKey = keyGenerator.generateKey();

            // Base64로 인코딩
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());

            System.out.println("=================================================");
            System.out.println("Generated AES-256 Encryption Key (Base64 encoded):");
            System.out.println("=================================================");
            System.out.println(encodedKey);
            System.out.println("=================================================");
            System.out.println("\n사용 방법:");
            System.out.println("1. 위의 키를 복사하세요");
            System.out.println("2. 환경변수에 설정하세요:");
            System.out.println("   export ENCRYPTION_SECRET_KEY=\"" + encodedKey + "\"");
            System.out.println("\n또는 .env 파일에:");
            System.out.println("   ENCRYPTION_SECRET_KEY=" + encodedKey);
            System.out.println("\n⚠️  경고: 이 키는 매우 중요합니다!");
            System.out.println("   - 절대 Git에 커밋하지 마세요");
            System.out.println("   - 안전한 곳에 백업하세요");
            System.out.println("   - 프로덕션과 개발 환경에서 다른 키를 사용하세요");

        } catch (NoSuchAlgorithmException e) {
            System.err.println("AES 알고리즘을 사용할 수 없습니다: " + e.getMessage());
        }
    }

    /**
     * 프로그래밍 방식으로 키 생성
     */
    public static String generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey secretKey = keyGenerator.generateKey();
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to generate encryption key", e);
        }
    }
}
