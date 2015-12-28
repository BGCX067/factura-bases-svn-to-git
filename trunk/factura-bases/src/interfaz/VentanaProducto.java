/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import MatrizDinamica.Matriz;
import java.util.ArrayList;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import negocio.Producto;
import negocio.Productos;

/**
 *
 * @author pablo
 */
public class VentanaProducto extends javax.swing.JInternalFrame {

    Producto unProducto = new Producto();
    Productos listaproductos = new Productos();
    Object[] namecolums = {"Id", "Nombre", "Cantidad", "Precio"};
    DefaultTableModel temp = new DefaultTableModel(namecolums, 0);
    int row = -1;

    public VentanaProducto() {
        initComponents();
        Actualizar();
        tblProductos.setModel(temp);
    }
    public void nuevo() {
        txtnombre.setText("");
        txtprecio.setText("");
        txtcantidad.setValue(0);
    }
    public void Grabar() {
        SpinnerDateModel model = new SpinnerDateModel();
        System.out.println(txtcantidad.getValue().toString());
        unProducto.setNombre(txtnombre.getText());
        unProducto.setCantidad(Integer.parseInt(txtcantidad.getValue().toString()));
        unProducto.setPrecio(Double.parseDouble(txtprecio.getText()));
        unProducto.grabar();
        System.out.println("grbado");
        Actualizar();
    }

    public void Buscar() {
        unProducto.setIdproducto(Integer.parseInt(tblProductos.getValueAt(row, 0).toString()));
        unProducto.buscar();
    }

    public void modificar() {
        Buscar();
        if (unProducto.getIdproducto() == Integer.parseInt(tblProductos.getValueAt(row, 0).toString())) {
            unProducto.setNombre(txtnombre.getText());
            unProducto.setCantidad(Integer.parseInt(txtcantidad.getValue().toString()));
            unProducto.setPrecio(Double.parseDouble(txtprecio.getText()));
            unProducto.modificar();

        }
    }
    public void eliminar() {
        if (unProducto.getIdproducto() == Integer.parseInt(txtid.getText())) {
            unProducto.eliminar();

        } else {
            
        }
    }
    public void Actualizar() {
        Matriz m = new Matriz(4);
        listaproductos.listar();
        ArrayList productos = new ArrayList();
        productos = listaproductos.getProductos();
        for (int i = 0; i < productos.size(); i++) {
            Producto otroProducto = new Producto();
            otroProducto = (Producto) productos.get(i);
            Object nuevo[] = {otroProducto.getIdproducto(), otroProducto.getNombre(), otroProducto.getCantidad(), otroProducto.getPrecio()}; //esto es por las tres columnas aunque puede variar
            m.agregar(nuevo);
        }
        temp.setDataVector(m.darTablaEntera(), namecolums);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtprecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JSpinner();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

        setTitle("Ingreso de Produtos");
        setToolTipText("");
        setPreferredSize(new java.awt.Dimension(1000, 576));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informacion", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("id:");

        txtid.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtid.setEnabled(false);

        jLabel2.setText("Nombre:");

        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel3.setText("Precio:");

        txtprecio.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel4.setText("Cantidad:");

        txtcantidad.setFocusable(false);
        txtcantidad.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addComponent(txtprecio, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jButton1.setText("Limpiar");

        jLabel5.setText("Buscar:");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        row = tblProductos.getSelectedRow();
        System.out.println(row);
        if (row != -1) {
            txtid.setText(tblProductos.getValueAt(row, 0).toString());
            txtnombre.setText(tblProductos.getValueAt(row, 1).toString());
            txtcantidad.setValue(tblProductos.getValueAt(row, 2));
            txtprecio.setText(tblProductos.getValueAt(row, 3).toString());

        }
    }//GEN-LAST:event_tblProductosMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tblProductos;
    private javax.swing.JSpinner txtcantidad;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
}
