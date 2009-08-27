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
 
package tudresden.ocl20.injection.reverseeng;

import java.io.*;
import java.util.*;

import javax.swing.*;
import javax.swing.tree.*;

import tudresden.ocl20.injection.*;
import tudresden.ocl20.injection.reverseeng.propertypages.*;

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
  private boolean m_fInSaveAll = false;
  
  private List m_lttiTypeTraceLogs = new LinkedList();
    
  /** Creates new form RevengGUI */
  public RevengGUI(java.awt.Frame parent,boolean modal) {
    super (parent, modal);
    initComponents ();
    
    pack ();
    
    m_jspSplitter.setDividerLocation (0.5);
    
    m_jtFiles.setSelectionRow (0);
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
    m_jbExploreFromHere = new javax.swing.JButton ();
    m_jlSpace = new javax.swing.JLabel ();
    m_jbSave = new javax.swing.JButton ();
    m_jbSaveAll = new javax.swing.JButton ();
    m_jlSpace2 = new javax.swing.JLabel ();
    m_jbTypeTrace = new javax.swing.JButton ();
    m_jspTreeScroller = new javax.swing.JScrollPane ();
    m_jtFiles = new javax.swing.JTree ();
    m_dtmFileModel = new DefaultTreeModel (new DefaultMutableTreeNode(), true); // just use a fake root

    File fRoot = new File (".").getAbsoluteFile();
    try {
      fRoot = fRoot.getCanonicalFile();
    }
    catch (IOException ioex) {
      System.err.println ("Couldn't retrieve canonical file name for root directory.");
      ioex.printStackTrace();
    }

    FolderTreeNode ftnRoot = new FolderTreeNode(m_dtmFileModel, fRoot);
    m_dtmFileModel.setRoot (ftnRoot);
    ftnRoot.fill();
    m_ppcProperties = new tudresden.ocl20.injection.reverseeng.propertypages.PropertyPageContainer ();
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
          m_jbUpOneLevel.setToolTipText ("Up One Level");
          m_jbUpOneLevel.setPreferredSize (new java.awt.Dimension(25, 25));
          m_jbUpOneLevel.setMaximumSize (new java.awt.Dimension(25, 25));
          m_jbUpOneLevel.setMinimumSize (new java.awt.Dimension(25, 25));
          m_jbUpOneLevel.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              onUpOneLevel (evt);
            }
          }
          );
      
          m_jtbTreeBar.add (m_jbUpOneLevel);
      
          m_jbExploreFromHere.setIcon (new javax.swing.ImageIcon (getClass ().getResource ("/tudresden/ocl/injection/reverseeng/resources/exploreFromHere.gif")));
          m_jbExploreFromHere.setToolTipText ("Explore From Here");
          m_jbExploreFromHere.setPreferredSize (new java.awt.Dimension(25, 25));
          m_jbExploreFromHere.setMaximumSize (new java.awt.Dimension(25, 25));
          m_jbExploreFromHere.setMinimumSize (new java.awt.Dimension(25, 25));
          m_jbExploreFromHere.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              onExploreFromHere (evt);
            }
          }
          );
      
          m_jtbTreeBar.add (m_jbExploreFromHere);
      
          m_jlSpace.setText (" ");
      
          m_jtbTreeBar.add (m_jlSpace);
      
          m_jbSave.setIcon (new javax.swing.ImageIcon (getClass ().getResource ("/tudresden/ocl/injection/reverseeng/resources/save.gif")));
          m_jbSave.setToolTipText ("Save");
          m_jbSave.setPreferredSize (new java.awt.Dimension(25, 25));
          m_jbSave.setMaximumSize (new java.awt.Dimension(25, 25));
          m_jbSave.setMinimumSize (new java.awt.Dimension(25, 25));
          m_jbSave.setEnabled (false);
          m_jbSave.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              onSaveButton (evt);
            }
          }
          );
      
          m_jtbTreeBar.add (m_jbSave);
      
          m_jbSaveAll.setIcon (new javax.swing.ImageIcon (getClass ().getResource ("/tudresden/ocl/injection/reverseeng/resources/saveAll.gif")));
          m_jbSaveAll.setToolTipText ("Save All");
          m_jbSaveAll.setPreferredSize (new java.awt.Dimension(25, 25));
          m_jbSaveAll.setMaximumSize (new java.awt.Dimension(25, 25));
          m_jbSaveAll.setMinimumSize (new java.awt.Dimension(25, 25));
          m_jbSaveAll.setEnabled (false);
          m_jbSaveAll.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              onSaveAllButton (evt);
            }
          }
          );
      
          m_jtbTreeBar.add (m_jbSaveAll);
      
          m_jlSpace2.setText (" ");
      
          m_jtbTreeBar.add (m_jlSpace2);
      
          m_jbTypeTrace.setIcon (new javax.swing.ImageIcon (getClass ().getResource ("/tudresden/ocl/injection/reverseeng/resources/ocltypetrace.gif")));
          m_jbTypeTrace.setToolTipText ("Specify Runtime Type Trace Log Files");
          m_jbTypeTrace.setPreferredSize (new java.awt.Dimension(25, 25));
          m_jbTypeTrace.setMaximumSize (new java.awt.Dimension(25, 25));
          m_jbTypeTrace.setMinimumSize (new java.awt.Dimension(25, 25));
          m_jbTypeTrace.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              onSpecifyTypeTraceLogs (evt);
            }
          }
          );
      
          m_jtbTreeBar.add (m_jbTypeTrace);
      
        m_jpLeft.add (m_jtbTreeBar, java.awt.BorderLayout.NORTH);
    
    
          m_jtFiles.setModel (m_dtmFileModel);
          m_jtFiles.setCellRenderer (new FileTreeNodeRenderer());
      
          // Enable tool tips.
          ToolTipManager.sharedInstance().registerComponent (m_jtFiles);
      
          // Specify lines to be drawn between nodes.
          m_jtFiles.putClientProperty("JTree.lineStyle", "Angled");
      
          m_jtFiles.addTreeExpansionListener (new javax.swing.event.TreeExpansionListener () {
            public void treeCollapsed (javax.swing.event.TreeExpansionEvent evt) {
              onExplorerNodeCollapsed (evt);
            }
            public void treeExpanded (javax.swing.event.TreeExpansionEvent evt) {
      
            }
          }
          );
          m_jtFiles.addTreeSelectionListener (new javax.swing.event.TreeSelectionListener () {
            public void valueChanged (javax.swing.event.TreeSelectionEvent evt) {
              onExplorerSelectionChanged (evt);
            }
          }
          );
          m_jtFiles.addTreeWillExpandListener (new javax.swing.event.TreeWillExpandListener () {
            public void treeWillCollapse (javax.swing.event.TreeExpansionEvent evt)
            throws javax.swing.tree.ExpandVetoException {
      
            }
            public void treeWillExpand (javax.swing.event.TreeExpansionEvent evt)
            throws javax.swing.tree.ExpandVetoException {
              onExplorerNodeWillExpand (evt);
            }
          }
          );
      
          m_jspTreeScroller.setViewportView (m_jtFiles);
      
        m_jpLeft.add (m_jspTreeScroller, java.awt.BorderLayout.CENTER);
    
      m_jspSplitter.setLeftComponent (m_jpLeft);
  
      java.awt.GridBagConstraints gridBagConstraints2;
  
      m_jspSplitter.setRightComponent (m_ppcProperties);
  

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

  private void onSpecifyTypeTraceLogs (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSpecifyTypeTraceLogs
    new SpecifyTypeTraceSourceDialog (this, true, m_lttiTypeTraceLogs).show();
    
    // Update PropertyPages
    m_ppcProperties.replacePropertyPages (m_rtnCurrent.getPropertyPages());
  }//GEN-LAST:event_onSpecifyTypeTraceLogs

  private void onUpOneLevel (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onUpOneLevel
    RevengTreeNode rtnNewRoot = m_rtnCurrent.createLogicalParent();
    
    if (rtnNewRoot != null) {
      m_dtmFileModel.setRoot (rtnNewRoot);
      m_jtFiles.setSelectionRow (0);
    }
  }//GEN-LAST:event_onUpOneLevel

  private void onExploreFromHere (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onExploreFromHere
    RevengTreeNode rtnParent = (RevengTreeNode) m_rtnCurrent.getParent();
    
    rtnParent.remove (m_rtnCurrent);
    
    m_dtmFileModel.setRoot (m_rtnCurrent);
    
    m_jtFiles.setSelectionRow (0);
  }//GEN-LAST:event_onExploreFromHere

  private void onSaveAllButton (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSaveAllButton
    try {
      m_fInSaveAll = true;
      
      synchronized (m_lrtnUnsavedTreeNodes) {
        for (Iterator i = m_lrtnUnsavedTreeNodes.iterator(); i.hasNext();) {
          if (save (((RevengTreeNode) i.next()))) {
            i.remove();
          }
        }

        m_jbSaveAll.setEnabled (m_lrtnUnsavedTreeNodes.size() > 0);      
      }
    }
    finally {
      m_fInSaveAll = false;
    }
  }//GEN-LAST:event_onSaveAllButton

  private void onSaveButton (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onSaveButton
    if (m_rtnCurrent != null) {
      save (m_rtnCurrent);
    }
  }//GEN-LAST:event_onSaveButton

  private boolean save (RevengTreeNode rtn) {
    try {
      rtn.save();
      return true;
    }
    catch (IOException ioe) {
      JOptionPane.showMessageDialog (this, 
                                       "An error occurred when attempting to save " + rtn + ":\n" + ioe.getLocalizedMessage(), 
                                       "Error", 
                                       JOptionPane.ERROR_MESSAGE);
      return false;
    }
  }
  
  private void onExplorerSelectionChanged (javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_onExplorerSelectionChanged
    if (evt.isAddedPath()) {
      // Stop notifications of dirty changes from previous selection
      if (m_rtnCurrent != null) {
        m_rtnCurrent.stopDirtyChangeNotification();
      }
      
      // Set property pages associated with new selection
      m_rtnCurrent = (RevengTreeNode) evt.getPath().getLastPathComponent();

      m_ppcProperties.replacePropertyPages (m_rtnCurrent.getPropertyPages());

      // En-/Disable save button based on dirty state of new selection
      m_jbSave.setEnabled (m_rtnCurrent.isDirty());
      
      // Start receiving notifications of changes to current selection's dirty state
      if (m_rtnCurrent != null) {
        m_rtnCurrent.startDirtyChangeNotification (this);
      }
      
      // En-/Disable explore from here button
      m_jbExploreFromHere.setEnabled (m_rtnCurrent.canRootExplorer());
      
      // En-/Disable UpOneLevel button
      m_jbUpOneLevel.setEnabled (m_rtnCurrent.getParent() == null);
    }
    else {
      m_jbSave.setEnabled (false);
      m_jbSaveAll.setEnabled(false);
    }
  }//GEN-LAST:event_onExplorerSelectionChanged

  private void onExplorerNodeCollapsed (javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_onExplorerNodeCollapsed
    RevengTreeNode rtn = (RevengTreeNode) evt.getPath().getLastPathComponent();
    
    rtn.collapsed();
  }//GEN-LAST:event_onExplorerNodeCollapsed

  private void onExplorerNodeWillExpand (javax.swing.event.TreeExpansionEvent evt) throws ExpandVetoException {//GEN-FIRST:event_onExplorerNodeWillExpand
    RevengTreeNode rtn = (RevengTreeNode) evt.getPath ().getLastPathComponent ();

    rtn.fill();
    if (! rtn.getAllowsChildren ()) {
      throw new ExpandVetoException (evt);
    }
  }//GEN-LAST:event_onExplorerNodeWillExpand

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

      if (! m_fInSaveAll) {
        synchronized (m_lrtnUnsavedTreeNodes) {
          m_lrtnUnsavedTreeNodes.remove (rtn);
          m_jbSaveAll.setEnabled (m_lrtnUnsavedTreeNodes.size() > 0);
        }
      }
    }
  }
  
  /**
    * Return all element types of the specified feature.
    */
  public Set getAllElementTypes (AbstractDescriptor ad) {
    Set sReturn = new HashSet();
    
    String sFeatureID = ad.getJavaDocName();
    
    for (Iterator i = m_lttiTypeTraceLogs.iterator(); i.hasNext();) {
      TypeTraceInfo ttiCurrent = (TypeTraceInfo ) i.next();
      
      List lCurrentSet = ttiCurrent.getAllElementTypes (sFeatureID);
      
      if (lCurrentSet != null) {
        sReturn.addAll (lCurrentSet);
      }
    }
    
    return sReturn;
  }
  
  /**
    * Return minimal element types of the specified feature.
    */
  public Set getElementTypeMinima (AbstractDescriptor ad) {
    Set sReturn = new HashSet();
    
    String sFeatureID = ad.getJavaDocName();
    
    for (Iterator i = m_lttiTypeTraceLogs.iterator(); i.hasNext();) {
      TypeTraceInfo ttiCurrent = (TypeTraceInfo ) i.next();
      
      List lCurrentSet = ttiCurrent.getElementTypeMinima (sFeatureID);
      
      if (lCurrentSet != null) {
        sReturn.addAll (lCurrentSet);
      }
    }
    
    return sReturn;
  }
  
  /**
    * Return all key types of the specified feature.
    */
  public Set getAllKeyTypes (AbstractDescriptor ad) {
    Set sReturn = new HashSet();
    
    String sFeatureID = ad.getJavaDocName();
    
    for (Iterator i = m_lttiTypeTraceLogs.iterator(); i.hasNext();) {
      TypeTraceInfo ttiCurrent = (TypeTraceInfo ) i.next();
      
      List lCurrentSet = ttiCurrent.getAllKeyTypes (sFeatureID);
      
      if (lCurrentSet != null) {
        sReturn.addAll (lCurrentSet);
      }
    }
    
    return sReturn;
  }
  
  /**
    * Return minimal key types of the specified feature.
    */
  public Set getKeyTypeMinima (AbstractDescriptor ad) {
    Set sReturn = new HashSet();
    
    String sFeatureID = ad.getJavaDocName();
    
    for (Iterator i = m_lttiTypeTraceLogs.iterator(); i.hasNext();) {
      TypeTraceInfo ttiCurrent = (TypeTraceInfo ) i.next();
      
      List lCurrentSet = ttiCurrent.getKeyTypeMinima (sFeatureID);
      
      if (lCurrentSet != null) {
        sReturn.addAll (lCurrentSet);
      }
    }
    
    return sReturn;
  }
  
  /**
    * @param args the command line arguments
    */
  public static void main (String args[]) {
    (s_rguiTheApp = new RevengGUI (new javax.swing.JFrame(), true)).show ();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JSplitPane m_jspSplitter;
  private javax.swing.JPanel m_jpLeft;
  private javax.swing.JToolBar m_jtbTreeBar;
  private javax.swing.JButton m_jbUpOneLevel;
  private javax.swing.JButton m_jbExploreFromHere;
  private javax.swing.JLabel m_jlSpace;
  private javax.swing.JButton m_jbSave;
  private javax.swing.JButton m_jbSaveAll;
  private javax.swing.JLabel m_jlSpace2;
  private javax.swing.JButton m_jbTypeTrace;
  private javax.swing.JScrollPane m_jspTreeScroller;
  private javax.swing.JTree m_jtFiles;
  private tudresden.ocl20.injection.reverseeng.propertypages.PropertyPageContainer m_ppcProperties;
  // End of variables declaration//GEN-END:variables

  
  // STATIC PART
  private static RevengGUI s_rguiTheApp;
  
  public static RevengGUI getTheApp() {
    return s_rguiTheApp;
  }
}