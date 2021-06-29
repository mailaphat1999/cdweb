$(function () {
    let $updateProfile = $("#updateProfile");
    if ($updateProfile.length) {
        $updateProfile.validate({
            rules: {
                name: {
                    required: true,
                    minlength: 6,
                    alpha: true
                },
                email: {
                    required: true,
                    customEmail: true
                },
                phone: {
                    required: true,
                    myPhoneFormat: true
                },
                dob: {
                    myDateFormat: true
                }
            },
            messages: {
                username: {
                    required: 'Please enter Username!',
                    minlength: 'Username at least 6 characters!',
                    alpha: 'Character Only'
                },
                email: {
                    required: 'Please enter Email!',
                    customEmail: 'Invalid Email'
                },
                phone: {
                    required: 'Please enter Contact Phone!',
                },
                dob: {
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });
    }
})

$(function () {
    let $changePass = $("#changePass");
    if ($changePass.length) {
        $changePass.validate({
            rules: {
                username: {
                    required: true,
                    minlength: 6
                },
                password: {
                    required: true,
                    minlength: 6
                },
                newpassword: {
                    required: true,
                    minlength: 6
                },
                repassword: {
                    required: true,
                    minlength: 6,
                    equalTo: '#newpassword'
                }
            },
            messages: {
                username: {
                    required: 'Please enter Username!',
                    minlength: 'Username at least 6 characters!'
                },
                password: {
                    required: 'Please enter Old Password!',
                    minlength: 'Old Password at least 6 characters!'
                },
                newpassword: {
                    required: 'Please enter New Password!',
                    minlength: 'New Password at least 6 characters!'
                },
                repassword: {
                    required: 'Please Confirm Password!',
                    minlength: 'Confirm Password at least 6 characters!',
                    equalTo: 'Confirm password not match'
                }
            },
            errorPlacement: function (error, element) {
                error.insertAfter(element);
            }
        });
    }
})