$(document).ready(function () {
    $('#userForm').validate({
        rules: {
            password: {
                required: true,
                minlength: 10,
                maxlength: 50
            },
            username: {
                required: true,
                minlength: 5,
                maxlength: 50
            }
        }
    });
});