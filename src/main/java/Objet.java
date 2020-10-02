/**
 * Objet du sac
 */
public class Objet implements Comparable<Objet> {
    /**
     * Position
     */
    private int index;

    /**
     * Poids
     */
    private double weight;

    /**
     * Valeur
     */
    private double value;

    /**
     * Ratio valeur/poids
     */
    private double ratio;

    /**
     * Constructeur
     * @param weight poids
     * @param value valeur
     */
    public Objet(int index, int weight, int value) {
        this.index = index;
        this.weight = weight;
        this.value = value;
    }

    /**
     * Comparaison avec un autre objet
     * @param object objet à comparer
     * @return résultat de la comparaison
     */
    @Override
    public int compareTo(Objet object) {
        return Double.compare(object.ratio, ratio);
    }

    /*** GETTERS & SETTERS ***/

    public int getIndex() { return index; }

    public double getWeight() { return weight; }

    public double getValue() { return value; }

    public void setRatio(double ratio) { this.ratio = ratio; }
}
