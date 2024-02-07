package Util;

import Schema.Object;
import java.util.List;
import java.util.Optional;

public class ObjectChecker {

    private String toCamelCase(String str) {
        str = str.toLowerCase();
        return str.substring(0,1).toUpperCase().concat(str.substring(1));
    }
    public boolean objectExists(String objectName) {
        try {
            Class.forName("Objects" + "." + toCamelCase(objectName));
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Optional<Object> findObjInList(List<Object> objectList, String objectName) {
        try {
            return objectList
                    .stream()
                    .filter(a -> a.toString().equalsIgnoreCase(objectName))
                    .findFirst();
        } catch (Exception e) {
            System.out.println("how should i " + this.getClass().getSimpleName() + " the " + objectName + "?!?! :/");
            return Optional.empty();
        }
    }
}
