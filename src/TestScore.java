
import java.lang.reflect.Method;


public class TestScore {

	public static void main(String[] args) {
		
		
		Guitare  g,dg;
		Store   s = new Store();
		
		double totalScore=0;


		double scoreForSection=0;
		/////////////////
		//check if all methods are public  2p
		Method[] arrayOfMethods = s.getClass().getMethods();
		for(Method m:arrayOfMethods){
			if(m.getName().equals("addGuitare"))
				scoreForSection+=1;
			if(m.getName().equals("sellGuitare"))
				scoreForSection+=1;
			if(m.getName().equals("searchByGuitareType"))
				scoreForSection+=1;
			if(m.getName().equals("expensiveGuitarePrice"))
				scoreForSection+=1;
			if(m.getName().equals("higherLevelPrice"))
				scoreForSection+=1;
		}

		if (scoreForSection<5)
			System.out.println("Not all Methods were public / -1p for each  method");

		
		totalScore += scoreForSection;
		
		///////////////////////
		//	check Store functions  6p
	
		
		// Check add and toString
		scoreForSection = 0;
		boolean goodid = true;
			g=new ElectricGuitare("ABCD",100,1.5);
			
			
			if(!g.toString().contains("ABCD")||!g.toString().contains("100")|| !g.toString().contains("1.5"))
				System.out.println("Not all in ElectricGuitare toString / -4p");
			else scoreForSection+=2;
			
			s.addGuitare(g);
			int a1 =g.getId();
			g = new ClassicGuitare("EFG", 2000);
			dg = g;
			if(!g.toString().contains("EFG")|| !g.toString().contains("200"))
				System.out.println("ClassicGuitare toString is not correct /-4p");
			else scoreForSection+=2;
			s.addGuitare(g);
			if (a1==g.getId())goodid = false;

			scoreForSection+=1;
			
			g = new AcousticGuitare("HIJK", 300,5);
			if(!g.toString().contains("HIJK")|| !g.toString().contains("5"))
				System.out.println(" AcousticGuitare toString us not correct/-3p");
			else scoreForSection+=2;
			s.addGuitare(g);
			if(a1== g.getId())goodid = false;
			g = new AcousticGuitare("HIJK", 400, 6);
			s.addGuitare(g);
		
			g = new AcousticGuitare("HIJK", 350, 7);
			s.addGuitare(g);

		//4p
		if(s.toString().contains("ABCD") && s.toString().contains("EFG")&& s.toString().contains("HIJK") ){
			scoreForSection+=4;
		} else {
			System.out.println("some Elementes weren't added according to toString()... / -4p");
		}
		//4p
		if(goodid)scoreForSection+=4;
		else System.out.println("Guitare does not get good id/ -4p");
		totalScore+=scoreForSection;
		///////////////////////////////////////////////
		//// check expensiveGuitarePrice  6p
		
		scoreForSection=0;
		int x = s.expensiveGuitarePrice();
		if(x == 2000)
				scoreForSection+=5;
			else System.out.println("2000 should be expensiveGuitarePrice and not "+x+" / -5p");
		
		totalScore += scoreForSection;

		
		///////////////////////
		//	check higherLevelPrice  6p
		scoreForSection = 0;
		if(s.higherLevelPrice()==350)
			scoreForSection +=5;
		else
			System.out.println("350 = higherLevelPrice() and not "+s.higherLevelPrice()+" /-5p");
		totalScore += scoreForSection;
		
//		Check sellGuitare 4p
		scoreForSection=0;
		s.sellGuitare(dg.getId());
		if(s.toString().contains("EFG") || s.toString().contains("2000") ){
			System.out.println("sellGuitare is not correct according to toString()... / -5p");
		} else {
			scoreForSection+=5;
		}
		totalScore += scoreForSection;
		
		//Check searchByGuitareType
		scoreForSection=0;
		boolean good = true;
	
		Guitare[] d = s.searchByGuitareType("ElectricGuitare");
		for(int i=0; i<d.length;i++)
			if (d[i] == null)good = false;
		if(d.length!=1)good = false;
		if(good)scoreForSection+=5;
		else System.out.println("searchByGuitareType is not good / -5p ");
		good = true;
		d = s.searchByGuitareType("ClassicGuitare");
		for(int i=0; i<d.length;i++)
			if (d[i] == null)good = false;
		if(d.length!=0)good = false;
		if(good)scoreForSection+=2;
		else System.out.println("searchByGuitareType is not good for empty array/ -2p ");
		totalScore += scoreForSection;

		System.out.println(totalScore);

	}

}
