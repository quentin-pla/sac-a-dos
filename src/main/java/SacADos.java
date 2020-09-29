import java.util.ArrayList;

/**
 * Sac à dos
 */
public class SacADos {
    /**
     * Poids maximum
     */
    private int max_weight;

    /**
     * Objets dans le sac
     */
    private ArrayList<Objet> objects;

    /**
     * Constructeur
     * @param max_weight poids maximum
     */
    public SacADos(int max_weight) {
        this.max_weight = max_weight;
        this.objects = new ArrayList<>();
    }

    /**
     * Ajouter un objet dans le sac
     */
    public void addObject(Objet object) {
        if ((getTotalWeight() + object.getWeight()) <= max_weight) objects.add(object);
    }

    /**
     * Obtenir le poids en cours du sac
     */
    public int getTotalWeight() {
        int total_weight = 0;
        for (Objet object : objects) total_weight += object.getWeight();
        return total_weight;
    }

    /*** GETTERS & SETTERS ***/

    public ArrayList<Objet> getObjects() {
        return objects;
    }
}
