/**
 * Noeud Branch and Bound
 */
public class NoeudBAB implements Comparable<NoeudBAB> {
    /**
     * Sac à dos lié au noeud
     */
    private SacADos bag;

    /**
     * Valeur maximale relaxation
     */
    private double maxValue = 0;

    /**
     * Index du noeud
     */
    private int index;

    /**
     * Constructeur
     * @param index index
     */
    public NoeudBAB(int index) {
        this.bag = new SacADos();
        this.index = index;
    }

    /**
     * Constructeur surchargé
     * @param node noeud à cloner
     */
    public NoeudBAB(NoeudBAB node) {
        this.bag = new SacADos(node.bag.getContent().clone());
        this.index = node.index;
        this.maxValue = node.maxValue;
    }

    /**
     * Ajouter l'objet correspondant à l'index dans le sac à dos
     */
    public NoeudBAB addObject() {
        bag.getContent()[index] = true;
        index++;
        updateMaxValue();
        return this;
    }

    /**
     * Ne pas ajouter l'objet correspondant à l'index actuel dans le sac à dos
     */
    public NoeudBAB addEmpty() {
        bag.getContent()[index] = false;
        index++;
        updateMaxValue();
        return this;
    }

    /**
     * Mettre à jour la valeur maximale
     */
    private void updateMaxValue() {
        maxValue = Relaxation.calculateMaxValue(bag.getContent(), index);
    }

    /**
     * Comparer un autre noeud
     * @param node noeud BAB
     * @return résultat comparaison
     */
    @Override
    public int compareTo(NoeudBAB node) {
        return Double.compare(maxValue, node.getMaxValue());
    }

    /*** GETTERS & SETTERS ***/

    public int getWeight() { return bag.getTotalWeight(); }

    public int getValue() { return bag.getTotalValue(); }

    public int getIndex() { return index; }

    public double getMaxValue() { return maxValue; }

    public SacADos getBag() { return bag; }
}
