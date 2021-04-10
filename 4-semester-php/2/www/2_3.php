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
$isStep1Completed = isset($_POST['2_action']) && $_POST['2_action'] == 'Set number of people';
$isStep2Completed = isset($_POST['2_action']) && $_POST['2_action'] == 'Send';

if ($isStep1Completed) {
    $numberOfPeople = $_POST['2_number_of_people'];
    echo '<input type="number" name="2_number_of_people" hidden value="' . $numberOfPeople . '" />';
    for ($i = 0; $i < $numberOfPeople; $i++) {
        $prsNumber = $i + 1;
        echo '<h3> Person ' . $prsNumber . '</h3>';
        echo '<input type="text" name="2_' . $i . '_firstName" placeholder="First name" required/><br />';
        echo '<input type="text" name="2_' . $i . '_lastName" placeholder="Last name" required/><br />';
        echo '<input type="text" name="2_' . $i . '_address" placeholder="Address" required/><br />';
        echo '<input type="tel" name="2_' . $i . '_creditCard" id="ccn" inputmode="numeric" pattern="[0-9\s]{13,19}" autocomplete="cc-number" maxlength="19" placeholder="xxxx xxxx xxxx xxxx" required/><br />';
        echo '<input type="email" name="2_' . $i . '_email" placeholder="Email" required/><br />';
        echo '<input type="date" name="2_' . $i . '_startDate" placeholder="Start date" required/><br />';
        echo '<input type="time" name="2_' . $i . '_startTime" placeholder="Start time" required/><br />';
        echo 'Extra bed?: <input type="checkbox" name="2_' . $i . '_extraBed" /><br />';
        echo 'Air conditioning?: <input type="checkbox" name="2_' . $i . '_airConditioning" /><br />';
        echo 'Ashtray?: <input type="checkbox" name="2_' . $i . '_ashTray" /><br />';
    }
    echo '<br />
<input type="submit" name="2_action" value="Send" />
';
} else if ($isStep2Completed) {
    $numberOfPeople = $_POST['2_number_of_people'];
    for ($i = 0; $i < $numberOfPeople; $i++) {
        echo '<h3> Person: ' .
            $_POST['2_' . $i . '_firstName']
            . ' ' .
            $_POST['2_' . $i . '_lastName']
            . '</h3>';

        echo 'Address: ' . $_POST['2_' . $i . '_address'] . '<br />';
        echo 'Credit card: ' . $_POST['2_' . $i . '_creditCard'] . '<br />';
        echo 'Email: ' . $_POST['2_' . $i . '_email'] . '<br />';
        echo 'Start: ' . $_POST['2_' . $i . '_startDate'] . ' ' . $_POST['2_' . $i . '_startTime'] . '<br />';
        if (isset($_POST['2_' . $i . '_extraBed'])) {
            echo 'Extra bed?: Yes<br />';
        } else {
            echo 'Extra bed?: No<br />';
        }
        if (isset($_POST['2_' . $i . '_airConditioning'])) {
            echo 'Air conditioning?: Yes<br />';
        } else {
            echo 'Air conditioning?: No<br />';
        }
        if (isset($_POST['2_' . $i . '_ashTray'])) {
            echo 'Ash tray?: Yes<br />';
        } else {
            echo 'Ash tray?: No<br />';
        }
    }
} else {
    echo 'People:
    <select name="2_number_of_people">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
    </select>
    <br />
    <input type="submit" name="2_action" value="Set number of people" />
        ';
}
?>
</body>

</html>