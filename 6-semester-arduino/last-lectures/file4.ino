#include <LiquidCrystal.h>

// LiquidCrystal lcd(4, 5, 6, 7, 8, 9);
// const int MAX_X = 16;
// const int MAX_Y = 2;

String str = "";

void setup()
{
    Serial.begin(9600);

    // lcd.begin(16, 2);
    // lcd.clear();

    // randomSeed(analogRead(0));
}

void loop()
{
    while (Serial.available() == 0)
    {
    }

    while (Serial.available() > 0)
    {
        str = Serial.readString();
    }

    str = "Witaj " + str;

    Serial.println(str);
    
    // lcd.clear();

    // lcd.setCursor(random(0, MAX_X - str.length()), random(0, MAX_Y));
    // lcd.print(str);
    // lcd.setCursor(random(0, MAX_X - str.length()), random(0, MAX_Y));
    // lcd.print(str);

    // delay(1000);
}
