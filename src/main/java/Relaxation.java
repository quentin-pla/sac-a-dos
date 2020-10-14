/**
 * Relaxation Lagrangienne
 */
public class Relaxation {
    /**
     * Lambda
     */
    public static double lambda = 0;

    /**
     * Solution optimale
     */
    public static double[] solution = new double[ProblemeSacADos.objects_count];

    /**
     * Calculer la solution optimale
     * pour obtenir une borne supérieur
     */
    public static void calculateSolution() {
        NoeudBAB node = new NoeudBAB(0);
        do {
            for (int i = 0; i < ProblemeSacADos.objects_count; i++) {
                Objet object = ProblemeSacADos.getObject(i);
                solution[i] = object.getValue() - (lambda * object.getWeight());
                node.getBag().getContent()[i] = (solution[i] > 0);
            }
            ++lambda;
        } while (node.getWeight() > ProblemeSacADos.max_weight);
    }

    /**
     * Calculer la valeur maximale possible
     * @param content liste d'objets
     * @param index index
     * @return double
     */
    public static double calculateMaxValue(boolean[] content, int index) {
        double value = lambda * ProblemeSacADos.max_weight;
        for (int i = 0; i < index; i++)
            value += content[i] ? solution[i] : 0;
        for (int i = index; i < solution.length; i++)
            value += (solution[i] > 0) ? solution[i] : 0;
        return value;
    }
}
