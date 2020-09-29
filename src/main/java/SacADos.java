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
     * @return poids total
     */
    public int getTotalWeight() {
        int total_weight = 0;
        for (Objet object : objects) total_weight += object.getWeight();
        return total_weight;
    }

    /**
     * Obtenir la valeur en cours des objets du sac
     * @return valeur total
     */
    public int getTotalValue() {
        int total_value = 0;
        for (Objet object : objects) total_value += object.getValue();
        return total_value;
    }

    @Override
    public String toString() {
        String string = "Sac à dos (capacité maximale " + max_weight + "):" +
            "\n-> poids total:  " + getTotalWeight() +
            "\n-> valeur total: " + getTotalValue() +
            "\n-> objets contenus: ";
        for (Objet object : objects)
            string = string.concat(object.getIndex()+" ");
        return string;
    }

    /*** GETTERS & SETTERS ***/

    public ArrayList<Objet> getObjects() {
        return objects;
    }
}
