import java.util.ArrayList;
import java.util.Collections;

/**
 * Algorithme glouton
 */
public class AlgoGlouton {
    /**
     * Liste des objets triés selon ratio
     */
    public static ArrayList<Objet> orderedObjectList;

    /**
     * Exécution de l'algorithme
     */
    public static SacADos run() {
        orderedObjectList = new ArrayList<>();
        for(Objet object : ProblemeSacADos.available_objects) {
            object.setRatio((double)object.getValue()/(double)object.getWeight());
            orderedObjectList.add(object);
        }
        Collections.sort(orderedObjectList);
        SacADos bag = new SacADos(ProblemeSacADos.max_weight);
        for (Objet object : orderedObjectList) bag.addObject(object);
        return bag;
    }
}
