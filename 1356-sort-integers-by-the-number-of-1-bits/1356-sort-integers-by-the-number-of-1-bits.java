class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(temp, (a, b) -> {
            
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if (countA == countB) {
                return a - b;   
            }
            
            return countA - countB;  
        });
        
        return Arrays.stream(temp).mapToInt(i -> i).toArray();
    }
}