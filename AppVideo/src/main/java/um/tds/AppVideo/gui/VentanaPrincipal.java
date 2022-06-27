package um.tds.AppVideo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.itextpdf.text.DocumentException;

import um.tds.AppVideo.controlador.Controlador;


import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Dimension;
import java.awt.CardLayout;

import pulsador.IEncendidoListener;
import pulsador.Luz;

public class VentanaPrincipal  implements IEncendidoListener {
	private JFrame frame;
	private CardLayout cl;
	private JPanel activeCard;
	Recientes recientes = new Recientes();
	Login login = new Login();
	Explorar explorar = new Explorar();
	MisListas mislistas = new MisListas();
	NuevasListas nuevaslistas = new NuevasListas();
	Registro registro = new Registro();

	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 633, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panelArriba = new JPanel();
		panelArriba.setForeground(UIManager.getColor("Button.background"));
		panelArriba.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panelArriba);
		panelArriba.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblAppVideo = new JLabel("APP VIDEO");
		lblAppVideo.setFont(new Font("Baskerville Old Face", Font.BOLD, 23));
		lblAppVideo.setForeground(Color.RED);
		panelArriba.add(lblAppVideo);
		
		Luz luz = new Luz();
		panelArriba.add(luz);
		luz.setColor(Color.YELLOW);
		luz.addEncendidoListener((IEncendidoListener) this);


		JSeparator separator = new JSeparator();
		separator.setForeground(UIManager.getColor("Button.background"));
		separator.setPreferredSize(new Dimension(16, 2));
		separator.setBackground(UIManager.getColor("Button.background"));
		panelArriba.add(separator);
		
		JButton btnPdf = new JButton("PDF");
		panelArriba.add(btnPdf);
		

		JButton btnRegistro = new JButton("Registro");
		panelArriba.add(btnRegistro);

		JButton btnLogin = new JButton("Login");
		panelArriba.add(btnLogin);

		JButton btnLogout = new JButton("Logout");
		panelArriba.add(btnLogout);

		JButton btnPremium = new JButton("Premium");
		btnPremium.setForeground(Color.BLACK);
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

		final JPanel panelPrincipal = new JPanel();
		panel_1.add(panelPrincipal, BorderLayout.CENTER);
		panelPrincipal.setLayout(new CardLayout(0, 0));

		panelPrincipal.add(login, "login");

		panelPrincipal.add(registro, "registro");

		panelPrincipal.add(explorar, "explorar");

		panelPrincipal.add(mislistas, "mislistas");

		panelPrincipal.add(nuevaslistas, "nuevaslistas");

		panelPrincipal.add(recientes, "recientes");

		cl = (CardLayout) (panelPrincipal.getLayout());
		cl.show(panelPrincipal, "login");
		
		/**
		 * Ventanas
		 */
		
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Controlador.getUnicaInstancia().generatePDF();
				} catch (FileNotFoundException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				} catch (DocumentException e1) {
					// TODO Bloque catch generado automáticamente
					e1.printStackTrace();
				}
			}
		});

		// Registro
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Controlador.getUnicaInstancia().getUsuario() == null) {
					cl.show(panelPrincipal, "registro");
				}else {
					JOptionPane.showMessageDialog(frame, "Ya hay un usuario logueado", "Error usuario",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});

		// Login
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Controlador.getUnicaInstancia().getUsuario() == null) {
					cl.show(panelPrincipal, "login");
				}else {
					JOptionPane.showMessageDialog(frame, "Ya hay un usuario logueado", "Error usuario",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});

		// Logout
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panelPrincipal, "login");
			}
		});

		// Premium
		btnPremium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Controlador.getUnicaInstancia().getUsuario() == null) {
					JOptionPane.showMessageDialog(frame, "No estas logueado", "Error usuario",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Controlador.getUnicaInstancia().becomePremium();
					JOptionPane.showMessageDialog(frame, "Enhorabuena ya eres premium", "Usuario Premium",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		// Explorar
		btnExplorar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Controlador.getUnicaInstancia().getUsuario() == null) {
					JOptionPane.showMessageDialog(frame, "No estas logueado", "Error usuario",
							JOptionPane.WARNING_MESSAGE);
				} else {
					switchWindow();
					activeCard = explorar;
					cl.show(panelPrincipal, "explorar");
				}
			}
			});

		// Mis Listas
		btnMisListas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Controlador.getUnicaInstancia().getUsuario() == null) {
					JOptionPane.showMessageDialog(frame, "No estas logueado", "Error usuario",
							JOptionPane.WARNING_MESSAGE);
				} else {
					mislistas.entrada();
					switchWindow();
					activeCard = mislistas;
					cl.show(panelPrincipal, "mislistas");
				}
			}
			});

		// Recientes
		btnRecientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Controlador.getUnicaInstancia().getUsuario() == null) {
					JOptionPane.showMessageDialog(frame, "No estas logueado", "Error usuario",
							JOptionPane.WARNING_MESSAGE);
				} else {
					recientes.entrada();
					switchWindow();
					activeCard =recientes;
					cl.show(panelPrincipal, "recientes");
				}
			}
		});

		// Nueva lista
		btnNuevaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Controlador.getUnicaInstancia().getUsuario() == null) {
					JOptionPane.showMessageDialog(frame, "No estas logueado", "Error usuario",
							JOptionPane.WARNING_MESSAGE);
				} else {
					switchWindow();
					activeCard = nuevaslistas;
					cl.show(panelPrincipal, "nuevaslistas");
				}
			}
		});
	}
	
	@Override
	public void enteradoCambioEncendido(EventObject evt) {
		JFileChooser fileChooser = new JFileChooser();
		int retChooser = fileChooser.showOpenDialog(null);
		if (retChooser == JFileChooser.APPROVE_OPTION) {
			String pwd = fileChooser.getSelectedFile().getAbsolutePath();
			Controlador.getUnicaInstancia().getVideosFromXml(pwd);
		}else {
			JOptionPane.showMessageDialog(frame, "Sin fichero seleccionado", "Error fichero",
					JOptionPane.WARNING_MESSAGE);
		}

	}
	
	//Dependiendo de la ventana procedemos de una manera o de otra
	public void switchWindow() {
		if (activeCard instanceof Explorar) {
			explorar.cambioDePanel();
		}else if (activeCard instanceof Recientes) {
			recientes.cambioDePanel();
		} else if (activeCard instanceof MisListas) {
			mislistas.cambioDePanel();
		}
		else if (activeCard instanceof NuevasListas) {
			nuevaslistas.cambioDePanel();
		}

	}

}
