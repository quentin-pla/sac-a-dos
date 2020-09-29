import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Sac à dos
 */
public class SacADos {
    /**
     * Objets contenus
     */
    public static ArrayList<int[]> objects = new ArrayList<>();

    /**
     * Poids maximum
     */
    public static int max_weight;

    /**
     * Initialiser le sac à partir d'un fichier texte
     * @param value numéro du sac
     */
    public static void initBag(int value) {
        InputStream file = SacADos.class.getClassLoader().getResourceAsStream("sac" + value + ".txt");
        if (file != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8));
            String line;
            int line_count = 0;
            try {
                while ((line = reader.readLine()) != null) {
                    ++line_count;
                    if (line_count == 1) max_weight = Integer.parseInt(line);
                    else {
                        String[] object_values = line.split(" ");
                        int object_weight = Integer.parseInt(object_values[0]);
                        int object_value = Integer.parseInt(object_values[1]);
                        objects.add(new int[]{object_weight,object_value});
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new Exception("Sac à dos introuvable.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
