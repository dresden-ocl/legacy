/*
Copyright (C) 2000  Steffen Zschaler

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

/*
 * RevengGUI.java
 *
 * Created on 8. August 2000, 14:27 !! Created with Forte4J, so watch out for the .form file!
 */
 
package tudresden.ocl.injection.reverseeng;

import java.io.*;

import java.util.*;

import javax.swing.tree.*;

import javax.swing.*;

import tudresden.ocl.injection.*;

/** 
  * GUI for specifying element and key types for collections and maps extracted from Java Source Code.
  *
  * @author  sz9 (Steffen Zschaler)
  * @version 0.1
  */
public class RevengGUI extends javax.swing.JDialog {

  private DefaultTreeModel m_dtmFileModel;
  private RevengTreeNode m_rtnCurrent = null;
  private List m_lrtnUnsavedTreeNodes = new LinkedList();
  
  /** Creates new form RevengGUI */
  public RevengGUI(java.awt.Frame parent,boolean modal) {
    super (parent, modal);
    initComponents ();
    pack ();
    
    m_jspSplitter.setDividerLocation (0.5);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the FormEditor.
   */
  private void initComponents () {//GEN-BEGIN:initComponents
    m_jspSplitter = new javax.swing.JSplitPane ();
    m_jpLeft = new javax.swing.JPanel ();
    m_jtbTreeBar = new javax.swing.JToolBar ();
    m_jbUpOneLevel = new javax.swing.JButton ();
    m_jlSpace = new javax.swing.JLabel ();
    m_jbSave = new javax.swing.JButton ();
    m_jbSaveAll = new javax.swing.JButton ();
    m_jspTreeScroller = new javax.swing.JScrollPane ();
    m_jtFiles = new javax.swing.JTree ();
    m_dtmFileModel = new DefaultTreeModel (new DefaultMutableTreeNode(), true); // just use a fake root
    FolderTreeNode ftnRoot = new FolderTreeNode(m_dtmFileModel, new File ("."));
    m_dtmFileModel.setRoot (ftnRoot);
    ftnRoot.fill();
    m_jspProperties = new javax.swing.JScrollPane ();
    m_jlDefaultComponent = new javax.swing.JLabel ();
    getContentPane ().setLayout (new java.awt.GridBagLayout ());
    java.awt.GridBagConstraints gridBagConstraints1;
    setDefaultCloseOperation (javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    addWindowListener (new java.awt.event.WindowAdapter () {
      public void windowClosing (java.awt.event.WindowEvent evt) {
        closeDialog (evt);
      }
    }
    );


      m_jpLeft.setLayout (new java.awt.BorderLayout ());
  
        m_jtbTreeBar.setFloatable (false);
    
          m_jbUpOneLevel.setIcon (new javax.swing.ImageIcon (getClass ().getResource ("/tudresden/ocl/injection/reverseeng/resources/upOneLevel.gif")));
          m_jbUpOneLevel.setPreferredSize (new java.awt.Dimension(25, 25));
          m_jbUpOneLevel.setMaximumSize (new java.awt.Dimension(25, 25));
          m_jbUpOneLevel.setMinimumSize (new java.awt.Dimension(25, 25));
      
          m_jtbTreeBar.add (m_jbUpOneLevel);
      
          m_jlSpace.setText (" ");
      
          m_jtbTreeBar.add (m_jlSpace);
      
          m_jbSave.setIcon (new javax.swing.ImageIcon (getClass ().getResource ("/tudresden/ocl/injection/reverseeng/resources/save.gif")));
          m_jbSave.setPreferredSize (new java.awt.Dimension(25, 25));
          m_jbSave.setMaximumSize (new java.awt.Dimension(25, 25));
          m_jbSave.setMinimumSize (new java.awt.Dimension(25, 25));
          m_jbSave.setEnabled (false);
          m_jbSave.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              m_jbSaveActionPerformed (evt);
            }
          }
          );
      
          m_jtbTreeBar.add (m_jbSave);
      
          m_jbSaveAll.setIcon (new javax.swing.ImageIcon (getClass ().getResource ("/tudresden/ocl/injection/reverseeng/resources/saveAll.gif")));
          m_jbSaveAll.setPreferredSize (new java.awt.Dimension(25, 25));
          m_jbSaveAll.setMaximumSize (new java.awt.Dimension(25, 25));
          m_jbSaveAll.setMinimumSize (new java.awt.Dimension(25, 25));
          m_jbSaveAll.setEnabled (false);
          m_jbSaveAll.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              m_jbSaveAllActionPerformed (evt);
            }
          }
          );
      
          m_jtbTreeBar.add (m_jbSaveAll);
      
        m_jpLeft.add (m_jtbTreeBar, java.awt.BorderLayout.NORTH);
    
    
          m_jtFiles.setModel (m_dtmFileModel);
          m_jtFiles.setCellRenderer (new FileTreeNodeRenderer());
      
          //Enable tool tips.
          ToolTipManager.sharedInstance().registerComponent (m_jtFiles);
      
          m_jtFiles.addTreeExpansionListener (new javax.swing.event.TreeExpansionListener () {
            public void treeCollapsed (javax.swing.event.TreeExpansionEvent evt) {
              m_jtFilesTreeCollapsed (evt);
            }
            public void treeExpanded (javax.swing.event.TreeExpansionEvent evt) {
      
            }
          }
          );
          m_jtFiles.addTreeSelectionListener (new javax.swing.event.TreeSelectionListener () {
            public void valueChanged (javax.swing.event.TreeSelectionEvent evt) {
              m_jtFilesValueChanged (evt);
            }
          }
          );
          m_jtFiles.addTreeWillExpandListener (new javax.swing.event.TreeWillExpandListener () {
            public void treeWillCollapse (javax.swing.event.TreeExpansionEvent evt)
            throws javax.swing.tree.ExpandVetoException {
      
            }
            public void treeWillExpand (javax.swing.event.TreeExpansionEvent evt)
            throws javax.swing.tree.ExpandVetoException {
              m_jtFilesTreeWillExpand (evt);
            }
          }
          );
      
          m_jspTreeScroller.setViewportView (m_jtFiles);
      
        m_jpLeft.add (m_jspTreeScroller, java.awt.BorderLayout.CENTER);
    
      m_jspSplitter.setLeftComponent (m_jpLeft);
  
  
        m_jlDefaultComponent.setText ("No properties for current selection!");
    
        m_jspProperties.setViewportView (m_jlDefaultComponent);
    
      m_jspSplitter.setRightComponent (m_jspProperties);
  

    gridBagConstraints1 = new java.awt.GridBagConstraints ();
    gridBagConstraints1.gridx = 0;
    gridBagConstraints1.gridy = 0;
    gridBagConstraints1.gridwidth = 0;
    gridBagConstraints1.gridheight = 0;
    gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
    gridBagConstraints1.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints1.weightx = 1.0;
    gridBagConstraints1.weighty = 1.0;
    getContentPane ().add (m_jspSplitter, gridBagConstraints1);

  }//GEN-END:initComponents

  private void m_jbSaveAllActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbSaveAllActionPerformed
    synchronized (m_lrtnUnsavedTreeNodes) {
      for (Iterator i = m_lrtnUnsavedTreeNodes.iterator(); i.hasNext();) {
        if (save (((RevengTreeNode) i.next()))) {
          i.remove();
        }
      }
      
      m_jbSaveAll.setEnabled (m_lrtnUnsavedTreeNodes.size() > 0);      
    }
  }//GEN-LAST:event_m_jbSaveAllActionPerformed

  private void m_jbSaveActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbSaveActionPerformed
    if (m_rtnCurrent != null) {
      save (m_rtnCurrent);
    }
  }//GEN-LAST:event_m_jbSaveActionPerformed

  private boolean save (RevengTreeNode rtn) {
    try {
      rtn.save();
      return true;
    }
    catch (IOException ioe) {
      JOptionPane.showMessageDialog (this, 
                                       "An error occurred when attempting to save " + rtn + ": " + ioe.getLocalizedMessage(), 
                                       "Error", 
                                       JOptionPane.ERROR_MESSAGE);
      return false;
    }
  }
  
  private void m_jtFilesValueChanged (javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_m_jtFilesValueChanged
    if (evt.isAddedPath()) {
      if (m_rtnCurrent != null) {
        m_rtnCurrent.stopDirtyChangeNotification();
      }
      
      m_rtnCurrent = (RevengTreeNode) evt.getPath().getLastPathComponent();

      m_jspProperties.setViewportView (m_rtnCurrent.getRightComponent());

      /*this.getRootPane().revalidate();
      this.getRootPane().repaint();*/
      pack(); // Not especially elegant! Does anybody know a better way of getting that JScrollPane to redraw?
      
      m_jbSave.setEnabled (m_rtnCurrent.isDirty());
      
      if (m_rtnCurrent != null) {
        m_rtnCurrent.startDirtyChangeNotification (this);
      }      
    }
    else {
      m_jbSave.setEnabled (false);
      m_jbSaveAll.setEnabled(false);
    }
  }//GEN-LAST:event_m_jtFilesValueChanged

  private void m_jtFilesTreeCollapsed (javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_m_jtFilesTreeCollapsed
    RevengTreeNode rtn = (RevengTreeNode) evt.getPath().getLastPathComponent();
    
    rtn.collapsed();
  }//GEN-LAST:event_m_jtFilesTreeCollapsed

  private void m_jtFilesTreeWillExpand (javax.swing.event.TreeExpansionEvent evt) throws ExpandVetoException {//GEN-FIRST:event_m_jtFilesTreeWillExpand
    RevengTreeNode rtn = (RevengTreeNode) evt.getPath ().getLastPathComponent ();

    rtn.fill();
    if (! rtn.getAllowsChildren ()) {
      throw new ExpandVetoException (evt);
    }
  }//GEN-LAST:event_m_jtFilesTreeWillExpand

  /** Closes the dialog */
  private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
    setVisible (false);
    dispose ();
    System.exit (0);
  }//GEN-LAST:event_closeDialog
  

  static class FileTreeNodeRenderer extends DefaultTreeCellRenderer {
    public FileTreeNodeRenderer () {
      super();
    }
    
    public java.awt.Component getTreeCellRendererComponent (javax.swing.JTree tree,
                                                                  Object value,
                                                                  boolean sel,
                                                                  boolean expanded,
                                                                  boolean leaf,
                                                                  int row,
                                                                  boolean hasFocus) {
      super.getTreeCellRendererComponent (tree, value, sel, expanded, leaf, row, hasFocus);
      
      RevengTreeNode rtn = (RevengTreeNode) value;
      
      setToolTipText (rtn.getToolTip());
      
      setIcon (rtn.getIcon (expanded));
      
      return this;
    }
  }
  
  /**
    * Invoked whenever the current tree node's dirty flag changes.
    */
  public void onDirtyChanged (RevengTreeNode rtn, boolean fNewValue) {
    if (fNewValue) {
      m_jbSave.setEnabled (true);
      
      synchronized (m_lrtnUnsavedTreeNodes) {
        m_jbSaveAll.setEnabled (true);
        m_lrtnUnsavedTreeNodes.add (rtn);
      }
    }
    else {
      m_jbSave.setEnabled (false);

      synchronized (m_lrtnUnsavedTreeNodes) {
        m_lrtnUnsavedTreeNodes.remove (rtn);
        m_jbSaveAll.setEnabled (m_lrtnUnsavedTreeNodes.size() > 0);
      }
    }
  }
  
  /**
    * @param args the command line arguments
    */
  public static void main (String args[]) {
    new RevengGUI (new javax.swing.JFrame (), true).show ();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JSplitPane m_jspSplitter;
  private javax.swing.JPanel m_jpLeft;
  private javax.swing.JToolBar m_jtbTreeBar;
  private javax.swing.JButton m_jbUpOneLevel;
  private javax.swing.JLabel m_jlSpace;
  private javax.swing.JButton m_jbSave;
  private javax.swing.JButton m_jbSaveAll;
  private javax.swing.JScrollPane m_jspTreeScroller;
  private javax.swing.JTree m_jtFiles;
  private javax.swing.JScrollPane m_jspProperties;
  private javax.swing.JLabel m_jlDefaultComponent;
  // End of variables declaration//GEN-END:variables

}
