package saru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LottoDB {
    //    private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static LottoDB lottoDB;
    private String addr;
    private String user;
    private String pw;

    private LottoDB(String addr, String user, String pw) {
        this.addr = addr;
        this.user = user;
        this.pw = pw;

// Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'.
// The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
//        loadDriver();
    }

    public static LottoDB getInstance() {
        return lottoDB;
    }

    public static void initLottoDB(String addr, String user, String pw) {
        if (lottoDB == null) {
            lottoDB = new LottoDB(addr, user, pw);
            return;
        }

        System.out.println("이미 초기화 되었습니다.");
    }

//    private void loadDriver() {
//        try {
//            Class.forName(COM_MYSQL_JDBC_DRIVER);
//        } catch (ClassNotFoundException e) {
//            System.err.println("No Driver");
//            System.err.println(e.getMessage());
//            return;
//        }
//
//        System.out.println("Success to load JDBC Driver");
//    }

    public Connection createConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(addr, user, pw);
            System.out.println("Success to connect");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
