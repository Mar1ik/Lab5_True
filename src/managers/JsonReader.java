package managers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import data.Worker;

import java.util.TreeMap;

public class JsonReader {

    public static void main(String[] args) {
        Worker worker = null;
        String json = worker.toString() ;

        TreeMap<Integer, Person> treeMap = new TreeMap<>();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);

        for (String key : jsonObject.keySet()) {
            JsonElement element = jsonObject.get(key);
            if (element.isJsonObject()) {
                JsonObject obj = element.getAsJsonObject();
                String name = obj.get("name").getAsString();
                Validator.NameIsValid(name);
                int age = obj.get("age").getAsInt();

                treeMap.put(Integer.parseInt(key), new Person(name, age));
            }
        }

        for (Integer key : treeMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        }
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}