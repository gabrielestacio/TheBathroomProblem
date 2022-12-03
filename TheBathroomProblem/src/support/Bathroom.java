/*PROGRAMAÇÃO CONCORRENTE
 * TRABALHO 2 - 2º UNIDADE
 * GABRIEL ESTÁCIO
 * 
 * O BANHEIRO UNISSEX*/

/*CLASSE QUE IMPLEMENTA O TIPO BANHEIRO (SEÇÃO CRÍTICA)*/

package support;

import java.util.LinkedList;
import java.util.Queue;

public class Bathroom{
	public int capacity; //CAPACIDADE MÁXIMA DO BANHEIRO
	public String current_gender; //O TIPO DE PESSOA (THREAD) ATUALMENTE OCUPANDO O BANHEIRO
	public Queue<Person> occupants; //LISTA DE OCUPANTES DO BANHEIRO
	
	public Bathroom(String capacity) {
		this.capacity = Integer.parseInt(capacity);
		this.occupants = new LinkedList<Person>();
		this.current_gender = new String();
	}

	//MÉTODO QUE VERIFICA SE O BANHEIRO ESTÁ VAZIO
	public boolean empty() {
		return occupants.isEmpty();
	}
	
	//MÉTODO QUE VERIFICA SE O BANHEIRO ESTÁ LOTADO
	public boolean full() {
		return occupants.size() == capacity;
	}
	
	//MÉTODO QUE REALIZA ENTRADA NA SEÇÃO CRÍTICA
	public synchronized void enter(Person p) {
		//LAÇO QUE GARANTE QUE A CAPACIDADE MÁXIMA DO BANHEIRO SERÁ RESPEITADA. A THREAD QUE TENTAR ENTRAR ENQUANTO O BANHEIRO ESTIVER LOTADO SERÁ SUSPENSA ATÉ QUE ESTE ESTADO MUDE
		while(full()) {
			System.out.println("Sorry! The bathroom is full of " + current_gender + " at this moment. :(");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		//LAÇO QUE GARANTE QUE O TIPO DE THREAD ATUALMENTE USANDO O BANHEIRO SERÁ RESPEITADO
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
	
	//MÉTODO QUE REALIZA SAÍDA DA SEÇÃO CRÍTICA
	public synchronized void leave() {
		occupants.remove();
		notify();
	}
	
	/*GETTERS E SETTERS*/

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