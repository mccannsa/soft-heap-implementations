using namespace std;

#include <math.h>
#include <cmath>
#include <iostream>
#include "Point.h"

Point::Point(int xCoord, int yCoord) {
    x = xCoord;
    y = yCoord;
    double radians = atan2(y,x);
    double degrees = M_PI * radians;
    angle = degrees >= 0 ? degrees : degrees + 360;
}

double Point::distanceFromOrigin() {
    return sqrt((double) (x * x + y * y));
}
