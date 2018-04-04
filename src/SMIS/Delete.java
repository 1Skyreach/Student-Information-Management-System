package ѧ����Ϣ����ϵͳ;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {
	private JTextField textField;
	public Delete() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(152, 103, 321, 162);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u5B66\u53F7/\u6559\u5E08\u53F7/\u8BFE\u7A0B\u53F7\uFF1A");
		label.setBounds(0, 5, 321, 37);
		panel.add(label);
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setBounds(72, 66, 159, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u5B66\u751F");
		rdbtnNewRadioButton.setBounds(31, 107, 59, 37);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton radioButton = new JRadioButton("\u6559\u5E08");
		radioButton.setBounds(121, 107, 59, 37);
		panel.add(radioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u8BFE\u7A0B");
		radioButton_1.setBounds(211, 107, 59, 37);
		panel.add(radioButton_1);
		bg.add(radioButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(141, 302, 343, 52);
		getContentPane().add(panel_1);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.setBounds(8, 5, 76, 40);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������ѧ�Ż��ʦ�Ż�γ̺�!","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField.getText(), textField.getText().length())){
					JOptionPane.showMessageDialog(null, "ѧ�Ż��ʦ�Ż�γ̺Ž���������ɣ��������ѧ�Ż��ʦ�Ż�γ̺���ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else if(!rdbtnNewRadioButton.isSelected() && !radioButton.isSelected() && !radioButton_1.isSelected()){
					JOptionPane.showMessageDialog(null,"��ѡ��ѧ�����ʦ��γ�!","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(rdbtnNewRadioButton.isSelected()){
					if(!MysqlConn.querystu(textField.getText())){
						JOptionPane.showMessageDialog(null,"�������ѧ������!\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
					}else{
						int option = JOptionPane.showConfirmDialog(null, "��ȷ��ɾ����ѧ����", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
						if(option == JOptionPane.OK_OPTION){
							MysqlConn.stuid = textField.getText();
							
							//ִ��ɾ������
							MysqlConn.deletestu(MysqlConn.stuid);
						}else {
							textField.setText("");
						}
					}
				}else if(radioButton.isSelected()){
					if(!MysqlConn.querytea(textField.getText())){
						JOptionPane.showMessageDialog(null,"������Ľ�ʦ������!\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
					}else{
						int option = JOptionPane.showConfirmDialog(null, "��ȷ��ɾ���ý�ʦ��", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
						if(option == JOptionPane.OK_OPTION){
							MysqlConn.teaid = textField.getText();
						
							//ִ��ɾ������
							MysqlConn.deletetea(MysqlConn.teaid);
						}else {
							textField.setText("");
						}
					}
				}else{
					if(!MysqlConn.querycou(textField.getText())){
						JOptionPane.showMessageDialog(null,"������Ľ�ʦ������!\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
					}else{
						int option = JOptionPane.showConfirmDialog(null, "��ȷ��ɾ���ÿγ���", "��ʾ��Ϣ", JOptionPane.OK_CANCEL_OPTION);
						if(option == JOptionPane.OK_OPTION){
							MysqlConn.cno = textField.getText();
						
							//ִ��ɾ������
							MysqlConn.deletecou(MysqlConn.cno);
						}else {
							textField.setText("");
						}
					}
				}
			}
		});
		panel_1.setLayout(null);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(176, 5, 76, 40);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin ad = new Admin();
			}
		});
		
		JButton button_2 = new JButton("\u91CD\u7F6E");
		button_2.setBounds(92, 5, 76, 40);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		panel_1.add(button_2);
		panel_1.add(button_1);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.setBounds(260, 5, 76, 40);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_1.add(button_3);
		
		this.setTitle("ѧ����Ϣ����ϵͳ-����Ա-ɾ��ѧ��/��ʦ/�γ�");
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
