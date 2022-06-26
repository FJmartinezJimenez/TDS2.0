package um.tds.AppVideo.gui;

import javax.swing.JPanel;

import um.tds.AppVideo.AppVideo;
import um.tds.AppVideo.controlador.Controlador;
import um.tds.AppVideo.dominio.ListaVideos;
import um.tds.AppVideo.dominio.Video;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class MisListas extends JPanel {
	JPanel panel_2 = new JPanel();
	JPanel panel_5 = new JPanel();
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
		panel_3.setBackground(Color.LIGHT_GRAY);
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
		for (ListaVideos lista : Controlador.getUnicaInstancia().getListas()) {
			comboBox.addItem(lista.getName());
		}

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() != "") {
					mostrarLista((String) comboBox.getSelectedItem());
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

		 

		JButton btnNewButton = new JButton("Reproducir");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 3;
		panel_3.add(btnNewButton, gbc_btnNewButton);
		
		//Reproducir
		btnNewButton.addActionListener(new ActionListener() { 
			 public void actionPerformed(ActionEvent e) { 
				 if ((String)comboBox.getSelectedItem()!= null &&
					 (String)comboBox.getSelectedItem() != "" && videoSeleccionado != null) {
					 reproducirVideo();
				 } 
			 } 
		 });

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		panel_5.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel_5);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
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
		panel_2.setBackground(Color.LIGHT_GRAY);
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

	}

	private void reproducirVideo() {
		

	}
	
	private void mostrarLista(String lista) {
		for (Component c : panel_5.getComponents()) {
			panel_5.remove(c);
		}
		List<Video> listaV = Controlador.getUnicaInstancia().getLista(lista);
		if (!listaV.isEmpty()) {
			for (Video video : listaV) {
				if (video != null) {
					JButton boton = new JButton();
					boton.setBackground(Color.gray);
					boton.setActionCommand(video.getUrl());
					ImageIcon thumb = AppVideo.videoWeb.getSmallThumb(video.getUrl());
					boton.setIcon(thumb);
					boton.addActionListener(listenerButtons);
					panel_5.add(boton);
				}
			}
		}
		panel_5.revalidate();
		panel_5.repaint();
	}

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
