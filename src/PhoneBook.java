

public class PhoneBook {
    private int id;
    private int user_id;
    private int telephone;
    private int status;

    public PhoneBook() {
    }

    public PhoneBook(int user_id, int telephone, int status) {
        this.user_id = user_id;
        this.telephone = telephone;
        this.status = status;
    }

    public PhoneBook(int id, int user_id, int telephone, int status) {
        this.id = id;
        this.user_id = user_id;
        this.telephone = telephone;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
