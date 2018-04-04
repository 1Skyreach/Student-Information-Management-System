package ѧ����Ϣ����ϵͳ;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QueryGra extends JFrame {
	private JTable table;
	public QueryGra() {
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		label.setBounds(172, 64, 152, 32);
		getContentPane().add(label);
		label.setText(MysqlConn.cname);
		
		MysqlConn.ConnectSQL();
		MysqlConn.getdatatea(MysqlConn.userword);
		MysqlConn.querygra(MysqlConn.cname);
		
		JLabel label_1 = new JLabel("\u7684\u6240\u6709\u5B66\u751F\u6210\u7EE9\u5982\u4E0B\uFF1A");
		label_1.setBounds(330, 64, 190, 32);
		label_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		getContentPane().add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 128, 568, 152);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u6210\u7EE9", "\u7EE9\u70B9"
			}
		));
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		
		for(int i = 0; i < MysqlConn.counter; i++){
			table.setValueAt(MysqlConn.stu_id[i], i, 0);
			table.setValueAt(MysqlConn.stu_name[i], i, 1);
			table.setValueAt(MysqlConn.stu_grade[i], i, 2);
			table.setValueAt(MysqlConn.stu_point[i], i, 3);
		}
		
		if(MysqlConn.counter == 0){
			JOptionPane.showMessageDialog(null, "�ÿγ���ʱû�гɼ�!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
		}
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Teacher t = new Teacher();
			}
		});
		button.setBounds(165, 339, 104, 39);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_1.setBounds(341, 339, 104, 39);
		getContentPane().add(button_1);
		
		this.setTitle("ѧ����Ϣ����ϵͳ-��ʦ-��ѯѧ���ɼ�");
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
