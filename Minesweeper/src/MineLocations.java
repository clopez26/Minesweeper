import java.util.ArrayList;
import java.util.Random;

public class MineLocations 
 {	
	private  Coordinates[]  mine;
	public static int[] XCORD;
	public static int[] YCORD;

	public MineLocations(int l)
	 {
		 XCORD = new int[l];
		 YCORD = new int[l];
		 mine= new Coordinates[l];
	 }
	
	public Coordinates [] getMinesPosition() 
	 {	
		 return mine;
	 }
	
	public void setCoordinate()
	 {
		Random number = new Random();

		for(int i=0;i<10;i++)
		 {
			int x_coordinate = number.nextInt(9);
			int y_coordinate = number.nextInt(9);
			mine[i] = new Coordinates(x_coordinate, y_coordinate);	
		 }

		int xcord [] = new int[10];
		int ycord[] = new int[10];
		for(int i=0;i<10;i++)
		 {
			xcord[i] = mine[i].getX();
			ycord[i] = mine[i].getY();
		 }
	 }

	public boolean Coord_Comparison(int x, int y, Coordinates c) 
	 { // Method to compare two different coordinates	
		 return x == c.getX() && y == c.getY();			
	 }

	public boolean Coordinate_Compare(int x, int y ) 
	 {
		for(int i=0; i < mine.length; i++)
		 { 
			if(Coord_Comparison(x, y, mine[i]))
			 {
				return true;
			 }	
		 }
		return false;	
	}

	public boolean Nearby_Mines( int a, int b)   
	{
		if(Coordinate_Compare(a+1,b)|| 
		   Coordinate_Compare(a-1,b)||
	       Coordinate_Compare(a,b+1)||
		   Coordinate_Compare(a,b-1)||
		   Coordinate_Compare(a-1,b-1)||
		   Coordinate_Compare(a+1,b+1)||
		   Coordinate_Compare(a-1,b+1)||
		   Coordinate_Compare(a+1,b-1))
		 
		{
			return true;
		}
		return false;
	}

	public int  Nearby_Mines_Counter(int  x, int y) 
	{
		int counter = 0 ;
		for (int i = x-1; i <= x+1; i++) 
		 {
			for (int j = y-1; j <= y+1; j++) 
			 {
				 if (!(i==x && j == y))
				  {
					if (Coordinate_Compare(i,j))
					 {
						counter++;	
					 }
				  }	
			 }
		}
		return counter;
	}
 }
