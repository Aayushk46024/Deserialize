import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File input = new File(System.getProperty("user.dir") +"/data.json");
        JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
        JsonObject fileObject = fileElement.getAsJsonObject();

        // Extracting the basic fields
        String address = fileObject.get("address").getAsString();
        Double houseCost = fileObject.get("cost").getAsDouble();

        System.out.println("Address is:- " + address);
        System.out.println("House cost is:- " + houseCost);

        JsonArray jsonArrayOfPets = fileObject.get("pets").getAsJsonArray();
        List<Pet> pets = new ArrayList<>();
        for (JsonElement petElement : jsonArrayOfPets.getAsJsonArray()) {
            //Get the JsonObject:
            JsonObject petJsonObject = petElement.getAsJsonObject();

            //Extract date
            String name = petJsonObject.get("name").getAsString();
            String colour = petJsonObject.get("color").getAsString();

            Pet pet = new Pet(name, colour);
            pets.add(pet);
        }
        System.out.println("All my pets are:- " + pets);
    }
}
