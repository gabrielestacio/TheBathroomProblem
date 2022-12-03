/*PROGRAMAÇÃO CONCORRENTE
 * TRABALHO 2 - 2º UNIDADE
 * GABRIEL ESTÁCIO
 * 
 * O BANHEIRO UNISSEX*/

/*CLASSE PRINCIPAL*/

import java.util.LinkedList;
import support.*;
import concurrency.*;

public class Main{
	public static void main(String[] args) {
		LinkedList<ManThread> men = new LinkedList<ManThread>(); //LISTA DE THREADS HOMENS
		LinkedList<WomanThread> women = new LinkedList<WomanThread>(); //LISTA DE THREADS MULHERES
		Bathroom bathroom = new Bathroom(args[0]); //O BANHEIRO, OU SEJA, A SEÇÃO CRÍTICA. O CONSTRUTOR RECEBE COMO PARÂMETRO UM VALOR QUE DEFINE A CAPACIDADE MÁXIMA DO BANHEIRO

		//CRIAÇÃO DAS THREADS DE ACORDO COM A QUANTIDADE PASSADA POR PARÂMETRO AO PROGRAMA
		for(int i = 0; i < Integer.parseInt(args[1]); i++) {
			men.add(new ManThread(bathroom));
			women.add(new WomanThread(bathroom));
		}
		
		//INICIALIZAÇÃO DAS THREADS
		for(int i = 0; i < Integer.parseInt(args[1]); i++) {
			men.get(i).start();
			women.get(i).start();
		}
		
		//JOIN DAS THREADS. COM ESSE MÉTODO, GARANTIMOS QUE TODAS AS THREADS AGUARDEM PELO FIM DA EXECUÇÃO DE OUTRA THREAD PARA PODER SEREM EXECUTADAS
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