jQuery.validator.addMethod("noSpace", function(value, element) {
    return value == '' || value.trim().length != 0;
}, "Not space only");

jQuery.validator.addMethod("customEmail", function(value, element) {
    return this.optional(element) || /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/.test(value);
}, "Invalid email address!");

$.validator.addMethod("alpha", function(value, element) {
    return this.optional(element) || /^[a-zA-Z]+$/.test(value);
}, "Only Alphabet Characters");

$.validator.addMethod("alphaAndNumber", function (value, element) {
    return this.optional(element) || /^[0-9a-zA-Z]+$/.test(value);
}, "Only Alphabet Characters And Number");

$.validator.addMethod("isSelected", function(value, element) {
    return value != "Not Selected";
}, "Please select this field");

$.validator.addMethod("myDateFormat", function(value, element) {
    return this.optional(element) || /^\d{4}-\d{2}-\d{2}$/.test(value);
}, "Invalid Date Format - Ex:1999-8-24");

$.validator.addMethod("myPhoneFormat", function(value, element) {
    return this.optional(element) || /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4}$/im.test(value);
}, "Invalid Phone Format - 10 Number Only");