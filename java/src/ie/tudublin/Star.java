package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star {
    private boolean hab;
    private String dispName;
    private float distance;
    private float xG,yG,zG;
    private float absMag;

    public Star(){}

    public Star(TableRow row){
        //constructor chaining
        this(
            row.getInt("Hab?") == 1 ? true : false,
            row.getString("Display Name"),
            row.getFloat("Distance"),
            row.getFloat("Xg"),
            row.getFloat("Yg"),
            row.getFloat("Zg"),
            row.getFloat("AbsMag")
        );

    }

    public Star(boolean hab, String dispName, float distance, float xG, float yG, float zG, float absMag){
        this.hab = hab;
        this.dispName = dispName;
        this.distance = distance;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
    }

    public void render(PApplet pa){
        float border =pa.width * 0.10f;
        float x = PApplet.map(xG,-5,5,border,pa.width-border);
        float y = PApplet.map(yG,-5,5,border,pa.height-border);
        
        pa.stroke(255,255,0);
        pa.line(x-5,y,x+5,y);
        pa.line(x,y-5,x,y+5);
        pa.noFill();
        pa.stroke(255,0,0);
        pa.circle(x, y, absMag);
        pa.textAlign(PApplet.LEFT,PApplet.CENTER);
        pa.text(dispName, x+10, y);

    }

    public boolean isHab() {
        return hab;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }

    public String getDispName() {
        return dispName;
    }

    public void setDispName(String dispName) {
        this.dispName = dispName;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getxG() {
        return xG;
    }

    public void setxG(float xG) {
        this.xG = xG;
    }

    public float getyG() {
        return yG;
    }

    public void setyG(float yG) {
        this.yG = yG;
    }

    public float getzG() {
        return zG;
    }

    public void setzG(float zG) {
        this.zG = zG;
    }

    public float getAbsMag() {
        return absMag;
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    @Override
    public String toString() {
        return "Star [absMag=" + absMag + ", dispName=" + dispName + ", distance=" + distance + ", hab=" + hab + ", xG="
                + xG + ", yG=" + yG + ", zG=" + zG + "]";
    }

    
}
