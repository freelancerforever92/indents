<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="resource/assets/css/application-style.css">
	<!--<link rel="stylesheet" href="resource/assets/css/bootstrap.css">-->
        <link rel="stylesheet" href="resource/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="resource/assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="resource/assets/css/main.css">
        <link rel="stylesheet" href="resource/assets/css/styles.css">
        <link rel="stylesheet" href="resource/assets/css/core.css">
       
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">

            </div>

            <div class="login-box-body">
                <p class="login-box-msg">Sign in to start your session</p>

                <form id="loginForm" name="loginForm" action="doLogin" method="post">
                    <div class="form-group">
                        <span class="fa fa-user"></span>
                        <input type="text" class="form-control" id="j_UserName" name="uUserName" placeholder="Username" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <span class="fa fa-lock"></span>
                        <input type="password" class="form-control" id="j_Password" name="uPassword" placeholder="Password">
                    </div>

                    <div class="row">
                        <div class="col-xs-4">
                            <input type="submit" class="btn btn-primary btn-block btn-flat" value="Sign In"/>
                        </div>
                    </div>
                </form>
                <div class="row">
                    <a href="javascript:void(0);" class="forgot-pass">I forgot my password</a><br>
                </div>
            </div>
        </div>
    </body>
</html>