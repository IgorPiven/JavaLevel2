package Level2_L3;


import java.util.HashMap;;
import java.util.Iterator;
import java.util.Map;

public class PhoneBook {

    HashMap<String, String> phoneItem = new HashMap<>();


    void add(String name, String phone) {

        phoneItem.put(phone, name);
    }

    void get(String name) {

        Iterator<Map.Entry<String, String>> iter = phoneItem.entrySet().iterator();
        boolean itemIn = false;

        System.out.println("Для фамилии " + name + " в справочнике есть следующие номера телефонов:");

        while (iter.hasNext()) {

            Map.Entry item = (Map.Entry) iter.next();

            if (name.equals(item.getValue())) {
                System.out.println(item.getKey());
                itemIn = true;
            }
        }

        if (!itemIn) System.out.println("Данные отсутствуют");
    }
}