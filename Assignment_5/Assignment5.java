import java.util.*;
public class Assignment5
{
	public static void main(String [] arg)
	{
		Donut poBoi = new Donut();
		System.out.print(poBoi);
		System.out.println();
		
		LazySusuan lazyMaid = new LazySusuan();
		lazyMaid.MakeDonuts();
		System.out.print(lazyMaid);
		
		Elvis inTheBuilding = new Elvis();
		inTheBuilding.GetDonuts(lazyMaid.lazyDonut, lazyMaid.checkDonut);
		System.out.println(inTheBuilding.toString(lazyMaid.lazyDonut, lazyMaid.checkDonut));
	}
}



class Elvis
{
	String[] ElvisDonuts = new String[3];
	Random rnd = new Random();
	
	public void GetDonuts(String[] doughNuts, boolean[] validDough)
	{
		for(int counter = 0; counter < 3; counter++)
		{
			int dn = rnd.nextInt(4);
			while(validDough[dn] == false)
			{
				dn = rnd.nextInt(4);
			}
			ElvisDonuts[counter] = doughNuts[dn];
			validDough[dn] = false;
		}
		
	}
	
	public String toString(String[] doughNuts, boolean[] validDough)
	{
		String sing = "\n\nElvis ate:\n";
		for(int i = 0; i < 3; i++)
		{
			sing += "A " + ElvisDonuts[i] + " filled donut\n";
		}
		
		sing += "\n\nThe Lazy Susan has:\n";
		
		for(int x = 0; x < 5; x++)
		{
			if(validDough[x] == true)
			{
				sing += "A " + doughNuts[x] + " filled donut\n";
			}
		}
		return sing;
	}
}

class LazySusuan
{
	Random rand = new Random();
	Donut myDonut = new Donut();
	String[] lazyDonut = new String[5];
	boolean[] checkDonut = new boolean[5];
	
	public void MakeDonuts()
	{
		for(int count = 0; count < 5; count++)
		{
			int f = rand.nextInt(7);
			lazyDonut[count] = Filling.values()[f].toString();
			checkDonut[count] = true;
		}
	}
	
	public String toString()
	{
		String contents = "\nThe Lazy Susan has:\n";
		for(int index = 0; index < 5; index++)
		{
			contents += "A " + lazyDonut[index] + " filled donut\n";
		}
		return contents;
	}
}

class Donut
{

	enum Filling
	{
		CREME, STRAWBERRY, GRAPE, APPLE, CINNAMON, BLUEBERRY, BANANA
	}
	public String toString()
	{
		String fill = "These are the Donut fillings: ";
		for(int count = 0; count < Filling.values().length; count++)
		{
			fill += Filling.values()[count];
			fill += " ";
		}
		return fill;
	}
}