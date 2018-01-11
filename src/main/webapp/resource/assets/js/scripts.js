/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var IndentJs;
var indx = 1;
IndentJs = {
    init: function() {
        this.loadingCounters();
        $("#j_Material").focus();
        $('#j_Material').keypress(IndentJs.materialOnEnterKey);
        $('#j_Vendor').keypress(IndentJs.vendorOnEnterKey);
        $('#j_Quantity').keypress(IndentJs.quantityOnEnterKey);
        $(".removeIndentItem").on('click', IndentJs.indentTableRow);
    },
    
     loadingCounters: function() {
//        alert("asfsf");
        $.getJSON('loadCounters', function(data)
        {
            console.log("2");
            alert(data.legacyCounters);
//            $("#navigatedCounterName").empty();
//            $("#navigatedCounterName").append($("<option></option>").attr("value", "Select").text("Select"));
            $.each(data.legacyCounters, function(i, item)
            {
                alert(item.counterName);
                console.log("" + item.counterName);
                console.log("" + item.counterLegacyNumber);
//                $("#navigatedCounterName").append($("<option></option>").attr("value", item.counterName).text(item.counterLegacyNumber));
            });
        });
    },
    
    
    materialOnEnterKey: function(event) {
        if (event.keyCode === 13) {
            var materialID = $("#j_Material").val().trim();
            if (materialID.length > 0) {
                $("#j_Material").removeClass('user-error');
                $.getJSON('materialValidate.action', $("#IndentForm").serialize(), function(data)
                {
                    if (data.isMaterialIdVaild !== false) {
                        $("#j_Vendor").focus();
                    } else {
                        $('#infoModal').modal('show');
                        $('#modalLabel').text('Error !');
                        $('#infoMessage').text('Material ' + materialID + ' Doesnt Exits.!');
                        $("#j_Material").addClass('user-error');
                        $("#j_Material").val("");
                        $("#j_Material").focus();
                    }
                });
            } else {
                $('#infoModal').modal('show');
                $('#modalLabel').text('Info !');
                $('#infoMessage').text('Material cant be Empty !');
                $("#j_Material").addClass('user-error');
            }
        }
    },
    vendorOnEnterKey: function(event) {
        if (event.keyCode === 13) {
            var vendorId = $("#j_Vendor").val().trim();
            if (vendorId.length > 0) {
                $.getJSON('vendorValidate.action', $("#IndentForm").serialize(), function(data)
                {
                    if (data.isVendorValid !== false) {
                        $("#j_Quantity").focus();
                    } else {
                        $('#infoModal').modal('show');
                        $('#modalLabel').text('Error !');
                        $('#infoMessage').text('Vendor ' + vendorId + ' Doesnt Exits.!');
                        $("#j_Vendor").val("");
                        $("#j_Quantity").focus();
                    }
                });
            } else {
                $('#infoModal').modal('show');
                $('#modalLabel').text('Info !');
                $('#infoMessage').text('Vendor cant be Empty !');
            }
        }
    },
    quantityOnEnterKey: function(event) {
        if (event.keyCode === 13) {
            var contentTableTr = "";
            var vendorID = $("#j_Vendor").val().trim();
            var quantity = $('#j_Quantity').val().trim();
            var materialID = $("#j_Material").val().trim();
            var contentRowCount = $('#indent-content tr').length;                   //GETTING THE TOTAL ROWS IN THE TABLE

            var InVendorId = "";
            var InQuantity = "";
            var InMaterialId = "";
            var InMaterialDescription = "";
            var InStandardPrice = "";
            var InSellingPrice = "";

            $.getJSON('getProductDetail.action', $("#IndentForm").serialize(), function(data)
            {
                var totalItems = data.materialInfo.length;
                InQuantity = parseFloat(data.materialInfo[0].IN_quantity).toFixed(2);
                InVendorId = data.materialInfo[0].IN_vendorID;
                InMaterialId = data.materialInfo[0].IN_materialID;
                InMaterialDescription = data.materialInfo[0].IN_materialDescription;
                InStandardPrice = parseFloat(data.materialInfo[0].IN_materialStandardPrice).toFixed(2);
                InSellingPrice = parseFloat(data.materialInfo[0].IN_materialSellingPrice).toFixed(2);
                contentTableTr = '<tr role="row" class="odd data-item=' + indx + '" id="tr' + indx + '"><td id="in-sno-' + indx + '">' + indx + ' . </td><td class="sorting_1" tabindex="0" id="in-material-id-' + indx + '">' + InMaterialId + '</td><td id="in-material-description-' + indx + '">' + InMaterialDescription + '</td><td id="in-material-quantity-' + indx + '">' + InQuantity + '</td><td id="in-material-stdprc-' + indx + '">' + InStandardPrice + '</td><td id="in-material-sellingprc-' + indx + '">' + InSellingPrice + '</td><td id="in-material-vendor-' + indx + '">' + InVendorId + '</td><td><input type="button" class="btn btn-icon btn-danger removeIndentItem" value="Remove"/></td></tr>'
                indx++;
                $('#indent-content').append(contentTableTr);
            });
            $("#j_Vendor").val("");
            $('#j_Quantity').val("");
            $("#j_Material").val("");
            $("#j_Material").focus();
        }
    },
   
    indentTableRow: function() {
        alert("ADSfsadfd");
        console.log("Hello world");
//        event.preventDefault();
//        var client = $(this).data('item');
//        console.log("=> :: "+client);

    }

};
$(window).on("load", function() {

    $(document).ready(function()
    {
        IndentJs.init();

    });
});
