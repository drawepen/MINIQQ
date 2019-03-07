package DatabaseTest;
import java.sql.*;
/** *//**
 * @author Administrator
 */
public class ggg {
    private Connection con = null ;
    private Statement stmt = null ;
    private String url = "jdbc:mysql://127.0.0.1:3306/miniqq";
    private String user = "root";
    private String pwd = "56789Shi!";
    /** *//** Creates a new instance of Operation */ 
    public ggg() {
        init();
    }
    /** *//** init */
    private void init(){
        try {        
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection(url ,user ,pwd );
          stmt = con .createStatement();
        } catch (Exception e){
          // your installation of JDBC Driver Failed 
          e.printStackTrace();
        }
    }
    /** *//**
     * TODO 增加一条记录
     * @param sn     学生名字
     * @param ss     学生性别
     * @param sa     学生年龄
     * @param so     学生专业
     * @return void
     */
    public void add(String sn,String ss,String sa,String so,String s1,String s2,String s3){     
        String sql2 = "insert into yonghu values("
                +sn+","+ss+","+sa+","+so+","+ss+","+sa+","+so+",null,null,null)";
        try {
            stmt.executeUpdate(sql2);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /** *//**
     * TODO 查询记录
     * @param sn 记录的学生姓名
     * @return String 查询的结果
     */
    public String search(String sn){
        String str = "so ：sa ："+sn+" ss ：";
        String sql1 = "select * from student where sn= '"+sn+"'; ";
        try {
            ResultSet rs = stmt .executeQuery(sql1);           
            if(rs.next()){   
                str = str+rs.getString("sn ")+" 手机号 ："
                        +rs.getString("sa ");
            }else str = "该记录不存在 ！！！";
        }catch (Exception e){
           e.printStackTrace();
        }
        return str;
    }
    /** *//**
     * TODO 修改记录
     * @param sn    学生姓名
     * @param ss    该学生性别
     * @parame sa   学生的年龄
     * @return void
     */
    public void modify(String sn,String ss){
        String sql = "update sturesult set ss ="+ss
                +" where sn ='"+sn+"' ";
        try {
            stmt .executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
     /** *//**
     * TODO 删除记录
     * @param sn 学生姓名
     * @return void
     */
    public void delete(String sn){
        String sql1 = "delete from teststudent "+" where sn= '"+sn+"'; ";
        try {
            stmt.executeUpdate(sql1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
           /**关闭连接*/
    public void close(){
        try {
            if (con != null ) con .close();
            if (stmt != null ) stmt .close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[])throws Exception{
        //add test here!!!! 
    	ggg sql=new ggg();
     sql.add("1", "2", "3", "4", "5", "6", "7"); 
     sql.close();
        
    
    }
} 