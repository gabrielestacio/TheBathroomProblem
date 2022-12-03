/*PROGRAMAÇÃO CONCORRENTE
 * TRABALHO 2 - 2º UNIDADE
 * GABRIEL ESTÁCIO
 * 
 * O BANHEIRO UNISSEX*/

/*IMPLEMENTAÇÃO DO TIPO MULHER*/

package support;

public class Woman implements Person{
	private String gender; //GÊNERO ASSOCIADO À PESSOA
	
	public Woman() {
		this.gender = "Woman";
	}
	
	@Override
	public String getGender() {
		return gender;
	}
}