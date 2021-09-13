let exist;let exist2;

$.when(checkExist()).done(function(){});
$.when(checkExist2()).done(function(){});


function checkExist() {
    let email = $("#email").val();
    $.ajax({
        type: "POST",
        url: 'account/checkExist',
        data: {email: email},
        success: function (data) {
            exist = data;
        },
        error: function () {
            console.log("fail check exist");
        }
    });
}
function checkExist2() {
    let username = $("#username").val();
    $.ajax({
        type: "POST",
        url: 'account/checkExist2',
        data: {username: username},
        success: function (data) {
            exist2 = data;
        },
        error: function () {
            console.log("fail check exist");
        }
    });
}


$.validator.addMethod("existEmail", function () {
    checkExist();
    return exist.trim()==="false";
}, "Email Already Exist");
$.validator.addMethod("existUsername", function () {
    checkExist2();
    return exist2.trim()==="false";
}, "Username Already Exist");

$(function () {
    let $loginForm = $("#loginForm");
    if ($loginForm.length) {
        $loginForm.validate({
            rules: {
                username: {
                    required: true,
                    minlength: 6,
                    alphaAndNumber: true
                },
                password: {
                    required: true,
                    minlength: 6
                }
            },
            messages: {
                username: {
                    required: 'Please enter Username!',
                    minlength: 'Username at least 6 characters!'
                },
                password: {
                    required: 'Please enter password!',
                    minlength: 'Password at least 6 characters'
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });
    }
})

$(function () {
    let $registrationForm = $("#registerform");
    if ($registrationForm.length) {
        $registrationForm.validate({
            rules: {
                username: {
                    required: true,
                    minlength: 6,
                    alphaAndNumber: true,
                    existUsername: true
                },
                password: {
                    required: true,
                    minlength: 6
                },
                confirm: {
                    required: true,
                    minlength: 6,
                    equalTo: "#password"
                },
                email: {
                    required: true,
                    customEmail: true,
                    existEmail: true
                }
            },
            messages: {
                username: {
                    required: 'Please enter Username!',
                    minlength: 'Username at least 6 characters!'
                },
                password: {
                    required: 'Please enter password!',
                    minlength: 'Password at least 6 characters'
                }, confirm: {
                    required: 'Please confirm password!',
                    minlength: 'Confirm password at least 6 characters',
                    equalTo: 'Please enter same password!'

                }, email: {
                    required: 'Please enter email!',
                    email: 'Please enter valid email!'
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });
    }
})