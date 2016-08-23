package com.fanpelin.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6064559739782638497L;
	private JPanel panel_main =null;//主面板
	private JPanel panel_left =null;
	private JPanel panel_right =null;
	
	private JLabel lb_uname =null;//用户标签
	private JLabel lb_upass =null;
	private JLabel lb_type =null;
	
	private JTextField tf_uname=null;//用户文本框
	private JPasswordField pf_pass=null;
	
	private JLabel lb_img=null;//图片框
	
	private JButton btn_login=null;//登陆按钮
	private JButton btn_register=null;//注册按钮
	private JComboBox<String> cb_type =null;//登陆类型下啦列表
	public LoginView(){
		init();
	}
	private void init(){
		this.setSize(320,220);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("登陆窗口");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//初始化面板
		panel_main=new JPanel(new GridLayout(1, 2));
		panel_left=new JPanel();
		panel_right=new JPanel(new GridLayout(4, 2,0,10));
		//初始化控件
		tf_uname=new JTextField(8);
		pf_pass =new JPasswordField(8);
		cb_type=new JComboBox<String>(new String []{"普通用户","管理员"});
		btn_login =new JButton("登陆");
		btn_register =new JButton("注册");
		lb_uname=new JLabel("用 户",JLabel.CENTER);
		lb_upass=new JLabel("密码",JLabel.CENTER);
		lb_type=new JLabel("类型",JLabel.CENTER);
		lb_img= new JLabel(new ImageIcon(ClassLoader.getSystemResource("images/login.jpg")));
		//把响应的控件放在面板中
		panel_left.add(lb_img);
		panel_right.add(lb_uname);
		panel_right.add(tf_uname);
		panel_right.add(lb_upass);
		panel_right.add(pf_pass);
		panel_right.add(lb_type);
		panel_right.add(cb_type);
		panel_right.add(btn_login);
		panel_right.add(btn_register);
		
		//主面板中放左右两个面板
		panel_main.add(panel_left);
		panel_main.add(panel_right);
		//再把主面板放到窗体中
		this.getContentPane().add(panel_main);
		this.pack();
		
		
		
		
		
		
		
		
		
		this.setVisible(true);
	}
	
	

}
