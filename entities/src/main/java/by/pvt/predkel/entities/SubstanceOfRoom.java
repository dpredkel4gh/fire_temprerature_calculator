package by.pvt.predkel.entities;

/**
 * <p>Java class for SubstanceOfRoom complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class SubstanceOfRoom extends Entity {
    private static final long serialVersionUID = 1L;

    private FlammableSubstance flammableSubstance;
    private double weight;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubstanceOfRoom)) return false;

        SubstanceOfRoom that = (SubstanceOfRoom) o;

        if (Double.compare(that.getWeight(), getWeight()) != 0) return false;
        return getFlammableSubstance().equals(that.getFlammableSubstance());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getFlammableSubstance().hashCode();
        temp = Double.doubleToLongBits(getWeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Gets the value of the flammableSubstance property.
     *
     * @return possible object is
     * {@link FlammableSubstance }
     */
    public FlammableSubstance getFlammableSubstance() {
        if (flammableSubstance == null)
            this.flammableSubstance = new FlammableSubstance();
        return flammableSubstance;
    }

    /**
     * Sets the value of the flammableSubstance property.
     *
     * @param value allowed object is
     *              {@link FlammableSubstance }
     */
    public void setFlammableSubstance(FlammableSubstance value) {
        this.flammableSubstance = value;
    }

    /**
     * Gets the value of the weight property.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     */
    public void setWeight(double value) {
        this.weight = value;
    }

}
