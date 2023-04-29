package by.pvt.predkel.entities;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Building complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class Building extends Entity {
    private static final long serialVersionUID = 1L;

    private double selectedTemperatureOfRegion;

    private List<Double> coefficientSForBuild;

    private double specifyingCoefficientS5;

    private String nameOfBuilding;

    private long userId;

    private User user;

    private String dateOfBuilding;

    private List<Room> room;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Building)) return false;
        if (!super.equals(o)) return false;

        Building building = (Building) o;

        if (Double.compare(building.getSelectedTemperatureOfRegion(), getSelectedTemperatureOfRegion()) != 0)
            return false;
        if (Double.compare(building.getSpecifyingCoefficientS5(), getSpecifyingCoefficientS5()) != 0) return false;
        if (!getCoefficientSForBuild().equals(building.getCoefficientSForBuild())) return false;
        if (!getNameOfBuilding().equals(building.getNameOfBuilding())) return false;
        if (!getDateOfBuilding().equals(building.getDateOfBuilding())) return false;
        return getRoom() != null ? getRoom().equals(building.getRoom()) : building.getRoom() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(getSelectedTemperatureOfRegion());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getCoefficientSForBuild().hashCode();
        temp = Double.doubleToLongBits(getSpecifyingCoefficientS5());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getNameOfBuilding().hashCode();
        result = 31 * result + getDateOfBuilding().hashCode();
        result = 31 * result + (getRoom() != null ? getRoom().hashCode() : 0);
        return result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the value of the selectedTemperatureOfRegion property.
     */
    public double getSelectedTemperatureOfRegion() {
        return selectedTemperatureOfRegion;
    }

    /**
     * Sets the value of the selectedTemperatureOfRegion property.
     */
    public void setSelectedTemperatureOfRegion(double value) {
        this.selectedTemperatureOfRegion = value;
    }

    /**
     * Gets the value of the coefficientSForBuild property.
     *
     * @return possible object is
     * {@link List<Double> }
     */
    public List<Double> getCoefficientSForBuild() {
        if (coefficientSForBuild == null)
            this.coefficientSForBuild = new ArrayList<Double>();
        return coefficientSForBuild;
    }

    /**
     * Sets the value of the coefficientSForBuild property.
     *
     * @param value allowed object is
     *              {@link List<Double> }
     */
    public void setCoefficientSForBuild(List<Double> value) {
        this.coefficientSForBuild = value;
    }

    /**
     * Gets the value of the specifyingCoefficientS5 property.
     */
    public double getSpecifyingCoefficientS5() {
        return specifyingCoefficientS5;
    }

    /**
     * Sets the value of the specifyingCoefficientS5 property.
     */
    public void setSpecifyingCoefficientS5(double value) {
        this.specifyingCoefficientS5 = value;
    }

    /**
     * Gets the value of the nameOfBuilding property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNameOfBuilding() {
        return nameOfBuilding;
    }

    /**
     * Sets the value of the nameOfBuilding property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNameOfBuilding(String value) {
        this.nameOfBuilding = value;
    }

    /**
     * Gets the value of the userId property.
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     */
    public void setUserId(long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the dateOfBuilding property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDateOfBuilding() {
        return dateOfBuilding;
    }

    /**
     * Sets the value of the dateOfBuilding property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDateOfBuilding(String value) {
        this.dateOfBuilding = value;
    }

    /**
     * Gets the value of the room property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the room property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoom().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Room }
     */
    public List<Room> getRoom() {
        if (room == null) {
            room = new ArrayList<Room>();
        }
        return this.room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }
}
