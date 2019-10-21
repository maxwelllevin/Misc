class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int num_stops = distance.length;
        int dist_forwards = 0;
        int dist_backwrds = 0;
        for (int f = start; f != destination; f = (f + 1) % num_stops) dist_forwards += distance[f];
        for (int b = destination; b != start; b = (b + 1) % num_stops) dist_backwrds += distance[b];
        return Math.min(dist_forwards, dist_backwrds);
    }
}
