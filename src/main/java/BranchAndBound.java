import java.util.TreeSet;

/**
 * Algorithme Branch and Bound
 */
public class BranchAndBound {
    /**
     * Arbre
     */
    private static TreeSet<NoeudBAB> tree = new TreeSet<>();

    /**
     * Solution finale
     */
    private static NoeudBAB solution = new NoeudBAB(0);

    /**
     * Exécuter l'algorithme
     * @param node noeud initial (provenant de l'algorithme glouton)
     * @return noeud final
     */
    public static NoeudBAB run(NoeudBAB node) {
        expandTree(solution);
        solution = node;
        NoeudBAB next_node;
        while ((next_node = tree.pollFirst()) != null) {
            if (next_node.getIndex() == ProblemeSacADos.objects_count)
                if (getFinalSolution(next_node)) continue;
                else break;
            expandTree(next_node);
        }
        return solution;
    }

    /**
     * Étendre l'arbre
     * @param next_node noeud suivant
     */
    private static void expandTree(NoeudBAB next_node) {
        NoeudBAB left_node = new NoeudBAB(next_node), right_node = new NoeudBAB(next_node);
        if (isValidSolution(left_node.addEmpty())) tree.add(left_node);
        if (isValidSolution(right_node.addObject())) tree.add(right_node);
    }

    /**
     * Savoir si un noeud est une solution valide
     * @param node noeud
     */
    private static boolean isValidSolution(NoeudBAB node) {
        return node.getMax_value() >= solution.getValue()
            && node.getWeight() <= ProblemeSacADos.max_weight;
    }

    /**
     * Obtenir la solution finale
     * @return arrêt boucle
     */
    private static boolean getFinalSolution(NoeudBAB node) {
        if (node.getValue() >= solution.getValue() &&
                node.getWeight() <= ProblemeSacADos.max_weight)
            solution = node;
        return !tree.isEmpty();
    }
}
