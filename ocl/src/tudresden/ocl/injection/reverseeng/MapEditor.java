/*
 * MapEditor.java
 *
 * Created on 10. August 2000, 16:34
 */
 
package tudresden.ocl.injection.reverseeng;

/** 
 *
 * @author  sz9
 * @version 
 */
public class MapEditor extends javax.swing.JPanel {

  private MapDescriptor m_mdModel;
  
  private TypeComboModel m_tcmKeyTypeModel;
  private TypeComboModel m_tcmElementTypeModel;
  
  /** Creates new form MapEditor */
  public MapEditor (MapDescriptor mdModel) {
    super();
    
    m_mdModel = mdModel;

    String sKeyType = m_mdModel.getKeyType();
    String sElementType = m_mdModel.getElementType();
    
    initComponents ();
    
    m_jtaDocComment.setText (m_mdModel.getCleanedComment());
    
    m_jcbElementType.setSelectedItem (sElementType);
    m_jcbKeyType.setSelectedItem (sKeyType);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the FormEditor.
   */
  private void initComponents () {//GEN-BEGIN:initComponents
    m_jspDocComment = new javax.swing.JScrollPane ();
    m_jtaDocComment = new javax.swing.JTextArea ();
    m_jlKeyType = new javax.swing.JLabel ();
    m_jcbKeyType = new javax.swing.JComboBox ();
    m_jlElementType = new javax.swing.JLabel ();
    m_jcbElementType = new javax.swing.JComboBox ();
    setLayout (new java.awt.GridBagLayout ());
    java.awt.GridBagConstraints gridBagConstraints1;


      m_jtaDocComment.setToolTipText ("The JavaDoc comment associated with the collection.");
      m_jtaDocComment.setBackground (java.awt.Color.lightGray);
      m_jtaDocComment.setEditable (false);
  
      m_jspDocComment.setViewportView (m_jtaDocComment);
  

    gridBagConstraints1 = new java.awt.GridBagConstraints ();
    gridBagConstraints1.gridwidth = 0;
    gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints1.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints1.weightx = 2.0;
    gridBagConstraints1.weighty = 3.0;
    add (m_jspDocComment, gridBagConstraints1);

    m_jlKeyType.setText ("Key Type:");


    gridBagConstraints1 = new java.awt.GridBagConstraints ();
    gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints1.weightx = 1.0;
    add (m_jlKeyType, gridBagConstraints1);

    m_jcbKeyType.setToolTipText ("Enter type of collection elements.\nThe dropdown box contains suggestions and standard types.");
    m_tcmKeyTypeModel = new TypeComboModel() {
      public void setSelectedItem (Object oSelectedItem) {
        super.setSelectedItem (oSelectedItem);

        m_mdModel.setKeyType ((String) oSelectedItem);
      }
    };
    m_jcbKeyType.setModel (m_tcmKeyTypeModel);
    m_jcbKeyType.setEditable (true);


    gridBagConstraints1 = new java.awt.GridBagConstraints ();
    gridBagConstraints1.gridwidth = 0;
    gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints1.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints1.weightx = 1.0;
    add (m_jcbKeyType, gridBagConstraints1);

    m_jlElementType.setText ("Element Type:");


    gridBagConstraints1 = new java.awt.GridBagConstraints ();
    gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints1.anchor = java.awt.GridBagConstraints.WEST;
    gridBagConstraints1.weightx = 1.0;
    add (m_jlElementType, gridBagConstraints1);

    m_jcbElementType.setToolTipText ("Enter type of collection elements.\nThe dropdown box contains suggestions and standard types.");
    m_tcmElementTypeModel = new TypeComboModel() {
      public void setSelectedItem (Object oSelectedItem) {
        super.setSelectedItem (oSelectedItem);

        m_mdModel.setElementType ((String) oSelectedItem);
      }
    };
    m_jcbElementType.setModel (m_tcmElementTypeModel);
    m_jcbElementType.setEditable (true);


    gridBagConstraints1 = new java.awt.GridBagConstraints ();
    gridBagConstraints1.gridwidth = 0;
    gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gridBagConstraints1.anchor = java.awt.GridBagConstraints.EAST;
    gridBagConstraints1.weightx = 1.0;
    add (m_jcbElementType, gridBagConstraints1);

  }//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane m_jspDocComment;
  private javax.swing.JTextArea m_jtaDocComment;
  private javax.swing.JLabel m_jlKeyType;
  private javax.swing.JComboBox m_jcbKeyType;
  private javax.swing.JLabel m_jlElementType;
  private javax.swing.JComboBox m_jcbElementType;
  // End of variables declaration//GEN-END:variables

}