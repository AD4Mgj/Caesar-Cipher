public class Example {
    public static void main(String[] args) {
        String text = "text.txt";
        String cipher = "cipher.txt";
        String decryption = "decryption.txt";
        CaesarCipher.doCaesarCipher(3, text, cipher);
        CaesarDecryption.doCaesarCipherDecryption(3, cipher, decryption);
    }
}
