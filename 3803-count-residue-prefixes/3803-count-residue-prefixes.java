class Solution {
    public int residuePrefixes(String s) {

        int length = s.length();
        int count = 0;

        for(int i =1; i<=length; i++){
            String pre = s.substring(0,i);

            Set<Character> unique = new HashSet<>();
            for(char c : pre.toCharArray()){
                unique.add(c);
            }
            if(unique.size() == (i%3)){
                count++;
            }
        }
        return count;
    }
}