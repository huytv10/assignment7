

import java.sql.Connection;
import java.sql.DriverManager;

public class PhoneBookSingleton {
    private static PhoneBookSingleton instance;

    private PhoneBookSingleton() {
    }

    public static PhoneBookSingleton getInstance() {
        if (instance == null) {
            instance = new PhoneBookSingleton();
        }
        return instance;
    }


    public Connection connect() throws Exception {
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:sqlite:C:/sqlite3/huy.db");
        return conn;
    }

    ;

}
