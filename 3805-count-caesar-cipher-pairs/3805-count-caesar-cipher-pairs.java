class Solution {
    public long countPairs(String[] words) {
       Map<String , Long> map = new HashMap<>();

        for(String s : words){
            String currString = getStringForm(s);
            map.put(currString , map.getOrDefault(currString ,0L)+1);
        }

        long formsOfString = 0;
        for(long c : map.values() ){
            formsOfString += (c * (c-1))/2;
        }

        return formsOfString;
    }

    public String getStringForm(String s){

        if(s.length() == 0){
            return "";
        }

        char[] c = s.toCharArray();

        int change = c[0] - 'a';
        StringBuilder sb = new StringBuilder();
        for(char ch : c){
            int pos = ch - 'a';
            int normlPos = (pos - change + 26)%26;
            sb.append((char)('a' + normlPos));
        }
        return sb.toString();
    }
}