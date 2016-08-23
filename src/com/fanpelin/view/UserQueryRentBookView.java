package com.fanpelin.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public class UserQueryRentBookView extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2412906289144051248L;
	private JPanel paneltable=null;//用来保存Jtable的一个面板
	private JTable table =null;//声明JTable
	private JPanel panelButton=null;//按钮面板
	private JButton btn_search=null;
	private JButton btn_lend=null;
	private JButton btn_exit =null;
	private JComboBox<String> cb_type=null;
	private JLabel lb_type=null;
	public UserQueryRentBookView(){
		init();
	}
	private void init() {
		this.setTitle("");
		this.setSize(800,500);
		this.setIconifiable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		table =new JTable();
		paneltable=new JPanel(new BorderLayout());//创建面板
		//给面板设置边框
		paneltable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null,null),"查询信息"));
		paneltable.add(table);
		this.add(paneltable,BorderLayout.CENTER);
		panelButton=new JPanel(new GridLayout(7, 1,10,30));
		panelButton.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(null,null),"查询条件"));
		this.add(panelButton, BorderLayout.EAST);
		lb_type=new JLabel("查询类型");
		panelButton.add(lb_type);
		cb_type=new JComboBox<String>(new String []{"全部","已借","热门"});
		
		panelButton.add(cb_type);
		btn_search=new JButton("查询");
		panelButton.add(btn_search);
		btn_lend=new JButton("借");
		btn_lend.setEnabled(false);
		panelButton.add(btn_lend);
		panelButton.add(new JLabel());
		panelButton.add(new JLabel());
		btn_exit=new JButton("退出");
		panelButton.add(btn_exit);
		this.setVisible(true);
		
		
		
		
		
		
		
		
		
	}
}
