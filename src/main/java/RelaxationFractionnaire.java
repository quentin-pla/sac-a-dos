import java.util.ArrayList;
import java.util.Collections;

/**
 * Relaxation fractionnaire
 */
public class RelaxationFractionnaire {
    /**
     * Liste des objets triés en fonction de leur ratio
     */
    private static int[] solution = new int[ProblemeSacADos.objects_count];

    /**
     * Initialiser la solution optimale
     */
    public static void init() {
        ArrayList<Objet> objects_list = new ArrayList<>(ProblemeSacADos.available_objects);
        Collections.sort(objects_list);
        for (int i = 0; i < objects_list.size(); i++) solution[i] = objects_list.get(i).getIndex();
    }

    /**
     * Calculer l'optimum fractionnaire associé au noeud
     */
    public static double calculateMaxValue(NoeudBAB node) {
        NoeudBAB node_clone = new NoeudBAB(node);
        for (int object : solution)
            if (object >= node_clone.getIndex())
                if (!node_clone.getBag().addObject(object))
                    return node_clone.getValue() + getFraction(node_clone, object);
        return node_clone.getValue();
    }

    /**
     * Obtenir la fraction d'un objet
     * @param node noeud
     * @param object_index objet qui n'a pas pu entrer dans le sac
     * @return fraction de la valeur de l'objet
     */
    private static double getFraction(NoeudBAB node, int object_index) {
        Objet object = ProblemeSacADos.getObject(object_index);
        double remaining_weight = ProblemeSacADos.max_weight - node.getWeight();
        return object.getValue() * remaining_weight / object.getWeight();
    }
}
