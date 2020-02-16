
public class PGElem {
	private int id;
	private ElemType type;
	private double power;

	public PGElem(int id, ElemType type, double power) {
		this.id = id;
		this.type = type;
		this.power = power;
	}

	public int getId() {
		return id;
	}

	public ElemType getType() {
		return type;
	}

	public double getPower() {
		return power;
	}
}
