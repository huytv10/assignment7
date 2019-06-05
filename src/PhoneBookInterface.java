

import java.util.ArrayList;

public interface PhoneBookInterface {
    boolean create(PhoneBook u);

    ArrayList<PhoneBook> getList();

    boolean update(int id,PhoneBook u);

    boolean delete(int id);

}
