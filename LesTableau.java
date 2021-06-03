import java.lang.Math;

public class LesTableau {  
    public LesTableau()
    {
    }
    public char [][] generatePlayerMap(int N)
    {
        char [][] arr = new char [N][N];
        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr[i].length;j++)
            {
                arr[i][j] = '-';
            }
        }
        return arr;
    }

    public char echangeTab(int [][]arr, int x, int y)
    {
        char [][] ans = new char [arr.length][arr.length];
        ans[x][y] = (char) (arr[x][y] +'0');
        return ans[x][y];
    }

    public boolean [][]check (int N,int nomofMines) // check the different position of mines
    {
        boolean ans[][] = new boolean [N][N];
        for(int i=0;i<ans.length;i++)
        {
            for (int j=0;j<ans[i].length;j++)
            {
                ans[i][j] = true;
            }
        }
        int posX, posY;
        for (int i=0;i<nomofMines;i++)
        {
            posX = (int) (Math.random()*N);
            posY = (int) (Math.random()*N);
            if (ans[posX][posY] == true)
            {
                ans[posX][posY] = false;
            }
            else
            {
                while(ans[posX][posY] == false )
                {
                    posX = (int) (Math.random()*N);
                    posY = (int) (Math.random()*N);
                }
                ans[posX][posY] = false;
            }
        }
        return ans;
    }

    public int [][]mines (boolean [][]check)
    {
        int [][]ans = new int [check.length][check.length];
        for (int i=0;i<ans.length;i++)
        {
            for (int j=0;j<ans[i].length;j++)
            {
                ans[i][j] = 0;
            }
        }
        for (int i=0;i<ans.length;i++)
        {
            for (int j=0;j<ans[i].length;j++)
            {
                if (check[i][j] == false)
                {
                    ans[i][j] = -1;
                }
            }
        }
        return ans;
    }

    public int [][] calculvosines(int [][]mines)
    {
        int [][]arr = new int [mines.length][mines.length];
        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr[i].length;j++)
            {
                arr[i][j] = mines[i][j];
            }
        }
        int N = arr.length;
        for (int x=0;x<arr.length;x++)
        {
            for (int y=0;y<arr[x].length;y++)
            {
                if (arr[x][y] == -1)
                {
                    //On verifie les voisines du bomb
                    if ((y >= 0 && y <= N-2) && (x >=0 && x <= N-1))
                    { 
                        if (arr[x][y+1] != -1)
                        {
                            arr[x][y+1] +=1;
                        }
                    } //center right
                    if ((y >= 1 && y <= N-1) && (x >=0 && x <= N-1))
                    {
                        if (arr[x][y-1] != -1)
                        {
                            arr[x][y-1] +=1;
                        }
                    } //center left
                    if ((y >= 1 && y <= N-1) && (x >=1 && x <= N-1))
                    {
                        if (arr[x-1][y-1] != -1)
                        {
                            arr[x-1][y-1] +=1;
                        }
                    } //top left
                    if ((y >= 0 && y <= N-2) && (x >=1 && x <= N-1))
                    {
                        if (arr[x-1][y+1] != -1)
                        {
                            arr[x-1][y+1] +=1;
                        }
                    } // top right
                    if ((y >= 0 && y <= N-1) && (x >=1 && x <= N-1))
                    {
                        if (arr[x-1][y] != -1)
                        {
                            arr[x-1][y] +=1;
                        }
                    } // top center
                    if ((y >= 0 && y <= N-2) && (x >=0 && x <= N-2))
                    {
                        if (arr[x+1][y+1] != -1)
                        {
                            arr[x+1][y+1] +=1;
                        }
                    } //bottom right
                    if ((y >= 1 && y <= N-1) && (x >=0 && x <= N-2))
                    {
                        if (arr[x+1][y-1] != -1)
                        {
                            arr[x+1][y-1] +=1;
                        }
                    } //bottom left
                    if ((y >= 0 && y <= N-1) && (x >=0 && x <= N-2))
                    {
                        if (arr[x+1][y] != -1)
                        {
                            arr[x+1][y] +=1;
                        }
                    } //bottom center
                }
            }
        }
        return arr;
    }
} 