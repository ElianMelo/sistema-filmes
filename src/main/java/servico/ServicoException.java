/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 17/04/2019
Resumo: Service para tratar os erros obtidos a partir do uso de services
Refer�ncia ao enunciado/origem do exerc�cio: https://www.youtube.com/user/educandoweb/videos?view=0&sort=da&flow=grid
*/

package servico;

public class ServicoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	
	public ServicoException(String msg, Integer codigo) {
		super(msg);
		this.codigo = codigo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
}
