/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var indx = 1;
var isSameMaterialVendorExitsInTable = 0;
var indentTotalAmount = 0;
// $(window).load(function() {
$(document).ready(function() {
	disableIt();
	// loadCouter();
	$("#tot-indent-rows").text("0");
	$("#indent-total-amount").text("0.00");
	$("#counterNames").change(function() {
		counterOnChange();
	});
	$('#j_Material').keypress(function(e) {
		materialValidate(e);
	});
	$('#j_Vendor').keypress(function(e) {
		vendorValidate(e);
	});
	$('#j_Quantity').keypress(function(e) {
		loadMaterialInfo(e);
	});
	$('#close-md-effect-modal').on("click", function() {
		alert("Close");
	});
});


function loadCouter() {
	$.getJSON('loadCounters.action',function(data) {
		var counterNameArr = new Array();
		counterNameArr = data;
		$("#counterNames").empty();
		$("#counterNames").append($("<option></option >").attr("value", "Select").text("Select"));
		if (counterNameArr.length > 0) {
			for (var i = 0; i <= counterNameArr.length; i++) {
				$("#counterNames").append($("<option></option>").attr("value",counterNameArr[i].counterName).text(counterNameArr[i].counterLegacyNumber));
			}
		}
		// }).fail(function(data) {
			// console.log("failed");
		});
}

function counterOnChange() {
	var vendor = $("#j_Vendor").val().trim();
	var quantity = $('#j_Quantity').val().trim();
	var material = $("#j_Material").val().trim();
	var choosedCounter = $("#counterNames").val().trim();

	var splittedCounterValues = choosedCounter.split('~');
	var counterId = splittedCounterValues[0];
	var counterLegacy = splittedCounterValues[1];

	$("#hidden-counterName").val(counterId);
	if (vendor !== "" || quantity !== "" || material !== "") {
		$("#j_Vendor").val("");
		$('#j_Quantity').val("");
		$("#j_Material").val("");
		$("#j_Material").removeClass('user-error');
	}
	if (counterId > 0) {
		$.ajax({
			type : "POST",
			url : "addCounterToSession?legacyNo=" + counterId,
			success : function(data) {
				if (data === 1) {
					$("#j_Material").attr("disabled", false);
					$("#j_Material").focus();
					$("#counterNames").attr("disabled", true);
				} else {
					disableIt();
				}
			},
			error : function(data) {
				$('#infoModal').modal('show');
				$('#modalLabel').text('Error !');
				$('#infoMessage').text('Process failure,please try again !');
				break;
			}
		});

	} else if (counterId <= 0) {
		disableIt();
	}
}

function materialValidate(event) {
	var selectedCounter = "";
	if (event.keyCode === 13) {
		var materialID = $("#j_Material").val().trim();
		if (materialID.length > 0) {
			$("#j_Material").removeClass('user-error');
			selectedCounter = $("#counterNames").val().trim();
			$("#hidden-counterName").val(selectedCounter);
			$.ajax({
						type : "POST",
						url : 'materialValidate',
						data : $("#IndentForm").serialize(),
						success : function(response) {
							switch (response) {
							case 0:
								$('#infoModal').modal('show');
								$('#modalLabel').text('Info !');
								$('#infoMessage').text(materialID + " doesn't exits !");
								$("#j_Material").addClass('user-error');
								$("#j_Material").focus();
								break;
							case 1:
								$("#j_Vendor").focus();
								$("#j_Vendor").attr("disabled", false);
								$("#j_Material").removeClass('user-error');
								break;
							case -1:
								$('#infoModal').modal('show');
								$('#modalLabel').text('Info !');
								$('#infoMessage').text("Material-ID field can't be empty!");
								$("#j_Material").addClass('user-error');
								$("#j_Material").focus();
								break;
							case -2:
								$('#infoModal').modal('show');
								$('#modalLabel').text('Info !');
								$('#infoMessage').text(materialID + " doesn't exits !");
								$("#j_Material").addClass('user-error');
								$("#j_Material").focus();
								break;
							case -3:
								$('#infoModal').modal('show');
								$('#modalLabel').text('Error !');
								$('#infoMessage').text(materialID+ " doesn't belong to selected counter type !");
								$("#j_Material").addClass('user-error');
								$("#j_Material").focus();
								break;
							default:
								$('#infoModal').modal('show');
								$('#modalLabel').text('Error !');
								$('#infoMessage').text('Process failure,please try again !');
								break;
							}
						}
					});
		} else {
			$('#infoModal').modal('show');
			$('#modalLabel').text('Info !');
			$('#infoMessage').text("Material can't be Empty !");
			$("#j_Material").addClass('user-error');
		}
	}
}

function vendorValidate(event) {
	if (event.keyCode === 13) {
		var vendorId = $("#j_Vendor").val().trim();
		if (vendorId.length > 0) {
			$.ajax({
						type : "POST",
						url : 'vendorValidate',
						data : $("#IndentForm").serialize(),
						success : function(response) {
							switch (response) {
							case 0:
								$('#infoModal').modal('show');
								$('#modalLabel').text('Info !');
								$('#infoMessage').text(vendorId + " doesn't exits !");
								$("#j_Vendor").addClass('user-error');
								$("#j_Vendor").focus();
								break;
							case 1:
								$("#j_Quantity").focus();
								$("#j_Quantity").attr("disabled", false);
								$("#j_Vendor").removeClass('user-error');
								break;
							case -1:
								$('#infoModal').modal('show');
								$('#modalLabel').text('Info !');
								$('#infoMessage').text("Vendor field can't be empty !");
								$("#j_Vendor").addClass('user-error');
								$("#j_Vendor").focus();
								break;
							case -2:
								$('#infoModal').modal('show');
								$('#modalLabel').text('Error !');
								$('#infoMessage').text("Material - Vendor doesn't match !");
								$("#j_Vendor").addClass('user-error');
								$("#j_Vendor").focus();
								break;
							default:
								$('#infoModal').modal('show');
								$('#modalLabel').text('Error !');
								$('#infoMessage').text('Process failure,please try again !');
								break;
							}
						}
					});
		} else {
			$('#infoModal').modal('show');
			$('#modalLabel').text('Error !');
			$('#infoMessage').text("Vendor field can't be empty !");
			$("#j_Vendor").addClass('user-error');
			$("#j_Vendor").focus();
		}
	}
}
function loadMaterialInfo(event) {
	if (event.keyCode === 13) {
		var rowColor = "";
		var dynamicRow = "";
		var indentTableTotalRows = $('#indent-content tr').length; // GETTING THE TOTAL ROWS IN THE TABLE
		// indentTableTotalRows = parseInt(indentTableTotalRows) + 1;
		var keyCode = "";
		var inVendorId = "";
		var inVendorName = "";
		var inQuantity = "";
		var inMaterialId = "";
		var inMaterialDescription = "";
		var inStandardPrice = "";
		var inSellingPrice = "";
		var intGrandTotal = "";
		// var InTaxValue = "";
		// var InCraftGst = "";
		var inGrossValue = "";
		var inHsnCode = "";
		var Qty = parseInt($("#j_Quantity").val());
		
		if (Qty > 0) {
			$.ajax({
				type : "POST",
				url : 'getProductDetail?mQty=' + Qty,
				data : $("#IndentForm").serialize(),
				success : function(response) {
					var materialInfoArr = new Array();
					materialInfoArr = response;
					for (var i = 0; i < materialInfoArr.length; i++) {
						keyCode = materialInfoArr[i].keyCode;
						inMaterialId = materialInfoArr[i].materialID;
						inMaterialDescription = materialInfoArr[i].materialDescription;
						inVendorId = materialInfoArr[i].vendorID;
						inVendorName = materialInfoArr[i].vendorName;
						inStandardPrice = parseFloat(materialInfoArr[i].materialStandardPrice).toFixed(2);
						inSellingPrice = parseFloat(materialInfoArr[i].materialSellingPrice).toFixed(2);
						inQuantity = parseFloat(materialInfoArr[i].quantity).toFixed(2);
						inGrossValue = parseFloat(materialInfoArr[i].grossAmount).toFixed(2);
						intGrandTotal = parseFloat(materialInfoArr[i].totalAmount).toFixed(2);
						inHsnCode = materialInfoArr[i].hsnCode;
					}
					rowColor = (indx % 2 === 0) ? ("success") : ("active");
					dynamicRow = '<tr role="row" class="lite-text size12 ' + rowColor + '" id="' + keyCode + '"><td id="in-sno-' + indx + '">' + indx + ' </td><td class="sorting_1" tabindex="0" id="in-material-id-' + indx + '">' + inMaterialId + '</td><td id="in-material-description-' + indx + '"style="font-size:13px;">' + inMaterialDescription + '</td> <td id="in-material-vendor-id-' + indx + '">' + inVendorId + '</td><td id="in-material-vendor-name-' + indx + '" style="font-size:13px;">' + inVendorName + '</td><td id="in-material-quantity-' + indx + '">' + inQuantity + '</td><td id="in-material-stdprc-' + indx + '">' + inStandardPrice + '</td><td id="in-material-sellingprc-' + indx + '">' + inSellingPrice + '</td><td id="in-total-' + indx + '">' + inGrossValue + '</td><td><button class="md-trigger btn btn-icon btn-danger m-b-5 deleteItem" id="in-remove-' + keyCode + '"> <i class="fa fa-remove"></i> </button> </td></tr>';
					$('#indent-content').append(dynamicRow).show('normal');
					indx ++;
				},
				error : function(response) {
					$('#infoModal').modal('show');
					$('#modalLabel').text('Error !');
					$('#infoMessage').text('Process failure,please try again !');
					break;
				}
			});
		}else{
			$('#infoModal').modal('show');
			$('#modalLabel').text('Error !');
			$('#infoMessage').text("Quantity should be greater than 0 !");
			$("#j_Vendor").addClass('user-error');
			$("#j_Vendor").focus()
		}
		$("#j_Vendor").val("");
		$('#j_Quantity').val("");
		$("#j_Material").val("");
		$("#j_Material").focus();
		if (indx > 0) {
			$("#counterNames").attr("disabled", true);
		} else if (indx === 0) {
			$("#counterNames").attr("disabled", false);
		}
	}
}

/* Animated - Modal */
this.$removeRow = '.deleteItem';
$(document).on("click", this.$removeRow, function(ev) {
	ev.preventDefault();
	$('#modal-11').modal('show');
	$('#modal-11').addClass('md-show');
	$("#hidden-indent-delete-row").val(this.id);
});

this.$closeMdModal = '#close-md-modal-effect';
$(document).on("click",this.$closeMdModal,function(ev) {
	ev.preventDefault();
	var deleteRowKey = $("#hidden-indent-delete-row").val().trim();
	var deleteKeyLen = deleteRowKey.length;
	if (deleteKeyLen > 0) {
		var deleteRowID = deleteRowKey.slice(10, deleteKeyLen);
		if(deleteRowID !="" || deleteRowID != undefined && deleteRowID.length > 0 ){
			$.ajax({
				type : "POST",
				url : "removeItemFromCart?cID=" + deleteRowID,
				success : function(response) {
					if(response >= 1){
						$.ajax({
							type : "POST",
							url : "getItemsFromCart",
							success : function(response){
								
							},error:function(response){
								
							}
						});
					}
				},error :function (response){
					
				}
			});
		}
		
//				$.getJSON('removeIndentFromCart.action?DeletingIndentId='+ deleteRow, function(data) {
//					$("#" + deleteRow).closest('tr[id]').remove(); // REMOVING SELECTED INDENT ROW
//					$('#modal-11').removeClass('md-show');
//					$('#modal-11').modal('hide');
//				});
	}
});

/* Animated - Modal */


function disableIt() {
	$("#j_Material").attr("disabled", true);
	$("#j_Vendor").attr("disabled", true);
	$("#j_Quantity").attr("disabled", true);
}
function enableIt() {
	$("#j_Material").attr("disabled", false);
	$("#j_Vendor").attr("disabled", false);
	$("#j_Quantity").attr("disabled", false);
}
// });

