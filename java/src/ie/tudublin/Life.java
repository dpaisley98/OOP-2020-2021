package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {

    int size = 300;
    float cellSize,cx,cy;
    boolean[][] board = new boolean[size][size];
    boolean[][] next = new boolean[size][size];
    boolean pause = true, check=true;
    float childColour;

    public int countNeighbours(int row, int col)
    {
        childColour=0;
        int count = 0;
        
        for(int r = row -1 ; r <= row + 1; r ++)
        {
            for(int c = col -1 ; c <= col + 1; c ++)
            {
                if (! (r == row && c == col))
                {
                    if (getCell(board, r, c))
                    {
                        float colourX = map(col, 0, size, 0, 255);
                        float colourY = map(row, 0, size, 0, 255);
                        childColour += (colourX + colourY)%255;
                        count ++;
                    }
                }
            }
        }
        
        return count;
    }

    public void setCell(boolean[][] board, int row, int col, boolean b)
    {
        if (row >= 0 && row <= size -1 && col >= 0 && col <= size -1)
        {
            board[row][col] = b;
        }
    }

    public boolean getCell(boolean[][] board, int row, int col)
    {
        if (row >= 0 && row < size -1 && col >= 0 && col < size -1)
        {
            return board[row][col];
        }
        else
        {
            return false;
        }        
    }

    public void drawBoard(boolean[][] board)
    {
        // Use a nested loop
        // Use map to calculate x and y
        // Rect draw the cell
        // Use the cell size variable
        // Use some colours!
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float x = map(col, 0, size, 0, width);
                float y = map(row, 0, size, 0, height);
                float colourX = map(col, 0, size, 0, 255);
                float colourY = map(row, 0, size, 0, 255);
                float colour = (colourX + colourY)%255;
                if (board[row][col] && check==true)
                {
                    fill(colour, 255, 255);
                    rect(x, y, cellSize, cellSize);
                }
                else if (board[row][col] && check==false)
                {
                    rect(x, y, cellSize, cellSize);
                }

                check=false;
            }
        }

    }

    private void printBoard(boolean[][] board)
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                print(board[row][col] ? 1 : 0);
            }
            println();
        }        
    }

    public void randomize()
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float dice = random(0.0f, 1.0f);
                board[row][col] = (dice < 0.5f) ? true : false;
            }
        }
    }

    public void settings()
    {
        size(1704, 940);
    }
    
    int mode = 0;
    boolean paused = false;
    public void keyPressed() {
        if (keyCode == ' ')
        {
            if(pause==true){
                pause=false;
            }else{
                pause=true;
            }
        }
        
        if (keyCode == '1')
        {
            randomize();
        }
        if (keyCode == '2')
        {
            armageddon();
        }
        if (keyCode == '3')
        {
            holyCrusade();
        }
        if (keyCode == '4')
        {
            notSoHolyCrusade();
        }
            
    }

    private void notSoHolyCrusade() {

        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                if(!((row>=(size*0.4f) && row<=(size*0.6f)) || (col>=(size*0.4f) && col<=(size*0.6f)))){
                    board[row][col]=true;
                }
            }
        }

    }

    public void armageddon() {
        for(int row=0; row <size; row++){
            for(int col=0; col<size; col++){
                setCell(board, row, col, false);
            }
        }
    }

    public void holyCrusade(){
        int quarts = size/10;

        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                if((row>=(size*0.4f) && row<=(size*0.6f)) || (col>=(size*0.4f) && col<=(size*0.6f))){
                    board[row][col]=true;
                }
            }
        }
        

    }

    public void setup() {
        colorMode(HSB);
        randomize();
        
        /*
        board[0][1] = true;
        board[1][2] = true;
        board[3][2] = true;
        */
        println(countNeighbours(0, 2));

        cellSize = width / (size);
        cx = width/2;
        cy = height/2;
        
        //printBoard(board);        
    }

    private void updateBoard()
    {
        // Put code here to apply the rules!!
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                int count = countNeighbours(row,col);

                if(getCell(board, row, col)){
                    if((count==2 || count==3)){
                        fill((childColour/count),255,255);
                        setCell(next, row, col, true);
                    }//if statement to see if the cell will die
                    else if(!(count==2 || count==3)){
                        setCell(next, row, col, false);
                    }
                }else if(!(getCell(board, row, col))){
                    if(count == 3){
                        fill((childColour/count),255,255);
                        setCell(next, row, col, true);
                    }//end else/if statement to check if the cell will be born
                    else if(!(count==3)){
                        setCell(next, row, col, false);
                    }
                }//end if/else statement to see if the cell is dead or alive
            }//end for loop 
        }

        
        // Swap board and next
        boolean[][] temp = board;
        board = next;
        next = temp;
    }

    public void mouseDragged()
    {
        // This method gets called automatically when the mouse is dragged across the screen
    }

    public void draw() {
        //if((frameCount%12)==0){
        if(pause){
            background(0);
            drawBoard(board);     
            updateBoard();
        }
        
    }
}
