package ѧ����Ϣ����ϵͳ;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

	//�����¼��������
	JButton jb1,jb2,jb3=null;
	JRadioButton jrb1,jrb2,jrb3=null;
	JPanel jp4=null;
    JTextField jtf=null;
	JLabel jlb1,jlb2,jlb3=null;
	JPasswordField jpf=null;
	ButtonGroup bg=null;	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login ms=new Login();	
	}
	//���캯��
	public Login()
	{
		bg=new ButtonGroup();
		jp4=new JPanel();
		jp4.setBounds(0, 0, 0, 0);
		getContentPane().setLayout(null);
		getContentPane().add(jp4);
		
		jlb1=new JLabel("�û�����");
		jlb1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		jlb1.setBounds(181, 92, 83, 37);
		getContentPane().add(jlb1);
		
		jtf=new JTextField(12);
		jtf.setBounds(265, 92, 133, 37);
		getContentPane().add(jtf);
		
		jlb2=new JLabel("��    �룺");
		jlb2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		jlb2.setBounds(181, 161, 83, 37);
		getContentPane().add(jlb2);
		
		jpf = new JPasswordField(12);
		jpf.setBounds(265, 161, 133, 37);
		getContentPane().add(jpf);
		
		jlb3=new JLabel("Ȩ    �ޣ�");
		jlb3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		jlb3.setBounds(181, 227, 83, 37);
		getContentPane().add(jlb3);
		
		jrb1=new JRadioButton("����Ա");
		jrb1.setBounds(265, 227, 73, 37);
		getContentPane().add(jrb1);
		bg.add(jrb1);
		
		jrb2=new JRadioButton("��ʦ");
		jrb2.setBounds(349, 227, 59, 37);
		getContentPane().add(jrb2);
		bg.add(jrb2);
		
		jrb3=new JRadioButton("ѧ��",true);
		jrb3.setBounds(421, 227, 59, 37);
		getContentPane().add(jrb3);
		bg.add(jrb3);
		
		//�������
		jb1=new JButton("��¼");
		jb1.setBounds(181, 311, 76, 40);
		getContentPane().add(jb1);
		jb2=new JButton("����");
		jb2.setBounds(265, 311, 76, 40);
		getContentPane().add(jb2);
		jb3=new JButton("�˳�");
		jb3.setBounds(349, 311, 76, 40);
		getContentPane().add(jb3);
		jb3.addActionListener(this);
		jb2.addActionListener(this);
		//���ü���
		jb1.addActionListener(this);
		//���������ñ���
		this.setTitle("ѧ����Ϣ����ϵͳ-��¼");
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
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand()=="�˳�")
		{
			System.exit(0);
		}else if(e.getActionCommand()=="��¼")
		{
			if(!jtf.getText().isEmpty() && !String.valueOf(jpf.getPassword()).isEmpty())
			{
				//�������¼��ťʱ�����������ݿ⽨������
				MysqlConn.ConnectSQL();
				//���ѡ�й���Ա��¼
				if(jrb1.isSelected())
				{
					//�ж��Ƿ���ڸ��û�
					if(MysqlConn.queryadm(jtf.getText()))
					{
						//���õ�¼����
						this.adminlogin();
					}
				}else if(jrb2.isSelected())
				{
					//�ж��Ƿ���ڸ��û�
					if(MysqlConn.querytea(jtf.getText()))
					{
						MysqlConn.userword = jtf.getText();
						
						//���õ�¼����
						this.tealogin();
					}
				}else if(jrb3.isSelected())
				{
					//�ж��Ƿ���ڸ��û�
					
					if(MysqlConn.querystu(jtf.getText()))
					{
						MysqlConn.userword = jtf.getText();
						
						//���õ�¼����
						this.stulogin();
					}
				}
			}else if(jtf.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null,"�������û���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}else if(String.valueOf(jpf.getPassword()).isEmpty())	
			{
				JOptionPane.showMessageDialog(null,"����������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			    this.clear();
			}
		}else if(e.getActionCommand()=="����")
		{
			this.clear();
		}			
	}
	
	//����ı���������
	public void clear()
	{
		jtf.setText("");
		jpf.setText("");
	}
	
	//����Ա��¼
	public void adminlogin(){
		if(MysqlConn.pawd.equals(String.valueOf(jpf.getPassword())))
		{
			JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			this.clear();
			//�رյ�ǰ����
			dispose();
			//����һ���½���
			Admin ad=new Admin();
		}else if(jtf.getText().isEmpty()&&String.valueOf(jpf.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(jtf.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(String.valueOf(jpf.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else
		{
			JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
		    //��������
			this.clear();
		}
	}
	
	//��ʦ��¼
	public void tealogin(){
		if(MysqlConn.pawd.equals(String.valueOf(jpf.getPassword())))
		{
			JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			this.clear();
			//�رյ�ǰ����
			dispose();
			//����һ���½���
			Teacher tea = new Teacher();
		}else if(jtf.getText().isEmpty()&&String.valueOf(jpf.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(jtf.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(String.valueOf(jpf.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else
		{
			JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
		    //��������
			this.clear();
		}
	}
	
	//ѧ����¼
	public void stulogin(){
		if(MysqlConn.pawd.equals(String.valueOf(jpf.getPassword())))
		{
			JOptionPane.showMessageDialog(null,"��¼�ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
			this.clear();
			//�رյ�ǰ����
			dispose();
			//����һ���½���
			Student stu = new Student();
		}else if(jtf.getText().isEmpty()&&String.valueOf(jpf.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog(null,"�������û��������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(jtf.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null,"�������û�����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else if(String.valueOf(jpf.getPassword()).isEmpty())
		{
			JOptionPane.showMessageDialog(null,"���������룡","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
		}else
		{
			JOptionPane.showMessageDialog(null,"�û��������������\n����������","��ʾ��Ϣ",JOptionPane.ERROR_MESSAGE);
		    //��������
			this.clear();
		}
	}
}