package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    public void settings() {
        size(800, 800);
        cx = width / 2;
        cy = height / 2;        
    }

    int mode = 0;

    float cx;
    float cy;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    public void draw() {
        background(0);
        noStroke();
        
        switch (mode)
        {
            case 10:{
                fill(50,255,255);
                if (mouseX < cx){
                    rect(0,0,cx,height);
                }else{
                    rect(cx,0,cx,height);
                }
                break;
            }
            case 11:{
                fill(0,255,255);
                if(mouseY<cy && mouseX<cx){
                    rect(0,0,cx,cy);
                }else if(mouseY>cy && mouseX<cx){
                    rect(0,cy,cx,height);
                }else if(mouseY<cy && mouseX>cx){
                    rect(cx,0,cx,cy);
                }else{
                    rect(cx,cy,cx,height);
                }
                break;
            }
            case 2:{
                int numRects = (int)(mouseX/10.0f);
                float w = width/(float)numRects, colour=255/(float)numRects;
                for(int i=0;i<numRects;i++){
                    fill(i*colour,255,255);
                    rect(w*i,0,w,height);
                }
                break;
            }
            case 3:{
                int numCircles = (int)(mouseX/10.0f);
                float widthCircle = width/(float)numCircles, circleColour=255/(float)numCircles;
                for(int i=0;i<numCircles;i++){
                    fill(i*circleColour,255,255);
                    ellipse(widthCircle/2+(widthCircle*i),cy,widthCircle,widthCircle);
                }
                break;
            }
            case 4:{
                int numSquares = (int)(mouseX/10.0f);;
                float w = width/(float)numSquares, h = height/(float)numSquares, colour=255/(float)numSquares;
                for(int i=0; i<numSquares;i++){
                    fill(i*colour,255,255);
                    rect(w*i,h*i,w,h);
                }
                break;
            }
            case 5:{
                int numSquares = (int)(mouseX/10.0f);;
                float w = width/(float)numSquares,
                    h = height/(float)numSquares, 
                    colour=255/(float)numSquares, 
                    rightSq;

                for(int i=0; i<numSquares;i++){
                    rightSq = width-(w*i)-w;
                    fill(i*colour,255,255);
                    rect(rightSq,h*i,w,h);
                    rect(w*i,h*i,w,h);
                }
                break;
            }
            case 6:{
                int numCircles = (int)(mouseX/10.0f);;
                float w = width/(float)numCircles,
                    h = height/(float)numCircles, 
                    colour=255/(float)numCircles,
                    sizeW,sizeH;

                for(int i=0;i<numCircles;i++){
                    sizeW = width-(w*i);
                    sizeH = height-(h*i);
                    fill(255-(colour*i)-colour,255,255);
                    ellipse(cx,cy,sizeW,sizeH);
                }
                break;
            }
            case 7:{
                int numCircles = (int)(mouseX/10.0f);;
                float w = width/(float)numCircles,
                h = height/(float)numCircles,
                colour=255/(float)numCircles,radius=h/2,
                innerC;

                for(int i=0;i<numCircles;i++){
                    innerC=(colour/2)*i;
                    fill(i*colour/2,255,255);
                    ellipse(w/2+(w*i),radius,w,w);
                    for(int j=1; j<numCircles;j++){
                        innerC+=colour/4;
                        fill(innerC,255,255);
                        ellipse(w/2+(w*i),(h*j)+radius,w,w);
                    }
                }
                break;
            }
            case 8:{
                int partition = 12, counter =-5;
                float gap= width/partition;
                for(int i=1; i<partition;i++){
                    stroke(100,255,255);
                    text(counter, gap/2, gap*i);
                    text(counter, gap*i,gap/2);
                    line(gap,gap*i,gap*(partition-1),gap*i);
                    line(gap*i,gap, gap*i, gap*(partition-1));
                    counter++;
                }
                break;
            }
            case 9:{
                int numSq = 20;
                float w = width/numSq, h = height/numSq;
                boolean colourChk=true;
                for(int i =0;i<numSq;i++){
                    if(colourChk==true){
                        fill(240,100,100);
                        colourChk=false;
                    }else{
                        fill(240,255,255);
                        colourChk=true;
                    }
                    rect(w*i,h,w,h);
                    for(int j =0;j<numSq;j++){
                        if(colourChk==true){
                            fill(50,100,100);
                            colourChk=false;
                        }else{
                            fill(240,255,255);
                            colourChk=true;
                        }
                        rect(w*i,h*j,w,h);
                    }
                }
            }
            case 0:{
                int lineAmt=5;
                float r=100, a, inc = TWO_PI/(float)lineAmt;                
                for(int i=0;i<lineAmt;i++){
                    a = inc*i;
                    stroke(100,255,255);
                    line(cx,cy,cx+(sin(a)*r),cy+(cos(a)*r));
                }
                break;
            }
            case 1:{
                background(0);
                int pentLines=5;
                float r=100, a, inc = TWO_PI/(float)pentLines, x, y;                
                for(int i=0;i<pentLines-1;i++){
                    a = inc*i;
                    x = sin(a)*r%360;
                    y = cos(a)*r%360;

                    stroke(200,255,255);
                    line(cx,cy,cx+x,cy+y);
                }
                break;
            }
        }

    }
}

