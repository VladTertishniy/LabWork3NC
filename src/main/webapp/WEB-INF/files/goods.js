jQuery.validator.addMethod("notEqual", function (value, element, param) {
    return this.optional(element) || value != '0';
});
$(document).ready(function () {
    $("#goodsForm").validate({
        rules: {
            price: {
                required: true,
                notEqual: '0'
            },
            "goodsType.id": {
                required: true,
                digits: true,
                notEqual: '0'
            },
            "supplier.user.user_id": {
                required: true,
                digits: true,
                notEqual: '0'
            },
            name: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
        },
        messages: {
            price: {
                required: "Please enter price",
                digits:"Please enter digits only",
                notEqual:"Price can not be zero"
            },
            "goodsType.id": {
                required: "Please enter goods type id",
                digits:"Please enter digits only",
                notEqual:"Goods type id can not be zero"
            },
            "supplier.user.user_id": {
                required: "Please enter supplier id",
                digits:"Please enter digits only",
                notEqual:"Supplier id can not be zero"
            }
        }
    });
});