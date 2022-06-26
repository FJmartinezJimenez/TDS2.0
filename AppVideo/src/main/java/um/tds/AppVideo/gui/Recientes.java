package um.tds.AppVideo.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import um.tds.AppVideo.AppVideo;
import um.tds.AppVideo.controlador.Controlador;
import um.tds.AppVideo.dominio.Video;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@SuppressWarnings("serial")
public class Recientes extends JPanel {
	JPanel panel_2;
	/**
	 * Create the application.
	 */
	public Recientes() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{97, 161, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{5, 25, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Mostrando videos recientes:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("Top 10 ");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		//Ver Top10
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Controlador.getUnicaInstancia().getUsuario() != null) {
					cleanVideos();
					mostrarVideos(Controlador.getUnicaInstancia().getTop10());
				}
				

			}
		});

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		mostrarVideos(Controlador.getUnicaInstancia().getRecientes());
	}
	
	private ActionListener listenerButtons = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			cleanVideos();
			panel_2.add(AppVideo.videoWeb);
			Controlador.getUnicaInstancia().playVideo(arg0.getActionCommand());
		}
	};
	
	private void mostrarVideos(List<Video> lista) {
		for (Video video : lista) {
			JButton boton = new JButton();
			boton.setBackground(Color.gray);
			boton.setActionCommand(video.getUrl());
			ImageIcon thumb = AppVideo.videoWeb.getSmallThumb(video.getUrl());
			boton.setIcon(thumb);
			boton.addActionListener(listenerButtons);
			panel_2.add(boton);
		}
		panel_2.revalidate();
		panel_2.repaint();
	}
	
	private void cleanVideos() {
		for (Component c : panel_2.getComponents()) {
			panel_2.remove(c);
		}
		Controlador.getUnicaInstancia().stopVideo();
		panel_2.revalidate();
		panel_2.repaint();
	}

	
	


}
