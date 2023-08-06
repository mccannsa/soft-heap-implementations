class Point {
    private:
        int x;
        int y;
        double angle;

    public:
        Point(int xCoord, int yCoord);
        double distanceFromOrigin();
        bool operator == (Point &obj) {
            return angle == obj.angle && distanceFromOrigin() == obj.distanceFromOrigin();
        }

        bool operator != (Point &obj) {
            return angle != obj.angle || distanceFromOrigin() != obj.distanceFromOrigin();
        }

        bool operator < (Point &obj) {
            if (angle == obj.angle) {
                return distanceFromOrigin() < obj.distanceFromOrigin();
            } else {
                return angle < obj.angle;
            }
        }

        bool operator > (Point &obj) {
            if (angle == obj.angle) {
                return distanceFromOrigin() > obj.distanceFromOrigin();
            } else {
                return angle > obj.angle;
            }
        }

        bool operator <= (Point &obj) {
            if (angle == obj.angle) {
                return distanceFromOrigin() <= obj.distanceFromOrigin();
            } else {
                return angle <= obj.angle;
            }
        }

        bool operator >= (Point &obj) {
            if (angle == obj.angle) {
                return distanceFromOrigin() >= obj.distanceFromOrigin();
            } else {
                return angle >= obj.angle;
            }
        }
};