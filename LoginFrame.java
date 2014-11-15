package org.frame;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import org.entity.Manager;
import org.impl.ManagerDaoImpl;
import org.interfaceDao.ManagerDao;


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
public class LoginFrame extends javax.swing.JFrame {
	private JLabel jLabelLogin;
	private JPasswordField jTextPassword;
	private JButton jButtonCancel;
	private JButton jButtonLogin;
	private JTextField jTextMagName;
	private JLabel jLabelPassword;
	private JLabel jLabelMagName;
	private ManagerDao managerDao = new ManagerDaoImpl();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginFrame inst = new LoginFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public LoginFrame() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelLogin = new JLabel();
				getContentPane().add(jLabelLogin);
				jLabelLogin.setText("\u7528\u6237\u767b\u5f55");
				jLabelLogin.setBounds(128, 36, 127, 28);
				jLabelLogin.setFont(new java.awt.Font("宋体",0,20));
				jLabelLogin.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelMagName = new JLabel();
				getContentPane().add(jLabelMagName);
				jLabelMagName.setText("\u7528\u6237\u540d\uff1a");
				jLabelMagName.setBounds(58, 100, 59, 20);
				jLabelMagName.setFont(new java.awt.Font("宋体",0,14));
			}
			{
				jLabelPassword = new JLabel();
				getContentPane().add(jLabelPassword);
				jLabelPassword.setText("\u5bc6  \u7801\uff1a");
				jLabelPassword.setBounds(58, 153, 59, 20);
				jLabelPassword.setFont(new java.awt.Font("宋体",0,14));
			}
			{
				jTextMagName = new JTextField();
				getContentPane().add(jTextMagName);
				jTextMagName.setBounds(135, 100, 160, 24);
			}
			{
				jTextPassword = new JPasswordField();
				getContentPane().add(jTextPassword);
				jTextPassword.setBounds(135, 153, 160, 24);
			}
			{
				jButtonLogin = new JButton();		//登录按钮
				getContentPane().add(jButtonLogin);
				jButtonLogin.setText("\u767b  \u5f55");
				jButtonLogin.setBounds(90, 227, 74, 28);
				jButtonLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						//获得用户名和密码
						String magName = jTextMagName.getText().trim();//trim用于截取空格
						String magPassword = String.valueOf(jTextPassword.getPassword());
					
						//调用magLogin方法
						Manager mag = managerDao.magLogin(magName, magPassword);
						if(mag != null){
							JOptionPane.showMessageDialog(LoginFrame.this, "登录成功！");
							MainFrame mainFrame = new MainFrame();
							mainFrame.setVisible(true);
							LoginFrame.this.setVisible(false);
						}else{
							JOptionPane.showMessageDialog(LoginFrame.this, "用户名或密码错误！请重新登录");
							jTextMagName.setText("");
							jTextPassword.setText("");
						}
					}
				});
			}
			{
				jButtonCancel = new JButton();	//取消按钮
				getContentPane().add(jButtonCancel);
				jButtonCancel.setText("\u53d6  \u6d88");
				jButtonCancel.setBounds(207, 227, 74, 28);
				jButtonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.exit(0);
					}
				});
			}
			pack();
			
			this.setSize(400, 340);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	

}
