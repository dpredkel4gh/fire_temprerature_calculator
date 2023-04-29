<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>

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
        <s:message var="name" code="history.name"/>
        <s:message var="date" code="history.date"/>
        <s:message var="action" code="history.action"/>
        <div class="col-md-4"><b>${name}</b></div>
        <div class="col-md-4"><b>${date}</b></div>
        <div class="col-md-4"><b>${action}</b></div>
    </div>

    <br/>
    <c:forEach items="${buildings}" var="build">
        <div class="row">
            <s:url value="/client/history/edit" var="formUrl"/>
            <form action="${formUrl}" method="post">
                <input type="hidden" name="idBuilding" value="${build.id}"/>
                <div class="col-md-4">
                    <div class="form-group">
                        <input type="text" class="form-control" value="${build.nameOfBuilding}" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <input type="text" class="form-control" value="${build.dateOfBuilding}" readonly="readonly"/>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="btn-group">
                        <s:message var="choose" code="history.choose"/>
                        <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                ${choose}
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <s:message var="save" code="history.save"/>
                                <button value="save" name="buildingAction" class="btn btn-default" type="submit">
                                        ${save}
                                </button>
                            </li>
                            <li>
                                <s:message var="delete" code="history.delete"/>
                                <button value="delete" name="buildingAction" class="btn btn-default" type="submit">
                                        ${delete}
                                </button>
                            </li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </c:forEach>
</div>