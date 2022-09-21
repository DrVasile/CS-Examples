package drvasile;

import drvasile.implementations.AffineCipher;
import drvasile.implementations.CaesarCipher;

public class Main
{
    public static void main(String[] args)
    {
        final Cipher cipher0 = new CaesarCipher(5);

        cipher0.encrypt("ABC");

    }
}
