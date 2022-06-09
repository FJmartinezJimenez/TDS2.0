package um.tds.AppVideo.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Dimension;

public class Explorar {

	private JFrame frame;
	private JTextField textFieldBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Explorar window = new Explorar();
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
	public Explorar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 413);
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
		frame.getContentPane().add(panelRecientes, BorderLayout.CENTER);
		panelRecientes.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setForeground(Color.LIGHT_GRAY);
		splitPane.setBackground(Color.LIGHT_GRAY);
		panelRecientes.add(splitPane, BorderLayout.CENTER);
		
		JPanel panelEtiquetas = new JPanel();
		panelEtiquetas.setBackground(Color.LIGHT_GRAY);
		splitPane.setLeftComponent(panelEtiquetas);
		GridBagLayout gbl_panelEtiquetas = new GridBagLayout();
		gbl_panelEtiquetas.columnWidths = new int[]{0, 0};
		gbl_panelEtiquetas.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panelEtiquetas.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelEtiquetas.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelEtiquetas.setLayout(gbl_panelEtiquetas);
		
		JLabel lblEtiquetasDisponibles = new JLabel("Etiquetas disponibles");
		GridBagConstraints gbc_lblEtiquetasDisponibles = new GridBagConstraints();
		gbc_lblEtiquetasDisponibles.insets = new Insets(0, 0, 5, 0);
		gbc_lblEtiquetasDisponibles.gridx = 0;
		gbc_lblEtiquetasDisponibles.gridy = 0;
		panelEtiquetas.add(lblEtiquetasDisponibles, gbc_lblEtiquetasDisponibles);
		
		JList listEtDisponibles = new JList();
		GridBagConstraints gbc_listEtDisponibles = new GridBagConstraints();
		gbc_listEtDisponibles.insets = new Insets(0, 0, 5, 0);
		gbc_listEtDisponibles.fill = GridBagConstraints.BOTH;
		gbc_listEtDisponibles.gridx = 0;
		gbc_listEtDisponibles.gridy = 1;
		panelEtiquetas.add(listEtDisponibles, gbc_listEtDisponibles);
		
		JLabel lblBuscarEtiquetas = new JLabel("Buscar etiquetas:");
		GridBagConstraints gbc_lblBuscarEtiquetas = new GridBagConstraints();
		gbc_lblBuscarEtiquetas.insets = new Insets(0, 0, 5, 0);
		gbc_lblBuscarEtiquetas.gridx = 0;
		gbc_lblBuscarEtiquetas.gridy = 2;
		panelEtiquetas.add(lblBuscarEtiquetas, gbc_lblBuscarEtiquetas);
		
		JList listBuscarEt = new JList();
		GridBagConstraints gbc_listBuscarEt = new GridBagConstraints();
		gbc_listBuscarEt.fill = GridBagConstraints.BOTH;
		gbc_listBuscarEt.gridx = 0;
		gbc_listBuscarEt.gridy = 3;
		panelEtiquetas.add(listBuscarEt, gbc_listBuscarEt);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setBackground(Color.LIGHT_GRAY);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBackground(Color.LIGHT_GRAY);
		splitPane_1.setLeftComponent(panelBusqueda);
		GridBagLayout gbl_panelBusqueda = new GridBagLayout();
		gbl_panelBusqueda.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBusqueda.rowHeights = new int[]{0, 0, 0};
		gbl_panelBusqueda.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelBusqueda.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelBusqueda.setLayout(gbl_panelBusqueda);
		
		JLabel lblBuscarTitulo = new JLabel("Buscar Titulo:");
		GridBagConstraints gbc_lblBuscarTitulo = new GridBagConstraints();
		gbc_lblBuscarTitulo.gridwidth = 4;
		gbc_lblBuscarTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscarTitulo.gridx = 4;
		gbc_lblBuscarTitulo.gridy = 0;
		panelBusqueda.add(lblBuscarTitulo, gbc_lblBuscarTitulo);
		
		textFieldBuscar = new JTextField();
		GridBagConstraints gbc_textFieldBuscar = new GridBagConstraints();
		gbc_textFieldBuscar.gridwidth = 6;
		gbc_textFieldBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBuscar.gridx = 8;
		gbc_textFieldBuscar.gridy = 0;
		panelBusqueda.add(textFieldBuscar, gbc_textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 14;
		gbc_btnBuscar.gridy = 0;
		panelBusqueda.add(btnBuscar, gbc_btnBuscar);
		
		JButton btnNuevaBusqueda = new JButton("Nueva Busqueda");
		GridBagConstraints gbc_btnNuevaBusqueda = new GridBagConstraints();
		gbc_btnNuevaBusqueda.insets = new Insets(0, 0, 0, 5);
		gbc_btnNuevaBusqueda.gridx = 10;
		gbc_btnNuevaBusqueda.gridy = 1;
		panelBusqueda.add(btnNuevaBusqueda, gbc_btnNuevaBusqueda);
		
		JPanel panelVideos = new JPanel();
		panelVideos.setBackground(Color.LIGHT_GRAY);
		splitPane_1.setRightComponent(panelVideos);
	}

}
