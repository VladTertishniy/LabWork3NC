jQuery.validator.addMethod("notEqual", function (value, element, param) {
    return this.optional(element) || value != '0';
});
$(document).ready(function () {
    $("#consumerForm").validate({
        rules: {
            "user.user_id": {
                required: true,
                digits: true,
                notEqual: '0'
            },
            phoneNumber: {
                required: true,
                digits: true,
                minlength: 12,
                maxlength: 50
            },
            firstname: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            lastname: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            counterpartyType: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            "user.user_id": {
                required: "Please enter count",
                digits:"Please enter digits only",
                notEqual:"Count can not be zero"
            }
        }
    });
});