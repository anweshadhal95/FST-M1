class car:
    def __init__(self,manufacturer,model,make,transmission,color):
        self.manufacturer=manufacturer
        self.model=model
        self.make=make
        self.transmission=transmission
        self.color=color
    def accelerate(self):
        print(self.manufacturer+" "+self.model+ " is moving")
    def stop(self):
        print(self.manufacturer+" "+self.model+ " has stopped")

p1=car("BMW","320d","2022","Automatic","Black")
p2=car("Mercedes","E250","2021","Automatic","White")
p3=car("Audi","A4","2020","Manual","Red")
p1.accelerate()
p2.accelerate()
p3.accelerate()
p1.stop()
p2.stop()
p3.stop()