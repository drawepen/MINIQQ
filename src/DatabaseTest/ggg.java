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
     * TODO ����һ����¼
     * @param sn     ѧ������
     * @param ss     ѧ���Ա�
     * @param sa     ѧ������
     * @param so     ѧ��רҵ
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
     * TODO ��ѯ��¼
     * @param sn ��¼��ѧ������
     * @return String ��ѯ�Ľ��
     */
    public String search(String sn){
        String str = "so ��sa ��"+sn+" ss ��";
        String sql1 = "select * from student where sn= '"+sn+"'; ";
        try {
            ResultSet rs = stmt .executeQuery(sql1);           
            if(rs.next()){   
                str = str+rs.getString("sn ")+" �ֻ��� ��"
                        +rs.getString("sa ");
            }else str = "�ü�¼������ ������";
        }catch (Exception e){
           e.printStackTrace();
        }
        return str;
    }
    /** *//**
     * TODO �޸ļ�¼
     * @param sn    ѧ������
     * @param ss    ��ѧ���Ա�
     * @parame sa   ѧ��������
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
     * TODO ɾ����¼
     * @param sn ѧ������
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
           /**�ر�����*/
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