package concurrency;

import support.*;

public class ManThread extends Thread{
	private Bathroom bathroom;
	
	public ManThread(Bathroom b) {
		this.bathroom = b;
	}
	
	@Override
	public void run() {
		try {
			bathroom.enter(new Man());
			bathroom.leave();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}