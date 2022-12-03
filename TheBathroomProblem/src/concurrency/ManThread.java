/*PROGRAMAÇÃO CONCORRENTE
 * TRABALHO 2 - 2º UNIDADE
 * GABRIEL ESTÁCIO
 * 
 * O BANHEIRO UNISSEX*/

/*IMPLEMENTAÇÃO DAS THREADS DO TIPO HOMEM*/

package concurrency;

import support.*;

public class ManThread extends Thread{
	private Bathroom bathroom; //BANHEIRO (SEÇÃO CRÍTICA) AO QUAL ESSE HOMEM (THREAD) TEM ACESSO
	
	public ManThread(Bathroom b) {
		this.bathroom = b;
	}
	
	@Override
	public void run() {
		//O HOMEM TENTA ENTRAR NO BANHEIRO, E AO ENTRAR, PRECISA SAIR PARA LIBERAR A CAPACIDADE
		try {
			bathroom.enter(new Man());
			bathroom.leave();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}