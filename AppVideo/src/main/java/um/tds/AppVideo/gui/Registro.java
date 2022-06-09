package um.tds.AppVideo.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;
import javax.swing.JSeparator;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.UIManager;


public class Registro {

	private JFrame frame;
	private JPasswordField passwordFieldRepContraseña;
	private JPasswordField passwordFieldContraseña;
	private JTextField textFieldUsuario;
	private JTextField textFieldEmail;
	private JTextField textFieldApellidos;
	private JTextField textFieldNombre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro window = new Registro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panelArriba = new JPanel();
		panelArriba.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panelArriba);
		panelArriba.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblAppVideo = new JLabel("APP VIDEO");
		lblAppVideo.setFont(new Font("Baskerville Old Face", Font.BOLD, 23));
		lblAppVideo.setForeground(Color.RED);
		panelArriba.add(lblAppVideo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(UIManager.getColor("Button.background"));
		separator_1.setForeground(UIManager.getColor("Button.background"));
		separator_1.setPreferredSize(new Dimension(96, 2));
		panelArriba.add(separator_1);

		JButton btnRegistro = new JButton("Registro");
		panelArriba.add(btnRegistro);

		JButton btnLogin = new JButton("Login");
		panelArriba.add(btnLogin);

		JButton btnLogout = new JButton("Logout");
		panelArriba.add(btnLogout);

		JButton btnPremium = new JButton("Premium");
		btnPremium.setForeground(Color.RED);
		btnPremium.setBackground(Color.RED);
		btnPremium.setHorizontalAlignment(SwingConstants.RIGHT);
		panelArriba.add(btnPremium);

		JPanel panelMenu = new JPanel();
		panelMenu.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel.add(panelMenu);
		panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.X_AXIS));

		JButton btnExplorar = new JButton("Explorar");
		btnExplorar.setBackground(new Color(135, 206, 235));
		btnExplorar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnExplorar.setForeground(Color.BLACK);
		btnExplorar.setHorizontalAlignment(SwingConstants.LEFT);
		panelMenu.add(btnExplorar);

		JButton btnMisListas = new JButton("Mis listas");
		btnMisListas.setBackground(new Color(135, 206, 235));
		btnMisListas.setHorizontalAlignment(SwingConstants.LEFT);
		panelMenu.add(btnMisListas);

		JButton btnRecientes = new JButton("Recientes");
		btnRecientes.setBackground(new Color(135, 206, 235));
		btnRecientes.setHorizontalAlignment(SwingConstants.LEFT);
		panelMenu.add(btnRecientes);

		JButton btnNuevaLista = new JButton("Nueva Lista");
		btnNuevaLista.setBackground(new Color(135, 206, 235));
		panelMenu.add(btnNuevaLista);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.LIGHT_GRAY);
		panelBotones.setForeground(Color.LIGHT_GRAY);
		panel_3.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("Registrar");
		panelBotones.add(btnRegistrar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setPreferredSize(new Dimension(64, 2));
		separator.setMinimumSize(new Dimension(32000, 320000));
		separator.setBounds(new Rectangle(10, 10, 10, 10));
		separator.setBackground(Color.LIGHT_GRAY);
		panelBotones.add(separator);
		
		JButton btnCancelar = new JButton("Cancelar");
		panelBotones.add(btnCancelar);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(Color.LIGHT_GRAY);
		panel_3.add(panelRegistro, BorderLayout.CENTER);
		GridBagLayout gbl_panelRegistro = new GridBagLayout();
		gbl_panelRegistro.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRegistro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRegistro.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelRegistro.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRegistro.setLayout(gbl_panelRegistro);
		
		JLabel lblNombre = new JLabel("*Nombre:");
		lblNombre.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 4;
		gbc_lblNombre.gridy = 0;
		panelRegistro.add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 5;
		gbc_textFieldNombre.gridy = 0;
		panelRegistro.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 4;
		gbc_lblApellidos.gridy = 1;
		panelRegistro.add(lblApellidos, gbc_lblApellidos);
		
		textFieldApellidos = new JTextField();
		GridBagConstraints gbc_textFieldApellidos = new GridBagConstraints();
		gbc_textFieldApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellidos.gridx = 5;
		gbc_textFieldApellidos.gridy = 1;
		panelRegistro.add(textFieldApellidos, gbc_textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JLabel lblFecha = new JLabel("*Fecha.Nac:");
		lblFecha.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 4;
		gbc_lblFecha.gridy = 2;
		panelRegistro.add(lblFecha, gbc_lblFecha);
		
		JCalendar calendar = new JCalendar();
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.gridheight = 4;
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 5;
		gbc_calendar.gridy = 2;
		panelRegistro.add(calendar, gbc_calendar);
		
		JLabel lblEmail = new JLabel("*email:");
		lblEmail.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 4;
		gbc_lblEmail.gridy = 6;
		panelRegistro.add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 5;
		gbc_textFieldEmail.gridy = 6;
		panelRegistro.add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblUsuario = new JLabel("*Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 4;
		gbc_lblUsuario.gridy = 7;
		panelRegistro.add(lblUsuario, gbc_lblUsuario);
		
		textFieldUsuario = new JTextField();
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.gridx = 5;
		gbc_textFieldUsuario.gridy = 7;
		panelRegistro.add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContraseña = new JLabel("*Contrase\u00F1a:");
		lblContraseña.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblContraseña = new GridBagConstraints();
		gbc_lblContraseña.anchor = GridBagConstraints.EAST;
		gbc_lblContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseña.gridx = 4;
		gbc_lblContraseña.gridy = 8;
		panelRegistro.add(lblContraseña, gbc_lblContraseña);
		
		passwordFieldContraseña = new JPasswordField();
		GridBagConstraints gbc_passwordFieldContraseña = new GridBagConstraints();
		gbc_passwordFieldContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_passwordFieldContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldContraseña.gridx = 5;
		gbc_passwordFieldContraseña.gridy = 8;
		panelRegistro.add(passwordFieldContraseña, gbc_passwordFieldContraseña);
		
		JLabel lblRepContraseña = new JLabel("*Rep.Contrase\u00F1a:");
		lblRepContraseña.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblRepContraseña = new GridBagConstraints();
		gbc_lblRepContraseña.insets = new Insets(0, 0, 0, 5);
		gbc_lblRepContraseña.anchor = GridBagConstraints.EAST;
		gbc_lblRepContraseña.gridx = 4;
		gbc_lblRepContraseña.gridy = 9;
		panelRegistro.add(lblRepContraseña, gbc_lblRepContraseña);
		
		passwordFieldRepContraseña = new JPasswordField();
		GridBagConstraints gbc_passwordFieldRepContraseña = new GridBagConstraints();
		gbc_passwordFieldRepContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldRepContraseña.insets = new Insets(0, 0, 0, 5);
		gbc_passwordFieldRepContraseña.gridx = 5;
		gbc_passwordFieldRepContraseña.gridy = 9;
		panelRegistro.add(passwordFieldRepContraseña, gbc_passwordFieldRepContraseña);
	}

}
