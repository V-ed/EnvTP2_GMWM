package graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import objects.MySQLDatabase;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;

public class ScreenConnect extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel = new JLabel("Nom d'utilisateur :");
	private JLabel lblConnexionAuProgramme = new JLabel("Connexion au programme");
	private JLabel lblMotDePasse = new JLabel("Mot de passe :");
	private JButton btnValider = new JButton("Valider");
	private JButton btnQuitter = new JButton("Quitter");

	public ScreenConnect() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(60, 63, 132, 24);
		contentPane.add(lblNewLabel);
		
		lblConnexionAuProgramme.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblConnexionAuProgramme.setBounds(50, 11, 335, 41);
		contentPane.add(lblConnexionAuProgramme);
		
		lblMotDePasse.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMotDePasse.setBounds(60, 106, 132, 24);
		contentPane.add(lblMotDePasse);
		
		textField = new JTextField();
		textField.setBounds(202, 67, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnValider.setBounds(90, 160, 100, 30);
		contentPane.add(btnValider);
		
		btnQuitter.setBounds(238, 160, 100, 30);
		contentPane.add(btnQuitter);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(202, 110, 157, 20);
		contentPane.add(passwordField);
		
		btnValider.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					MySQLDatabase database = new MySQLDatabase("localhost",
							"gestionalbums", getUsername(), getPassword());
					
					dispose();
					
					new ScreenPrincipal(database);
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		btnQuitter.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
