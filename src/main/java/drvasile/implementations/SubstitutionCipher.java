package drvasile.implementations;

import java.util.Locale;

import drvasile.Cipher;

public abstract class SubstitutionCipher implements Cipher
{
    @Override
    public String encrypt(String message)
    {
        final String upperCaseMessage = message.toUpperCase(Locale.ROOT);
        final StringBuilder encryptedMessage = new StringBuilder(upperCaseMessage.length());

        for (char character : upperCaseMessage.toCharArray())
        {
            encryptedMessage.append(encryptCharacter(character));
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
            decryptedMessage.append(decryptCharacter(character));
        }

        return decryptedMessage.toString();
    }

    protected abstract Character encryptCharacter(final Character currentChar);

    protected abstract Character decryptCharacter(final Character currentChar);
}
