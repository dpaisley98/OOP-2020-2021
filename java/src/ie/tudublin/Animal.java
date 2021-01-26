package ie.tudublin;

public class Animal
{

    public String toString()
    {
        return name;
    }

    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public Animal(String name)
    {
        this.name = name;
    }
}