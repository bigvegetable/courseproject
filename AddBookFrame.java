package org.frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
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
public class AddBookFrame extends javax.swing.JFrame {
	private JLabel jLabelAddBook;
	private JLabel jLabelDate;
	private JTextField jTextPrice;
	private JTextField jTextDate;
	private JTextField jTextBookId;
	private JLabel jLabelBookId;
	private JButton jButtonCancel;
	private JButton jButtonReset;
	private JButton jButtonEnsure;
	private JTextField jTextPublish;
	private JTextField jTextWriter;
	private JTextField jTextType;
	private JTextField jTextName;
	private JLabel jLabelPrice;
	private JLabel jLabelPublish;
	private JLabel jLabelWriter;
	private JLabel jLabelType;
	private JLabel jLabelName;
	private BookDao bookDao = new BookDaoImpl();

	/**
	* Auto-generated main method to display this JFrame
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AddBookFrame inst = new AddBookFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	*/
	public AddBookFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setResizable(false);
			//this.setDefaultLookAndFeelDecorated(true);
			{
				jLabelAddBook = new JLabel();
				getContentPane().add(jLabelAddBook);
				jLabelAddBook.setText("\u65b0\u589e\u56fe\u4e66\u4fe1\u606f");
				jLabelAddBook.setBounds(126, 24, 140, 30);
				jLabelAddBook.setHorizontalAlignment(SwingConstants.CENTER);
				jLabelAddBook.setFont(new java.awt.Font("宋体",1,20));
			}
			{
				jLabelName = new JLabel();
				getContentPane().add(jLabelName);
				jLabelName.setText("\u56fe\u4e66\u540d");
				jLabelName.setBounds(35, 135, 69, 22);
				jLabelName.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelType = new JLabel();
				getContentPane().add(jLabelType);
				jLabelType.setText("\u56fe\u4e66\u7c7b\u578b");
				jLabelType.setBounds(35, 180, 69, 22);
				jLabelType.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelWriter = new JLabel();
				getContentPane().add(jLabelWriter);
				jLabelWriter.setText("\u4f5c\u8005");
				jLabelWriter.setBounds(35, 227, 69, 22);
				jLabelWriter.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelPublish = new JLabel();
				getContentPane().add(jLabelPublish);
				jLabelPublish.setText("\u51fa\u7248\u793e");
				jLabelPublish.setBounds(35, 273, 69, 22);
				jLabelPublish.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelDate = new JLabel();
				getContentPane().add(jLabelDate);
				jLabelDate.setText("\u51fa\u7248\u65e5\u671f");
				jLabelDate.setBounds(35, 317, 69, 22);
				jLabelDate.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelPrice = new JLabel();
				getContentPane().add(jLabelPrice);
				jLabelPrice.setText("\u4ef7\u683c");
				jLabelPrice.setBounds(35, 363, 69, 22);
				jLabelPrice.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextName = new JTextField();
				getContentPane().add(jTextName);
				jTextName.setBounds(122, 135, 189, 24);
			}
			{
				jTextType = new JTextField();
				getContentPane().add(jTextType);
				jTextType.setBounds(122, 180, 189, 24);
			}
			{
				jTextWriter = new JTextField();
				getContentPane().add(jTextWriter);
				jTextWriter.setBounds(122, 227, 189, 24);
			}
			{
				jTextPublish = new JTextField();
				getContentPane().add(jTextPublish);
				jTextPublish.setBounds(122, 273, 189, 24);
			}
			{
				jTextDate = new JTextField();
				getContentPane().add(jTextDate);
				jTextDate.setBounds(122, 317, 189, 24);
			}
			{
				jTextPrice = new JTextField();
				getContentPane().add(jTextPrice);
				jTextPrice.setBounds(122, 363, 189, 24);
			}
			{
				jButtonEnsure = new JButton();	//确定按钮
				getContentPane().add(jButtonEnsure);
				jButtonEnsure.setText("\u786e\u5b9a");
				jButtonEnsure.setBounds(79, 426, 67, 25);
				jButtonEnsure.addActionListener(new ActionListener() {
					/**
					 * 确定按钮功能实现
					 */
					public void actionPerformed(ActionEvent evt) {
						int bookId = Integer.parseInt(jTextBookId.getText().trim());
						String bookName = jTextName.getText().trim();
						String bookType = jTextType.getText().trim();
						String bookWriter = jTextWriter.getText().trim();
						String publish = jTextPublish.getText().trim();
						String publicDate = jTextDate.getText().trim();
						float bookPrice = Float.parseFloat(jTextPrice.getText().trim());
						//调用BookDaoImpl中的addBookInfo方法
						BookInfo book = new BookInfo(bookId,bookName,bookType,bookWriter,publish,publicDate,bookPrice);
						int result = bookDao.addBookInfo(book);
						if(result>0){
							JOptionPane.showMessageDialog(AddBookFrame.this, "添加成功！");
							reset();
							QueryBookFrame queryFrame = QueryBookFrame.getInstance();
							queryFrame.refresh();
							
						}else{
							JOptionPane.showMessageDialog(AddBookFrame.this, "添加失败！");
						}
					}
				});
			}
			{
				jButtonReset = new JButton();	//重置按钮
				getContentPane().add(jButtonReset);
				jButtonReset.setText("\u91cd\u7f6e");
				jButtonReset.setBounds(168, 426, 67, 25);
				jButtonReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						reset();
					}

				
				});
			}
			{
				jButtonCancel = new JButton();	//查询按钮
				getContentPane().add(jButtonCancel);
				jButtonCancel.setText("\u67e5\u8be2");
				jButtonCancel.setBounds(259, 426, 67, 25);
				jButtonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						QueryBookFrame queryFrame = QueryBookFrame.getInstance();
						queryFrame.setVisible(true);
					}
				});
			}
			{
				jLabelBookId = new JLabel();
				getContentPane().add(jLabelBookId);
				jLabelBookId.setText("\u56fe\u4e66\u53f7");
				jLabelBookId.setBounds(35, 88, 69, 22);
				jLabelBookId.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextBookId = new JTextField();
				getContentPane().add(jTextBookId);
				jTextBookId.setBounds(122, 86, 185, 24);
			}
			pack();
			this.setSize(417, 517);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	private void reset() {
		jTextBookId.setText("");
		jTextName.setText("");
		jTextType.setText("");
		jTextWriter.setText("");
		jTextPublish.setText("");
		jTextDate.setText("");
		jTextPrice.setText("");
	}

}
