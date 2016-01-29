package ro.tm.siit.homework.w8d13.SportsCar;

import java.util.Arrays;
/**
 * Test class for SportsCar
 * @author mircea
 *
 */
public class SportsCarTest {

	public static void main(String[] args) {
		SportsCar[] sportCar = new SportsCar[6];
		
		sportCar[0]=new SportsCar("Chevrolet","Corvette", 460, 180);
		sportCar[1]=new SportsCar("Porsche","Cayman", 340, 170);
		sportCar[2]=new SportsCar("Mercedes","AMG GT", 456, 190);
		sportCar[3]=new SportsCar("Audi","R8", 456, 190);
		sportCar[4]=new SportsCar("Mercedes","AMG GT-S", 456, 190);
		sportCar[5]=new SportsCar("MyCar","flash", 2000, 1000);
		
		p(sportCar);
	}
	/**
	 * Method to scan the array for duplicates.
	 * If found prints information about at least one duplicate.
	 * @param sport
	 */
	public static void p(SportsCar[] sport) {
		int index = 0;
		int counter = 1;
		boolean flag = false;
		
		for (int i = 0; i < sport.length; i++) {
			for (int k=i+1;k<sport.length;k++)
			    if (k!=i && sport[k].equals(sport[i])){
			    	flag=true;
			    	counter++;
			    	index=i;
			    }
		}
		if(flag){
			System.out.println("Found at least "+counter+" car matching: "+"\n"+sport[index].toString());
		}else{
			System.out.println("there are no equal cars in this lot");
		}
	
	}

}