package test;
import core.*;
public class TestMain {
    public static void main(String[] args) {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        databaseHandler.signUpUser("Abdul","myPassword");
    }
}
