#include <Wire.h>

int x = 0;

void setup()
{
    Wire.begin();
}

void loop()
{
    Wire.beginTransmission(9);
    Wire.write(x);
    Wire.endTransmission();

    x++;
    if (x > 6)
    {
        x = 0;
    }
    delay(200);
}
