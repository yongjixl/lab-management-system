var webRoot="localhost:8080"

$(function() {
    $('#defaultForm')
        .bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                userName: {
                    message: 'The username is not valid',
                    validators: {
                        notEmpty: {
                            message: 'The username is required and can\'t be empty'
                        },
                        stringLength: {
                            min: 5,
                            max: 30,
                            message: 'The username must be more than 6 and less than 30 characters long'
                        },
                        /*remote: {
                         url: 'remote.php',
                         message: 'The username is not available'
                         },*/
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\.]+$/,
                            message: 'The username can only consist of alphabetical, number, dot and underscore'
                        }
                    }
                },
                passWord: {
                    validators: {
                        notEmpty: {
                            message: 'The password is required and can\'t be empty'
                        }
                    }
                }
            }
        })
        // .on('success.form.bv', function(e) {
        //     // Prevent form submission
        //     e.preventDefault();
        //
        //     // Get the form instance
        //     var $form = $(e.target);
        //
        //     // Get the BootstrapValidator instance
        //     var bv = $form.data('bootstrapValidator');
        //
        //     // Use Ajax to submit form data
        //     $.post($form.attr('action'), $form.serialize(), function(result) {
        //        if(result.code == "0"){
        //            console.log(1111);
        //            window.location.href=webRoot + '/userpage';
        //        }else{
        //            alert(result.msg);
        //        }
        //     }, 'json');
        // });
});