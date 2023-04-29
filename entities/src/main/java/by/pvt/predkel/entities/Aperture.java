package by.pvt.predkel.entities;


/**
 * <p>Java class for Aperture complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class Aperture extends Entity {

    private String typeOfAperture;
    private double width;
    private double height;
    private int count;
    private double squareOfAperture;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aperture)) return false;
        if (!super.equals(o)) return false;

        Aperture aperture = (Aperture) o;

        if (Double.compare(aperture.getWidth(), getWidth()) != 0) return false;
        if (Double.compare(aperture.getHeight(), getHeight()) != 0) return false;
        if (getCount() != aperture.getCount()) return false;
        if (Double.compare(aperture.getSquareOfAperture(), getSquareOfAperture()) != 0) return false;
        return getTypeOfAperture().equals(aperture.getTypeOfAperture());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + getTypeOfAperture().hashCode();
        temp = Double.doubleToLongBits(getWidth());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getCount();
        temp = Double.doubleToLongBits(getSquareOfAperture());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Gets the value of the typeOfAperture property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTypeOfAperture() {
        return typeOfAperture;
    }

    /**
     * Sets the value of the typeOfAperture property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTypeOfAperture(String value) {
        this.typeOfAperture = value;
    }

    /**
     * Gets the value of the width property.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     */
    public void setWidth(double value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     */
    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Gets the value of the count property.
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     */
    public void setCount(int value) {
        this.count = value;
    }

    /**
     * Gets the value of the squareOfAperture property.
     */
    public double getSquareOfAperture() {
        if (squareOfAperture == 0)
            squareOfAperture = height * width;
        return squareOfAperture;
    }

    /**
     * Sets the value of the squareOfAperture property.
     */
    public void setSquareOfAperture(double value) {
        this.squareOfAperture = value;
    }

}
