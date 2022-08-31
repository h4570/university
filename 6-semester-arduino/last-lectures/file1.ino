/* Ping))) Sensor

   This sketch reads a PING))) ultrasonic rangefinder and returns the
   distance to the closest object in range. To do this, it sends a pulse
   to the sensor to initiate a reading, then listens for a pulse
   to return.  The length of the returning pulse is proportional to
   the distance of the object from the sensor.

   The circuit:
    * +V connection of the PING))) attached to +5V
    * GND connection of the PING))) attached to ground
    * SIG connection of the PING))) attached to digital pin 7

   http://www.arduino.cc/en/Tutorial/Ping

   created 3 Nov 2008
   by David A. Mellis
   modified 30 Aug 2011
   by Tom Igoe

   This example code is in the public domain.

 */

// this constant won't change.  It's the pin number
// of the sensor's output:
const int trig = 11;
const int echo = 8;
const int ledPin = 13;

void setup()
{
    // initialize serial communication:
    Serial.begin(9600);
    pinMode(echo, INPUT);
    pinMode(trig, OUTPUT);
    pinMode(ledPin, OUTPUT);
}

void loop()
{
    // establish variables for duration of the ping,
    // and the distance result in inches and centimeters:
    long duration, cm;

    // The PING))) is triggered by a HIGH pulse of 2 or more microseconds.
    // Give a short LOW pulse beforehand to ensure a clean HIGH pulse:
    digitalWrite(trig, LOW);
    delayMicroseconds(2);
    digitalWrite(trig, HIGH);
    delayMicroseconds(5);
    digitalWrite(trig, LOW);

    // The same pin is used to read the signal from the PING))): a HIGH
    // pulse whose duration is the time (in microseconds) from the sending
    // of the ping to the reception of its echo off of an object.
    //  pinMode(pingPin, INPUT);
    duration = pulseIn(echo, HIGH);

    // convert the time into a distance
    cm = microsecondsToCentimeters(duration);

    // Print the distance
    Serial.print("Distance: ");
    Serial.print(cm);
    Serial.print("cm");
    Serial.println();

    // Turn on the LED if the object is too close:
    if (cm < 50)
    {
        digitalWrite(ledPin, HIGH);
    }
    else
    {
        digitalWrite(ledPin, LOW);
    }

    delay(100);
}

long microsecondsToCentimeters(long microseconds)
{
    // The speed of sound is 340 m/s or 29 microseconds per centimeter.
    // The ping travels out and back, so to find the distance of the
    // object we take half of the distance travelled.
    return microseconds / 29 / 2;
}
