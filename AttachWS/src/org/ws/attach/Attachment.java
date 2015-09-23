package org.ws.attach;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class Attachment {
	
	// Esse web mothod retorna um arquivo solicitado
	public DataHandler retornaArquivo(String pathArquivo, String nomeArquivo) {
		try {
			// Criando objeto que aponta para o arquivo requisitado
			File file = new File(pathArquivo + nomeArquivo);

			// Criando o objeto que irá retornar o arquivo
			DataHandler dh = new DataHandler(new FileDataSource(file));
			
			// Retornando o arquivo
			return dh;
		} catch (Exception ex) {
			return null;
		}
	}
	
	// Esse web method recebe um arquivo e irá persistí-lo localmente
	public boolean recebeArquivo(DataHandler arquivo, String pathArquivo, String nomeArquivo) {
		// Verifica se o arquivo recebido é nulo
		if (arquivo == null) {
			return false;			
		}
		
		try {
			// Criando o arquivo de destino para persistí-lo em disco
			File novoArquivo = new File(pathArquivo + nomeArquivo);
			OutputStream out = new FileOutputStream(novoArquivo);
			
			// Persistindo arquivo recebido em disco
			arquivo.writeTo(out);
			return true;			
		} catch (Exception ex) {
			return false;
		}
	}
}
