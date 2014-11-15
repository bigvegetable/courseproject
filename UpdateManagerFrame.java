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
public class UpdateManagerFrame extends javax.swing.JFrame {
	private JLabel jLabelTitle;
	private JLabel jLabelUserName;
	private JLabel jLabelMagPassword;
	private JTextField jTextMagName;
	private JButton jButtonCancel;
	private JButton jButtonEnsure;
	private JPasswordField jPassword;
	private int magId;
	private ManagerDao magDao = new ManagerDaoImpl();

	/**
	* Auto-generated main method to display this JFrame
	*/
	
	public UpdateManagerFrame() {
		super();
		initGUI();
	}
	public UpdateManagerFrame(int magId) {
		super();
		this.magId = magId;
		initGUI();
		fillInfo();
	}
	private void fillInfo(){
		Manager manager = magDao.queryManagerById(magId);
		jTextMagName.setText(manager.getMagName());
		jPassword.setText(manager.getMagPassword());
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabelTitle = new JLabel();
				getContentPane().add(jLabelTitle);
				jLabelTitle.setText("\u4fee\u6539\u7ba1\u7406\u5458\u4fe1\u606f");
				jLabelTitle.setBounds(64, 22, 157, 23);
				jLabelTitle.setFont(new java.awt.Font("宋体",1,20));
			}
			{
				jLabelUserName = new JLabel();
				getContentPane().add(jLabelUserName);
				jLabelUserName.setText("\u7528\u6237\u540d");
				jLabelUserName.setBounds(35, 72, 52, 17);
				jLabelUserName.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jLabelMagPassword = new JLabel();
				getContentPane().add(jLabelMagPassword);
				jLabelMagPassword.setText("\u5bc6\u7801");
				jLabelMagPassword.setBounds(35, 130, 52, 17);
				jLabelMagPassword.setHorizontalAlignment(SwingConstants.CENTER);
			}
			{
				jTextMagName = new JTextField();
				getContentPane().add(jTextMagName);
				jTextMagName.setBounds(105, 69, 139, 24);
			}
			{
				jPassword = new JPasswordField();
				getContentPane().add(jPassword);
				jPassword.setBounds(105, 127, 139, 24);
			}
			{
				jButtonEnsure = new JButton();
				getContentPane().add(jButtonEnsure);
				jButtonEnsure.setText("\u786e\u5b9a");
				jButtonEnsure.setBounds(57, 188, 63, 24);
				jButtonEnsure.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String magName = jTextMagName.getText().trim();
						String magPassword = String.valueOf(jPassword.getPassword());
						Manager manager = new Manager(magId, magName, magPassword);
						int result = magDao.updateReader(manager);
						if(result>0){
							JOptionPane.showMessageDialog(UpdateManagerFrame.this, "修改成功！");
							QueryManagerFrame queryFrame = QueryManagerFrame.getInstance();
							queryFrame.refresh();
							UpdateManagerFrame.this.dispose();
						}else{
							JOptionPane.showMessageDialog(UpdateManagerFrame.this, "修改失败！");
						}
					}
				});
			}
			{
				jButtonCancel = new JButton();
				getContentPane().add(jButtonCancel);
				jButtonCancel.setText("\u53d6\u6d88");
				jButtonCancel.setBounds(165, 188, 63, 24);
				jButtonCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						UpdateManagerFrame.this.dispose();
					}
				});
			}
			pack();
			this.setSize(310, 280);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
