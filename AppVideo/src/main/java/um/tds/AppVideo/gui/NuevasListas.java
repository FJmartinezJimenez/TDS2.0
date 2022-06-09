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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Dimension;

public class NuevasListas {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevasListas window = new NuevasListas();
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
	public NuevasListas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 607, 478);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

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
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(96, 2));
		separator.setSize(new Dimension(96, 2));
		separator.setBackground(UIManager.getColor("Button.background"));
		separator.setForeground(UIManager.getColor("Button.background"));
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
		
		JPanel panelRecientes = new JPanel();
		panelRecientes.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panelRecientes, BorderLayout.CENTER);
		panelRecientes.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(Color.LIGHT_GRAY);
		panelRecientes.add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBackground(Color.LIGHT_GRAY);
		splitPane_1.setLeftComponent(panelBusqueda);
		GridBagLayout gbl_panelBusqueda = new GridBagLayout();
		gbl_panelBusqueda.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBusqueda.rowHeights = new int[]{0, 0, 0};
		gbl_panelBusqueda.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBusqueda.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelBusqueda.setLayout(gbl_panelBusqueda);
		
		
		JLabel lblBuscarTitulo = new JLabel("Buscar Titulo:");
		GridBagConstraints gbc_lblBuscarTitulo = new GridBagConstraints();
		gbc_lblBuscarTitulo.gridwidth = 3;
		gbc_lblBuscarTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscarTitulo.gridx = 7;
		gbc_lblBuscarTitulo.gridy = 0;
		panelBusqueda.add(lblBuscarTitulo, gbc_lblBuscarTitulo);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 10;
		gbc_textField_1.gridy = 0;
		panelBusqueda.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 14;
		gbc_btnBuscar.gridy = 0;
		panelBusqueda.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnNuevaBusqueda = new JButton("Nueva Busqueda");
		GridBagConstraints gbc_btnNuevaBusqueda = new GridBagConstraints();
		gbc_btnNuevaBusqueda.insets = new Insets(0, 0, 0, 5);
		gbc_btnNuevaBusqueda.gridx = 11;
		gbc_btnNuevaBusqueda.gridy = 1;
		panelBusqueda.add(btnNuevaBusqueda, gbc_btnNuevaBusqueda);
		
		JPanel panelVideos = new JPanel();
		panelVideos.setBackground(Color.LIGHT_GRAY);
		splitPane_1.setRightComponent(panelVideos);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		splitPane_2.setLeftComponent(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblIntroducirNombreLista = new JLabel("Introducir nombre lista:");
		GridBagConstraints gbc_lblIntroducirNombreLista = new GridBagConstraints();
		gbc_lblIntroducirNombreLista.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroducirNombreLista.gridx = 0;
		gbc_lblIntroducirNombreLista.gridy = 0;
		panel_1.add(lblIntroducirNombreLista, gbc_lblIntroducirNombreLista);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar_1 = new GridBagConstraints();
		gbc_btnBuscar_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar_1.gridx = 1;
		gbc_btnBuscar_1.gridy = 1;
		panel_1.add(btnBuscar_1, gbc_btnBuscar_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 0;
		gbc_btnEliminar.gridy = 2;
		panel_1.add(btnEliminar, gbc_btnEliminar);
		
		JSplitPane splitPane_3 = new JSplitPane();
		splitPane_3.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_2.setRightComponent(splitPane_3);
		
		JPanel panelBoton = new JPanel();
		splitPane_3.setRightComponent(panelBoton);
		panelBoton.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panelBoton.add(panel_2, BorderLayout.NORTH);
		
		JButton btnAadir = new JButton("A\u00F1adir");
		panel_2.add(btnAadir);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setPreferredSize(new Dimension(32, 2));
		panel_2.add(separator_1);
		
		JButton btnQuitar = new JButton("Quitar");
		panel_2.add(btnQuitar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panelBoton.add(panel_3, BorderLayout.CENTER);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_3.add(btnAceptar);
		
		JPanel panelLista = new JPanel();
		panelLista.setBackground(Color.LIGHT_GRAY);
		splitPane_3.setLeftComponent(panelLista);
	}
}
