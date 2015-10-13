public class MemoryList {

	private class MemoryListNode {
		int data;
		MemoryListNode next;

		private MemoryListNode(int i, MemoryListNode next) {
			this.data = i;
			this.next = next;
		}
	}

	private MemoryListNode top;

	public MemoryList() {
		this.top = null;
	}

	public boolean contains(int i) {
		boolean toReturn = false;
		if (this.top != null) {
			if (this.top.data == i) {
				toReturn = true;
			} else {
				MemoryListNode temp = this.top;
				while (temp.next != null) {
					temp = temp.next;
					if (temp.data == i) {
						toReturn = true;
						break;
					}
				}
			}
		}
		return toReturn;
	}

	public boolean isEmpty() {
		return this.top == null;
	}

	public int pop() {
		int item = this.top.data;
		this.top = this.top.next;
		return item;
	}

	public void push(int i) {
		if (this.top == null) {
			this.top = new MemoryListNode(i, null);
		} else {
			this.top = new MemoryListNode(i, this.top);
		}
	}

	public boolean remove(int i) {
		boolean toReturn = false;
		if (this.top.data == i) {
			this.top = this.top.next;
		} else {
			MemoryListNode prev;
			MemoryListNode runner = this.top;
			while (runner.next != null) {
				prev = runner;
				runner = runner.next;
				if (runner.data == i) {
					prev.next = runner.next;
					toReturn = true;
					break;
				}
			}

		}
		return toReturn;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String toReturn = "";
		for (MemoryListNode temp = this.top; temp != null; temp = temp.next) {
			toReturn += temp.data + " ";
		}
		return toReturn;
	}

}
