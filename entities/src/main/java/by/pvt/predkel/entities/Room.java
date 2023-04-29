package by.pvt.predkel.entities;


import by.pvt.predkel.entities.options.CommonParameters;
import by.pvt.predkel.entities.options.DetermineTheTypeOfFire;
import by.pvt.predkel.entities.options.IntegratedThermalAndTechnicalParameters;
import by.pvt.predkel.entities.options.ParametersCalculatedFireLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for Room complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class Room extends Entity {
    private static final long serialVersionUID = 1L;

    private CommonParameters commonParameters;

    private List<Double> coefficientSForRoom;

    protected List<Aperture> aperture;

    private ParametersCalculatedFireLoad parametersCalculatedFireLoad;
    private List<SubstanceOfRoom> substanceOfRoom;

    private DetermineTheTypeOfFire determineTheTypeOfFire;

    private IntegratedThermalAndTechnicalParameters integratedThermalAndTechnicalParameters;

    private List<Double> changeInMeanBulkTemperature;

    private List<Double> changeInTemperatureOfWalls;

    private List<Double> changeInTemperatureOfSlab;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;

        Room room = (Room) o;

        if (!getCommonParameters().equals(room.getCommonParameters())) return false;
        if (!getCoefficientSForRoom().equals(room.getCoefficientSForRoom())) return false;
        if (!getAperture().equals(room.getAperture())) return false;
        if (!getParametersCalculatedFireLoad().equals(room.getParametersCalculatedFireLoad())) return false;
        if (getSubstanceOfRoom() != null ? !getSubstanceOfRoom().equals(room.getSubstanceOfRoom()) : room.getSubstanceOfRoom() != null)
            return false;
        if (!getDetermineTheTypeOfFire().equals(room.getDetermineTheTypeOfFire())) return false;
        if (!getIntegratedThermalAndTechnicalParameters().equals(room.getIntegratedThermalAndTechnicalParameters()))
            return false;
        if (!getChangeInMeanBulkTemperature().equals(room.getChangeInMeanBulkTemperature())) return false;
        if (!getChangeInTemperatureOfWalls().equals(room.getChangeInTemperatureOfWalls())) return false;
        return getChangeInTemperatureOfSlab().equals(room.getChangeInTemperatureOfSlab());

    }

    @Override
    public int hashCode() {
        int result = getCommonParameters().hashCode();
        result = 31 * result + getCoefficientSForRoom().hashCode();
        result = 31 * result + getAperture().hashCode();
        result = 31 * result + getParametersCalculatedFireLoad().hashCode();
        result = 31 * result + (getSubstanceOfRoom() != null ? getSubstanceOfRoom().hashCode() : 0);
        result = 31 * result + getDetermineTheTypeOfFire().hashCode();
        result = 31 * result + getIntegratedThermalAndTechnicalParameters().hashCode();
        result = 31 * result + getChangeInMeanBulkTemperature().hashCode();
        result = 31 * result + getChangeInTemperatureOfWalls().hashCode();
        result = 31 * result + getChangeInTemperatureOfSlab().hashCode();
        return result;
    }


    /**
     * Gets the value of the commonParameters property.
     *
     * @return possible object is
     * {@link CommonParameters }
     */
    public CommonParameters getCommonParameters() {
        if (commonParameters == null)
            this.commonParameters = new CommonParameters();
        return commonParameters;
    }

    /**
     * Sets the value of the commonParameters property.
     *
     * @param value allowed object is
     *              {@link CommonParameters }
     */
    public void setCommonParameters(CommonParameters value) {
        this.commonParameters = value;
    }

    /**
     * Gets the value of the coefficientSForRoom property.
     *
     * @return possible object is
     * {@link List<Double> }
     */
    public List<Double> getCoefficientSForRoom() {
        if (coefficientSForRoom == null)
            this.coefficientSForRoom = new ArrayList<Double>();
        return coefficientSForRoom;
    }

    /**
     * Sets the value of the coefficientSForRoom property.
     *
     * @param value allowed object is
     *              {@link List<Double> }
     */
    public void setCoefficientSForRoom(List<Double> value) {
        this.coefficientSForRoom = value;
    }

    /**
     * Gets the value of the aperture property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aperture property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAperture().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Aperture }
     */
    public List<Aperture> getAperture() {
        if (aperture == null) {
            aperture = new ArrayList<Aperture>();
        }
        return this.aperture;
    }

    public void setAperture(List<Aperture> aperture) {
        this.aperture = aperture;
    }

    /**
     * Gets the value of the parametersCalculatedFireLoad property.
     *
     * @return possible object is
     * {@link ParametersCalculatedFireLoad }
     */
    public ParametersCalculatedFireLoad getParametersCalculatedFireLoad() {
        if (parametersCalculatedFireLoad == null)
            this.parametersCalculatedFireLoad = new ParametersCalculatedFireLoad();
        return parametersCalculatedFireLoad;
    }

    /**
     * Sets the value of the parametersCalculatedFireLoad property.
     *
     * @param value allowed object is
     *              {@link ParametersCalculatedFireLoad }
     */
    public void setParametersCalculatedFireLoad(ParametersCalculatedFireLoad value) {
        this.parametersCalculatedFireLoad = value;
    }

    /**
     * Gets the value of the substanceOfRoom property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the substanceOfRoom property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubstanceOfRoom().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubstanceOfRoom }
     */
    public List<SubstanceOfRoom> getSubstanceOfRoom() {
        if (substanceOfRoom == null) {
            substanceOfRoom = new ArrayList<SubstanceOfRoom>();
        }
        return this.substanceOfRoom;
    }

    public void setSubstanceOfRoom(List<SubstanceOfRoom> substanceOfRoom) {
        this.substanceOfRoom = substanceOfRoom;
    }

    /**
     * Gets the value of the determineTheTypeOfFire property.
     *
     * @return possible object is
     * {@link DetermineTheTypeOfFire }
     */
    public DetermineTheTypeOfFire getDetermineTheTypeOfFire() {
        if (determineTheTypeOfFire == null)
            this.determineTheTypeOfFire = new DetermineTheTypeOfFire();
        return determineTheTypeOfFire;
    }

    /**
     * Sets the value of the determineTheTypeOfFire property.
     *
     * @param value allowed object is
     *              {@link DetermineTheTypeOfFire }
     */
    public void setDetermineTheTypeOfFire(DetermineTheTypeOfFire value) {
        this.determineTheTypeOfFire = value;
    }

    /**
     * Gets the value of the integratedThermalAndTechnicalParameters property.
     *
     * @return possible object is
     * {@link IntegratedThermalAndTechnicalParameters }
     */
    public IntegratedThermalAndTechnicalParameters getIntegratedThermalAndTechnicalParameters() {
        if (integratedThermalAndTechnicalParameters == null)
            this.integratedThermalAndTechnicalParameters = new IntegratedThermalAndTechnicalParameters();
        return integratedThermalAndTechnicalParameters;
    }

    /**
     * Sets the value of the integratedThermalAndTechnicalParameters property.
     *
     * @param value allowed object is
     *              {@link IntegratedThermalAndTechnicalParameters }
     */
    public void setIntegratedThermalAndTechnicalParameters(IntegratedThermalAndTechnicalParameters value) {
        this.integratedThermalAndTechnicalParameters = value;
    }

    /**
     * Gets the value of the changeInMeanBulkTemperature property.
     *
     * @return possible object is
     * {@link List<Double>  }
     */
    public List<Double> getChangeInMeanBulkTemperature() {
        if (changeInMeanBulkTemperature == null) {
            changeInMeanBulkTemperature = new ArrayList<>(121);
        }
        return this.changeInMeanBulkTemperature;
    }

    /**
     * Gets the value of the changeInTemperatureOfWalls property.
     *
     * @return possible object is
     * {@link List<Double>  }
     */
    public List<Double> getChangeInTemperatureOfWalls() {
        if (changeInTemperatureOfWalls == null)
            this.changeInTemperatureOfWalls = new ArrayList<>(121);
        return changeInTemperatureOfWalls;
    }

    /**
     * Gets the value of the changeInTemperatureOfSlab property.
     *
     * @return possible object is
     * {@link List<Double>  }
     */
    public List<Double> getChangeInTemperatureOfSlab() {
        if (changeInTemperatureOfSlab == null)
            this.changeInTemperatureOfSlab = new ArrayList<>(121);
        return changeInTemperatureOfSlab;
    }

    public void setChangeInMeanBulkTemperature(List<Double> changeInMeanBulkTemperature) {
        this.changeInMeanBulkTemperature = changeInMeanBulkTemperature;
    }

    public void setChangeInTemperatureOfWalls(List<Double> changeInTemperatureOfWalls) {
        this.changeInTemperatureOfWalls = changeInTemperatureOfWalls;
    }

    public void setChangeInTemperatureOfSlab(List<Double> changeInTemperatureOfSlab) {
        this.changeInTemperatureOfSlab = changeInTemperatureOfSlab;
    }

    @Override
    public String toString() {
        return null;
    }
}
