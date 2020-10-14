import java.util.ArrayList;
import java.util.Collections;

/**
 * Algorithme glouton
 */
public class AlgoGlouton {
    /**
     * Exécution de l'algorithme glouton
     * permettant d'obtenir la borne inférieure
     */
    public static NoeudBAB run() {
        ArrayList<Objet> objects_list = new ArrayList<>(ProblemeSacADos.available_objects);
        for (Objet object : objects_list) object.setRatio(object.getValue()*1.0/object.getWeight());
        Collections.sort(objects_list);
        NoeudBAB node = new NoeudBAB(0);
        for (Objet object : objects_list) node.getBag().addObject(object.getIndex());
        return node;
    }
}
