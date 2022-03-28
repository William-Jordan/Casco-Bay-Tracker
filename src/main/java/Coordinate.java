public class Coordinate {
    private Double latitude, longitude;

    public Coordinate(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int[] getPixels(int x, int y, double n, double s, double e, double w){
        int px = x - (int) Math.round( (longitude-w) / (e-w) * x);
        int py = y - (int) Math.round( (latitude-s) / (n-s) * y);
        return new int[]{px, py};
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
