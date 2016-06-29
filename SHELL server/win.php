<html>
<body>


<?php
if (isset($_GET['bet']) and isset($_GET['shellNo']) and isset($_GET['amountShells']) and isset($_GET['amountBalls']) and isset($_GET['money']) ){

$bet = $_GET['bet'];
$shellNo = $_GET['shellNo'];
$amountShells =$_GET['amountShells'];
$amountBalls =$_GET['amountBalls'];
$Money=$_GET['money'];
$NewMoney=0;
$houseEdge=0.02;
$wins =array();
$Money;


$multiplicator = (1-$houseEdge)/($amountBalls/$amountShells);
$possibleWin=$bet*$multiplicator;

//Generate Secret:
$i =0;
while ($i <$amountShells) {
$wins[$i]=FALSE;
$i++;
}

$i=0;
while ($i<$amountBalls) {

  $rand =rand(0, $amountShells-1);
  if ($wins[$rand]) {
  while ($wins[$rand]) {
    $rand=rand(0,$amountShells-1);

  } }

$wins[$rand]=TRUE;
$i++;
}

//Hashing:
/**
 *
$toHash='';
foreach ($wins as $bool) {
$toHash=$toHash.$bool;
}
$salt=str_pad(rand(0, pow(10, 20)-1), 20, '0', STR_PAD_LEFT);
$toHash=(string)($toHash.' '.$salt);
echo ($hash=hash ( (string)$algo="sha256" ,(string)$toHash [$raw_output = FALSE ] )).'<br>';
*/
 if($wins[$shellNo-1]){

   $NewMoney=($Money-$bet)+($bet*$multiplicator);
   echo 'You won <b>' . $possibleWin .'</b>. <br>';
 } else {
   $NewMoney=$Money-$bet;
   echo "You lost <b>$bet</b>.<br>";
 }




echo 'The ball was in Shell ' ;
$i=0;
while ($i<$amountShells) {
  if ($wins[$i]) {
    echo '<b>'. $i+1 .'</b> ' ;
  }
$i++;
}
echo '<br>';

echo "Money:<b> $NewMoney</b><br>";

} else {
  echo 'Some variable is not set!<br>';
}
?>

<a href="./placebet.php?money=<?php echo $NewMoney ?>"> New Game</a>

</body>
</html>
