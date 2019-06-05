

/**
 * Created by ThinkKING on 5/27/2019.
 */
public class Main_7 {
    public static void main(String[] args) {
//Create
//        PhoneBookDAO.getInstance().create(new PhoneBook(2, 2, 2, 2));

// Update
//        PhoneBookDAO.getInstance().update(1, new PhoneBook(10, 10, 10));

// Delete
//        PhoneBookDAO.getInstance().delete(1);

// GET
        PhoneBookDAO.getInstance().getList()
                .forEach(e -> System.out.println(
                        "Id: " + e.getId() +
                                ", user_id: " + e.getUser_id() +
                                ", telephone: " + e.getTelephone() +
                                ", status: " + e.getStatus()));
    }
}
