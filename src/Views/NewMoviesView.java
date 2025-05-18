/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.ControllerNewMovies;
import Models.Movie;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 *
 * @author Dell
 */
public class NewMoviesView extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form NewMoviesView
     */
    private ControllerNewMovies controllerNewMovies;
    JButton[][] pelis;
    JLabel[][] titulos;
    JLabel[][] puntuaciones;
    List<Movie> seleccionadas;
    int filas; 

    public NewMoviesView(List<Movie> movies, List<Movie> selectedMovies) {
        controllerNewMovies = new ControllerNewMovies(movies);
        seleccionadas = selectedMovies == null? new ArrayList<>(): selectedMovies;
        
        filas = controllerNewMovies.getFilas();
        pelis = new JButton[filas][];
        titulos = new JLabel[filas][];
        puntuaciones = new JLabel[filas][];
        initComponents();
        dibujarPeliculas();
    }
    
    private void dibujarPeliculas() {

		int separadoX = 20;
		int separadoY = 30;
		int ancho = 140;
		int alto = (int) (((double) ancho) * 1.6);
		int margen = 20;
		int peliculasPorFila = controllerNewMovies.getPELICULAS_POR_FILA();
		int cantidadPeliculas = controllerNewMovies.getCantidadPeliculas();
		int counter = 0;
		
		//TODO ****** BORAR ****** TODO//
		/*
		for(Movie movie : controladorVistaUsuario.getPeliculas()) {
			System.out.println(movie.getTitulo());
		}
		*/

		for (int i = 0; i < pelis.length; i++) {
			int len = (i == pelis.length-1) ? (cantidadPeliculas - (filas-1) * peliculasPorFila) : peliculasPorFila;
			System.out.println("pelis.length:" + pelis.length + " len:" + len);
			pelis[i] = new JButton[len];
			titulos[i] = new JLabel[len];
			puntuaciones[i] = new JLabel[len];
			for (int j = 0; j < len; j++) {
				// System.out.println(controladorVistaUsuario.getPeliculas().get(counter));
				pelis[i][j] = new JButton();
				titulos[i][j] = new JLabel();
				puntuaciones[i][j] = new JLabel();
				// setbounds (posX, posY, ancho, alto)
				pelis[i][j].setBounds(
						(ancho + margen) * j + separadoX,
						(alto + margen) * i + separadoY,
						ancho, alto
				);
				int ALTO_TITULO = 15;
				double RATIO_ANCHO = 0.75;
				titulos[i][j].setBounds(
						(ancho + margen)*j + separadoX,
						(alto + margen)*i + separadoY + alto,
						(int) ((double) ancho * (RATIO_ANCHO)),
						ALTO_TITULO
				);
				titulos[i][j].setText(controllerNewMovies.getTituloByIdx(counter));
				titulos[i][j].setBackground(Color.RED);
				titulos[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				titulos[i][j].setVerticalAlignment(SwingConstants.CENTER);
				puntuaciones[i][j].setBounds(
						(ancho + margen) * j + separadoX + (int) ((double) ancho * RATIO_ANCHO),
						(alto + margen) * i + separadoY + alto,
						(int) ((double) ancho * (1 - RATIO_ANCHO)),
						ALTO_TITULO
				);
				puntuaciones[i][j].setText(String.valueOf(controllerNewMovies.getPuntuacionByIdx(counter)));
				puntuaciones[i][j].setBackground(Color.BLUE);
				puntuaciones[i][j].setForeground(Color.WHITE);
				puntuaciones[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				puntuaciones[i][j].setVerticalAlignment(SwingConstants.CENTER);
				try {
					// w300, w780, w1200, original
					URL imageUrl = new URL(
							"https://image.tmdb.org/t/p/w300" +
					controllerNewMovies.entregarPelicula(counter).getBackdrop_path());
					counter++;
					Image img = ImageIO.read(imageUrl);
					img = img.getScaledInstance(ancho, alto, Image.SCALE_DEFAULT);
					pelis[i][j].setIcon(new ImageIcon(img));
				} catch (Exception ex) {
					System.out.println(ex);
				}
				panelPeliculas7.add(pelis[i][j]);
				panelPeliculas7.add(titulos[i][j]);
				panelPeliculas7.add(puntuaciones[i][j]);
				pelis[i][j].addActionListener(this);
			}
		}

		// Solucion de Gemini :')
		int anchoPanel = peliculasPorFila * (ancho + margen) + 2 * separadoX;
		int altoPanel = filas * (alto + margen) + 2 * separadoY;
		panelPeliculas7.setPreferredSize(new Dimension(anchoPanel, altoPanel));
		panelPeliculas7.revalidate();
		jScrollPane2.getVerticalScrollBar().setUnitIncrement(15);
	}
    
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		int peliculasPorFila = controllerNewMovies.getPELICULAS_POR_FILA();
    		for(int i = 0; i < pelis.length; i++) {
    			for(int j = 0; j < pelis[i].length; j++) {
    				if(e.getSource().equals(pelis[i][j])) {
    					Movie pelicula = controllerNewMovies.entregarPelicula(i * peliculasPorFila + j);
    					System.out.println(pelicula.getTitle());
    					
    					if (seleccionadas.contains(pelicula)) {
    	                    seleccionadas.remove(pelicula);
    	                    pelis[i][j].setOpaque(false); // Elimina color de fondo
    	                    pelis[i][j].setBackground(null);
    	                } else {
    	                    seleccionadas.add(pelicula);
    	                    pelis[i][j].setOpaque(true); // Necesario para ver el fondo
    	                    pelis[i][j].setBackground(Color.BLUE);
    	                    pelis[i][j].setForeground(Color.WHITE); // Mejor contraste
    	                }
    					 System.out.println("Seleccionadas: " + seleccionadas.size());
    				}
    			}
    		}
    	}
    	
//    	public void actionPerformed(ActionEvent e) {
//    	    int peliculasPorFila = controllerNewMovies.getPELICULAS_POR_FILA();
//    	    
//    	    for (int i = 0; i < pelis.length; i++) {
//    	        for (int j = 0; j < pelis[i].length; j++) {
//    	            if (e.getSource().equals(pelis[i][j])) {
//    	                Movie pelicula = controllerNewMovies.entregarPelicula(i * peliculasPorFila + j);
//
//    	                // Si ya está seleccionada, se quita
//    	                if (seleccionadas.contains(pelicula)) {
//    	                    seleccionadas.remove(pelicula);
//    	                    pelis[i][j].setOpaque(false); // Elimina color de fondo
//    	                    pelis[i][j].setBackground(null);
//    	                } else {
//    	                    seleccionadas.add(pelicula);
//    	                    pelis[i][j].setOpaque(true); // Necesario para ver el fondo
//    	                    pelis[i][j].setBackground(Color.BLUE);
//    	                    pelis[i][j].setForeground(Color.WHITE); // Mejor contraste
//    	                }
//
//    	                System.out.println("Seleccionadas: " + seleccionadas.size());
//    	            }
//    	        }
//    	    }
//    	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelPeliculas = new javax.swing.JPanel();
        btn_goBack = new javax.swing.JButton();
        btn_movies = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelPeliculas7 = new javax.swing.JPanel();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout panelPeliculasLayout = new javax.swing.GroupLayout(panelPeliculas);
        panelPeliculas.setLayout(panelPeliculasLayout);
        panelPeliculasLayout.setHorizontalGroup(
            panelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 681, Short.MAX_VALUE)
        );
        panelPeliculasLayout.setVerticalGroup(
            panelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelPeliculas);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_goBack.setText("Regresar");
        btn_goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_goBackActionPerformed(evt);
            }
        });

        btn_movies.setText("Seleccionar Pelculas");
        btn_movies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moviesActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout panelPeliculas7Layout = new javax.swing.GroupLayout(panelPeliculas7);
        panelPeliculas7.setLayout(panelPeliculas7Layout);
        panelPeliculas7Layout.setHorizontalGroup(
            panelPeliculas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        panelPeliculas7Layout.setVerticalGroup(
            panelPeliculas7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelPeliculas7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_goBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_movies)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_goBack)
                    .addComponent(btn_movies))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btn_moviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moviesActionPerformed
        AsignMoviesView am = new AsignMoviesView(controllerNewMovies.getMovies(),seleccionadas);
        am.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_moviesActionPerformed

    private void btn_goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_goBackActionPerformed
        AdminView av = new AdminView();
        av.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_goBackActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_goBack;
    private javax.swing.JButton btn_movies;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelPeliculas;
    private javax.swing.JPanel panelPeliculas7;
    // End of variables declaration//GEN-END:variables
}
