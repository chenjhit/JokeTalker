/**
 * Created by Administrator on 2016/11/26.
 */
import com.chenj.GetRandomJoke;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

// ��չ HttpServlet ��
public class HelloWorld extends HttpServlet {

    private String message;
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/joke_talker";

    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";

    public void init() throws ServletException
    {
        // ִ�б���ĳ�ʼ��
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // ������Ӧ��������
        response.setContentType("text/html");

        Double randomDouble = GetRandomJoke.getAnDecimal();
        String jokes = GetRandomJoke.getSomeJokes();
        // ʵ�ʵ��߼���������
        String html = "<h1>我是陈静</h1>" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\"> \n" +
                "<title>我的主页</title> \n" +
                "<link rel=\"icon\" href=\"home.png\" type=\"image/x-icon\"/>\n" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\">\n" +
                "\n" +
                "<script src=\"test.js\"></script>\n" +
                "</head>" +
                "<form name=\"inputSearchContent\" action=\"HelloForm\" method=\"GET\" target=\"_blank\">\n" +
                "<input id=\"baiduSeachContent\" type=\"text\" name=\"content\">\n" +
                "<input type=\"submit\" value=\"搜索\">\n" +
                "</form>";
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
        out.println(html);
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        GetRandomJoke p = new GetRandomJoke();//ctx.getBean("get", GetRandomJoke.class);
        String qqq = p.findMe();
        out.println("<p>" + qqq + "</p>");
        out.println("<pre style=\"font-size:40px\">" + jokes + "</pre>");
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动器
            Class.forName("com.mysql.jdbc.Driver");

            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行 SQL 查询
            stmt = conn.createStatement();
            String sql;
            Date date = new Date();
            sql = "INSERT INTO `jokes`(content) VALUES ('" + jokes + "');";
            //sql = "INSERT INTO `jokes`(content) VALUES ('" + "敢不敢成功？" + "');";
            stmt.execute(sql);
            //ClassPathXmlApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME;

            // 完成后关闭
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch(Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 最后是用于关闭资源的块
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }

    public void destroy()
    {
        // ʲôҲ����
    }

}
