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
	private JPanel panel_main =null;//�����
	private JPanel panel_left =null;
	private JPanel panel_right =null;
	
	private JLabel lb_uname =null;//�û���ǩ
	private JLabel lb_upass =null;
	private JLabel lb_type =null;
	
	private JTextField tf_uname=null;//�û��ı���
	private JPasswordField pf_pass=null;
	
	private JLabel lb_img=null;//ͼƬ��
	
	private JButton btn_login=null;//��½��ť
	private JButton btn_register=null;//ע�ᰴť
	private JComboBox<String> cb_type =null;//��½���������б�
	public LoginView(){
		init();
	}
	private void init(){
		this.setSize(320,220);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("��½����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ʼ�����
		panel_main=new JPanel(new GridLayout(1, 2));
		panel_left=new JPanel();
		panel_right=new JPanel(new GridLayout(4, 2,0,10));
		//��ʼ���ؼ�
		tf_uname=new JTextField(8);
		pf_pass =new JPasswordField(8);
		cb_type=new JComboBox<String>(new String []{"��ͨ�û�","����Ա"});
		btn_login =new JButton("��½");
		btn_register =new JButton("ע��");
		lb_uname=new JLabel("�� ��",JLabel.CENTER);
		lb_upass=new JLabel("����",JLabel.CENTER);
		lb_type=new JLabel("����",JLabel.CENTER);
		lb_img= new JLabel(new ImageIcon(ClassLoader.getSystemResource("images/login.jpg")));
		//����Ӧ�Ŀؼ����������
		panel_left.add(lb_img);
		panel_right.add(lb_uname);
		panel_right.add(tf_uname);
		panel_right.add(lb_upass);
		panel_right.add(pf_pass);
		panel_right.add(lb_type);
		panel_right.add(cb_type);
		panel_right.add(btn_login);
		panel_right.add(btn_register);
		
		//������з������������
		panel_main.add(panel_left);
		panel_main.add(panel_right);
		//�ٰ������ŵ�������
		this.getContentPane().add(panel_main);
		this.pack();
		
		
		
		
		
		
		
		
		
		this.setVisible(true);
	}
	
	

}
