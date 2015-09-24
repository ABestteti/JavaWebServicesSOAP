package org.ws.attach.cliente.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;

import org.ws.attach.cliente.stub.AttachmentStub;
import org.ws.attach.cliente.stub.AttachmentStub.RetornaArquivo;
import org.ws.attach.cliente.stub.AttachmentStub.RetornaArquivoResponse;

public class RecArq {
	public static void main(String[] args) {
		// Informa o diretório onde se encontra o arquivo desejado
		String path = "D:/TEMP/";
		String dstPath = null;
		
		if (args.length == 0) {
			dstPath = "D:/TEMP/WS/";
		}
		else {
			dstPath = args[0];
		}
	    
		// Informa o nome do arquivo
		String nomeArquivo = "URHNI_TABELAS_20120720.xls";

		try {
			// Cria um objeto que aponta para o web service
			AttachmentStub stub = new AttachmentStub("http://10.0.50.152:8080/axis2/services/Attachment");
			
			// Cria um objeto para sertar os valores que devem ser enviados
			RetornaArquivo retornaArquivo = new RetornaArquivo();
			retornaArquivo.setPathArquivo(path);
			retornaArquivo.setNomeArquivo(nomeArquivo);
			
			// Executa a chamada ao web service para receber o arquivo
			RetornaArquivoResponse retornaArquivoResponse = stub.retornaArquivo(retornaArquivo);
			
			// Transfere o arquivo recebido para um objeto DataHandler
			DataHandler dh = retornaArquivoResponse.get_return();
			
			// Cria o arquivo no destino
			File novoArquivo = new File(dstPath + nomeArquivo);
			
			OutputStream out = new FileOutputStream(novoArquivo);
			
			// Escreve os dados do arquivo recebido no sistema de arquivo local
			dh.writeTo(out);
			System.out.println("Arquivo " + nomeArquivo + " recebido com sucesso.\n");
			System.out.println("Arquivo gravado em " + dstPath);
		} catch (Exception e) {
			System.out.println("Falha ao receber arquivo " + nomeArquivo);
		}
	}
}
