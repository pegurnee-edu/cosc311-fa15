
public class ProjectDriverWithController {
	private static final int NUM_BLOCKS = 4;
	private static final int NUM_COMMANDS = 12;

	public static void main(String[] args) {
		int x = -1, y;
		int[] z = new int[NUM_BLOCKS + 1];

		/*
		 * This could be implemented more `interpreter-y` so you don't have to
		 * try and catch each time
		 */
		MemoryManagerController ui = new MemoryManagerController(NUM_BLOCKS, NUM_COMMANDS);
		x = ui.alloc(1);
		y = ui.alloc(1);
		ui.free(x);
		ui.free(0);
		ui.free(0); // should throw InvalidAction
		z[0] = ui.alloc(1);
		z[1] = ui.alloc(1);
		z[2] = ui.alloc(1);
		z[3] = ui.alloc(1);
		z[4] = ui.alloc(1); // should throw BlockNotAvailable
		ui.free(0);
		ui.free(27); // should throw InvalidAddress

		ui.printAll();

	}
}
