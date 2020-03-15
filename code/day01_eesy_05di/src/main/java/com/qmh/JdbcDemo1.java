package com.qmh;

import java.sql.*;
/**
 * 低耦合：降低方法间的依赖
 * 实际开发中做到 编译期不依赖，运行时才依赖
 * 解题思路：
 *      1.使用反射创建对象，避免使用new关键字
 *      2.通过读取配置文件来获取要创建的对象全限定类名
 * */
//程序的耦合
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?serverTimezone=GMT%2B8","root","070622");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("money"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
