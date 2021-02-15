package ie.tudublin;

public class Cat extends Animal
{
	private int numLives;
	
	public int getNumLives(){
		return numLives;
	}
    public Cat(String name)
    {
        super(name);
		this.numLives=9;
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