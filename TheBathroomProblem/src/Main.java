import java.util.LinkedList;
import support.*;
import concurrency.*;

public class Main{
	public static void main(String[] args) {
		LinkedList<ManThread> men = new LinkedList<ManThread>();
		LinkedList<WomanThread> women = new LinkedList<WomanThread>();
		Bathroom bathroom = new Bathroom(args[0]);

		for(int i = 0; i < Integer.parseInt(args[1]); i++) {
			men.add(new ManThread(bathroom));
			women.add(new WomanThread(bathroom));
		}
		
		for(int i = 0; i < Integer.parseInt(args[1]); i++) {
			men.get(i).start();
			women.get(i).start();
		}
		
		try {
			for (int i = 0; i < Integer.parseInt(args[1]); i++) {
				men.get(i).join();
				women.get(i).join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}