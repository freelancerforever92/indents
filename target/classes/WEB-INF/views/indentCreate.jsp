<%-- 
    Document   : indentCreate
    Created on : Dec 3, 2017, 7:22:03 PM
    Author     : Madiba
--%>

<section class="indent">
    <div class="panel-heading">
        <h3 class="panel-title">Indent Creation</h3>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">

                <div class="panel-body">
                    <form id="IndentForm" class="form-inline p-20" role="form" method="post" onload="loadCouter();">
                        <div class="container">
                            <div class="row">

                                <div class="col-md-3">
                                    <label class="required-red">Material </label>
                                    <input type="text"  id="j_Material" name ="materialId" class="form-control tooltip-btn" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Material Id" required autocomplete="off" placeholder="material"/>
                                </div>

                                <div class="col-md-3">
                                    <label class="required-red">Vendor</label>
                                    <input type="text"  id="j_Vendor" name ="vendorID"  class="form-control tooltip-btn" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Vendor Id" required autocomplete="off" placeholder="vendor"/>
                                </div>

                                <div class="col-md-3">
                                    <label class="required-red">Quantity</label>
                                    <input type="text" id="j_Quantity" name ="J_quantity"  class="form-control tooltip-btn" data-toggle="tooltip" data-placement="bottom" title="" data-original-title="Quantity" required autocomplete="off" placeholder="quantity"/>
                                </div>

                                <div class="col-md-3">
                                    <input type="button" class="btn btn-danger fa fa-refresh w-sm m-b-5 lite-text size16 removeIndentItem" value="Refresh"/>
                                </div>

                            </div>
                        </div>
                       <input type="hidden" id="hidden-counterName" name="counterName" style="display: none" />
                    </form>
                </div>

            </div>
        </div>
        <div class="row">
            <div id="datatable-buttons_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer" style="height: 350px;overflow: auto;">
                <table id="datatable-buttons" class="table table-striped table-bordered dataTable no-footer dtr-inline" role="grid" border="1" aria-describedby="datatable-buttons_info">
                    <thead>
                        <tr role="row" style="text-justify: center">
                            <th class="sorting_asc" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 30px;">Sno</th>
                            <th class="sorting_asc" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 89px;">Item Code</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-label="Position: activate to sort column ascending" style="width: 190px;">Description</th>
                            <th class="sorting_asc" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 79px;">Vendor No</th>
                            <th class="sorting_asc" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Name: activate to sort column descending" style="width: 190px;">Vendor Name</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-label="Office: activate to sort column ascending" style="width: 52px;">Qty</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-label="Age: activate to sort column ascending" style="width: 52px;">Cp</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-label="Start date: activate to sort column ascending" style="width: 52px;">Sp</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending" style="width: 52px;">Amount</th>
                            <th class="sorting" tabindex="0" aria-controls="datatable-buttons" rowspan="1" colspan="1" aria-label="Salary: activate to sort column ascending" style="width: 30px;">#</th>
                        </tr>
                    </thead>

                    <tbody id="indent-content">

                    </tbody>
                </table>
            </div>

        </div>


    </div>
    <footer class="footer" style="margin-top: 69px;">
        <div class="container">
            <div class="row indent-form-actions">
                <ul class="list-unstyled navbar-nav ">
                    <li>
                        <div class="pull-left">
                            <input type="button" class="btn btn-success lite-text size20 w-sm" value="Save"/>
                        </div>
                    </li>
                    <li>
                        <div class="pull-left">
                            <input type="button" class="btn btn-danger lite-text size20 w-sm" value="Cancel"/>
                        </div>
                    </li>
                </ul>
                <div class="pull-right">
                    <label class="lite-text size12">Total:</label>
                    <span class="lite-text size26" id="indent-total-amount"></span>
                </div>
            </div>
        </div>
    </footer>

    <!--    <footer class="footer">
                            <div class="container">
                                <div class="row">
                                    <div class="col-md-3">
                                       
                                    </div>
                                    <div class="col-md-3">
                                        
                                    </div>
                                </div>
                            </div>
        </footer>-->














    <!--
        <div class="sweet-overlay" tabindex="-1" style="opacity: 1.02; display: block;"></div>
        <div class="sweet-alert showSweetAlert visible" tabindex="-1" data-custom-class="" data-has-cancel-button="false" data-has-confirm-button="true" data-allow-ouside-click="false" data-has-done-function="false" data-animation="pop" data-timer="null" style="display: block; margin-top: -114px;">
            <div class="sa-icon sa-error" style="display: none;">
                <span class="sa-x-mark">
                    <span class="sa-line sa-left"></span>
                    <span class="sa-line sa-right"></span>
    
                </span>
            </div>
            <div class="sa-icon sa-warning" style="display: none;"> 
                <span class="sa-body"></span> 
                <span class="sa-dot"></span> 
            </div> 
            <div class="sa-icon sa-info" style="display: none;"></div> 
            <div class="sa-icon sa-success" style="display: none;"> 
                <span class="sa-line sa-tip"></span> 
                <span class="sa-line sa-long"></span> 
                <div class="sa-placeholder"></div> 
                <div class="sa-fix"></div> </div> 
            <div class="sa-icon sa-custom" style="display: none; background-image: url(&quot;assets/sweet-alert/thumbs-up.jpg&quot;); width: 80px; height: 80px;"></div> 
            <h2>Here's a message!</h2>
            <p style="display: block;"></p>
            <button class="cancel" tabindex="2" style="display: none; box-shadow: none;">Cancel</button>
            <button class="confirm" tabindex="1" style="display: inline-block; background-color: rgb(174, 222, 244); box-shadow: rgba(174, 222, 244, 0.8) 0px 0px 2px, rgba(0, 0, 0, 0.05) 0px 0px 0px 1px inset;">OK</button>
        </div>
    -->




</section>
<!-- Modal -->
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h5 class="modal-title lite-text size18" id="modalLabel"></h5>
            </div>
            <div class="modal-body lite-text size20" id="infoMessage" ></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary confirm lite-text" data-dismiss="modal" style="color:#ffffff;">Close</button>
            </div>
        </div>
    </div>
</div>
<input type="text" id="hidden-indent-delete-row" />
<!-- Modal Remove Confirmation -->
<div class="md-modal md-effect-11" id="modal-11">
    <div class="md-content">
        <h3>Do you want to remove ?</h3>
        <div>
            <input type="text" id="hidden-indent-delete-row" />
            <button class="md-close btn-lg btn-success" id="close-md-modal-effect">Okay</button>
        </div>
    </div>
</div>