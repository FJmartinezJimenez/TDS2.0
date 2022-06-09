package um.tds.AppVideo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;



import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.Point;

public class Login {
	private JFrame frame;
	private JTextField textFieldLogin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panelNorte = new JPanel();
		frame.getContentPane().add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new BoxLayout(panelNorte, BoxLayout.Y_AXIS));

		JPanel panelArriba = new JPanel();
		panelArriba.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelNorte.add(panelArriba);
		panelArriba.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblAppVideo = new JLabel("APP VIDEO");
		lblAppVideo.setFont(new Font("Baskerville Old Face", Font.BOLD, 23));
		lblAppVideo.setForeground(Color.RED);
		panelArriba.add(lblAppVideo);

		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(96, 2));
		separator.setForeground(UIManager.getColor("Button.background"));
		separator.setBackground(UIManager.getColor("Button.background"));
		panelArriba.add(separator);

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
		panelNorte.add(panelMenu);
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

		JPanel panelResto = new JPanel();
		panelResto.setForeground(Color.LIGHT_GRAY);
		panelResto.setBackground(Color.WHITE);
		frame.getContentPane().add(panelResto, BorderLayout.CENTER);
		panelResto.setLayout(new BorderLayout(0, 0));

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.LIGHT_GRAY);
		panelLogin.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				new LineBorder(new Color(0, 0, 0), 3)));
		panelResto.add(panelLogin, BorderLayout.CENTER);
		GridBagLayout gbl_panelLogin = new GridBagLayout();
		gbl_panelLogin.columnWidths = new int[] { 80, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelLogin.rowHeights = new int[] { 60, 30, 0, 6, 0, 0, 0 };
		gbl_panelLogin.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelLogin.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelLogin.setLayout(gbl_panelLogin);

		final JLabel lblLogin = new JLabel("Login:");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 1;
		gbc_lblLogin.gridy = 1;
		panelLogin.add(lblLogin, gbc_lblLogin);

		textFieldLogin = new JTextField();
		GridBagConstraints gbc_textFieldLogin = new GridBagConstraints();
		gbc_textFieldLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLogin.gridwidth = 4;
		gbc_textFieldLogin.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLogin.gridx = 2;
		gbc_textFieldLogin.gridy = 1;
		panelLogin.add(textFieldLogin, gbc_textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		panelLogin.add(lblPassword, gbc_lblPassword);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 4;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 3;
		panelLogin.add(passwordField, gbc_passwordField);

		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 5;
		panelLogin.add(btnAceptar, gbc_btnAceptar);

		// Aceptar
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 6;
		gbc_btnCancelar.gridy = 5;
		panelLogin.add(btnCancelar, gbc_btnCancelar);

		JPanel panelOeste = new JPanel();
		panelOeste.setBackground(Color.LIGHT_GRAY);
		panelResto.add(panelOeste, BorderLayout.WEST);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.LIGHT_GRAY);
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setPreferredSize(new Dimension(96, 2));
		panelOeste.add(separator_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panelResto.add(panel, BorderLayout.NORTH);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setPreferredSize(new Dimension(0, 32));
		separator_1_1.setForeground(Color.LIGHT_GRAY);
		separator_1_1.setBackground(Color.LIGHT_GRAY);
		panel.add(separator_1_1);

		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.LIGHT_GRAY);
		panelResto.add(panelSur, BorderLayout.SOUTH);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(0, 32));
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.LIGHT_GRAY);
		panelSur.add(separator_1);

		JPanel panelEste = new JPanel();
		panelEste.setBackground(Color.LIGHT_GRAY);
		panelResto.add(panelEste, BorderLayout.EAST);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setPreferredSize(new Dimension(96, 2));
		separator_3.setLocation(new Point(96, 0));
		separator_3.setForeground(Color.LIGHT_GRAY);
		separator_3.setBackground(Color.LIGHT_GRAY);
		panelEste.add(separator_3);

		// Registro
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir ventana registro
			}

		});

		// Registro
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir ventana registro
			}

		});

		// Logout
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar alerta o dejar asi

			}

		});

		// Premium
		btnPremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar alerta o dejar asi
			}
		});

		// Explorar
		btnExplorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar alerta o dejar asi
			}

		});

		// Mis Listas
		btnMisListas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar alerta o dejar asi
			}
		});

		// Recientes
		btnRecientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar alerta o dejar asi
			}
		});

		// Nueva lista
		btnNuevaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Mostrar alerta o dejar asi
			}
		});

	}

}