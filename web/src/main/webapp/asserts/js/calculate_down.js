$('.float').keypress(function (e) {
    if ((e.keyCode < 48 || e.keyCode > 57) && e.keyCode != 46) {
        return false;
    }
});
$('.num').keypress(function (e) {
    if (e.keyCode < 48 || e.keyCode > 57) {
        return false;
    }
});
var checker;
function calculateValid() {
    var amountOfApertures = 6;
    var amountOfSubstances = 6;

    var currentAmountOfApertures = 0;
    var currentAmountOfSubstances = 0;

    checker = true;

    var nameOfBuilding = document.getElementsByName('nameOfBuilding')[0];

    checkStringInput([nameOfBuilding]);

    var selectedTemperatureOfRegion = parseFloat(document.getElementsByName('selectedTemperatureOfRegion')[0].value);
    var s2 = parseFloat(document.getElementsByName('s2')[0].value);
    var s3 = parseFloat(document.getElementsByName('s3')[0].value);
    var s5 = parseFloat(document.getElementsByName('s5')[0].value);
    var s6 = parseFloat(document.getElementsByName('s6')[0].value);
    var buildingCoefficientS = [s2, s3, s5, s6];

    var specifyingCoefficientS5 = document.getElementsByName('specifyingCoefficientS5')[0];
    checkFloatInput([specifyingCoefficientS5]);

    var amountOfRooms = document.getElementById('amountOfRooms');
    checkIntInput([amountOfRooms]);

    var rooms = [];

    for (var i = 0; i < amountOfRooms.value; i++) {
        var positionOfRoom = document.getElementsByName('positionOfRoom')[i];
        var nameOfRoom = document.getElementsByName('nameOfRoom')[i];
        var elements = [positionOfRoom, nameOfRoom];
        checkStringInput(elements);

        var square = document.getElementsByName('squareOfRoom')[i];
        var heightR = document.getElementsByName('heightOfRoom')[i];
        var perimeter = document.getElementsByName('perimeterOfRoom')[i];

        elements = [square, heightR, perimeter];
        checkFloatInput(elements);

        var volume = parseFloat(document.getElementsByName('volumeOfRoom')[i].value);
        var squareOfConstruction = parseFloat(document.getElementsByName('squareOfConstruction')[i].value);

        ///////auto calculating\\\\\\\
        if (isNaN(volume))
            volume = 0;
        if (isNaN(squareOfConstruction))
            squareOfConstruction = 0;

        var s1 = parseFloat(document.getElementsByName('s1')[i].value);
        var s4 = parseFloat(document.getElementsByName('s4')[i].value);
        var s7 = parseFloat(document.getElementsByName('s7')[i].value);
        var s8 = parseFloat(document.getElementsByName('s8')[i].value);
        var s9 = parseFloat(document.getElementsByName('s9')[i].value);
        var s10 = parseFloat(document.getElementsByName('s10')[i].value);
        var roomCoefficientS = [s1, s4, s7, s8, s9, s10];

        var apertures = [];
        var substances = [];
        for (var k = 0; k < amountOfApertures; k++) {
            var typeOfAperture = document.getElementsByName('typeOfAperture')[currentAmountOfApertures].value;
            if (typeOfAperture == "") {
                currentAmountOfApertures++;
                continue;
            }
            var width = document.getElementsByName('widthOfAperture')[currentAmountOfApertures];
            var height = document.getElementsByName('heightOfAperture')[currentAmountOfApertures];
            var count = document.getElementsByName('countOfAperture')[currentAmountOfApertures];
            elements = [width, height];
            checkFloatInput(elements);
            checkIntInput([count]);

            var squareOfAperture = parseFloat(document.getElementsByName('squareOfAperture')[currentAmountOfApertures].value);

            ///////auto calculating\\\\\\\
            if (isNaN(squareOfAperture))
                squareOfAperture = 0;

            //creating the list of 'apertures'
            var aperture = {
                type: typeOfAperture,
                width: width.value,
                height: height.value,
                count: count.value,
                square: squareOfAperture
            };
            apertures.push(aperture);
            currentAmountOfApertures++;
        }

        if (apertures.length == 0) {
            //mark only the first aperture in room
            var one = document.getElementsByName('typeOfAperture')[currentAmountOfApertures - 6];
            var two = document.getElementsByName('widthOfAperture')[currentAmountOfApertures - 6];
            var three = document.getElementsByName('heightOfAperture')[currentAmountOfApertures - 6];
            var four = document.getElementsByName('countOfAperture')[currentAmountOfApertures - 6];
            checkStringInput([one]);
            elements = [two, three];
            checkFloatInput(elements);
            checkIntInput([four]);
        }

        for (var m = 0; m < amountOfSubstances; m++) {
            var weight = parseFloat(document.getElementsByName('weight')[currentAmountOfSubstances].value);
            if (isNaN(weight)) {
                currentAmountOfSubstances++;
                continue;
            }
            var idSubstance = parseInt(document.getElementsByName('idOfSubstance')[currentAmountOfSubstances].value);

            //creating the list of 'substances'
            var substance = {
                id: idSubstance,
                weight: weight
            };
            substances.push(substance);
            currentAmountOfSubstances++;
        }

        var zvezdochka = parseFloat(document.getElementsByName('specificFireLoadZVEZDOCHKA')[i].value);

        var sub = document.getElementsByName('weight')[currentAmountOfSubstances - 6];
        var star = document.getElementsByName('specificFireLoadZVEZDOCHKA')[i];
        resetError(star.parentNode);
        resetError(star.parentNode.parentNode);
        if (isNaN(zvezdochka) && substances.length == 0) {
            //mark only the first substance in room and specificFireLoad
            elements = [sub, star];
            checkFloatInput(elements);
            showError(star.parentNode, "Необходимо ввести либо один материал, либо удельную пожарную нагрузку");
            showError(star.parentNode.parentNode, "* Все выделенные поля должны быть заполнены");
        }

        if (isNaN(zvezdochka))
            zvezdochka = 0;

        if (!checker) {
            return false;
        }
        //creating the list of 'rooms'
        // var room={
        //     positionOfRoom:positionOfRoom,
        //     name:nameOfRoom,
        //     square:square,
        //     height:heightR,
        //     perimeter:perimeter,
        //     volume:volume,
        //     squareOfConstruction:squareOfConstruction,
        //     s:roomCoefficientS,
        //     apertures:apertures,
        //     substances:substances,
        //     zvezdochka:zvezdochka
        // };
        // rooms.push(room);
    }
    //creating the main object
    // var building={
    //     name:nameOfBuilding,
    //     selectedTemperatureOfRegion:selectedTemperatureOfRegion,
    //     s:buildingCoefficientS,
    //     specifyingCoefficientS5:specifyingCoefficientS5,
    //     amountOfRooms:amountOfRooms,
    //     rooms:rooms
    // };

    //send json to server #1
    // var str = JSON.stringify(building);
    // xhr = new XMLHttpRequest();
    // var url = "aj";
    // xhr.open("POST", url, false);
    // xhr.setRequestHeader("Content-type", "application/json");
    // xhr.send(str);

    //send json to server #2
    // $.ajax({
    //     type: "POST",
    //     url: "aj",
    //     datatype: 'json',
    //     data: str,
    //     success: function(data) {
    //         alert("success "+JSON.stringify(data));
    //     },
    //     error: function(err) {
    //         alert("error "+JSON.stringify(err));
    //     }
    // });
}
function validateSubstance() {

    checker = true;
    var amountOfSubstances = parseInt(document.getElementsByName('amountOfSubstances')[0].value);

    for (var i = 0; i < amountOfSubstances; i++) {
        var id = document.getElementsByName('idSubstance');
        var name = document.getElementsByName('nameOfSubstance');
        var amountOfCombustionAir = document.getElementsByName('amountOfCombustionAir');
        var combustionHeat = document.getElementsByName('combustionHeat');
        var averageSpeedBurnout = document.getElementsByName('averageSpeedBurnout');
        if (id.value = "") {
            if (name.value != "" || !isNaN(amountOfCombustionAir.value) || !isNaN(combustionHeat.value) || !isNaN(averageSpeedBurnout.value)) {
                checkStringInput([name]);
                checkFloatInput([amountOfCombustionAir, combustionHeat, averageSpeedBurnout])
            }
        } else {
            checkStringInput([name]);
            checkFloatInput([amountOfCombustionAir, combustionHeat, averageSpeedBurnout])
        }
    }
    if (!checker) {
        return false;
    }
}
function checkStringInput(arr) {
    arr.forEach(function (element, i, arr) {
        var elemVal = element.value.replace(/^\s+/, "").replace(/\s+$/, "");//delete spaces before and after text
        if (elemVal == "") {
            element.style.background = "pink";
            if (checker) {
                checker = false;
                event.preventDefault();
                scrollToElement(element);
            }
        } else {
            returnElementStyle(element);
            resetError(element.parentNode);
        }
    });
}
function checkFloatInput(arr) {
    arr.forEach(function (element, i, arr) {
        if (isNaN(parseFloat(element.value)) || element.value == 0) {
            element.style.background = "pink";
            if (checker) {
                checker = false;
                event.preventDefault();
                scrollToElement(element);
            }
        } else {
            returnElementStyle(element);
            resetError(element.parentNode);
        }
    });
}
function checkIntInput(arr) {
    arr.forEach(function (element, i, arr) {
        if (isNaN(parseInt(element.value)) || element.value == 0) {
            element.style.background = "pink";
            if (checker) {
                checker = false;
                event.preventDefault();
                scrollToElement(element);
            }
        } else {
            returnElementStyle(element);
            resetError(element.parentNode);
        }
    });
}
function returnElementStyle(element) {
    if (element.style.background == "pink")
        element.style.background = "#fff";
}
function scrollToElement(element) {
    var selectedPosX = 0;
    var selectedPosY = 0;

    while (element != null) {
        selectedPosX += element.offsetLeft;
        selectedPosY += element.offsetTop;
        element = element.offsetParent;
    }
    window.scrollTo(selectedPosX, selectedPosY - 100);
}