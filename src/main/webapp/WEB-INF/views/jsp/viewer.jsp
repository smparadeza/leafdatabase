<%--
  Created by IntelliJ IDEA.
  User: smparadeza
  Date: 8/25/15
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:choose>
    <c:when test="${leaf == null}">
        NO LEAF TO LABEL
    </c:when>
    <c:otherwise>
        <div id="${leaf.id}" class="leaf">
            <div class="row col-md-4 center-block" style="float:none;">
                <div class="btn-group btn-group-justified" role="group" data-toggle="buttons">
                    <a id="simple" type="button"
                       class="btn btn-default btn-block <c:if test="${leaf.isCompound != null && leaf.isCompound == false}"> active btn-info </c:if> ">Simple
                        <span class="glyphicon glyphicon-leaf"></span></a>
                    <a id="compound" type="button"
                       class="btn btn-default btn-block <c:if test="${leaf.isCompound == true}"> active btn-info </c:if>">Compound
                        <span class="glyphicon glyphicon-grain"></span></a>
                </div>
            </div>
            <br>
            <br>

            <div class="container col-xs-10 center-block" style="float:none;">

                <div class="row">
                    <div class="col-xs-5 ">
                        <img id="leaf_image" src="/resources/images/leaves/${leaf.filename}" rel="popover" data-content="Hello" title="Popover with image">

                    </div>
                    <div class="col-xs-7">
                        <u>[${leaf.id}]<strong><mark>${leaf.vernacularName}</mark></strong></u>
                        <br/>
                        Type : <mark>${leaf.type}</mark>
                        <br/>
                        Content : <mark>${leaf.content}</mark>
                    </div>
                </div>
            </div>
        </div>
        <script>



            $(document).ready(function(){
                $("#compound").click(function () {
                    $.ajax({
                        type: "POST",
                        async: true,
                        url: "${baseURL}/leaf/mark_as_compound",
                        contentType: "application/json",
                        data: JSON.stringify({leafId: $(".leaf").attr("id")}),
                        success: function (result) {
                            $("#compound").addClass("active btn-info");
                            $("#simple").removeClass("active btn-info");
                            $("#next-leaf").trigger("click");
                        },
                    });
                    <%--$("#view-leaf-div").load("${baseURL}/leaf/get_next", {leafId : $(".leaf").attr("id")}, function(){--%>

                    <%--});--%>
                });

                $("#simple").click(function () {
                    $.ajax({
                        type: "POST",
                        async: true,
                        url: "${baseURL}/leaf/mark_as_simple",
                        contentType: "application/json",
                        data: JSON.stringify({leafId: $(".leaf").attr("id")}),
                        success: function (result) {
                            $("#simple").addClass("active btn-info");
                            $("#compound").removeClass("active btn-info");
                            $("#next-leaf").trigger("click");
                        },
                    });
                    <%--$("#view-leaf-div").load("${baseURL}/leaf/get_next", {leafId : $(".leaf").attr("id")}, function(){--%>

                    <%--});--%>
                });

            });

        </script>
    </c:otherwise>

</c:choose>
