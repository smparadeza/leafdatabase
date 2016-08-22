<%@ include file="header.jsp" %>
<div>
    <div class="container">
        <div class="row">
            <h4>Total species : ${leaves.size()}</h4>
            <h5>Total number of compound  leaf images : ${totalImages}</h5>
            <h5>Average : ${average} leaf image per species</h5>
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <c:forEach var="name" items="${leaves}" varStatus="ctr">
                    <div class="panel panel-default">
                        <div class="panel-heading leaf" role="tab" id="headingOne" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse-${ctr.index}" aria-expanded="true" aria-controls="collapseOne">
                            <h4 class="panel-title">
                                <a class="leafName" >
                                        ${name}
                                </a>
                                <span class="pull-right">Image count : ${imgCounts.get(ctr.index)}</span>
                            </h4>
                        </div>
                        <div id="collapse-${ctr.index}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                            <div class="panel-body leaf-images" style="max-height: 500px; overflow:scroll;">
                            </div>
                        </div>
                    </div>


                </c:forEach>

            </div>

        </div>
    </div>
</div>
<script>
    $(document).ready(function(){
        $(" .leaf").click(function(){
            var leafName = $(this).find($("a")).text().trim();
//            alert($(this).find($("a")).text().trim());
            var div =$(this).parents(".panel").find($("div.panel-body"));
            $.ajax({
                type: "POST",
                async: true,
                url: "${baseURL}/leaf/compound/images",
                contentType: "application/json",
                data: JSON.stringify({leafName: leafName}),
                success: function (result) {
                    $(div).html(result);
                    $(".leaf").removeClass("leaf");
                },
            });

        });
//        $(".leaf").trigger("click");
    });
</script>

<%@include file="footer.jsp" %>