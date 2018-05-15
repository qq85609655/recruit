package generator.tools;

import generator.pojo.DatabaseType;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.table.TableColumnModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 代码生成器的GUI界面
 * 
 * @author luojunfeng
 */
public class CodeWindow {

  private static final Logger logger = LoggerFactory.getLogger(CodeWindow.class);
  
  private static final String SEQUENCE_STR = "sequence";
  private static final String UUID_STR = "uuid";

  /**
   * 数据库类型
   */
  private static final String[] DB_TYPES;

  static {
    List<String> databaseTypeStrList = new ArrayList<String>();
    DatabaseType[] databaseTypeArray = DatabaseType.values();
    for (DatabaseType databaseType : databaseTypeArray) {
      databaseTypeStrList.add(databaseType.toString());
    }
    DB_TYPES = databaseTypeStrList.toArray(new String[0]);
  }

  /**
   * 生成类型，是首次生成还是再次生成
   */
  private static final String[] GENERATE_TYPES = {"", "首次生成", "再次生成"};

  /**
   * 主键生成类型
   */
  private static final String[] KEY_TYPES = {"", UUID_STR, SEQUENCE_STR};

  /**
   * 属性生成是否trim
   */
  private static final String[] PROPERTY_TRIM = {"否", "是"};

  /**
   * 数据库列字段类型
   */
  private static final String[] JDBC_TYPES;

  static {
    List<String> jdbcTypeStrList = new ArrayList<String>();
    JdbcType[] jdbcTypeArray = JdbcType.values();
    for (JdbcType jdbcType : jdbcTypeArray) {
      String jdbcTypeStr = jdbcType.name();
      jdbcTypeStrList.add(jdbcTypeStr);
    }
    JDBC_TYPES = jdbcTypeStrList.toArray(new String[0]);
  }



  /**
   * 顶层窗口
   */
  private final JFrame frame = new JFrame();

  /**
   * 提示
   */
  private final JLabel tipsLbl = new JLabel("提示：");

  /**
   * 提示信息
   */
  private final JLabel showLbl = new JLabel(" ");

  /**
   * 基础包名提示栏
   */
  private final JLabel packageLbl = new JLabel("基础包名（小写：xx.xx ...）：");

  /**
   * 基础包名输入框
   */
  private final JTextField packageFld = new JTextField();

  /**
   * 星号，基础包名必填提示
   */
  private final JLabel starPackageLbl = new JLabel("*");

  /**
   * 表名提示栏
   */
  private final JLabel tableLbl = new JLabel("表名：");

  /**
   * 表名输入框
   */
  private final JTextField tableFld = new JTextField();

  /**
   * 星号，表名必填提示
   */
  private final JLabel starTableLbl = new JLabel("*");

  /**
   * 放tableLbl和table2ClassBtn的Panel
   */
  private final JPanel tablePnl = new JPanel();

  /**
   * 自动生成类名按钮
   */
  private final JButton table2ClassBtn = new JButton("生成类名");

  /**
   * 子模块包名提示栏
   */
  private final JLabel subPackageLbl = new JLabel("子模块包名：");

  /**
   * 子模块包名输入框
   */
  private final JTextField subPackageFld = new JTextField();

  /**
   * 星号，子模块包名必填提示
   */
  private final JLabel starSubPackageLbl = new JLabel("*");

  /**
   * 类名提示栏
   */
  private final JLabel entityNameLbl = new JLabel("类名：");

  /**
   * 类名输入框
   */
  private final JTextField entityNameFld = new JTextField();

  /**
   * 星号， 类名必填提示
   */
  private final JLabel starEntityNameLbl = new JLabel("*");

  /**
   * 数据库类型提示栏
   */
  private final JLabel dbTypeLbl = new JLabel("数据库类型：");

  /**
   * 数据库类型选择框
   */
  private final JComboBox<String> dbTypeCmb = new JComboBox<String>(DB_TYPES);

  /**
   * 星号，数据库类型必选提示
   */
  private final JLabel starDbTypeLbl = new JLabel("*");

  /**
   * 生成模式提示栏
   */
  private final JLabel generateTypeLbl = new JLabel("生成模式：");

  /**
   * 生成模式选择框
   */
  private final JComboBox<String> generateTypeCmb = new JComboBox<String>(GENERATE_TYPES);

  /**
   * 星号，生成模式必选提示
   */
  private final JLabel starGenerateTypeLbl = new JLabel("*");

  /**
   * 主键生成策略提示栏
   */
  private final JLabel keyTypeLbl = new JLabel("主键生成策略：");

  /**
   * 主键生成策略选择框
   */
  private final JComboBox<String> keyTypeCmb = new JComboBox<String>(KEY_TYPES);

  /**
   * 星号，主键生成策略必选提示
   */
  private final JLabel starKeyTypesLbl = new JLabel("*");

  /**
   * 主键列名提示框
   */
  private final JLabel pkColNameLbl = new JLabel("主键列名：");

  /**
   * 主键列名输入框
   */
  private final JTextField pkColNameFld = new JTextField();

  /**
   * 星号，主键列名
   */
  private final JLabel starPkColNameLbl = new JLabel("");

  /**
   * 序列名提示栏
   */
  private final JLabel seqNameLbl = new JLabel("序列名：");

  /**
   * 序列名输入框
   */
  private final JTextField seqNameFld = new JTextField();

  /**
   * 星号，序列名必填提示
   */
  private final JLabel starSeqNameLbl = new JLabel("");

  /**
   * 生成属性是否trim提示
   */
  private final JLabel propertyTrimLbl = new JLabel("生成属性是否trim：");

  /**
   * 生成属性是否trim选择框
   */
  private final JComboBox<String> propertyTrimCmb = new JComboBox<String>(PROPERTY_TRIM);

  /**
   * 是否生成Service的单选框
   */
  private final JCheckBox serviceCkb = new JCheckBox("Service", true);

  /**
   * 是否生成Controller的单选框
   */
  private final JCheckBox controllerCkb = new JCheckBox("Controller", true);

  /**
   * 添加数据按钮
   */
  private final JButton insertBtn = new JButton("添加数据");

  /**
   * 删除数据按钮
   */
  private final JButton deleteBtn = new JButton("删除数据");
  
  /**
   * 帮助信息
   */
  private final JLabel helpInfoLabel = new JLabel("帮助：点生成后修改表名，包名，类名可重新激活生成按钮(失去焦点时)");

  /**
   * 添加定制列转换的Table的TableModel
   */
  private final CodeGeneTableModel model = new CodeGeneTableModel(20);

  /**
   * 添加定制列转换的Table
   */
  private final JTable table = new JTable(model);

  /**
   * 生成代码按钮
   */
  private final JButton generateBtn = new JButton("生成");

  /**
   * 退出程序按钮
   */
  private final JButton exitBtn = new JButton("退出");

  /**
   * 包名输入框内容
   */
  private String packageFldStr;

  /**
   * 表名输入框内容
   */
  private String tableFldStr;

  /**
   * 子模块名输入框内容
   */
  private String subPackageFldStr;

  /**
   * 类名输入框内容
   */
  private String entityNameFldStr;

  /**
   * 数据库类型名选择框内容
   */
  private String dbTypeCmbSelectedStr;

  /**
   * 生成模式选择框内容
   */
  private String generateTypeCmbSelectedStr;

  /**
   * 主键生成策略选择框内容
   */
  private String keyTypeCmbSelectedStr;

  /**
   * 主键列名输入框内容
   */
  private String pkColNameFldStr;

  /**
   * 序列名输入框内容
   */
  private String seqNameFldStr;

  /**
   * 生成属性是否trim选择框内容
   */
  private String propertyTrimCmbStr;

  /**
   * 是否生成service代码单选框是否选中
   */
  private boolean serviceCkbSelected;

  /**
   * 是否生成controller代码单选框是否选中
   */
  private boolean controllerCkbSelected;

  /**
   * 定制列转换表格的数据
   */
  private List<Map<String, String>> tableDataList = getTableDataList();

  /**
   * 默认构造方法，进行初始哈，设置面板布局，添加监听
   */
  public CodeWindow() {
    init();
    setLayout();
    addListener();
  }

  /**
   * 初始化设置
   */
  private void init() {
    frame.setTitle("代码生成器");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    showLbl.setForeground(Color.RED);

    starPackageLbl.setForeground(Color.RED);
    starTableLbl.setForeground(Color.RED);
    starSubPackageLbl.setForeground(Color.RED);
    starEntityNameLbl.setForeground(Color.RED);
    starDbTypeLbl.setForeground(Color.RED);
    starGenerateTypeLbl.setForeground(Color.RED);
    starKeyTypesLbl.setForeground(Color.RED);
    starPkColNameLbl.setForeground(Color.RED);
    starSeqNameLbl.setForeground(Color.RED);
    pkColNameFld.setEditable(false);
    seqNameFld.setEditable(false);
    serviceCkb.setSelected(true);
    controllerCkb.setSelected(true);

    table.setPreferredScrollableViewportSize(new Dimension(400, 100));
    table.setBackground(Color.white);
    table.setRowHeight(20);
    JComboBox<String> com = new JComboBox<String>(JDBC_TYPES);
    TableColumnModel tcm = table.getColumnModel();
    tcm.getColumn(1).setCellEditor(new DefaultCellEditor(com));
  }

  /**
   * 为组件添加监听器
   */
  private void addListener() {
    keyTypeCmb.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (SEQUENCE_STR.equals(keyTypeCmb.getSelectedItem().toString())) {
          pkColNameFld.setEditable(true);
          seqNameFld.setEditable(true);
          starPkColNameLbl.setText("*");
          starSeqNameLbl.setText("*");
        } else {
          pkColNameFld.setEditable(false);
          seqNameFld.setEditable(false);
          starPkColNameLbl.setText("");
          starSeqNameLbl.setText("");
        }

      }
    });

    insertBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        model.addRow("", "", "", "");
        table.updateUI();
      }
    });

    deleteBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        int[] selections = table.getSelectedRows();
        for (int i = selections.length - 1; i >= 0; i--) {
          if (selections[i] < model.getRowCount()) {
            model.removeRow(selections[i]);
          }
        }

        table.updateUI();
      }
    });

    generateBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        getUiFieldValue();
        if (checkInfoComplete()) {
          final CustomCodeGnrtSetting customCodeGnrtSetting = new CustomCodeGnrtSetting();
          initCustomSetting(customCodeGnrtSetting);

          Runnable gnrtRunnable = new GenerateRunnable(customCodeGnrtSetting);
          
          new Thread(gnrtRunnable).start();
        }
      }

    });

    exitBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        // 没有使用：frame.dispose()
        // 也没有使用：System.exit(0)
        // 以下代码做完了之后会关闭进程
        frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
      }
    });

    table2ClassBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent ae) {
        if (null != tableFld.getText() && tableFld.getText().length() > 0) {
          entityNameFld.setText(getEntityNameByTable(tableFld.getText()));
        }
      }
    });

    FocusListener fieldFocusListener = new FocusListener() {

      @Override
      public void focusLost(FocusEvent fe) {
        if (!generateBtn.isEnabled()) {
          generateBtn.setEnabled(true);
        }
      }

      @Override
      public void focusGained(FocusEvent fe) {
        // No need
      }
    };

    packageFld.addFocusListener(fieldFocusListener);
    tableFld.addFocusListener(fieldFocusListener);
    subPackageFld.addFocusListener(fieldFocusListener);
    entityNameFld.addFocusListener(fieldFocusListener);

  }

  /**
   * 设置布局，采用GridBagLayout布局方式
   */
  private void setLayout() {
    int gridx = 0;
    int gridy = 0;
    int gridwidth = 1;
    int gridheight = 1;
    double weightx = 0.0;
    double weighty = 0.0;
    int anchor = GridBagConstraints.CENTER;
    int fill = GridBagConstraints.HORIZONTAL;
    int ipadx = 0;
    int ipady = 0;

    Insets inset = new Insets(0, 0, 0, 0);
    GridBagConstraints constraints = null;

    GridBagLayout gridbag = new GridBagLayout();
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(gridbag);

    /*
     * firstColLbl, secondColLbl和thirdColLbl仅作布局使用，并没有实际内容显示。 这是为了把三栏的布局先定好，后面的组件可以依次按行添加。
     */
    JLabel firstColLbl = new JLabel();
    gridx = 0;
    gridy = 0;
    ipadx = 200;
    weightx = 1.0;
    weighty = 1.0;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(firstColLbl, constraints);
    contentPane.add(firstColLbl);

    JLabel secondColLbl = new JLabel();
    gridx = 1;
    gridy = 0;
    ipadx = 200;
    weightx = 1.0;
    weighty = 1.0;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(secondColLbl, constraints);
    contentPane.add(secondColLbl);

    JLabel thirdColLbl = new JLabel();
    gridx = 2;
    gridy = 0;
    ipadx = 1;
    weightx = 0.0;
    weighty = 1.0;
    inset = new Insets(0, 5, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(thirdColLbl, constraints);
    contentPane.add(thirdColLbl);
    // 三栏布局结束

    /*
     * 重新定义ipadx， weightx， weighty。 由于GridBagLayout会取所有行中最大的ipady和weighty，以及所有列中最大的ipadx和weightx，
     * 此处将这些值定小是为了firstColLbl, secondColLbl和thirdColLbl三栏定义其作用。
     */
    ipadx = 0;
    weightx = 0.0;
    weighty = 1.0;

    gridx = 0;
    gridy = 0;
    inset = new Insets(10, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(tipsLbl, constraints);
    contentPane.add(tipsLbl);

    gridx = 1;
    gridy = 0;
    inset = new Insets(10, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(showLbl, constraints);
    contentPane.add(showLbl);

    gridx = 0;
    gridy = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(tablePnl, constraints);
    tablePnl.setLayout(new FlowLayout(FlowLayout.LEFT));
    tablePnl.add(tableLbl);
    tablePnl.add(table2ClassBtn);
    contentPane.add(tablePnl);

    gridx = 1;
    gridy = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(tableFld, constraints);
    contentPane.add(tableFld);

    gridx = 2;
    gridy = 1;
    inset = new Insets(0, 5, 0, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(starTableLbl, constraints);
    contentPane.add(starTableLbl);

    gridx = 0;
    gridy = 2;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(packageLbl, constraints);
    contentPane.add(packageLbl);

    gridx = 1;
    gridy = 2;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(packageFld, constraints);
    contentPane.add(packageFld);

    gridx = 2;
    gridy = 2;
    inset = new Insets(0, 5, 0, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(starPackageLbl, constraints);
    contentPane.add(starPackageLbl);

    gridx = 0;
    gridy = 3;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(subPackageLbl, constraints);
    contentPane.add(subPackageLbl);

    gridx = 1;
    gridy = 3;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(subPackageFld, constraints);
    contentPane.add(subPackageFld);

    gridx = 0;
    gridy = 4;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(entityNameLbl, constraints);
    contentPane.add(entityNameLbl);

    gridx = 1;
    gridy = 4;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(entityNameFld, constraints);
    contentPane.add(entityNameFld);

    gridx = 2;
    gridy = 4;
    inset = new Insets(0, 5, 0, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(starEntityNameLbl, constraints);
    contentPane.add(starEntityNameLbl);

    // 添加分割线
    Border emptyBorder = BorderFactory.createEmptyBorder(1, 1, 0, 1);
    Border lineBorder = BorderFactory.createLineBorder(Color.BLUE, 1);
    Border compoundBorder = new CompoundBorder(emptyBorder, lineBorder);
    JLabel sperateLbl = new JLabel();
    sperateLbl.setBorder(compoundBorder);
    gridx = 0;
    gridy = 5;
    gridwidth = 3;
    inset = new Insets(3, 10, 5, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(sperateLbl, constraints);
    contentPane.add(sperateLbl);

    gridx = 0;
    gridy = 6;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(dbTypeLbl, constraints);
    contentPane.add(dbTypeLbl);

    gridx = 1;
    gridy = 6;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(dbTypeCmb, constraints);
    contentPane.add(dbTypeCmb);

    gridx = 2;
    gridy = 6;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 5, 0, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(starDbTypeLbl, constraints);
    contentPane.add(starDbTypeLbl);

    gridx = 0;
    gridy = 7;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(generateTypeLbl, constraints);
    contentPane.add(generateTypeLbl);

    gridx = 1;
    gridy = 7;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(generateTypeCmb, constraints);
    contentPane.add(generateTypeCmb);

    gridx = 2;
    gridy = 7;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 5, 0, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(starGenerateTypeLbl, constraints);
    contentPane.add(starGenerateTypeLbl);

    gridx = 0;
    gridy = 8;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(keyTypeLbl, constraints);
    contentPane.add(keyTypeLbl);

    gridx = 1;
    gridy = 8;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(keyTypeCmb, constraints);
    contentPane.add(keyTypeCmb);

    gridx = 2;
    gridy = 8;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 5, 0, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(starKeyTypesLbl, constraints);
    contentPane.add(starKeyTypesLbl);

    gridx = 0;
    gridy = 9;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(pkColNameLbl, constraints);
    contentPane.add(pkColNameLbl);

    gridx = 1;
    gridy = 9;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(pkColNameFld, constraints);
    contentPane.add(pkColNameFld);

    gridx = 2;
    gridy = 9;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 5, 0, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(starPkColNameLbl, constraints);
    contentPane.add(starPkColNameLbl);

    gridx = 0;
    gridy = 10;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(seqNameLbl, constraints);
    contentPane.add(seqNameLbl);

    gridx = 1;
    gridy = 10;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(seqNameFld, constraints);
    contentPane.add(seqNameFld);

    gridx = 2;
    gridy = 10;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 5, 0, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(starSeqNameLbl, constraints);
    contentPane.add(starSeqNameLbl);

    gridx = 0;
    gridy = 11;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(propertyTrimLbl, constraints);
    contentPane.add(propertyTrimLbl);

    gridx = 1;
    gridy = 11;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(propertyTrimCmb, constraints);
    contentPane.add(propertyTrimCmb);

    // 添加分割线
    JLabel sperateDbLbl = new JLabel();
    sperateDbLbl.setBorder(compoundBorder);
    gridx = 0;
    gridy = 12;
    gridwidth = 3;
    inset = new Insets(3, 10, 5, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(sperateDbLbl, constraints);
    contentPane.add(sperateDbLbl);

    gridx = 0;
    gridy = 13;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 5, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(serviceCkb, constraints);
    contentPane.add(serviceCkb);

    gridx = 1;
    gridy = 13;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 5, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(controllerCkb, constraints);
    contentPane.add(controllerCkb);

    // 添加分割线
    JLabel sperateTypesLbl = new JLabel();
    sperateTypesLbl.setBorder(compoundBorder);
    gridx = 0;
    gridy = 14;
    gridwidth = 3;
    inset = new Insets(3, 10, 5, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(sperateTypesLbl, constraints);
    contentPane.add(sperateTypesLbl);

    JLabel customColumn = new JLabel("自定义列转换:");
    gridx = 0;
    gridy = 15;
    gridwidth = 2;
    gridheight = 1;
    inset = new Insets(0, 10, 5, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(customColumn, constraints);
    contentPane.add(customColumn);

    gridx = 0;
    gridy = 16;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(insertBtn, constraints);
    contentPane.add(insertBtn);

    gridx = 1;
    gridy = 16;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(deleteBtn, constraints);
    contentPane.add(deleteBtn);

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    gridx = 0;
    gridy = 17;
    gridwidth = 2;
    inset = new Insets(5, 10, 0, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(scrollPane, constraints);
    contentPane.add(scrollPane);

    // 添加分割线
    JLabel sperateResultLbl = new JLabel();
    sperateResultLbl.setBorder(compoundBorder);
    gridx = 0;
    gridy = 18;
    gridwidth = 3;
    inset = new Insets(3, 10, 5, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(sperateResultLbl, constraints);
    contentPane.add(sperateResultLbl);

    gridx = 0;
    gridy = 19;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 10, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(generateBtn, constraints);
    contentPane.add(generateBtn);

    gridx = 1;
    gridy = 19;
    gridwidth = 1;
    gridheight = 1;
    inset = new Insets(0, 10, 10, 0);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(exitBtn, constraints);
    contentPane.add(exitBtn);
    
    gridx = 0;
    gridy = 20;
    gridwidth = 2;
    gridheight = 1;
    inset = new Insets(0, 10, 10, 10);
    constraints =
        new GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill,
            inset, ipadx, ipady);
    gridbag.setConstraints(helpInfoLabel, constraints);
    contentPane.add(helpInfoLabel);
  }

  /**
   * 获取界面元素的值
   */
  private void getUiFieldValue() {
    packageFldStr = packageFld.getText();
    tableFldStr = tableFld.getText();
    subPackageFldStr = subPackageFld.getText();
    entityNameFldStr = entityNameFld.getText();

    dbTypeCmbSelectedStr = dbTypeCmb.getSelectedItem().toString();
    generateTypeCmbSelectedStr = generateTypeCmb.getSelectedItem().toString();
    keyTypeCmbSelectedStr = keyTypeCmb.getSelectedItem().toString();
    pkColNameFldStr = pkColNameFld.getText();
    seqNameFldStr = seqNameFld.getText();
    propertyTrimCmbStr = propertyTrimCmb.getSelectedItem().toString();

    serviceCkbSelected = serviceCkb.isSelected();
    controllerCkbSelected = controllerCkb.isSelected();

    tableDataList = getTableDataList();
  }

  /**
   * 检测用户所填信息是否完整
   */
  private boolean checkInfoComplete() {
    boolean infoComplete = true;
    String errorShowStr = "";
    if (StringUtils.isEmpty(packageFldStr.trim())) {
      infoComplete = false;
      errorShowStr = "基础包名不能为空！";
    }
    if (infoComplete && StringUtils.isEmpty(tableFldStr.trim())) {
      infoComplete = false;
      errorShowStr = "表名不能为空！";
    }
    if (infoComplete && StringUtils.isEmpty(entityNameFldStr.trim())) {
      infoComplete = false;
      errorShowStr = "类名不能为空！";
    }
    if (infoComplete && StringUtils.isEmpty(dbTypeCmbSelectedStr)) {
      infoComplete = false;
      errorShowStr = "数据库类型不能为空！";
    }
    if (infoComplete && StringUtils.isEmpty(generateTypeCmbSelectedStr)) {
      infoComplete = false;
      errorShowStr = "生成模式不能为空！";
    }
    if (infoComplete && StringUtils.isEmpty(keyTypeCmbSelectedStr)) {
      infoComplete = false;
      errorShowStr = "主键生成策略不能为空！";
    }
    if (infoComplete && SEQUENCE_STR.equals(keyTypeCmbSelectedStr)
        && StringUtils.isEmpty(pkColNameFldStr.trim())) {
      infoComplete = false;
      errorShowStr = "主键列名不能为空！";
    }
    if (infoComplete && SEQUENCE_STR.equals(keyTypeCmbSelectedStr)
        && StringUtils.isEmpty(seqNameFldStr.trim())) {
      infoComplete = false;
      errorShowStr = "序列名不能为空！";
    }

    if (infoComplete) {
      showLbl.setForeground(Color.BLUE);
      showLbl.setText("");
    } else {
      showLbl.setForeground(Color.RED);
      showLbl.setText(errorShowStr);
    }

    return infoComplete;
  }

  /**
   * 初始化用户设置
   * 
   * @param customCodeGnrtSetting 用户设置对象
   */
  private void initCustomSetting(CustomCodeGnrtSetting customCodeGnrtSetting) {
    customCodeGnrtSetting.setBaseModulePackageStr(packageFldStr);
    customCodeGnrtSetting.setTableNameStr(tableFldStr);
    customCodeGnrtSetting.setSubModulePackageStr(subPackageFldStr);
    customCodeGnrtSetting.setObjectNameStr(entityNameFldStr);

    DatabaseType databaseType = getDatabaseTypeByName(dbTypeCmbSelectedStr);
    customCodeGnrtSetting.setDatabaseType(databaseType);

    boolean firstGeneration = false;
    if ("首次生成".equals(generateTypeCmbSelectedStr)) {
      firstGeneration = true;
      customCodeGnrtSetting.setServiceGenerated(serviceCkbSelected);
      customCodeGnrtSetting.setControllerGenerated(controllerCkbSelected);
    } else {
      customCodeGnrtSetting.setServiceGenerated(false);
      customCodeGnrtSetting.setControllerGenerated(false);
    }
    customCodeGnrtSetting.setFirstGeneration(firstGeneration);
    customCodeGnrtSetting.setKeyStrategy(keyTypeCmbSelectedStr);
    String keyColumnName = SEQUENCE_STR.equals(keyTypeCmbSelectedStr) ? pkColNameFldStr : "";
    customCodeGnrtSetting.setKeyColumnName(keyColumnName);
    String sequenceName = SEQUENCE_STR.equals(keyTypeCmbSelectedStr) ? seqNameFldStr : "";
    customCodeGnrtSetting.setSequenceName(sequenceName);

    boolean trimString = false;
    if ("是".equals(propertyTrimCmbStr)) {
      trimString = true;
    }
    customCodeGnrtSetting.setTrimString(trimString);
    customCodeGnrtSetting.setCustomColumnList(tableDataList);
  }

  /**
   * 把用户自定义列转换信息保存到List里，List中的元素是Map，Map的键是列名，值为用户所填字符串
   * 
   * @return 保存着列转换信息的List
   */
  private List<Map<String, String>> getTableDataList() {
    List<Map<String, String>> tableDatas = new ArrayList<Map<String, String>>();
    int tableRowCount = table.getRowCount();
    int tableColumnCount = table.getColumnCount();

    for (int i = 0; i < tableRowCount; i++) {
      String columnStr = "";
      String jdbcTypeStr = "";
      String javaPropertyStr = "";
      String javaTypeStr = "";
      for (int j = 0; j < tableColumnCount; j++) {
        String tableColumnName = table.getColumnName(j);
        String tableValueStr = table.getValueAt(i, j).toString();
        if (tableColumnName.equals(CustomCodeGnrtSetting.COLUMN)) {
          columnStr = tableValueStr;
        }
        if (tableColumnName.equals(CustomCodeGnrtSetting.JDBC_TYPE)) {
          jdbcTypeStr = tableValueStr;
        }
        if (tableColumnName.equals(CustomCodeGnrtSetting.JAVA_PROPERTY)) {
          javaPropertyStr = tableValueStr;
        }
        if (tableColumnName.equals(CustomCodeGnrtSetting.JAVA_TYPE)) {
          javaTypeStr = tableValueStr;
        }
      }

      if (StringUtils.isNotEmpty(columnStr)
          && (StringUtils.isNotEmpty(jdbcTypeStr) || StringUtils.isNotEmpty(javaPropertyStr) || StringUtils
              .isNotEmpty(javaTypeStr))) {
        Map<String, String> rowDataMap = new HashMap<String, String>();
        rowDataMap.put(CustomCodeGnrtSetting.COLUMN, columnStr);
        rowDataMap.put(CustomCodeGnrtSetting.JDBC_TYPE, jdbcTypeStr);
        rowDataMap.put(CustomCodeGnrtSetting.JAVA_PROPERTY, javaPropertyStr);
        rowDataMap.put(CustomCodeGnrtSetting.JAVA_TYPE, javaTypeStr);
        tableDatas.add(rowDataMap);
      }
    }

    return tableDatas;
  }

  /**
   * @param 根据数据库类型名字符串返回数据库类型
   * @return 数据库类型
   */
  private static DatabaseType getDatabaseTypeByName(String databaseTypeName) {
    DatabaseType databaseType = DatabaseType.ORACLE;
    DatabaseType[] databaseTypeArray = DatabaseType.values();
    for (DatabaseType databaseTypeItem : databaseTypeArray) {
      if (databaseTypeItem.toString().equals(databaseTypeName)) {
        databaseType = databaseTypeItem;
      }
    }
    return databaseType;
  }

  /**
   * 根据传入的表名生成对应的实体类名，生成规则如下.
   * <ul>
   * <li>按照“_”英文下划线分割字符串，并将每段按照大驼峰命名法拼接在一起
   * <li>如果第一段只有一个字符，则忽略
   * </ul>
   * <p>
   * Example：T_TEST_USER >> TestUser
   * 
   * @param tableName 表名
   * @return 实体类名
   */
  private String getEntityNameByTable(String tableName) {
    String[] names = tableName.split("_");
    StringBuilder entityNameSb = new StringBuilder();
    String subName = null;
    StringBuilder subNameSb = null;
    for (int i = 0; i < names.length; i++) {
      if (0 == i && names[i].length() < 2) {
        continue;
      }
      // 将字符串全部转为小写，再将首字母转为大写
      subName = names[i].toLowerCase();
      subNameSb = new StringBuilder(subName);
      if (subNameSb.length() > 0) {
        subNameSb.setCharAt(0, Character.toUpperCase(subNameSb.charAt(0)));
        entityNameSb.append(subNameSb);
      }
    }
    return entityNameSb.toString();
  }

  /**
   * 展示界面
   */
  public void show() {
    frame.setVisible(true);
    frame.pack();
    frame.setLocationRelativeTo(frame.getOwner());
  }

  private class GenerateRunnable implements Runnable {
    
    private CustomCodeGnrtSetting customCodeGnrtSetting;
    
    public GenerateRunnable(CustomCodeGnrtSetting customCodeGnrtSetting) {
      this.customCodeGnrtSetting = customCodeGnrtSetting;
    }
    
    @Override
    public void run() {
      frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
      generateBtn.setEnabled(false);
      exitBtn.setEnabled(false);

      boolean success = AmberCodeGeneratorTool.generatorCode(this.customCodeGnrtSetting);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException ex) {
        logger.error(ex.getMessage(), ex);
      }

      if (success) {
        showLbl.setForeground(Color.BLUE);
        showLbl.setText("生成代码成功");
        exitBtn.setEnabled(true);
        generateBtn.setEnabled(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      } else {
        showLbl.setForeground(Color.RED);
        showLbl.setText("生成代码失败");
        exitBtn.setEnabled(true);
        generateBtn.setEnabled(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
    }
  }
}
