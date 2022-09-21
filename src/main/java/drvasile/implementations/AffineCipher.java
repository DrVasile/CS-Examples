package drvasile.implementations;

import javafx.util.Pair;

public class AffineCipher extends SubstitutionCipher
{
    private final Pair<Integer, Integer> keyPair;

    public AffineCipher(final Integer a, final Integer b)
    {
        this.keyPair = new Pair<>(a, b);
    }

    @Override
    protected Character encryptCharacter(Character currentChar)
    {
        return (char) ((((currentChar - 65) * keyPair.getKey() + keyPair.getValue()) % ALPHABET_SIZE) + 65);
    }

    @Override
    protected Character decryptCharacter(Character currentChar)
    {
        return (char) (((((currentChar - 65) - keyPair.getValue()) * keyPair.getKey()) % ALPHABET_SIZE) + 65);
    }
}
