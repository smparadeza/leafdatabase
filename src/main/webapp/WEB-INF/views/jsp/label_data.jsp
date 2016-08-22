


<%@include file="header.jsp"%>

<div>
    <div class="container">

        <div class="row col-md-4 center-block" style="float:none;">
            <div class="btn-group btn-group-justified" role="group" data-toggle="buttons">
                <a id="prev-leaf" type="button" class="btn btn-default btn-block"><span
                        class="glyphicon glyphicon-arrow-left"> </span>
                    Previous</a>
                <a id="next-leaf" type="button" class="btn btn-default btn-block">Next <span
                        class="glyphicon glyphicon-arrow-right"></a>
            </div>
        </div>

    </div>
    <br/>

    <div id="view-leaf-div" class="container">

    </div>
</div>
<script>
    var getUrlParameter = function getUrlParameter(sParam) {
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
                sURLVariables = sPageURL.split('&'),
                sParameterName,
                i;

        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');

            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    };



    $(document).ready(function () {
        <%--alert("${baseURL}/leaf/get_unlabeled");--%>
        <%--$.get("${baseURL}/leaf/get_unlabeled", function(data){--%>
        <%--alert(JSON.stringify(data));--%>
        <%--});--%>
        start = getUrlParameter("startId");
        if(start == undefined){
            $("#view-leaf-div").load("${baseURL}/leaf/get_unlabeled");
        }
        else{
            $("#view-leaf-div").load("${baseURL}/leaf/get_unlabeled/" + start);
        }
        $("#next-leaf").click(function () {
            $.ajax({
                type: "POST",
                async: true,
                url: "${baseURL}/leaf/get_next",
                contentType: "application/json",
                data: JSON.stringify({leafId: $(".leaf").attr("id")}),
                success: function (result) {
                    $("#view-leaf-div").html(result);
                    $("#next-leaf").removeClass("active");
                },
            });
            <%--$("#view-leaf-div").load("${baseURL}/leaf/get_next", {leafId : $(".leaf").attr("id")}, function(){--%>

            <%--});--%>
        });
        $("#prev-leaf").click(function () {
            $.ajax({
                type: "POST",
                async: true,
                url: "${baseURL}/leaf/get_previous",
                contentType: "application/json",
                data: JSON.stringify({"leafId": $(".leaf").attr("id")}),
                success: function (result) {
                    $("#view-leaf-div").html(result);
                    $("#prev-leaf").removeClass("active");
                },
            });
            <%--$("#view-leaf-div").load("${baseURL}/leaf/get_next", {leafId : $(".leaf").attr("id")}, function(){--%>

            <%--});--%>
        });

        $(document).bind('keyup', function(e) {
            if(e.keyCode==87){ //w
                $("#compound").trigger("click");
            }
            else if(e.keyCode==83){ //s
                $("#simple").trigger("click");
            }
            else if(e.keyCode==65){ //a
                $("#prev-leaf").trigger("click");
            }
            else if(e.keyCode==68){ //d
                $("#next-leaf").trigger("click");
            }
        });
    });

</script>
<%@include file="footer.jsp"%>