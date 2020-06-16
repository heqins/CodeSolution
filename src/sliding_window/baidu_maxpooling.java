public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    int n = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    
    int[][] matrix = new int[m][n];
    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < n; j++)
      {
        matrix[i][j] = (i+1)*(j+1)%10;
      }
    }
    
    System.out.println("打印出原始的像素层：");
    printMatrix(matrix);
    System.out.println();
    
    int[][] first = new int[m][n-b+1];
    for (int i = 0; i < m; i++)
    {
      first[i] = maxSlidingWindow(matrix[i], b);
    }
    
    int[][] second = new int[n-b+1][m-a+1];
    for (int i = 0; i < second.length; i++)
    {
      second[i] = maxSlidingWindow(first[i], a);
    }
    
    printMatrix(second);
  }
}
