package ie.tudublin;

public class Cat extends Animal
{
    private int numLives;
    public Cat(String name)
    {
        super(name);
        numLives = 9;
    }

    public int getNumLives() {
        return numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    void kill()
    {
        if (numLives > 0)
        {
            System.out.println("Ouch!");
            numLives --;
        }
        else
        {
            System.out.println("I am dead!");
        }
    }
	//public method to allow the 
	public void killCat(){
		numLives--;
		if(numLives>0){
			System.out.println("OUCH");
		}else{
			System.out.println("DEAD");
		}//end else if statement to check if cat has ran out of lives
	}//end killCat method
}