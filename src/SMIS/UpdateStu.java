package ѧ����Ϣ����ϵͳ;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStu extends JFrame {
	private JTextField textField;
	private JTextField textField_2;
	public UpdateStu() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(190, 27, 231, 85);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u4FEE\u6539\u7684\u5B66\u751F\u5B66\u53F7\uFF1A");
		label.setBounds(0, 0, 241, 39);
		panel.add(label);
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setBounds(0, 43, 231, 33);
		panel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(190, 143, 231, 103);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u60A8\u8981\u4FEE\u6539\u7684\u5C5E\u6027\uFF1A");
		label_1.setBounds(19, 13, 198, 32);
		panel_1.add(label_1);
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ID", "Sname", "Ssex", "Sbirth", "Stel", "Sacademy", "Sclass", "Saddress"}));
		comboBox.setBounds(45, 58, 152, 32);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(190, 284, 231, 79);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u65B0\u6570\u636E\uFF1A");
		label_2.setBounds(51, 0, 126, 37);
		panel_2.add(label_2);
		label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		
		textField_2 = new JTextField();
		textField_2.setBounds(51, 36, 126, 33);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(111, 388, 393, 39);
		getContentPane().add(panel_3);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������ѧ��!","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField.getText(), textField.getText().length())){
					JOptionPane.showMessageDialog(null, "ѧ�Ž���������ɣ��������ѧ����ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
				}else if(!MysqlConn.querystu(textField.getText())){
					JOptionPane.showMessageDialog(null,"�������ѧ��������ѧ�Ų�����!\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
				}else if(textField_2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������������!","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
				}else{
					MysqlConn.stuid = textField.getText();
					String s = (String) comboBox.getSelectedItem();//Ҫ�޸ĵ�����
					String s1 = textField_2.getText();//������ֵ
					
					/*//��s1Ӧ���м��
					if(s.equals("ID")){
						if(!JudgeNum.judge(s1, s1.length())){
							JOptionPane.showMessageDialog(null, "ѧ�Ž���������ɣ��������ѧ����ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
						}else{
							MysqlConn.updatestu(MysqlConn.stuid,s,s1);
						}
					}else if(s.equals("Stel")){
						if(!JudgeNum.judge(s1, s1.length())){
							JOptionPane.showMessageDialog(null, "�绰�������������ɣ�������ĺ�����ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
						}else{
							MysqlConn.updatestu(MysqlConn.stuid,s,s1);
						}
					}else{
						MysqlConn.updatestu(MysqlConn.stuid,s,s1);
					}*/
				}
			}
		});
		panel_3.add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_2.setText("");
			}
		});
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Stu st = new Stu();
			}
		});
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_3.add(button_3);
		
		this.setTitle("ѧ����Ϣ����ϵͳ-����Ա-�޸�ѧ����Ϣ");
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
