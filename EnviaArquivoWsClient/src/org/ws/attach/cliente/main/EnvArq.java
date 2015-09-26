package org.ws.attach.cliente.main;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.ws.attach.cliente.stub.AttachmentStub;
import org.ws.attach.cliente.stub.AttachmentStub.RecebeArquivo;
import org.ws.attach.cliente.stub.AttachmentStub.RecebeArquivoResponse;

public class EnvArq {
	public boolean enviarArquivo(File file, String pathArquivo, String nomeArquivo) {
		String host = "localhost";
		AttachmentStub stub = null; 
		try {
			stub = new AttachmentStub("http://" + host + ":8080/axis2/services/Attachment");
			RecebeArquivo recebeArquivo = new RecebeArquivo();
			
			// Prepara o arquivo para ser enviado
			DataHandler dh = new DataHandler(new FileDataSource(file));
			
			// Seta o arquivo e os parametros que devem ser enviados
			recebeArquivo.setArquivo(dh);
			recebeArquivo.setPathArquivo(pathArquivo);
			recebeArquivo.setNomeArquivo(nomeArquivo);
			
			// Efetua a chamada do web service
			RecebeArquivoResponse recebeArquivoResponse = stub.recebeArquivo(recebeArquivo);
			
			// Obtem o resultado do envio
			return recebeArquivoResponse.get_return();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		String nomeArquivo = "teste_envio.jpg";
		String dirOrigemLocal = "/Users/anderson/Temp/ws/";
		String dirDestinoServidor = "/Users/anderson/Temp/ws_server/";
		
		// Informa a localizacao no servidor do diretorio e arquivo enviado
		File arquivo = new File(dirOrigemLocal + nomeArquivo);
		EnvArq envArq = new EnvArq();
		
		// Faz uma chamada a funcao que executa o web service
		boolean ret = envArq.enviarArquivo(arquivo, dirDestinoServidor, nomeArquivo);
		
		if (ret) {
			System.out.println("Arquivo "+dirOrigemLocal+nomeArquivo+" enviado com sucesso.");
			System.out.println("Pasta de destino no servidor "+dirDestinoServidor);
		}
		else {
			System.out.println("Falha ao envia o arquivo "+dirOrigemLocal+nomeArquivo);
		}
	}
}
