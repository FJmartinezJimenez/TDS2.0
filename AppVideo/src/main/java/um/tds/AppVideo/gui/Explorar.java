package um.tds.AppVideo.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import um.tds.AppVideo.AppVideo;
import um.tds.AppVideo.controlador.Controlador;
import um.tds.AppVideo.dominio.Etiqueta;
import um.tds.AppVideo.dominio.Video;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.BoxLayout;


@SuppressWarnings("serial")
public class Explorar extends JPanel {
	private JTextField textField;
	private JList<String> list_1;
	private JList<String> list;
	private DefaultListModel<String> d2 = new DefaultListModel<String>();
	JPanel panel_3 = new JPanel();

	/**
	 * Create the application.
	 */
	public Explorar() {
		setLayout(new BorderLayout(0, 0));

		JPanel panelRecientes = new JPanel();
		panelRecientes.setBackground(Color.LIGHT_GRAY);
		panelRecientes.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelRecientes, BorderLayout.EAST);
		GridBagLayout gbl_panelRecientes = new GridBagLayout();
		gbl_panelRecientes.columnWidths = new int[] { 9, 0, 8, 0 };
		gbl_panelRecientes.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 9, 0 };
		gbl_panelRecientes.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelRecientes.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panelRecientes.setLayout(gbl_panelRecientes);

		JLabel lblNewLabel_1 = new JLabel("Etiquetas disponibles");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panelRecientes.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 2;
		panelRecientes.add(scrollPane_1, gbc_scrollPane_1);

		DefaultListModel<String> d = new DefaultListModel<String>();
		addEtiquetasList(d);
		list = new JList<String>(d);
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					String aux = (String) list.getSelectedValue();
					d2.addElement(aux);
				}
			}
		});

		scrollPane_1.setViewportView(list);

		JLabel lblNewLabel_1_1 = new JLabel("Buscar etiquetas");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 4;
		panelRecientes.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 5;
		panelRecientes.add(scrollPane_2, gbc_scrollPane_2);

		list_1 = new JList<String>(d2);
		scrollPane_2.setViewportView(list_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 5, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 5, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel("Buscar título:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		panel_1.add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Buscar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 1;
		panel_1.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("Nueva búsqueda");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 2;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_2.add(scrollPane);
		panel_3.setBackground(Color.LIGHT_GRAY);

		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		// Busqueda
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanVideos();
				mostrarVideos();

			}
		});

		// Nueva Busqueda
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cleanVideos();
				d2.clear();
			}
		});
	}

	public void addEtiquetasList(DefaultListModel<String> d) {
		for (Etiqueta et : Controlador.getUnicaInstancia().getEtiquetas()) {
			d.addElement(et.getNombre());
		}
	}

	public void mostrarVideos() {
		cleanVideos();
		List<String> etiquetas = new ArrayList<String>();
		for (int i = 0; i < list_1.getModel().getSize(); i++) {
			etiquetas.add(d2.getElementAt(i));
		}
		String titulo = textField.getText().trim();
		Collection<Video> set = Controlador.getUnicaInstancia().searchVideos(etiquetas, titulo);
		for (Video v : set) {
			JButton boton = new JButton();
			boton.setBackground(Color.gray);
			boton.setActionCommand(v.getUrl());
			ImageIcon thumb = AppVideo.videoWeb.getSmallThumb(v.getUrl());
			boton.setIcon(thumb);
			boton.addActionListener(listenerButtons);
			panel_3.add(boton);
		}
		panel_3.revalidate();
		textField.setText("");
		d2.clear();
	}
	
	public void cleanVideos() {
		for (Component c : panel_3.getComponents()) {
			panel_3.remove(c);
		}
		panel_3.repaint();
		Controlador.getUnicaInstancia().stopVideo();

	}

	private ActionListener listenerButtons = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cleanVideos();
			panel_3.add(AppVideo.videoWeb);
			Controlador.getUnicaInstancia().playVideo(arg0.getActionCommand());
		}
	};

	public void cambioDePanel() {
		cleanVideos();
		textField.setText("");
		d2.clear();
	}
	

}
