package Controller;


import Model.donThuocChiTiet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luong Thanh Long
 */
public class model_chitietthuoc {
    String filename;
    private String className="com.mysql.jdbc.Driver";
	private String table="donthuocchitiet";
	private final String url="jdbc:mysql://localhost:3306/QuanLyPhongKham";
	private Connection connection;
        model_thuoc t=new model_thuoc();
        public model_chitietthuoc()
        {
            try {
			Class.forName(className);
			connection = DriverManager.getConnection(url,"root","");
			System.out.print("connect sucessfull \n");
		} catch (ClassNotFoundException e) {
			System.out.print("Class not found \n");
		} catch (SQLException e) {
			System.out.print("Error connection \n");
		}
        }
        public ResultSet gettime() throws SQLException
    {
        
       ResultSet rs=null;
       PreparedStatement  pst=null;
       String sqlcomand = "SELECT year(date(now()))as year , day(date(now())) as day ,month(date(now())) as month";
       pst=connection.prepareStatement(sqlcomand);
       rs=pst.executeQuery();
       return rs;
    }
    
    public void  showData(ResultSet rs)
       {
       try {
           while (rs.next())
           {
               System.out.printf("%d %s %s %d  \n",
                       rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
           }
       } catch (SQLException ex) {
           
       }
       }         
       
        
    
//    public void readExelFile() throws BiffException, IOException {
//		File f = new File("C:\\Users\\luong thanh long\\Desktop\\Book1");
//		JFileChooser chooser = new JFileChooser();
//		chooser.showOpenDialog(null);
//		f = chooser.getSelectedFile();
//		 filename = f.getAbsolutePath();
//		Workbook wb = Workbook.getWorkbook(f);
//		Sheet s = wb.getSheet(0);
//		int row = s.getRows();
//		int col = s.getColumns();
//		for(int i = 0; i < row;i++) {
//			for(int j = 0; j < col;j++) {
//				jxl.Cell c = s.getCell(j,i);
//				System.out.print(c.getContents());
//			}
//			System.out.println("");
//	}
//	}
//    
    public ResultSet GetData()
    {
           ResultSet rs=null;
           String sqlcomand = "select * from  " + table;
           Statement st;
          try {
           st=connection.createStatement();
           rs=st.executeQuery(sqlcomand);
         } catch (SQLException e) {
           System.out.println("select error \n"+e.toString());
         }     
       return rs;
    }
    
   public ResultSet getDataID(String id , String column)
   {
           ResultSet rs=null;
           String sqlcomand = "select * from "+ table + "  where " + "`"+column+"`" + " like ?" ;
           PreparedStatement pst=null;
       try {
           pst = connection.prepareStatement(sqlcomand);
           pst.setString(1,id);
           rs=pst.executeQuery();
       } catch (SQLException e) {
           System.out.println("select error \n"+e.toString());
       }     
       return rs;
   }
   
//   public ResultSet Thongke(String text) 
//   {
//       ResultSet rs=null;
//       String sqlcomand= "select `"+text+"` , count( Distinct`Mã sách`) As Number from `Sách` group by `"+text+"` ";
//       Statement st=null;
//       System.out.printf("%s",sqlcomand);
//            try {
//                 st=connection.createStatement();
//                 rs=st.executeQuery(sqlcomand);
//            } catch (SQLException ex) {
//                System.out.println("thong ke error"+ex.toString());
//            }
//            return rs;
//   }
       
       
   
   
   public void deleteID(int id) throws SQLException
   {
//       ResultSet rs= null;
//            rs=getDataID(String.valueOf(id), "maDonThuocChiTiet");
//            while(rs.next())
//            {
//                t.updateID2(table, id);
//            }
                String slqcomand = "delete from  " +table + " where `maDonThuocChiTiet`=?";
                PreparedStatement pst =null;
            try {
                pst=connection.prepareStatement(slqcomand);
                pst.setInt(1,id);
                
                if( pst.executeUpdate()>0) 
                {
                    System.out.print("delete successful \n");
                }
                else System.out.print("delete error \n");
            } catch (SQLException e) {
                System.out.println("delete error \n" + e.toString());
            }
            
   }
   
         public void insertID(donThuocChiTiet s) throws ParseException
   {
                String slqcomand = "insert into  " + table + " value( ?,? , ? ,?)";
                PreparedStatement pst =null;
            try {
                pst=connection.prepareStatement(slqcomand);
                pst.setString(1,null);
                pst.setString(2,s.getMadonthuoc());
                pst.setString(3,s.getMathuoc());
                
                pst.setInt(4, s.getSoluong());
                if( pst.executeUpdate()>0) 
                {
                    System.out.print("insert successful \n");
                }
                else System.out.print("insert error \n");
            } catch (SQLException e) {
                System.out.println("insert error \n" + e.toString());
            }          
   }
   public  void updateID(String madonthuoc ,String mathuoc, int soluong,String mathuocchitiet) throws ParseException 
   {
           
                String sqlcomand = "update " + table
                        + " set `maThuoc`=? ,`soLuong`=? "
                        + " where `maDonThuoc`=? and `maDonThuocChiTiet`=?";
                PreparedStatement ptm=null;
              try {
                ptm=connection.prepareStatement(sqlcomand);
                
                ptm.setString(1, mathuoc);
                ptm.setInt(2, soluong);
                ptm.setString(3, madonthuoc);
                ptm.setString(4,  mathuocchitiet);
                
                if (ptm.executeUpdate()>0) System.out.println("update succesful");
                else  System.out.println("update error");
            } catch (SQLException ex) {
                System.out.println("update error \n"+ ex.toString());
            }
   }
        public static void main(String[] args) throws ParseException {
        model_chitietthuoc chitiet = new model_chitietthuoc();
        //chitiet.insertID(new donThuocChiTiet("3", "PANA", 3));
        //chitiet.deleteID(4);
        chitiet.showData(chitiet.getDataID("9", "maDonThuoc"));
    }
}
