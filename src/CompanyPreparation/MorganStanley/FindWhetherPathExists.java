package CompanyPreparation.MorganStanley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindWhetherPathExists {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] matrix = new int[n][n];
            int[][] visited = new int[n][n];
            String input = br.readLine();
            int k=0;
            int srcrow=0;
            int srccol=0;
            int destrow=0;
            int destcol=0;
            for(int i=0; i<n; i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = Integer.parseInt(String.valueOf(input.charAt(k)));
                    if(matrix[i][j]==1){
                        srcrow = i;
                        srccol = j;
                    }
                    if(matrix[i][j]==2){
                        destrow= i ;
                        destcol = j;
                    }
                    k++;
                }
            }
//            isPathExists(matrix,visited,srcrow,srccol,n,destrow,destcol);

            if(isPathExists(matrix,visited,srcrow,srccol,n, destrow, destcol)){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }

        }

    }

    public static boolean isPathExists(int[][] matrix, int[][] visited, int i, int j, int n, int destrow, int destcol) {
        //i,j is not valid
        if (i >= n || i < 0 || j >= n || j < 0) {
            return false;
        }

        if (i == destrow && j == destcol) {
//            System.out.println("1");
            return true;
        }

        if (visited[i][j] == 1 || matrix[i][j] == 0) {
            return false;
        }

        visited[i][j] = 1;
        //go up
        return (isPathExists(matrix, visited, i - 1, j, n, destrow, destcol) ||
        //go right
        isPathExists(matrix, visited, i, j + 1, n, destrow, destcol) ||
        //go down
        isPathExists(matrix, visited, i + 1, j, n, destrow, destcol) ||
        //go left
        isPathExists(matrix, visited, i, j - 1, n, destrow, destcol)
        );


    }
}
