import java.util.ArrayList;
import java.util.Arrays;

/**
 * Sac à dos
 */
public class SacADos {
    /**
     * Contenu du sac
     */
    private boolean[] content;

    /**
     * Constructeur
     */
    public SacADos() {
        this.content = new boolean[ProblemeSacADos.objects_count];
        Arrays.fill(content, false);
    }

    /**
     * Constructeur surchargé
     */
    public SacADos(boolean[] content) {
        this.content = content;
    }

    /**
     * Ajouter un objet dans le sac
     */
    public void addObject(int index) {
        double new_weight = getTotalWeight() + ProblemeSacADos.getObject(index).getWeight();
        content[index] = new_weight <= ProblemeSacADos.max_weight;
    }

    /**
     * Obtenir le poids en cours du sac
     * @return poids total
     */
    public int getTotalWeight() {
        int total_weight = 0;
        for (int i = 0; i < content.length; i++)
            if (content[i]) total_weight += ProblemeSacADos.getObject(i).getWeight();
        return total_weight;
    }

    /**
     * Obtenir la valeur en cours des objets du sac
     * @return valeur total
     */
    public int getTotalValue() {
        int total_value = 0;
        for (int i = 0; i < content.length; i++)
            if (content[i]) total_value += ProblemeSacADos.getObject(i).getValue();
        return total_value;
    }

    /**
     * Obtenir l'index des objets contenus dans le sac
     * @return index des objets contenus
     */
    public ArrayList<Integer> getObjectsContent() {
        ArrayList<Integer> objects_indexes = new ArrayList<>();
        for (int i = 0; i < content.length; i++)
            if (content[i]) objects_indexes.add(ProblemeSacADos.getObject(i).getIndex());
        return objects_indexes;
    }

    @Override
    public String toString() {
        return "Sac à dos (capacité maximale " + ProblemeSacADos.max_weight + "):" +
            "\n-> poids total:  " + getTotalWeight() +
            "\n-> valeur total: " + getTotalValue() +
            "\n-> objets contenus: " + getObjectsContent();
    }

    /*** GETTERS & SETTERS ***/

    public boolean[] getContent() { return content; }
}
