package by.pvt.predkel.utils.rounding;

import by.pvt.predkel.entities.Aperture;
import by.pvt.predkel.entities.Building;
import by.pvt.predkel.entities.Room;

import static by.pvt.predkel.utils.rounding.Rounding.myRound;

public class RoundBuilding {
    public void roundBuilding(Building building) {
        for (Room temp : building.getRoom()) {
            for (Aperture aperture : temp.getAperture()) {
                aperture.setHeight(myRound(aperture.getHeight()));
                aperture.setWidth(myRound(aperture.getWidth()));
                aperture.setSquareOfAperture(myRound(aperture.getSquareOfAperture()));
            }
            temp.getCommonParameters().setHeight(myRound(temp.getCommonParameters().getHeight()));
            temp.getCommonParameters().setPerimeter(myRound(temp.getCommonParameters().getPerimeter()));
            temp.getCommonParameters().setSquare(myRound(temp.getCommonParameters().getSquare()));
            temp.getCommonParameters().setSquareOfConstruction(myRound(temp.getCommonParameters().getSquareOfConstruction()));
            temp.getCommonParameters().setVolume(myRound(temp.getCommonParameters().getVolume()));

            temp.getDetermineTheTypeOfFire().setAverageAmountOfCombustionAir(
                    myRound(temp.getDetermineTheTypeOfFire().getAverageAmountOfCombustionAir()));
            temp.getDetermineTheTypeOfFire().setProemnostOfRoom(
                    myRound(temp.getDetermineTheTypeOfFire().getProemnostOfRoom()));
            temp.getDetermineTheTypeOfFire().setSpecificCriticalAmountOfFireLoad(
                    myRound(temp.getDetermineTheTypeOfFire().getSpecificCriticalAmountOfFireLoad()));
            temp.getDetermineTheTypeOfFire().setSpecificValueOfFireLoad(
                    myRound(temp.getDetermineTheTypeOfFire().getSpecificValueOfFireLoad()));

            temp.getIntegratedThermalAndTechnicalParameters().setAverageMaximumTemperatureOfSlab(
                    myRound(temp.getIntegratedThermalAndTechnicalParameters().getAverageMaximumTemperatureOfSlab()));
            temp.getIntegratedThermalAndTechnicalParameters().setDurationOfFireSurround(
                    myRound(temp.getIntegratedThermalAndTechnicalParameters().getDurationOfFireSurround()));
            temp.getIntegratedThermalAndTechnicalParameters().setMaximumAverageTemperatureOfWallSurface(
                    myRound(temp.getIntegratedThermalAndTechnicalParameters().getMaximumAverageTemperatureOfWallSurface()));
            temp.getIntegratedThermalAndTechnicalParameters().setMaximumMeanBulkTemperature(
                    myRound(temp.getIntegratedThermalAndTechnicalParameters().getMaximumMeanBulkTemperature()));
            temp.getIntegratedThermalAndTechnicalParameters().setTimeReachMaximumMeanBulkTemperature(
                    myRound(temp.getIntegratedThermalAndTechnicalParameters().getTimeReachMaximumMeanBulkTemperature()));
            temp.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfSlabSurface(
                    myRound(temp.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfSlabSurface()));
            temp.getIntegratedThermalAndTechnicalParameters().setTimeToReachMaximumTemperatureOfWallSurface(
                    myRound(temp.getIntegratedThermalAndTechnicalParameters().getTimeToReachMaximumTemperatureOfWallSurface()));

//            temp.getParametersCalculatedFireLoad().setCoefficientA(
//                    myRound(temp.getParametersCalculatedFireLoad().getCoefficientA()));
            temp.getParametersCalculatedFireLoad().setCoefficientB(
                    myRound(temp.getParametersCalculatedFireLoad().getCoefficientB()));
            temp.getParametersCalculatedFireLoad().setCoefficientK(
                    myRound(temp.getParametersCalculatedFireLoad().getCoefficientK()));
            temp.getParametersCalculatedFireLoad().setCoefficientS(
                    myRound(temp.getParametersCalculatedFireLoad().getCoefficientS()));
            temp.getParametersCalculatedFireLoad().setEstimatedFireLoad(
                    myRound(temp.getParametersCalculatedFireLoad().getEstimatedFireLoad()));
            temp.getParametersCalculatedFireLoad().setGeneralSquareOfApertures(
                    myRound(temp.getParametersCalculatedFireLoad().getGeneralSquareOfApertures()));
            temp.getParametersCalculatedFireLoad().setReducedHeightOfApertures(
                    myRound(temp.getParametersCalculatedFireLoad().getReducedHeightOfApertures()));
            temp.getParametersCalculatedFireLoad().setSpecificFireLoad(
                    myRound(temp.getParametersCalculatedFireLoad().getSpecificFireLoad()));
            temp.getParametersCalculatedFireLoad().setSpecificFireLoadZVEZDOCHKA(
                    myRound(temp.getParametersCalculatedFireLoad().getSpecificFireLoadZVEZDOCHKA()));
            temp.getParametersCalculatedFireLoad().setVentilationParameter(
                    myRound(temp.getParametersCalculatedFireLoad().getVentilationParameter()));

            for (Double change : temp.getChangeInMeanBulkTemperature()) {
                change = myRound(change);
            }
            for (Double change : temp.getChangeInTemperatureOfSlab()) {
                change = myRound(change);
            }
            for (Double change : temp.getChangeInTemperatureOfWalls()) {
                change = myRound(change);
            }
        }
    }
}
