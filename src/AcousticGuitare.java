
public class AcousticGuitare extends Guitare{
	
	private int _level;
	
	public AcousticGuitare(String company, int price, int level) {
		super(company, price);
		this._level = level;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		this._level = level;
	}

	@Override
	public String toString() {
		return "AcousticGuitare [_level=" + _level + "]";
	}	
}