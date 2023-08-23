class Solution {
    public void setZeroes(int[][] matrix) {
       int rowlength = matrix.length;
       int collength = matrix[0].length;
       boolean[] rowZeros = new boolean[rowlength];
       boolean[] collZeros = new boolean[collength];

       for(int i=0; i<rowlength; i++){
         for(int j=0; j<collength; j++){
           if(matrix[i][j]== 0){
             rowZeros[i] = true;
             collZeros[j] = true;
           }
         }
       }
       for (int i = 0; i < rowlength; i++) {
            for (int j = 0; j < collength; j++) {
                if (rowZeros[i] || collZeros[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
}
}