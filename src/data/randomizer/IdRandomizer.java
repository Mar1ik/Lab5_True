package data.randomizer;

import java.util.ArrayList;
import java.lang.Math;

import exceptions.*;

/**
 *
 */
public class IdRandomizer {
    private static final Integer min = 10;
    private static final Integer max = 100;
    private static ArrayList<Long> IDlist = new ArrayList<>();

    public IdRandomizer() {
        IDlist = new ArrayList<>();
    }

    public static Long generatedID() {
        Long id = (long) Math.floor(Math.random() * (max - min + 1)) + min;
        while (IDlist.contains(id)) {
            id = (long) Math.floor(Math.random() * (max - min + 1)) + min;
        }
        IDlist.add(id);
        return id;
    }

    public static boolean IDisUnic(long id) throws IdCopyEX {
        if (IDlist.contains(id)) {
            return false;
        }
        IDlist.add(id);
        return true;
    }

    public static void add(long id) {
        IDlist.add(id);
    }
}
