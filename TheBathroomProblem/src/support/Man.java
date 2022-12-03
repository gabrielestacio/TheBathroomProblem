/*PROGRAMAÇÃO CONCORRENTE
 * TRABALHO 2 - 2º UNIDADE
 * GABRIEL ESTÁCIO
 * 
 * O BANHEIRO UNISSEX*/

//IMPLEMENTAÇÃO DO TIPO HOMEM

package support;

public class Man implements Person{
	private String gender; //GÊNERO ASSOCIADO À PESSOA
	
	public Man() {
		this.gender = "Man";
	}
	
	@Override
	public String getGender() {
		return gender;
	}
}