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

import javax.swing.JSeparator;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Registro extends JPanel {

	/**
	 * Create the application.
	 */
	public Registro() {
		setLayout(new BorderLayout(0, 0));
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

		JPanel panelCampos = new JPanel();
		panelCampos.setForeground(Color.LIGHT_GRAY);
		panelCampos.setBackground(Color.LIGHT_GRAY);
		add(panelCampos, BorderLayout.CENTER);
		GridBagLayout gbl_panelCampos = new GridBagLayout();
		gbl_panelCampos.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelCampos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelCampos.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelCampos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelCampos.setLayout(gbl_panelCampos);
				
						JLabel lblnombre = new JLabel("*Nombre:");
						GridBagConstraints gbc_lblnombre = new GridBagConstraints();
						gbc_lblnombre.anchor = GridBagConstraints.EAST;
						gbc_lblnombre.insets = new Insets(0, 0, 5, 5);
						gbc_lblnombre.gridx = 2;
						gbc_lblnombre.gridy = 1;
						panelCampos.add(lblnombre, gbc_lblnombre);
		
				JTextField textFieldNombre = new JTextField();
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.gridwidth = 4;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 3;
				gbc_textField.gridy = 1;
				panelCampos.add(textFieldNombre, gbc_textField);
				textFieldNombre.setColumns(10);
		
				JLabel lblApellidos = new JLabel("Apellidos:");
				GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
				gbc_lblApellidos.anchor = GridBagConstraints.EAST;
				gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
				gbc_lblApellidos.gridx = 2;
				gbc_lblApellidos.gridy = 2;
				panelCampos.add(lblApellidos, gbc_lblApellidos);
		
				JTextField textFieldApellidos = new JTextField();
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.gridwidth = 4;
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 3;
				gbc_textField_1.gridy = 2;
				panelCampos.add(textFieldApellidos, gbc_textField_1);
				textFieldApellidos.setColumns(10);
				
						JLabel lblfechnac = new JLabel("*Fech.Nac:");
						GridBagConstraints gbc_lblfechnac = new GridBagConstraints();
						gbc_lblfechnac.anchor = GridBagConstraints.EAST;
						gbc_lblfechnac.insets = new Insets(0, 0, 5, 5);
						gbc_lblfechnac.gridx = 2;
						gbc_lblfechnac.gridy = 3;
						panelCampos.add(lblfechnac, gbc_lblfechnac);
		
				JDateChooser calendar = new JDateChooser();
				GridBagConstraints gbc_calendar = new GridBagConstraints();
				gbc_calendar.gridwidth = 4;
				gbc_calendar.gridheight = 3;
				gbc_calendar.insets = new Insets(0, 0, 5, 5);
				gbc_calendar.fill = GridBagConstraints.BOTH;
				gbc_calendar.gridx = 3;
				gbc_calendar.gridy = 3;
				panelCampos.add(calendar, gbc_calendar);
		
				JLabel lblemail = new JLabel("*email:");
				GridBagConstraints gbc_lblemail = new GridBagConstraints();
				gbc_lblemail.anchor = GridBagConstraints.EAST;
				gbc_lblemail.insets = new Insets(0, 0, 5, 5);
				gbc_lblemail.gridx = 2;
				gbc_lblemail.gridy = 6;
				panelCampos.add(lblemail, gbc_lblemail);
		
				JTextField textFieldEmail = new JTextField();
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.gridwidth = 4;
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.gridx = 3;
				gbc_textField_2.gridy = 6;
				panelCampos.add(textFieldEmail, gbc_textField_2);
				textFieldEmail.setColumns(10);
		
				JLabel lblusuario = new JLabel("*Usuario:");
				GridBagConstraints gbc_lblusuario = new GridBagConstraints();
				gbc_lblusuario.anchor = GridBagConstraints.EAST;
				gbc_lblusuario.insets = new Insets(0, 0, 5, 5);
				gbc_lblusuario.gridx = 2;
				gbc_lblusuario.gridy = 7;
				panelCampos.add(lblusuario, gbc_lblusuario);
		
				JTextField textFieldUsuario = new JTextField();
				GridBagConstraints gbc_textField_3 = new GridBagConstraints();
				gbc_textField_3.gridwidth = 4;
				gbc_textField_3.insets = new Insets(0, 0, 5, 5);
				gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_3.gridx = 3;
				gbc_textField_3.gridy = 7;
				panelCampos.add(textFieldUsuario, gbc_textField_3);
				textFieldUsuario.setColumns(10);
		
				JLabel lblcontrasea = new JLabel("*Contrase\u00F1a:");
				GridBagConstraints gbc_lblcontrasea = new GridBagConstraints();
				gbc_lblcontrasea.insets = new Insets(0, 0, 5, 5);
				gbc_lblcontrasea.anchor = GridBagConstraints.EAST;
				gbc_lblcontrasea.gridx = 2;
				gbc_lblcontrasea.gridy = 8;
				panelCampos.add(lblcontrasea, gbc_lblcontrasea);
		
				JPasswordField passwordFieldContraseña = new JPasswordField();
				GridBagConstraints gbc_passwordField = new GridBagConstraints();
				gbc_passwordField.gridwidth = 4;
				gbc_passwordField.insets = new Insets(0, 0, 5, 5);
				gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
				gbc_passwordField.gridx = 3;
				gbc_passwordField.gridy = 8;
				panelCampos.add(passwordFieldContraseña, gbc_passwordField);
		
				JLabel lblrepcon = new JLabel("*Rep.Con:");
				GridBagConstraints gbc_lblrepcon = new GridBagConstraints();
				gbc_lblrepcon.insets = new Insets(0, 0, 5, 5);
				gbc_lblrepcon.anchor = GridBagConstraints.EAST;
				gbc_lblrepcon.gridx = 2;
				gbc_lblrepcon.gridy = 9;
				panelCampos.add(lblrepcon, gbc_lblrepcon);
		
				JPasswordField passwordFieldRepContraseña = new JPasswordField();
				GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
				gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
				gbc_passwordField_1.gridwidth = 4;
				gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_passwordField_1.gridx = 3;
				gbc_passwordField_1.gridy = 9;
				panelCampos.add(passwordFieldRepContraseña, gbc_passwordField_1);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passwordFieldRepContraseña.setText("");
				passwordFieldContraseña.setText("");
				textFieldNombre.setText("");
				textFieldEmail.setText("");
				textFieldUsuario.setText("");
				textFieldApellidos.setText("");
			}
		});

		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				@SuppressWarnings("deprecation")
				String password = passwordFieldRepContraseña.getText();

				@SuppressWarnings("deprecation")
				String password2 = passwordFieldContraseña.getText();
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

				} // TODO Registrar Usuario 
				passwordFieldRepContraseña.setText("");
				passwordFieldContraseña.setText("");
				textFieldNombre.setText("");
				textFieldEmail.setText("");
				textFieldUsuario.setText("");
				textFieldApellidos.setText("");

			}

		});

	}

}
