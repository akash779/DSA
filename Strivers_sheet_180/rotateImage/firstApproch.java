//Time Complexity: O(n^2) where n is the number of rows or columns in the matrix 
//Space Complexity: O(n^2) where n is the number of rows or columns in the matrix
class firstApproch{

    public void rotate(int[][] matrix){

        //total rows and columns in matrix
        int m = matrix.length;
        int n = matrix[0].length;
        int [][] temp = new int[m][n];
        //put rows as columns and columns as rows in temp matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                temp[j][n-1-i] = matrix[i][j];
            }
        }
        //copying the elements of temp back to matrix
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = temp[i][j];
            }
        }

    }

}