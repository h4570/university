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
    <p>Text: <input type="text" name="11_text" /></p>
    <p><input type="submit" /></p>
  </form>
  <?php 
    $formWasSent = isset($_POST['11_text']);
    $formIsOk = false;
    if($formWasSent){
        $text = $_POST['11_text'];
        $formIsOk = !empty($text) && $text > 0;
    }
    if($formWasSent){
        if($formIsOk){
            $letters = array();
            $addedLetters = 0;
            $isPanagram = true;
            for ($i=0; $i < strlen($text); $i++) {
                $char = strtolower($text[$i]);
                if (preg_match("/^[a-z]$/i", $char)) {
                    if(in_array($char, $letters)){
                        $isPanagram = false; 
                        break;
                    } else $letters[$addedLetters++] = $char;
                }
            }
            echo $isPanagram ? 'This text is a panagram.' : 'This text is NOT a panagram.';
        } else echo 'BŁĄD'; 
    }
  ?>
</body>
</html>
