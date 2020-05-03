<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Start page</title>
</head>
<body>
	<h3>Client information:</h3>
	<form action="client" method="get">
		<p>
			id: <input type="text" name='id' size='20' />
		</p>
		<p>
			Name: <input type="text" name='name' size='20' />
		</p>
		<p>
			Surname: <input type="text" name='surname' size='20' />
		</p>
		<p>
			Date of birth: <input type="text" name='day_of_birth' size='20' />
		</p>
		<input type='submit' name="show" value='show my current data' />
	</form>
	
<!-- 	<form action="" method="">
	<input type='submit' name="set" value="set my data" />
	</form> -->
	
	
<!-- 	<h2>Actions:</h2>
	<p>
	<input type='submit' value='withdraw cash' />
	</p>
	
	<input type='submit' value='open client account' />
	<input type='submit' value='block client account' /> -->
	
	<a href="/MainWeb">Logout</a>
	
</body>
</html>