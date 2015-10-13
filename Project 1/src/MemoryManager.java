
public class MemoryManager {
	private final MemoryList freeList;
	private final MemoryList usedList;

	public MemoryManager(int sizeLimit) {
		this.usedList = new MemoryList();
		this.freeList = new MemoryList();

		for (int i = 0; i < sizeLimit; i++) {
			this.freeList.push(i);
		}
	}

	public int alloc(int i) throws BlockNotAvailableException {
		if (this.freeList.isEmpty()) {
			throw new BlockNotAvailableException();
		}
		int item = this.freeList.pop();
		this.usedList.push(item);
		return item;
	}

	public void free(int i)
			throws InvalidActionException, InvalidAddressException {
		if (this.freeList.contains(i)) {
			throw new InvalidActionException();
		}
		if (!this.usedList.remove(i)) {
			throw new InvalidAddressException();
		}
		this.freeList.push(i);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MemoryManager [freeList="+ this.freeList + ", usedList="
				+ this.usedList + "]";
	}

}
