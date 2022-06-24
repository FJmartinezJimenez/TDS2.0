package um.tds.AppVideo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Login extends JPanel {

	public Login() {
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

		JPanel panelLogin = new JPanel();
		add(panelLogin, BorderLayout.CENTER);

		panelLogin.setBackground(Color.LIGHT_GRAY);
		panelLogin.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				new LineBorder(new Color(0, 0, 0), 3)));
		GridBagLayout gbl_panelLogin = new GridBagLayout();
		gbl_panelLogin.columnWidths = new int[] { 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelLogin.rowHeights = new int[] { 60, 30, 0, 6, 0, 0, 0 };
		gbl_panelLogin.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelLogin.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelLogin.setLayout(gbl_panelLogin);

		JLabel lblLogin = new JLabel("Login:");
		GridBagConstraints gbc_lblLogin = new GridBagConstraints();
		gbc_lblLogin.anchor = GridBagConstraints.EAST;
		gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLogin.gridx = 6;
		gbc_lblLogin.gridy = 1;
		panelLogin.add(lblLogin, gbc_lblLogin);

		final JTextField textFieldLogin = new JTextField();
		GridBagConstraints gbc_textFieldLogin = new GridBagConstraints();
		gbc_textFieldLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLogin.gridwidth = 3;
		gbc_textFieldLogin.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLogin.gridx = 7;
		gbc_textFieldLogin.gridy = 1;
		panelLogin.add(textFieldLogin, gbc_textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 6;
		gbc_lblPassword.gridy = 3;
		panelLogin.add(lblPassword, gbc_lblPassword);

		final JPasswordField passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 7;
		gbc_passwordField.gridy = 3;
		panelLogin.add(passwordField, gbc_passwordField);

		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 7;
		gbc_btnAceptar.gridy = 5;
		panelLogin.add(btnAceptar, gbc_btnAceptar);

		// Aceptar
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textFieldLogin.getText();

				String password = "";
				for (char c : passwordField.getPassword()) {
					password += c;
				}
					
				if (nombre.isEmpty() || password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campo/s vacio/s", "Error login", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Cliente logeado correctamente", "Login cliente",
							JOptionPane.PLAIN_MESSAGE);
					textFieldLogin.setText("");
					passwordField.setText("");
				}

			}
		});
		// Cancelar
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 9;
		gbc_btnCancelar.gridy = 5;
		panelLogin.add(btnCancelar, gbc_btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldLogin.setText("");
				passwordField.setText("");
			}

		});

	}

}