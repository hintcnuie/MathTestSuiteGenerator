package com.blueray.test.math.suite.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.blueray.test.math.suite.entity.DifficultyLevelEnum;
import com.blueray.test.math.suite.entity.MathTest;
import com.blueray.test.math.suite.service.FileService;
import com.blueray.test.math.suite.service.MathTestInterface;
import com.blueray.test.math.suite.service.MathTestService;
import com.blueray.test.math.suite.service.WordService;
import com.blueray.test.math.suite.utils.FileEncodingUtil;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class MathTestSwingMainUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6008385950658741152L;
	private JPanel contentPane;
	private JTextField suiteTitle;
	private JSpinner suiteTestNumber;
	private JSpinner testItemNumber;
	private JSpinner startNumber;
	private JSpinner endNumber;
	private JCheckBox addSubCheckBox;
	private JCheckBox mulDivCheckBox;
	private JTextField outputDirTxt;
	private JProgressBar progressBar;
	private JComboBox difficultyLevelComboBox;
	private JButton generateMathStartButton;
	private Task tasker;
	private static MathTestSwingMainUI frame;
	private Timer timer;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	/**
	 * user input data
	 * 
	 */
	// 试卷标题
	private String title = null;
	// 包含多少套试卷
	private int suiteNumber = 0;
	// 每套试卷多少道道题目
	private int itemNumber = 0;
	private int mathItemStart = 0;
	private int mathItemEnd = 0;
	private boolean addSubChoice = true;
	private boolean mulDivChoice = false;
	private String dist;
	private DifficultyLevelEnum difChoice = null;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FileEncodingUtil.setUtf8Setting();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new MathTestSwingMainUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MathTestSwingMainUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				MathTestSwingMainUI.class.getResource("/img/ico.jpg")));
		setTitle("家庭作业生成器--小学数学版");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance()
				.createLabel("试卷标题：");
		lblNewJgoodiesLabel.setFont(new Font("STSong", Font.BOLD, 11));
		lblNewJgoodiesLabel.setToolTipText("显示在试卷最中间的文字，例如“一零四中学三年级数学练习题“");
		lblNewJgoodiesLabel.setBounds(27, 25, 70, 24);
		contentPane.add(lblNewJgoodiesLabel);

		suiteTitle = new JTextField();
		suiteTitle.setText("苏三四小学一年级   《数学》 寒假 作业");
		suiteTitle.setToolTipText("显示在试卷最中间的文字，例如“一零四中学三年级数学练习题“");
		suiteTitle.setBounds(123, 27, 354, 20);
		contentPane.add(suiteTitle);
		suiteTitle.setColumns(10);

		JLabel label = new JLabel("试卷数量：");
		label.setToolTipText("试卷数量：");
		label.setFont(new Font("STSong", Font.BOLD, 11));
		label.setBounds(27, 57, 60, 24);
		contentPane.add(label);

		suiteTestNumber = new JSpinner();

		suiteTestNumber.setToolTipText("每套试卷包含多少道题目");
		suiteTestNumber.setBounds(123, 57, 70, 24);
		suiteTestNumber.setValue(new Integer(20));
		contentPane.add(suiteTestNumber);

		JLabel lblNewLabel = new JLabel("试题数量：");
		lblNewLabel.setToolTipText("每张试卷包含多少道题目");
		lblNewLabel.setFont(new Font("STSong", Font.BOLD, 11));
		lblNewLabel.setBounds(27, 92, 60, 20);

		contentPane.add(lblNewLabel);

		testItemNumber = new JSpinner();
		testItemNumber.setToolTipText("每张试卷包含多少道题目");
		testItemNumber.setBounds(123, 90, 70, 24);
		testItemNumber.setValue(new Integer(20));
		contentPane.add(testItemNumber);

		JLabel label_1 = new JLabel("算数范围：");
		label_1.setToolTipText("算数的范围，例如100范围内的运算，需要填写1,100");
		label_1.setFont(new Font("STSong", Font.BOLD, 11));
		label_1.setBounds(27, 126, 60, 24);
		contentPane.add(label_1);

		startNumber = new JSpinner();
		startNumber.setToolTipText("算数的范围，例如100范围内的运算，需要填写1,100");
		startNumber.setBounds(123, 128, 52, 20);
		startNumber.setValue(1);
		contentPane.add(startNumber);

		JLabel label_2 = new JLabel("到");
		label_2.setBounds(205, 131, 24, 19);
		contentPane.add(label_2);

		endNumber = new JSpinner();
		endNumber.setToolTipText("算数的范围，例如100范围内的运算，需要填写1,100");
		endNumber.setBounds(261, 128, 52, 20);
		endNumber.setValue(30);
		contentPane.add(endNumber);

		JLabel label_3 = new JLabel("运算符：");
		label_3.setFont(new Font("STSong", Font.BOLD, 11));
		label_3.setBounds(37, 161, 60, 20);
		contentPane.add(label_3);

		addSubCheckBox = new JCheckBox("加减法");
		addSubCheckBox.setSelected(true);
		addSubCheckBox.setToolTipText("加减法运算");
		addSubCheckBox.setBounds(123, 159, 87, 24);
		contentPane.add(addSubCheckBox);

		mulDivCheckBox = new JCheckBox("乘除法");
		mulDivCheckBox.setBounds(241, 158, 78, 24);
		mulDivCheckBox.setToolTipText("乘除法运算");
		contentPane.add(mulDivCheckBox);

		JCheckBox checkBox_1 = new JCheckBox("加减乘除混合运算");
		checkBox_1.setToolTipText("暂不支持");
		checkBox_1.setEnabled(false);
		checkBox_1.setBounds(341, 158, 162, 24);
		contentPane.add(checkBox_1);

		JLabel lblNewLabel_1 = new JLabel("难度系数：");
		lblNewLabel_1.setFont(new Font("STSong", Font.BOLD, 11));
		lblNewLabel_1.setBounds(17, 205, 70, 16);
		contentPane.add(lblNewLabel_1);

		difficultyLevelComboBox = new JComboBox();
		difficultyLevelComboBox.setToolTipText("产生试题的难度系数");
		difficultyLevelComboBox.setModel(new DefaultComboBoxModel(new String[] {
				"简单", "中等", "高级" }));
		difficultyLevelComboBox.setBounds(123, 201, 106, 27);
		difficultyLevelComboBox.setSelectedIndex(0);
		contentPane.add(difficultyLevelComboBox);

		JLabel outputDir = new JLabel("输出word路径：");
		outputDir.setFont(new Font("STSong", Font.BOLD, 12));
		outputDir.setToolTipText("产生word文件的路径");
		outputDir.setBounds(6, 254, 107, 24);
		contentPane.add(outputDir);

		outputDirTxt = new JTextField();
		outputDirTxt.setBounds(123, 255, 275, 22);
		contentPane.add(outputDirTxt);
		outputDirTxt.setColumns(10);

		JButton chooseFileDirButton = new JButton("选择路径...");
		chooseFileDirButton.setHorizontalAlignment(SwingConstants.LEFT);
		chooseFileDirButton.setToolTipText("请注意，该路径下的所有文件都会被清空！");
		chooseFileDirButton.setBounds(410, 256, 127, 22);
		chooseFileDirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				/*
				 * 这是尤为重要的。因为JFileChooser默认的是选择文件，而需要选目录。
				 * 故要将DIRECTORIES_ONLY装入模型 另外，若选择文件，则无需此句
				 */
				file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int resule = file.showOpenDialog(new JPanel());
				if (resule == JFileChooser.APPROVE_OPTION) {
					String prefix = "您选择的路径是 ";
					String dir = file.getSelectedFile().getPath();
					String warningTxt = prefix + dir + "，请注意，该路径下的所有文件都会被清空！";
					String displayTxt = warningTxt;
					JOptionPane.showConfirmDialog(null, displayTxt, "选择的文件",
							JOptionPane.YES_OPTION);
					outputDirTxt.setText(dir);
				}
			}
		});
		contentPane.add(chooseFileDirButton);

		generateMathStartButton = new JButton("生成试题");
		generateMathStartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 1.get all the value user input
				// 试卷标题
				title = suiteTitle.getText();
				// 包含多少套试卷
				suiteNumber = (Integer) suiteTestNumber.getValue();
				// 每套试卷多少道道题目
				itemNumber = (Integer) testItemNumber.getValue();
				// 数字范围
				mathItemStart = (Integer) startNumber.getValue();
				mathItemEnd = (Integer) endNumber.getValue();
				addSubChoice = addSubCheckBox.isSelected();
				mulDivChoice = mulDivCheckBox.isSelected();
				// 难度选择
				int difSelected = difficultyLevelComboBox.getSelectedIndex();
				switch (difSelected) {
				case 0:
					difChoice = DifficultyLevelEnum.EasyDifLevel;
					break;
				case 1:
					difChoice = DifficultyLevelEnum.MiddleDifLevel;
					break;
				case 2:
					difChoice = DifficultyLevelEnum.AdvancedDifLevel;
					break;
				default:
					difChoice = DifficultyLevelEnum.EasyDifLevel;
					break;
				}

				dist = outputDirTxt.getText();
				// 2.对用户选择进行检验
				boolean valid = check();
				// 3.检验完成，开始生成MathTestSuite
				// Use another thread to handle the MathTest service work
				if (valid) {
					// 3.1 禁用‘生成按钮’，防止用户误操作

					tasker = new Task();
					tasker.execute();
					tasker.addPropertyChangeListener(new PropertyChangeListener() {
						@Override
						public void propertyChange(PropertyChangeEvent event) {
							if ("progress" == event.getPropertyName()) {
								int progress = (Integer) event.getNewValue();
								progressBar.setIndeterminate(false);
								progressBar.setValue(progress);
							}
						}
					});
				}
			}

		});
		generateMathStartButton.setBounds(63, 320, 89, 23);
		contentPane.add(generateMathStartButton);

		JButton resetButton = new JButton("重置");
		resetButton.setToolTipText("重置所有选项");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = JOptionPane.showConfirmDialog(null, "重置",
						"所有的选项都将会被重置", JOptionPane.YES_OPTION);
				System.out.println(i);
				// click Yes button
				if (i == 0) {
					ResetChoice();
				}

			}
		});
		resetButton.setBounds(309, 320, 89, 23);
		contentPane.add(resetButton);

		progressBar = new JProgressBar();

		progressBar.setPreferredSize(this.contentPane.getPreferredSize());
		progressBar.setForeground(Color.GREEN);
		progressBar.setStringPainted(true);
		progressBar.setBounds(27, 441, 497, 14);
		progressBar.setMinimum(0);
		contentPane.add(progressBar);

	}

	protected void ResetChoice() {
		// 试卷标题
		suiteTitle.setText("");
		// 包含多少套试卷
		suiteTestNumber.setValue(20);
		// 每套试卷多少道道题目
		testItemNumber.setValue(20);

		startNumber.setValue(1);
		endNumber.setValue(30);
		difficultyLevelComboBox.setSelectedIndex(0);
		outputDirTxt.setText("");
		progressBar.setValue(0);

	}

	protected boolean check() {

		boolean valid = true;
		String titleWarningTxt="标题不能为空";
		String outputWarningTxt="word输出路径不能为空";
		String suiteNumberWarningTxt="试卷数量不能为0";
		String itemNumberWarningTxt="试题数量不能为0";
		String mathItemEndWarningTxt="运算数的最大值不能为空";
		String mathItemEndWarning_noless_Txt="运算范围的第二个数字必须大于第一个数字";
		if (null == title || title.length() == 0) {
			JOptionPane.showConfirmDialog(null, titleWarningTxt, titleWarningTxt,
					JOptionPane.OK_OPTION);
			suiteTitle.setText("");
			suiteTitle.requestFocus();
			
			return false;
		}
		if(suiteNumber==0){
			JOptionPane.showConfirmDialog(null, suiteNumberWarningTxt, suiteNumberWarningTxt,
					JOptionPane.OK_OPTION);
			suiteTestNumber.requestFocus();
			return false;
		}
		if(itemNumber==0){
			JOptionPane.showConfirmDialog(null, itemNumberWarningTxt, itemNumberWarningTxt,
					JOptionPane.OK_OPTION);
			testItemNumber.requestFocus();
			return false;
		}
		if(mathItemEnd==0){
			JOptionPane.showConfirmDialog(null, mathItemEndWarningTxt, mathItemEndWarningTxt,
					JOptionPane.OK_OPTION);
			endNumber.requestFocus();
			return false;
		}
		if(mathItemEnd<=mathItemStart){
			JOptionPane.showConfirmDialog(null, mathItemEndWarning_noless_Txt, mathItemEndWarning_noless_Txt,
					JOptionPane.OK_OPTION);
			endNumber.requestFocus();
			return false;
		}
		
		if(dist==null||dist.length()==0){
			JOptionPane.showConfirmDialog(null, outputWarningTxt, outputWarningTxt,JOptionPane.OK_OPTION);
			outputDirTxt.requestFocus();
			return false;
		}else{
			File folder=new File(dist);
			if(folder.exists()==false){
				JOptionPane.showConfirmDialog(null, outputWarningTxt, outputWarningTxt,JOptionPane.OK_OPTION);
				outputDirTxt.requestFocus();
				return false;
			}
			if(folder.isDirectory()==false){
				JOptionPane.showConfirmDialog(null, outputWarningTxt, outputWarningTxt,JOptionPane.OK_OPTION);
				outputDirTxt.requestFocus();
				return false;
			}
		}
		return valid;
	}


	class Task extends SwingWorker<Void, Void> {
		/*
		 * Main task. Executed in background thread.
		 */
		@Override
		public Void doInBackground() {

			{
				// 生成按钮设置为不能触发
				generateMathStartButton.setEnabled(false);

				MathTestInterface service = new MathTestService();
				List<MathTest> mathTestList = service.generateMathTest(
						suiteNumber, itemNumber, mathItemStart, mathItemEnd,
						addSubChoice, mulDivChoice, difChoice);
				progressBar.setMaximum(suiteNumber);
				// service.writeDocToDisk(title, mathTestList, new
				// File(dist),this);
				/**
				 * generate MathTest doc file
				 */
				File folder = new File(dist);
				FileService.cleanFolder(folder);

				StringBuffer sb = new StringBuffer();
				// Initialize progress property.
				setProgress(0);
				for (int i = 0; i < mathTestList.size(); i++) {

					MathTest test = mathTestList.get(i);
					test.setTitle(title);
					sb.append("writing ").append(title).append(" ").append(i)
							.append(" to disk\r\n");
					logger.info(sb.toString());

					String filename = folder.getAbsoluteFile() + File.separator
							+ i;
					WordService.writeDoc(filename, test);
					setProgress(i + 1);

				}
				
			}
			return null;
		}

		/*
		 * Executed in event dispatch thread
		 */
		public void done() {
			Toolkit.getDefaultToolkit().beep();
			generateMathStartButton.setEnabled(true);
			String displayTxt = "试题已经生成";
			timer=new Timer(3*1000, new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					progressBar.setMinimum(0);
					progressBar.setValue(0);
				}
				
			});
			timer.start();
		}
		
	}
}
