package ѧ����Ϣ����ϵͳ;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertCou extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public InsertCou() {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(134, 49, 379, 265);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("����д��Ҫ��ӵĿγ���Ϣ��");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label.setBounds(79, 14, 238, 36);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_1.setBounds(104, 76, 77, 41);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(181, 80, 110, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_2.setBounds(105, 137, 77, 41);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 137, 110, 34);
		panel.add(textField_1);
		
		JLabel label_3 = new JLabel("\u5B66\u5206\uFF1A");
		label_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_3.setBounds(111, 199, 69, 41);
		panel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 201, 110, 34);
		panel.add(textField_2);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������γ̺�!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField.getText(), textField.getText().length())){
					JOptionPane.showMessageDialog(null,"�γ̺Ž���������ɣ�������Ŀγ̺���ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(MysqlConn.querycou(textField.getText())){
					JOptionPane.showMessageDialog(null,"�ÿγ��Ѵ���!\n����������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������γ���!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(textField_2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������ѧ��!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField_2.getText())){
					JOptionPane.showMessageDialog(null,"������ѧ�ֵ���ȷ��ʽ!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else{
					MysqlConn.cno = textField.getText();
					MysqlConn.cname = textField_1.getText();
					MysqlConn.stucredit = Double.parseDouble(textField_2.getText());
					
					MysqlConn.insertcou(MysqlConn.cno,MysqlConn.cname,MysqlConn.stucredit);
				}
			}
		});
		button.setBounds(146, 345, 78, 41);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		button_1.setBounds(237, 344, 78, 41);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cou co = new Cou();
			}
		});
		button_2.setBounds(330, 344, 78, 41);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(423, 343, 78, 41);
		getContentPane().add(button_3);
		
		//���������ñ���
		this.setTitle("ѧ����Ϣ����ϵͳ-����Ա-��ӿγ���Ϣ");
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

	public InsertCou(String s) {
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(134, 49, 379, 265);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("����д��Ҫ�޸ĵĿγ���Ϣ��");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label.setBounds(79, 14, 238, 36);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u53F7\uFF1A");
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_1.setBounds(104, 76, 77, 41);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(181, 80, 110, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u540D\uFF1A");
		label_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_2.setBounds(105, 137, 77, 41);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 137, 110, 34);
		panel.add(textField_1);
		
		JLabel label_3 = new JLabel("\u5B66\u5206\uFF1A");
		label_3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label_3.setBounds(111, 199, 69, 41);
		panel.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 201, 110, 34);
		panel.add(textField_2);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MysqlConn.ConnectSQL();
				if(textField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������γ̺�!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField.getText(), textField.getText().length())){
					JOptionPane.showMessageDialog(null,"�γ̺Ž���������ɣ�������Ŀγ̺���ʽ����!\n����������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(MysqlConn.querycou(textField.getText())){
					JOptionPane.showMessageDialog(null,"�ÿγ̲�����!\n����������", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(textField_1.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������γ���!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(textField_2.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"������ѧ��!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else if(!JudgeNum.judge(textField_2.getText())){
					JOptionPane.showMessageDialog(null,"������ѧ�ֵ���ȷ��ʽ!", "��ʾ��Ϣ", JOptionPane.WARNING_MESSAGE);
				}else{
					MysqlConn.cno = textField.getText();
					MysqlConn.cname = textField_1.getText();
					MysqlConn.stucredit = Double.parseDouble(textField_2.getText());
					
					MysqlConn.updatecou(MysqlConn.cno,MysqlConn.cname,MysqlConn.stucredit);
				}
			}
		});
		button.setBounds(146, 345, 78, 41);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		button_1.setBounds(237, 344, 78, 41);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cou co = new Cou();
			}
		});
		button_2.setBounds(330, 344, 78, 41);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_3.setBounds(423, 343, 78, 41);
		getContentPane().add(button_3);
		
		//���������ñ���
		this.setTitle("ѧ����Ϣ����ϵͳ-����Ա-�޸Ŀγ���Ϣ");
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
