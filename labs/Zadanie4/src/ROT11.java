public class ROT11 implements Algorithm {
    private final int move = 11;
    private final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    @Override
    public String crypt(String cryptString) {
        String result;
        StringBuilder cryptedString = new StringBuilder();
        int pos;
        int newPos;

        for(char c : cryptString.toCharArray()) {
            pos = alphabet.indexOf(String.valueOf(c));

            if(pos < 0) {
                cryptedString.append(c);
                continue;
            }

            if(pos + move > 61) {
                newPos = (pos + move) % 62;
            } else {
                newPos = pos + move;
            }

            cryptedString.append(alphabet.charAt(newPos));
        }
        result = cryptedString.toString();
        return result;
    }

    @Override
    public String decrypt(String decryptString) {
        String result;
        StringBuilder decryptedString = new StringBuilder();

        int pos;
        int newPos;

        for(char c : decryptString.toCharArray()) {
            pos = alphabet.indexOf(String.valueOf(c));

            if(pos < 0) {
                decryptedString.append(c);
                continue;
            }

            if(pos - move < 0) {
                newPos = 62 + ((pos - move) % 62);
            } else {
                newPos = pos - move;
            }

            decryptedString.append(alphabet.charAt(newPos));
        }
        result = decryptedString.toString();
        return result;
    }
}
