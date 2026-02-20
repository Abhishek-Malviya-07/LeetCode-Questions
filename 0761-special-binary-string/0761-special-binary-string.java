class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;

        List<String> substrings = new ArrayList<>();
        int balance = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            balance += (s.charAt(i) == '1' ? 1 : -1);
            
            if (balance == 0) {
                String inner = s.substring(start + 1, i);
                substrings.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }

        substrings.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String sub : substrings) {
            sb.append(sub);
        }
        return sb.toString();
    }
}