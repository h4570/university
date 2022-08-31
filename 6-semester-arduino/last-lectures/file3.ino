#include <LiquidCrystal.h>

LiquidCrystal lcd(4, 5, 6, 7, 8, 9);
String str = "";
int dane;

void setup()
{
    Serial.begin(9600);
    lcd.begin(16, 2);
    lcd.clear();
}

// 1. Login i hasło w dwóch liniach.
// 2. Po wpisaniu 4 liter przeskakuje do hasło.
// 3. Po wpisaniu 4 liter hasła wyświetla "Zalogowany" na kilka sekund.
// 4. Wraca do 1

void loop()
{
    lcd.clear();

    lcd.setCursor(0, 0);
    lcd.print("Login: ");
    lcd.setCursor(0, 1);
    lcd.print("Haslo: ");

    while (Serial.available() == 0)
    {
    }

    while (Serial.available() > 0)
    {
        str = Serial.readString();
    }

    lcd.setCursor(7, 0);
    lcd.print(str);
    while (Serial.available() == 0)
    {
    }

    while (Serial.available() > 0)
    {
        str = Serial.readString();
    }

    lcd.setCursor(7, 1);
    lcd.print(str);

    delay(5000);

    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print("Zalogowany");

    delay(5000);
}
