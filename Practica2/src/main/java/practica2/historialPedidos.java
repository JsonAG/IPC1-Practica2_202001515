/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package practica2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author jaswl
 */
public class historialPedidos extends javax.swing.JFrame implements Serializable{

    public static Pedido[] cantPedidos = new Pedido[50];
    public static int contadorPedido;
    public static int fila;
    /**
     * Creates new form historialPedidos
     */
    public historialPedidos() {
        initComponents();
         this.setResizable(false);
        this.setLocationRelativeTo(null);
       actualizarListaPedidos(); 
       
       DefaultTableModel modeloTabla = new DefaultTableModel(
    new Object[][] {
        {"Repartidor 1", "5", "75", "21/06/2023 8:00PM", "21/06/2023 8:27PM"},
        {null, null, null, null, null},
        {null, null, null, null, null}
    },
    new String[] {"Vehículo", "Distancia", "Monto", "Fecha Creacion", "Fecha Entrega"}
);
jTable1.setModel(modeloTabla);

       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("HISTORIAL DE PEDIDOS");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Repartidor 1", "5", "75", "21/06/2023 8:00PM", "21/06/2023 8:27PM"},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Vehículo", "Distancia", "Monto", "Fecha Creacion", "Fecha Entrega"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Serializar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(265, 265, 265)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Pedidos pe = new Pedidos(); 
        pe.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         serializarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    
       public void actualizarListaPedidos() {

        if (contadorPedido > 0) {

            // actualizar listado
            SerializableTableModel modeloListado = new SerializableTableModel(null, new String[]{"Vehículo", "Distancia", "Monto", "Fecha Creacion", "Fecha Entrega"});
            modeloListado.setRowCount(contadorPedido);
            for (int i = 0; i < contadorPedido; i++) {
                modeloListado.setValueAt(cantPedidos[i].recorrido, i, 0);
                modeloListado.setValueAt(cantPedidos[i].repartidor, i, 1);
                modeloListado.setValueAt(cantPedidos[i].monto, i, 2);
                modeloListado.setValueAt(cantPedidos[i].fechaInicio, i, 3);
                modeloListado.setValueAt(cantPedidos[i].fechaEntrega, i, 4);
            }
        }
       }
        public void serializarTabla() {
        DefaultTableModel modeloListado = (DefaultTableModel) jTable1.getModel();
         Object[][] datos = getTableModelData(modeloListado);
        try {
            FileOutputStream fileOut = new FileOutputStream("pedido.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(modeloListado);
            out.close();
            fileOut.close();
            System.out.println("El modelo de la tabla ha sido serializado y guardado en 'historialPedidos.ser'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private Object[][] getTableModelData(DefaultTableModel model) {
    int rowCount = model.getRowCount();
    int columnCount = model.getColumnCount();
    Object[][] data = new Object[rowCount][columnCount];

    for (int row = 0; row < rowCount; row++) {
        for (int col = 0; col < columnCount; col++) {
            data[row][col] = model.getValueAt(row, col);
        }
    }

    return data;
}
    
       
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(historialPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(historialPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(historialPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(historialPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new historialPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}