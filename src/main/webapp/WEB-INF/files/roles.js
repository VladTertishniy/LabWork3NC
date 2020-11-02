$(document).ready(function () {
    $("#rolesForm").validate({
        rules: {
            name: {
                required: true,
                minlength: 5,
                maxlength: 50
            }
        }
    });
});