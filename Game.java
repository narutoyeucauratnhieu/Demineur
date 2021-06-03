
// on define le numéro -1 est la mine.

// Game controller 

//import java.lang.Math;
import java.util.Scanner;

public class Game  {
    //Attributes
    Scanner sc = new Scanner(System.in);
    public int N; //taille du tableau
    public int numofMines; //nombre de mines
    public char [][]playerMap; //une variable on va traivailler sur 
    public int [][]minesMap; //une variable on va traivailler sur
    public int cellsreste; //les celles totale (N*N)
    public int score; // le score
    public int posX;    // position horizontalle on appuie
    public int posY;    // position verticalle on appuie

    //Constructors . Crée plusieur instances. 
    public Game(int N, int numofMines)
    {
        this.N = N;
        this.numofMines = numofMines;
        this.cellsreste = N*N;
    }

    //Scanner sc = new Scanner(System.in);

    LesTableau v2 = new LesTableau(); // on va travailler sur l'objet v2

    //Condition of win. Si this.cellesreste = this.numofMines, on va gagner.
    public boolean checkWin(char [][]arr)
    {
        if (this.cellsreste == numofMines ) return true;
        return false;
    }

    //Continue?
    public boolean Continue(int score)
    {
        char isContinue;
        System.out.println("Your Score: " + score);
        System.out.println("Do you want to try again (y/n)?: ");
        isContinue = sc.next().charAt(0); //appuyer y ou n 
        if(isContinue == 'n') 
        {
            return false;
        }
        return true;
    }
    //Display the map of player
    public void displayPlayerMap(char [][] arr)
    {
        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr[i].length;j++)
            {   
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    //Display the map of mines // when lose!
    public void displaysMinesMap(int [][] arr)
    {
        for (int i=0;i<arr.length;i++)
        {
            for (int j=0;j<arr[i].length;j++)
            {   
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    //All of the game controller
    public void gamePlay()
    {
        boolean status = true;   
        while (status)
        {   
            //Initing
            boolean [][]var1 = v2.check(N,numofMines); //assigne le var1 = le tableau check
            int [][]var2 = v2.mines(var1);  //assigne le var2 = le tableau mines
            playerMap = v2.generatePlayerMap(N);
            minesMap = v2.calculvosines(var2);
            score = 0;
            displayPlayerMap(playerMap);
            while (true)
            {
                if (!checkWin(playerMap))
                {
                    System.out.println("Enter the cell you want to open: ");
                    System.out.println("Attention, you must type from 0 to N-1 ");
                    System.out.println("Choose the row: ");
                    posX = sc.nextInt();
                    System.out.println("Choose the column: ");
                    posY = sc.nextInt();
                    System.out.println("If it appears 0 it means there's no bomb around! " );
                    if (minesMap[posX][posY] == -1)
                    {
                        System.out.println("You lose!");
                        displaysMinesMap(minesMap);
                        status = Continue(score);
                        break;
                    }
                    else
                    {
                        playerMap[posX][posY] = v2.echangeTab(minesMap,posX,posY);
                        displayPlayerMap(playerMap);
                        score+=1;
                        this.cellsreste--;   
                    }
                }
                else
                {
                    System.out.println("You won!");
                    displayPlayerMap(playerMap);
                    System.out.println("This is where the bomb placed!");
                    displaysMinesMap(minesMap);
                    status = Continue(score);
                    break;
                }
            }
        }
    }
}
