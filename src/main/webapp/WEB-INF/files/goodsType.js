jQuery.validator.addMethod("notEqual", function (value, element, param) {
    return this.optional(element) || value != '0';
});
$(document).ready(function () {
    $("#goodsTypeForm").validate({
        rules: {
            "parent_id": {
                required: true,
                digits: true,
                notEqual: '0'
            },
            name: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            vendorCode: {
                required: true,
                minlength: 5,
                maxlength: 50
            }
        },
        messages: {
            "parent_id": {
                required: "Please enter parent goods type",
                digits:"Please enter digits only",
                notEqual:"Parent goods type can not be zero"
            }
        }
    });
});