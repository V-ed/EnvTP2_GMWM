package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objects.MySQLDatabase;
import outils.Constantes;
import outils.ConstantesAffichage;
import outils.OutilsFichiers;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VueConnexion extends JFrame implements Constantes,
		ConstantesAffichage {
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblUsername = new JLabel(VIEW_CONNECT_USERNAME);
	private JLabel lblHeader = new JLabel(VIEW_CONNECT_HEADER);
	private JLabel lblPassword = new JLabel(VIEW_CONNECT_PASSWORD);
	private JButton btnValider = new JButton(VIEW_CONNECT_VALIDER);
	private JButton btnQuitter = new JButton(VIEW_CONNECT_QUITTER);
	
	public VueConnexion(){
		
		setTitle(TITLE_CONNECT + " - " + TITLE_PROJECT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(450, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblUsername.setIcon(OutilsFichiers
				.getImageIconFromResources("utilisateur.png"));
		
		lblUsername.setFont(new Font(FONT_USED, Font.PLAIN, 18));
		lblUsername.setBounds(26, 63, 166, 24);
		contentPane.add(lblUsername);
		
		lblHeader.setFont(new Font(FONT_USED, Font.BOLD, 30));
		lblHeader.setBounds(50, 11, 335, 41);
		contentPane.add(lblHeader);
		lblPassword
				.setIcon(OutilsFichiers.getImageIconFromResources("cle.png"));
		
		lblPassword.setFont(new Font(FONT_USED, Font.PLAIN, 18));
		lblPassword.setBounds(60, 106, 132, 24);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(202, 67, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		btnValider.setIcon(OutilsFichiers
				.getImageIconFromResources("crochet_1.png"));
		
		btnValider.setBounds(90, 160, 100, 30);
		contentPane.add(btnValider);
		btnQuitter.setIcon(OutilsFichiers
				.getImageIconFromResources("croix_1.png"));
		
		btnQuitter.setBounds(238, 160, 100, 30);
		contentPane.add(btnQuitter);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(202, 110, 157, 20);
		contentPane.add(passwordField);
		
		btnValider.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					
					MySQLDatabase database = new MySQLDatabase("localhost",
							"gestionalbums", getUsername(), getPassword());
					
					dispose();
					
					new VuePrincipal(database, VueConnexion.this);
					
				}
				catch(ClassNotFoundException e1){
					System.out.println("this one");
				}
				catch(SQLException e1){
					// TODO Constante erreur connection
					JOptionPane
							.showMessageDialog(
									null,
									"Erreur, Connection impossible (verifier l'identifiant et le mot de passe)",
									"Erreur de connection",
									JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnQuitter.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		
		setVisible(true);
		
	}
	
	public String getUsername(){
		return textField.getText();
	}
	
	public String getPassword(){
		return String.valueOf(passwordField.getPassword());
	}
	
}
