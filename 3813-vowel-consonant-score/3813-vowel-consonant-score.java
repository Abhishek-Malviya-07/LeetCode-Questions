class Solution {
    public int vowelConsonantScore(String word) {
        int vowels = 0; int consonants = 0;
        
        for (char letter : word.toCharArray()) {
            if (letter >= 'a' && letter <= 'z') {
                switch (letter) {
                    case 'a': case 'e': case 'i': 
                    case 'o': case 'u': 
                        vowels++; 
                        break;
                    default:
                        consonants++;
                }
            }
        }
                return consonants > 0 ? vowels / consonants : 0;
    }
}
