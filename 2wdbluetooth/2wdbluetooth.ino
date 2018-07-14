#include <QueueArray.h>

/*
aitreasure 2wd smart car, red wire close to uno board
go to visit aitreasure.com to learn more

 */
const int L298nIn1 = 8;//define L298N input 
const int L298nIn2 = 9;
const int L298nIn3 = 10;
const int L298nIn4 = 11;
const int WAIT_TIME = 1000;
const String GO = "g";//define the bluetooth control code value
const String BACK = "b";
const String LEFT = "l";
const String RIGHT = "r";
const String STOP = "a";
QueueArray <char> commandQueue;

void setup()
{
  pinMode(L298nIn1, OUTPUT);
  pinMode(L298nIn2, OUTPUT);
  pinMode(L298nIn3, OUTPUT);
  pinMode(L298nIn4, OUTPUT);
  Serial.begin(9600);
}
void goForward() {//car go forward
  digitalWrite(L298nIn1, HIGH);
  digitalWrite(L298nIn2, LOW);
  digitalWrite(L298nIn3, LOW);
  digitalWrite(L298nIn4, HIGH);
}
void goBack() {//car backward
  digitalWrite(L298nIn1, LOW);
  digitalWrite(L298nIn2, HIGH);
  digitalWrite(L298nIn3, HIGH);
  digitalWrite(L298nIn4, LOW);
}
void goStop() {//car stop
  digitalWrite(L298nIn1, LOW);
  digitalWrite(L298nIn2, LOW);
  digitalWrite(L298nIn3, LOW);
  digitalWrite(L298nIn4, LOW);
}
void turnRight() {//car turn right
  digitalWrite(L298nIn1, HIGH);
  digitalWrite(L298nIn2, LOW);
  digitalWrite(L298nIn3, HIGH);
  digitalWrite(L298nIn4, LOW);
}
void turnLeft() {//car turn left
  digitalWrite(L298nIn1, LOW);
  digitalWrite(L298nIn2, HIGH);
  digitalWrite(L298nIn3, LOW);
  digitalWrite(L298nIn4, HIGH);
}
String readTtl() {
  String comdata = "";
  while (Serial.available())
  {
    comdata += char(Serial.read());
    delay(2);
  }
  return comdata;
}
char getNextChar(String s) { //Gets the next character from the string
	return commandQueue.dequeue();
}
void emptyQueue() {
  while (!commandQueue.isEmpty) {
    commandQueue.dequeue();
  }
}
void loop()//main function
{
  String s = readTtl(); // Read string
  char c = getNextChar(s);
  //Check if string is abort string
  switch (c) {
    case STOP:
      goStop();
      emptyQueue();
    case GO: goForward();
    case BACK: goBack();
    case LEFT: turnLeft();
    case RIGHT: turnRight();
    default: goStop();
  }
  delay(WAIT_TIME);
}
