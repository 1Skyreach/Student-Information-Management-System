package ѧ����Ϣ����ϵͳ;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertGra extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	public InsertGra() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		lblNewLabel.setBounds(218, 88, 61, 39);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(286, 90, 151, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u6210\u7EE9\uFF1A");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label.setBounds(218, 196, 61, 39);
		getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(306, 198, 110, 39);
		getContentPane().add(textField_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������ѧ��!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField.getText(), textField.getText().length())){
					JOptionPane.showMessageDialog(null, "ѧ�Ž���������ɣ��������ѧ����ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else if(!MysqlConn.querystu(textField.getText())){
					JOptionPane.showMessageDialog(null, "�������ѧ��������ѧ�Ų�����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������ѧ���ɼ�!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField_1.getText(), textField_1.getText().length())){
					JOptionPane.showMessageDialog(null, "�ɼ�����������ɣ�������ĳɼ���ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else if(Integer.parseInt(textField_1.getText()) > 100 || Integer.parseInt(textField_1.getText()) < 0){
					JOptionPane.showMessageDialog(null, "������ĳɼ���ʽ����!\n������0~100�е�����", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else{
					MysqlConn.stuid = textField.getText();
					MysqlConn.stugrade = Integer.parseInt(textField_1.getText());
					MysqlConn.stupoint = Calculate.calculatepoi(MysqlConn.stugrade);
					
					//��õ�ǰ��¼��ʦ��Ϣ�������̿γ�
					MysqlConn.getdatatea(MysqlConn.userword);
					
					//�˴�Ӧ��������óɼ��Ѵ��ڵ����
					if(MysqlConn.querycou(MysqlConn.stuid, MysqlConn.cname)){
						JOptionPane.showMessageDialog(null, "��ѧ���˿γ̳ɼ��Ѵ���!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
					}else{
						MysqlConn.insertgra(MysqlConn.stuid,MysqlConn.cno,MysqlConn.stugrade,MysqlConn.stupoint);
					}
				}
			}
		});
		button.setBounds(132, 308, 84, 39);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		button_1.setBounds(222, 308, 84, 39);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Teacher t = new Teacher();
			}
		});
		button_2.setBounds(315, 308, 84, 39);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(408, 308, 84, 39);
		getContentPane().add(button_3);
		
		this.setTitle("ѧ����Ϣ����ϵͳ-����Ա-¼��ѧ���ɼ�");
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
	
	public InsertGra(String s) {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		lblNewLabel.setBounds(218, 88, 61, 39);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(286, 90, 151, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u6210\u7EE9\uFF1A");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label.setBounds(218, 196, 61, 39);
		getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(306, 198, 110, 39);
		getContentPane().add(textField_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������ѧ��!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField.getText(), textField.getText().length())){
					JOptionPane.showMessageDialog(null, "ѧ�Ž���������ɣ��������ѧ����ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else if(!MysqlConn.querystu(textField.getText())){
					JOptionPane.showMessageDialog(null, "�������ѧ��������ѧ�Ų�����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������ѧ���ɼ�!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField_1.getText(), textField_1.getText().length())){
					JOptionPane.showMessageDialog(null, "�ɼ�����������ɣ�������ĳɼ���ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else if(Integer.parseInt(textField_1.getText()) > 100 || Integer.parseInt(textField_1.getText()) < 0){
					JOptionPane.showMessageDialog(null, "������ĳɼ���ʽ����!\n������0~100�е�����", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else{
					MysqlConn.stuid = textField.getText();
					MysqlConn.stugrade = Integer.parseInt(textField_1.getText());
					MysqlConn.stupoint = Calculate.calculatepoi(MysqlConn.stugrade);
					
					//��õ�ǰ��¼��ʦ��Ϣ�������̿γ�
					MysqlConn.getdatatea(MysqlConn.userword);
					
					//�˴�Ӧ��������óɼ��Ѵ��ڵ����
					if(!MysqlConn.querycou(MysqlConn.stuid, MysqlConn.cname)){
						JOptionPane.showMessageDialog(null, "��ѧ���˿γ̳ɼ�������!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
					}else{
						MysqlConn.updategra(MysqlConn.stuid,MysqlConn.cno,MysqlConn.stugrade,MysqlConn.stupoint);
					}
				}
			}
		});
		button.setBounds(132, 308, 84, 39);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		button_1.setBounds(222, 308, 84, 39);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Teacher t = new Teacher();
			}
		});
		button_2.setBounds(315, 308, 84, 39);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(408, 308, 84, 39);
		getContentPane().add(button_3);
		
		this.setTitle("ѧ����Ϣ����ϵͳ-����Ա-�޸�ѧ���ɼ�");
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