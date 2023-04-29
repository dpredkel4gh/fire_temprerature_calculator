<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="error" class="java.lang.String" scope="request"/>
<jsp:useBean id="substances" class="java.util.ArrayList" scope="request"/>
<s:message var="room" code="calculate.room"/>
<script>
    //    $('#amountOfRooms').keypress(function(eventObject){
    //    alert('Вы ввели символ с клавиатуры. Его код равен ' + eventObject.which);
    //});
    //    function spoiler() {
    <%--var str = document.getElementById('amountOfRooms').value;--%>
    <%--if (str.length > 2)--%>
    <%--return false;--%>
    <%--var str1 = "";--%>
    <%--var str2 = "";--%>
    <%--var file = document.getElementById('data').innerHTML;--%>
    <%--var k = 0;--%>
    <%--for (var i = 0; i < parseInt(str); i++) {--%>
    <%--k++;--%>
    <%--str1 += '<div class="tab-pane fade" id="tab-' + i + '" >' + file + '</div>';--%>
    <%--str2 += '<li><a href="#tab-' + i + '" data-toggle="tab">${room} ' + k + '</a></li>';--%>
    <%--}--%>
    <%--document.getElementById('Vkladka').innerHTML = str2;--%>
    <%--document.getElementById('Content').innerHTML = str1;--%>
    //    }
</script>
<s:url value="/client/count" var="formUrl"/>
<form action="${formUrl}" method="post" novalidate="">
    <div class="container">
        <div class="row">
            <div class="col-md-2">

            </div>
            <div class="col-md-8">
                <h3>${error}</h3>
            </div>
            <div class="col-md-2">

            </div>
        </div>
        <div class="row">
            <div class="col-md-12">

                <div class="form-group">
                    <label>
                        <s:message var="buildingName" code="calculate.building.name"/>
                        ${buildingName}
                    </label>
                    <input name="nameOfBuilding" class="form-control" placeholder="${buildingName}"/>
                </div>

                <div class="form-group">
                    <label>
                        <s:message var="region" code="calculate.building.region"/>
                        ${region}
                    </label>
                    <select name="selectedTemperatureOfRegion" class="selectpicker form-control select-lg">
                        <option id="Brest" value="35"><s:message code="calculate.building.brest"/></option>
                        <option id="Vitebsk" value="35"><s:message code="calculate.building.vitebsk"/></option>
                        <option id="Grodno" value="35"><s:message code="calculate.building.grodno"/></option>
                        <option id="Gomel" value="35"><s:message code="calculate.building.gomel"/></option>
                        <option id="Minsk" value="35"><s:message code="calculate.building.minsk"/></option>
                        <option id="Mogilev" value="35"><s:message code="calculate.building.mogilev"/></option>
                    </select>
                </div>

                <label>
                    <s:message var="coefficientBuild" code="calculate.building.coefficient"/>
                    ${coefficientBuild}
                </label>
                <div class="form-group">

                    <s:message var="s2" code="calculate.building.s2"/>
                    <select name="s2" class="selectpicker form-control select-lg">
                        <optgroup label="${s2}"/>
                        <option value="1.5"><s:message code="calculate.building.s2.1"/></option>
                        <option value="0.87"><s:message code="calculate.building.s2.2"/></option>
                        <option value="0.8"><s:message code="calculate.building.s2.3"/></option>
                        <option value="0.7"><s:message code="calculate.building.s2.4"/></option>
                    </select>

                    <s:message var="s3" code="calculate.building.s3"/>
                    <select name="s3" class="selectpicker form-control select-lg">
                        <optgroup label="${s3}"/>
                        <option value="1.5"><s:message code="calculate.building.s3.1"/></option>
                        <option value="0.9"><s:message code="calculate.building.s3.2"/></option>
                        <option value="0.8"><s:message code="calculate.building.s3.3"/></option>
                    </select>

                    <s:message var="s5" code="calculate.building.s5"/>
                    <select name="s5" class="selectpicker form-control select-lg">
                        <optgroup label="${s5}"/>
                        <option value="0.61"><s:message code="calculate.building.s5.1"/></option>
                        <option value="0.78"><s:message code="calculate.building.s5.2"/></option>
                        <option value="1.0"><s:message code="calculate.building.s5.3"/></option>
                        <option value="1.5"><s:message code="calculate.building.s5.4"/></option>
                        <option value="0.5"><s:message code="calculate.building.s5.5"/></option>
                    </select>

                    <s:message var="s6" code="calculate.building.s6"/>
                    <select name="s6" class="selectpicker form-control select-lg">
                        <optgroup label="${s6}"/>
                        <option value="1.0"><s:message code="calculate.building.s6.1"/></option>
                        <option value="0.9"><s:message code="calculate.building.s6.2"/></option>
                    </select>
                </div>

                <div class="form-group">
                    <s:message var="coefficient5" code="calculate.building.coefficient5"/>
                    <label>
                        ${coefficient5}
                    </label>
                    <input name="specifyingCoefficientS5" class="form-control float" type="number"
                           placeholder="${coefficient5}" value="1"/>
                </div>

                <div class="form-group" id="amount">
                    <s:message var="amountOfRoom" code="calculate.building.amountOfRoom"/>
                    <label>
                        ${amountOfRoom}
                    </label>
                    <input id="previousAmountOfRooms" style="display: none" value="1"/>
                    <input name="amountOfRooms" id="amountOfRooms" class="form-control num" type="number"
                           value="1" placeholder="${amountOfRoom}"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="tabs">
                    <ul class="nav nav-tabs" id="Vkladka">
                        <li><a href="#tab-1" data-toggle="tab">${room} 1</a></li>
                        <!--<li><a href="#tab-2" data-toggle="tab">Вкладка 2</a></li>-->
                    </ul>
                    <div class="tab-content" id="Content">

                        <div class="tab-pane fade" id="tab-1">
                            <div class="form-group">
                                <s:message var="position" code="calculate.room.position"/>
                                <s:message var="name" code="calculate.room.name"/>
                                <s:message var="square" code="calculate.room.square"/>
                                <s:message var="height" code="calculate.room.height"/>
                                <s:message var="perimeter" code="calculate.room.perimeter"/>
                                <s:message var="volume" code="calculate.room.volume"/>
                                <s:message var="squareOfWall" code="calculate.room.squareOfWall"/>

                                <input name="positionOfRoom" class="form-control" placeholder="${position}"/>
                                <input name="nameOfRoom" class="form-control" placeholder="${name}"/>
                                <input name="squareOfRoom" class="form-control float" placeholder="${square}"/>
                                <input name="heightOfRoom" class="form-control float" placeholder="${height}"/>
                                <input name="perimeterOfRoom" class="form-control float" placeholder="${perimeter}"/>
                                <input name="volumeOfRoom" class="form-control float" placeholder="${volume}"/>
                                <input name="squareOfConstruction" class="form-control float"
                                       placeholder="${squareOfWall}"/>
                            </div>
                            <div class="row">
                                <c:forEach var="k" begin="0" end="1">
                                    <div class="col-md-6">
                                        <c:forEach var="i" begin="1" end="3">
                                            <div class="form-group">
                                                <label><s:message code="calculate.aperture.aper"/> ${i+k*3}</label>
                                                <div class="parametersOfAperture">

                                                    <s:message var="aperture" code="calculate.aperture"/>
                                                    <s:message var="apertureWidth" code="calculate.aperture.width"/>
                                                    <s:message var="apertureHeight"
                                                               code="calculate.aperture.height"/>
                                                    <s:message var="apertureAmount"
                                                               code="calculate.aperture.amount"/>
                                                    <s:message var="apertureSquare"
                                                               code="calculate.aperture.square"/>

                                                    <input name="typeOfAperture" class="form-control"
                                                           placeholder="${aperture}"/>
                                                    <input name="widthOfAperture" class="form-control float"
                                                           placeholder="${apertureWidth}"/>
                                                    <input name="heightOfAperture" class="form-control float"
                                                           placeholder="${apertureHeight}"/>
                                                    <input name="countOfAperture" class="form-control num"
                                                           placeholder="${apertureAmount}"/>
                                                    <input name="squareOfAperture" class="form-control float"
                                                           placeholder="${apertureSquare}"/>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="form-group">
                                <label><s:message code="calculate.room.coefficient"/></label>

                                <s:message var="s1" code="calculate.room.s1"/>
                                <s:message var="s15" code="calculate.room.s1.5"/>
                                <select name="s1" class="selectpicker form-control select-lg">
                                    <optgroup label="${s1}"/>
                                    <option value="0.59"><s:message code="calculate.room.s1.1"/></option>
                                    <option value="0.57"><s:message code="calculate.room.s1.2"/></option>
                                    <option value="0.59"><s:message code="calculate.room.s1.3"/></option>
                                    <option value="1.0"><s:message code="calculate.room.s1.4"/></option>
                                    <optgroup label="${s15}"/>
                                    <option value="0.63"><s:message code="calculate.room.s1.6"/></option>
                                    <option value="0.61"><s:message code="calculate.room.s1.7"/></option>
                                </select>

                                <s:message var="s4" code="calculate.room.s4"/>
                                <select name="s4" class="selectpicker form-control select-lg">
                                    <optgroup label="${s4}"/>
                                    <option value="1.5"><s:message code="calculate.room.s4.1"/></option>
                                    <option value="0.73"><s:message code="calculate.room.s4.2"/></option>
                                    <option value="0.87"><s:message code="calculate.room.s4.3"/></option>
                                    <!--<option value=""><s:message code="calculate.room.s4.4"/></option> -->
                                    <option value="1.0"><s:message code="calculate.room.s4.5"/></option>
                                </select>

                                <s:message var="s7" code="calculate.room.s7"/>
                                <select name="s7" class="selectpicker form-control select-lg">
                                    <optgroup label="${s7}"/>
                                    <option value="1"><s:message code="calculate.room.s7.1"/></option>
                                    <option value="0.9"><s:message code="calculate.room.s7.2"/></option>
                                </select>

                                <s:message var="s8" code="calculate.room.s8"/>
                                <select name="s8" class="selectpicker form-control select-lg">
                                    <optgroup label="${s8}"/>
                                    <option value="1"><s:message code="calculate.room.s8.1"/></option>
                                    <option value="0.9"><s:message code="calculate.room.s8.2"/></option>
                                </select>

                                <s:message var="s9" code="calculate.room.s9"/>
                                <select name="s9" class="selectpicker form-control select-lg">
                                    <optgroup label="${s9}"/>
                                    <option value="1.5"><s:message code="calculate.room.s9.1"/></option>
                                    <option value="1.0"><s:message code="calculate.room.s9.2"/></option>
                                </select>

                                <s:message var="s10" code="calculate.room.s10"/>
                                <select name="s10" class="selectpicker form-control select-lg">
                                    <optgroup label="${s10}"/>
                                    <option value="0.9"><s:message code="calculate.room.s10.1"/></option>
                                    <option value="1.0"><s:message code="calculate.room.s10.2"/></option>
                                </select>
                            </div>
                            <div class="row">
                                <s:message var="material" code="calculate.material.mat"/>
                                <s:message var="typeOfMaterial" code="calculate.material"/>
                                <s:message var="weightOfMaterial" code="calculate.material.weight"/>
                                <c:forEach var="k" begin="0" end="1">
                                    <div class="col-md-6">
                                        <c:forEach var="i" begin="1" end="3">
                                            <div class="form-group">
                                                <label>${material} ${i+k*3}</label>
                                                <select name="idOfSubstance"
                                                        class="selectpicker form-control select-lg">
                                                    <optgroup label="${typeOfMaterial}"/>
                                                    <c:forEach items="${substances}" var="substance">
                                                        <option value="${substance.id}">${substance.nameOfSubstance}</option>
                                                    </c:forEach>
                                                </select>
                                                <input name="weight" class="form-control float"
                                                       placeholder="${weightOfMaterial}"/>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </c:forEach>
                            </div>
                            <s:message var="specificFireLoad" code="calculate.room.specificFireLoad"/>
                            <div class="form-group">
                                <label>${specificFireLoad}</label>
                                <input name="specificFireLoadZVEZDOCHKA" class="form-control float"
                                       placeholder="${specificFireLoad}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <s:message var="send" code="calculate.send"/>
                    <input class="btn btn-primary btn-block" value="${send}" type="submit" onclick="calculateValid()"/>
                </div>
            </div>
        </div>
    </div>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>

</form>
<script>
    var file = document.getElementById('tab-1').innerHTML;
    $('#amountOfRooms').change(function () {

        var checker = parseInt(document.getElementById('previousAmountOfRooms').value);
        var value = parseInt(document.getElementById('amountOfRooms').value);

        if (value < 1 ||
                value > 99 ||
                isNaN(value)    //if input is empty
        ) {
            document.getElementById('amountOfRooms').value = checker;
            return false;
        }

        if (value > checker) {
            var str1 = "";
            var str2 = "";

            for (var i = checker + 1; i < parseInt(value) + 1; i++) {
                str1 = '<div class="tab-pane fade" id="tab-' + i + '" >' + file + '</div>';
                str2 = '<li class="link"><a href="#tab-' + i + '" data-toggle="tab">${room} ' + i + '</a></li>';
                $("#Content").append(str1);
                $("#Vkladka").append(str2);
            }
            document.getElementById('previousAmountOfRooms').value = value;
        }

        if (value < checker) {
            var raznica = checker - value;
            for (var k = 0; k < raznica; k++) {
                $("li.link").remove(":last-child");
                $("div.tab-pane").remove(":last-child");
            }
            document.getElementById('previousAmountOfRooms').value = value;
        }

    });
</script>