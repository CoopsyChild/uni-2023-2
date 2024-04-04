void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  Serial.println("Hello");
  delay(1000);
  for(int i = 0; i < 10; i++) {
    Serial.println("Counter: " + i);
  }
}
