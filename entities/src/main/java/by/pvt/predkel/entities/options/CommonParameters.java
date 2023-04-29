package by.pvt.predkel.entities.options;


import by.pvt.predkel.entities.Entity;

/**
 * <p>Java class for CommonParameters complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class CommonParameters extends Entity {
    private static final long serialVersionUID = 1L;
    private String positionOfRoom;
    private String nameOfRoom;
    private double square;
    private double height;
    private double perimeter;
    private double volume;
    private double squareOfConstruction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonParameters)) return false;
        if (!super.equals(o)) return false;

        CommonParameters that = (CommonParameters) o;

        if (Double.compare(that.getSquare(), getSquare()) != 0) return false;
        if (Double.compare(that.getHeight(), getHeight()) != 0) return false;
        if (Double.compare(that.getPerimeter(), getPerimeter()) != 0) return false;
        if (Double.compare(that.getVolume(), getVolume()) != 0) return false;
        if (Double.compare(that.getSquareOfConstruction(), getSquareOfConstruction()) != 0) return false;
        if (!getPositionOfRoom().equals(that.getPositionOfRoom())) return false;
        return getNameOfRoom().equals(that.getNameOfRoom());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + getPositionOfRoom().hashCode();
        result = 31 * result + getNameOfRoom().hashCode();
        temp = Double.doubleToLongBits(getSquare());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getHeight());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPerimeter());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getVolume());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getSquareOfConstruction());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Gets the value of the positionOfRoom property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPositionOfRoom() {
        return positionOfRoom;
    }

    /**
     * Sets the value of the positionOfRoom property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPositionOfRoom(String value) {
        this.positionOfRoom = value;
    }

    /**
     * Gets the value of the nameOfRoom property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNameOfRoom() {
        return nameOfRoom;
    }

    /**
     * Sets the value of the nameOfRoom property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNameOfRoom(String value) {
        this.nameOfRoom = value;
    }

    /**
     * Gets the value of the square property.
     */
    public double getSquare() {
        return square;
    }

    /**
     * Sets the value of the square property.
     */
    public void setSquare(double value) {
        this.square = value;
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
     * Gets the value of the perimeter property.
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * Sets the value of the perimeter property.
     */
    public void setPerimeter(double value) {
        this.perimeter = value;
    }

    /**
     * Gets the value of the volume property.
     */
    public double getVolume() {
        if (volume == 0)
            volume = height * square;
        return volume;
    }

    /**
     * Sets the value of the volume property.
     */
    public void setVolume(double value) {
        this.volume = value;
    }

    /**
     * Gets the value of the squareOfConstruction property.
     */
    public double getSquareOfConstruction() {
        if (squareOfConstruction == 0)
            squareOfConstruction = perimeter * height;
        return squareOfConstruction;
    }

    /**
     * Sets the value of the squareOfConstruction property.
     */
    public void setSquareOfConstruction(double value) {
        this.squareOfConstruction = value;
    }

}
