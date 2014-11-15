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

import org.entity.BookInfo;
import org.impl.BookDaoImpl;
import org.interfaceDao.BookDao;



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
public class QueryBookFrame extends javax.swing.JFrame {
	private JScrollPane jScrollPane;
	private JLabel jLabelByName;
	private JButton jButtonReturn;
	private JTable jTable;
	private JButton jButtonDelete;
	private JButton jButtonUpdate;
	private JButton jButtonByName;
	private JButton jButtonById;
	private JTextField jTextByName;
	private JTextField jTextById;
	private JLabel jLabelById;
	private JLabel jLabelTitle;
	private static QueryBookFrame queryFrame = null;
	private BookDao bookDao = new BookDaoImpl();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				QueryBookFrame inst = new QueryBookFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	private QueryBookFrame() {
		super();
		initGUI();
	}
	/**
	 * 修改学生信息后需要刷新查询页面，调用此方法即可
	 * @return
	 */
	public static QueryBookFrame getInstance(){
		if(queryFrame == null){
			queryFrame = new QueryBookFrame();
		}
		return queryFrame;
	}

	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setResizable(false);
			{
				jScrollPane = new JScrollPane();
				getContentPane().add(jScrollPane);
				jScrollPane.setBounds(12, 99, 768, 264);
				{
					//获得TableModel对象
					TableModel jTableModel = getTableModel();
					jTable = new JTable();
					jScrollPane.setViewportView(jTable);
					jTable.setModel(jTableModel);
				}
			}
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("\u67e5\u8be2\u56fe\u4e66\u4fe1\u606f");
				jLabelTitle.setBounds(318, 20, 141, 30);
				jLabelTitle.setFont(new java.awt.Font("宋体",1,20));
				jLabelTitle.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelById = new JLabel();
				getContentPane().add(jLabelById);
				jLabelById.setText("\u8f93\u5165\u56fe\u4e66\u53f7");
				jLabelById.setBounds(112, 68, 75, 17);
			}
			{
				jTextById = new JTextField();
				getContentPane().add(jTextById);
				jTextById.setBounds(181, 65, 91, 24);
			}
			{
				jLabelByName = new JLabel();
				getContentPane().add(jLabelByName);
				jLabelByName.setText("\u8f93\u5165\u56fe\u4e66\u540d");
				jLabelByName.setBounds(360, 68, 75, 17);
			}
			{
				jTextByName = new JTextField();
				getContentPane().add(jTextByName);
				jTextByName.setBounds(427, 65, 137, 24);
			}
			{
				jButtonById = new JButton();
				getContentPane().add(jButtonById);
				jButtonById.setText("\u68c0\u7d22");
				jButtonById.setBounds(278, 65, 61, 24);
			}
			{
				jButtonByName = new JButton();
				getContentPane().add(jButtonByName);
				jButtonByName.setText("\u68c0\u7d22");
				jButtonByName.setBounds(570, 65, 66, 24);
			}
			{
				jButtonUpdate = new JButton();	//修改按钮
				getContentPane().add(jButtonUpdate);
				jButtonUpdate.setText("\u4fee\u6539");
				jButtonUpdate.setBounds(243, 397, 79, 26);
				jButtonUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//获得选中的行号
						int row = jTable.getSelectedRow();
						//获得所选行的值，两个参数行和列确定选中某一个单元格
						int bookId = Integer.parseInt((String)jTable.getValueAt(row, 0));
						UpdateBookFrame update = new UpdateBookFrame(bookId);
						update.setVisible(true);
					}
				});
			}
			{
				jButtonDelete = new JButton();	//删除按钮
				getContentPane().add(jButtonDelete);
				jButtonDelete.setText("\u5220\u9664");
				jButtonDelete.setBounds(353, 397, 79, 26);
				jButtonDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						int row = jTable.getSelectedRow();//获得选中的行号
						//获得所选行的值，两个参数行和列确定选中某一个单元格
						int bookId = Integer.parseInt((String)jTable.getValueAt(row, 0));
						
						
						int i = JOptionPane.showConfirmDialog(QueryBookFrame.this, "确定删除吗？");
						if(i == 0){
							//调用deleteBookInfo方法
							int result = bookDao.deleteBookInfo(bookId);
							if(result>0){
								JOptionPane.showMessageDialog(QueryBookFrame.this, "删除成功！");
								//在此处绘制表格是为了刷新查询界面，同步相应数据
								TableModel jTableModel = getTableModel();
								jTable.setModel(jTableModel);//重新从数据库中加载数据放到表格中
							}else{
								JOptionPane.showMessageDialog(QueryBookFrame.this, "删除失败！");
							}
						}
						
						
					}
				});
			}
			{
				jButtonReturn = new JButton();	//返回按钮
				getContentPane().add(jButtonReturn);
				jButtonReturn.setText("\u8fd4\u56de");
				jButtonReturn.setBounds(459, 397, 79, 26);
				jButtonReturn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						QueryBookFrame.this.dispose();
					}
				});
			}
			pack();
			this.setSize(798, 504);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	/**
	 * 加载表格信息方法
	 * @return
	 */
	private TableModel getTableModel() {
		List<BookInfo> list = bookDao.queryBookInfo();
		//创建二维数组存放表格信息
		String[][] content = new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			BookInfo book = list.get(i);//获取集合中的元素
			content[i][0] = String.valueOf(book.getBookId());
			content[i][1] = book.getBookName();
			content[i][2] = book.getBookType();
			content[i][3] = book.getBookWriter();
			content[i][4] = book.getPublish();
			content[i][5] = book.getPublicDate();
			content[i][6] = String.valueOf(book.getBookPrice());
		}
		String[] column = new String[] { "图书号", "图书名", "图书类型" , "作者" , "出版社" , "出版日期" , "价格"  };
		TableModel jTableModel = new DefaultTableModel(content,column);
		return jTableModel;
	}
	/**
	 * 修改数据后，刷新表格方法
	 */
	public void refresh(){
		TableModel jTableModel = this.getTableModel();
		jTable.setModel(jTableModel);
	}

}
