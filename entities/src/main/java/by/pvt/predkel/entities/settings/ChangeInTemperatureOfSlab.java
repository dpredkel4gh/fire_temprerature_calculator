package by.pvt.predkel.entities.settings;

import by.pvt.predkel.entities.Entity;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ChangeInTemperatureOfSlab complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class ChangeInTemperatureOfSlab extends Entity {

    private static final long serialVersionUID = 1L;

    private List<Double> changes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangeInTemperatureOfSlab)) return false;
        if (!super.equals(o)) return false;

        ChangeInTemperatureOfSlab that = (ChangeInTemperatureOfSlab) o;

        return getChanges().equals(that.getChanges());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getChanges().hashCode();
        return result;
    }

    /**
     * Gets the value of the changes property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changes property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChanges().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     */
    public List<Double> getChanges() {
        if (changes == null) {
            changes = new ArrayList<Double>();
        }
        return this.changes;
    }

}
