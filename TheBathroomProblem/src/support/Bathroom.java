package support;

import java.util.LinkedList;
import java.util.Queue;

/*FALTA FAZER COM QUE OS PROCESSOS QUE ESTÃO ESPERANDO ENTREM NA ÁREA CRÍTICA*/

public class Bathroom{
	public int capacity;
	public String current_gender;
	public Queue<Person> occupants;
	
	public Bathroom(String capacity) {
		this.capacity = Integer.parseInt(capacity);
		this.occupants = new LinkedList<Person>();
		this.current_gender = new String();
	}

	public boolean empty() {
		return occupants.isEmpty();
	}
	
	public boolean full() {
		return occupants.size() == capacity;
	}
	
	public synchronized void enter(Person p) {
		while(full()) {
			System.out.println("Sorry! The bathroom is full of " + current_gender + " at this moment. :(");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		while((current_gender != p.getGender()) && (!empty())) {
			System.out.println("Sorry! This bathroom is being used by " + current_gender + " right now. :(");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		current_gender = p.getGender();
		occupants.add(p);
		System.out.println("Yeah, " + current_gender + "! You can go relieve yourself now! :D");
		notify();
	}
	
	public synchronized void leave() {
		occupants.remove();
		notify();
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getCurrentGender() {
		return current_gender;
	}

	public void setCurrentGender(String current_gender) {
		this.current_gender = current_gender;
	}

	public Queue<Person> getOccupants() {
		return occupants;
	}

	public void setOccupants(Queue<Person> occupants) {
		this.occupants = occupants;
	}
}