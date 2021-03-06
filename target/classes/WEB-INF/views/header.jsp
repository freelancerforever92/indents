<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<header class="top-head container-fluid">
		<button type="button" class="navbar-toggle pull-left">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>

		<!-- Left navbar -->
		<nav class=" navbar-default" role="navigation">
			<!-- Right navbar -->
			<ul
				class="nav navbar-nav navbar-right hidden-xs top-menu top-right-menu">
				<!-- mesages -->
				<li class="nav-item dropdown" style="margin-right: 20px;">
					<select class="form-control lite-text size20" id="counterNames" style="margin-top: 13px;">
						<option value="0" selected="0" class="dropdown-item">Select</option>
							<c:if test="${!empty counters}">
								<c:forEach items="${counters}" var="counter">
									<c:if test="${counter.activeCounterFlag gt 0}">
										<option value="${counter.counterId}~${counter.counterLegacy}" class="lite-text size12">${counter.counterLegacy} - ${counter.counterCaption}</option>
									</c:if>
								</c:forEach>
							</c:if>
					</select>
				</li>
				<!--
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#"> <i class="fa fa-envelope-o"></i>
						<span class="badge badge-sm up bg-purple count">4</span>
					</a>
					<ul class="dropdown-menu extended fadeInUp animated nicescroll"
						tabindex="5001" style="overflow: hidden; outline: none;">
						<li>
							<p>Messages</p>
						</li>
						<li>
							<a href="#"> 
								<!--<span class="pull-left"><img src="img/avatar-2.jpg" class="img-circle thumb-sm m-r-15" alt="img"></span>
									<span class="block"><strong>John smith</strong></span>
									<span class="media-body block">New tasks needs to be done<br>
									<small class="text-muted">10 seconds ago</small></span>
							</a>
						</li>
						<li>
							<a href="#">
								 <!--<span class="pull-left"><img src="img/avatar-3.jpg" class="img-circle thumb-sm m-r-15" alt="img"></span>
									<span class="block"><strong>John smith</strong></span>
									<span class="media-body block">New tasks needs to be done<br>
									<small class="text-muted">3 minutes ago</small></span>
							</a>
						</li>
						<li>
							<a href="#"> 
							<!--<span class="pull-left"><img src="img/avatar-4.jpg" class="img-circle thumb-sm m-r-15" alt="img"></span>
								<span class="block"><strong>John smith</strong></span>
								<span class="media-body block">New tasks needs to be done<br>
								<small class="text-muted">10 minutes ago</small></span>
							</a>
						</li>
						<li>
							<p>
								<a href="inbox.html" class="text-right">See all Messages</a>
							</p>
						</li>
					</ul>
					</li>
					  -->
				<!-- /messages -->
				<!-- Notification -->
				<li class="dropdown"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <i class="fa fa-bell-o"></i>
						<span class="badge badge-sm up bg-pink count">3</span>
				</a>
					<ul class="dropdown-menu extended fadeInUp animated nicescroll"
						tabindex="5002" style="overflow: hidden; outline: none;">
						<li class="noti-header">
							<p>Notifications</p>
						</li>
						<li><a href="#"> <span class="pull-left"><i
									class="fa fa-user-plus fa-2x text-info"></i></span> <span>New
									user registered<br>
								<small class="text-muted">5 minutes ago</small>
							</span>
						</a></li>
						<li><a href="#"> <span class="pull-left"><i
									class="fa fa-diamond fa-2x text-primary"></i></span> <span>Use
									animate.css<br>
								<small class="text-muted">5 minutes ago</small>
							</span>
						</a></li>
						<li><a href="#"> <span class="pull-left"><i
									class="fa fa-bell-o fa-2x text-danger"></i></span> <span>Send
									project demo files to client<br>
								<small class="text-muted">1 hour ago</small>
							</span>
						</a></li>

						<li>
							<p>
								<a href="#" class="text-right">See all notifications</a>
							</p>
						</li>
					</ul></li>
				<!-- /Notification -->

				<!-- user login dropdown start-->
				<li class="dropdown text-center"><a data-toggle="dropdown"
					class="dropdown-toggle" href="#"> <!--<img alt="" src="img/avatar-2.jpg" class="img-circle profile-img thumb-sm">-->
						<span class="username lite-text size12">${loggedUser}</span> <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu pro-menu fadeInUp animated"
						tabindex="5003" style="overflow: hidden; outline: none;">
						<li><a href="profile.html"><i class="fa fa-briefcase"></i>Profile</a></li>
						<li><a href="#"><i class="fa fa-cog"></i> Settings</a></li>
						<li><a href="#"><i class="fa fa-bell"></i> Friends <span
								class="label label-info pull-right mail-info">5</span></a></li>
						<li><a href="#"><i class="fa fa-sign-out"></i> Log Out</a></li>
					</ul></li>
				<!-- user login dropdown end -->
			</ul>
			<!-- End right navbar -->
		</nav>

		<div id="ascrail2000" class="nicescroll-rails"
			style="width: 7px; z-index: 3; cursor: default; position: absolute; top: 0px; left: 23px; height: 327px; display: none;">
			<div
				style="position: relative; top: 0px; float: right; width: 5px; height: 0px; background-color: rgb(157, 158, 165); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 0px;"></div>
		</div>
		<div id="ascrail2000-hr" class="nicescroll-rails"
			style="height: 7px; z-index: 3; top: 320px; left: -250px; position: absolute; cursor: default; display: none;">
			<div
				style="position: relative; top: 0px; height: 5px; width: 0px; background-color: rgb(157, 158, 165); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 0px;"></div>
		</div>
		<div id="ascrail2001" class="nicescroll-rails"
			style="width: 7px; z-index: 3; cursor: default; position: absolute; top: 0px; left: 23px; height: 267px; display: none;">
			<div
				style="position: relative; top: 0px; float: right; width: 5px; height: 0px; background-color: rgb(157, 158, 165); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 0px;"></div>
		</div>
		<div id="ascrail2001-hr" class="nicescroll-rails"
			style="height: 7px; z-index: 3; top: 260px; left: -250px; position: absolute; cursor: default; display: none;">
			<div
				style="position: relative; top: 0px; height: 5px; width: 0px; background-color: rgb(157, 158, 165); border: 1px solid rgb(255, 255, 255); background-clip: padding-box; border-radius: 0px;"></div>
		</div>
	</header>