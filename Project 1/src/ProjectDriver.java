
public class ProjectDriver {
	private static final int NUM_BLOCKS = 4;

	public static void main(String[] args) {
		final MemoryManager memoryManager = new MemoryManager(NUM_BLOCKS);
		int x = -1, y;
		int[] z = new int[NUM_BLOCKS + 1];

		/*
		 * This could be implemented more `interpreter-y` so you don't have to
		 * try and catch each time
		 */

		System.out.println(memoryManager);
		try {
			x = memoryManager.alloc(1);
		} catch (BlockNotAvailableException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			y = memoryManager.alloc(1);
		} catch (BlockNotAvailableException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			memoryManager.free(x);
		} catch (InvalidActionException | InvalidAddressException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			memoryManager.free(0);
		} catch (InvalidActionException | InvalidAddressException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			memoryManager.free(0); // should throw InvalidAction
		} catch (InvalidActionException | InvalidAddressException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			z[0] = memoryManager.alloc(1);
		} catch (BlockNotAvailableException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			z[1] = memoryManager.alloc(1);
		} catch (BlockNotAvailableException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			z[2] = memoryManager.alloc(1);
		} catch (BlockNotAvailableException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			z[3] = memoryManager.alloc(1);
		} catch (BlockNotAvailableException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			z[4] = memoryManager.alloc(1); // should throw BlockNotAvailable
		} catch (BlockNotAvailableException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			memoryManager.free(0);
		} catch (InvalidActionException | InvalidAddressException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}
		try {
			memoryManager.free(27); // should throw InvalidAddress
		} catch (InvalidActionException | InvalidAddressException e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(memoryManager);
		}

	}
}
