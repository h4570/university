const int fotoPin = A1;
const int ledPin = 9;
const int buzzerPin = 8;

uint8_t buzzerState = false;
uint8_t ledState = false;

void setup()
{
	pinMode(ledPin, OUTPUT);
	pinMode(buzzerPin, OUTPUT);
	pinMode(fotoPin, INPUT);
	Serial.begin(9600);
}

void showLed()
{
	if (ledState)
		digitalWrite(ledPin, 100);
	else
		digitalWrite(ledPin, 0);
}

void turnBuzzer()
{
	if (buzzerState)
		digitalWrite(buzzerPin, 100);
	else
		digitalWrite(buzzerPin, 0);
}

void loop()
{
	float fotoRes = analogRead(fotoPin);

	if (fotoRes >= 20)
	{
		ledState = false;
		buzzerState = true;
	}
	else
	{
		ledState = true;
		buzzerState = false;
	}

	turnBuzzer();
	showLed();

	Serial.print("Swiatlo: ");
	Serial.println(fotoRes);

	delay(100);
}