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
    m_jspTreeScroller = new javax.swing.JScrollPane ();
    m_jtFiles = new javax.swing.JTree ();
    m_dtmFileModel = new DefaultTreeModel (new DefaultMutableTreeNode(), true); // just use a fake root
    FileTreeNode ftnRoot = new FileTreeNode(m_dtmFileModel, new File ("."));
    m_dtmFileModel.setRoot (ftnRoot);
    ftnRoot.fill (m_dtmFileModel);
    m_jspProperties = new javax.swing.JScrollPane ();
    m_jtPropertiesTable = new javax.swing.JTable ();
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
    
          m_jbUpOneLevel.setIcon (new javax.swing.ImageIcon (getClass ().getResource ("/tudresden/ocl/injection/reverseeng/upOneLevel.gif")));
          m_jbUpOneLevel.setPreferredSize (new java.awt.Dimension(25, 25));
          m_jbUpOneLevel.setMaximumSize (new java.awt.Dimension(25, 25));
          m_jbUpOneLevel.setMinimumSize (new java.awt.Dimension(25, 25));
      
          m_jtbTreeBar.add (m_jbUpOneLevel);
      
        m_jpLeft.add (m_jtbTreeBar, java.awt.BorderLayout.NORTH);
    
    
          m_jtFiles.setModel (m_dtmFileModel);
          m_jtFiles.setCellRenderer (new FileTreeNodeRenderer());
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
  
  
        m_jtPropertiesTable.setModel (new javax.swing.table.DefaultTableModel (
        new Object [][] {
        {"Key type", null},
        {"Element type", null}
        },
        new String [] {
          "", ""
        }
        ) {
          boolean[] canEdit = new boolean [] {
            false, true
          };
    
          public boolean isCellEditable (int rowIndex, int columnIndex) {
            return canEdit [columnIndex];
          }
        });
    
        m_jspProperties.setViewportView (m_jtPropertiesTable);
    
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

  private void m_jtFilesValueChanged (javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_m_jtFilesValueChanged
    if (evt.isAddedPath()) {
      RevengTreeNode rtn = (RevengTreeNode) evt.getPath().getLastPathComponent();

      m_jspProperties.setViewportView (rtn.getRightComponent());

      pack(); // Not especially elegant! Does anybody know a better way of getting that JScrollPane to redraw?
    }
  }//GEN-LAST:event_m_jtFilesValueChanged

  private void m_jtFilesTreeCollapsed (javax.swing.event.TreeExpansionEvent evt) {//GEN-FIRST:event_m_jtFilesTreeCollapsed
    RevengTreeNode rtn = (RevengTreeNode) evt.getPath().getLastPathComponent();
    
    rtn.collapsed (m_dtmFileModel);
  }//GEN-LAST:event_m_jtFilesTreeCollapsed

  private void m_jtFilesTreeWillExpand (javax.swing.event.TreeExpansionEvent evt) throws ExpandVetoException {//GEN-FIRST:event_m_jtFilesTreeWillExpand
    RevengTreeNode rtn = (RevengTreeNode) evt.getPath ().getLastPathComponent ();

    rtn.fill (m_dtmFileModel);
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
  
  /**
    * Abstract super class for each node in the treeview.
    */
  abstract static class RevengTreeNode extends DefaultMutableTreeNode {
    
    static JLabel s_jlNoProperties = new JLabel ("No properties for current selection!");
    
    public RevengTreeNode() {
      super();
    }
    
    public abstract Icon getIcon (boolean fExpanded);
    public abstract void fill (DefaultTreeModel dtmModel);
        
    public void collapsed (DefaultTreeModel dtmModel) {
      if (! isLeaf()) {
        removeAllChildren();
        setAllowsChildren (true);
        
        dtmModel.nodeStructureChanged (this);
      }
    }
    
    public JComponent getRightComponent () {
      return s_jlNoProperties;
    }
  }
 
  static class ErrorTreeNode extends RevengTreeNode {

    static Icon s_iIcon;
    static {
      s_iIcon = new javax.swing.ImageIcon (ErrorTreeNode.class.getResource ("error.gif"));
    }
    
    public ErrorTreeNode (String sMessage) {
      super();
      
      setUserObject (sMessage);
      setAllowsChildren (false);
    }
    
    public Icon getIcon (boolean fExpanded) {
      return s_iIcon;
    }
    
    public void fill (DefaultTreeModel dtmModel) { }
  }
  
  static abstract class HolderTreeNode extends RevengTreeNode {
    
    private String m_sCaption;
    
    public HolderTreeNode (String sCaption, List lData) {
      super();
      
      setUserObject (lData);
      setAllowsChildren (lData.size() > 0);
      
      m_sCaption = sCaption;
    }
    
    public Icon getIcon (boolean fExpanded) {
      if (fExpanded) {
        return javax.swing.UIManager.getIcon ("Tree.closedIcon");
      }
      else {
        return javax.swing.UIManager.getIcon ("Tree.openIcon");
      }
    }
    
    public String toString() {
      return m_sCaption;
    }
  }
  
  static class MapHolderNode extends HolderTreeNode {
    public MapHolderNode (List lmdMaps) {
      super ("Maps", lmdMaps);
    }
        
    public void fill (DefaultTreeModel dtmModel) {
      List lmdMaps = (List) getUserObject ();
      
      if (lmdMaps.size() == 0) {
        setAllowsChildren (false);
        
        dtmModel.nodeChanged (this);
      }
      else {
        for (Iterator i = lmdMaps.iterator(); i.hasNext();) {
          add (new MapTreeNode ((MapDescriptor) i.next ()));
        }
        
        dtmModel.nodeStructureChanged (this);
      }
    }
  }
  
  static class MapTreeNode extends RevengTreeNode {
    public MapTreeNode (MapDescriptor md) {
      super();
      
      setUserObject (md);
      setAllowsChildren(false);
    }
    
    public Icon getIcon (boolean fExpanded) {
      return javax.swing.UIManager.getIcon ("Tree.leafIcon");
    }
    
    public void fill (DefaultTreeModel dtm) {
      setAllowsChildren (false);
      
      dtm.nodeChanged (this);
    }

    public JComponent getRightComponent() {
      return new MapEditor (getDescriptor());
    }
    
    public MapDescriptor getDescriptor() {
      return (MapDescriptor) getUserObject();
    }
    
    public String toString () {      
      MapDescriptor md = getDescriptor();
      
      return "Map<" + ((md.getKeyType() != null)?(md.getKeyType()):("Unknown Type"))
                     + " -> "
                     + ((md.getElementType() != null)?(md.getElementType()):("Unknown Type"))
                     + "> "
                     + md.getName();
    }
  }
  
  static class CollectionHolderNode extends HolderTreeNode {
    public CollectionHolderNode (List lcdCollections) {
      super ("Collections", lcdCollections);
    }
        
    public void fill (DefaultTreeModel dtmModel) {
      List lcdCollections = (List) getUserObject ();
      
      if (lcdCollections.size() == 0) {
        setAllowsChildren (false);
        
        dtmModel.nodeChanged (this);
      }
      else {
        for (Iterator i = lcdCollections.iterator(); i.hasNext();) {
          add (new CollectionTreeNode ((CollectionDescriptor) i.next ()));
        }
        
        dtmModel.nodeStructureChanged (this);
      }
    }
  }
  
  static class CollectionTreeNode extends RevengTreeNode {
    public CollectionTreeNode (CollectionDescriptor cd) {
      super();
      
      setUserObject (cd);
      setAllowsChildren(false);
    }
    
    public Icon getIcon (boolean fExpanded) {
      return javax.swing.UIManager.getIcon ("Tree.leafIcon");
    }
    
    public void fill (DefaultTreeModel dtm) {
      setAllowsChildren (false);
      
      dtm.nodeChanged (this);
    }
    
    public CollectionDescriptor getDescriptor() {
      return (CollectionDescriptor) getUserObject();
    }

    public JComponent getRightComponent() {
      return new CollectionEditor (getDescriptor());
    }
    
    public String toString () {      
      CollectionDescriptor cd = getDescriptor();
      
      return "Collection<" + ((cd.getElementType() != null)?(cd.getElementType()):("Unknown Type")) + "> " + cd.getName();
    }
  }
  
  static class FileTreeNode extends RevengTreeNode {
    
    static ThreadPool s_tpIconComputers = new ThreadPool ("Icon Calculator Pool");
    
    static Icon s_iNormalFile = new javax.swing.ImageIcon (FileTreeNode.class.getResource ("normalFile.gif"));
    static Icon s_iFileError = new javax.swing.ImageIcon (FileTreeNode.class.getResource ("fileError.gif"));
    static Icon s_iFileWithCollections = new javax.swing.ImageIcon (FileTreeNode.class.getResource ("fileWithCollections.gif"));
    static Icon s_iFileWithCollectionsInComplete = new javax.swing.ImageIcon (FileTreeNode.class.getResource ("fileWithCollectionsInComplete.gif"));
    static Icon s_iFileWithCollectionsAndMaps = new javax.swing.ImageIcon (FileTreeNode.class.getResource ("fileWithCollectionsAndMaps.gif"));
    static Icon s_iFileWithCollectionsAndMapsInComplete = new javax.swing.ImageIcon (FileTreeNode.class.getResource ("fileWithCollectionsAndMapsInComplete.gif"));
    static Icon s_iFileWithMaps = new javax.swing.ImageIcon (FileTreeNode.class.getResource ("fileWithMaps.gif"));
    static Icon s_iFileWithMapsInComplete = new javax.swing.ImageIcon (FileTreeNode.class.getResource ("fileWithMapsInComplete.gif"));
    
    private boolean m_fUseDefaultIcon = true;
    private boolean m_fParsed = false;
    private boolean m_fHadError = false;
    private String m_sErrorMessage = null;
    private AnalysisConsumer m_acAnalysisResults = null;
    
    private DefaultTreeModel m_dtm;
    
    public FileTreeNode (DefaultTreeModel dtm) {
      super();
      
      m_dtm = dtm;
    }
    
    public FileTreeNode (DefaultTreeModel dtm, File f) {
      this(dtm);
      
      setFile (f);
    }
    
    public void setFile (File f) {
      setUserObject (f);
      
      m_fUseDefaultIcon = true;
      m_fParsed = false;
      m_fHadError = false;
      m_sErrorMessage = null;
      m_acAnalysisResults = null;
      
      if (! f.isDirectory()) {
        s_tpIconComputers.addTask (new Runnable() {
          public void run() {
            ensureParsed (false);
            
            synchronized (this) {
              m_fUseDefaultIcon = false;
              m_dtm.nodeChanged (FileTreeNode.this);
            }
          }
        });
      }
    }
    
    public File getFile() {
      return (File) getUserObject ();
    }
    
    protected synchronized void ensureParsed (boolean fUpdateChildren) {
      if (! m_fParsed) {
        try {
          m_acAnalysisResults = AnalysisConsumer.analyse (getFile());
          m_fHadError = false;
        }
        catch (IOException ioex) {
          m_acAnalysisResults = null;
          m_fHadError = true;

          m_sErrorMessage = "Couldn't read file: " + ioex.getLocalizedMessage();          
        }
        catch (InjectorParseException ipe) {
          m_acAnalysisResults = null;
          m_fHadError = true;
          m_sErrorMessage = "Not a Java file, or file is corrupted: " + ipe.getMessage();
        }
        finally {
          m_fParsed = true;
        }
      }
      
      
      if (fUpdateChildren) {
        removeAllChildren();

        if (! m_fHadError) {
          add (new CollectionHolderNode (m_acAnalysisResults.getCollections ()));
          add (new MapHolderNode (m_acAnalysisResults.getMaps ()));
        }
        else {
          add (new ErrorTreeNode (m_sErrorMessage));
        }
      }
    }
    
    public Icon getIcon (boolean fExpanded) {
      if (getFile().isDirectory()) {
        if (fExpanded) {
          return javax.swing.UIManager.getIcon ("Tree.closedIcon");
        }
        else {
          return javax.swing.UIManager.getIcon ("Tree.openIcon");
        }
      }
      else {
        if (m_fUseDefaultIcon) {
          return javax.swing.UIManager.getIcon ("Tree.leafIcon");
        }
        
        ensureParsed (false);
        
        if (! m_fHadError) {
          switch (m_acAnalysisResults.getStatus()) {
            case AnalysisConsumer.STATUS_NORMALFILE:
              return s_iNormalFile;
            case AnalysisConsumer.STATUS_COLLECTIONSONLY:
              return s_iFileWithCollections;
            case AnalysisConsumer.STATUS_COLLECTIONSONLY_INCOMPL:
              return s_iFileWithCollectionsInComplete;
            case AnalysisConsumer.STATUS_MAPSONLY:
              return s_iFileWithMaps;
            case AnalysisConsumer.STATUS_MAPSONLY_INCOMPL:
              return s_iFileWithMapsInComplete;
            case AnalysisConsumer.STATUS_COLLECTIONSANDMAPS:
              return s_iFileWithCollectionsAndMaps;
            case AnalysisConsumer.STATUS_COLLECTIONSANDMAPS_INCOMPL:
              return s_iFileWithCollectionsAndMapsInComplete;
            default:
              return javax.swing.UIManager.getIcon ("Tree.leafIcon");
          }
        }
        else {
          return s_iFileError;
        }
      }
    }
    
    public void fill (String sDirectory, DefaultTreeModel dtmModel) {
      setFile (new File (sDirectory));
      fill (dtmModel);
    }
    
    public void fill (DefaultTreeModel dtmModel) {
      File fLister = getFile();
      
      if (fLister.isDirectory()) {
        File[] afFiles = fLister.listFiles (new FileFilter() {
          public boolean accept (File f) {
            return ((f.isDirectory()) ||
                     (f.getName().endsWith (".java")));
          }
        });

        if (afFiles.length == 0) {
          setAllowsChildren (false);
          
          dtmModel.nodeChanged (this);
        }
        else {
          List lFiles = Arrays.asList (afFiles);
          Collections.sort (lFiles, new Comparator() {
            // Sort directories before files, same type sort lexikographically
            public int compare (Object o1, Object o2) {
              File f1 = (File) o1;
              File f2 = (File) o2;
              
              if (f1.isDirectory() == f2.isDirectory()) {
                // Either two directories or two files
                return String.CASE_INSENSITIVE_ORDER.compare (f1.getName(), f2.getName());
              }
              else {
                // One directory, one file
                if (f1.isDirectory()) {
                  // f1 is the directory, which is "smaller" than the file f2.
                  return -1;
                }
                else {
                  // f2 is the directory, so f1 is "greater" than f2.
                  return 1;
                }
              }
            }
          });
          
          for (Iterator i = lFiles.iterator(); i.hasNext();) {
            add (new FileTreeNode (dtmModel, (File) i.next()));
          }

          dtmModel.nodeStructureChanged (this);
        } 
      }
      else {
        // Current node is java file
        ensureParsed (true);
        
        dtmModel.nodeStructureChanged (this);
      }
    }
    
    public String toString() {
      return ((getFile() != null)?
               (getFile().getName()):
               ("<>"));
    }
  }

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
      
      setIcon (rtn.getIcon (expanded));
      
      return this;
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
  private javax.swing.JScrollPane m_jspTreeScroller;
  private javax.swing.JTree m_jtFiles;
  private javax.swing.JScrollPane m_jspProperties;
  private javax.swing.JTable m_jtPropertiesTable;
  // End of variables declaration//GEN-END:variables

}
