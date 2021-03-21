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
    <p>Miesiąc: <input type="number" name="7_month" /></p>
    <p><input type="submit" /></p>
  </form>
  <?php 
    $formWasSent = isset($_POST['7_month']);
    $formIsOk = false;
    if($formWasSent){
        $month = $_POST['7_month'];
        $formIsOk = !empty($month) && $month > 0 && $month < 13;
    }
    if($formWasSent){
        if($formIsOk){
            switch($month){
                case 2: echo 28; break;
                case 4: 
                case 6: 
                case 9: 
                case 11: echo 30; break;
                case 1: 
                case 3: 
                case 5: 
                case 7: 
                case 8: 
                case 10: 
                case 12: echo 31; break;
            }
        } else echo 'BŁĄD'; 
    }
    
  ?>
</body>
</html>
