package drvasile.implementations;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import drvasile.Cipher;

/**
 * Invented in 1854
 * Author: Charles Wheatstone, but named after Lord Playfair.
 */

public class PlayfairCipher implements Cipher
{
    private final String key;
    private final Character[][] charGrid = new Character[5][5];
    private final boolean[] usedChars = new boolean[26];

    public PlayfairCipher(String key)
    {
        this.key = key;
        usedChars['J' - 'A'] = true;

        final String preprocessedKey = key.toUpperCase(Locale.ROOT).replaceAll("J", "I");
        final List<Character> distinctKeyChars = key.chars().distinct().mapToObj(character -> (char) character).collect(Collectors.toList());

        int i = 0;
        int j = 0;

        for (Character character : distinctKeyChars)
        {
            charGrid[i][j] = character;
            usedChars[character - 'A'] = true;
            j++;

            if (j == 5)
            {
                j = 0;
                i++;
            }
        }

        for (int k = 0; k < 26; k++)
        {
            if (usedChars[k]) continue;

            usedChars[k] = true;
            charGrid[i][j] = (char) ('A' + k);
            j++;

            if (j == 5)
            {
                j = 0;
                i++;
            }
        }
    }

    @Override
    public String encrypt(String message)
    {

        return message;
    }

    @Override
    public String decrypt(String message)
    {
        return null;
    }

    private String preprocessMessage(String message)
    {
        int i = 0;

        for (;; i += 2)
        {
            if (i >= message.length() - 1) break;

            if (message.charAt(i) == message.charAt(i + 1))
            {
                message = insertBogusChar(message, i);
                i++;
            }
        }

        if (isOdd(message.length()))
        {
            message = message + "Z";
        }

        return message;
    }

    private String insertBogusChar(final String currentString, final int position)
    {
        final char bogusChar = (currentString.charAt(position) == 'X' ? 'Z' : 'X');

        return currentString.substring(0, position) + bogusChar + currentString.substring(position);
    }

    private boolean isOdd(final int number)
    {
        return number % 2 == 1;
    }
}
