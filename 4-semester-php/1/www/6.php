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
    <p>A: <input type="number" name="6_a" /></p>
    <p>B: <input type="number" name="6_b" /></p>
    <p>C: <input type="number" name="6_c" /></p>
    <p><input type="submit" /></p>
  </form>
  <?php 
    $formWasSent = isset($_POST['6_a']) && isset($_POST['6_b']) && isset($_POST['6_c']);
    $formIsOk = false;
    if($formWasSent){
        $a = $_POST['6_a'];
        $b = $_POST['6_b'];
        $c = $_POST['6_c'];
        $formIsOk = !empty($a) && !empty($b) && !empty($c) && $a > 0 && $b > 0 && $c > 0;
    }
    if($formWasSent){
        if($formIsOk){
            if($a+$b>$c && $a+$c>$b && $b+$c>$a)
                echo 'You can compute triangle from these values.'; 
            else
                echo 'You CAN\'T compute triangle from these values.'; 
        } else echo 'BŁĄD'; 
    }
    
  ?>
</body>
</html>
