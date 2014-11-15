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
	 * �޸�ѧ����Ϣ����Ҫˢ�²�ѯҳ�棬���ô˷�������
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
					//���TableModel����
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
				jLabelTitle.setFont(new java.awt.Font("����",1,20));
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
				jButtonUpdate = new JButton();	//�޸İ�ť
				getContentPane().add(jButtonUpdate);
				jButtonUpdate.setText("\u4fee\u6539");
				jButtonUpdate.setBounds(243, 397, 79, 26);
				jButtonUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//���ѡ�е��к�
						int row = jTable.getSelectedRow();
						//�����ѡ�е�ֵ�����������к���ȷ��ѡ��ĳһ����Ԫ��
						int bookId = Integer.parseInt((String)jTable.getValueAt(row, 0));
						UpdateBookFrame update = new UpdateBookFrame(bookId);
						update.setVisible(true);
					}
				});
			}
			{
				jButtonDelete = new JButton();	//ɾ����ť
				getContentPane().add(jButtonDelete);
				jButtonDelete.setText("\u5220\u9664");
				jButtonDelete.setBounds(353, 397, 79, 26);
				jButtonDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						
						int row = jTable.getSelectedRow();//���ѡ�е��к�
						//�����ѡ�е�ֵ�����������к���ȷ��ѡ��ĳһ����Ԫ��
						int bookId = Integer.parseInt((String)jTable.getValueAt(row, 0));
						
						
						int i = JOptionPane.showConfirmDialog(QueryBookFrame.this, "ȷ��ɾ����");
						if(i == 0){
							//����deleteBookInfo����
							int result = bookDao.deleteBookInfo(bookId);
							if(result>0){
								JOptionPane.showMessageDialog(QueryBookFrame.this, "ɾ���ɹ���");
								//�ڴ˴����Ʊ����Ϊ��ˢ�²�ѯ���棬ͬ����Ӧ����
								TableModel jTableModel = getTableModel();
								jTable.setModel(jTableModel);//���´����ݿ��м������ݷŵ������
							}else{
								JOptionPane.showMessageDialog(QueryBookFrame.this, "ɾ��ʧ�ܣ�");
							}
						}
						
						
					}
				});
			}
			{
				jButtonReturn = new JButton();	//���ذ�ť
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
	 * ���ر����Ϣ����
	 * @return
	 */
	private TableModel getTableModel() {
		List<BookInfo> list = bookDao.queryBookInfo();
		//������ά�����ű����Ϣ
		String[][] content = new String[list.size()][7];
		for(int i=0;i<list.size();i++){
			BookInfo book = list.get(i);//��ȡ�����е�Ԫ��
			content[i][0] = String.valueOf(book.getBookId());
			content[i][1] = book.getBookName();
			content[i][2] = book.getBookType();
			content[i][3] = book.getBookWriter();
			content[i][4] = book.getPublish();
			content[i][5] = book.getPublicDate();
			content[i][6] = String.valueOf(book.getBookPrice());
		}
		String[] column = new String[] { "ͼ���", "ͼ����", "ͼ������" , "����" , "������" , "��������" , "�۸�"  };
		TableModel jTableModel = new DefaultTableModel(content,column);
		return jTableModel;
	}
	/**
	 * �޸����ݺ�ˢ�±�񷽷�
	 */
	public void refresh(){
		TableModel jTableModel = this.getTableModel();
		jTable.setModel(jTableModel);
	}

}
