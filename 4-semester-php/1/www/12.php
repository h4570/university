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
        if(!isset($_POST['12_a']) && !isset($_POST['12_b'])){
            echo '<p>A: <input type="number" name="12_a" /></p>';
            echo '<p>B: <input type="number" name="12_b" /></p>';
        } else {
            echo '<input type="number" hidden name="12_a_size" value="'.$_POST['12_a'].'" />';
            echo '<input type="number" hidden name="12_b_size" value="'.$_POST['12_b'].'" />';
            for ($i=0; $i < $_POST['12_a']; $i++) 
                for ($j=0; $j < $_POST['12_b']; $j++) 
                    echo '<p>'.$i.$j.': <input type="number" name="12_'.$i.$j.'" /></p>';
        }
    ?>
    <p><input type="submit" /></p>
  </form>
  <?php 
    function transpose($array) {
        return array_map(null, ...$array);
    }
    $formWasSent = isset($_POST['12_a_size']) && isset($_POST['12_b_size']);
    $formIsOk = false;
    if($formWasSent){
        $aSize = $_POST['12_a_size'];
        $bSize = $_POST['12_b_size'];
        $formIsOk = !empty($aSize) && !empty($bSize) && $aSize > 0 && $bSize > 0;
        $array = [];
        for ($i=0; $i < $aSize; $i++){
            $array[$i] = [];
            for ($j=0; $j < $bSize; $j++){
                $formIsOk = $formIsOk && !empty($_POST['12_'.$i.$j]);
                if(!$formIsOk) break;
                $array[$i][$j] = $_POST['12_'.$i.$j];
            }
        }
        
    }
    if($formWasSent){
        if($formIsOk){
            echo 'Original: <br/>';
            for($i=0;$i<count($array);$i++){
                for($j=0;$j<count($array[$i]);$j++)
                    echo $array[$i][$j].' ';
                echo '<br/>';
            }
            echo 'Transposed: <br/>';
            $transposed = transpose($array);
            for($i=0;$i<count($transposed);$i++){
                for($j=0;$j<count($transposed[$i]);$j++)
                    echo $transposed[$i][$j].' ';
                echo '<br/>';
            }

        } else echo 'BŁĄD'; 
    }
  ?>
</body>
</html>
