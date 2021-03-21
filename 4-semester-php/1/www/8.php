<?php include 'uri.php'; ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
  <form action="<?php echo $URI; ?>" method="post">
    <p>A: <input type="number" name="8_a" /></p>
    <p>B: <input type="number" name="8_b" /></p>
    <p>C: <input type="number" name="8_c" /></p>
    <p><input type="submit" /></p>
  </form>
  <?php 
    function swap(&$x, &$y) {
        $tmp = $x;
        $x = $y;
        $y = $tmp;
    }
    $formWasSent = isset($_POST['8_a']) && isset($_POST['8_b']) && isset($_POST['8_c']);
    $formIsOk = false;
    if($formWasSent){
        $a = $_POST['8_a'];
        $b = $_POST['8_b'];
        $c = $_POST['8_c'];
        $formIsOk = !empty($a) && !empty($b) && !empty($c) && $a > 0 && $b > 0 && $c > 0;
    }
    if($formWasSent){
        if($formIsOk){
            if ($a > $b) swap($a, $b);
            if ($b > $c) swap($b, $c);
            if ($a > $b) swap($a, $b);
            echo $a.' '.$b.' '.$c;
            echo $c.' '.$b.' '.$a;
        } else echo 'BŁĄD'; 
    }
    
  ?>
</body>
</html>
