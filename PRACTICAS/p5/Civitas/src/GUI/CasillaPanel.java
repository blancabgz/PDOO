/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import civitas.Casilla;

/**
 *
 * @author Blanca
 */
public class CasillaPanel extends javax.swing.JPanel {
    
    Casilla casilla;
    /**
     * Creates new form CasillaPanel
     */
    public CasillaPanel() {
        initComponents();
    }
    
    void setCasilla(Casilla c){
        casilla = c;
        nombreCasilla.setText(c.getNombre());
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JLabel();
        nombreCasilla = new javax.swing.JTextField();

        nombre.setText("Nombre");
        add(nombre);

        nombreCasilla.setEditable(false);
        nombreCasilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreCasillaActionPerformed(evt);
            }
        });
        add(nombreCasilla);
    }// </editor-fold>//GEN-END:initComponents

    private void nombreCasillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreCasillaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreCasillaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField nombreCasilla;
    // End of variables declaration//GEN-END:variables
}
