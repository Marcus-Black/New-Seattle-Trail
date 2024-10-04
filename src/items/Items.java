package items;

import items.Consumables.*;

public abstract class Items implements ItemActions{
	public double price;
	public double weight;

	public Items() {
		// TODO Auto-generated constructor stub
	}
	

	public String toString() {
		String result = this.getClass().getName();
		return result;
	}


}
