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
  <?php 
        if(!isset($_POST['9_a']) && !isset($_POST['9_b'])){
            echo '<p>A: <input type="number" name="9_a" /></p>';
            echo '<p>B: <input type="number" name="9_b" /></p>';
        } else {
            echo '<input type="number" hidden name="9_a_size" value="'.$_POST['9_a'].'" />';
            echo '<input type="number" hidden name="9_b_size" value="'.$_POST['9_b'].'" />';
            for ($i=0; $i < $_POST['9_a']; $i++) 
                echo '<p>A'.$i.': <input type="number" name="9_a'.$i.'" /></p>';
            for ($i=0; $i < $_POST['9_b']; $i++) 
                echo '<p>B'.$i.': <input type="number" name="9_b'.$i.'" /></p>';
        }
    ?>
    <p><input type="submit" /></p>
  </form>
  <?php 
    $formWasSent = isset($_POST['9_a_size']) && isset($_POST['9_b_size']);
    $formIsOk = false;
    $arr1 = [];
    $arr2 = [];
    if($formWasSent){
        $aSize = $_POST['9_a_size'];
        $bSize = $_POST['9_b_size'];
        $formIsOk = !empty($aSize) && !empty($bSize) && $aSize > 0 && $bSize > 0;
        for ($i=0; $i < $aSize; $i++){
            $formIsOk = $formIsOk && !empty($_POST['9_a'.$i]);
            if(!$formIsOk) break;
            $arr1[$i] = $_POST['9_a'.$i];
        }
        for ($i=0; $i < $bSize; $i++){
            $formIsOk = $formIsOk && !empty($_POST['9_b'.$i]);
            if(!$formIsOk) break;
            $arr2[$i] = $_POST['9_b'.$i];
        }
    }
    if($formWasSent){
        if($formIsOk){
            $res = 0;
            $skipped = 0;
            $arrLength = count($arr2);
            if(count($arr1) > count($arr2)){
                $skipped = count($arr1) - count($arr2);
                $arrLength = count($arr2);
            }
            if(count($arr2) > count($arr1)){
                $skipped = count($arr2) - count($arr1);
                $arrLength = count($arr1);
            }
            foreach (range(0, $arrLength-1) as $i) 
                $res += $arr1[$i] * $arr2[$i];
            echo 'Result is: '.$res.'<br/>';
            if($skipped > 0)
                echo 'Skipped: '.$skipped;
        } else echo 'BŁĄD'; 
    }
    
  ?>
</body>
</html>
