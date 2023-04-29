package by.pvt.predkel.entities.options;


import by.pvt.predkel.entities.Entity;

/**
 * <p>Java class for IntegratedThermalAndTechnicalParameters complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class IntegratedThermalAndTechnicalParameters extends Entity {
    private static final long serialVersionUID = 1L;
    private double maximumMeanBulkTemperature;
    private double durationOfFireSurround;
    private double timeReachMaximumMeanBulkTemperature;
    private double maximumAverageTemperatureOfWallSurface;
    private double timeToReachMaximumTemperatureOfWallSurface;
    private double averageMaximumTemperatureOfSlab;
    private double timeToReachMaximumTemperatureOfSlabSurface;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntegratedThermalAndTechnicalParameters)) return false;
        if (!super.equals(o)) return false;

        IntegratedThermalAndTechnicalParameters that = (IntegratedThermalAndTechnicalParameters) o;

        if (Double.compare(that.getMaximumMeanBulkTemperature(), getMaximumMeanBulkTemperature()) != 0) return false;
        if (Double.compare(that.getDurationOfFireSurround(), getDurationOfFireSurround()) != 0) return false;
        if (Double.compare(that.getTimeReachMaximumMeanBulkTemperature(), getTimeReachMaximumMeanBulkTemperature()) != 0)
            return false;
        if (Double.compare(that.getMaximumAverageTemperatureOfWallSurface(), getMaximumAverageTemperatureOfWallSurface()) != 0)
            return false;
        if (Double.compare(that.getTimeToReachMaximumTemperatureOfWallSurface(), getTimeToReachMaximumTemperatureOfWallSurface()) != 0)
            return false;
        if (Double.compare(that.getAverageMaximumTemperatureOfSlab(), getAverageMaximumTemperatureOfSlab()) != 0)
            return false;
        return Double.compare(that.getTimeToReachMaximumTemperatureOfSlabSurface(), getTimeToReachMaximumTemperatureOfSlabSurface()) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getMaximumMeanBulkTemperature());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getDurationOfFireSurround());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getTimeReachMaximumMeanBulkTemperature());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getMaximumAverageTemperatureOfWallSurface());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getTimeToReachMaximumTemperatureOfWallSurface());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getAverageMaximumTemperatureOfSlab());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getTimeToReachMaximumTemperatureOfSlabSurface());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    /**
     * Gets the value of the maximumMeanBulkTemperature property.
     */
    public double getMaximumMeanBulkTemperature() {
        return maximumMeanBulkTemperature;
    }

    /**
     * Sets the value of the maximumMeanBulkTemperature property.
     */
    public void setMaximumMeanBulkTemperature(double value) {
        this.maximumMeanBulkTemperature = value;
    }

    /**
     * Gets the value of the durationOfFireSurround property.
     */
    public double getDurationOfFireSurround() {
        return durationOfFireSurround;
    }

    /**
     * Sets the value of the durationOfFireSurround property.
     */
    public void setDurationOfFireSurround(double value) {
        this.durationOfFireSurround = value;
    }

    /**
     * Gets the value of the timeReachMaximumMeanBulkTemperature property.
     */
    public double getTimeReachMaximumMeanBulkTemperature() {
        return timeReachMaximumMeanBulkTemperature;
    }

    /**
     * Sets the value of the timeReachMaximumMeanBulkTemperature property.
     */
    public void setTimeReachMaximumMeanBulkTemperature(double value) {
        this.timeReachMaximumMeanBulkTemperature = value;
    }

    /**
     * Gets the value of the maximumAverageTemperatureOfWallSurface property.
     */
    public double getMaximumAverageTemperatureOfWallSurface() {
        return maximumAverageTemperatureOfWallSurface;
    }

    /**
     * Sets the value of the maximumAverageTemperatureOfWallSurface property.
     */
    public void setMaximumAverageTemperatureOfWallSurface(double value) {
        this.maximumAverageTemperatureOfWallSurface = value;
    }

    /**
     * Gets the value of the timeToReachMaximumTemperatureOfWallSurface property.
     */
    public double getTimeToReachMaximumTemperatureOfWallSurface() {
        return timeToReachMaximumTemperatureOfWallSurface;
    }

    /**
     * Sets the value of the timeToReachMaximumTemperatureOfWallSurface property.
     */
    public void setTimeToReachMaximumTemperatureOfWallSurface(double value) {
        this.timeToReachMaximumTemperatureOfWallSurface = value;
    }

    /**
     * Gets the value of the averageMaximumTemperatureOfSlab property.
     */
    public double getAverageMaximumTemperatureOfSlab() {
        return averageMaximumTemperatureOfSlab;
    }

    /**
     * Sets the value of the averageMaximumTemperatureOfSlab property.
     */
    public void setAverageMaximumTemperatureOfSlab(double value) {
        this.averageMaximumTemperatureOfSlab = value;
    }

    /**
     * Gets the value of the timeToReachMaximumTemperatureOfSlabSurface property.
     */
    public double getTimeToReachMaximumTemperatureOfSlabSurface() {
        return timeToReachMaximumTemperatureOfSlabSurface;
    }

    /**
     * Sets the value of the timeToReachMaximumTemperatureOfSlabSurface property.
     */
    public void setTimeToReachMaximumTemperatureOfSlabSurface(double value) {
        this.timeToReachMaximumTemperatureOfSlabSurface = value;
    }

}
