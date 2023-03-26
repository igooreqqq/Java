public class Polibiusz implements Algorithm {

    private final char[][] alphabet = {
            {'A', 'B', 'C', 'D', 'E'},
            {'F', 'G', 'H', 'I', 'K'},
            {'L', 'M', 'N', 'O', 'P'},
            {'Q', 'R', 'S', 'T', 'U'},
            {'V', 'W', 'X', 'Y', 'Z'}
    };

    @Override
    public String crypt(String text) {
        StringBuilder result = new StringBuilder();

        for(char c : text.toUpperCase().toCharArray()) {
            if(c == 'J') {
                c = 'I';
            } else if(c == ' ') {
                result.append(" ");
                continue;
            }

            int row = 0;
            int col = 0;
            for(int i = 0; i < alphabet.length; i++) {
                for(int j = 0; j < alphabet[i].length; j++) {
                    if (alphabet[i][j] == c) {
                        row = i + 1;
                        col = j + 1;
                        break;
                    }
                }
            }
            result.append(row).append(col);
        }
        return result.toString();
    }

    @Override
    public String decrypt(String text) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < text.length(); i += 2) {
            if(text.charAt(i) == ' ') {
                result.append(" ");
                i--;
                continue;
            }

            int row = Character.getNumericValue(text.charAt(i));
            int col = Character.getNumericValue(text.charAt(i + 1));

            if(row < 1 || row > alphabet.length || col < 1 || col > alphabet[0].length) {
                continue;
            }

            char c = alphabet[row - 1][col - 1];
            if(c == 'I') {
                c = 'J';
            }
            result.append(c);
        }
        return result.toString();
    }
}
