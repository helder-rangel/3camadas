
/**IFPB - Curso SI - Disciplina de PERSISTENCIA DE OBJETOS
 * @author Prof Fausto Ayres
 */
package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Conta;

public class TelaConsultarConta extends JFrame {
	private JPanel contentPane;
	private JLabel lblPreco;
	private JTextField textField_1;
	private JButton btnInserir;
	private DefaultListModel<String> model = new DefaultListModel<String>();	
	private JLabel lblmsg;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaInserirProdutoPrateleira window = new TelaInserirProdutoPrateleira();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public TelaConsultarConta() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Consultar conta");
		setBounds(100, 100, 645, 229);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblPreco = new JLabel("Id da mesa");
		lblPreco.setBounds(19, 56, 102, 14);
		contentPane.add(this.lblPreco);
		textField_1 = new JTextField();
		textField_1.setBounds(124, 53, 40, 20);
		contentPane.add(this.textField_1);
		textField_1.setColumns(10);
		btnInserir = new JButton("Consultar");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {					
					int idmesa = Integer.parseInt(textField_1.getText());
					Conta c = Fachada.consultarConta(idmesa);
					lblmsg.setText(c.toString());
				} catch (NumberFormatException e) {
					lblmsg.setText("campo id deve ser numerico");
				} catch (Exception e) {
					lblmsg.setText(e.getMessage());
				}
			}
		});
		btnInserir.setBounds(19, 101, 136, 23);
		contentPane.add(this.btnInserir);
		lblmsg = new JLabel("");
		lblmsg.setBounds(19, 164, 594, 14);
		contentPane.add(this.lblmsg);
	}
}
