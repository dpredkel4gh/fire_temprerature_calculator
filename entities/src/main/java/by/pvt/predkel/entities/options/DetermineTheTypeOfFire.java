package by.pvt.predkel.entities.options;


import by.pvt.predkel.entities.Entity;

/**
 * <p>Java class for DetermineTheTypeOfFire complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class DetermineTheTypeOfFire extends Entity {
    private static final long serialVersionUID = 1L;
    private double proemnostOfRoom;
    private double averageAmountOfCombustionAir;
    private double specificCriticalAmountOfFireLoad;
    private double specificValueOfFireLoad;
    private boolean prn;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetermineTheTypeOfFire)) return false;
        if (!super.equals(o)) return false;

        DetermineTheTypeOfFire that = (DetermineTheTypeOfFire) o;

        if (Double.compare(that.getProemnostOfRoom(), getProemnostOfRoom()) != 0) return false;
        if (Double.compare(that.getAverageAmountOfCombustionAir(), getAverageAmountOfCombustionAir()) != 0)
            return false;
        if (Double.compare(that.getSpecificCriticalAmountOfFireLoad(), getSpecificCriticalAmountOfFireLoad()) != 0)
            return false;
        if (Double.compare(that.getSpecificValueOfFireLoad(), getSpecificValueOfFireLoad()) != 0) return false;
        return getPrn() == that.getPrn();

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getProemnostOfRoom());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getAverageAmountOfCombustionAir());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSpecificCriticalAmountOfFireLoad());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSpecificValueOfFireLoad());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (getPrn() ? 1 : 0);
        return result;
    }

    public boolean getPrn() {
        return prn;
    }

    public void setPrn(boolean prn) {
        this.prn = prn;
    }

    /**
     * Gets the value of the proemnostOfRoom property.
     */
    public double getProemnostOfRoom() {
        return proemnostOfRoom;
    }

    /**
     * Sets the value of the proemnostOfRoom property.
     */
    public void setProemnostOfRoom(double value) {
        this.proemnostOfRoom = value;
    }

    /**
     * Gets the value of the averageAmountOfCombustionAir property.
     */
    public double getAverageAmountOfCombustionAir() {
        return averageAmountOfCombustionAir;
    }

    /**
     * Sets the value of the averageAmountOfCombustionAir property.
     */
    public void setAverageAmountOfCombustionAir(double value) {
        this.averageAmountOfCombustionAir = value;
    }

    /**
     * Gets the value of the specificCriticalAmountOfFireLoad property.
     */
    public double getSpecificCriticalAmountOfFireLoad() {
        return specificCriticalAmountOfFireLoad;
    }

    /**
     * Sets the value of the specificCriticalAmountOfFireLoad property.
     */
    public void setSpecificCriticalAmountOfFireLoad(double value) {
        this.specificCriticalAmountOfFireLoad = value;
    }

    /**
     * Gets the value of the specificValueOfFireLoad property.
     */
    public double getSpecificValueOfFireLoad() {
        return specificValueOfFireLoad;
    }

    /**
     * Sets the value of the specificValueOfFireLoad property.
     */
    public void setSpecificValueOfFireLoad(double value) {
        this.specificValueOfFireLoad = value;
    }

}
