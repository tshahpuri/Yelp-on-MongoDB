import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tejas Shahpuri
 */
public class JavaGui extends javax.swing.JFrame {

    public static Boolean label;
    public static ArrayList<String> finalCat;
    public static String fromCheckin;
    public static String fromCheckinHour;
    public static String toCheckin;
    public static String toCheckinHour;
    public static String operationCheckin;
    public static String valueCheckin;
    public static String operationStar;
    public static String operationVote;
    public static String valueStar;
    public static String valueVote;
    public static String fromReview;
    public static String toReview;
    public static String updatedQuery;
    public JDialog mydialog;
    public static String memberSince;
    public static String operReviewCount;
    public static String operNoOfFriends;
    public static String operAvgStar;
    public static String valueReviewCount;
    public static String valueNoOfFriends;
    public static String valueAvgStar;
    public static String andOrAttribute;
    public MongoClient mongoClient;
    public static String Address;
    public static String proximity;
    public static String searchFor;
    public static Double longitude;
    public static Double latitude;
    public static String operNoOfVotes;
    public static String valueNoOfVotes;
    public static DefaultListModel<CheckboxListItem> model;

    /**
     * Creates new form dbGui
     */
    public JavaGui() throws SQLException {
        initComponents();

        label = true;
        finalCat = new ArrayList<>();
        fromCheckin = "";
        fromCheckinHour = "";
        toCheckin = "";
        toCheckinHour = "";
        operationCheckin = "";
        valueCheckin = "";
        operationStar = "";
        operationVote = "";
        valueStar = "";
        valueVote = "";
        fromReview = "";
        toReview = "";
        memberSince = "";
        operReviewCount = "";
        operNoOfFriends = "";
        operAvgStar = "";
        valueReviewCount = "";
        valueNoOfFriends = "";
        valueAvgStar = "";
        andOrAttribute = "";
        Address = "";
        proximity = "";
        searchFor = "";
        latitude = 0.0;
        longitude = 0.0;
        operNoOfVotes = "";
        valueNoOfVotes = "";

//        checkinList = new ArrayList<CheckinDetail>();
        mongoClient = new MongoClient("localhost", 27017);
        memberSinceDateBox.setEnabled(false);
        reviewCountComboBox.setEnabled(false);
        reviewCountValueTextField.setEnabled(false);
        numberOfFriendsComboBox.setEnabled(false);
        numberOfFriendsValueTextField.setEnabled(false);
        avgStarComboBox.setEnabled(false);
        avgStarValueTextField.setEnabled(false);
        andOrComboBox.setEnabled(false);
        model = (DefaultListModel) jList1.getModel();

        checkinValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueCheckin = checkinValueTextField.getText();
                //System.out.println(valueCheckin);
            }

        });
        starsValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueStar = starsValueTextField.getText();
                //System.out.println(valueStar);
            }

        });

        votesValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueVote = votesValueTextField.getText();
                //System.out.println(valueVote);
            }

        });
        reviewCountValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueReviewCount = reviewCountValueTextField.getText();
                //System.out.println(valueCheckin);
            }

        });

        numberOfFriendsValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueNoOfFriends = numberOfFriendsValueTextField.getText();
                //System.out.println(valueCheckin);
            }

        });

        avgStarValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueAvgStar = avgStarValueTextField.getText();
                //System.out.println(valueCheckin);
            }

        });

        noOfVotesValueTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                text();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                text();
            }

            public void text() {
                valueNoOfVotes = noOfVotesValueTextField.getText();
                System.out.println(valueNoOfVotes);
            }

        });

        //fromReview = ((JTextField) fromReviewDate.getDateEditor().getUiComponent()).getText();
        //System.out.println(fromReview);
        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                int row = resultTable.rowAtPoint(evt.getPoint());
                int col = resultTable.columnAtPoint(evt.getPoint());
                DB dbReview = mongoClient.getDB("review");
                DBCollection collReview = dbReview.getCollection("review");
                JTable im = new JTable();
                DefaultTableModel reviewModel = new DefaultTableModel(0, 0);
                im.setModel(reviewModel);

                String header[] = new String[]{"Name", "Review"};
                reviewModel.setColumnIdentifiers(header);
                //im.setRowHeight(50);

                if (!memberSince.isEmpty() || !operReviewCount.isEmpty() || !operNoOfFriends.isEmpty() || !operAvgStar.isEmpty()
                        || !valueReviewCount.isEmpty() || !valueNoOfFriends.isEmpty() || !valueAvgStar.isEmpty() || !andOrAttribute.isEmpty()) {
                    
                    
                    if (row >= 0 && col == 0) {
                        String tableValue = resultTable.getValueAt(row, col).toString();
                        String name= resultTable.getValueAt(row, col+1).toString();
                        
                        BasicDBObject whereQuery = new BasicDBObject();
                        whereQuery.put("user_id", tableValue);
                        DBCursor cursor = collReview.find(whereQuery);
                        while (cursor.hasNext()) {
                            Object[] rowReview = new Object[2];
                             rowReview[0] =name;
                             rowReview[1] = cursor.next().get("text").toString();
                              
                            reviewModel.addRow(rowReview);
                            }
                        
                        mydialog = new JDialog();
                        mydialog.setSize(new Dimension(1000, 1000));
                        mydialog.setTitle("Reviews By User");
                        mydialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // prevent user from doing something else
                        mydialog.add(im);
                        mydialog.setVisible(true);
                        mydialog.setResizable(true);

//                    JOptionPane.showConfirmDialog(null,
//                        getPanel(tableValue));
                    }

                } else {

                    if (row >= 0 && col == 0) {
                        String tableValue = resultTable.getValueAt(row, col).toString();
                        //String name= resultTable.getValueAt(row, col+1).toString();
                        
                        BasicDBObject whereQuery = new BasicDBObject();
                        whereQuery.put("business_id", tableValue);
                        DBCursor cursor = collReview.find(whereQuery);
                        while (cursor.hasNext()) {
                            Object[] rowReview = new Object[1];
                             //rowReview[0] =name;
                             rowReview[0] = cursor.next().get("text").toString();
                              
                            reviewModel.addRow(rowReview);
                            }
                        mydialog = new JDialog();
                        mydialog.setSize(new Dimension(1000, 1000));
                        mydialog.setTitle("Reviews By User");
                        mydialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // prevent user from doing something else
                        mydialog.add(im);
                        mydialog.setVisible(true);
                        mydialog.setResizable(true);

//                    JOptionPane.showConfirmDialog(null,
//                        getPanel(tableValue));
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane6 = new javax.swing.JScrollPane();
        dbCategory = new javax.swing.JPanel();
        checkinLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        checkinPanel = new javax.swing.JPanel();
        fromLabel = new javax.swing.JLabel();
        fromComboBox = new javax.swing.JComboBox();
        toLabel = new javax.swing.JLabel();
        toComboBox = new javax.swing.JComboBox();
        fromHourComboBox = new javax.swing.JComboBox();
        toHourComboBox = new javax.swing.JComboBox();
        noCheckinLabel = new javax.swing.JLabel();
        checkinValueComboBox = new javax.swing.JComboBox();
        checkinValueTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        reviewPanel = new javax.swing.JPanel();
        fromReviewLabel = new javax.swing.JLabel();
        toReviewLabel = new javax.swing.JLabel();
        starsLabel = new javax.swing.JLabel();
        starsComboBox = new javax.swing.JComboBox();
        starValueLabel = new javax.swing.JLabel();
        starsValueTextField = new javax.swing.JTextField();
        votesLabel = new javax.swing.JLabel();
        votesComboBox = new javax.swing.JComboBox();
        votesValueLabel = new javax.swing.JLabel();
        votesValueTextField = new javax.swing.JTextField();
        fromReviewDate = new com.toedter.calendar.JDateChooser();
        toReviewDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        categoryPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane8 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        queryLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        executeQueryButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        noCheckinLabel1 = new javax.swing.JLabel();
        noCheckinLabel2 = new javax.swing.JLabel();
        noCheckinLabel3 = new javax.swing.JLabel();
        proximityComboBox = new javax.swing.JComboBox();
        searchForComboBox = new javax.swing.JComboBox();
        pointOfInterestComboBox = new javax.swing.JComboBox();
        checkinPanel1 = new javax.swing.JPanel();
        fromLabel1 = new javax.swing.JLabel();
        toLabel1 = new javax.swing.JLabel();
        memberSinceDateBox = new com.toedter.calendar.JDateChooser();
        reviewCountComboBox = new javax.swing.JComboBox();
        reviewCountValueTextField = new javax.swing.JTextField();
        toLabel2 = new javax.swing.JLabel();
        numberOfFriendsComboBox = new javax.swing.JComboBox();
        numberOfFriendsValueTextField = new javax.swing.JTextField();
        toLabel3 = new javax.swing.JLabel();
        andOrComboBox = new javax.swing.JComboBox();
        avgStarValueTextField = new javax.swing.JTextField();
        toLabel4 = new javax.swing.JLabel();
        avgStarComboBox = new javax.swing.JComboBox();
        toLabel5 = new javax.swing.JLabel();
        numberOfVotesComboBox = new javax.swing.JComboBox();
        noOfVotesValueTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dbCategory.setBackground(new java.awt.Color(204, 204, 255));
        dbCategory.setMaximumSize(new java.awt.Dimension(1000, 1000));
        JScrollPane pane = new JScrollPane(dbCategory);

        checkinLabel.setBackground(new java.awt.Color(255, 255, 255));
        checkinLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        checkinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkinLabel.setText("Checkin");

        categoryLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        categoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoryLabel.setText("Category");

        checkinPanel.setBackground(new java.awt.Color(255, 255, 255));
        checkinPanel.setAutoscrolls(true);

        fromLabel.setBackground(new java.awt.Color(255, 255, 255));
        fromLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fromLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fromLabel.setLabelFor(fromComboBox);
        fromLabel.setText("From");

        fromComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fromComboBox.setMaximumRowCount(8);
        fromComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Day", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        fromComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromComboBoxMouseClicked(evt);
            }
        });
        fromComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromComboBoxActionPerformed(evt);
            }
        });

        toLabel.setBackground(new java.awt.Color(255, 255, 255));
        toLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLabel.setLabelFor(toComboBox);
        toLabel.setText("to");

        toComboBox.setMaximumRowCount(8);
        toComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Day", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" }));
        toComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toComboBoxActionPerformed(evt);
            }
        });

        fromHourComboBox.setMaximumRowCount(10);
        fromHourComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Time","0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        fromHourComboBox.setAutoscrolls(true);
        fromHourComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromHourComboBoxActionPerformed(evt);
            }
        });

        toHourComboBox.setMaximumRowCount(10);
        toHourComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Time","0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        toHourComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toHourComboBoxActionPerformed(evt);
            }
        });

        noCheckinLabel.setBackground(new java.awt.Color(255, 255, 255));
        noCheckinLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        noCheckinLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noCheckinLabel.setLabelFor(fromComboBox);
        noCheckinLabel.setText("Number of Checkins:");

        checkinValueComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<", "=", ">", "<" }));
        checkinValueComboBox.setToolTipText("");
        checkinValueComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinValueComboBoxActionPerformed(evt);
            }
        });

        checkinValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        checkinValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkinValueTextFieldActionPerformed(evt);
            }
        });
        checkinValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                checkinValueTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout checkinPanelLayout = new javax.swing.GroupLayout(checkinPanel);
        checkinPanel.setLayout(checkinPanelLayout);
        checkinPanelLayout.setHorizontalGroup(
            checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkinPanelLayout.createSequentialGroup()
                        .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromLabel)
                            .addComponent(toLabel)
                            .addComponent(noCheckinLabel)
                            .addGroup(checkinPanelLayout.createSequentialGroup()
                                .addComponent(checkinValueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(checkinValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(checkinPanelLayout.createSequentialGroup()
                        .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(fromHourComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(checkinPanelLayout.createSequentialGroup()
                        .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(toHourComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        checkinPanelLayout.setVerticalGroup(
            checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fromLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(toLabel)
                .addGap(18, 18, 18)
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toHourComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(noCheckinLabel)
                .addGap(18, 18, 18)
                .addGroup(checkinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkinValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkinValueComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Review");

        reviewPanel.setBackground(new java.awt.Color(255, 255, 255));
        reviewPanel.setAutoscrolls(true);

        fromReviewLabel.setBackground(new java.awt.Color(255, 255, 255));
        fromReviewLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fromReviewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fromReviewLabel.setText("From");

        toReviewLabel.setBackground(new java.awt.Color(255, 255, 255));
        toReviewLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toReviewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toReviewLabel.setText("to");

        starsLabel.setBackground(new java.awt.Color(255, 255, 255));
        starsLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        starsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        starsLabel.setLabelFor(starsComboBox);
        starsLabel.setText("Stars");

        starsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<","=", ">", "<" }));
        starsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starsComboBoxActionPerformed(evt);
            }
        });

        starValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        starValueLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        starValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        starValueLabel.setLabelFor(starsValueTextField);
        starValueLabel.setText("Values:");

        starsValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        starsValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starsValueTextFieldActionPerformed(evt);
            }
        });
        starsValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                starsValueTextFieldKeyTyped(evt);
            }
        });

        votesLabel.setBackground(new java.awt.Color(255, 255, 255));
        votesLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        votesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        votesLabel.setLabelFor(votesComboBox);
        votesLabel.setText("Votes");

        votesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<", "=", ">", "<" }));
        votesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votesComboBoxActionPerformed(evt);
            }
        });

        votesValueLabel.setBackground(new java.awt.Color(255, 255, 255));
        votesValueLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        votesValueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        votesValueLabel.setLabelFor(votesValueTextField);
        votesValueLabel.setText("Values:");

        votesValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        votesValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votesValueTextFieldActionPerformed(evt);
            }
        });
        votesValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                votesValueTextFieldKeyTyped(evt);
            }
        });

        fromReviewDate.setDateFormatString("yyyy-MM-dd");
        fromReviewDate.setName("");
        fromReviewDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fromReviewDateMouseClicked(evt);
            }
        });
        fromReviewDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                fromReviewDatePropertyChange(evt);
            }
        });

        toReviewDate.setDateFormatString("yyyy-MM-dd");
        toReviewDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                toReviewDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout reviewPanelLayout = new javax.swing.GroupLayout(reviewPanel);
        reviewPanel.setLayout(reviewPanelLayout);
        reviewPanelLayout.setHorizontalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanelLayout.createSequentialGroup()
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromReviewLabel)
                            .addComponent(toReviewLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromReviewDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(toReviewDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanelLayout.createSequentialGroup()
                        .addComponent(starsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(starsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanelLayout.createSequentialGroup()
                        .addComponent(votesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(votesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reviewPanelLayout.createSequentialGroup()
                        .addComponent(votesValueLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(votesValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(reviewPanelLayout.createSequentialGroup()
                        .addComponent(starValueLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(starsValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        reviewPanelLayout.setVerticalGroup(
            reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reviewPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromReviewLabel)
                    .addComponent(fromReviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toReviewLabel)
                    .addComponent(toReviewDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(starsLabel)
                    .addComponent(starsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(starValueLabel)
                    .addComponent(starsValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(votesLabel)
                    .addComponent(votesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reviewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(votesValueLabel)
                    .addComponent(votesValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Result Table");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Sql Query");

        categoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        DefaultListModel<String> listModel = new DefaultListModel<String>();
        jList1.setModel(listModel);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout categoryPanelLayout = new javax.swing.GroupLayout(categoryPanel);
        categoryPanel.setLayout(categoryPanelLayout);
        categoryPanelLayout.setHorizontalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 118, Short.MAX_VALUE))
        );
        categoryPanelLayout.setVerticalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 961, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(categoryPanel);

        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        resultTable.setModel(dtm
        );
        jScrollPane8.setViewportView(resultTable);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        queryLabel.setBackground(new java.awt.Color(255, 255, 255));
        queryLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        queryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        queryLabel.setLabelFor(executeQueryButton);
        queryLabel.setText("");
        queryLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(queryLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 749, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(queryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        jButton2.setBackground(new java.awt.Color(255, 255, 153));
        jButton2.setText("User");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        executeQueryButton.setText("Execute Query");
        executeQueryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executeQueryButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 153));
        jPanel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        noCheckinLabel1.setBackground(new java.awt.Color(255, 255, 255));
        noCheckinLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        noCheckinLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noCheckinLabel1.setLabelFor(fromComboBox);
        noCheckinLabel1.setText("Search For");

        noCheckinLabel2.setBackground(new java.awt.Color(255, 255, 255));
        noCheckinLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        noCheckinLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noCheckinLabel2.setLabelFor(fromComboBox);
        noCheckinLabel2.setText("Point Of Interest");

        noCheckinLabel3.setBackground(new java.awt.Color(255, 255, 255));
        noCheckinLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        noCheckinLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noCheckinLabel3.setLabelFor(fromComboBox);
        noCheckinLabel3.setText("Proximity");

        proximityComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        proximityComboBox.setMaximumRowCount(8);
        proximityComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Miles", "5", "10", "20", "30", "50" }));
        proximityComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proximityComboBoxMouseClicked(evt);
            }
        });
        proximityComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proximityComboBoxActionPerformed(evt);
            }
        });

        searchForComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        searchForComboBox.setMaximumRowCount(8);
        searchForComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Between AND OR", "AND", "OR"}));
        searchForComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchForComboBoxMouseClicked(evt);
            }
        });
        searchForComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchForComboBoxActionPerformed(evt);
            }
        });

        pointOfInterestComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        pointOfInterestComboBox.setMaximumRowCount(8);
        pointOfInterestComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Address", "3799 S Las Vegas Blvd Eastside Las Vegas, NV 89119", "6002 S Durango Dr Ste 100 Spring Valley Las Vegas, NV 89113", "1801 E Baseline Rd, #101 Ste 101 Tempe, AZ 85283", "1033 S Park St Bay Creek Madison, WI 53715", "University Center II Lot Phoenix, AZ 85008"}));
        pointOfInterestComboBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pointOfInterestComboBoxMouseClicked(evt);
            }
        });
        pointOfInterestComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointOfInterestComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noCheckinLabel2)
                    .addComponent(pointOfInterestComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(noCheckinLabel3)
                    .addComponent(proximityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchForComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noCheckinLabel1))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noCheckinLabel2)
                    .addComponent(noCheckinLabel1)
                    .addComponent(noCheckinLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(proximityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchForComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pointOfInterestComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        checkinPanel1.setBackground(new java.awt.Color(255, 255, 255));
        checkinPanel1.setAutoscrolls(true);

        fromLabel1.setBackground(new java.awt.Color(255, 255, 255));
        fromLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        fromLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fromLabel1.setLabelFor(fromComboBox);
        fromLabel1.setText("Member Since");

        toLabel1.setBackground(new java.awt.Color(255, 255, 255));
        toLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLabel1.setLabelFor(toComboBox);
        toLabel1.setText("Review Count");

        memberSinceDateBox.setDateFormatString("yyyy-MM");
        memberSinceDateBox.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                memberSinceDateBoxPropertyChange(evt);
            }
        });

        reviewCountComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<", "=", ">", "<" }));
        reviewCountComboBox.setToolTipText("");
        reviewCountComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewCountComboBoxActionPerformed(evt);
            }
        });

        reviewCountValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        reviewCountValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewCountValueTextFieldActionPerformed(evt);
            }
        });
        reviewCountValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                reviewCountValueTextFieldKeyTyped(evt);
            }
        });

        toLabel2.setBackground(new java.awt.Color(255, 255, 255));
        toLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLabel2.setLabelFor(toComboBox);
        toLabel2.setText("Number of Friends");

        numberOfFriendsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<", "=", ">", "<" }));
        numberOfFriendsComboBox.setToolTipText("");
        numberOfFriendsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfFriendsComboBoxActionPerformed(evt);
            }
        });

        numberOfFriendsValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        numberOfFriendsValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfFriendsValueTextFieldActionPerformed(evt);
            }
        });
        numberOfFriendsValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numberOfFriendsValueTextFieldKeyTyped(evt);
            }
        });

        toLabel3.setBackground(new java.awt.Color(255, 255, 255));
        toLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLabel3.setLabelFor(toComboBox);
        toLabel3.setText("Avg Stars");

        andOrComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"AND,OR between attribute", "AND", "OR" }));
        andOrComboBox.setToolTipText("");
        andOrComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                andOrComboBoxActionPerformed(evt);
            }
        });

        avgStarValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        avgStarValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avgStarValueTextFieldActionPerformed(evt);
            }
        });
        avgStarValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                avgStarValueTextFieldKeyTyped(evt);
            }
        });

        toLabel4.setBackground(new java.awt.Color(255, 255, 255));
        toLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLabel4.setLabelFor(toComboBox);
        toLabel4.setText("Select:");

        avgStarComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<", "=", ">", "<" }));
        avgStarComboBox.setToolTipText("");
        avgStarComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avgStarComboBoxActionPerformed(evt);
            }
        });

        toLabel5.setBackground(new java.awt.Color(255, 255, 255));
        toLabel5.setFont(new java.awt.Font("Comic Sans MS", 0, 16)); // NOI18N
        toLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        toLabel5.setLabelFor(toComboBox);
        toLabel5.setText("Number of Votes");

        numberOfVotesComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Select =,>,<", "=", ">", "<" }));
        numberOfVotesComboBox.setToolTipText("");
        numberOfVotesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberOfVotesComboBoxActionPerformed(evt);
            }
        });

        noOfVotesValueTextField.setPreferredSize(new java.awt.Dimension(78, 26));
        noOfVotesValueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noOfVotesValueTextFieldActionPerformed(evt);
            }
        });
        noOfVotesValueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                noOfVotesValueTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout checkinPanel1Layout = new javax.swing.GroupLayout(checkinPanel1);
        checkinPanel1.setLayout(checkinPanel1Layout);
        checkinPanel1Layout.setHorizontalGroup(
            checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(checkinPanel1Layout.createSequentialGroup()
                        .addComponent(fromLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(memberSinceDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(checkinPanel1Layout.createSequentialGroup()
                        .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(toLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(toLabel1)
                                    .addComponent(toLabel2)
                                    .addComponent(toLabel3)))
                            .addComponent(toLabel5))
                        .addGap(23, 23, 23)
                        .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(checkinPanel1Layout.createSequentialGroup()
                                .addComponent(numberOfVotesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(noOfVotesValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(checkinPanel1Layout.createSequentialGroup()
                                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(reviewCountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numberOfFriendsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(avgStarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85)
                                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(avgStarValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(numberOfFriendsValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reviewCountValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(andOrComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(351, Short.MAX_VALUE))
        );
        checkinPanel1Layout.setVerticalGroup(
            checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkinPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromLabel1)
                    .addComponent(memberSinceDateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel1)
                    .addComponent(reviewCountComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reviewCountValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel2)
                    .addComponent(numberOfFriendsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfFriendsValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel3)
                    .addComponent(avgStarValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avgStarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel5)
                    .addComponent(numberOfVotesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noOfVotesValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(checkinPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(andOrComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(255, 255, 153));
        jButton1.setText("Business");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dbCategoryLayout = new javax.swing.GroupLayout(dbCategory);
        dbCategory.setLayout(dbCategoryLayout);
        dbCategoryLayout.setHorizontalGroup(
            dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dbCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dbCategoryLayout.createSequentialGroup()
                                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(categoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(dbCategoryLayout.createSequentialGroup()
                                        .addComponent(checkinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(reviewPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(dbCategoryLayout.createSequentialGroup()
                                        .addComponent(checkinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addComponent(checkinPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(executeQueryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dbCategoryLayout.setVerticalGroup(
            dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dbCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(executeQueryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dbCategoryLayout.createSequentialGroup()
                        .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dbCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(checkinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(reviewPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkinPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jScrollPane6.setViewportView(dbCategory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1376, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1079, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkinValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinValueTextFieldActionPerformed

    }//GEN-LAST:event_checkinValueTextFieldActionPerformed

    private void starsValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starsValueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_starsValueTextFieldActionPerformed

    private void votesValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votesValueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_votesValueTextFieldActionPerformed

    private void toComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Day") {
            toCheckin = "";
        } else {
            toCheckin = a;
        }
        //System.out.println("Hour checkin :"+toCheckin);
    }//GEN-LAST:event_toComboBoxActionPerformed

    private void fromComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fromComboBoxMouseClicked

    private void fromHourComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromHourComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Time") {
            fromCheckinHour = "";
        } else {
            fromCheckinHour = a;
        }
        //System.out.println("Hour checkin :"+fromCheckinHour);
    }//GEN-LAST:event_fromHourComboBoxActionPerformed

    private void fromComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Day") {
            fromCheckin = "";
        } else {
            fromCheckin = a;
        }
        // System.out.println("From checkin :"+fromCheckin);
    }//GEN-LAST:event_fromComboBoxActionPerformed

    private void toHourComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toHourComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Time") {
            toCheckinHour = "";
        } else {
            toCheckinHour = a;
        }
        //System.out.println("Hour checkin :"+toCheckinHour);
    }//GEN-LAST:event_toHourComboBoxActionPerformed

    private void checkinValueComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkinValueComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operationCheckin = "";
        } else {
            operationCheckin = a;
        }
        //System.out.println("Hour checkin :"+operationCheckin);
    }//GEN-LAST:event_checkinValueComboBoxActionPerformed

    private void checkinValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_checkinValueTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_checkinValueTextFieldKeyTyped

    private void starsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starsComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operationStar = null;
        } else {
            operationStar = a;
        }
        //System.out.println("Hour checkin :"+operationStar);
    }//GEN-LAST:event_starsComboBoxActionPerformed

    private void votesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votesComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operationVote = "";
        } else {
            operationVote = a;
        }
        //System.out.println("Hour checkin :"+operationVote);
    }//GEN-LAST:event_votesComboBoxActionPerformed

    private void starsValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_starsValueTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_starsValueTextFieldKeyTyped

    private void votesValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_votesValueTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_votesValueTextFieldKeyTyped

    private void fromReviewDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fromReviewDateMouseClicked

    }//GEN-LAST:event_fromReviewDateMouseClicked

    private void fromReviewDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_fromReviewDatePropertyChange
        //System.out.println(evt.getNewValue().toString());
        fromReview = ((JTextField) fromReviewDate.getDateEditor().getUiComponent()).getText();
        //System.out.println(fromReview);
    }//GEN-LAST:event_fromReviewDatePropertyChange

    private void toReviewDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_toReviewDatePropertyChange
        toReview = ((JTextField) toReviewDate.getDateEditor().getUiComponent()).getText();
        //System.out.println(toReview);
    }//GEN-LAST:event_toReviewDatePropertyChange

    @SuppressWarnings("empty-statement")
    private void executeQueryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executeQueryButtonActionPerformed

        DefaultTableModel dtm = new DefaultTableModel(0, 0);

        //nothing is selected
        if (finalCat.isEmpty()) {
            if (!Address.isEmpty() && !proximity.isEmpty()) {

                if (Address.contains("3799 S Las Vegas Blvd Eastside Las Vegas, NV 89119")) {
                    longitude = -115.16768879999999;
                    latitude = 36.103017899999998;
                }

                if (Address.equalsIgnoreCase("6002 S Durango Dr Ste 100 Spring Valley Las Vegas, NV 89113")) {
                    longitude = -115.27906539999999;
                    latitude = 36.079256100000002;
                }

                if (Address.equalsIgnoreCase("1801 E Baseline Rd, #101 Ste 101 Tempe, AZ 85283")) {
                    longitude = -111.90860979259;
                    latitude = 33.377052104372098;
                }

                if (Address.equalsIgnoreCase("1033 S Park St Bay Creek Madison, WI 53715")) {
                    longitude = -89.397478300000003;
                    latitude = 43.055539400000001;
                }

                if (Address.equalsIgnoreCase("University Center II Lot Phoenix, AZ 85008")) {
                    longitude = -112.02540759999999;
                    latitude = 33.451857400000002;
                }
                DB dbBusiness = mongoClient.getDB("business");
                DBCollection collBusiness = dbBusiness.getCollection("business");

                BasicDBList geoCoord = new BasicDBList();

                geoCoord.add(longitude);
                geoCoord.add(latitude);

                BasicDBList geoParams = new BasicDBList();
                geoParams.add(geoCoord);
                geoParams.add(Integer.parseInt(proximity) / 1018.59);

                BasicDBObject query = new BasicDBObject("loc",
                        new BasicDBObject("$geoWithin",
                                new BasicDBObject("$center", geoParams)
                        )
                );

                resultTable.setModel(dtm);
                String header[] = new String[]{"B_ID","Business", "City", "State",
                    "Stars"};
                dtm.setColumnIdentifiers(header);
                DBCursor cursorForBusiness = collBusiness.find(query);
                while (cursorForBusiness.hasNext()) {
                    //pointInterest.add(cursorForBusiness.next());
                    Object[] row = new Object[5];
                    row[0] = cursorForBusiness.next().get("business_id");
                    row[1] = cursorForBusiness.next().get("name");
                    row[2] = cursorForBusiness.next().get("city");
                    row[3] = cursorForBusiness.next().get("state");
                    row[4] = cursorForBusiness.next().get("stars");

                    dtm.addRow(row);
                }

            }

            if (!memberSince.isEmpty() || !operReviewCount.isEmpty() || !operNoOfFriends.isEmpty() || !operAvgStar.isEmpty()
                    || !valueReviewCount.isEmpty() || !valueNoOfFriends.isEmpty() || !valueAvgStar.isEmpty() || !andOrAttribute.isEmpty()
                    || !operNoOfVotes.isEmpty() || !valueNoOfVotes.isEmpty()) {

                DB dbUser = mongoClient.getDB("user");
                DBCollection collUser = dbUser.getCollection("user");
                BasicDBObject andQuery = new BasicDBObject();
                List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
                try {
                    if (!memberSince.isEmpty()) {
                        obj.add(new BasicDBObject("yelping_since", memberSince));
                    }
                    if (!valueReviewCount.isEmpty()) {
                        int vrc = Integer.parseInt(valueReviewCount);
                        BasicDBObject rCount = null;
                        if (operReviewCount.equals(">")) {
                            rCount = new BasicDBObject("review_count", new BasicDBObject("$gt", vrc));
                            //rCount = new BasicDBObject("$where", "review_count >" + vrc);
                        }
                        if (operReviewCount.equals("<")) {
                            rCount = new BasicDBObject("review_count", new BasicDBObject("$lt", vrc));
                            //rCount = new BasicDBObject("$where", "review_count <" + vrc);
                        }
                        if (operReviewCount.equals("=")) {
                            rCount = new BasicDBObject("review_count", vrc);
                            // rCount = new BasicDBObject("$where", "review_count =" + vrc);
                        }

                        obj.add(new BasicDBObject(rCount));
                    }
                    if (!valueNoOfFriends.isEmpty()) {
                        int vnf = Integer.parseInt(valueNoOfFriends);
                        BasicDBObject vFriends = null;
                        if (operNoOfFriends.equals(">")) {
                            vFriends = new BasicDBObject("$where", "this.friends.length >" + vnf);
                        }
                        if (operNoOfFriends.equals("<")) {
                            vFriends = new BasicDBObject("$where", "this.friends.length <" + vnf);
                        }
                        if (operNoOfFriends.equals("=")) {
                            vFriends = new BasicDBObject("$where", "this.friends.length =" + vnf);
                        }

                        obj.add(new BasicDBObject(vFriends));
                    }
                    if (!valueAvgStar.isEmpty()) {
                        Double doubleValueAvgStar = Double.parseDouble(valueAvgStar);
                        BasicDBObject avgStarValue = null;
                        if (operAvgStar.equals(">")) {
                            avgStarValue = new BasicDBObject("average_stars", new BasicDBObject("$gt", doubleValueAvgStar));
                            // avgStarValue = new BasicDBObject("$where", "average_stars >" + doubleValueAvgStar);
                        }
                        if (operAvgStar.equals("<")) {
                            avgStarValue = new BasicDBObject("average_stars", new BasicDBObject("$lt", doubleValueAvgStar));
                            // avgStarValue = new BasicDBObject("$where", "average_stars <" + doubleValueAvgStar);
                        }
                        if (operAvgStar.equals("=")) {
                            avgStarValue = new BasicDBObject("average_stars", doubleValueAvgStar);
                            // avgStarValue = new BasicDBObject("$where", "average_stars =" + doubleValueAvgStar);
                        }

                        obj.add(new BasicDBObject(avgStarValue));

                    }
                    if (!valueNoOfVotes.isEmpty()) {
//                                BasicDBObject noOfVotesValue = null;
//                                 if (operNoOfVotes.equals(">")) {
//                            noOfVotesValue = new BasicDBObject("average_stars", new BasicDBObject("$gt", valueNoOfVotes));
//                        }
//                        if (operNoOfVotes.equals("<")) {
//                            noOfVotesValue = new BasicDBObject("average_stars", new BasicDBObject("$lt", valueNoOfVotes));
//                        }
//                        if (operNoOfVotes.equals("=")) {
//                            noOfVotesValue = new BasicDBObject("average_stars", new BasicDBObject("$eq", valueNoOfVotes));
//                        }   
//                        
//                        obj.add(new BasicDBObject(noOfVotesValue));

                    }
                    System.out.println(andOrAttribute);
                    if (andOrAttribute.equalsIgnoreCase("AND")) {
                        System.out.println("Here");
                        andQuery.put("$and", obj);
                    } else {
                        andQuery.put("$or", obj);
                    }
                    queryLabel.setText("<html><p>" + andQuery.toString() + "</p></html>");
                    List<DBObject> outputMyList = new ArrayList<DBObject>();
                    DBCursor cursor = collUser.find(andQuery);
                    while (cursor.hasNext()) {
                        //System.out.println(cursor.next());
                        outputMyList.add(cursor.next());
                    }

                    resultTable.setModel(dtm);
                    String header[] = new String[]{"U_ID","User Name", "Yelping Since", "Avg Stars",
                        "Review Count"};
                    // add header in table model     
                    dtm.setColumnIdentifiers(header);
                    for (DBObject temp : outputMyList) {
                        //System.out.println("Business Name : " + temp.get("name") + " Category :  " + temp.get("categories"));
                        Object[] row = new Object[5];
                        row[0] = temp.get("user_id");
                        row[1] = temp.get("name");
                        row[2] = temp.get("yelping_since");
                        row[3] = temp.get("average_stars");
                        row[4] = temp.get("review_count");

                        dtm.addRow(row);
                    }

                } catch (Exception e) {

                }

            } else {
                queryLabel.setText("Please select atleast one category from business");
            }
        } //only cat selected
        //////////////////////////Business//////////////////////////////////////////////////////////
        if (finalCat.size() > 0) {
            DB dbBusiness = mongoClient.getDB("business");
            DBCollection collBusiness = dbBusiness.getCollection("business");
            if (!fromCheckin.isEmpty() && !fromCheckinHour.isEmpty() && !toCheckin.isEmpty() && !toCheckinHour.isEmpty()
                    && !operationCheckin.isEmpty() && !valueCheckin.isEmpty()) {
                DB dbCheckin = mongoClient.getDB("checkin");
                DBCollection collCheckin = dbCheckin.getCollection("checkin");

                if (!fromReview.isEmpty() && !toReview.isEmpty() && !operationStar.isEmpty() && !valueStar.isEmpty()
                        && !operationVote.isEmpty() && !valueVote.isEmpty()) {
                    //////////////////////Category, Checkin and Review///////////////////////////////////////////////////
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
                    String fromDate1 = fromReview;
                    String fromdate = fromDate1 + "T00:00:00Z";
                    String toDate1 = toReview;
                    String todate = toDate1 + "T00:00:00Z";
                    int starValue = Integer.parseInt(valueStar);
                    int voteValue = Integer.parseInt(valueVote);
                    StringBuffer finalQuery = new StringBuffer();
                    DB dbReview = mongoClient.getDB("review");
                    DBCollection collReview = dbReview.getCollection("review");
                    int j = 0;
                    int l = 0;

                    HashMap<String, Integer> tempCheckin = new HashMap<String, Integer>();
                    ArrayList<String> finalCheckinBid = new ArrayList<String>();

                    ArrayList<CheckinDetail> checkinList = new ArrayList<CheckinDetail>();
                    //System.out.println("I am in checkin box");
                    String[] arrayDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
                    for (int i = 0; i < arrayDays.length; i++) {
                        if (fromCheckin == arrayDays[i]) {
                            j = i;
                        } else if (toCheckin == arrayDays[i]) {
                            l = i;
                        }
                    }
                    ArrayList<Integer> days = new ArrayList<Integer>();
                    days.add(j);
                    int temfromday = j;
                    days.add(l);

                    int difference = CheckForDay(fromCheckin, toCheckin);
                    if (difference > 0) {
                        for (int k = 0; k < difference; k++) {
                            j = j + 1;
                            if (j == 7) {
                                j = 0;
                            }
                            days.add(j);

                        }
                    }
                    List<DBObject> categoryIdList = new ArrayList<DBObject>();
                    for (String t : finalCat) {
                        BasicDBObject whereQueryBusiness = new BasicDBObject();
                        BasicDBObject fieldsBusiness = new BasicDBObject();
                        fieldsBusiness.put("business_id", 1);
                        whereQueryBusiness.put("categories", t);
                        DBCursor cursorForBusiness = collBusiness.find(whereQueryBusiness, fieldsBusiness);
                        finalQuery.append(whereQueryBusiness);
                        while (cursorForBusiness.hasNext()) {
                            int i = 1;
                            categoryIdList.add(cursorForBusiness.next());
                            i++;
                        }
                    }//for FINALCAT
                    List<DBObject> checkinCategoryIdList = new ArrayList<DBObject>();
                    for (DBObject s : categoryIdList) {
                        //System.out.println(s.get("business_id"));
                        BasicDBObject whereQueryCheckin = new BasicDBObject();
                        whereQueryCheckin.put("business_id", s.get("business_id"));
                        DBCursor cursorForCheckin = collCheckin.find(whereQueryCheckin);
                        while (cursorForCheckin.hasNext()) {
                            int i = 1;
                            checkinCategoryIdList.add(cursorForCheckin.next());
                            i++;
                        }
                    }//for DBObject s:categoryIdList
                    for (DBObject u : checkinCategoryIdList) {
                        String full = u.get("checkin_info").toString();
                        String a = full.replaceAll("[{}]", "");
                        String[] b = a.split(",");
                        for (int x = 0; x < b.length; x++) {
                            CheckinDetail objCheckin = new CheckinDetail();
                            String[] c = b[x].split(":");

                            String d = c[0].replaceAll("[\"]", "");
                            String[] e = d.split("-");
                            objCheckin.b_Id = u.get("business_id").toString();
                            objCheckin.fromTime = Integer.parseInt(e[0].replaceAll("\\s+", ""));
                            objCheckin.checkinDay = Integer.parseInt(e[1].replaceAll("\\s+", ""));
                            objCheckin.CountValue = Integer.parseInt(c[1].replaceAll("\\s+", ""));;
                            checkinList.add(objCheckin);
                        }
                    }

                    for (CheckinDetail e : checkinList) {
                        for (int f : days) {
                            if ((f == temfromday && temfromday == e.checkinDay && Integer.parseInt(fromCheckinHour) <= e.fromTime)
                                    || (f == l && l == e.checkinDay && Integer.parseInt(toCheckinHour) >= e.fromTime)
                                    || (f == e.checkinDay && f != temfromday && f != l)) {
//                                    System.out.println(e.b_Id);
//                                    System.out.println(e.CountValue);
                                if (tempCheckin.containsKey(e.b_Id)) {
                                    tempCheckin.put(e.b_Id, tempCheckin.get(e.b_Id) + e.CountValue);
                                } else {
                                    tempCheckin.put(e.b_Id, e.CountValue);
                                }

                            }
                        }
                    }

                    Iterator itr = tempCheckin.entrySet().iterator();
                    while (itr.hasNext()) {
                        Map.Entry entry = (Map.Entry) itr.next();
                        if ((operationCheckin.contains("="))) {
                            if (entry.getValue() == valueCheckin) {
                                finalCheckinBid.add(entry.getKey().toString());
                            }
                        }
                        if ((operationCheckin.contains("<"))) {
                            if (Integer.parseInt(entry.getValue().toString()) < Integer.parseInt(valueCheckin)) {
                                finalCheckinBid.add(entry.getKey().toString());
                                //System.out.println("in <");
                            }
                        }
                        if ((operationCheckin.contains(">"))) {
                            if (Integer.parseInt(entry.getValue().toString()) > Integer.parseInt(valueCheckin)) {
                                finalCheckinBid.add(entry.getKey().toString());
                                //System.out.println("in >");
                            }
                        }
                    }
                    //abhi tak ki bid is in finalCheckinBid
//                    for(String a :finalCheckinBid){
//                    System.out.println(a);
//                    }
                    finalQuery.append("Stage{name='$match', value=Or Filter{filters=[Operator Filter{fieldName='checkin_info.2-3', operator='$exists', value=BsonBoolean{value=true}}, Operator Filter{fieldName='checkin_info.2-4', operator='$exists', value=BsonBoolean{value=true}}]}}\n"
                            + "Document{{$group=Document{{_id=$business_id, total1=Document{{$sum=$checkin_info.2-4}}, total2=Document{{$sum=$checkin_info.2-3}}}}}}\n"
                            + "Stage{name='$match', value=Operator Filter{fieldName='totalCheckins', operator='$gt', value=4}}");
                    try {
                        List<Object> reviewCategoryIdList = new ArrayList<Object>();

                        DBObject match = new BasicDBObject("$match",
                                new BasicDBObject("date",
                                        new BasicDBObject("$gt", format.parse(fromdate)).append("$lt", format.parse(todate))));

                        DBObject groupFields = new BasicDBObject("_id", "$business_id");
                        groupFields.put("total1", new BasicDBObject("$sum", "$votes.funny"));
                        groupFields.put("total2", new BasicDBObject("$sum", "$votes.useful"));
                        groupFields.put("total3", new BasicDBObject("$sum", "$votes.cool"));
                        groupFields.put("totalStars", new BasicDBObject("$sum", "$stars"));
                        DBObject group = new BasicDBObject("$group", groupFields);

                        DBObject fields = new BasicDBObject("_id", 1);
                        BasicDBList addFields = new BasicDBList();
                        addFields.add("$total1");
                        addFields.add("$total2");
                        addFields.add("$total3");
                        fields.put("totalVotes", new BasicDBObject("$sum", addFields));
                        fields.put("totalStars", 1);
                        DBObject project = new BasicDBObject("$project", fields);
                        BasicDBObject votes = null;
                        BasicDBObject stars = null;
                        if (operationStar.equals(">")) {
                            stars = new BasicDBObject("totalStars", new BasicDBObject("$gt", starValue));
                        }
                        if (operationStar.equals("<")) {
                            stars = new BasicDBObject("totalStars", new BasicDBObject("$lt", starValue));
                        }
                        if (operationStar.equals("=")) {
                            stars = new BasicDBObject("totalStars", new BasicDBObject("$eq", starValue));
                        }
                        if (operationVote.equals(">")) {
                            votes = new BasicDBObject("totalVotes", new BasicDBObject("$gt", voteValue));
                        }
                        if (operationVote.equals("<")) {
                            votes = new BasicDBObject("totalVotes", new BasicDBObject("$lt", voteValue));
                        }
                        if (operationVote.equals("=")) {
                            votes = new BasicDBObject("totalVotes", new BasicDBObject("$eq", voteValue));
                        }
                        List<BasicDBObject> list1 = new ArrayList<BasicDBObject>();
                        list1.add(new BasicDBObject(votes));
                        list1.add(new BasicDBObject(stars));
                        DBObject votesnStars = new BasicDBObject("$and", list1);
                        DBObject match2 = new BasicDBObject("$match", votesnStars);

                        AggregationOutput cursorForReview = collReview.aggregate(match, group, project, match2);
                        String query33 = match + "\n" + group + "\n" + project + "\n" + match2;
                        finalQuery.append(query33);

                        Iterable<DBObject> list = cursorForReview.results();
                        Iterator<DBObject> resultSet1 = list.iterator();
                        while (resultSet1.hasNext()) {
//                            System.out.println(resultSet1.next().get("_id"));
                            reviewCategoryIdList.add(resultSet1.next().get("_id"));
                        }
//                            System.out.println(reviewCategoryIdList.size());
//                            System.out.println(finalCheckinBid.size());
                        reviewCategoryIdList.retainAll(finalCheckinBid);
//                            System.out.println(reviewCategoryIdList.size());
//                        for (Object s : reviewCategoryIdList) { 
//                        System.out.println(s.toString());
//                        }

                        if (!Address.isEmpty() && !proximity.isEmpty()) {

                            if (Address.contains("3799 S Las Vegas Blvd Eastside Las Vegas, NV 89119")) {
                                longitude = -115.16768879999999;
                                latitude = 36.103017899999998;
                            }

                            if (Address.equalsIgnoreCase("6002 S Durango Dr Ste 100 Spring Valley Las Vegas, NV 89113")) {
                                longitude = -115.27906539999999;
                                latitude = 36.079256100000002;
                            }

                            if (Address.equalsIgnoreCase("1801 E Baseline Rd, #101 Ste 101 Tempe, AZ 85283")) {
                                longitude = -111.90860979259;
                                latitude = 33.377052104372098;
                            }

                            if (Address.equalsIgnoreCase("1033 S Park St Bay Creek Madison, WI 53715")) {
                                longitude = -89.397478300000003;
                                latitude = 43.055539400000001;
                            }

                            if (Address.equalsIgnoreCase("University Center II Lot Phoenix, AZ 85008")) {
                                longitude = -112.02540759999999;
                                latitude = 33.451857400000002;
                            }

                            List<String> pointInterest = new ArrayList<String>();
                            BasicDBList geoCoord = new BasicDBList();

                            geoCoord.add(longitude);
                            geoCoord.add(latitude);

                            BasicDBList geoParams = new BasicDBList();
                            geoParams.add(geoCoord);
                            geoParams.add(Integer.parseInt(proximity) / 1018.59);

                            BasicDBObject query = new BasicDBObject("loc",
                                    new BasicDBObject("$geoWithin",
                                            new BasicDBObject("$center", geoParams)
                                    )
                            );

                            DBCursor cursorForBusiness = collBusiness.find(query);
                            finalQuery.append(query);
                            while (cursorForBusiness.hasNext()) {
                                pointInterest.add(cursorForBusiness.next().get("business_id").toString());

                            }
//                System.out.println(pointInterest.size());
//                System.out.println(reviewCategoryIdList.size());
                            reviewCategoryIdList.retainAll(pointInterest);
//                System.out.println(reviewCategoryIdList.size());
                        }

                        List<DBObject> outputMyList = new ArrayList<DBObject>();
                        BasicDBObject whereQuery = new BasicDBObject();
                        for (Object fianlBid2 : reviewCategoryIdList) {
//                        System.out.println(fianlBid2);
                            whereQuery.put("business_id", fianlBid2.toString());
                            DBCursor cursor = collBusiness.find(whereQuery);
                            while (cursor.hasNext()) {
                                //System.out.println(cursor.next());
                                outputMyList.add(cursor.next());
                            }
                        }
                        queryLabel.setText("<html><p>" + finalQuery + "</p></html>");
                        resultTable.setModel(dtm);
                        String header[] = new String[]{"B_ID","Business", "City", "State",
                            "Stars"};
                        // add header in table model     
                        dtm.setColumnIdentifiers(header);
                        for (DBObject temp : outputMyList) {
                            //System.out.println("Business Name : " + temp.get("name") + " Category :  " + temp.get("categories"));
                            Object[] row = new Object[5];
                            row[0] = temp.get("business_id");
                            row[1] = temp.get("name");
                            row[2] = temp.get("city");
                            row[3] = temp.get("state");
                            row[4] = temp.get("stars");

                            dtm.addRow(row);
                        }
                    } catch (Exception e) {

                    }
                }//review if
                ///////////////////////////////Category and Checkin///////////////////////////////
                else {//Check in with cat not review
                    int j = 0;
                    int l = 0;

                    HashMap<String, Integer> tempCheckin = new HashMap<String, Integer>();
                    ArrayList<String> finalCheckinBid = new ArrayList<String>();
                    StringBuffer finalQueryCatCheck = new StringBuffer();
                    ArrayList<CheckinDetail> checkinList = new ArrayList<CheckinDetail>();
                    //System.out.println("I am in checkin box");
                    String[] arrayDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
                    for (int i = 0; i < arrayDays.length; i++) {
                        if (fromCheckin == arrayDays[i]) {
                            j = i;
                        } else if (toCheckin == arrayDays[i]) {
                            l = i;
                        }
                    }
                    ArrayList<Integer> days = new ArrayList<Integer>();
                    days.add(j);
                    int temfromday = j;
                    days.add(l);

//                         System.out.println("Input Data "+j+"  "+fromCheckinHour+"  "+toCheckin+"  "+toCheckinHour+" "+
//                                        operationCheckin+"  "+valueCheckin);
//               System.out.println(j);         
                    int difference = CheckForDay(fromCheckin, toCheckin);
                    if (difference > 0) {
                        for (int k = 0; k < difference; k++) {
                            j = j + 1;
                            if (j == 7) {
                                j = 0;
                            }
                            days.add(j);

                        }
                    }
//                        for(int q:days){
//                        System.out.println(q);
//                        }

                    List<DBObject> categoryIdList = new ArrayList<DBObject>();
                    for (String t : finalCat) {
                        BasicDBObject whereQueryBusiness = new BasicDBObject();
                        BasicDBObject fieldsBusiness = new BasicDBObject();
                        fieldsBusiness.put("business_id", 1);
                        whereQueryBusiness.put("categories", t);
                        DBCursor cursorForBusiness = collBusiness.find(whereQueryBusiness, fieldsBusiness);
                        finalQueryCatCheck.append(whereQueryBusiness);
                        while (cursorForBusiness.hasNext()) {
                            int i = 1;
                            categoryIdList.add(cursorForBusiness.next());
                            i++;
                        }
                    }//for FINALCAT
                    List<DBObject> checkinCategoryIdList = new ArrayList<DBObject>();
                    for (DBObject s : categoryIdList) {
                        //System.out.println(s.get("business_id"));
                        BasicDBObject whereQueryCheckin = new BasicDBObject();
                        whereQueryCheckin.put("business_id", s.get("business_id"));
                        DBCursor cursorForCheckin = collCheckin.find(whereQueryCheckin);
                        while (cursorForCheckin.hasNext()) {
                            int i = 1;
                            checkinCategoryIdList.add(cursorForCheckin.next());
                            i++;
                        }
                    }//for DBObject s:categoryIdList
                    for (DBObject u : checkinCategoryIdList) {
//                                System.out.println(s.get("business_id"));    
//                                System.out.println(u.get("checkin_info").toString());

                        String full = u.get("checkin_info").toString();
                        String a = full.replaceAll("[{}]", "");
                        String[] b = a.split(",");
                        for (int x = 0; x < b.length; x++) {
                            CheckinDetail objCheckin = new CheckinDetail();
                            String[] c = b[x].split(":");

                            String d = c[0].replaceAll("[\"]", "");
                            String[] e = d.split("-");
                            objCheckin.b_Id = u.get("business_id").toString();
//                                        System.out.println(u.get("business_id").toString());
//                                        System.out.println(e[0]);//from time
                            objCheckin.fromTime = Integer.parseInt(e[0].replaceAll("\\s+", ""));
//                                        System.out.println(e[1]);//day
                            objCheckin.checkinDay = Integer.parseInt(e[1].replaceAll("\\s+", ""));
//                                        System.out.println(c[1]);//value
                            objCheckin.CountValue = Integer.parseInt(c[1].replaceAll("\\s+", ""));;
                            checkinList.add(objCheckin);
                            //System.out.println(checkinList.size());
                        }
                    }

                    for (CheckinDetail e : checkinList) {

                        for (int f : days) {

                            if ((f == temfromday && temfromday == e.checkinDay && Integer.parseInt(fromCheckinHour) <= e.fromTime)
                                    || (f == l && l == e.checkinDay && Integer.parseInt(toCheckinHour) >= e.fromTime)
                                    || (f == e.checkinDay && f != temfromday && f != l)) {
//                                    System.out.println(e.b_Id);
//                                    System.out.println(e.CountValue);
                                if (tempCheckin.containsKey(e.b_Id)) {
                                    tempCheckin.put(e.b_Id, tempCheckin.get(e.b_Id) + e.CountValue);
                                } else {
                                    tempCheckin.put(e.b_Id, e.CountValue);
                                }

                            }
                        }
                    }

                    Iterator itr = tempCheckin.entrySet().iterator();
                    while (itr.hasNext()) {
                        Map.Entry entry = (Map.Entry) itr.next();
                        if ((operationCheckin.contains("="))) {
                            if (entry.getValue() == valueCheckin) {
                                finalCheckinBid.add(entry.getKey().toString());
                            }
                        }
                        if ((operationCheckin.contains("<"))) {
                            if (Integer.parseInt(entry.getValue().toString()) < Integer.parseInt(valueCheckin)) {
                                finalCheckinBid.add(entry.getKey().toString());
                                //System.out.println("in <");
                            }
                        }
                        if ((operationCheckin.contains(">"))) {
                            if (Integer.parseInt(entry.getValue().toString()) > Integer.parseInt(valueCheckin)) {
                                finalCheckinBid.add(entry.getKey().toString());
                                //System.out.println("in >");
                            }
                        }

//                            
                    }
                    finalQueryCatCheck.append("Stage{name='$match', value=Or Filter{filters=[Operator Filter{fieldName='checkin_info.2-3', operator='$exists', value=BsonBoolean{value=true}}, Operator Filter{fieldName='checkin_info.2-4', operator='$exists', value=BsonBoolean{value=true}}]}}\n"
                            + "Document{{$group=Document{{_id=$business_id, total1=Document{{$sum=$checkin_info.2-4}}, total2=Document{{$sum=$checkin_info.2-3}}}}}}\n"
                            + "Stage{name='$match', value=Operator Filter{fieldName='totalCheckins', operator='$gt', value=4}}");
                    if (!Address.isEmpty() && !proximity.isEmpty()) {

                        if (Address.contains("3799 S Las Vegas Blvd Eastside Las Vegas, NV 89119")) {
                            longitude = -115.16768879999999;
                            latitude = 36.103017899999998;
                        }

                        if (Address.equalsIgnoreCase("6002 S Durango Dr Ste 100 Spring Valley Las Vegas, NV 89113")) {
                            longitude = -115.27906539999999;
                            latitude = 36.079256100000002;
                        }

                        if (Address.equalsIgnoreCase("1801 E Baseline Rd, #101 Ste 101 Tempe, AZ 85283")) {
                            longitude = -111.90860979259;
                            latitude = 33.377052104372098;
                        }

                        if (Address.equalsIgnoreCase("1033 S Park St Bay Creek Madison, WI 53715")) {
                            longitude = -89.397478300000003;
                            latitude = 43.055539400000001;
                        }

                        if (Address.equalsIgnoreCase("University Center II Lot Phoenix, AZ 85008")) {
                            longitude = -112.02540759999999;
                            latitude = 33.451857400000002;
                        }

                        List<String> pointInterest = new ArrayList<String>();
                        BasicDBList geoCoord = new BasicDBList();

                        geoCoord.add(longitude);
                        geoCoord.add(latitude);

                        BasicDBList geoParams = new BasicDBList();
                        geoParams.add(geoCoord);
                        geoParams.add(Integer.parseInt(proximity) / 1018.59);

                        BasicDBObject query = new BasicDBObject("loc",
                                new BasicDBObject("$geoWithin",
                                        new BasicDBObject("$center", geoParams)
                                )
                        );

                        DBCursor cursorForBusiness = collBusiness.find(query);
                        finalQueryCatCheck.append(query);
                        while (cursorForBusiness.hasNext()) {
                            pointInterest.add(cursorForBusiness.next().get("business_id").toString());

                        }
//                System.out.println(pointInterest.size());
//                System.out.println(reviewCategoryIdList.size());
                        finalCheckinBid.retainAll(pointInterest);
//                System.out.println(reviewCategoryIdList.size());
                    }

                    resultTable.setModel(dtm);
                    queryLabel.setText("<html><p>" + finalQueryCatCheck.toString() + "</p></html>");
                    String header[] = new String[]{"B_ID","Business", "City", "State",
                        "Stars"};

                    // add header in table model     
                    dtm.setColumnIdentifiers(header);
                    List<DBObject> outputMyList = new ArrayList<DBObject>();
                    BasicDBObject whereQuery = new BasicDBObject();
                    for (String fianlBid2 : finalCheckinBid) {
                        whereQuery.put("business_id", fianlBid2);
                        DBCursor cursor = collBusiness.find(whereQuery);
                        while (cursor.hasNext()) {
                            int i = 1;
                            //System.out.println(cursor.next());
                            outputMyList.add(cursor.next());
                            i++;
                        }
                    }

                    for (DBObject temp : outputMyList) {
                        //System.out.println("Business Name : " + temp.get("name") + " Category :  " + temp.get("categories"));
                        Object[] row = new Object[5];
                        row[0] = temp.get("business_id");
                        row[1] = temp.get("name");
                        row[2] = temp.get("city");
                        row[3] = temp.get("state");
                        row[4] = temp.get("stars");

                        dtm.addRow(row);
                    }
                    // }
                }//else with no review
            }//if for entire checkin check
            else {//only cat

/////////////////////////////////////////Cat N Review/////////////////////////////////////////////////////////////////////
                if (!fromReview.isEmpty() && !toReview.isEmpty() && !operationStar.isEmpty() && !valueStar.isEmpty()
                        && !operationVote.isEmpty() && !valueVote.isEmpty()) {
                    StringBuffer finalQueryCatReview = new StringBuffer();
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
                    String fromDate1 = fromReview;
                    String fromdate = fromDate1 + "T00:00:00Z";
                    String toDate1 = toReview;
                    String todate = toDate1 + "T00:00:00Z";
                    int starValue = Integer.parseInt(valueStar);
                    //int voteValue = 4;
                    int voteValue = Integer.parseInt(valueVote);
                    DB dbReview = mongoClient.getDB("review");
                    DBCollection collReview = dbReview.getCollection("review");

                    //abhi tak ki bid is in finalCheckinBid
//                    for(String a :finalCheckinBid){
//                    System.out.println(a);
//                    }
                    try {
                        List<Object> finalCatBid = new ArrayList<Object>();
                        List<Object> reviewCategoryIdList = new ArrayList<Object>();
                        for (String a : finalCat) {

                            BasicDBObject whereQueryBusinessReview = new BasicDBObject();
                            //System.out.println(a);
                            whereQueryBusinessReview.put("categories", a);
                            DBCursor cursor = collBusiness.find(whereQueryBusinessReview);
                            finalQueryCatReview.append(whereQueryBusinessReview);
                            while (cursor.hasNext()) {
                                int i = 1;
                                //System.out.println(cursor.next());
                                finalCatBid.add(cursor.next().get("business_id"));
                                i++;
                            }
                        }
                        DBObject match = new BasicDBObject("$match",
                                new BasicDBObject("date",
                                        new BasicDBObject("$gt", format.parse(fromdate)).append("$lt", format.parse(todate))));

                        DBObject groupFields = new BasicDBObject("_id", "$business_id");
                        groupFields.put("total1", new BasicDBObject("$sum", "$votes.funny"));
                        groupFields.put("total2", new BasicDBObject("$sum", "$votes.useful"));
                        groupFields.put("total3", new BasicDBObject("$sum", "$votes.cool"));
                        groupFields.put("totalStars", new BasicDBObject("$sum", "$stars"));
                        DBObject group = new BasicDBObject("$group", groupFields);

                        DBObject fields = new BasicDBObject("_id", 1);
                        BasicDBList addFields = new BasicDBList();
                        addFields.add("$total1");
                        addFields.add("$total2");
                        addFields.add("$total3");
                        fields.put("totalVotes", new BasicDBObject("$sum", addFields));
                        fields.put("totalStars", 1);
                        DBObject project = new BasicDBObject("$project", fields);
                        BasicDBObject votes = null;
                        BasicDBObject stars = null;
                        if (operationStar.equals(">")) {
                            stars = new BasicDBObject("totalStars", new BasicDBObject("$gt", starValue));
                        }
                        if (operationStar.equals("<")) {
                            stars = new BasicDBObject("totalStars", new BasicDBObject("$lt", starValue));
                        }
                        if (operationStar.equals("=")) {
                            stars = new BasicDBObject("totalStars", new BasicDBObject("$eq", starValue));
                        }
                        if (operationVote.equals(">")) {
                            votes = new BasicDBObject("totalVotes", new BasicDBObject("$gt", voteValue));
                        }
                        if (operationVote.equals("<")) {
                            votes = new BasicDBObject("totalVotes", new BasicDBObject("$lt", voteValue));
                        }
                        if (operationVote.equals("=")) {
                            votes = new BasicDBObject("totalVotes", new BasicDBObject("$eq", voteValue));
                        }
                        List<BasicDBObject> list1 = new ArrayList<BasicDBObject>();
                        list1.add(new BasicDBObject(votes));
                        list1.add(new BasicDBObject(stars));
                        DBObject votesnStars = new BasicDBObject("$and", list1);
                        DBObject match2 = new BasicDBObject("$match", votesnStars);

                        AggregationOutput cursorForReview = collReview.aggregate(match, group, project, match2);
                        String query33 = match + "\n" + group + "\n" + project + "\n" + match2;
                        finalQueryCatReview.append(query33);
                        Iterable<DBObject> list = cursorForReview.results();
                        Iterator<DBObject> resultSet1 = list.iterator();
                        while (resultSet1.hasNext()) {
//                            System.out.println(resultSet1.next().get("_id"));
                            reviewCategoryIdList.add(resultSet1.next().get("_id"));
                        }
                        //System.out.println(reviewCategoryIdList.size());
                        //System.out.println(finalCatBid.size());
                        reviewCategoryIdList.retainAll(finalCatBid);
                        //System.out.println(reviewCategoryIdList.size());
//                        for (Object s : reviewCategoryIdList) { 
//                        System.out.println(s.toString());
//                        }
                        if (!Address.isEmpty() && !proximity.isEmpty()) {

                            if (Address.contains("3799 S Las Vegas Blvd Eastside Las Vegas, NV 89119")) {
                                longitude = -115.16768879999999;
                                latitude = 36.103017899999998;
                            }

                            if (Address.equalsIgnoreCase("6002 S Durango Dr Ste 100 Spring Valley Las Vegas, NV 89113")) {
                                longitude = -115.27906539999999;
                                latitude = 36.079256100000002;
                            }

                            if (Address.equalsIgnoreCase("1801 E Baseline Rd, #101 Ste 101 Tempe, AZ 85283")) {
                                longitude = -111.90860979259;
                                latitude = 33.377052104372098;
                            }

                            if (Address.equalsIgnoreCase("1033 S Park St Bay Creek Madison, WI 53715")) {
                                longitude = -89.397478300000003;
                                latitude = 43.055539400000001;
                            }

                            if (Address.equalsIgnoreCase("University Center II Lot Phoenix, AZ 85008")) {
                                longitude = -112.02540759999999;
                                latitude = 33.451857400000002;
                            }

                            List<String> pointInterest = new ArrayList<String>();
                            BasicDBList geoCoord = new BasicDBList();

                            geoCoord.add(longitude);
                            geoCoord.add(latitude);

                            BasicDBList geoParams = new BasicDBList();
                            geoParams.add(geoCoord);
                            geoParams.add(Integer.parseInt(proximity) / 1018.59);

                            BasicDBObject query = new BasicDBObject("loc",
                                    new BasicDBObject("$geoWithin",
                                            new BasicDBObject("$center", geoParams)
                                    )
                            );

                            DBCursor cursorForBusiness = collBusiness.find(query);
                            finalQueryCatReview.append(query);
                            while (cursorForBusiness.hasNext()) {
                                pointInterest.add(cursorForBusiness.next().get("business_id").toString());

                            }
//                System.out.println(pointInterest.size());
//                System.out.println(reviewCategoryIdList.size());
                            reviewCategoryIdList.retainAll(pointInterest);
//                System.out.println(reviewCategoryIdList.size());
                        }
                        queryLabel.setText("<html><p>" + finalQueryCatReview.toString() + "</p></html>");
                        resultTable.setModel(dtm);

                        String header[] = new String[]{"B_ID","Business", "City", "State",
                            "Stars"};

                        // add header in table model     
                        dtm.setColumnIdentifiers(header);
                        List<DBObject> outputMyList = new ArrayList<DBObject>();
                        for (Object fianlBid2 : reviewCategoryIdList) {
                            BasicDBObject whereQuery = new BasicDBObject();

//                        System.out.println(fianlBid2);
                            whereQuery.put("business_id", fianlBid2.toString());
                            DBCursor cursor = collBusiness.find(whereQuery);
                            while (cursor.hasNext()) {
                                //System.out.println(cursor.next());
                                outputMyList.add(cursor.next());
                            }
                        }

                        for (DBObject temp : outputMyList) {
                            //System.out.println("Business Name : " + temp.get("name") + " Category :  " + temp.get("categories"));
                            Object[] row = new Object[5];
                            row[0] = temp.get("business_id");
                            row[1] = temp.get("name");
                            row[2] = temp.get("city");
                            row[3] = temp.get("state");
                            row[4] = temp.get("stars");

                            dtm.addRow(row);
                        }
                    } catch (Exception e) {

                    }
                } //////////////////////////////////////Only Category ////////////////////////////////////////////
                else {
                    resultTable.setModel(dtm);
                    String header[] = new String[]{"B_ID","Business", "City", "State",
                        "Stars", "Category"};
                    // add header in table model     
                    dtm.setColumnIdentifiers(header);
                    StringBuffer catOnly = new StringBuffer();
                    if (!Address.isEmpty() && !proximity.isEmpty() && finalCat.size() > 0) {
                        if (Address.contains("3799 S Las Vegas Blvd Eastside Las Vegas, NV 89119")) {
                            longitude = -115.16768879999999;
                            latitude = 36.103017899999998;
                        }

                        if (Address.equalsIgnoreCase("6002 S Durango Dr Ste 100 Spring Valley Las Vegas, NV 89113")) {
                            longitude = -115.27906539999999;
                            latitude = 36.079256100000002;
                        }

                        if (Address.equalsIgnoreCase("1801 E Baseline Rd, #101 Ste 101 Tempe, AZ 85283")) {
                            longitude = -111.90860979259;
                            latitude = 33.377052104372098;
                        }

                        if (Address.equalsIgnoreCase("1033 S Park St Bay Creek Madison, WI 53715")) {
                            longitude = -89.397478300000003;
                            latitude = 43.055539400000001;
                        }

                        if (Address.equalsIgnoreCase("University Center II Lot Phoenix, AZ 85008")) {
                            longitude = -112.02540759999999;
                            latitude = 33.451857400000002;
                        }
                        //BasicDBList category = new BasicDBList();
                        for (String a : finalCat) {

                            BasicDBObject andQuery = new BasicDBObject();
                            List<BasicDBObject> obj = new ArrayList<BasicDBObject>();

                            List<DBObject> pointInterest = new ArrayList<DBObject>();
                            BasicDBList geoCoord = new BasicDBList();

                            geoCoord.add(longitude);
                            geoCoord.add(latitude);

                            BasicDBList geoParams = new BasicDBList();
                            geoParams.add(geoCoord);
                            geoParams.add(Integer.parseInt(proximity) / 1018.59);

                            BasicDBObject query = new BasicDBObject("loc",
                                    new BasicDBObject("$geoWithin",
                                            new BasicDBObject("$center", geoParams)
                                    )
                            );
                            obj.add(query);
                            obj.add(new BasicDBObject("categories", a));
                            andQuery.put("$and", obj);
                            System.out.println(andQuery);
                            DBCursor cursorForBusiness = collBusiness.find(andQuery);
                            catOnly.append(andQuery);
                            while (cursorForBusiness.hasNext()) {
                                pointInterest.add(cursorForBusiness.next());

                            }
                            for (DBObject temp : pointInterest) {

                                Object[] row = new Object[6];
                                row[0] = temp.get("business_id");
                                row[1] = temp.get("name");
                                row[2] = temp.get("city");
                                row[3] = temp.get("state");
                                row[4] = temp.get("stars");
                                row[5] = a;

                                dtm.addRow(row);
                            }
                        }
                    } else {
                        List<DBObject> testMyList = new ArrayList<DBObject>();
                        for (String a : finalCat) {
                            BasicDBObject whereQuery = new BasicDBObject();
                            //System.out.println(a);
                            whereQuery.put("categories", a);
                            DBCursor cursor = collBusiness.find(whereQuery);
                            catOnly.append(whereQuery);
                            while (cursor.hasNext()) {
                                testMyList.add(cursor.next());

                            }

                            for (DBObject temp : testMyList) {
                                //System.out.println("Business Name : " + temp.get("name") + " Category :  " + temp.get("categories"));
                                Object[] row = new Object[6];
                                row[0] = temp.get("business_id");
                                row[1] = temp.get("name");
                                row[2] = temp.get("city");
                                row[3] = temp.get("state");
                                row[4] = temp.get("stars");
                                row[5] = a;

                                dtm.addRow(row);
                            }
                        }

                    }
                    queryLabel.setText("<html><p>" + catOnly.toString() + "</p></html>");
                }
            }//else
        } //cat and subCat is selected

    }//GEN-LAST:event_executeQueryButtonActionPerformed

    private void reviewCountComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewCountComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operReviewCount = "";
        } else {
            operReviewCount = a;
        }
        //System.out.println("Hour checkin :"+operationCheckin);
    }//GEN-LAST:event_reviewCountComboBoxActionPerformed

    private void reviewCountValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewCountValueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reviewCountValueTextFieldActionPerformed

    private void reviewCountValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reviewCountValueTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_reviewCountValueTextFieldKeyTyped

    private void numberOfFriendsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfFriendsComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operNoOfFriends = "";
        } else {
            operNoOfFriends = a;
        }
        //System.out.println("Hour checkin :"+operationCheckin);
    }//GEN-LAST:event_numberOfFriendsComboBoxActionPerformed

    private void numberOfFriendsValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfFriendsValueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberOfFriendsValueTextFieldActionPerformed

    private void numberOfFriendsValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberOfFriendsValueTextFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            getToolkit().beep();
            evt.consume();

        }
    }//GEN-LAST:event_numberOfFriendsValueTextFieldKeyTyped

    private void andOrComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_andOrComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "AND,OR between attribute") {
            andOrAttribute = "";
        } else {
            andOrAttribute = a;
        }
        //System.out.println("Hour checkin :"+operationCheckin);
    }//GEN-LAST:event_andOrComboBoxActionPerformed

    private void avgStarValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avgStarValueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_avgStarValueTextFieldActionPerformed

    private void avgStarValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_avgStarValueTextFieldKeyTyped
//        char c = evt.getKeyChar();
//        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
//            getToolkit().beep();
//            evt.consume();
//
//        }
    }//GEN-LAST:event_avgStarValueTextFieldKeyTyped

    private void avgStarComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avgStarComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operAvgStar = "";
        } else {
            operAvgStar = a;
        }
        //System.out.println("Hour checkin :"+operationCheckin);
    }//GEN-LAST:event_avgStarComboBoxActionPerformed

    private void memberSinceDateBoxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_memberSinceDateBoxPropertyChange
        memberSince = ((JTextField) memberSinceDateBox.getDateEditor().getUiComponent()).getText();
        System.out.println(memberSince);
    }//GEN-LAST:event_memberSinceDateBoxPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //business button

        jList1.setVisible(true);
        fromComboBox.setEnabled(true);
        fromHourComboBox.setEnabled(true);
        toComboBox.setEnabled(true);
        toHourComboBox.setEnabled(true);
        checkinValueComboBox.setEnabled(true);
        checkinValueTextField.setEnabled(true);
        fromReviewDate.setEnabled(true);
        toReviewDate.setEnabled(true);
        starsComboBox.setEnabled(true);
        starsValueTextField.setEnabled(true);
        votesComboBox.setEnabled(true);
        votesValueTextField.setEnabled(true);
        pointOfInterestComboBox.setEnabled(true);
        proximityComboBox.setEnabled(true);
        searchForComboBox.setEnabled(true);
        numberOfVotesComboBox.setEnabled(false);
        noOfVotesValueTextField.setEnabled(false);
        memberSinceDateBox.setEnabled(false);
        reviewCountComboBox.setEnabled(false);
        reviewCountValueTextField.setEnabled(false);
        numberOfFriendsComboBox.setEnabled(false);
        numberOfFriendsValueTextField.setEnabled(false);
        avgStarComboBox.setEnabled(false);
        avgStarValueTextField.setEnabled(false);
        andOrComboBox.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // user button
        finalCat.clear();
        numberOfVotesComboBox.setEnabled(true);
        noOfVotesValueTextField.setEnabled(true);
        memberSinceDateBox.setEnabled(true);
        reviewCountComboBox.setEnabled(true);
        reviewCountValueTextField.setEnabled(true);
        numberOfFriendsComboBox.setEnabled(true);
        numberOfFriendsValueTextField.setEnabled(true);
        avgStarComboBox.setEnabled(true);
        avgStarValueTextField.setEnabled(true);
        andOrComboBox.setEnabled(true);
        pointOfInterestComboBox.setEnabled(false);
        proximityComboBox.setEnabled(false);
        searchForComboBox.setEnabled(false);
        jList1.setVisible(false);
        fromComboBox.setEnabled(false);
        fromHourComboBox.setEnabled(false);
        toComboBox.setEnabled(false);
        toHourComboBox.setEnabled(false);
        checkinValueComboBox.setEnabled(false);
        checkinValueTextField.setEnabled(false);
        fromReviewDate.setEnabled(false);
        toReviewDate.setEnabled(false);
        starsComboBox.setEnabled(false);
        starsValueTextField.setEnabled(false);
        votesComboBox.setEnabled(false);
        votesValueTextField.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void proximityComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proximityComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_proximityComboBoxMouseClicked

    private void proximityComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proximityComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a.equalsIgnoreCase("Miles")) {
            proximity = "";
        } else {
            proximity = a;
        }
    }//GEN-LAST:event_proximityComboBoxActionPerformed

    private void searchForComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchForComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchForComboBoxMouseClicked

    private void searchForComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchForComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Between AND OR") {
            searchFor = "";
        } else {
            searchFor = a;
        }
    }//GEN-LAST:event_searchForComboBoxActionPerformed

    private void pointOfInterestComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pointOfInterestComboBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pointOfInterestComboBoxMouseClicked

    private void pointOfInterestComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointOfInterestComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a.equalsIgnoreCase("Address")) {
            Address = "";
        } else {
            Address = a;
        }
    }//GEN-LAST:event_pointOfInterestComboBoxActionPerformed

    private void numberOfVotesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberOfVotesComboBoxActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        String a = (String) cb.getSelectedItem();
        if (a == "Select =,>,<") {
            operNoOfVotes = "";
        } else {
            operNoOfVotes = a;
        }
    }//GEN-LAST:event_numberOfVotesComboBoxActionPerformed

    private void noOfVotesValueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noOfVotesValueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_noOfVotesValueTextFieldActionPerformed

    private void noOfVotesValueTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noOfVotesValueTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_noOfVotesValueTextFieldKeyTyped

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(JavaGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JavaGui jFrame;

                try {
                    jFrame = new JavaGui();
                    jFrame.setVisible(true);
                    jFrame.connect();
                    jFrame.pack();
                    jFrame.setVisible(true);

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(JavaGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox andOrComboBox;
    private javax.swing.JComboBox avgStarComboBox;
    private javax.swing.JTextField avgStarValueTextField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JLabel checkinLabel;
    private javax.swing.JPanel checkinPanel;
    private javax.swing.JPanel checkinPanel1;
    private javax.swing.JComboBox checkinValueComboBox;
    private javax.swing.JTextField checkinValueTextField;
    private javax.swing.JPanel dbCategory;
    private javax.swing.JButton executeQueryButton;
    private javax.swing.JComboBox fromComboBox;
    private javax.swing.JComboBox fromHourComboBox;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel fromLabel1;
    private com.toedter.calendar.JDateChooser fromReviewDate;
    private javax.swing.JLabel fromReviewLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser memberSinceDateBox;
    private javax.swing.JLabel noCheckinLabel;
    private javax.swing.JLabel noCheckinLabel1;
    private javax.swing.JLabel noCheckinLabel2;
    private javax.swing.JLabel noCheckinLabel3;
    private javax.swing.JTextField noOfVotesValueTextField;
    private javax.swing.JComboBox numberOfFriendsComboBox;
    private javax.swing.JTextField numberOfFriendsValueTextField;
    private javax.swing.JComboBox numberOfVotesComboBox;
    private javax.swing.JComboBox pointOfInterestComboBox;
    private javax.swing.JComboBox proximityComboBox;
    private javax.swing.JLabel queryLabel;
    private javax.swing.JTable resultTable;
    private javax.swing.JComboBox reviewCountComboBox;
    private javax.swing.JTextField reviewCountValueTextField;
    private javax.swing.JPanel reviewPanel;
    private javax.swing.JComboBox searchForComboBox;
    private javax.swing.JLabel starValueLabel;
    private javax.swing.JComboBox starsComboBox;
    private javax.swing.JLabel starsLabel;
    private javax.swing.JTextField starsValueTextField;
    private javax.swing.JComboBox toComboBox;
    private javax.swing.JComboBox toHourComboBox;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel toLabel1;
    private javax.swing.JLabel toLabel2;
    private javax.swing.JLabel toLabel3;
    private javax.swing.JLabel toLabel4;
    private javax.swing.JLabel toLabel5;
    private com.toedter.calendar.JDateChooser toReviewDate;
    private javax.swing.JLabel toReviewLabel;
    private javax.swing.JComboBox votesComboBox;
    private javax.swing.JLabel votesLabel;
    private javax.swing.JLabel votesValueLabel;
    private javax.swing.JTextField votesValueTextField;
    // End of variables declaration//GEN-END:variables

    private void connect() throws ClassNotFoundException, SQLException {

        String[] main_categories = {"Active Life", "Arts & Entertainment",
            "Automotive", "Car Rental", "Cafes", "Beauty & Spas",
            "Convenience Stores", "Dentists", "Doctors", "Drugstores",
            "Department Stores", "Education", "Event Planning & Services",
            "Flowers & Gifts", "Food", "Health & Medical", "Home Services",
            "Home & Garden", "Hospitals", "Hotels & Travel", "Hardware Stores",
            "Grocery", "Medical Centers", "Nurseries & Gardening", "Nightlife",
            "Restaurants", "Shopping", "Transportation"};
        jList1.setCellRenderer(new CheckboxListRenderer());
        jList1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jList1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent event) {
                JList<CheckboxListItem> list
                        = (JList<CheckboxListItem>) event.getSource();
                // Get index of item clicked
                int index = list.locationToIndex(event.getPoint());
                CheckboxListItem item = (CheckboxListItem) list.getModel()
                        .getElementAt(index);
                // Toggle selected state
                item.setSelected(!item.isSelected());
                if (item.isSelected()) {
                    finalCat.add(item.toString());
//                for(String t:finalCat){
//                System.out.println(t);
//                }
                } else {
                    finalCat.remove(item.toString());
                }
                //System.out.println("Size of arraylist : "+finalCat.size());
                // Repaint cell

                list.repaint(list.getCellBounds(index, index));
            }
        });
        for (int i = 0; i < main_categories.length; i++) {

            CheckboxListItem cbl = new CheckboxListItem(main_categories[i]);
            model.addElement(cbl);
        }
    }

    private int CheckForDay(String from, String to) {
        int value1 = 0;
        int value2 = 0;
        if ("Sunday".equals(from)) {
            value1 = 0;
        }
        if ("Monday".equals(from)) {
            value1 = 1;
        }
        if ("Tuesday".equals(from)) {
            value1 = 2;
        }
        if ("Wednesday".equals(from)) {
            value1 = 3;
        }
        if ("Thursday".equals(from)) {
            value1 = 4;
        }
        if ("Friday".equals(from)) {
            value1 = 5;
        }
        if ("Saturday".equals(from)) {
            value1 = 6;
        }

        if ("Sunday".equals(to)) {
            value2 = 0;
        }
        if ("Monday".equals(to)) {
            value2 = 1;
        }
        if ("Tuesday".equals(to)) {
            value2 = 2;
        }
        if ("Wednesday".equals(to)) {
            value2 = 3;
        }
        if ("Thursday".equals(to)) {
            value2 = 4;
        }
        if ("Friday".equals(to)) {
            value2 = 5;
        }
        if ("Saturday".equals(to)) {
            value2 = 6;
        }

        int difference = value2 - value1;

        if (difference == 0) {
            difference = 6;
        }
        if (difference == -1) {
            difference = 5;
        }
        if (difference == -2) {
            difference = 4;
        }
        if (difference == -3) {
            difference = 3;
        }
        if (difference == -4) {
            difference = 2;
        }
        if (difference == -5) {
            difference = 1;
        }
        if (difference == -6) {
            difference = 0;
        }
        if (difference > 0) {
            difference = difference - 1;
        }
        return difference;
    }//checkForDay

    private String clobToString(Clob data) throws IOException {
        StringBuilder sb = new StringBuilder();
        try {
            Reader reader = data.getCharacterStream();
            BufferedReader br = new BufferedReader(reader);

            String line;
            while (null != (line = br.readLine())) {
                sb.append(line);
            }
            br.close();
        } catch (SQLException e) {
            // handle this exception
        } catch (IOException e) {
            // handle this exception
        }
        return sb.toString();
    }

}//class CheckBox

class CheckboxListItem {

    private String label;
    private boolean isSelected = false;

    public CheckboxListItem(String label) {
        this.label = label;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public String toString() {
        return label;
    }
}

class CheckboxListRenderer extends JCheckBox implements
        ListCellRenderer<CheckboxListItem> {

    @Override
    public Component getListCellRendererComponent(
            JList<? extends CheckboxListItem> list, CheckboxListItem value,
            int index, boolean isSelected, boolean cellHasFocus) {
        setEnabled(list.isEnabled());
        setSelected(value.isSelected());
        setFont(list.getFont());
        setBackground(list.getBackground());
        setForeground(list.getForeground());
        setText(value.toString());
        return this;
    }
}
