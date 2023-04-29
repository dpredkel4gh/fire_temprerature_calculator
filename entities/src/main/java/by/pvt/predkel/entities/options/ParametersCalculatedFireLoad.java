package by.pvt.predkel.entities.options;


import by.pvt.predkel.entities.Entity;

/**
 * <p>Java class for ParametersCalculatedFireLoad complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class ParametersCalculatedFireLoad extends Entity {
    private static final long serialVersionUID = 1L;
    private double specificFireLoad;
    private double specificFireLoadZVEZDOCHKA;
    private double reducedHeightOfApertures;
    private double generalSquareOfApertures;
    private double ventilationParameter;
    private double coefficientK;

    private double coefficientA = 1;
    private double coefficientB;
    private double coefficientS;
    private double estimatedFireLoad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParametersCalculatedFireLoad)) return false;
        if (!super.equals(o)) return false;

        ParametersCalculatedFireLoad that = (ParametersCalculatedFireLoad) o;

        if (Double.compare(that.getSpecificFireLoad(), getSpecificFireLoad()) != 0) return false;
        if (Double.compare(that.getSpecificFireLoadZVEZDOCHKA(), getSpecificFireLoadZVEZDOCHKA()) != 0) return false;
        if (Double.compare(that.getReducedHeightOfApertures(), getReducedHeightOfApertures()) != 0) return false;
        if (Double.compare(that.getGeneralSquareOfApertures(), getGeneralSquareOfApertures()) != 0) return false;
        if (Double.compare(that.getVentilationParameter(), getVentilationParameter()) != 0) return false;
        if (Double.compare(that.getCoefficientK(), getCoefficientK()) != 0) return false;
        if (Double.compare(that.getCoefficientA(), getCoefficientA()) != 0) return false;
        if (Double.compare(that.getCoefficientB(), getCoefficientB()) != 0) return false;
        if (Double.compare(that.getCoefficientS(), getCoefficientS()) != 0) return false;
        return Double.compare(that.getEstimatedFireLoad(), getEstimatedFireLoad()) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getSpecificFireLoad());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSpecificFireLoadZVEZDOCHKA());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getReducedHeightOfApertures());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getGeneralSquareOfApertures());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getVentilationParameter());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCoefficientK());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCoefficientA());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCoefficientB());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCoefficientS());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getEstimatedFireLoad());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Gets the value of the specificFireLoad property.
     */
    public double getSpecificFireLoad() {
        return specificFireLoad;
    }

    /**
     * Sets the value of the specificFireLoad property.
     */
    public void setSpecificFireLoad(double value) {
        this.specificFireLoad = value;
    }

    /**
     * Gets the value of the specificFireLoadZVEZDOCHKA property.
     */
    public double getSpecificFireLoadZVEZDOCHKA() {
        return specificFireLoadZVEZDOCHKA;
    }

    /**
     * Sets the value of the specificFireLoadZVEZDOCHKA property.
     */
    public void setSpecificFireLoadZVEZDOCHKA(double value) {
        this.specificFireLoadZVEZDOCHKA = value;
    }

    /**
     * Gets the value of the reducedHeightOfApertures property.
     */
    public double getReducedHeightOfApertures() {
        return reducedHeightOfApertures;
    }

    /**
     * Sets the value of the reducedHeightOfApertures property.
     */
    public void setReducedHeightOfApertures(double value) {
        this.reducedHeightOfApertures = value;
    }

    /**
     * Gets the value of the generalSquareOfApertures property.
     */
    public double getGeneralSquareOfApertures() {
        return generalSquareOfApertures;
    }

    /**
     * Sets the value of the generalSquareOfApertures property.
     */
    public void setGeneralSquareOfApertures(double value) {
        this.generalSquareOfApertures = value;
    }

    /**
     * Gets the value of the ventilationParameter property.
     */
    public double getVentilationParameter() {
        return ventilationParameter;
    }

    /**
     * Sets the value of the ventilationParameter property.
     */
    public void setVentilationParameter(double value) {
        this.ventilationParameter = value;
    }

    /**
     * Gets the value of the coefficientK property.
     */
    public double getCoefficientK() {
        return coefficientK;
    }

    /**
     * Sets the value of the coefficientK property.
     */
    public void setCoefficientK(double value) {
        this.coefficientK = value;
    }

    /**
     * Gets the value of the coefficientA property.
     */
    public double getCoefficientA() {
        return coefficientA;
    }

    /**
     * Sets the value of the coefficientA property.
     */
    public void setCoefficientA(double value) {
        this.coefficientA = value;
    }

    /**
     * Gets the value of the coefficientB property.
     */
    public double getCoefficientB() {
        return coefficientB;
    }

    /**
     * Sets the value of the coefficientB property.
     */
    public void setCoefficientB(double value) {
        this.coefficientB = value;
    }

    /**
     * Gets the value of the coefficientS property.
     */
    public double getCoefficientS() {
        return coefficientS;
    }

    /**
     * Sets the value of the coefficientS property.
     */
    public void setCoefficientS(double value) {
        this.coefficientS = value;
    }

    /**
     * Gets the value of the estimatedFireLoad property.
     */
    public double getEstimatedFireLoad() {
        return estimatedFireLoad;
    }

    /**
     * Sets the value of the estimatedFireLoad property.
     */
    public void setEstimatedFireLoad(double value) {
        this.estimatedFireLoad = value;
    }

}
