/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testtool.views.questiondb;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import testtool.models.questiondb.*;

/**
 *
 * @author RJ Almada (rjalmada@calpoly.edu)
 * @version 14apr14
 *
 */
public class AddQuestion extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private Object oldQTItem;
    private JPanel prevPanel;
    private JFrame frame;

    /**
     * Creates new form NewJPanel
     */
    public AddQuestion(final QuestionDatabank qdb) {
    	frame = new JFrame("QuestionDB");
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setJMenuBar(this);
		frame.setLayout(new BorderLayout());
        initComponents();
        this.oldQTItem = "Multiple Choice";
        this.prevPanel = MCQPanel;
        TFPanel.setVisible(false);
        SAPanel.setVisible(false);
        EQPanel.setVisible(false);
        GQPanel.setVisible(false);
        CQPanel.setVisible(false);
        
        finishButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Data will be saved.");
		        switch ((String) oldQTItem) {
		                case "Multiple Choice":
		                    qdb.add(new MCQuestion(MCQuestionText.getText(), "Gene Fisher", "Never", Course.getText(),
		                    		new ArrayList<String>(Arrays.asList(Topic.getText().split(","))),
		                    		Integer.parseInt(EstTime.getText()), Difficulty.getSelectedIndex(),
		                    		collectMCAnswers(), collectMCCorAnswers()));
		                    break;
		                case "True/False":
		                    qdb.add(new TFQuestion(TFQuestionText.getText(), "Gene Fisher", "Never", Course.getText(),
		                    		new ArrayList<String>(Arrays.asList(Topic.getText().split(","))),
		                    		Integer.parseInt(EstTime.getText()), Difficulty.getSelectedIndex(),
		                    		TFAnswer.isSelected()));
		                    break;
		                case "Short Answer":
		                    qdb.add(new SAQuestion(SAQuestion.getText(), "Gene Fisher", "Never", Course.getText(),
		                    		new ArrayList<String>(Arrays.asList(Topic.getText().split(","))),
		                    		Integer.parseInt(EstTime.getText()), Difficulty.getSelectedIndex(),
		                    		parseStuff(SAAnswer.getText())));
		                    break;
		                case "Essay":
		                    qdb.add(new EssayQuestion(SAQuestion.getText(), "Gene Fisher", "Never", Course.getText(),
		                    		new ArrayList<String>(Arrays.asList(Topic.getText().split(","))),
		                    		Integer.parseInt(EstTime.getText()), Difficulty.getSelectedIndex(), 
		                    		parseStuff(EssayAnswer.getText())));
		                    break;
		                case "Graphics":
		                    qdb.add(new GraphicsQuestion(GraphicsQuestionText.getText(), "Gene Fisher", "Never",
		                    		Course.getText(), new ArrayList<String>(Arrays.asList(Topic.getText().split(","))),
		                    		Integer.parseInt(EstTime.getText()), Difficulty.getSelectedIndex()));
		                    break;
		                case "Code":
		                    qdb.add(new CodeQuestion(SAQuestion.getText(), "Gene Fisher", "Never", Course.getText(),
		                    		new ArrayList<String>(Arrays.asList(Topic.getText().split(","))),
		                    		Integer.parseInt(EstTime.getText()), Difficulty.getSelectedIndex(), 
		                    		CodeScriptPath.getText()));
		                    break;
		        }
				frame.dispose();
			}
		});
        
		frame.getContentPane().add(prevPanel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
    }

    /**
     * This method will collect the multiple choice question answers
     */
    @SuppressWarnings("null")
	private static Collection<String> collectMCAnswers() {
    	Collection<String> r = null;
    	
    	if(!MCAnswerText1.getText().equals("Answer 1")) {
    		r.add(MCAnswerText1.getText());
    	}
    	if(!MCAnswerText2.getText().equals("Answer 2")) {
    		r.add(MCAnswerText2.getText());
    	}
    	if(!MCAnswerText3.getText().equals("Answer 3")) {
    		r.add(MCAnswerText3.getText());
    	}
    	if(!MCAnswerText4.getText().equals("Answer 4")) {
    		r.add(MCAnswerText4.getText());
    	}
    	if(!MCAnswerText5.getText().equals("Answer 5")) {
    		r.add(MCAnswerCheck5.getText());
    	}
    	
    	return r;
    }
    
    @SuppressWarnings({ "null" })
	private static Collection<Integer> collectMCCorAnswers() {
    	Collection<Integer> r = null;
    	
    	if(MCAnswerCheck1.isSelected()) {
    		r.add(new Integer(1));
    	}
    	if(MCAnswerCheck2.isSelected()) {
    		r.add(new Integer(2));
    	}
    	if(MCAnswerCheck3.isSelected()) {
    		r.add(new Integer(3));
    	}
    	if(MCAnswerCheck4.isSelected()) {
    		r.add(new Integer(4));
    	}
    	if(MCAnswerCheck5.isSelected()) {
    		r.add(new Integer(5));
    	}
    	
    	return r;
    }
    
    
    
    private static Collection<String> parseStuff(String toParse) {
    	Collection<String> r = null;
    	
    	r = Arrays.asList(toParse.split(","));
    	
    	return r;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuestionType = new javax.swing.JComboBox();
        Difficulty = new javax.swing.JComboBox();
        Topic = new javax.swing.JTextField();
        Course = new javax.swing.JTextField();
        TopicLabel = new javax.swing.JLabel();
        CourseLabel = new javax.swing.JLabel();
        QuestionTypeLabel = new javax.swing.JLabel();
        DifficultyLabel = new javax.swing.JLabel();
        EstTimeLabel = new javax.swing.JLabel();
        EstTime = new javax.swing.JTextField();
        minLabel = new javax.swing.JLabel();
        MCQPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MCQuestionText = new javax.swing.JTextArea();
        MCQuestionLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        MCAnswerCheck1 = new javax.swing.JCheckBox();
        MCAnswerCheck2 = new javax.swing.JCheckBox();
        MCAnswerCheck3 = new javax.swing.JCheckBox();
        MCAnswerCheck4 = new javax.swing.JCheckBox();
        MCAnswerText1 = new javax.swing.JTextField();
        MCAnswerText3 = new javax.swing.JTextField();
        MCAnswerText4 = new javax.swing.JTextField();
        MCAnswerText2 = new javax.swing.JTextField();
        MCAnswerCheck5 = new javax.swing.JCheckBox();
        MCAnswerText5 = new javax.swing.JTextField();
        MCAddAnswerButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        ImagePath = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        FilePathButton = new javax.swing.JButton();
        TFPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TFQuestionText = new javax.swing.JTextArea();
        TFQuestion = new javax.swing.JLabel();
        TFAnswer = new javax.swing.JCheckBox();
        SAPanel = new javax.swing.JPanel();
        SAQuestionLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        SAQuestion = new javax.swing.JTextArea();
        SAAnswer = new javax.swing.JTextField();
        SAAnswerLabel = new javax.swing.JLabel();
        EQPanel = new javax.swing.JPanel();
        EssayQuestionLabel = new javax.swing.JLabel();
        EssayAnswer = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        EssayQuestionText = new javax.swing.JTextArea();
        EssayAnswerLabel = new javax.swing.JLabel();
        GQPanel = new javax.swing.JPanel();
        GraphicsQuestionLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        GraphicsQuestionText = new javax.swing.JTextArea();
        CQPanel = new javax.swing.JPanel();
        CodeQuestionLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        CodeQuestionText = new javax.swing.JTextArea();
        CodeScriptPath = new javax.swing.JTextField();
        CodeAnswerLabel = new javax.swing.JLabel();
        CodeUploadButton = new javax.swing.JButton();

        QuestionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Multiple Choice", "True/False", "Short Answer", "Essay", "Graphics", "Code"}));
        QuestionType.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                QuestionTypeComponentShown(evt);
            }
        });
        QuestionType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuestionTypeActionPerformed(evt);
            }
        });

        Difficulty.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Easy", "Easy-Medium", "Medium", "Medium-Hard", "Hard" }));
        Difficulty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DifficultyActionPerformed(evt);
            }
        });

        Topic.setText("Topic");
        Topic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopicActionPerformed(evt);
            }
        });

        Course.setText("Course");

        TopicLabel.setText("Topic");

        CourseLabel.setText("Course");

        QuestionTypeLabel.setText("Question Type");

        DifficultyLabel.setText("Difficulty");

        EstTimeLabel.setText("Est. Time");

        EstTime.setText("Est. Time");

        minLabel.setText("min");

        MCQuestionText.setColumns(20);
        MCQuestionText.setRows(5);
        jScrollPane1.setViewportView(MCQuestionText);

        MCQuestionLabel.setText("Question Text");

        MCAnswerCheck1.setText("A)");

        MCAnswerCheck2.setText("B)");

        MCAnswerCheck3.setText("C)");

        MCAnswerCheck4.setText("D)");

        MCAnswerText1.setText("Answer 1");

        MCAnswerText3.setText("Answer 3");

        MCAnswerText4.setText("Answer 4");

        MCAnswerText2.setText("Answer 2");

        MCAnswerCheck5.setText("E)");

        MCAnswerText5.setText("Answer 5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MCAnswerCheck1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MCAnswerText1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MCAnswerCheck2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MCAnswerText2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MCAnswerCheck3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MCAnswerText3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MCAnswerCheck5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MCAnswerText5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(MCAnswerCheck4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MCAnswerText4)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MCAnswerCheck1)
                    .addComponent(MCAnswerText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MCAnswerCheck2)
                    .addComponent(MCAnswerText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MCAnswerText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MCAnswerCheck3))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MCAnswerCheck4)
                    .addComponent(MCAnswerText4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MCAnswerCheck5)
                    .addComponent(MCAnswerText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        MCAddAnswerButton.setText("Add another Answer");

        javax.swing.GroupLayout MCQPanelLayout = new javax.swing.GroupLayout(MCQPanel);
        MCQPanel.setLayout(MCQPanelLayout);
        MCQPanelLayout.setHorizontalGroup(
            MCQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MCQPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(MCQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MCAddAnswerButton)
                    .addGroup(MCQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(MCQuestionLabel)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MCQPanelLayout.setVerticalGroup(
            MCQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MCQPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MCQuestionLabel)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MCAddAnswerButton)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        finishButton.setText("Finish");

        CancelButton.setText("Cancel");

        ImagePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImagePathActionPerformed(evt);
            }
        });

        jLabel2.setText("Optional Image");

        FilePathButton.setText("Choose File");

        TFQuestionText.setColumns(20);
        TFQuestionText.setRows(5);
        jScrollPane2.setViewportView(TFQuestionText);

        TFQuestion.setText("Question Text");

        TFAnswer.setText("True?");

        javax.swing.GroupLayout TFPanelLayout = new javax.swing.GroupLayout(TFPanel);
        TFPanel.setLayout(TFPanelLayout);
        TFPanelLayout.setHorizontalGroup(
            TFPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TFPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(TFPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TFPanelLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(TFAnswer))
                    .addComponent(TFQuestion)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        TFPanelLayout.setVerticalGroup(
            TFPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TFPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TFQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TFAnswer)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        SAQuestion.setText("Question Text");

        SAQuestion.setColumns(20);
        SAQuestion.setRows(5);
        jScrollPane3.setViewportView(SAQuestion);

        SAAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAAnswerActionPerformed(evt);
            }
        });

        SAAnswerLabel.setText("Keywords (separated by a comma)");

        javax.swing.GroupLayout SAPanelLayout = new javax.swing.GroupLayout(SAPanel);
        SAPanel.setLayout(SAPanelLayout);
        SAPanelLayout.setHorizontalGroup(
            SAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SAPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(SAQuestion)
                        .addComponent(jScrollPane3)
                        .addComponent(SAAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SAAnswerLabel))
                .addGap(26, 26, 26))
        );
        SAPanelLayout.setVerticalGroup(
            SAPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SAPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SAQuestion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SAAnswerLabel)
                .addGap(3, 3, 3)
                .addComponent(SAAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        EssayQuestionLabel.setText("Question Text");

        EssayAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EssayAnswerActionPerformed(evt);
            }
        });

        EssayQuestionText.setColumns(20);
        EssayQuestionText.setRows(5);
        jScrollPane4.setViewportView(EssayQuestionText);

        EssayAnswerLabel.setText("Ordered Keywords (separated by a comma)");

        javax.swing.GroupLayout EQPanelLayout = new javax.swing.GroupLayout(EQPanel);
        EQPanel.setLayout(EQPanelLayout);
        EQPanelLayout.setHorizontalGroup(
            EQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EQPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(EssayQuestionLabel)
                        .addComponent(jScrollPane4)
                        .addComponent(EssayAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(EssayAnswerLabel))
                .addGap(25, 25, 25))
        );
        EQPanelLayout.setVerticalGroup(
            EQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EQPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EssayQuestionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EssayAnswerLabel)
                .addGap(3, 3, 3)
                .addComponent(EssayAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        GraphicsQuestionLabel.setText("Question Text");

        GraphicsQuestionText.setColumns(20);
        GraphicsQuestionText.setRows(5);
        jScrollPane5.setViewportView(GraphicsQuestionText);

        javax.swing.GroupLayout GQPanelLayout = new javax.swing.GroupLayout(GQPanel);
        GQPanel.setLayout(GQPanelLayout);
        GQPanelLayout.setHorizontalGroup(
            GQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GQPanelLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(GQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GraphicsQuestionLabel)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        GQPanelLayout.setVerticalGroup(
            GQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GQPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GraphicsQuestionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        CodeQuestionLabel.setText("Question Text");

        CodeQuestionText.setColumns(20);
        CodeQuestionText.setRows(5);
        jScrollPane6.setViewportView(CodeQuestionText);

        CodeAnswerLabel.setText("Path to Grading Script");

        CodeUploadButton.setText("Choose File");

        javax.swing.GroupLayout CQPanelLayout = new javax.swing.GroupLayout(CQPanel);
        CQPanel.setLayout(CQPanelLayout);
        CQPanelLayout.setHorizontalGroup(
            CQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CQPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(CQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CQPanelLayout.createSequentialGroup()
                        .addComponent(CodeScriptPath, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CodeUploadButton))
                    .addComponent(CodeQuestionLabel)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodeAnswerLabel))
                .addContainerGap())
        );
        CQPanelLayout.setVerticalGroup(
            CQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CQPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CodeQuestionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CodeAnswerLabel)
                .addGap(1, 1, 1)
                .addGroup(CQPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CodeScriptPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodeUploadButton))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(finishButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MCQPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Topic)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TopicLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EstTimeLabel)
                            .addComponent(CourseLabel)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FilePathButton)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(EstTime, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QuestionType, javax.swing.GroupLayout.Alignment.LEADING, 0, 140, Short.MAX_VALUE)
                            .addComponent(QuestionTypeLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DifficultyLabel)
                                    .addComponent(Difficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(CQPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GQPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EQPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SAPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(TFPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CourseLabel)
                .addGap(2, 2, 2)
                .addComponent(Course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(TopicLabel)
                .addGap(1, 1, 1)
                .addComponent(Topic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(QuestionTypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QuestionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EstTimeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EstTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DifficultyLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Difficulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilePathButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TFPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SAPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CQPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(MCQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DifficultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DifficultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DifficultyActionPerformed

    private void TopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TopicActionPerformed

    private void QuestionTypeComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_QuestionTypeComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_QuestionTypeComponentShown

    private void QuestionTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuestionTypeActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        Object newItem = cb.getSelectedItem();
        
        boolean same = newItem.equals(oldQTItem);
        
        if (!same) {
            prevPanel.setVisible(false);
            switch ((String) newItem) {
                case "Multiple Choice":
                    MCQPanel.setVisible(true);
                    prevPanel = MCQPanel;
                    break;
                case "True/False":
                    TFPanel.setVisible(true);
                    prevPanel = TFPanel;
                    break;
                case "Short Answer":
                    SAPanel.setVisible(true);
                    prevPanel = SAPanel;
                    break;
                case "Essay":
                    EQPanel.setVisible(true);
                    prevPanel = EQPanel;
                    break;
                case "Graphics":
                    GQPanel.setVisible(true);
                    prevPanel = GQPanel;
                    break;
                case "Code":
                    CQPanel.setVisible(true);
                    prevPanel = CQPanel;
                    break;
            }
          }  
            
          oldQTItem = newItem;
          
    }//GEN-LAST:event_QuestionTypeActionPerformed

    private void ImagePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImagePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImagePathActionPerformed

    private void SAAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SAAnswerActionPerformed

    private void EssayAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EssayAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EssayAnswerActionPerformed 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField MCAnswerText1;
    private static javax.swing.JTextField MCAnswerText2;
    private static javax.swing.JTextField MCAnswerText3;
    private static javax.swing.JTextField MCAnswerText4;
    private static javax.swing.JTextField MCAnswerText5;
    private javax.swing.JPanel CQPanel;
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField CodeScriptPath;
    private javax.swing.JTextField Course;
    private javax.swing.JLabel CourseLabel;
    private javax.swing.JComboBox Difficulty;
    private javax.swing.JLabel DifficultyLabel;
    private javax.swing.JPanel EQPanel;
    private javax.swing.JTextField EstTime;
    private javax.swing.JLabel EstTimeLabel;
    private javax.swing.JButton FilePathButton;
    private javax.swing.JPanel GQPanel;
    private javax.swing.JTextField ImagePath;
    private javax.swing.JPanel MCQPanel;
    private javax.swing.JComboBox QuestionType;
    private javax.swing.JLabel QuestionTypeLabel;
    private javax.swing.JPanel SAPanel;
    private javax.swing.JPanel TFPanel;
    private javax.swing.JLabel TFQuestion;
    private javax.swing.JLabel SAQuestionLabel;
    private javax.swing.JLabel EssayQuestionLabel;
    private javax.swing.JLabel GraphicsQuestionLabel;
    private javax.swing.JLabel CodeQuestionLabel;
    private static javax.swing.JTextField Topic;
    private javax.swing.JLabel TopicLabel;
    private javax.swing.JButton MCAddAnswerButton;
    private static javax.swing.JCheckBox MCAnswerCheck1;
    private static javax.swing.JCheckBox MCAnswerCheck2;
    private static javax.swing.JCheckBox MCAnswerCheck3;
    private static javax.swing.JCheckBox MCAnswerCheck4;
    private static javax.swing.JCheckBox MCAnswerCheck5;
    private javax.swing.JButton finishButton;
    private javax.swing.JButton CodeUploadButton;
    private javax.swing.JCheckBox TFAnswer;
    private javax.swing.JLabel MCQuestionLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel SAAnswerLabel;
    private javax.swing.JLabel EssayAnswerLabel;
    private javax.swing.JLabel CodeAnswerLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea MCQuestionText;
    private javax.swing.JTextArea TFQuestionText;
    private javax.swing.JTextArea SAQuestion;
    private javax.swing.JTextArea EssayQuestionText;
    private javax.swing.JTextArea GraphicsQuestionText;
    private javax.swing.JTextArea CodeQuestionText;
    private javax.swing.JTextField SAAnswer;
    private javax.swing.JTextField EssayAnswer;
    private javax.swing.JLabel minLabel;
    // End of variables declaration//GEN-END:variables
}
