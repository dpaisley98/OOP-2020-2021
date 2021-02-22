package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet {
    int size = 100;
    float cellSize;
    boolean[][] board = new boolean[size][size];


    public int countCellsAround(int row, int col){
        int count = 0;
        for(int i=row-1;i<row+2;i++){
            for(int j =col-1;j<col+2;j++){
                if(!(i==row && j==col)){
                    if(board[i][j]==true){
                        count=count+1;
                    }
                }
            }
        }
        return count;
    }

    public void setCell(int row, int col, boolean B, boolean[][] board){
        if(row>0 && row<size-1 && col>0 && col<size-1){
            board[row][col] = B;
        }
    }

    public boolean getCell(boolean[][] board, int row, int col){
        if(row>0 && row<size-1 && col>0 && col<size-1){
            return board[row][col];
        }else{
            return false;
        }
    }

    public void drawBoard(boolean[][] board){
        background(0);
        for(int row=0;row<size;row++){
            for(int col=0;col<size;col++){
                float x = map(col, 0, size, 0, width);
                float y = map(row,0,size,0,height);
                float c1 = map(row+col,0,size,0,height)%255;
                float c2 = map(col,0,size,0,width)%255;
                float colour = (c1*c2)%255;

                fill(colour,255,255);
                //print(board[row][col] ? 1 : 0);
                if(board[row][col]){
                    rect(x,y,cellSize,cellSize);
                }

            }
            println();
        }

    }

    private void printBoard(boolean[][] board){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                print(board[row][col] ? 1 : 0);

            }
            println();

        }


    }

    public void randomize(){
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                float dice = random(0.0f, 1.0f);
            /*
                if(dice < 0.5f){
                    board[row][col] = true;
                }else{
                    board[row][col] = false;
                }//end if/else statement
            */
                board[row][col] = (dice < 0.5f) ? true : false;
            }
        }
    }

    public void settings(){
        size(500, 500);
    }
    int mode = 0;
    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
        //randomize();
        board[1][1]=true;
        board[1][2]=true;
        board[2][2]=true;
        cellSize = width/(size);
        printBoard(board);
        drawBoard(board);
        print(getCell(board,1,2));
        print(countCellsAround(1,2));
    }


    public void draw() {
       // background(0);
    }
}
