/*PROGRAMAÇÃO CONCORRENTE
 * TRABALHO 2 - 2º UNIDADE
 * GABRIEL ESTÁCIO
 * 
 * O BANHEIRO UNISSEX*/

/*IMPLEMENTAÇÃO DAS THREADS DO TIPO MULHER*/

package concurrency;

import support.*;

public class WomanThread extends Thread{
	private Bathroom bathroom; //BANHEIRO (SEÇÃO CRÍTICA) AO QUAL ESSA MULHER (THREAD) TEM ACESSO
	
	public WomanThread(Bathroom b) {
		this.bathroom = b;
	}
	
	@Override
	public void run() {
		//A MULHER TENTA ENTRAR NO BANHEIRO, E AO ENTRAR, PRECISA SAIR PARA LIBERAR A CAPACIDADE
		try {
			bathroom.enter(new Woman());
			bathroom.leave();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}