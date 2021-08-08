
public class ElectricGuitare extends Guitare{

	private double _voltage;
	
	public ElectricGuitare(String company, int price, double voltage) {
		super(company, price);
		this._voltage = voltage;
	}

	public double getVoltage() {
		return _voltage;
	}

	public void set_voltage(double voltage) {
		this._voltage = voltage;
	}

	@Override
	public String toString() {
		return "ElectricGuitare [_voltage=" + _voltage + "]";
	}
}