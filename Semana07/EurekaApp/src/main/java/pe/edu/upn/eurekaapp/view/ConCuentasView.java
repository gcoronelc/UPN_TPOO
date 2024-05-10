
package pe.edu.upn.eurekaapp.view;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.upn.eurekaapp.controller.CuentaController;
import pe.edu.upn.eurekaapp.dto.CuentaDto;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 * @cursos gcoronelc.github.io
 */
public class ConCuentasView extends javax.swing.JInternalFrame {

    /** Creates new form ConCuentasView */
    public ConCuentasView() {
        initComponents();
		  try {
			 this.setMaximum(true);
		 } catch (Exception e) {
		 }	  
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      btnConsultar = new javax.swing.JButton();
      jScrollPane1 = new javax.swing.JScrollPane();
      tblRepo = new javax.swing.JTable();

      setClosable(true);
      setIconifiable(true);
      setMaximizable(true);
      setTitle("Consultar Cuentas");

      btnConsultar.setText("Consultar");
      btnConsultar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnConsultarActionPerformed(evt);
         }
      });

      tblRepo.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
         },
         new String [] {
            "CUENTA", "MONEDA", "CLIENTE", "SALDO", "ESTADO"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
         };
         boolean[] canEdit = new boolean [] {
            false, false, false, false, false
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }

         public boolean isCellEditable(int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
         }
      });
      jScrollPane1.setViewportView(tblRepo);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(492, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
      try {
         // Traer la lista
         CuentaController controller = new CuentaController();
         List<CuentaDto> lista = controller.listaCuentas();
         // Reporte
         DefaultTableModel tabla;
         tabla = (DefaultTableModel) tblRepo.getModel();
         tabla.setRowCount(0); // Elimina todas ls filas
         for (CuentaDto dto : lista) {
            Object[] rowData = {
               dto.getCuenta(),
               dto.getMoneda(),
               dto.getCliente(),
               dto.getSaldo(),
               dto.getEstado()
            };
            tabla.addRow(rowData);
         }
      } catch (Exception e) {
         JOptionPane.showMessageDialog(rootPane, e.getMessage());
      }
   }//GEN-LAST:event_btnConsultarActionPerformed


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnConsultar;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tblRepo;
   // End of variables declaration//GEN-END:variables

}
