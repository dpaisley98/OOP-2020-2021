package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {
    int startStar=-1,endStar=-1;
    float lX,lY,lX2,lY2,dist;
    float border;


    ArrayList<Star> stars = new ArrayList<Star>();

    

    void drawGrid(){
        border = 0.10f * width;
        textAlign(CENTER,CENTER);
        for(int i=-5;i<=5;i++){
            float x = map(i,-5,5,border,width-border);
            float y = map(i,-5,5,border,height-border);
            stroke(0,0,255);
            line(x,border,x,height-border);
            line(border,y,width-border,y);
            fill(255);
            text(i, x, border/2);
            text(i,border/2,y);
        }
    }

    void printStars(){
        for(Star s: stars){
            println(s);
        }
    }

    void loadStars(){
        Table table = loadTable("HabHYG15ly.csv", "header");
        for(TableRow row:table.rows()){
            Star s = new Star(row);
            stars.add(s);
        }
    }

    public void settings() {
        size(800, 800);
    }


    public void mouseClicked()
    {
        //border= width*0.10f;
        println("Mouse clicked");
        for(int i=0;i<stars.size();i++){
            Star s =stars.get(i);
            float x = map(s.getxG(),-5,5,border,width-border);
            float y = map(s.getyG(),-5,5,border,height-border);
            if(dist(mouseX, mouseY,x,y)<s.getAbsMag()/2){
                println(s.getDispName());
                lX = x; lY = y;
                if(startStar!=-1){
                    Star o = stars.get(startStar);
                    dist = dist(o.getxG(), o.getyG(), o.getzG(), s.getxG(), s.getyG(), s.getzG());
                    endStar=i;
                    startStar=-1;
                }else{
                    startStar=i;
                    endStar=-1;
                }
                break;
            }

        }
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();
    }

    public void drawStars(){
        for(Star s : stars){
            s.render(this);
        }
    }

    public void draw() {
        background(0);
        drawGrid();
        drawStars();
        if(!(startStar==-1)){
            line(lX,lY,mouseX,mouseY);
        }else if(endStar!=-1){
            text("The distance is "+dist, border,height-(border/2));

        }

    }
}