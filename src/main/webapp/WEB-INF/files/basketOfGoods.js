
jQuery.validator.addMethod("notEqual", function (value, element, param) {
    return this.optional(element) || value != '0';
});
$(document).ready(function () {
    $("#basketOfGoodsForm").validate({
        rules: {
            "order.id": {
                required: true,
                digits: true,
                notEqual: '0'
            },
            "goods.id": {
                required: true,
                digits: true,
                notEqual: '0'
            },
            count: {
                required: true,
                digits: true,
                notEqual: '0'
            },
            sum: {
                required: true,
                notEqual: '0'
            }
        },
        messages: {
            count: {
                required: "Please enter count",
                digits:"Please enter digits only",
                notEqual:"Count can not be zero"
            },
            sum: {
                required: "Please enter sum",
                notEqual:"Sum can not be zero"
            },
            "order.id": {
                required: "Please enter order id",
                digits:"Please enter digits only",
                notEqual:"Order id can not be zero"
            },
            "goods.id": {
                required: "Please enter goods id",
                digits:"Please enter digits only",
                notEqual:"Goods id can not be zero"
            }
        }
    });
});
