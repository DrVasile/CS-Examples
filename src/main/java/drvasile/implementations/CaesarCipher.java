package drvasile.implementations;

import java.util.Locale;

import drvasile.Cipher;

public class CaesarCipher implements Cipher
{
    private final int key;

    public CaesarCipher(int key)
    {
        this.key = key;
    }

    @Override
    public String encrypt(String message)
    {
        final String upperCaseMessage = message.toUpperCase(Locale.ROOT);
        final StringBuilder encryptedMessage = new StringBuilder(upperCaseMessage.length());

        for (char character : upperCaseMessage.toCharArray())
        {
            encryptedMessage.append((char) (((character + key - 65) % ALPHABET_SIZE) + 65));
        }

        return encryptedMessage.toString();
    }

    @Override
    public String decrypt(String message)
    {
        final String upperCaseMessage = message.toUpperCase(Locale.ROOT);
        final StringBuilder decryptedMessage = new StringBuilder(upperCaseMessage.length());

        for (char character : upperCaseMessage.toCharArray())
        {
            decryptedMessage.append((char) (((character - key - 65) % ALPHABET_SIZE) + 65));
        }

        return decryptedMessage.toString();
    }
}
