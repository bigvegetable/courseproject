package org.frame;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;

import org.entity.Reader;
import org.impl.ReaderDaoImpl;
import org.interfaceDao.ReaderDao;





/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class QueryReaderFrame extends javax.swing.JFrame {
	private JLabel jLabelTitle;
	private JLabel jLabelById;
	private JTextField jTextById;
	private JButton jButtonById;
	private JScrollPane jScrollPane;
	private JButton jButtonBack;
	private JButton jButtonDelete;
	private JButton jButtonUpdate;
	private JTable jTable;
	private ReaderDao readerDao = new ReaderDaoImpl();
	private static QueryReaderFrame queryFrame = null;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static QueryReaderFrame getInstance(){
		if(queryFrame == null){
			queryFrame = new QueryReaderFrame();
		}
		return queryFrame;
	}
	
	private QueryReaderFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("\u67e5\u8be2\u8bfb\u8005\u4fe1\u606f");
				jLabelTitle.setBounds(318, 20, 141, 30);
				jLabelTitle.setFont(new java.awt.Font("宋体",1,20));
			}
			{
				jLabelById = new JLabel();
				getContentPane().add(jLabelById);
				jLabelById.setText("\u8f93\u5165\u501f\u9605\u8bc1\u53f7");
				jLabelById.setBounds(36, 71, 93, 17);
				jLabelById.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextById = new JTextField();
				getContentPane().add(jTextById);
				jTextById.setBounds(147, 68, 110, 24);
			}
			{
				jButtonById = new JButton();
				getContentPane().add(jButtonById);
				jButtonById.setText("\u68c0\u7d22");
				jButtonById.setBounds(280, 68, 60, 24);
			}
			{
				jScrollPane = new JScrollPane();
				getContentPane().add(jScrollPane);
				jScrollPane.setBounds(12, 99, 758, 264);
				{
					TableModel jTableModel = getTableModel();
					jTable = new JTable();
					jScrollPane.setViewportView(jTable);
					jTable.setModel(jTableModel);
				}
			}
			{
				jButtonUpdate = new JButton();//修改按钮
				getContentPane().add(jButtonUpdate);
				jButtonUpdate.setText("\u4fee\u6539");
				jButtonUpdate.setBounds(222, 388, 72, 25);
				jButtonUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						/**
						 * 修改按钮单击事件
						 */
						int row = jTable.getSelectedRow();
						int readerId = Integer.parseInt((jTable.getValueAt(row, 0))+"");
						AddReaderFrame query = new AddReaderFrame(readerId);
						query.setVisible(true);
					}
				});
			}
			{
				jButtonDelete = new JButton();//删除按钮
				getContentPane().add(jButtonDelete);
				jButtonDelete.setText("\u5220\u9664");
				jButtonDelete.setBounds(340, 388, 72, 25);
				jButtonDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						/**
						 * 删除按钮单击事件
						 */
						int row = jTable.getSelectedRow();
						int readerId = Integer.parseInt((jTable.getValueAt(row, 0))+"");
						
						int i = JOptionPane.showConfirmDialog(QueryReaderFrame.this, "确定删除吗？");
						if(i == 0){
							//调用deleteBookInfo方法
							int result = readerDao.deleteReader(readerId);
							if(result>0){
								JOptionPane.showMessageDialog(QueryReaderFrame.this, "删除成功！");
								//在此处绘制表格是为了刷新查询界面，同步相应数据
								TableModel jTableModel = getTableModel();
								jTable.setModel(jTableModel);//重新从数据库中加载数据放到表格中
							}else{
								JOptionPane.showMessageDialog(QueryReaderFrame.this, "删除失败！");
							}
						}
					}
				});
			}
			{
				jButtonBack = new JButton();//返回按钮
				getContentPane().add(jButtonBack);
				jButtonBack.setText("\u8fd4\u56de");
				jButtonBack.setBounds(459, 388, 72, 25);
				jButtonBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						QueryReaderFrame.this.dispose();
					}
				});
			}
			pack();
			this.setSize(798, 481);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	/**
	 * 绘制表格方法
	 * @return
	 */
	private TableModel getTableModel() {
		List<Reader> list = readerDao.queryReader();
		String[][] tableContent = new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			Reader reader = list.get(i);
			tableContent[i][0] = String.valueOf(reader.getReaderId());
			tableContent[i][1] = reader.getReaderName();
			tableContent[i][2] = String.valueOf(reader.getReaderAge());
			tableContent[i][3] = reader.getReaderSex();
			tableContent[i][4] = reader.getReaderPhone();
			tableContent[i][5] = reader.getStartDate();
			tableContent[i][6] = reader.getEndDate();						
			
		}
		String[] columnName = { "借书证号","姓名","年龄","性别","联系电话","开证日期","结证日期" };
		TableModel jTableModel = new DefaultTableModel(tableContent,columnName);
		return jTableModel;
	}
	
	/**
	 * 修改数据后，刷新表格方法
	 */
	public void refresh(){
		jTable.setModel(this.getTableModel());
	}

}
