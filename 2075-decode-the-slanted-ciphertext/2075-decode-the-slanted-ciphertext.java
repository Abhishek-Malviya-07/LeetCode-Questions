class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1)
            return encodedText;

        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();

        for (int startCol = 0; startCol < cols; startCol++) {
            for (int r = 0; r < rows; r++) {
                int c = startCol + r;
                if (c >= cols)
                    break;

                int index = r * cols + c;
                sb.append(encodedText.charAt(index));
            }
        }
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == ' ') {
            i--;
        }

        return sb.substring(0, i + 1);
    }
}