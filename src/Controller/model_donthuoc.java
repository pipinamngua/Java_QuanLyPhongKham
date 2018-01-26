package Controller;


import Model.donthuoc;
import java.sql.Connection;
import java.sql.Date;
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
public class model_donthuoc {
    String filename;
    private String className="com.mysql.jdbc.Driver";
	private String table="donthuoc";
	private final String url="jdbc:mysql://localhost:3306/QuanLyPhongKham";
	private Connection connection;
        model_chitietthuoc ct= new model_chitietthuoc();
   public model_donthuoc()
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
               System.out.printf("%s %s %s %s %s %d \n",
                       rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
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
       
       
   
   
   public void deleteID(String id) throws SQLException
   {
       ResultSet rs= null;
       rs=ct.getDataID(id, "maDonThuoc");
       while(rs.next())
       {
           ct.deleteID(rs.getInt("maDonThuocChiTiet"));
       }
                String slqcomand = "delete from  " +table + "  where `maDonThuoc` = ?";
                PreparedStatement pst =null;
            try {
                pst=connection.prepareStatement(slqcomand);
                pst.setString(1,id);
                
                if( pst.executeUpdate()>0) 
                {
                    System.out.print("delete successful \n");
                }
                else System.out.print("delete error \n");
            } catch (SQLException e) {
                System.out.println("delete error \n" + e.toString());
            }
            
   }
   
         public void insertID(donthuoc s) throws ParseException
   {
                String slqcomand = "insert into  " + table + " value( ?, ? , ? ,?,?,?)";
                PreparedStatement pst =null;
            try {
                pst=connection.prepareStatement(slqcomand);
                pst.setString(1, null);
                pst.setString(2,s.getMabenhnhan());
                pst.setString(3,s.getMaduocsi());
                pst.setString(4,s.getMabacsi());
                pst.setString(5, s.getNgay());
                pst.setInt(6, s.getTien());
                if( pst.executeUpdate()>0) 
                {
                    System.out.print("insert successful \n");
                }
                else System.out.print("insert error \n");
            } catch (SQLException e) {
                System.out.println("insert error \n" + e.toString());
            }          
   }
   public  void updateID(String madonthuoc , donthuoc s) throws ParseException 
   {
           
                String sqlcomand = "update " + table
                        + " set `maBenhNhan`=? ,`maDuocSi`=? ,`maBacSi`=? ,`ngayLayThuoc`=?,`tongTien`=?"
                        + " where `maDonThuoc`=?";
                PreparedStatement ptm=null;
              try {
                ptm=connection.prepareStatement(sqlcomand);
                
                ptm.setString(1, s.getMabenhnhan());
                ptm.setString(2, s.getMaduocsi());
                ptm.setString(3, s.getMabacsi());
                ptm.setString(4,  s.getNgay());
                ptm.setInt(5, s.getTien());
                ptm.setString(6, madonthuoc);
                if (ptm.executeUpdate()>0) System.out.println("update succesful");
                else  System.out.println("update error");
            } catch (SQLException ex) {
                System.out.println("update error \n"+ ex.toString());
            }
   }
   public  void updateID1(String madonthuoc , int tong) throws ParseException 
   {
           
                String sqlcomand = "update " + table
                        + " set `tongTien`=?"
                        + " where `maDonThuoc`=?";
                PreparedStatement ptm=null;
              try {
                ptm=connection.prepareStatement(sqlcomand);
                
                ptm.setInt(1, tong);
                ptm.setString(2, madonthuoc);
                if (ptm.executeUpdate()>0) System.out.println("update succesful");
                else  System.out.println("update error");
            } catch (SQLException ex) {
                System.out.println("update error \n"+ ex.toString());
            }
   }
        public static void main(String[] args) throws ParseException {
        model_donthuoc donthuoc=new model_donthuoc();
        donthuoc.insertID(new donthuoc("aaa", "21", "24", "2000-2-2", 20));
        donthuoc.showData(donthuoc.GetData());
    }
}




