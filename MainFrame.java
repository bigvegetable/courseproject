package org.frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


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
public class MainFrame extends javax.swing.JFrame {
	private JMenuBar jMenuBar;
	private JMenu jMenuManager;
	private JMenuItem jItemBorrowBook;
	private JMenuItem jItemQueryBorrow;
	private JMenu jMenuReader;
	private JMenu jMenuBorrow;
	private JMenuItem jItemAddBook;
	private JMenuItem jItemQueryReader;
	private JMenuItem jMenuUpdateReader;
	private JMenuItem jItemAddReader;
	private JMenuItem jItemUpdateBook;
	private JMenuItem jItemQueryBook;
	private JMenuItem jItemManager;
	private JMenu jMenuHelp;
	private JMenu jMenuBookInfo;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame inst = new MainFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MainFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			pack();
			this.setBounds(0, 0, 600, 430);
			getContentPane().setLayout(null);
			{
				jMenuBar = new JMenuBar();
				setJMenuBar(jMenuBar);
				{
					jMenuManager = new JMenu();
					jMenuBar.add(jMenuManager);
					jMenuManager.setText("\u7ba1\u7406\u5458\u4fe1\u606f  ");
					{
						jItemManager = new JMenuItem();//修改管理员信息菜单项
						jMenuManager.add(jItemManager);
						jItemManager.setText("\u4fee\u6539\u7ba1\u7406\u5458\u4fe1\u606f");
						jItemManager.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryManagerFrame updateManager = QueryManagerFrame.getInstance();
								updateManager.setVisible(true);
							}
						});
					}
				}
				{
					jMenuBookInfo = new JMenu();
					jMenuBar.add(jMenuBookInfo);
					jMenuBookInfo.setText("\u56fe\u4e66\u7ba1\u7406  ");
					{
						jItemQueryBook = new JMenuItem();	//查询图书菜单项
						jMenuBookInfo.add(jItemQueryBook);
						jItemQueryBook.setText("\u67e5\u8be2\u56fe\u4e66\u4fe1\u606f");
						jItemQueryBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryBookFrame queryFrame = QueryBookFrame.getInstance();
								queryFrame.setVisible(true);
							}
						});
					}
					{
						jItemAddBook = new JMenuItem();//添加图书菜单项
						jMenuBookInfo.add(jItemAddBook);
						jItemAddBook.setText("\u8521\u8212\u5578");
						jItemAddBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddBookFrame addBookFrame = new AddBookFrame();
								addBookFrame.setVisible(true);
								
							}
						});
					}
					{
						jItemUpdateBook = new JMenuItem();	//修改图书信息菜单项
						jMenuBookInfo.add(jItemUpdateBook);
						jItemUpdateBook.setText("\u4fee\u6539\u56fe\u4e66\u4fe1\u606f");
						jItemUpdateBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								
								QueryBookFrame queryFrame = QueryBookFrame.getInstance();
								queryFrame.setVisible(true);
							}
						});
					}
				}
				{
					jMenuReader = new JMenu();
					jMenuBar.add(jMenuReader);
					jMenuReader.setText("\u8bfb\u8005\u7ba1\u7406  ");
					{
						jItemQueryReader = new JMenuItem();//查询读者信息菜单项
						jMenuReader.add(jItemQueryReader);
						jItemQueryReader.setText("\u67e5\u8be2\u8bfb\u8005\u4fe1\u606f");
						jItemQueryReader.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryReaderFrame queryReader = QueryReaderFrame.getInstance();
								queryReader.setVisible(true);
							}
						});
					}
					{
						jItemAddReader = new JMenuItem();//添加读者信息菜单项
						jMenuReader.add(jItemAddReader);
						jItemAddReader.setText("\u6dfb\u52a0\u8bfb\u8005\u4fe1\u606f");
						jItemAddReader.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddReaderFrame add = new AddReaderFrame();
								add.setVisible(true);
							}
						});
					}
					{
						jMenuUpdateReader = new JMenuItem();//修改读者信息菜单项
						jMenuReader.add(jMenuUpdateReader);
						jMenuUpdateReader.setText("\u4fee\u6539\u8bfb\u8005\u4fe1\u606f");
						jMenuUpdateReader.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddReaderFrame addFrame = new AddReaderFrame();
								addFrame.setVisible(true);
							}
						});
						
					}
				}
				{
					jMenuBorrow = new JMenu();
					jMenuBar.add(jMenuBorrow);
					jMenuBorrow.setText("\u501f\u9605\u7ba1\u7406  ");
					{
						jItemQueryBorrow = new JMenuItem();//图书借阅查询
						jMenuBorrow.add(jItemQueryBorrow);
						jItemQueryBorrow.setText("\u67e5\u8be2\u501f\u9605\u4fe1\u606f");
						jItemQueryBorrow.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								QueryBorrowFrame queryFrame = new QueryBorrowFrame();
								queryFrame.setVisible(true);
							}
						});
					}
					{
						jItemBorrowBook = new JMenuItem();//图书借阅管理
						jMenuBorrow.add(jItemBorrowBook);
						jItemBorrowBook.setText("\u56fe\u4e66\u501f\u8fd8\u7ba1\u7406");
						jItemBorrowBook.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								AddBorrowFrame add = new AddBorrowFrame();
								add.setVisible(true);
							}
						});
					}
				}
				{
					jMenuHelp = new JMenu();
					jMenuBar.add(jMenuHelp);
					jMenuHelp.setText("\u5e2e\u52a9");
				}
			}
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
