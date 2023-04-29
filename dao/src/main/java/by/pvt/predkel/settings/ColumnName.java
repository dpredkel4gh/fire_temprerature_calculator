package by.pvt.predkel.settings;

public class ColumnName {

    public static final String USER_ID = "id.user";
    public static final String USER_LOGIN = "login";
    public static final String USER_PASSWORD = "password";
    public static final String USER_ADMIN = "admin";

    public static final String BUILDING_ID = "id.building";
    public static final String BUILDING_NAME = "nameOfBuilding";
    public static final String BUILDING_TEMPERATURE = "selectedTemperatureOfRegion";
    public static final String BUILDING_DATE = "dateofbuilding";
    public static final String BUILDING_FK_ID_USER = "userId";
    public static final String BUILDING_COEFFICIENT_C5 = "specifyingCoefficientS5";

    public static final String COEFFICIENTS_FOR_BUILDING_FKID = "fk.id.building";
    public static final String COEFFICIENTS_FOR_BUILDING_ID = "id.coefficientSForBuilding";
    public static final String COEFFICIENTS_FOR_BUILDING_S2 = "s2";
    public static final String COEFFICIENTS_FOR_BUILDING_S3 = "s3";
    public static final String COEFFICIENTS_FOR_BUILDING_S5 = "s5";
    public static final String COEFFICIENTS_FOR_BUILDING_S6 = "s6";

    public static final String ROOM_ID = "id.room";
    public static final String ROOM_POSITION = "positionOfRoom";
    public static final String ROOM_NAME = "nameOfRoom";
    public static final String ROOM_SQUARE = "square";
    public static final String ROOM_HEIGHT = "height";
    public static final String ROOM_PERIMETER = "perimeter";
    public static final String ROOM_SquareOfConstruction = "squareOfConstruction";
    public static final String ROOM_SpecificFireLoad = "specificFireLoad";
    public static final String ROOM_SpecificFireLoadZVEZDOCHKA = "specificFireLoadZVEZDOCHKA";
    public static final String ROOM_ReducedHeightOfApertures = "reducedHeightOfApertures";
    public static final String ROOM_GeneralSquareOfApertures = "generalSquareOfApertures";
    public static final String ROOM_VentilationParameter = "ventilationParameter";
    public static final String ROOM_CoefficientK = "coefficientK";
    public static final String ROOM_CoefficientA = "coefficientA";
    public static final String ROOM_CoefficientB = "coefficientB";
    public static final String ROOM_CoefficientS = "coefficientS";
    public static final String ROOM_EstimatedFireLoad = "estimatedFireLoad";
    public static final String ROOM_ProemnostOfRoom = "proemnostOfRoom";
    public static final String ROOM_AverageAmountOfCombustionAir = "averageAmountOfCombustionAir";
    public static final String ROOM_SpecificCriticalAmountOfFireLoad = "specificCriticalAmountOfFireLoad";
    public static final String ROOM_SpecificValueOfFireLoad = "specificValueOfFireLoad";
    public static final String ROOM_PRN = "PRN";
    public static final String ROOM_MaximumMeanBulkTemperature = "maximumMeanBulkTemperature";
    public static final String ROOM_DurationOfFireSurround = "durationOfFireSurround";
    public static final String ROOM_TimeReachMaximumMeanBulkTemperature = "timeReachMaximumMeanBulkTemperature";
    public static final String ROOM_MaximumAverageTemperatureOfWallSurface = "maximumAverageTemperatureOfWallSurface";
    public static final String ROOM_TimeToReachMaximumTemperatureOfWallSurface = "timeToReachMaximumTemperatureOfWallSurface";
    public static final String ROOM_AverageMaximumTemperatureOfSlab = "averageMaximumTemperatureOfSlab";
    public static final String ROOM_TimeToReachMaximumTemperatureOfSlabSurface = "timeToReachMaximumTemperatureOfSlabSurface";
    public static final String ROOM_FkIdBuilding = "fk.id.building";

    public static final String COEFFICIENTS_FOR_ROOM_FKID = "fk.id.room";
    public static final String COEFFICIENTS_FOR_ROOM_ID = "id.coefficientsforroom";
    public static final String COEFFICIENTS_FOR_ROOM_S1 = "s1";
    public static final String COEFFICIENTS_FOR_ROOM_S4 = "s4";
    public static final String COEFFICIENTS_FOR_ROOM_S7 = "s7";
    public static final String COEFFICIENTS_FOR_ROOM_S8 = "s8";
    public static final String COEFFICIENTS_FOR_ROOM_S9 = "s9";
    public static final String COEFFICIENTS_FOR_ROOM_S10 = "s10";

    public static final String APERTURE_ID = "id.aperture";
    public static final String APERTURE_FKID = "fk.id.room";
    public static final String APERTURE_TYPE_OF_APERTURE = "typeOfAperture";
    public static final String APERTURE_HEIGHT = "height";
    public static final String APERTURE_WIDTH = "width";
    public static final String APERTURE_SQUARE = "squareOfAperture";
    public static final String APERTURE_COUNT = "count";

    public static final String FLAMMABLE_SUBSTANCE_ID = "id.substance";
    public static final String FLAMMABLE_SUBSTANCE_NAME = "nameOfSubstance";
    public static final String FLAMMABLE_SUBSTANCE_AMOUNT_OF_Combustion_Air = "amountOfCombustionAir";
    public static final String FLAMMABLE_SUBSTANCE_Average_Speed_Burnout = "averageSpeedBurnout";
    public static final String FLAMMABLE_SUBSTANCE_Combustion_Heat = "combustionHeat";

    public static final String SUBSTANCES_OF_ROOM_ID = "id.substancesOfRoom";
    public static final String SUBSTANCES_OF_ROOM_FK_ID_ROOM = "fk.id.room";
    public static final String SUBSTANCES_OF_ROOM_FK_ID_SUBSTANCE = "fk.id.substance";
    public static final String SUBSTANCES_OF_ROOM_WEIGHT = "weight";

    public static final String ChangeInMeanBulkTemperature_ID = "id.changeinmeanbulktemperature";
    public static final String ChangeInMeanBulkTemperature_FK_ID_ROOM = "fk.id.room";
    public static final String ChangeInMeanBulkTemperature_FIELD = "changes";

    public static final String ChangeInTemperatureOfSlab_ID = "id.changeintemperatureofslab";
    public static final String ChangeInTemperatureOfSlab_FK_ID_ROOM = "fk.id.room";
    public static final String ChangeInTemperatureOfSlab_FIELD = "changes";

    public static final String ChangeInTemperatureOfWalls_ID = "id.changeintemperatureofwalls";
    public static final String ChangeInTemperatureOfWalls_FK_ID_ROOM = "date";
    public static final String ChangeInTemperatureOfWalls_FIELD = "fk.id.room";

    private ColumnName() {
    }
}
