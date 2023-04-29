package by.pvt.predkel.entities;


/**
 * <p>Java class for FlammableSubstance complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class FlammableSubstance extends Entity {
    private static final long serialVersionUID = 1L;
    private String nameOfSubstance;
    private double amountOfCombustionAir;
    private double combustionHeat;
    private double averageSpeedBurnout;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlammableSubstance)) return false;

        FlammableSubstance substance = (FlammableSubstance) o;

        if (Double.compare(substance.getAmountOfCombustionAir(), getAmountOfCombustionAir()) != 0) return false;
        if (Double.compare(substance.getCombustionHeat(), getCombustionHeat()) != 0) return false;
        if (Double.compare(substance.getAverageSpeedBurnout(), getAverageSpeedBurnout()) != 0) return false;
        return getNameOfSubstance().equals(substance.getNameOfSubstance());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getNameOfSubstance().hashCode();
        temp = Double.doubleToLongBits(getAmountOfCombustionAir());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCombustionHeat());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getAverageSpeedBurnout());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Gets the value of the nameOfSubstance property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNameOfSubstance() {
        return nameOfSubstance;
    }

    /**
     * Sets the value of the nameOfSubstance property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNameOfSubstance(String value) {
        this.nameOfSubstance = value;
    }

    /**
     * Gets the value of the amountOfCombustionAir property.
     */
    public double getAmountOfCombustionAir() {
        return amountOfCombustionAir;
    }

    /**
     * Sets the value of the amountOfCombustionAir property.
     */
    public void setAmountOfCombustionAir(double value) {
        this.amountOfCombustionAir = value;
    }

    /**
     * Gets the value of the combustionHeat property.
     */
    public double getCombustionHeat() {
        return combustionHeat;
    }

    /**
     * Sets the value of the combustionHeat property.
     */
    public void setCombustionHeat(double value) {
        this.combustionHeat = value;
    }

    /**
     * Gets the value of the averageSpeedBurnout property.
     */
    public double getAverageSpeedBurnout() {
        return averageSpeedBurnout;
    }

    /**
     * Sets the value of the averageSpeedBurnout property.
     */
    public void setAverageSpeedBurnout(double value) {
        this.averageSpeedBurnout = value;
    }

}
