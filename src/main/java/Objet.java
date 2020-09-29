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
    private int weight;

    /**
     * Valeur
     */
    private int value;

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

    public void setIndex(int index) { this.index = index; }

    public int getWeight() { return weight; }

    public void setWeight(int weight) { this.weight = weight; }

    public int getValue() { return value; }

    public void setValue(int value) { this.value = value; }

    public double getRatio() { return ratio; }

    public void setRatio(double ratio) { this.ratio = ratio; }
}
