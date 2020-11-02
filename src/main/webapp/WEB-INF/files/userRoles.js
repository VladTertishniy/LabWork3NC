jQuery.validator.addMethod("notEqual", function (value, element, param) {
    return this.optional(element) || value != '0';
});
$(document).ready(function () {
    $("#userRolesForm").validate({
        rules: {
            "user.user_id": {
                required: true,
                digits: true,
                notEqual: '0'
            },
            "role.id": {
                required: true,
                digits: true,
                notEqual: '0'
            }

        },
        messages: {
            "user.user_id": {
                required: "Please enter user id",
                digits:"Please enter digits only",
                notEqual:"User id can not be zero"
            },
            "role.id": {
                required: "Please enter role id",
                digits:"Please enter digits only",
                notEqual:"Role id can not be zero"
            }
        }
    });
});