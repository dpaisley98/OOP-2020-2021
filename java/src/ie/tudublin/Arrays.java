package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    public float map1(float from, float start, float stop, float start2, float stop2){
        
        float range =  start + stop;
        float map = from/range;
        range = start2 + stop2;
        
        return range*map;
    }

    public void drawGrid(){

        float border = width * .05f;
        textAlign(CENTER, CENTER);
        for(int i =-5; i<=5;i++){
            float x = map1(i, -5, 5, border, width -border);
            line(x, border, x, height-border);
            line(border, x, width-border, x);
            fill(255,255,255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);

        }

    }

    public void settings() {
        size(500, 500);           
        float f = map1(2, 0, 10, 0, width);     
        println(f);

        f=map1(9, 0, 1, 0, 10);
        println(f);

        f = map1(250, 200, 300, 400, 500);
        println(f);

        f = map1(5, 0, 10, 1000, 2000);
        println(f);


    }

    int mode = 0;
    float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
    String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
    float[] arr = new float[1000];

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
        for(int i =0;i< rainFall.length ;i++){
            println(months[i]+"\t"+rainFall[i]);
        }

        float max=rainFall[0], min=rainFall[0],sum=0,average;
        for(float f: rainFall){
            println(f);
            if(max<f){
                max=f; 
            }if(min>f){
                min=f;
            }
            sum=sum+f;
        }

        average=sum/rainFall.length;
        println("MAX:"+max);
        println("MIN:"+min);
        println("SUM:"+sum);
        println("AVERAGE:"+average);
        background(0);
        float w = width/rainFall.length;
        fill(255,255,255);
        for(int i=0;i<rainFall.length;i++){
            fill(random(255),255,255);
            rect(w*i,height-100,w,(rainFall[i])*-1.0f);
            text(months[i], w*i, height-50);
        }


    }

    float offset = 0;

    public void draw() {
      //  background(0);
      //  noStroke();
      //  drawGrid();
    }
}
