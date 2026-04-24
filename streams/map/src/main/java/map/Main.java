package map;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        // Testing getting
       Map testMap = new HashMap<Integer, String>();
       testMap.put("m", "marina");
       testMap.put("m", "martina");

       System.out.println(testMap.get("m"));

    }
}
