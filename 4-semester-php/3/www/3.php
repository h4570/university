<?php include 'uri.php';?>
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
$isLoad = isset($_POST['3_action']) && $_POST['3_action'] == 'Load';
$isStep1Completed = isset($_POST['3_action']) && $_POST['3_action'] == 'Set number of people';
$isStep2Completed = isset($_POST['3_action']) && $_POST['3_action'] == 'Send';

if ($isLoad) {
    $file = fopen("3.csv", "r");
    if (!$file) {
        echo "Cant open CSV file. File not found?";
    } else {
        echo "Saved data:<br />";
        while ($data = fgetcsv($file, 1000, ",")) {
            for ($i = 0; $i < count($data); $i++) {
                echo $data[$i] . "<br />\n";
            }
        }
        fclose($file);
    }
} else if ($isStep1Completed) {
    $numberOfPeople = $_POST['3_number_of_people'];
    echo '<input type="number" name="3_number_of_people" hidden value="' . $numberOfPeople . '" />';
    for ($i = 0; $i < $numberOfPeople; $i++) {
        $prsNumber = $i + 1;
        echo '<h3> Person ' . $prsNumber . '</h3>';
        echo '<input type="text" name="3_' . $i . '_firstName" placeholder="First name" required/><br />';
        echo '<input type="text" name="3_' . $i . '_lastName" placeholder="Last name" required/><br />';
        echo '<input type="text" name="3_' . $i . '_address" placeholder="Address" required/><br />';
        echo '<input type="tel" name="3_' . $i . '_creditCard" id="ccn" inputmode="numeric" pattern="[0-9\s]{13,19}" autocomplete="cc-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx" required/><br />';
        echo '<input type="email" name="3_' . $i . '_email" placeholder="Email" required/><br />';
        echo '<input type="date" name="3_' . $i . '_startDate" placeholder="Start date" required/><br />';
        echo '<input type="time" name="3_' . $i . '_startTime" placeholder="Start time" required/><br />';
        echo 'Extra bed?: <input type="checkbox" name="3_' . $i . '_extraBed" /><br />';
        echo 'Air conditioning?: <input type="checkbox" name="3_' . $i . '_airConditioning" /><br />';
        echo 'Ashtray?: <input type="checkbox" name="3_' . $i . '_ashTray" /><br />';
    }
    echo '<br />
<input type="submit" name="3_action" value="Send" />
';
} else if ($isStep2Completed) {
    $numberOfPeople = $_POST['3_number_of_people'];
    for ($i = 0; $i < $numberOfPeople; $i++) {
        echo '<h3> Person: ' .
            $_POST['3_' . $i . '_firstName']
            . ' ' .
            $_POST['3_' . $i . '_lastName']
            . '</h3>';

        $address = $_POST['3_' . $i . '_address'];
        $creditCard = $_POST['3_' . $i . '_creditCard'];
        $email = $_POST['3_' . $i . '_email'];
        $startDate = $_POST['3_' . $i . '_startDate'];
        $startTime = $_POST['3_' . $i . '_startTime'];
        $extraBed = false;
        $airConditioning = false;
        $ashTray = false;
        echo 'Address: ' . $address . '<br />';
        echo 'Credit card: ' . $creditCard . '<br />';
        echo 'Email: ' . $email . '<br />';
        echo 'Start: ' . $startDate . ' ' . $startTime . '<br />';
        if (isset($_POST['3_' . $i . '_extraBed'])) {
            $extraBed = $_POST['3_' . $i . '_extraBed'];
            echo 'Extra bed?: Yes<br />';
        } else {
            echo 'Extra bed?: No<br />';
        }
        if (isset($_POST['3_' . $i . '_airConditioning'])) {
            $airConditioning = $_POST['3_' . $i . '_airConditioning'];
            echo 'Air conditioning?: Yes<br />';
        } else {
            echo 'Air conditioning?: No<br />';
        }
        if (isset($_POST['3_' . $i . '_ashTray'])) {
            $ashTray = $_POST['3_' . $i . '_ashTray'];
            echo 'Ash tray?: Yes<br />';
        } else {
            echo 'Ash tray?: No<br />';
        }

        // Save in csv
        if (file_put_contents('3.csv',
            $address . ";" . $creditCard . ";" . $email . ";" . $startDate . ";" .
            $startTime . ";" . $extraBed . ";" . $airConditioning . ";" . $ashTray . ";"
            . "\n",
            FILE_APPEND)) {
            echo "File saved successfully.";
        } else {
            echo "There was a problem with file saving.. Permissions?";
        }
    }
} else {
    echo 'People:
    <select name="3_number_of_people">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select>
    <br />
    <input type="submit" name="3_action" value="Set number of people" />
    <input type="submit" name="3_action" value="Load" />
        ';
}
?>
</body>

</html>