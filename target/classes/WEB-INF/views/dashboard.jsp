<%-- 
    Document   : dashboard
    Created on : Dec 21, 2017, 11:07:00 AM
    Author     : Madiba
--%>

<section id="dashboard-chart">

    <!--    <div class="wraper container-fluid">-->
    <!--    <div class="portlet">-->
    <div class="row">
        <div class="col-lg-6">
            <div class="portlet"><!-- /primary heading -->
                <div class="portlet-heading">
                    <h3 class="portlet-title text-dark text-uppercase">
                        Donut Pie
                    </h3>
                    <div class="portlet-widgets">
                        <a href="javascript:;" data-toggle="reload"><i class="ion-refresh"></i></a>
                        <span class="divider"></span>
                        <a data-toggle="collapse" data-parent="#accordion1" href="http://coderthemes.com/velonic_3.0/admin_4/charts-flot.html#portlet3"><i class="ion-minus-round"></i></a>
                        <span class="divider"></span>
                        <a href="http://coderthemes.com/velonic_3.0/admin_4/charts-flot.html#" data-toggle="remove"><i class="ion-close-round"></i></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="portlet"><!-- /primary heading -->
                    <div id="portlet3" class="panel-collapse collapse in">
                        <div class="portlet-body">
                            <div id="donut-chart">
                                <div id="donut-chart-container" class="flot-chart" style="height: 320px; padding: 0px; position: relative;">
                                    <canvas class="flot-base" width="488" height="320" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 488px; height: 320px;"></canvas><canvas class="flot-overlay" width="488" height="320" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 488px; height: 320px;"></canvas><span class="pieLabel" id="pieLabel0" style="position: absolute; top: 78px; left: 353px;"><div style="font-size:x-small;text-align:center;padding:2px;color:rgb(252,93,147);">Series 1<br>35%</div></span><span class="pieLabel" id="pieLabel1" style="position: absolute; top: 281px; left: 269px;"><div style="font-size:x-small;text-align:center;padding:2px;color:rgb(52,199,59);">Series 2<br>20%</div></span><span class="pieLabel" id="pieLabel2" style="position: absolute; top: 261px; left: 139px;"><div style="font-size:x-small;text-align:center;padding:2px;color:rgb(57,96,209);">Series 3<br>10%</div></span><span class="pieLabel" id="pieLabel3" style="position: absolute; top: 167px; left: 81px;"><div style="font-size:x-small;text-align:center;padding:2px;color:rgb(220,220,220);">Series 4<br>15%</div></span><span class="pieLabel" id="pieLabel4" style="position: absolute; top: 27px; left: 139px;"><div style="font-size:x-small;text-align:center;padding:2px;color:rgb(63,183,238);">Series 5<br>20%</div></span></div>
                            </div>
                        </div>

                    </div>
                </div>


                <div id="portlet3" class="panel-collapse collapse in">
                    <div class="portlet-body">
                        <canvas id="pie" data-type="Pie" height="250" width="488" style="width: 488px; height: 250px;"></canvas> 
                    </div>
                </div>
            </div> <!-- /Portlet -->
        </div> <!-- end col -->
        <!--    </div>-->
        <!--    </div>-->
    </div>
</section>