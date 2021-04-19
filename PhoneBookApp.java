package Level2_L3;

public class PhoneBookApp {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();


        phoneBook.add("Ivanov", "(495) 123 45 67");
        phoneBook.add("Petrov", "(495) 321 54 76");
        phoneBook.add("Sidorov","(495) 274 10 01");
        phoneBook.add("Ivanov", "(812) 121 00 10");


        phoneBook.get("Ivanov");

        phoneBook.get("Petrov");

        phoneBook.get("Kuznetsov");


    }
}
