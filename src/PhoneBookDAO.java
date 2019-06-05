

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PhoneBookDAO implements PhoneBookInterface {
    private static PhoneBookDAO instance;

    private PhoneBookDAO() {
    }

    public static PhoneBookDAO getInstance() {
        if (instance == null) {
            instance = new PhoneBookDAO();
        }
        return instance;
    }

    @Override
    public boolean create(PhoneBook u) {
        Connection cnn = null;
        try {
            cnn = PhoneBookSingleton.getInstance().connect();

            int id = u.getId();
            int user_id = u.getUser_id();
            int phone = u.getTelephone();
            int status = u.getStatus();

            String sqlInsert = "INSERT INTO phonebook VALUES(?, ?, ?, ?)";
            cnn.prepareStatement("INSERT INTO phonebook VALUES(?, ?, ?, ?)");
            PreparedStatement stmt = cnn.prepareStatement(sqlInsert);
            stmt.setInt(1, id);
            stmt.setInt(2, user_id);
            stmt.setInt(3, phone);
            stmt.setInt(4, status);
            stmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            finallys(cnn);
        }

        return false;
    }

    @Override
    public ArrayList<PhoneBook> getList() {
        ArrayList<PhoneBook> result = new ArrayList<>();
        Connection cnn = null;

        try {
            String sql = "Select * from phonebook";
            cnn = PhoneBookSingleton.getInstance().connect();
            Statement statement = cnn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                PhoneBook p = new PhoneBook(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                result.add(p);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            finallys(cnn);
        }
        return result;
    }

    @Override
    public boolean update(int id, PhoneBook u) {
        Connection cnn = null;
        try {
            cnn = PhoneBookSingleton.getInstance().connect();
            int id_ = id;
            int user_id = u.getUser_id();
            int phone = u.getTelephone();
            int status = u.getStatus();


            String update = "UPDATE phonebook SET user_id = ?,telephone = ?, status = ? where id = ?";
            PreparedStatement preparedStmt = cnn.prepareStatement(update);
            preparedStmt.setInt(1, user_id);
            preparedStmt.setInt(2, phone);
            preparedStmt.setInt(3, status);
            preparedStmt.setInt(4, id_);
            preparedStmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            finallys(cnn);
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection cnn = null;
        try {
            String sql = "DELETE FROM phonebook where id = ?";
            cnn = PhoneBookSingleton.getInstance().connect();
            cnn.prepareStatement("INSERT INTO phonebook VALUES(?, ?, ?, ?)");
            PreparedStatement stmt = cnn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            finallys(cnn);
        }

        return false;
    }

    private void finallys(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
