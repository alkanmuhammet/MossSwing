package GUI;

import it.zielke.moji.SocketClient;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.DefaultListModel;
import javax.swing.InputMap;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyledDocument;
import org.apache.commons.io.FileUtils;

/**
 * @file MainFormFX.java
 * @date Dec 25, 2017 , 2:23:36 PM
 * @author Muhammet Alkan
 */
public class MainFormFX extends javax.swing.JFrame {

    private final DefaultListModel<String> listModel_BaseFiles, listModel_SourceFiles;
    private final Map<String, String> languageList;
    private final PropertyManager pm;
    private final StyledDocument log;

    private ExecutorService executor;

    private SimpleSwingBrowser browser;

    public MainFormFX() {
        pm = new PropertyManager();

        initComponents();
        initBrowser();

        listModel_SourceFiles = new DefaultListModel();
        listModel_BaseFiles = new DefaultListModel();
        languageList = new LinkedHashMap<>();

        jList_SourceFiles.setModel(listModel_SourceFiles);
        jList_BaseFiles.setModel(listModel_BaseFiles);

        log = jTextPane_Log.getStyledDocument();
        initProperties();
        setLanguageList();

        javax.swing.ToolTipManager.sharedInstance().setDismissDelay(60000);
    }

    private void initBrowser() {
        JPopupMenu popup = new JPopupMenu("");
        JMenuItem item = new JMenuItem(new DefaultEditorKit.CopyAction());
        item.setText("Copy");
        popup.add(item);
        jTextPane_Log.setComponentPopupMenu(popup);

        browser = new SimpleSwingBrowser();
        browser.setVisible(true);

        jTabbedPane1.add(browser, 1);
    }

    private void initProperties() {
        try {
            if (pm.readUserProperties()) {
                logToTextPane("All user defined values are succesfully readed");
            } else {
                logToTextPane("There is no user config file");
            }

            setAllProperties();
        } catch (Exception ex) {
            showMessageDialog(ex.toString(), "Error : Initialize Properties", 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel_Main = new javax.swing.JPanel();
        jLabel_UserId = new javax.swing.JLabel();
        jLabel_Language = new javax.swing.JLabel();
        jTextField_UserId = new javax.swing.JTextField();
        jComboBox_Language = new javax.swing.JComboBox<>();
        jPanel_Options = new javax.swing.JPanel();
        jCheckBox_UseExperimentalServer = new javax.swing.JCheckBox();
        jLabel_OptionN = new javax.swing.JLabel();
        jLabel_OptionC = new javax.swing.JLabel();
        jLabel_OptionM = new javax.swing.JLabel();
        jTextField_OptionC = new javax.swing.JTextField();
        jFTextField_OptionM = new javax.swing.JFormattedTextField();
        jFTextField_OptionN = new javax.swing.JFormattedTextField();
        jPanelExtensions = new javax.swing.JPanel();
        jCheckBox_RestrictFileTypes = new javax.swing.JCheckBox();
        jTextField_AllowedExtensions = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_BaseFiles = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_SourceFiles = new javax.swing.JList<>();
        jLabel_BaseFiles = new javax.swing.JLabel();
        jLabel_SourceFiles = new javax.swing.JLabel();
        jCheckBox_DirectoryMode = new javax.swing.JCheckBox();
        jLabel_ClearLists = new javax.swing.JLabel();
        jButton_SendRequest = new javax.swing.JButton();
        jPanel_Log = new javax.swing.JPanel();
        jScrollPane_Log = new javax.swing.JScrollPane();
        jTextPane_Log = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Similarity Finder");
        setMinimumSize(new java.awt.Dimension(577, 592));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel_UserId.setText("User Id       :");

        jLabel_Language.setText("Language   :");

        jPanel_Options.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Set Options", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jCheckBox_UseExperimentalServer.setText("Use Experimental Server");
        jCheckBox_UseExperimentalServer.setToolTipText("Sends queries to the current experimental version of the server.");

        jLabel_OptionN.setText("Option N       :");
        jLabel_OptionN.setToolTipText(pm.getDefaultProperty("info_OptionN"));

        jLabel_OptionC.setText("Option C       :");
        jLabel_OptionC.setToolTipText(pm.getDefaultProperty("info_OptionC"));

        jLabel_OptionM.setText("Option M       :");
        jLabel_OptionM.setToolTipText(pm.getDefaultProperty("info_OptionM"));

        jFTextField_OptionM.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFTextField_OptionM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OptionKeyTyped(evt);
            }
        });

        jFTextField_OptionN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFTextField_OptionN.setCaretPosition(jFTextField_OptionN.getDocument().getLength());
        jFTextField_OptionN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_OptionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel_OptionsLayout = new javax.swing.GroupLayout(jPanel_Options);
        jPanel_Options.setLayout(jPanel_OptionsLayout);
        jPanel_OptionsLayout.setHorizontalGroup(
            jPanel_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_OptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_OptionsLayout.createSequentialGroup()
                        .addGroup(jPanel_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_OptionM)
                            .addComponent(jLabel_OptionC)
                            .addComponent(jLabel_OptionN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_OptionC)
                            .addComponent(jFTextField_OptionM, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jFTextField_OptionN, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel_OptionsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jCheckBox_UseExperimentalServer)))
                .addContainerGap())
        );
        jPanel_OptionsLayout.setVerticalGroup(
            jPanel_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_OptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_OptionM)
                    .addComponent(jFTextField_OptionM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_OptionC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_OptionC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_OptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_OptionN)
                    .addComponent(jFTextField_OptionN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_UseExperimentalServer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelExtensions.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Accepted Extensions", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jCheckBox_RestrictFileTypes.setText("<html><center>Restrict File Types</center></html>");
        jCheckBox_RestrictFileTypes.setToolTipText("File extension filter to apply when selecting files");
        jCheckBox_RestrictFileTypes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_RestrictFileTypesItemStateChanged(evt);
            }
        });

        jTextField_AllowedExtensions.setText("Allowed File Extensions");
        jTextField_AllowedExtensions.setToolTipText("Enter a list of accepted extensions, for example: java,xml");
        jTextField_AllowedExtensions.setEnabled(false);

        javax.swing.GroupLayout jPanelExtensionsLayout = new javax.swing.GroupLayout(jPanelExtensions);
        jPanelExtensions.setLayout(jPanelExtensionsLayout);
        jPanelExtensionsLayout.setHorizontalGroup(
            jPanelExtensionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExtensionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelExtensionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox_RestrictFileTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_AllowedExtensions, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelExtensionsLayout.setVerticalGroup(
            jPanelExtensionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelExtensionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox_RestrictFileTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField_AllowedExtensions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jList_BaseFiles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_BaseFiles.setVisibleRowCount(7);
        jScrollPane1.setViewportView(jList_BaseFiles);

        jList_SourceFiles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jList_SourceFiles);

        jLabel_BaseFiles.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel_BaseFiles.setText("<HTML><U>Base File(s)</U></HTML>");
        jLabel_BaseFiles.setToolTipText("Add Base File(s)");
        jLabel_BaseFiles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_BaseFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_BaseFilesMouseClicked(evt);
            }
        });

        jLabel_SourceFiles.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel_SourceFiles.setText("<HTML><U>Source Files</U></HTML>");
        jLabel_SourceFiles.setToolTipText("Add Source Files");
        jLabel_SourceFiles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_SourceFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_SourceFilesMouseClicked(evt);
            }
        });

        jCheckBox_DirectoryMode.setText("Directory Mode");
        jCheckBox_DirectoryMode.setToolTipText("<html>Specifies that submissions are by directory, not by file.<br/>\nThat is, files in a directory are taken to be part of the same program,\n<br/>and reported matches are organized accordingly by directory.</html>\");\n       ");

        jLabel_ClearLists.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel_ClearLists.setText("<HTML><U>Clear Lists</U></HTML>");
        jLabel_ClearLists.setToolTipText("Clear Base File(s) List and Source Files List");
        jLabel_ClearLists.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_ClearLists.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_ClearListsMouseClicked(evt);
            }
        });

        jButton_SendRequest.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton_SendRequest.setText("<html><center>Send<br>Request</center></html>");
        jButton_SendRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_SendRequest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_SendRequest.setMinimumSize(new java.awt.Dimension(94, 56));
        jButton_SendRequest.setPreferredSize(new java.awt.Dimension(94, 56));
        jButton_SendRequest.setSize(new java.awt.Dimension(94, 56));
        jButton_SendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SendRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_MainLayout = new javax.swing.GroupLayout(jPanel_Main);
        jPanel_Main.setLayout(jPanel_MainLayout);
        jPanel_MainLayout.setHorizontalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_MainLayout.createSequentialGroup()
                        .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_MainLayout.createSequentialGroup()
                                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_SendRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_MainLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel_BaseFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelExtensions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel_MainLayout.createSequentialGroup()
                                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel_UserId)
                                    .addComponent(jLabel_Language))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_UserId, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox_Language, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel_Options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_MainLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel_SourceFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox_DirectoryMode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_ClearLists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        jPanel_MainLayout.setVerticalGroup(
            jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_MainLayout.createSequentialGroup()
                        .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_UserId)
                            .addComponent(jTextField_UserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Language)
                            .addComponent(jComboBox_Language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_MainLayout.createSequentialGroup()
                                .addComponent(jButton_SendRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel_BaseFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanelExtensions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel_Options, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_SourceFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_DirectoryMode)
                    .addComponent(jLabel_ClearLists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Main", jPanel_Main);

        jTextPane_Log.setEditable(false);
        jScrollPane_Log.setViewportView(jTextPane_Log);

        javax.swing.GroupLayout jPanel_LogLayout = new javax.swing.GroupLayout(jPanel_Log);
        jPanel_Log.setLayout(jPanel_LogLayout);
        jPanel_LogLayout.setHorizontalGroup(
            jPanel_LogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_LogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_Log, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel_LogLayout.setVerticalGroup(
            jPanel_LogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_LogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane_Log, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Log", jPanel_Log);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_BaseFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_BaseFilesMouseClicked
        getAllFiles(listModel_BaseFiles, "Base File(s)");
    }//GEN-LAST:event_jLabel_BaseFilesMouseClicked

    private void jLabel_SourceFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_SourceFilesMouseClicked
        getAllFiles(listModel_SourceFiles, "Source Files");
    }//GEN-LAST:event_jLabel_SourceFilesMouseClicked

    private void jButton_SendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SendRequestActionPerformed
        if (listModel_SourceFiles.isEmpty()) {
            showMessageDialog("To send request, please add some source files !!", "Source Files", 1);
            return;
        }

        if (executor == null) {
            executor = Executors.newSingleThreadExecutor();
        }

        if (jButton_SendRequest.getText().contains("Send")) {
            // with or without base files
            executor.execute(() -> uploadFiles(startSocketClient(), !listModel_BaseFiles.isEmpty()));

            jButton_SendRequest.setForeground(Color.red);
            jButton_SendRequest.setText("<html><center>Cancel<br>Request</center></html>");
        } else {
            executor.shutdownNow();
            jButton_SendRequest.setForeground(Color.black);
            jButton_SendRequest.setText("<html><center>Send<br>Request</center></html>");
        }
    }//GEN-LAST:event_jButton_SendRequestActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        saveUserProperties();
    }//GEN-LAST:event_formWindowClosing

    private void jCheckBox_RestrictFileTypesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_RestrictFileTypesItemStateChanged
        if (jCheckBox_RestrictFileTypes.isSelected()) {
            if (jTextField_AllowedExtensions.getText().equals("Allowed File Extensions")) {
                jTextField_AllowedExtensions.setText("");
            }
            jTextField_AllowedExtensions.setEnabled(true);
        } else {
            jTextField_AllowedExtensions.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox_RestrictFileTypesItemStateChanged

    private void jLabel_ClearListsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_ClearListsMouseClicked
        listModel_SourceFiles.clear();
        listModel_BaseFiles.clear();
    }//GEN-LAST:event_jLabel_ClearListsMouseClicked

    private void jTextField_OptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_OptionKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_OptionKeyTyped

    private void uploadFiles(SocketClient socketClient, boolean getBaseFiles) {
        if (socketClient == null) {
            return;
        }

        logToTextPane("***** Uploading Files *****");
        try {
            jTabbedPane1.setSelectedIndex(2);
            String filename;
            if (getBaseFiles) {
                for (int i = 0; i < listModel_BaseFiles.getSize(); i++) {
                    filename = listModel_BaseFiles.get(i);
                    socketClient.uploadBaseFile(FileUtils.getFile(filename));
                    logToTextPane("base file uploaded : " + filename);
                }
            }

            for (int i = 0; i < listModel_SourceFiles.getSize(); i++) {
                filename = listModel_SourceFiles.get(i);
                socketClient.uploadFile(FileUtils.getFile(filename));
                logToTextPane("source file uploaded : " + filename);
            }

            logToTextPane("*** All files succesfully uploaded to the server. Waiting for an answer from the server..");
            socketClient.sendQuery();

            URL resultURL = socketClient.getResultURL();
            logToTextPane("Result link is available at : " + resultURL);

            copyURLToFile(resultURL);
            browser.loadURL(resultURL.toExternalForm());
            jTabbedPane1.setSelectedIndex(1);
        } catch (Exception ex) {
            showMessageDialog(ex.toString(), "Error : Upload Files", 0);
        } finally {
            jButton_SendRequest.setForeground(Color.black);
            jButton_SendRequest.setText("<html><center>Send<br>Request</center></html>");
        }
    }

    private SocketClient startSocketClient() {
        SocketClient socketClient = null;
        try {
            socketClient = new SocketClient();
            socketClient.setUserID(jTextField_UserId.getText());
            socketClient.setLanguage(languageList.get(jComboBox_Language.getSelectedItem().toString()));
            socketClient.setOptX(jCheckBox_UseExperimentalServer.isSelected() ? 1 : 0);
            socketClient.setOptD(jCheckBox_DirectoryMode.isSelected() ? 1 : 0);
            socketClient.setOptC(jTextField_OptionC.getText());
            socketClient.setOptM(Long.parseLong(jFTextField_OptionM.getText()));
            socketClient.setOptN(Long.parseLong(jFTextField_OptionN.getText()));

            socketClient.run();
        } catch (Exception ex) {
            showMessageDialog(ex.toString(), "Error : Socket Client", 0);
        }

        return socketClient;
    }

    private void copyURLToFile(URL resultURL) {
        if (resultURL != null) {
            try {
                String fileName = resultURL.getFile().substring(resultURL.getFile().lastIndexOf("/") + 1);

                fileName += ".html";
                FileUtils.copyURLToFile(resultURL, new File("results", fileName));

                showMessageDialog("Result file(" + fileName + ") is downloaded into results folder", "Finish", 1);
            } catch (Exception ex) {
                showMessageDialog(ex.toString(), "Error : Copy URL to File", 0);
            }
        } else {
            showMessageDialog("Returned URL is \"null\"", "Error : Copy URL to File", 0);
        }
    }

    private void getAllFiles(DefaultListModel listModel, String title) {
        JFileChooserExt fc = new JFileChooserExt("Select " + title);

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            listModel.clear();

            try {
                String[] extensions = null;
                if (jCheckBox_RestrictFileTypes.isSelected()) {
                    extensions = jTextField_AllowedExtensions.getText().trim().split("\\s*,\\s*");
                }

                Collection<File> files = FileUtils.listFiles(fc.getSelectedFile(), extensions, true);

                files.stream().filter(f -> !f.isHidden()).forEachOrdered((f) -> {
                    listModel.addElement(f.toString());
                });
            } catch (Exception ex) {
                showMessageDialog(ex.toString(), "Error : Get Files", 0);
            }

            showMessageDialog("All files in the selected directory are added.", title, 1);
        }
    }

    private static void addOSXKeyStrokes(InputMap inputMap) {
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.META_DOWN_MASK), DefaultEditorKit.copyAction);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.META_DOWN_MASK), DefaultEditorKit.cutAction);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.META_DOWN_MASK), DefaultEditorKit.pasteAction);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.META_DOWN_MASK), DefaultEditorKit.selectAllAction);
    }

    public static boolean isOSX() {
        String osName = System.getProperty("os.name");
        return osName.contains("OS X");
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            // javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            // javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            if (isOSX()) {
                addOSXKeyStrokes((InputMap) UIManager.get("TextField.focusInputMap"));
                addOSXKeyStrokes((InputMap) UIManager.get("FormattedTextField.focusInputMap"));
                addOSXKeyStrokes((InputMap) UIManager.get("TextPane.focusInputMap"));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Error : main", JOptionPane.ERROR_MESSAGE);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new MainFormFX().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_SendRequest;
    private javax.swing.JCheckBox jCheckBox_DirectoryMode;
    private javax.swing.JCheckBox jCheckBox_RestrictFileTypes;
    private javax.swing.JCheckBox jCheckBox_UseExperimentalServer;
    private javax.swing.JComboBox<String> jComboBox_Language;
    private javax.swing.JFormattedTextField jFTextField_OptionM;
    private javax.swing.JFormattedTextField jFTextField_OptionN;
    private javax.swing.JLabel jLabel_BaseFiles;
    private javax.swing.JLabel jLabel_ClearLists;
    private javax.swing.JLabel jLabel_Language;
    private javax.swing.JLabel jLabel_OptionC;
    private javax.swing.JLabel jLabel_OptionM;
    private javax.swing.JLabel jLabel_OptionN;
    private javax.swing.JLabel jLabel_SourceFiles;
    private javax.swing.JLabel jLabel_UserId;
    private javax.swing.JList<String> jList_BaseFiles;
    private javax.swing.JList<String> jList_SourceFiles;
    private javax.swing.JPanel jPanelExtensions;
    private javax.swing.JPanel jPanel_Log;
    private javax.swing.JPanel jPanel_Main;
    private javax.swing.JPanel jPanel_Options;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane_Log;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField_AllowedExtensions;
    private javax.swing.JTextField jTextField_OptionC;
    private javax.swing.JTextField jTextField_UserId;
    private javax.swing.JTextPane jTextPane_Log;
    // End of variables declaration//GEN-END:variables

    //ERROR_MESSAGE = 0;INFORMATION_MESSAGE = 1;WARNING_MESSAGE = 2;QUESTION_MESSAGE = 3;PLAIN_MESSAGE = -1;
    private void showMessageDialog(String message, String title, int type) {
        JOptionPane.showMessageDialog(this, message, title, type);
    }

    private void logToTextPane(String message) {
        try {
            log.insertString(log.getLength(), message + "\n", null);
            jScrollPane_Log.getVerticalScrollBar().setValue(jScrollPane_Log.getVerticalScrollBar().getMaximum());
        } catch (BadLocationException ex) {
            showMessageDialog(ex.toString(), "Error : Log", 0);
        }
    }

    private void setAllProperties() {
        jTextField_UserId.setText(pm.getUserProperty("userId", pm.getDefaultProperty("userId")));
        jComboBox_Language.setSelectedItem(pm.getUserProperty("default_Lang", pm.getDefaultProperty("default_Lang")));

        jFTextField_OptionM.setText(pm.getUserProperty("optionM", pm.getDefaultProperty("optionM")));
        jTextField_OptionC.setText(pm.getUserProperty("optionC", pm.getDefaultProperty("optionC")));
        jFTextField_OptionN.setText(pm.getUserProperty("optionN", pm.getDefaultProperty("optionN")));
        
        if (pm.getUserProperty("isDirMode", pm.getDefaultProperty("isDirMode")).equals("true")) {
            jCheckBox_DirectoryMode.setSelected(true);
        }
        if (pm.getUserProperty("useExprServer", pm.getDefaultProperty("useExprServer")).equals("true")) {
            jCheckBox_UseExperimentalServer.setSelected(true);
        }

        jTextField_UserId.requestFocusInWindow();
    }

    private void setLanguageList() {
        String languages = pm.getUserProperty("languages", pm.getDefaultProperty("languages"));
        if (languages != null) {
            String[] langs = languages.split(";");
            String[] lang;
            for (String l : langs) {
                lang = l.split(",");
                languageList.put(lang[0], lang[1]);
                jComboBox_Language.addItem(lang[0]);
            }

            jComboBox_Language.setSelectedItem(pm.getUserProperty("default_Lang", pm.getDefaultProperty("default_Lang")));
        } else {
            showMessageDialog("Corrupted default config file !", "Error : Get Language List", 0);
        }

        // center = 0 ; left = 2 ; right = 4
        ((javax.swing.JLabel) jComboBox_Language.getRenderer()).setHorizontalAlignment(0);
    }

    protected void saveUserProperties() {
        pm.setUserProperty("userId", jTextField_UserId.getText());
        Object selectedItem = jComboBox_Language.getSelectedItem();
        pm.setUserProperty("default_Lang", selectedItem == null ? "" : jComboBox_Language.getSelectedItem().toString());

        pm.setUserProperty("optionM", jFTextField_OptionM.getText());
        pm.setUserProperty("optionC", jTextField_OptionC.getText());
        pm.setUserProperty("optionN", jFTextField_OptionN.getText());

        pm.setUserProperty("isDirMode", jCheckBox_DirectoryMode.isSelected() + "");
        pm.setUserProperty("useExprServer", jCheckBox_UseExperimentalServer.isSelected() + "");

        if (!pm.getUserConfigFile().getParentFile().exists()) {
            pm.getUserConfigFile().getParentFile().mkdir();
        }

        try (FileWriter writer = new FileWriter(pm.getUserConfigFile())) {
            pm.getUserProperties().store(writer, "user config setttings");
            writer.close();
        } catch (Exception ex) {
            showMessageDialog(ex.toString(), "Error : Save User Properties", 0);
        }
    }
}
