import math

class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        radians = math.atan2(y,x)
        degrees = math.pi * radians
        angle = math.nan
        if degrees >= 0:
            angle = degrees
        else:
            angle = degrees + 360
        self.angle = angle

    def distance_from_origin(self):
        return math.sqrt(self.x * self.x + self.y * self.y)

    def __lt__(self, other):
        if self.angle == other.angle:
            return self.distance_from_origin() < other.distance_from_origin()
        else:
            return self.angle < other.angle

    def __gt__(self, other):
        if self.angle == other.angle:
            return self.distance_from_origin() > other.distance_from_origin()
        else:
            return self.angle > other.angle
    
    def __le__(self, other):
        if self.angle == other.angle:
            return self.distance_from_origin() <= other.distance_from_origin()
        else:
            return self.angle <= other.angle
    
    def __ge__(self, other):
        if self.angle == other.angle:
            return self.distance_from_origin() >= other.distance_from_origin()
        else:
            return self.angle >= other.angle
    
    def __eq__(self, other):
        return self.angle == other.angle and self.distance_from_origin() == other.distance_from_origin()
    
    def __ne__(self, other):
        return self.angle != other.angle or self.distance_from_origin() != other.distance_from_origin()
    