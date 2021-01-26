package ie.tudublin;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");

        Animal misty = new Dog("Misty");

        Animal topCat = new Cat("TopCat");

        System.out.println(misty);
        System.out.println(topCat);

        misty = topCat;

        topCat.setName("Garfield");

        System.out.println(misty);
        System.out.println(topCat);
		
		Cat ginger = new Cat("Ginger");
		
		while(ginger.getNumLives()!=0){
			ginger.killCat();
			
		}//end while loop
		System.out.println("End of program");


    }
} 