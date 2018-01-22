<%-- 
    Document   : baseLayout
    Created on : Nov 12, 2017, 8:08:06 PM
    Author     : Madiba
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title><tiles:getAsString name="title"/></title>
        <link rel="stylesheet" href="resource/assets/css/appstyle.css"/>
        <link rel="stylesheet" href="resource/assets/css/helper.css"/>
        <link rel="stylesheet" href="resource/assets/css/toggles.css"/>

        <link rel="stylesheet" href="resource/assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="resource/assets/css/bootstrap-reset.css"/>

        <link rel="stylesheet" href="resource/assets/css/animate.css"/>

        <link rel="stylesheet" href="resource/assets/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="resource/assets/css/ionicons.min.css"/>

        <!--<link rel="stylesheet" href="css/sweet-alert.min.css"/>-->
        <link rel="stylesheet" href="resource/assets/css/application-style.css"/>
        <link rel="stylesheet" href="resource/assets/css/style-core.css"/>


        <!-- MODAL -->
        <link rel="stylesheet" href="resource/assets/css/component.css"/>
        <!-- MODAL -->

        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500" rel="stylesheet">


        <!--<link rel="stylesheet" href="resource/assets/css/bootstrap-datepicker.min.css"/>
        <link rel="stylesheet" href="resource/assets/css/bootstrap-timepicker.min.css"/>-->
    </head>
    <body>
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="menu" />
        <div class="wraper container-fluid">
            <tiles:insertAttribute name="body" />
        </div>
    </body>


    <!--   
    <script src="resource/assets/js/jquery.js"></script>
    <script src="resource/assets/js/jquery-ui.js"></script>
    <script src="resource/assets/js/jquery-1.11.2.min.js"></script>
    <script src="resource/assets/js/jquery-1.10.1.min.js"></script>
    <script src="resource/assets/js/jQuery-2.1.4.min.js"></script>
    -->
    
    <script src="resource/assets/js/jquery-1.10.1.min.js"></script>
    <script src="resource/assets/js/bootstrap.min.js"></script>
    <script src="resource/assets/js/charts/modernizr.min.js"></script>
    <script src="resource/assets/js/pace.min.js"></script>
    <script src="resource/assets/js/wow.min.js"></script>
    <script src="resource/assets/js/charts/jquery.scrollTo.min.js"></script>
    <script src="resource/assets/js/charts/jquery.nicescroll.js"></script>

<!--<script src="resource/assets/js/jquery-1.11.2.js"></script>-->
    <script src="resource/assets/js/toggles.min.js"></script>
    <script src="resource/assets/js/jquery.app.js"></script>
    <script src="resource/assets/js/modalEffects.js"></script>
    <script src="resource/assets/js/core-script.js"></script>
    <!--
    <script src="resource/assets/js/charts/chart.min.js"></script>
    <script src="resource/assets/js/charts/chartjs.init.js"></script>
    <script src="resource/assets/js/charts/jquery.flot.pie.js"></script>
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="resource/assets/js/classie.js"></script>
    <script src="js/wow.min.js"></script>
    -->
    <!-- CHARTS -->
    <!--
        <script src="resource/assets/js/charts/jquery.flot.js"></script>
        <script src="resource/assets/js/charts/jquery.flot.time.js"></script>
        <script src="resource/assets/js/charts/jquery.flot.tooltip.min.js"></script>
        <script src="resource/assets/js/charts/jquery.flot.resize.js"></script>
        <script src="resource/assets/js/charts/jquery.flot.pie.js"></script>
        <script src="resource/assets/js/charts/jquery.flot.selection.js"></script>
        <script src="resource/assets/js/charts/jquery.flot.stack.js"></script>
        <script src="resource/assets/js/charts/jquery.flot.crosshair.js"></script>
        <script src="resource/assets/js/charts/jquery.flot.init.js"></script>
        <script src="resource/assets/js/charts/analytics.js"></script>
    -->
    <div id="flotTip" style="display: none; position: absolute; left: 456px; top: 784px;"></div>
    <!-- CHARTS -->

    <!--<script src="js/jquery.tagsinput.min.js"></script>-->
    <!--<script src="js/scripts.js"></script>-->
    <!--<script src="js/sweet-alert.min.js"></script>-->
    <!--<script src="js/sweet-alert.init.js"></script>-->

</html>














