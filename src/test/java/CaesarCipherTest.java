import static org.junit.Assert.assertTrue;

import drvasile.Cipher;
import drvasile.implementations.CaesarCipher;
import org.junit.Test;

public class CaesarCipherTest
{
    private static final int TEST_KEY = 1;
    private static final String TEST_MESSAGE = "DrVasile";
    private static final String TEST_ENC_MESSAGE = "ESWBTJMF";

    private final Cipher cipherInstance = new CaesarCipher(TEST_KEY);

    @Test
    public void testCipherEncryption()
    {
        final String encryptedMessage = cipherInstance.encrypt(TEST_MESSAGE);
        final boolean areEqual = TEST_ENC_MESSAGE.equalsIgnoreCase(encryptedMessage);

        assertTrue(areEqual);
    }

    @Test
    public void testCipherDecryption()
    {
        final String decryptedMessage = cipherInstance.decrypt(TEST_ENC_MESSAGE);
        final boolean areEqual = TEST_MESSAGE.equalsIgnoreCase(decryptedMessage);

        assertTrue(areEqual);
    }
}
