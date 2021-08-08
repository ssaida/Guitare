
public abstract class Guitare {

	protected String _company;
	protected int _price;
	protected int _id;
	
	public Guitare(String company, int price) {
		this._company = company;
		this._price = price;
	}

	public String getCompany() {
		return _company;
	}

	public void getCompany(String company) {
		this._company = company;
	}

	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		this._price = price;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		this._id = id;
	}

	@Override
	public String toString() {
		return "Guitare [_company=" + _company + ", _price=" + _price + ", _id=" + _id + "]";
	}
}
