package ѧ����Ϣ����ϵͳ;

import java.awt.event.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;

//��ѯ�����½�ʦ��ѧ����Ϣ
public class Admin extends JFrame {
	JButton jb1,jb2 = null;
	JRadioButton jrb1,jrb2 = null;
	JLabel jl = null;
	JPanel jp = null;
	ButtonGroup bg = null;
	
	public Admin() {
		getContentPane().setLayout(null);
		
		jp = new JPanel();
		jp.setBounds(125, 184, 386, 190);
		getContentPane().add(jp);
		jp.setLayout(null);
		
		jl = new JLabel("\u64CD\u4F5C\u5BF9\u8C61");
		jl.setBounds(29, 48, 60, 37);
		jp.add(jl);
		
		jrb1 = new JRadioButton("\u5B66\u751F");//ѧ��
		jrb1.setBounds(118, 48, 59, 37);
		jp.add(jrb1);
		
		jrb2 = new JRadioButton("\u6559\u5E08");//��ʦ
		jrb2.setBounds(206, 48, 59, 37);
		jp.add(jrb2);
		
		bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		jb1 = new JButton("\u786E\u5B9A");
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				if(jrb1.isSelected()){
					Stu st = new Stu();
				}
				else if(jrb2.isSelected()){
					Tea ta = new Tea();
				}else{
					Cou co = new Cou();
				}
			}
		});
		jb1.setBounds(41, 109, 72, 42);
		jp.add(jb1);
		

		JButton jb2 = new JButton("\u9000\u51FA");
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jb2.setBounds(267, 109, 76, 42);
		jp.add(jb2);
		
		JRadioButton radioButton = new JRadioButton("\u8BFE\u7A0B");
		radioButton.setBounds(294, 48, 59, 37);
		jp.add(radioButton);
		bg.add(radioButton);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l = new Login();
			}
		});
		button.setBounds(154, 109, 72, 42);
		jp.add(button);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u767B\u5F55\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF\uFF01");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 46));
		label.setBounds(14, 55, 604, 60);
		getContentPane().add(label);
		
		//���������ñ���
		this.setTitle("ѧ����Ϣ����ϵͳ-����Ա");
		//���ô����С
		this.setSize(650,520);
		//���ô����ʼλ��
		this.setLocation(200, 150);
		//���õ��رմ���ʱ����֤JVMҲ�˳�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��ʾ����
		this.setVisible(true);
		//�����С�ɱ�
		this.setResizable(true);
	}
}
