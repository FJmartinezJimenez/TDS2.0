package um.tds.AppVideo.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashSet;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import um.tds.AppVideo.AppVideo;
import um.tds.AppVideo.controlador.Controlador;
import um.tds.AppVideo.dominio.ListaVideos;
import um.tds.AppVideo.dominio.Video;

import java.awt.Color;
import java.awt.Component;

@SuppressWarnings("serial")
public class NuevasListas extends JPanel {
	private JTextField textField;	
	private JTextField textField_1;
	JPanel panel_5 = new JPanel();
	JPanel panel_6 = new JPanel();
	private ListaVideos lista;

	public NuevasListas() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(Color.LIGHT_GRAY);
		panel_3_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_3_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3_1 = new GridBagLayout();
		gbl_panel_3_1.columnWidths = new int[]{10, 0, 112, 0};
		gbl_panel_3_1.rowHeights = new int[]{10, 16, 22, 0, 5, 0};
		gbl_panel_3_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3_1.setLayout(gbl_panel_3_1);
		
		JLabel lblIntroducirNombreLista = new JLabel("Introducir nombre lista:");
		GridBagConstraints gbc_lblIntroducirNombreLista = new GridBagConstraints();
		gbc_lblIntroducirNombreLista.anchor = GridBagConstraints.WEST;
		gbc_lblIntroducirNombreLista.insets = new Insets(0, 0, 5, 5);
		gbc_lblIntroducirNombreLista.gridx = 1;
		gbc_lblIntroducirNombreLista.gridy = 1;
		panel_3_1.add(lblIntroducirNombreLista, gbc_lblIntroducirNombreLista);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel_3_1.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.anchor = GridBagConstraints.WEST;
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 3;
		panel_3_1.add(btnBuscar, gbc_btnBuscar);
		
		//Boton Buscar
		btnBuscar.addActionListener(new ActionListener() { 
			 public void actionPerformed(ActionEvent e) { 
				 ListaVideos aux = Controlador.getUnicaInstancia().findLista(textField_1.getText());
					if (aux != null) {
						showVideos(panel_5, aux.getVideos(), "I");
						lista = aux;
					} else {
						JOptionPane.showConfirmDialog(null, "¿Desea añadir lista?");
						if (JOptionPane.OK_OPTION == 0) {
							lista = Controlador.getUnicaInstancia().createList(textField_1.getText());
						}

					}

				 
			 } 
		 });
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 3;
		panel_3_1.add(btnNewButton_3, gbc_btnNewButton_3);
		
		//Boton eliminar
		btnNewButton_3.addActionListener(new ActionListener() { 
			 public void actionPerformed(ActionEvent e) { 
				 	textField_1.setText("");
					lista = null;
			 } 
		 });
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_4.add(scrollPane_1, BorderLayout.CENTER);
		
		
		panel_6.setBackground(Color.LIGHT_GRAY);
		scrollPane_1.setViewportView(panel_6);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.LIGHT_GRAY);
		panel_4_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_4_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4_1 = new GridBagLayout();
		gbl_panel_4_1.columnWidths = new int[]{93, 0, 97, 0, 0};
		gbl_panel_4_1.rowHeights = new int[]{4, 25, 0, 0, 0};
		gbl_panel_4_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4_1.setLayout(gbl_panel_4_1);
		
		JButton btnNewButton_2 = new JButton("Añadir");
		btnNewButton_2.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 1;
		panel_4_1.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Quitar");
		btnNewButton_4.setForeground(Color.BLUE);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 2;
		gbc_btnNewButton_4.gridy = 1;
		panel_4_1.add(btnNewButton_4, gbc_btnNewButton_4);
			
		JButton btnNewButton_5 = new JButton("Aceptar");
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 2;
		panel_4_1.add(btnNewButton_5, gbc_btnNewButton_5);
		
		//Boton Aceptar
		btnNewButton_5.addActionListener(new ActionListener() { 
			 public void actionPerformed(ActionEvent e) { 
				 if (lista != null) {
					ListaVideos aux = Controlador.getUnicaInstancia().findLista(textField.getText());
					if (aux != null) {
						Controlador.getUnicaInstancia().createList(aux.getName(), aux.getVideos());
					} else {
						Controlador.getUnicaInstancia().createList(lista.getName(), lista.getVideos());
					}
				}
				lista=null;
				cleanVideo();
				 
			 } 
		 });
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Buscar título:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() { 
			 public void actionPerformed(ActionEvent e) { 
				 	String titulo = textField.getText().trim();
					cleanVideosDerecha();
					Collection<Video> videos = Controlador.getUnicaInstancia().searchVideos(titulo);
					showVideos(panel_5, videos, "D"); 
			 } 
		 });
		
		JButton btnNewButton_1 = new JButton("Nueva búsqueda");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 2;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
		
		//Nueva busqueda
		btnNewButton_1.addActionListener(new ActionListener() { 
			 public void actionPerformed(ActionEvent e) { 
				 cleanVideosDerecha();
			 } 
		 });
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_3.add(scrollPane);
		panel_5.setBackground(Color.LIGHT_GRAY);
		
		scrollPane.setViewportView(panel_5);
	}
	
	private void showVideos(JPanel j, Collection<Video> videos, String s) {
		for (Video v : videos) {
			JButton boton = new JButton();
			boton.setBackground(Color.gray);
			boton.setActionCommand(v.getUrl());
			ImageIcon thumb = AppVideo.videoWeb.getSmallThumb(v.getUrl());
			boton.setIcon(thumb);
			if (s.equals("I")) {
				boton.addActionListener(listenerButtonsLeftPanel);
			}
			else {
				boton.addActionListener(listenerButtonsRightPanel);
			}
			int control = 0;
			if (j == panel_5) {
				for (Component c : panel_5.getComponents()) {
					if (c instanceof JButton) {
						if (((JButton) c).getActionCommand().equals(v.getUrl())) {
							control = 1;
						}
					}
				}
				if (control == 0) {
					j.add(boton);
				}
			}
			else {
				j.add(boton);
			}

		}
		j.revalidate();
		j.repaint();

	}

	private ActionListener listenerButtonsRightPanel = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (lista != null) {
				Video v = Controlador.getUnicaInstancia().findVideo(arg0.getActionCommand());
				Controlador.getUnicaInstancia().addVideotoList(lista.getName(), v);
				Collection<Video> listv = new HashSet<Video>();
				listv.add(v);
				showVideos(panel_6, listv, "I");
			}else {
				JOptionPane.showInternalMessageDialog(null, "Primero debes seleccionar una lista");
			}
		}
	};

	private ActionListener listenerButtonsLeftPanel = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Video v = Controlador.getUnicaInstancia().findVideo(arg0.getActionCommand());
			Controlador.getUnicaInstancia().deleteVideotoList(lista.getName(), v);
			for (Component c : panel_6.getComponents()) {
				if (c instanceof JButton) {
					if (((JButton) c).getActionCommand().equals(arg0.getActionCommand())) {
						panel_6.remove(c);
						panel_6.revalidate();
						panel_6.repaint();
					}

				}
			}

		}
	};
	
	public void cleanVideosDerecha(){
		for (Component c : panel_5.getComponents()) {
			panel_5.remove(c);
		}
		textField.setText("");
		panel_5.revalidate();
		panel_5.repaint();
	}
	
	public void cleanVideosIzquierda() {
		for (Component c : panel_6.getComponents()) {
			panel_6.remove(c);
		}
		textField_1.setText("");
		panel_6.revalidate();
		panel_6.repaint();
	}
	
	public void cleanVideo() {
		cleanVideosDerecha();
		cleanVideosIzquierda();
	}

	public void cambioDePanel() {
		cleanVideo();
	}	

	
	

}
