package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
public class NaiveInventory implements Inventory {

	private static final int INITIAL_CAPACITY = 100;

	private Collectible[] items; // may be longer than the number of real items
	private int count; // how many cells are actually used

	public NaiveInventory() {
		items = new Collectible[INITIAL_CAPACITY];
		count = 0;
	}

	@Override
	public void collect(Collectible collectible) {
		if (count == items.length) { // full → grow
			Collectible[] bigger = new Collectible[items.length * 2];
			for (int i = 0; i < count; i++) {
				bigger[i] = items[i]; // same order
			}
			items = bigger; // the field now points to the new array
		}
		items[count] = collectible;
		count++;
	}

	@Override
	public float getTotalWeight() {
		float total = 0;
		for (int i = 0; i < count; i++) { // only the real items
			total += items[i].getWeight();
		}
		return total;
	}

	@Override
	public int getCurrentCount() {
		return count;
	}

	// Returns the array of Collectibles that is stored in the field of this class
	public Collectible[] getCollArr() {
		return items;
	}
}