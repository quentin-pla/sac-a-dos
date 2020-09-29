import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * Problème sac à dos
 */
public class ProblemeSacADos {
    /**
     * Objets disponibles
     */
    public static ArrayList<Objet> available_objects = new ArrayList<>();

    /**
     * Poids maximum du sac à dos
     */
    public static int max_weight;

    /**
     * Exécution du programme
     * @param args arguments
     */
    public static void main(String[] args) {
        initProblem(0);
        SacADos bag = AlgoGlouton.run();
        for (Objet object : bag.getObjects())
            System.out.println(object.getIndex() + " " + object.getRatio());
    }

    /**
     * Initialiser le problème à partir d'un fichier texte
     * @param number numéro du problème
     */
    public static void initProblem(int number) {
        InputStream file = ProblemeSacADos.class.getClassLoader().getResourceAsStream("sac" + number + ".txt");
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
                        int weight = Integer.parseInt(object_values[0]);
                        int value = Integer.parseInt(object_values[1]);
                        available_objects.add(new Objet(line_count,weight,value));
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new Exception("Fichier introuvable.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
