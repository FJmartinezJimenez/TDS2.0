package um.tds.AppVideo.gui;

import javax.swing.JPanel;

import um.tds.AppVideo.controlador.Controlador;
import um.tds.AppVideo.dominio.ListaVideos;
import um.tds.AppVideo.dominio.Video;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class MisListas extends JPanel {
	JPanel panel_2 = new JPanel();
	/**
	 * Create the application.
	 */

	private final JComboBox<String> comboBox = new JComboBox<String>();

	private String videoSeleccionado = null;

	public MisListas() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_3, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 10, 0, 112, 0 };
		gbl_panel_3.rowHeights = new int[] { 10, 16, 22, 0, 5, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblNewLabel = new JLabel("Seleccione lista:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);

		comboBox.addItem("");
		for(ListaVideos lista : Controlador.getUnicaInstancia().getListas()){
			comboBox.addItem(lista.getName());
		}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() != "") {

					// showList(comboBox.getSelectedItem().toString());

				}

			}
		});

		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		panel_3.add(comboBox, gbc_comboBox);

		/*
		 * btnNewButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) {
		 * 
		 * if (comboBox.getSelectedItem().toString() != null &&
		 * comboBox.getSelectedItem().toString() != "" && videoSeleccionado != null) {
		 * 
		 * addVideoPlayer();
		 * 
		 * }
		 * 
		 * }
		 * 
		 * });
		 */

		JButton btnNewButton = new JButton("Reproducir");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		panel_3.add(btnNewButton, gbc_btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		JPanel panel_5 = new JPanel();
		scrollPane.setViewportView(panel_5);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_4, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("Cancelar");
		// Cancelar
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.setSelectedItem(0);
				cleanPanel();
			}
		});

		panel_4.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

	}

	/*
	 * private void showList(String lista) {
	 * 
	 * for (Component c : panel_4.getComponents()) {
	 * 
	 * panel_4.remove(c); }
	 * 
	 * List<Video> l = Controlador.getUnicaInstancia().getLista(lista);
	 * 
	 * if (l != null) {
	 * 
	 * for (Video v : l) {
	 * 
	 * if (v != null) {
	 * 
	 * JButton boton = new JButton(); boton.setBackground(Color.gray);
	 * boton.setActionCommand(v.getUrl());
	 * 
	 * ImageIcon thumb = Lanzador.videoWeb.getSmallThumb(v.getUrl());
	 * 
	 * boton.setIcon(thumb); boton.addActionListener(listenerButtons);
	 * 
	 * panel_4.add(boton);
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * panel_4.revalidate(); panel_4.repaint(); }
	 */

	private void cleanPanel() {
		for (Component c : panel_2.getComponents()) {
			panel_2.remove(c);
		}
		Controlador.getUnicaInstancia().stopVideo();
		panel_2.revalidate();
		panel_2.repaint();
	}

	private ActionListener listenerButtons = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			videoSeleccionado = arg0.getActionCommand();

		}
	};

}
