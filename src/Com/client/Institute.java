package Com.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Institute {

	public static void main(String[] args) throws Exception {
		
         Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/client","root","root");
		
		while(true) {
			Scanner s = new Scanner(System.in);
			System.out.println("*********menu**********");
			System.out.println("choice option from below list_______");
			System.out.println("1.insert data\n2.update data\n3.delete data\n4.retrive data\n5.exit");
			System.out.println("what is your choice");
			int ch=s.nextInt();
			 
			switch (ch) {
				case 1:
					String insertdata = "insert into course values(?,?,?)";
					PreparedStatement psi = con.prepareStatement(insertdata);
			        System.out.println("Enter course id here");
			        psi.setInt(1, s.nextInt());
			        System.out.println("enter course name here");
			        psi.setString(2, s.next());
			        System.out.println("enter course fees here");
			        psi.setInt(3, s.nextInt());
			        psi.execute();
			        System.out.println("data inserted successfully");
		        break;
            
				case 2:
				    String updatedata="update course set Fees=? where id=?";
				    PreparedStatement psu = con.prepareStatement(updatedata);
				    System.out.println("enter fees here");
				    psu.setInt(1, s.nextInt());
				    System.out.println("enter id here");
				    psu.setInt(2, s.nextInt());
				    psu.execute();
				    System.out.println("data updated");
			    break;
		    
				case 3:
					String deletedata="delete from course where id=?";
					PreparedStatement psd = con.prepareStatement(deletedata);
					System.out.println("enter id here");
					psd.setInt(1, s.nextInt());
					psd.execute();
					System.out.println("deleted data");
				break;
		    
				case 4:    
					String RetriveAll = "select * from course";
					PreparedStatement psr = con.prepareStatement(RetriveAll);
					ResultSet rs = psr.executeQuery();
					while(rs.next()){
						System.out.println("Course id here:  "+rs.getInt(1));
						System.out.println("Course name here: "+rs.getString(2));
						System.out.println("Course Fees here: "+rs.getInt(3));
						System.out.println("_____________________________");		
					}
				break;
				case 5:
					System.exit(0);
					default:
					System.out.println("sorry !Wrong choice");
			    break;
			}		
		}
	}
}


