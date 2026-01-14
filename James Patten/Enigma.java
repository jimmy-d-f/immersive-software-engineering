public class Enigma {

    static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static String rotor = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
    static int rotorPosition = 0;

    static String reflector = "YRUHQSLDPXNGOKMIEBFZCWVJAT";

    static char encryptChar(char c) {
        if (!Character.isLetter(c)) return c;

        c = Character.toUpperCase(c);

        int index = (ALPHABET.indexOf(c) + rotorPosition) % 26;
        char stepped = rotor.charAt(index);

        char reflected = reflector.charAt(ALPHABET.indexOf(stepped));

        int backIndex = rotor.indexOf(reflected);
        char result = ALPHABET.charAt(
                (backIndex - rotorPosition + 26) % 26
        );

        rotorPosition = (rotorPosition + 1) % 26;

        return result;
    }

    static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            result.append(encryptChar(c));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String message = "HELLO WORLD";

        rotorPosition = 0;
        String encrypted = encrypt(message);
        System.out.println("Encrypted: " + encrypted);

        rotorPosition = 0;
        String decrypted = encrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
