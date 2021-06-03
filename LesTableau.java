import java.lang.Math;

public class LesTableau {  
    public LesTableau() //constructeurs
    {
    }
    public char [][] generatePlayerMap(int N) //Le map initial du joueur
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

    public char echangeTab(int [][]arr, int x, int y) //convert from a character to an int
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
            if (ans[posX][posY] == true) //si la nouvelle mine n'est pas dans la carte de check 
            {
                ans[posX][posY] = false;
            }
            else   //si la nouvelle mine est dans la carte de check
            {
                while(ans[posX][posY] == false ) // on regenerate la position verticale et horizontale des mines
                {
                    posX = (int) (Math.random()*N);
                    posY = (int) (Math.random()*N);
                }
                ans[posX][posY] = false;
            }
        }
        return ans;
    }

    public int [][]mines (boolean [][]check) // on convert de un tableau de boolean à int
    {
        int [][]ans = new int [check.length][check.length];
        for (int i=0;i<ans.length;i++) //initiale 
        {
            for (int j=0;j<ans[i].length;j++)
            {
                ans[i][j] = 0;
            }
        }
        for (int i=0;i<ans.length;i++) //if check[i][j] = false, on laisse ans[i][j] = -1
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

    public int [][] calculvosines(int [][]mines) //on calcul les voisines du bombe 
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
                    if ((y >= 0 && y <= N-2) && (x >=0 && x <= N-1)) //center right
                    { 
                        if (arr[x][y+1] != -1)
                        {
                            arr[x][y+1] +=1;
                        }
                    } 
                    if ((y >= 1 && y <= N-1) && (x >=0 && x <= N-1))//center left
                    {
                        if (arr[x][y-1] != -1)
                        {
                            arr[x][y-1] +=1;
                        }
                    } 
                    if ((y >= 1 && y <= N-1) && (x >=1 && x <= N-1)) //top left
                    {
                        if (arr[x-1][y-1] != -1)
                        {
                            arr[x-1][y-1] +=1;
                        }
                    } 
                    if ((y >= 0 && y <= N-2) && (x >=1 && x <= N-1)) // top right
                    {
                        if (arr[x-1][y+1] != -1)
                        {
                            arr[x-1][y+1] +=1;
                        }
                    } 
                    if ((y >= 0 && y <= N-1) && (x >=1 && x <= N-1)) // top center
                    {
                        if (arr[x-1][y] != -1)
                        {
                            arr[x-1][y] +=1;
                        }
                    } 
                    if ((y >= 0 && y <= N-2) && (x >=0 && x <= N-2)) //bottom right
                    {
                        if (arr[x+1][y+1] != -1)
                        {
                            arr[x+1][y+1] +=1;
                        }
                    } 
                    if ((y >= 1 && y <= N-1) && (x >=0 && x <= N-2)) //bottom left
                    {
                        if (arr[x+1][y-1] != -1)
                        {
                            arr[x+1][y-1] +=1;
                        }
                    } 
                    if ((y >= 0 && y <= N-1) && (x >=0 && x <= N-2)) //bottom center
                    {
                        if (arr[x+1][y] != -1)
                        {
                            arr[x+1][y] +=1;
                        }
                    } 
                }
            }
        }
        return arr;
    }
} 
