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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VueConnexion extends JFrame implements Constantes,
		ConstantesAffichage, WindowListener {
	
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
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setSize(450, 250);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblUsername.setIcon(OutilsFichiers
				.getImageIconFromResources(IMAGE_CONNECT_USER));
		
		lblUsername.setFont(new Font(FONT_USED, Font.PLAIN, 18));
		lblUsername.setBounds(26, 63, 166, 24);
		contentPane.add(lblUsername);
		
		lblHeader.setFont(new Font(FONT_USED, Font.BOLD, 30));
		lblHeader.setBounds(50, 11, 335, 41);
		contentPane.add(lblHeader);
		lblPassword.setIcon(OutilsFichiers
				.getImageIconFromResources(IMAGE_CONNECT_KEY));
		
		lblPassword.setFont(new Font(FONT_USED, Font.PLAIN, 18));
		lblPassword.setBounds(60, 106, 132, 24);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(202, 67, 157, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		btnValider.setIcon(OutilsFichiers
				.getImageIconFromResources(IMAGE_CONNECT_CHECK));
		
		btnValider.setBounds(90, 160, 100, 30);
		contentPane.add(btnValider);
		btnQuitter.setIcon(OutilsFichiers
				.getImageIconFromResources(IMAGE_CONNECT_CROSS));
		
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
					
					database.disconnect();
					
				}
				catch(ClassNotFoundException e1){}
				catch(SQLException e1){
					JOptionPane.showMessageDialog(null,
							ERROR_IMPOSSIBLE_CONNECTION,
							TITLE_ERROR_CONNECTION, JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		getRootPane().setDefaultButton(btnValider);
		
		btnQuitter.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				windowClosing(null);
			}
		});
		
		addWindowListener(this);
		
		setVisible(true);
		
	}
	
	public String getUsername(){
		return textField.getText();
	}
	
	public String getPassword(){
		return String.valueOf(passwordField.getPassword());
	}
	
	@Override
	public void windowActivated(WindowEvent e){}
	
	@Override
	public void windowClosed(WindowEvent e){}
	
	@Override
	public void windowClosing(WindowEvent e){
		if(JOptionPane.showConfirmDialog(null, CONFIRM_QUIT, COMMON_QUIT,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
	
	@Override
	public void windowDeactivated(WindowEvent e){}
	
	@Override
	public void windowDeiconified(WindowEvent e){}
	
	@Override
	public void windowIconified(WindowEvent e){}
	
	@Override
	public void windowOpened(WindowEvent e){}
	
}
