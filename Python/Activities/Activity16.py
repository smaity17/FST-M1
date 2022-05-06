class Car:
    def __init__(self, mfg, model, make, transmission, color):
        self.mfg = mfg
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelarate(self):
        print(f"{self.mfg} {self.model} is moving")
    
    def stop(self):
        print(f"{self.mfg} {self.model} has stopped")
    
car1 = Car("BMW", "Nova", 2017, "Manual", "White")
car2 = Car("Porshe", "Neon", 2018, "Automatic", "Black")
car3 = Car("Dodge", "Viper", 2019, "Automatic", "Green")

car1.accelarate()
car1.stop()
car2.accelarate()
car2.stop()
car3.accelarate()
car3.stop()