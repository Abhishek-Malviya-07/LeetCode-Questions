class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        if (ones.size() < k) {
            return "";
        }

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i <= ones.size() - k; i++) {
            int left = ones.get(i);
            int right = ones.get(i + k - 1);
            String sub = s.substring(left, right + 1);

            if (sub.length() < minLen) {
                minLen = sub.length();
                ans = sub;
            } else if (sub.length() == minLen && sub.compareTo(ans) < 0) {
                ans = sub;
            }
        }

        return ans;
    }
}