package ѧ����Ϣ����ϵͳ;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryCou extends JFrame {
	private JTable table;
	public QueryCou() {
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 148, 525, 180);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u8BFE\u7A0B\u540D", "\u8BFE\u7A0B\u53F7", "\u5B66\u5206"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		MysqlConn.ConnectSQL();
		MysqlConn.getdatacou();
		
		if(MysqlConn.counter == 0){
			JOptionPane.showMessageDialog(null, "�γ̻�δ����!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
		}
			
		for(int i = 0; i < MysqlConn.counter; i++){
			table.setValueAt(MysqlConn.c_name[i], i, 0);
			table.setValueAt(MysqlConn.c_no[i], i, 1);
			table.setValueAt(MysqlConn.credit[i], i, 2);
		}
		
		JLabel label = new JLabel("\u6240\u6709\u8BFE\u7A0B\u4FE1\u606F\u5982\u4E0B\uFF1A");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label.setBounds(235, 76, 164, 45);
		getContentPane().add(label);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Cou co = new Cou();
			}
		});
		button.setBounds(199, 367, 89, 36);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(362, 367, 89, 36);
		getContentPane().add(button_1);
		
		//���������ñ���
		this.setTitle("ѧ����Ϣ����ϵͳ-����Ա-��ѯ�γ���Ϣ");
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
