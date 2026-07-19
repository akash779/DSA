//time complexity: O(n^2) where n is the number of rows or columns in the matrix
//space complexity: O(1) where n is the number of rows or columns in the matrix

class optimalApproch{ 
    public void rotate(int[][] matrix) {
        
        //swap the elements accross the diagonal elemenets in the matrix then we just reverse each row hence result is the transpose of the matrix 

        for(int i = 0 ; i < matrix.length;i++){
            for(int j = 0 ; j < i ; j++){

                if(i!=j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp ;
                }

            }
        }
        reverseRows(matrix);

    }

      


    public static void reverseRows(int[][] matrix) {
        for (int[] row : matrix) {
            int start = 0;
            int end = row.length - 1;
            while (start < end) {
                int temp = row[start];
                row[start] = row[end];  
                row[end] = temp;
                start++;
                end--;
            }
        }
    } 
}