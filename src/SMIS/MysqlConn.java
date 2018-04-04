package ѧ����Ϣ����ϵͳ;

import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.Spring;

//���ݿ����ӳ���
public class MysqlConn {
	//JDBC�����������ݿ�URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost:3306/SCIS";
	
	//���ݿ��¼��������
	static final String USER = "root";
	static final String PASS = "tiger";
	
	//�趨�û���������
	static String userword;
	static String pawd;
	
	static String teaid = null;
	static String teaname = null;
	static Date teabirth = null;
	static String protitle = null;
	static String cname = null;
	static String cno = null;
	
	static String stuid = null;
	static String stuname = null;
	static String stusex = null;
	static Date stubirth = null;
	static String stutel = null;
	static String stuacademy = null;//ѧԺ
	static String stuclass = null;
	static String stuadd = null;
	
	static int stugrade = 0;
	static double stupoint = 0;
	static double stucredit = 0;
	
	static int counter = 0;
	
	static String [] stu_id = new String[10];
	static String [] stu_name = new String[10];
	static String [] stu_sex = new String[10];
	static Date [] stu_birth = new Date[10];
	static String [] stu_tel = new String[10];
	static String [] stu_academy = new String[10];
	static String [] stu_class = new String[10];
	static String [] stu_add = new String[10];
	
	static int [] stu_grade = new int[10];
	static double [] stu_point = new double[10];
	
	static String [] c_no = new String[10];
	static String [] ct_name = new String[10];
	static String [] c_name = new String[10];
	static double [] credit = new double[10];
	
	static String [] tea_id = new String[10];
	static String [] tea_name = new String[10];
	static Date [] tea_birth = new Date[10];
	static String [] tea_protitle = new String[10];
	
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	//�������ݿ�
	public static void ConnectSQL() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("The SQL is connected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// �ж��û��Ƿ����
	public static boolean queryadm(String id) {
		// ���������
		try {
			ps = conn.prepareStatement("select * from ����Ա where ID = ?");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, id);
			// ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			// ѭ��ȡ��
			if (rs.next()) {
				pawd = rs.getString("password");
				return true;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	public static boolean querytea(String id) {
		// ���������
		try {
			ps = conn.prepareStatement("select * from ��ʦ where ID = ?");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, id);
			// ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			// ѭ��ȡ��
			if (rs.next()) {
				pawd = rs.getString("ID");
				return true;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	public static boolean querystu(String id) {
		// ���������
		try {
			ps = conn.prepareStatement("select * from ѧ�� where ID = ?");
			// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
			ps.setString(1, id);
			// ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			// ѭ��ȡ��
			if (rs.next()) {
				pawd = rs.getString("ID");
				return true;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	
	//��ȡѧ����Ϣ
	public static void getdatastu() {
		
		// ���������
		try {
			ps = conn.prepareStatement("select * from ѧ��");
			// ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next())	
			{
				stu_id[counter] = rs.getString("ID");
				stu_name[counter] = rs.getString("Sname");
				stu_sex[counter] = rs.getString("Ssex");
				stu_birth[counter] = rs.getDate("Sbirth");
				stu_tel[counter] = rs.getString("Stel");
				stu_academy[counter] = rs.getString("Sacademy");//ѧԺ
				stu_class[counter] = rs.getString("Sclass");
				stu_add[counter] = rs.getString("Saddress");
				counter++;
			}
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void getdatastu(String s) {
		
		// ���������
		try {
			ps = conn.prepareStatement("select * from �ɼ�,�γ� where Sno = ? and �ɼ�.Cno = �γ�.Cno");
			ps.setString(1, s);
			// ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next())	
			{
				c_name[counter] = rs.getString("Cname");
				stu_grade[counter] = rs.getInt("Grade");
				credit[counter] = rs.getDouble("Ccredit");
				stu_point[counter] = rs.getDouble("Point");
				counter++;
			}
	
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void getdatagra() {
		try {
			ps = conn.prepareStatement("select * from �ɼ�,�γ�,ѧ��,��ʦ where �ɼ�.Sno = ѧ��.ID and �ɼ�.Cno = �γ�.Cno and ��ʦ.Cno = �γ�.Cno");
			rs = ps.executeQuery();
			
			counter = 0;
			while(rs.next())	
			{
				stu_name[counter] = rs.getString("Sname");
				c_name[counter] = rs.getString("Cname");
				ct_name[counter] = rs.getString("Tname");
				stu_grade[counter] = rs.getInt("Grade");
				stu_point[counter] = rs.getDouble("Point");
				credit[counter] = rs.getDouble("Ccredit");
				counter++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void getdatatea(){
		try {
			ps = conn.prepareStatement("select * from ��ʦ,�γ� where �γ�.Cno = ��ʦ.Cno");
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next()){
				tea_id[counter] = rs.getString("ID");
				tea_name[counter] = rs.getString("Tname");
				tea_birth[counter] = rs.getDate("Tbirth");
				tea_protitle[counter] = rs.getString("Tprotitle");
				c_name[counter] = rs.getString("Cname");
				counter++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//��ȡ��ʦ��Ϣ
		public static void getdatatea(String id) {
			
			// ���������
			try {
				ps = conn.prepareStatement("select * from ��ʦ,�γ� where ID = ? and �γ�.Cno = ��ʦ.Cno ");
				// ��?��ֵ(�ɷ�ֹSQLע��©������)����Ҫֱ��ʹ��ƴ�ӵķ�ʽ
				ps.setString(1, id);
				// ResultSet�����,��ҿ��԰�ResultSet���ɷ���һ�ű��еĽ����
				rs = ps.executeQuery();
				if(rs.next())	
				{
					teaid = rs.getString("ID");
					teaname = rs.getString("Tname");
					teabirth = rs.getDate("Tbirth");
					protitle = rs.getString("Tprotitle");//ְ��
					cno = rs.getString("Cno");
					cname = rs.getString("Cname");
				}
		
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	//����ѧ����Ϣ
	public static void insertstu() {
		try{
			ps = conn.prepareStatement("insert into ѧ�� values ('"+stuid+"','"+stuname+"','"+stusex+"','"+stubirth+"','"+stutel+"','"+stuacademy+"','"+stuclass+"','"+stuadd+"')");
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "ѧ����¼��ӳɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
				
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "��������쳣!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
		
	}

	public static void updatestu(String stuid2,String stuname2,String stusex2, Date stubirth2, String stutel2, String stuacademy2, String stuclass2, String stuadd2) {
		// TODO Auto-generated method stub
		try{
			ps = conn.prepareStatement("update ѧ�� set Sname = ?, Ssex = ?, Sbirth = ?, Stel = ?, Sacademy = ?, Sclass = ?, Saddress = ? where ID = ? ");
			ps.setString(1, stuname2);
			ps.setString(2, stusex2);		//���ܳ�����ĵط�
			ps.setDate(3, stubirth2);
			ps.setString(4, stutel2);
			ps.setString(5, stuacademy2);
			ps.setString(6, stuclass2);
			ps.setString(7, stuadd2);
			ps.setString(8, stuid2);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "ѧ����¼�޸ĳɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "�����޸�ʧ��!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}

	public static void deletestu(String stuid2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("delete from ѧ�� where ID = ? ");
			ps.setString(1, stuid2);
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "ѧ����¼ɾ���ɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e1){
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "����ɾ��ʧ��!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}

	public static void inserttea() {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("insert into ��ʦ values ('"+teaid+"','"+teaname+"','"+teabirth+"','"+protitle+"','"+cno+"')");
			System.out.println("cno:"+cno);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "��ʦ��¼��ӳɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e){
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "��������쳣!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static void updatetea(String teaid2, String teaname2, Date teabirth2, String protitle2, String cno2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("update ��ʦ set Tname = ?,Tbirth = ?,Tprotitle = ?,Cno = ? where ID = ? ");
			ps.setString(1, teaname2);
			ps.setDate(2, teabirth2);
			ps.setString(3, protitle2);
			ps.setString(4, cno2);
			ps.setString(5, teaid2);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "��ʦ��¼�޸ĳɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "�����޸�ʧ��!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static void deletetea(String teaid2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("delete from ��ʦ where ID = ? ");
			ps.setString(1, teaid2);
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "��ʦ��¼ɾ���ɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
			
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			
			JOptionPane.showMessageDialog(null, "����ɾ��ʧ��!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}
	}
	
	public static void querygra(String cname2){
		try {
			ps = conn.prepareStatement("select * from ѧ��,�γ�,�ɼ� where Cname = ? and �γ�.Cno = �ɼ�.Cno and ѧ��.ID = �ɼ�.Sno");
			ps.setString(1, cname2);
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next()){
				stu_id[counter] = rs.getString("Sno");
				stu_name[counter] = rs.getString("Sname");
				stu_grade[counter] = rs.getInt("Grade");
				stu_point[counter] = rs.getDouble("Point");
				counter++;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertgra(String stuid2, String cno2, int stugrade2, double stupoint2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("insert into �ɼ� values ('"+stuid2+"','"+cno2+"','"+stugrade2+"','"+stupoint2+"')");
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "�ɼ�¼��ɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e) {
			
			JOptionPane.showMessageDialog(null, "��������쳣!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	//��ѯ�ɼ�����ĳ�γ̳ɼ��Ƿ��Ѿ�����
	public static boolean querycou(String stuid2,String cname2){
		try {
			ps = conn.prepareStatement("select Grade from �γ�,�ɼ� where Sno = ? and Cname = ? and �γ�.Cno = �ɼ�.Cno");
			ps.setString(1, stuid2);
			ps.setString(2, cname2);
			rs = ps.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public static void updategra(String stuid2, String cno2, int stugrade2, double stupoint2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("update �ɼ� set Grade = ?, Point = ? where Sno = ? and Cno = ? ");
			ps.setInt(1, stugrade2);
			ps.setDouble(2, stupoint2);
			ps.setString(3, stuid2);
			ps.setString(4, cno2);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "�ɼ��޸ĳɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "�����޸�ʧ��!", "��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public static void query_gra(String stuid2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("select * from �γ�,�ɼ�,��ʦ where Sno = ? and �γ�.Cno = �ɼ�.Cno and �γ�.Cno = ��ʦ.Cno");
			ps.setString(1, stuid2);
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next()){
				c_name[counter] = rs.getString("Cname");
				ct_name[counter] = rs.getString("Tname");
				stu_grade[counter] = rs.getInt("Grade");
				credit[counter] = rs.getDouble("Ccredit");
				stu_point[counter] = rs.getDouble("Point");
				counter++;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void getdatacou() {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("select * from �γ� ");
			rs = ps.executeQuery();
			counter = 0;
			while(rs.next()){
				c_no[counter] = rs.getString("Cno");
				c_name[counter] = rs.getString("Cname");
				credit[counter] = rs.getDouble("Ccredit");
				counter++;
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public static boolean querycou(String text) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("select Cno from �γ� where Cno = ?");
			ps.setString(1, text);
			rs = ps.executeQuery();
			
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	public static void insertcou(String cno2, String cname2, double stucredit2) {
		// TODO Auto-generated method stub
		try{
			ps = conn.prepareStatement("insert into �γ� values ('"+ cno2 +"','"+ cname2 +"','"+stucredit2+"')");
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "�γ���Ϣ��ӳɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�γ���Ϣ���ʧ��!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void updatecou(String cno2, String cname2, double stucredit2) {
		// TODO Auto-generated method stub
		try{
			ps = conn.prepareStatement("update �γ� set Cname = ?, Ccredit = ? where Cno = ?");
			ps.setString(1, cname2);
			ps.setDouble(2, stucredit2);
			ps.setString(3, cno2);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "�γ���Ϣ�޸ĳɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�γ���Ϣ�޸�ʧ��!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void deletecou(String cno2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("delete from �γ� where Cno = ?");
			ps.setString(1, cno2);
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "�γ�ɾ���ɹ�!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�γ�ɾ��ʧ��!", "��ʾ��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void getdatacou(String cname2) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("select Cno from �γ� where Cname = ?");
			//System.out.println("cname"+cname2);
			ps.setString(1, cname2);
			rs = ps.executeQuery();
			
			if(rs.next()){
				//System.out.println("found");
				cno = rs.getString("Cno");
			}
			
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
