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
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Dimension;

public class MisListas {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MisListas window = new MisListas();
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
	public MisListas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 436);
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
		panelRecientes.add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		
		JPanel panelMisListas = new JPanel();
		panelMisListas.setBackground(Color.LIGHT_GRAY);
		splitPane_1.setLeftComponent(panelMisListas);
		GridBagLayout gbl_panelMisListas = new GridBagLayout();
		gbl_panelMisListas.columnWidths = new int[]{0, 0};
		gbl_panelMisListas.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelMisListas.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMisListas.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelMisListas.setLayout(gbl_panelMisListas);
		
		JLabel lblSeleccionarLista = new JLabel("Seleccionar lista:");
		GridBagConstraints gbc_lblSeleccionarLista = new GridBagConstraints();
		gbc_lblSeleccionarLista.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccionarLista.gridx = 0;
		gbc_lblSeleccionarLista.gridy = 0;
		panelMisListas.add(lblSeleccionarLista, gbc_lblSeleccionarLista);
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 1;
		panelMisListas.add(comboBox, gbc_comboBox);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setRightComponent(splitPane_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		splitPane_2.setLeftComponent(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		splitPane_2.setRightComponent(panel_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_2.add(btnCancelar);
		
		JPanel panelVideos = new JPanel();
		panelVideos.setBackground(Color.LIGHT_GRAY);
		splitPane.setRightComponent(panelVideos);
		
	}

}
