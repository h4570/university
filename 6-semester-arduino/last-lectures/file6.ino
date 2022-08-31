#include <IRremote.h>

// biblioteka
#define receiverpin 2
// pin Arduino, do którego został podłączony odbiornik IR\

IRrecv irrecv(receiverpin);
decode_results results;

void setup()
{
	Serial.begin(9600);
	irrecv.enableIRIn(); // uruchamia odbiornik podczerwieni
}

void loop()
{
	// sprawdza, czy otrzymano sygnał IR
	if (irrecv.decode(&results))
	{
		Serial.print(results.value);
		Serial.println(" ");
		irrecv.resume(); // odbiera następną wartość
		delay(100);
	}
}

// 1 -> 16582903
// 0 -> 16593103