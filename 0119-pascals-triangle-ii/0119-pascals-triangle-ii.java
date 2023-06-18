class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        ArrayList<Integer> prev = new ArrayList<Integer>();
        
        prev.add(1);
        
        if(rowIndex == 0) return prev;
        
        
        for(int i=1; i<=rowIndex; i++){
            
             ArrayList<Integer> curr = new ArrayList<Integer>();
        
             curr.add(1); //first 
             for(int j=0; j<prev.size()-1;  j++){
                 curr.add(prev.get(j) + prev.get(j+1)); //middle
             }
             curr.add(1);// last
            
             prev = curr;
            
        }
         
        
        return prev;
         
        
        
    }
}