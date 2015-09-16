package org.ws.calc.cliente.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.ws.calc.cliente.stub.CalculadoraStub;


public class CalcView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField tfValor1;
	private JTextField tfValor2;
	private JButton bLimpar;
	private JButton bSoma;
	private JButton bSubtracao;
	private JButton bMultiplicacao;
	private JButton bDivisao;
	private JLabel lValor1;
	private JLabel lValor2;
	private JLabel lResultado;
	private JLabel lResultadoLabel;
	private JLabel lOperacao;
	private JLabel lOperacaoLabel;
	private JPanel pPanelLeft;
	private JPanel pPanelRight;
	private JPanel pPanelCenter;
	DecimalFormat df = new DecimalFormat("###,##0.00");
	
	//Construtor
	public CalcView() {
		super("Calculador");
		pPanelRight = new JPanel();
		pPanelLeft = new JPanel();
		pPanelCenter = new JPanel();
		lValor1 = new JLabel("Valor 1:");
		lValor2 = new JLabel("Valor 2:");
		lResultado = new JLabel("");
		lResultadoLabel = new JLabel("Resultado:");
		lOperacao = new JLabel("");
		lOperacaoLabel = new JLabel("Operação:");
		tfValor1 = new JTextField("");
		tfValor2 = new JTextField("");
		bLimpar = new JButton("Limpar");
		bSoma = new JButton("Soma");
		bSubtracao = new JButton("Subtração");
		bMultiplicacao = new JButton("Multiplicação");
		bDivisao = new JButton("Divisão");
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(1,3));
		pPanelLeft.setLayout(new GridLayout(4,1));
		pPanelCenter.setLayout(new GridLayout(4, 1));
		pPanelRight.setLayout(new GridLayout(5, 1));
		cp.add(pPanelLeft);
		cp.add(pPanelCenter);
		cp.add(pPanelRight);
		pPanelLeft.add(lValor1);
		pPanelLeft.add(lValor2);
		pPanelLeft.add(lOperacaoLabel);
		pPanelLeft.add(lResultadoLabel);
		pPanelCenter.add(tfValor1);
		pPanelCenter.add(tfValor2);
		pPanelCenter.add(lOperacao);
		pPanelCenter.add(lResultado);
		pPanelRight.add(bSoma);
		pPanelRight.add(bSubtracao);
		pPanelRight.add(bMultiplicacao);
		pPanelRight.add(bDivisao);
		pPanelRight.add(bLimpar);
		
		//Registro dos events listener
		bLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bLimparClick();
			}
		});
		
		bSoma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bSomaClick();
			}
		});
		
		bSubtracao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bSubtracaoClick();				
			}
		});
		
		bMultiplicacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bMultiplicacaoClick();
			}
		});
		
		bDivisao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bDivisaoClick();
			}
		});
		
		//Ajustes da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	// Limpa as caixas de texto
	private void bLimparClick() {
		tfValor1.setText("");
		tfValor2.setText("");
		lResultado.setText("");
		lOperacao.setText("");
	}
	
	// Utiliza o web method Soma
	private void bSomaClick() {
		try {
			// Obtém os valores digitados nas caixas de texto
			double val1 = Double.parseDouble(tfValor1.getText());
			double val2 = Double.parseDouble(tfValor2.getText());
			
			//Cria um objeto apontando para o endereço do web service Calculadora
			CalculadoraStub stub = new CalculadoraStub("http://10.0.50.152:8080/axis2/services/Calculadora");
			
			//Cria um objeto para setar os parametros do web method Soma
			CalculadoraStub.Soma req = new CalculadoraStub.Soma();
			
			//Seta os parâmetros
			req.setI(val1);
			req.setJ(val2);
			
			//Executa o web mothod Soma e coloca o resultado na variavel resp
			CalculadoraStub.SomaResponse resp = stub.soma(req);
			
			//Apresenta o resultado do Web Service Calculadora
			lOperacao.setText("SOMA");
			lResultado.setText(df.format(resp.get_return()));
		}
		catch (Exception e) {
			lResultado.setText("");
			lOperacao.setText("");
			tfValor1.requestFocus();
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	//Utiliza o web method Subtracao
	private void bSubtracaoClick() {
		try {
			// Obtém os valores digitados nas caixas de texto
			double val1 = Double.parseDouble(tfValor1.getText());
			double val2 = Double.parseDouble(tfValor2.getText());
			
			//Cria um objeto apontando para o endereço do web service Calculadora
			CalculadoraStub stub = new CalculadoraStub("http://10.0.50.152:8080/axis2/services/Calculadora");
			
			//Cria um objeto para setar os parametros do web method Subtracao
			CalculadoraStub.Subtracao req = new CalculadoraStub.Subtracao();
			
			//Seta os parâmetros
			req.setI(val1);
			req.setJ(val2);
			
			//Executa o web mothod Subtracao e coloca o resultado na variavel resp
			CalculadoraStub.SubtracaoResponse resp = stub.subtracao(req);
			
			//Apresenta o resultado do Web Service Calculadora
			lOperacao.setText("SUBTRAÇÃO");
			lResultado.setText(df.format(resp.get_return()));
		}
		catch (Exception e) {
			lResultado.setText("");
			lOperacao.setText("");
			tfValor1.requestFocus();
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	//Utiliza o web method Multiplicacao
	private void bMultiplicacaoClick() {
		try {
			// Obtém os valores digitados nas caixas de texto
			double val1 = Double.parseDouble(tfValor1.getText());
			double val2 = Double.parseDouble(tfValor2.getText());
			
			//Cria um objeto apontando para o endereço do web service Calculadora
			CalculadoraStub stub = new CalculadoraStub("http://10.0.50.152:8080/axis2/services/Calculadora");
			
			//Cria um objeto para setar os parametros do web method Subtracao
			CalculadoraStub.Multiplicacao req = new CalculadoraStub.Multiplicacao();
			
			//Seta os parâmetros
			req.setI(val1);
			req.setJ(val2);
			
			//Executa o web mothod Multiplicacao e coloca o resultado na variavel resp
			CalculadoraStub.MultiplicacaoResponse resp = stub.multiplicacao(req);
			
			//Apresenta o resultado do Web Service Calculadora
			lOperacao.setText("MULTIPLICAÇÃO");
			lResultado.setText(df.format(resp.get_return()));
		}
		catch (Exception e) {
			lResultado.setText("");
			lOperacao.setText("");
			tfValor1.requestFocus();
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	//Utiliza o web method Divisao
	private void bDivisaoClick() {
		try {
			// Obtém os valores digitados nas caixas de texto
			double val1 = Double.parseDouble(tfValor1.getText());
			double val2 = Double.parseDouble(tfValor2.getText());
			
			//Cria um objeto apontando para o endereço do web service Calculadora
			CalculadoraStub stub = new CalculadoraStub("http://10.0.50.152:8080/axis2/services/Calculadora");
			
			//Cria um objeto para setar os parametros do web method Subtracao
			CalculadoraStub.Divisao req = new CalculadoraStub.Divisao();
			
			//Seta os parâmetros
			req.setI(val1);
			req.setJ(val2);
			
			//Executa o web mothod Multiplicacao e coloca o resultado na variavel resp
			CalculadoraStub.DivisaoResponse resp = stub.divisao(req);
			
			//Apresenta o resultado do Web Service Calculadora
			lOperacao.setText("DIVISÃO");
			lResultado.setText(df.format(resp.get_return()));
		}
		catch (Exception e) {
			lResultado.setText("");
			lOperacao.setText("");
			tfValor1.requestFocus();
			Toolkit.getDefaultToolkit().beep();
		}
	}
	
	//Método main
	public static void main(String[] args) {
		new CalcView().setVisible(true);
	}
}
