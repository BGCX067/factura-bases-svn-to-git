/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import MatrizDinamica.Matriz;
import java.util.ArrayList;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import negocio.Ciudad;
import negocio.Cliente;
import negocio.ClienteLista;
import negocio.Direccion;
import negocio.Sector;

/**
 *
 * @author pablo
 */
public class VentanaCliente extends javax.swing.JInternalFrame {
    Cliente cliente = new Cliente();
    ClienteLista clienteLista = new ClienteLista();
    Ciudad ciudad=new Ciudad();
    Sector sector=new Sector();
    Direccion direccion=new Direccion();
    ArrayList ciudades;
    ArrayList sectores;
    Object[] namecolums = {"Cedula", "Nombre", "Apellido", "Telefono"};
    DefaultTableModel temp = new DefaultTableModel(namecolums, 0);
    /**
     * Creates new form VentanaCliente
     */
    public VentanaCliente() {
        initComponents();
        Actualizar();
        jTable1.setModel(temp);
        //llenar CboCiudad
        ciudades=new ArrayList<>();
        sectores=new ArrayList<>();
        ciudades=ciudad.listar();
        llenarCboCiudad();
        updateCbo();
    }
    public void nuevo() {
        textCedula.setText("");
        textNombre.setText("");
        textApellido.setText("");
        textTelefono.setText("");
        txtCalle.setText("");
        txtNum.setText("");
        Actualizar();
    }
    
    private void updateCbo(){
        //limpiar cbo
        cboSectores.removeAllItems();
        //Llenar CboSector
        Ciudad aux=ciudad.buscar((String) cboCiudades.getSelectedItem());
        sectores=sector.listar(aux.getIdCiudad());
        llenarCboSectores();
    }
    
    private void llenarCboCiudad(){
        for (Object c : ciudades) {
            cboCiudades.addItem(((Ciudad) c).getNombre());
        }
    }
    
    private void llenarCboSectores(){
        for (Object c : sectores) {
            cboSectores.addItem(((Sector) c).getNombre());
        }
    }
    public void Grabar(){
        SpinnerDateModel model  = new SpinnerDateModel();
        cliente.setCedula(textCedula.getText());
        cliente.setNombre(textNombre.getText());
        cliente.setApellido(textApellido.getText());
        cliente.setTelefono(textTelefono.getText());
        
        direccion.setCalle(txtCalle.getText());
        direccion.setNumeroC(Integer.parseInt(txtNum.getText()));
        
        direccion.setIdSector(sector.getIdSector());
        direccion.setIdCiudad(ciudad.getIdCiudad());
        
        
        ciudad = ciudad.buscar((String)cboCiudades.getSelectedItem());
        cliente.setIdCiudad(ciudad.getIdCiudad());
        sector.buscar((String) cboSectores.getSelectedItem(),ciudad.getIdCiudad());
        cliente.setIdSector(sector.getIdSector());
        
        System.out.println(direccion.getCalle());
        System.out.println(direccion.getNumeroC());
        System.out.println(direccion.getIdSector());
        System.out.println(direccion.getIdCiudad());
        
        direccion.grabar();
        
        if(cliente.buscar()==1)
            System.out.println("Ya existe el usuario");
        else
            cliente.grabar();
        Actualizar();
    }
   int row = -1;
   public int Buscar() {
        cliente.setCedula((String)jTable1.getValueAt(row, 0).toString());
        return cliente.buscar();
    }
    public void Modificar(){
        if(Buscar() ==1){
            System.out.println("No esta en la base de datos");
        }else{
            System.out.println(textCedula.getText());
            cliente.setCedula(textCedula.getText());
            cliente.setNombre(textNombre.getText());
            cliente.setApellido(textApellido.getText());
            cliente.setTelefono(textTelefono.getText());
            
            ciudad = ciudad.buscar((String)cboCiudades.getSelectedItem());
            cliente.setIdCiudad(ciudad.getIdCiudad());
            sector.buscar((String) cboSectores.getSelectedItem(),ciudad.getIdCiudad());
            cliente.setIdSector(sector.getIdSector());
            
            cliente.modificar();
        }
    }
    
    public void Eliminar(){
       if (Buscar() ==1) {
           System.out.println("No se puede eliminar");
        } else {
           cliente.eliminar();
        }
    }
    public void Actualizar(){
        Matriz m = new Matriz(4);
        clienteLista.listar();
        ArrayList clientes = new ArrayList();
        clientes = clienteLista.getClientes();
        
        for (int i = 0; i < clientes.size(); i++){
            Cliente auxCliente = new Cliente();
            auxCliente = (Cliente) clientes.get(i);
            Object nuevo[] = {auxCliente.getCedula(), auxCliente.getNombre(), auxCliente.getApellido(), auxCliente.getTelefono()};
            m.agregar(nuevo);
            System.out.println(nuevo);
        }
        temp.setDataVector(m.darTablaEntera(), namecolums);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        cboCiudades = new javax.swing.JComboBox();
        cboSectores = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textCedula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textTelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setTitle("Ingreso de Clientes");
        setPreferredSize(new java.awt.Dimension(610, 370));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jButton1.setText("Limpiar");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion:", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel5.setText("Ciudad:");

        jLabel6.setText("Sector:");

        jLabel7.setText("Numero:");

        txtCalle.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel8.setText("Calle:");

        txtNum.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        cboCiudades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboCiudadesItemStateChanged(evt);
            }
        });
        cboCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCiudadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCalle)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCiudades, 0, 155, Short.MAX_VALUE)
                    .addComponent(cboSectores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(cboCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cboSectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Informacion", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Cedula:");

        textCedula.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel2.setText("Nombre:");

        textNombre.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel3.setText("Apellido:");

        textApellido.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel4.setText("Telefono:");

        textTelefono.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

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
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(textCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addGap(6, 6, 6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCiudadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCiudadesActionPerformed

    private void cboCiudadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboCiudadesItemStateChanged
        // TODO add your handling code here:
        if(evt.getSource()==cboCiudades)
            updateCbo();
    }//GEN-LAST:event_cboCiudadesItemStateChanged

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        System.out.println("hola");
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        row = jTable1.getSelectedRow();
        if(row !=-1){
            textCedula.setText(jTable1.getValueAt(row, 0).toString());
            textNombre.setText(jTable1.getValueAt(row, 1).toString());
            textApellido.setText(jTable1.getValueAt(row, 2).toString());
            textTelefono.setText(jTable1.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboCiudades;
    private javax.swing.JComboBox cboSectores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCedula;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables

    void modificar() {
        throw new UnsupportedOperationException("Not yet implemented");
    }



}
