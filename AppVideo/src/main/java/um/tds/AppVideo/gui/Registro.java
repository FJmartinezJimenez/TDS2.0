package um.tds.AppVideo.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;

import um.tds.AppVideo.controlador.Controlador;

import javax.swing.JSeparator;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Registro extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JPasswordField passwordFieldRepContra;
	private JPasswordField passwordFieldContra;
	private JTextField textFieldUsuario;
	private JTextField textFieldEmail;

	/**
	 * Create the application.
	 */
	public Registro() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(0, 32));
		panel.add(separator_2);
		add(panel, BorderLayout.NORTH);
		
		JPanel panelOeste = new JPanel();
		panelOeste.setBackground(Color.LIGHT_GRAY);
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(64, 2));
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.LIGHT_GRAY);
		panelOeste.add(separator_1);
		add(panelOeste, BorderLayout.WEST);

		JPanel panelEste = new JPanel();
		JSeparator separator_1_1 = new JSeparator();
		panelEste.setBackground(Color.LIGHT_GRAY);
		panelEste.add(separator_1_1);
		separator_1_1.setPreferredSize(new Dimension(64, 2));
		separator_1_1.setForeground(Color.LIGHT_GRAY);
		separator_1_1.setBackground(Color.LIGHT_GRAY);
		add(panelEste, BorderLayout.EAST);

		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.LIGHT_GRAY);
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setPreferredSize(new Dimension(0, 32));
		panelSur.add(separator_2_1);
		add(panelSur, BorderLayout.SOUTH);


		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.LIGHT_GRAY);
		panelBotones.setForeground(Color.LIGHT_GRAY);

		JButton btnRegistrar = new JButton("Registrar");
		panelBotones.add(btnRegistrar);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setPreferredSize(new Dimension(32, 2));
		separator.setMinimumSize(new Dimension(32000, 320000));
		separator.setBounds(new Rectangle(10, 10, 10, 10));
		separator.setBackground(Color.LIGHT_GRAY);
		panelBotones.add(separator);

		JButton btnCancelar = new JButton("Cancelar");
		panelBotones.add(btnCancelar);
		add(panelBotones, BorderLayout.SOUTH);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(Color.LIGHT_GRAY);
		add(panelRegistro, BorderLayout.CENTER);
		GridBagLayout gbl_panelRegistro = new GridBagLayout();
		gbl_panelRegistro.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelRegistro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRegistro.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelRegistro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRegistro.setLayout(gbl_panelRegistro);
		
		JLabel lblnombre = new JLabel("*Nombre:");
		GridBagConstraints gbc_lblnombre = new GridBagConstraints();
		gbc_lblnombre.anchor = GridBagConstraints.EAST;
		gbc_lblnombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblnombre.gridx = 1;
		gbc_lblnombre.gridy = 0;
		panelRegistro.add(lblnombre, gbc_lblnombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 0;
		panelRegistro.add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 1;
		panelRegistro.add(lblApellidos, gbc_lblApellidos);
		
		textFieldApellidos = new JTextField();
		GridBagConstraints gbc_textFieldApellidos = new GridBagConstraints();
		gbc_textFieldApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellidos.gridx = 2;
		gbc_textFieldApellidos.gridy = 1;
		panelRegistro.add(textFieldApellidos, gbc_textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JLabel lblFecnac = new JLabel("Fec.Nac:");
		GridBagConstraints gbc_lblFecnac = new GridBagConstraints();
		gbc_lblFecnac.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecnac.anchor = GridBagConstraints.EAST;
		gbc_lblFecnac.gridx = 1;
		gbc_lblFecnac.gridy = 2;
		panelRegistro.add(lblFecnac, gbc_lblFecnac);
		
		final JDateChooser calendar = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridheight = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 2;
		gbc_dateChooser.gridy = 2;
		panelRegistro.add(calendar, gbc_dateChooser);
		
		JLabel lblemail = new JLabel("*email:");
		GridBagConstraints gbc_lblemail = new GridBagConstraints();
		gbc_lblemail.anchor = GridBagConstraints.EAST;
		gbc_lblemail.insets = new Insets(0, 0, 5, 5);
		gbc_lblemail.gridx = 1;
		gbc_lblemail.gridy = 4;
		panelRegistro.add(lblemail, gbc_lblemail);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 4;
		panelRegistro.add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblusuario = new JLabel("*Usuario:");
		GridBagConstraints gbc_lblusuario = new GridBagConstraints();
		gbc_lblusuario.anchor = GridBagConstraints.EAST;
		gbc_lblusuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblusuario.gridx = 1;
		gbc_lblusuario.gridy = 5;
		panelRegistro.add(lblusuario, gbc_lblusuario);
		
		textFieldUsuario = new JTextField();
		GridBagConstraints gbc_textFieldUsuario = new GridBagConstraints();
		gbc_textFieldUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsuario.gridx = 2;
		gbc_textFieldUsuario.gridy = 5;
		panelRegistro.add(textFieldUsuario, gbc_textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("*Contraseña:");
		GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
		gbc_lblContrasea.anchor = GridBagConstraints.EAST;
		gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasea.gridx = 1;
		gbc_lblContrasea.gridy = 6;
		panelRegistro.add(lblContrasea, gbc_lblContrasea);
		
		passwordFieldContra = new JPasswordField();
		GridBagConstraints gbc_passwordFieldContra = new GridBagConstraints();
		gbc_passwordFieldContra.insets = new Insets(0, 0, 5, 5);
		gbc_passwordFieldContra.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldContra.gridx = 2;
		gbc_passwordFieldContra.gridy = 6;
		panelRegistro.add(passwordFieldContra, gbc_passwordFieldContra);
		
		JLabel lblrepcontrasea = new JLabel("*Rep.Contraseña:");
		GridBagConstraints gbc_lblrepcontrasea = new GridBagConstraints();
		gbc_lblrepcontrasea.insets = new Insets(0, 0, 5, 5);
		gbc_lblrepcontrasea.anchor = GridBagConstraints.EAST;
		gbc_lblrepcontrasea.gridx = 1;
		gbc_lblrepcontrasea.gridy = 7;
		panelRegistro.add(lblrepcontrasea, gbc_lblrepcontrasea);
		
		passwordFieldRepContra = new JPasswordField();
		GridBagConstraints gbc_passwordFieldRepContra = new GridBagConstraints();
		gbc_passwordFieldRepContra.insets = new Insets(0, 0, 5, 5);
		gbc_passwordFieldRepContra.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordFieldRepContra.gridx = 2;
		gbc_passwordFieldRepContra.gridy = 7;
		panelRegistro.add(passwordFieldRepContra, gbc_passwordFieldRepContra);
		
				

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passwordFieldRepContra.setText("");
				passwordFieldContra.setText("");
				textFieldNombre.setText("");
				textFieldEmail.setText("");
				textFieldUsuario.setText("");
				textFieldApellidos.setText("");
			}
		});

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				@SuppressWarnings("deprecation")
				String password = passwordFieldRepContra.getText();

				@SuppressWarnings("deprecation")
				String password2 = passwordFieldContra.getText();
				String nombre = textFieldNombre.getText().trim();
				String email = textFieldEmail.getText().trim();
				String usuario = textFieldUsuario.getText().trim();
				String apellidos = textFieldApellidos.getText();
				LocalDate fecha = null;

				if (calendar.getDate() != null)
					fecha = calendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				if (password.isEmpty() || password2.isEmpty() || nombre.isEmpty() || usuario.isEmpty()
						|| email.isEmpty() || fecha == null || !password2.equals(password)) {

					JOptionPane.showMessageDialog(null, "Contraseñas diferentes o campos vacíos", "Registrar usuario",
							JOptionPane.ERROR_MESSAGE);

				}else {
					Controlador.getUnicaInstancia().registrarUsuario(nombre, apellidos, email, false, usuario, password2, fecha);
						JOptionPane.showMessageDialog(null, "Usuario registrado correctamente", "Usuario registrado",
								JOptionPane.INFORMATION_MESSAGE);
				}
				
				passwordFieldRepContra.setText("");
				passwordFieldContra.setText("");
				textFieldNombre.setText("");
				textFieldEmail.setText("");
				textFieldUsuario.setText("");
				textFieldApellidos.setText("");
				calendar.setDate(null);

			}

		});

	}

}
