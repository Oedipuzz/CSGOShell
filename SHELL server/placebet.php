<html>
<body>
<?php
$Money=$_GET['money'];
echo '<b>Your Money: </b>'.$Money;
 ?>
<form action="win.php" method="GET">
<b>Number of Shells: </b><input type="number" size="5" name="amountShells"><br>
<b>Number of Balls: </b><input type="number" size="5" name="amountBalls"><br>
<b>Money Bet: </b><input type="number" size="5" name="bet"><br>
<b>Shell Bet: </b><input type="number" size="5" name="shellNo"><br>
<input type="number" size="5" name="money" value="<?php echo $Money ?>"><br>
  <input type="submit" value="Submit form">
</form>



</body>
</html>
