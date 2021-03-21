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
    <p>Size: <input type="number" name="10_size" /></p>
    <p><input type="submit" /></p>
  </form>
  <?php 
    $formWasSent = isset($_POST['10_size']);
    $formIsOk = false;
    if($formWasSent){
        $size = $_POST['10_size'];
        $formIsOk = !empty($size) && $size > 0;
    }
    if($formWasSent){
        if($formIsOk){
            foreach (range(1, $size) as $i) {
                foreach (range(1, $i) as $j) 
                    echo '*';
                echo '<br/>';
            }
            for($i=$size;$i>0;$i--){
                for($j=$i;$j>0;$j--)
                    echo '*';
                echo '<br/>';
            }
            echo '<br />';
            foreach (range(1, $size) as $i) {
                for($j=1;$j<$i;$j++)
                    echo '&nbsp;';
                foreach (range($i, $size) as $j) 
                    echo '*';
                echo '<br/>';
            }
            for($i=$size;$i>0;$i--){
                for($j=$i;$j>1;$j--)
                    echo '&nbsp;';
                for($j=$i;$j<$size;$j++)
                    echo '*'; 
                echo '*<br/>';
            }
        } else echo 'BŁĄD'; 
    }
  ?>
</body>
</html>
