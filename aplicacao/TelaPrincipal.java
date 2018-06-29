package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;
import modelo.Produto;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaPrincipal {

	private JFrame frmPrincipal;
	private JMenuItem mntmListarProdutos;
	private JMenuItem mntmListarGarcons;
	private JMenuItem mntmListarMesas;
	private JMenuItem mntmListarContas;
	private JMenuItem mntmCadastrarProduto;
	private JMenuItem mntmSoliciarProduto;
	private JMenuItem mntmcadastrarGarcom;
	private JMenuItem mntmcalcularGorjeta;
	private JMenuItem mntmCriarConta;
	private JMenuItem mntmConsultarConta;
	private JMenuItem mntmCancelarConta;
	private JMenuItem mntmTransferirConta;
	private JMenuItem mntmFecharCona;
	private JMenu mnRestaurante;
	private JMenu mnProduto;
	private JMenu mnGarcom;
	private JMenu mnConta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("Sistema de vendas para restaurantes");

		frmPrincipal.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
					Produto p;
					p = Fachada.cadastrarProduto("feijoada", 3.0);
					p = Fachada.cadastrarProduto("rubacao", 5.0);
					p = Fachada.cadastrarProduto("macarronada", 2.0);
					p = Fachada.cadastrarProduto("carne", 30.0);
					p = Fachada.cadastrarProduto("frango", 10.0);
					p = Fachada.cadastrarProduto("coxinha", 30.0);
					p = Fachada.cadastrarProduto("porco", 10.0);
					p = Fachada.cadastrarProduto("bode", 30.0);

					Fachada.criarMesas(20);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "Até breve !");
			}
		});

		frmPrincipal.setBounds(100, 100, 600, 450);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frmPrincipal.setJMenuBar(menuBar);

		mnRestaurante = new JMenu("Restaurante");
		mnProduto = new JMenu("Produto");
		mnGarcom = new JMenu("Garçom");
		mnConta = new JMenu("Conta");
		menuBar.add(mnRestaurante);
		menuBar.add(mnProduto);
		menuBar.add(mnGarcom);
		menuBar.add(mnConta);

		//Menu restaurante
		mntmListarProdutos = new JMenuItem("Listar produtos");
		mntmListarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemProduto j = new TelaListagemProduto();
				j.setVisible(true);
			}
		});
		mnRestaurante.add(mntmListarProdutos);
		
		mntmListarGarcons = new JMenuItem("Listar garçons");
		mntmListarGarcons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemGarcons j = new TelaListagemGarcons();
				j.setVisible(true);
			}
		});
		mnRestaurante.add(mntmListarGarcons);
		
		mntmListarMesas = new JMenuItem("Listar mesas");
		mntmListarMesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemMesas j = new TelaListagemMesas();
				j.setVisible(true);
			}
		});
		mnRestaurante.add(mntmListarMesas);
		
		mntmListarContas = new JMenuItem("Listar contas");
		mntmListarContas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagemContas j = new TelaListagemContas();
				j.setVisible(true);
			}
		});
		mnRestaurante.add(mntmListarContas);
		
		//Menu produto===============================
		
		mntmCadastrarProduto = new JMenuItem("Cadastrar produto");
		mntmCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaInserirProduto j = new TelaInserirProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(mntmCadastrarProduto);
		
		mntmSoliciarProduto = new JMenuItem("Solicitar produto");
		mntmSoliciarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaSolicitarProduto j = new TelaSolicitarProduto();
				j.setVisible(true);
			}
		});
		mnProduto.add(mntmSoliciarProduto);
		
		//Menu garçom===============================

		mntmcadastrarGarcom = new JMenuItem("Cadastrar garçom");
		mntmcadastrarGarcom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastrarGarcom j = new TelaCadastrarGarcom();
				j.setVisible(true);
			}
		});
		mnGarcom.add(mntmcadastrarGarcom);
		
		mntmcalcularGorjeta = new JMenuItem("Calcular gorjeta");
		mntmcalcularGorjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCalcularGorjeta j = new TelaCalcularGorjeta();
				j.setVisible(true);
			}
		});
		mnGarcom.add(mntmcalcularGorjeta);
		
		//Menu Conta===============================
		
		mntmCriarConta = new JMenuItem("Criar conta");
		mntmCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCriarConta j = new TelaCriarConta();
				j.setVisible(true);
			}
		});
		mnConta.add(mntmCriarConta);
		
		mntmConsultarConta = new JMenuItem("Consultar conta");
		mntmConsultarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaConsultarConta j = new TelaConsultarConta();
				j.setVisible(true);
			}
		});
		mnConta.add(mntmConsultarConta);
		
		mntmTransferirConta = new JMenuItem("Transferir conta");
		mntmTransferirConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaTransferirConta j = new TelaTransferirConta();
				j.setVisible(true);
			}
		});
		mnConta.add(mntmTransferirConta);
		
		mntmCancelarConta = new JMenuItem("Cancelar conta");
		mntmCancelarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCancelarConta j = new TelaCancelarConta();
				j.setVisible(true);
			}
		});
		mnConta.add(mntmCancelarConta);
		
		mntmFecharCona = new JMenuItem("Fechar conta");
		mntmFecharCona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaFecharConta j = new TelaFecharConta();
				j.setVisible(true);
			}
		});
		mnConta.add(mntmFecharCona);
		
	}
}
