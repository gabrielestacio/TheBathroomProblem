package concurrency;

import support.*;

public class WomanThread extends Thread{
	private Bathroom bathroom;
	
	public WomanThread(Bathroom b) {
		this.bathroom = b;
	}
	
	@Override
	public void run() {
		try {
			bathroom.enter(new Woman());
			bathroom.leave();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}