/*
Copyright (C) 2001  Sten Loecher

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

package tudresden.ocl.sql;

import tudresden.ocl.*;
import tudresden.ocl.codegen.*;
import tudresden.ocl.codegen.decl.*;
import tudresden.ocl.check.types.*;
import tudresden.ocl.check.types.xmifacade.*;
import tudresden.ocl.gui.*;

import java.io.*;
import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class OCL2SQL extends JPanel implements ActionListener {
    
    // Step 1
    private String xmiFileLocation;
    private String rulesFileLocation;
    private String theProjectPath;
    
    // Step 2
    private ModelFacade theModelFacade;
    private Model theRoughModel;
    private SimpleOCLEditorModel theOCLEditorModel;
    private OCLEditor theOCLEditor;
    
    // Step 3
    private ORMapping theORMapping;
    private ObjectViewSchema theObjectViewSchema;    
    private SQLBuilder theSQLBuilder;
    private ILSQLCodeGenerator theSQLCodeGenerator;
    
    // object relational Mapping
    private int ormClassToTableMode = 2;
    private int ormNumOfPKColumns = 1;
    private String ormPKColType = "int";
    private boolean ormOneTablePerAss = false;
    
    // result
    private java.util.List lIntegrityViews;
    private String resultTableSchema, resultObjectViews, resultIntegrityViews, resultTrigger;
        
    // gui
    protected JTabbedPane tabs;
    protected JButton bLoadConstraints, bSaveConstraints, bXmiSource, bLoadXmi, bProjectDirectory, bExecute;
    protected JTextField tfXmiSource, tfProjectDirectory, tfPKNoCol;
    protected JRadioButton rbInheritance0, rbInheritance1, rbInheritance2, rbAssociations0, rbAssociations1, rbTriggerAssertion, rbTriggerECA, rbTriggerNone;
    protected JComboBox cbPKType;
    protected JTextArea taResultTables, taResultObjectViews, taResultIntegrityViews, taResultTrigger;
    protected JDialog dlgProgress;
    protected JProgressBar progressBar;
    
    // tokens
    public static String TRIGGER = "tudocltrigg";
    public static String INTERR = "integrity violation at ";
    
    public OCL2SQL(boolean engageGUI) {
        if (engageGUI) buildGUI();
    }
    
    protected void buildGUI() {
        tabs = new JTabbedPane();
        tabs.addTab("Input", getInputPane());
        tabs.addTab("Project", getProjectPane());
        tabs.addTab("Output", getOutputPane());
        tabs.addTab("About", getAboutPane());
        setLayout(new BorderLayout());
        add(tabs);
    }
    
    protected JPanel getInputPane() {
        JPanel result = new JPanel(new BorderLayout());
                      
        // constraints
        JPanel c = new JPanel(new BorderLayout());
        c.setBorder(BorderFactory.createTitledBorder(" Constraints "));
                 
        theOCLEditor = new OCLEditor();
        theOCLEditorModel = new SimpleOCLEditorModel();
        theOCLEditor.setModel(theOCLEditorModel);
        c.add(theOCLEditor);
        
        JPanel buttons = new JPanel(new GridLayout(0,4));
        bLoadConstraints = new JButton("Load");
        bLoadConstraints.addActionListener(this);
        bSaveConstraints = new JButton("Save");
        bSaveConstraints.addActionListener(this);
        buttons.add(new JPanel());
        buttons.add(new JPanel());
        buttons.add(bLoadConstraints);
        buttons.add(bSaveConstraints);
        c.add(BorderLayout.SOUTH, buttons);       
            
        result.add(c);
        
        // object oriented Model from XMI file
        JPanel oom = new JPanel(new BorderLayout());
        oom.setBorder(BorderFactory.createTitledBorder(" URL of XMI file "));
        tfXmiSource = new JTextField();
        oom.add(BorderLayout.CENTER, tfXmiSource);
        
        JPanel oomb = new JPanel(new GridLayout(1,2));
        bXmiSource = new JButton(". . .");
        bXmiSource.addActionListener(this);
        oomb.add(bXmiSource);
        bLoadXmi = new JButton("Parse");
        bLoadXmi.addActionListener(this);
        oomb.add(bLoadXmi);
        
        oom.add(BorderLayout.EAST, oomb);
        
        result.add(BorderLayout.SOUTH, oom);
        
        return result;
    }
    
    protected JPanel getProjectPane() {
        JPanel result = new JPanel(new BorderLayout());
                
        // project directory
        JPanel prdir = new JPanel(new BorderLayout());
        prdir.setBorder(BorderFactory.createTitledBorder(" project directory "));
        
        tfProjectDirectory = new JTextField();
        prdir.add(BorderLayout.CENTER, tfProjectDirectory);
        
        bProjectDirectory = new JButton(". . .");
        bProjectDirectory.addActionListener(this);
        prdir.add(BorderLayout.EAST, bProjectDirectory);

        // object relational mapping    
        JPanel orm = new JPanel(new BorderLayout());
        orm.setBorder(BorderFactory.createTitledBorder(" object relational mapping "));
        
        JPanel pInheritance = new JPanel();
        pInheritance.setLayout(new BoxLayout(pInheritance, BoxLayout.Y_AXIS));
        pInheritance.setBorder(BorderFactory.createTitledBorder(" classes to tables "));
        rbInheritance0 = new JRadioButton("one table per class");
        rbInheritance1 = new JRadioButton("one table per hierarchy");
        rbInheritance2 = new JRadioButton("one table per leaf class");
        ButtonGroup bgInheritance = new ButtonGroup();
        bgInheritance.add(rbInheritance0);
        bgInheritance.add(rbInheritance1);
        bgInheritance.add(rbInheritance2);
        rbInheritance0.setSelected(true);
        pInheritance.add(rbInheritance0);
        pInheritance.add(rbInheritance1);
        pInheritance.add(rbInheritance2);
        orm.add(BorderLayout.WEST, pInheritance);      
      
        JPanel pAssociations = new JPanel();
        pAssociations.setLayout(new BoxLayout(pAssociations, BoxLayout.Y_AXIS));
        pAssociations.setBorder(BorderFactory.createTitledBorder(" associations "));
        rbAssociations0 = new JRadioButton("prefer foreign keys");
        rbAssociations1 = new JRadioButton("one table per association");
        ButtonGroup bgAssociations = new ButtonGroup();
        bgAssociations.add(rbAssociations0);
        bgAssociations.add(rbAssociations1);
        rbAssociations0.setSelected(true);
        pAssociations.add(rbAssociations0);
        pAssociations.add(rbAssociations1);
        orm.add(BorderLayout.CENTER, pAssociations);
        
        JPanel pPK = new JPanel(new BorderLayout());
        pPK.setBorder(BorderFactory.createTitledBorder(" primary keys "));
        
        JPanel pType = new JPanel(new BorderLayout());
        JLabel lType = new JLabel(" type:  ");
        lType.setOpaque(false);
        cbPKType = new JComboBox();
        cbPKType.addItem("NUMBER");
        cbPKType.addItem("VARCHAR");
        pType.add(BorderLayout.WEST, lType);
        pType.add(BorderLayout.CENTER, cbPKType);
        pPK.add(BorderLayout.WEST, pType);
        
        JPanel pNoCol = new JPanel(new BorderLayout());
        JLabel lNoCol = new JLabel("   number of columns:  ");
        lNoCol.setOpaque(false);
        tfPKNoCol = new JTextField("1", 5);
        tfPKNoCol.setEditable(true);
        pNoCol.add(BorderLayout.WEST, lNoCol);
        pNoCol.add(BorderLayout.CENTER, tfPKNoCol);
        pPK.add(BorderLayout.CENTER, pNoCol);
        
        orm.add(BorderLayout.SOUTH, pPK);
        
        // trigger
        JPanel tp = new JPanel();
        tp.setLayout(new BoxLayout(tp, BoxLayout.Y_AXIS));
        tp.setBorder(BorderFactory.createTitledBorder(" trigger "));
        rbTriggerAssertion = new JRadioButton("assertion replacement");
        rbTriggerECA = new JRadioButton("ECA template");
        rbTriggerNone = new JRadioButton("none");
        ButtonGroup bgTrigger = new ButtonGroup();
        bgTrigger.add(rbTriggerAssertion);
        bgTrigger.add(rbTriggerECA);
        bgTrigger.add(rbTriggerNone);
        rbTriggerAssertion.setSelected(true);
        tp.add(rbTriggerAssertion);
        tp.add(rbTriggerECA);
        tp.add(rbTriggerNone);
               
        // execute
        JPanel ep = new JPanel(new GridLayout(0,4));
        bExecute = new JButton("Execute Project");
        bExecute.addActionListener(this);
        ep.add(new JPanel());
        ep.add(new JPanel());
        ep.add(new JPanel());
        ep.add(bExecute);
           
        result.add(BorderLayout.NORTH, prdir);
        result.add(BorderLayout.CENTER, orm);
        result.add(BorderLayout.SOUTH, ep);
        result.add(BorderLayout.EAST, tp);
        
        return result;
    }
    
    protected JPanel getOutputPane() {
        JPanel result = new JPanel(new BorderLayout());
        result.setBorder(BorderFactory.createEtchedBorder());
        
        JTabbedPane tpResult = new JTabbedPane();
        tpResult.setTabPlacement(SwingConstants.BOTTOM);
        
        taResultTables = new JTextArea("");
        taResultTables.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane sp1 = new JScrollPane(taResultTables);
        tpResult.addTab("Table Schema", sp1);
        
        taResultObjectViews = new JTextArea("");
        taResultObjectViews.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane sp2 = new JScrollPane(taResultObjectViews);
        tpResult.addTab("Object Views", sp2);
        
        taResultIntegrityViews = new JTextArea("");
        taResultIntegrityViews.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane sp3 = new JScrollPane(taResultIntegrityViews);
        tpResult.addTab("Integrity Views", sp3);
        
        taResultTrigger = new JTextArea("");
        taResultTrigger.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane sp4 = new JScrollPane(taResultTrigger);
        tpResult.addTab("Trigger", sp4);
        
        result.add(tpResult);
        
        return result;
    }
    
    protected JPanel getAboutPane() {
        JPanel result = new JPanel(new BorderLayout());
        
        return result;
    }
          
    public static void main(String[] args) {
        JFrame frame = new JFrame("OCL2SQL");
        OCL2SQL ce = new OCL2SQL(true);
        
        frame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        frame.getContentPane().add(ce);
        frame.setSize(600, 400);
        frame.setVisible(true);
        
        /*
        String xmiFile = (OCL2SQL.class.getRessource("/home/sl13/Diplom/OCL2SQLTestProject/test.xmi")).toString();
        String rulesFile = (OCL2SQL.class.getRessource("/home/sl13/Diplom/OCL2SQLTestProject/test.ocl")).toString();
        String projectPath = "/home/sl13/Diplom/OCL2SQLTestProject/";
        OCL2SQL theTool = new OCL2SQL(xmiFile, rulesFile, projectPath);
        theTool.buildAll();        
         */
    }
    
    /**
     *  Builds the entire project. The following will be executed to prepare for code generation:<br>
     *  <ol>
     *      <li>the model facade for the compiler will be created</li>
     *      <li>the rough model for the SQL specific tasks will be created</li>
     *      <li>the specified OCL invariants will be read from the specified location</li>
     *      <li>the ObjectViewSchema for the SQL code generator will be created</li>      
     *  </ol>
     *  The actual code generation takes place by executing the following steps:
     *  <ol>
     *      <li>the table schema will be generated</li>
     *      <li>the object views will be generated</li>
     *      <li>the integrity views will be generated one after each other</li>
     *      <li>the trigger definitions will be generated</li>
     *  </ol>
     */
    public void buildAll() {
        /*
        prepareProjectBuild();
        executeGenerationProcess();
         */
    }
    
    public boolean prepareProjectExecution() { 
        String temp;
        
        // check XMI source
        temp = tfXmiSource.getText();
        if (temp.trim().length() == 0) {
            showMessage("Error", "You must specify a XMI source file !", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                theRoughModel = XmiParser.createRoughModel(tfXmiSource.getText(), "model in rough mode");
                theModelFacade = XmiParser.createModel(tfXmiSource.getText(), "model in classic mode");               
            } catch(Exception e) {
                showMessage("Error", "Could not process XMI source file !\n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        
        // do object relational mapping
        theSQLBuilder = new OracleSQLBuilder();
        theORMapping = new ORMappingImp(theRoughModel,
                                        ormClassToTableMode, 
                                        ormNumOfPKColumns, 
                                        ormPKColType, 
                                        ormOneTablePerAss); 
        
        // initialize object view shema
        theObjectViewSchema = new ObjectViewSchema(theORMapping, theSQLBuilder);
        
        // initialize SQL code generator
        theSQLCodeGenerator = new ILSQLCodeGenerator((OCL2SQL.class.getResource("../codegen/decl/OCL2SQL4Oracle.xml")).toString());        
        theSQLCodeGenerator.setORMappingScheme(theObjectViewSchema);
        lIntegrityViews = new ArrayList();        
                
        return true;
    }
    
    private void prepareProgressInfo() {
    }
    
    private void increaseProgressInfo() {
    }
    
    private void updateOutputPane() {
        taResultTables.setText(resultTableSchema);
        taResultObjectViews.setText(resultObjectViews);
        taResultIntegrityViews.setText(resultIntegrityViews);
        taResultTrigger.setText(resultTrigger);
    }
    
    public void executeProject() {
        StringBuffer tmp;
        String constraint, triggers[];
        OclTree theTree;
        CodeFragment cf[];
        DeclarativeCodeFragment dcf;
        TriggerGenerator tg;
        
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        prepareProgressInfo();
        if (!prepareProjectExecution()) return;
                        
        // create table schema
        DDLGenerator ddlg = new DDLGenerator();
        ddlg.createDDL(theORMapping);
        resultTableSchema = ddlg.getDDLScript();
        increaseProgressInfo();
        
        // create object views
        resultObjectViews = theObjectViewSchema.getViewDefinitions();
        increaseProgressInfo();
        
        // create integrity views
        tmp = new StringBuffer();
        try {
            for (int i=0; i<theOCLEditorModel.getConstraintCount(); i++) {
                constraint = (theOCLEditorModel.getConstraintAt(i)).getData();
                theTree = OclTree.createTree(constraint, theModelFacade);
                theTree.applyDefaultNormalizations();
                cf = theSQLCodeGenerator.getCode(theTree);
                tmp.append(cf[0].getCode() + "\n");
                lIntegrityViews.add(cf[0]);
            }
        } catch(Exception e) {
            showMessage("Error", "Error during Integrity View generation.\n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        resultIntegrityViews = tmp.toString();
        increaseProgressInfo();
        
        // create trigger definitions
        tg = new TriggerGenerator(theSQLBuilder);
        tmp = new StringBuffer();
        for (int i=0; i<lIntegrityViews.size(); i++) {
            dcf = (DeclarativeCodeFragment)lIntegrityViews.get(i);
            triggers = new String[0];
            
            if (rbTriggerAssertion.isSelected()) {
                triggers = tg.getAssertionReplacement(TRIGGER, 
                                                      INTERR + dcf.getName(),
                                                      (dcf.getAdditionalInfo())[0],
                                                      theObjectViewSchema.getQueriedTables((dcf.getAdditionalInfo())[0]));
            } else if (rbTriggerECA.isSelected()) {
                triggers = tg.getECATriggerTemplate(TRIGGER, 
                                                    (dcf.getAdditionalInfo())[0],
                                                    theObjectViewSchema.getQueriedTables((dcf.getAdditionalInfo())[0]));
            }
            for (int k=0; k<triggers.length; k++) {
                tmp.append(triggers[k]);
                tmp.append("\n");
            }
        }
        
        resultTrigger = tmp.toString();
        increaseProgressInfo();
        
        updateOutputPane();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    public void actionPerformed(java.awt.event.ActionEvent event) {
        Object source=event.getSource();
   
        if (source == bLoadConstraints) {
            loadConstraints();
        } else if (source == bSaveConstraints) {
            saveConstraints();
        } else if (source == bXmiSource) {
            loadXmiSourceURL();
        } else if (source == bLoadXmi) {
            loadXmiSource();
        } else if (source == bProjectDirectory) {
            loadProjectPath();
        } else if (source == bExecute) {
            executeProject();
        }
    }
    
    private void showMessage(String title, String message, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }
    
    private void loadConstraints() {
        JFileChooser fileChooser = new JFileChooser();
        File theFile = null;
        FileInputStream fis;
        ObjectInputStream ois;
            
        // show open dialog
        fileChooser.setDialogTitle("Open Constraint List");
        fileChooser.showOpenDialog(this);
            
        // check for selected file
        theFile = fileChooser.getSelectedFile();
        if (theFile == null) return;
        System.err.println(theFile.getAbsolutePath());
          
        // load the constraints from the specified file
        try {
            fis = new FileInputStream(theFile.getAbsolutePath());
            ois = new ObjectInputStream(fis);
              
            theOCLEditorModel = (SimpleOCLEditorModel)ois.readObject();
                
            ois.close();                
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Could not load constraint list.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
              
        theOCLEditor.setModel(theOCLEditorModel);  
    }
    
    private void saveConstraints() {
        JFileChooser fileChooser = new JFileChooser();
        File theFile = null;
        FileOutputStream fos;
        ObjectOutputStream oos;
                                 
        // show save dialog
        fileChooser.setDialogTitle("Save Constraint List");
        fileChooser.showSaveDialog(this);  
            
        // check for selected file
        theFile = fileChooser.getSelectedFile();
        if (theFile == null) return;
                      
        // save constraints to the specified file
        try {
            fos = new FileOutputStream(theFile.getAbsolutePath());
            oos = new ObjectOutputStream(fos);
            
            oos.writeObject(theOCLEditorModel);
            
            oos.flush();
            oos.close();            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Could not save constraint list.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(e.toString());
        }
            
        // show success Message
        JOptionPane.showMessageDialog(this, "Constraint list successfully stored.", "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void loadXmiSourceURL() {
        JFileChooser fileChooser = new JFileChooser();
        File theFile = null;
        FileInputStream fis;
        ObjectInputStream ois;
            
        // show open dialog
        fileChooser.setDialogTitle("Choose XMI Source");
        fileChooser.showOpenDialog(this);
            
        // check for selected file
        theFile = fileChooser.getSelectedFile();
        if (theFile == null) return;
        System.err.println(theFile.getAbsolutePath());
            
        // load the constraints from the specified file
        try {
            tfXmiSource.setText(theFile.toURL().toString());
        } catch(Exception e) {
        }
    }
    
    private void loadXmiSource() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        
        try {
            theModelFacade = XmiParser.createModel(tfXmiSource.getText(), "model in classic mode");
            theOCLEditorModel.setModelFacade(theModelFacade);
        } catch(Exception e) {
            this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(this, "Could not parse XMI source.\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(e.toString());
            return;
        }
        
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        JOptionPane.showMessageDialog(this, "XMI source has been parsed successfully.", "", JOptionPane.INFORMATION_MESSAGE);        
    }
    
    private void loadProjectPath() {
        JFileChooser fileChooser = new JFileChooser();
        File theFile = null;
        FileInputStream fis;
        ObjectInputStream ois;
            
        // show open dialog
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Choose Project Directory");
        fileChooser.showOpenDialog(this);
            
        // check for selected file
        theFile = fileChooser.getSelectedFile();
        if (theFile == null) return;
        System.err.println(theFile.getAbsolutePath());
            
        // load the constraints from the specified file
        tfProjectDirectory.setText(theFile.getPath());
    }
    
}
