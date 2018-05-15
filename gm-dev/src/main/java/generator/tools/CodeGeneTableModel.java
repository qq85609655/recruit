package generator.tools;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * 自定义列转换表格的TableModel
 * 
 * @author luojunfeng
 */
public class CodeGeneTableModel extends AbstractTableModel {

  private static final long serialVersionUID = -7495940408592595397L;

  private transient List<List<String>> content;

  private String[] titleName = {CustomCodeGnrtSetting.COLUMN, CustomCodeGnrtSetting.JDBC_TYPE,
      CustomCodeGnrtSetting.JAVA_PROPERTY, CustomCodeGnrtSetting.JAVA_TYPE};

  public CodeGeneTableModel() {
    content = new ArrayList<List<String>>();
  }

  public CodeGeneTableModel(int count) {
    content = new ArrayList<List<String>>(count);
  }

  /**
   * 添加行
   * 
   * @param column 列名
   * @param jdbcType jdbcType
   * @param javaProperty javaProperty
   * @param javaType javaType
   */
  public void addRow(String column, String jdbcType, String javaProperty, String javaType) {
    List<String> list = new ArrayList<String>(4);
    list.add(0, column);
    list.add(1, jdbcType);
    list.add(2, javaProperty);
    list.add(3, javaType);
    content.add(list);
  }

  /**
   * 删除行
   * 
   * @param row 行号
   */
  public void removeRow(int row) {
    content.remove(row);
  }

  /**
   * 删除行
   * 
   * @param row 初始行号
   * @param count 数量
   */
  public void removeRows(int row, int count) {
    for (int i = 0; i < count; i++) {
      if (content.size() > row) {
        content.remove(row);
      }
    }
  }

  /**
   * 让表格中某些值可修改，但需要setValueAt(Object value, int row, int col)方法配合才能使修改生效
   */
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return true;
  }

  /**
   * 使修改的内容生效
   */
  @Override
  public void setValueAt(Object value, int row, int col) {
    String valueStr = value != null ? value.toString() : "";
    content.get(row).remove(col);
    content.get(row).add(col, valueStr);
    this.fireTableCellUpdated(row, col);
  }

  @Override
  public String getColumnName(int col) {
    return titleName[col];
  }

  @Override
  public int getColumnCount() {
    return titleName.length;
  }

  @Override
  public int getRowCount() {
    return content.size();
  }

  @Override
  public Object getValueAt(int row, int col) {
    return ((List<?>) content.get(row)).get(col);
  }

  /**
   * 返回数据类型
   */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Override
  public Class getColumnClass(int col) {
    return getValueAt(0, col).getClass();
  }
}
