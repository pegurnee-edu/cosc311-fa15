package edu.emich.egurnee.teach.ds.haynes.fa15.p1.ui;
import edu.emich.egurnee.teach.ds.haynes.fa15.p1.core.MemoryManager;
import edu.emich.egurnee.teach.ds.haynes.fa15.p1.exceptions.BlockNotAvailableException;
import edu.emich.egurnee.teach.ds.haynes.fa15.p1.exceptions.InvalidActionException;
import edu.emich.egurnee.teach.ds.haynes.fa15.p1.exceptions.InvalidAddressException;

public class MemoryManagerController {
	private final String[] commands;
	private final String[] exceptions;
	private final MemoryManager memoryManager;
	private final String[] output;
	private int pointer;

	public MemoryManagerController(int size, int numcommands) {
		// TODO Auto-generated constructor stub
		this.commands = new String[numcommands];
		this.exceptions = new String[numcommands];
		this.output = new String[numcommands];

		this.memoryManager = new MemoryManager(size);
		this.pointer = 0;
	}

	public int alloc(int i) {
		// TODO Auto-generated method stub
		int toReturn = -1;
		this.commands[this.pointer] = "alloc(" + i + ")";
		try {
			toReturn = this.memoryManager.alloc(i);
		} catch (BlockNotAvailableException e) {
			this.exceptions[this.pointer] = e.getMessage();
		} finally {
			this.output[this.pointer++] = this.memoryManager.toString();
		}
		return toReturn;
	}

	public void free(int x) {
		// TODO Auto-generated method stub
		this.commands[this.pointer] = "free(" + x + ")";
		try {
			this.memoryManager.free(x);
		} catch (InvalidActionException | InvalidAddressException e) {
			this.exceptions[this.pointer] = e.getMessage();
		} finally {
			this.output[this.pointer++] = this.memoryManager.toString();
		}
	}

	public void printAll() {
		for (int i = 0; i < this.commands.length; i++) {
			System.out.printf("%-12s%-58s%20s%n", this.commands[i],
				this.output[i],
				this.exceptions[i] == null ? "" : this.exceptions[i]);
		}

	}

}
