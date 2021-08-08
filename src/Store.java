
import java.util.ArrayList;

public class Store {
	private ArrayList<Guitare> guitars;
	private int id;
	
	public Store() {
		guitars = new ArrayList<Guitare>();
		id = 0;
	}
	
	public void addGuitare(Guitare g) {
		g.setId(id++);
		guitars.add(g);
	}
	
	public void sellGuitare(int id) {	
		for (int i = 0; i < guitars.size(); i++) {
			Guitare g = guitars.get(i);
			if (g.getId() == id){
				guitars.remove(g);
				break;
			}
		}
	}
	
	public Guitare [] searchByGuitareType(String type)  {
		ArrayList<Guitare> arr = new ArrayList<Guitare>();
		for (Guitare g: guitars) {
			if (type.equals("AcousticGuitare"))
				if (g instanceof AcousticGuitare)
					arr.add(g);
			if (type.equals("ClassicGuitare"))
				if (g instanceof ClassicGuitare)
					arr.add(g);
			
			if (type.equals("ElectricGuitare"))
				if (g instanceof ElectricGuitare)
					arr.add(g);
		}	
		Guitare [] arrFinal = new Guitare[arr.size()];
		
		// copy to final array
		for (int i = 0; i < arr.size(); i++)
			arrFinal[i] = arr.get(i);
		
		return arrFinal;
	}
	
	public int expensiveGuitarePrice(){

		int maxPrice = 0;
		for (Guitare g: guitars) {
			if (g.getPrice() > maxPrice)
				maxPrice = g.getPrice();
		}
		
		return maxPrice;
	}
	
	public int  higherLevelPrice(){
		int maxLevel = 0;
		boolean first = true;
		int price = 0;
		for (Guitare g: guitars) {
			if (g instanceof AcousticGuitare) {
				if (first) {
					maxLevel = ((AcousticGuitare) g).getLevel();
					first = false;
					price = g.getPrice();
				}
				else {
					int level = ((AcousticGuitare) g).getLevel();
					if (level > maxLevel) {
						maxLevel = level;
						price = g.getPrice();
					}
				}
					
			}
		}
		return price;
	}

	public ArrayList<Guitare> getGuitars() {
		return guitars;
	}

	public void setGuitars(ArrayList<Guitare> guitars) {
		this.guitars = guitars;
	}

	@Override
	public String toString() {
		return "Store [guitars=" + guitars + "]";
	}
	
	
}
