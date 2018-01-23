<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<section class="manageVendor">
    <div class="panel-heading">
        <h3 class="panel-title">Manage Vendor</h3>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <div class="panel-body">
                    <form id="IndentForm" class="form-inline p-20" role="form" method="post" onload="loadCouter();">
                        <div class="container">
                            <div class="row">
                            	<c:if test="${!empty vndrLst}">
                            		<c:forEach items="${vndrLst}" var="vendor">
										<c:out value="${vendor.vendorName1}"></c:out>	
									</c:forEach>
                            	</c:if>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
