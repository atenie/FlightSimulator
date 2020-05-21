package flightSim;

public class Lookups {
    private static String[] flyables = {"Jetplane", "Helicopter", "Balloon"};
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private static String[][] msg = {
            {
                    "Jet,  SUN ",
                    "Jet,  RAIN",
                    "Jet,  FOG ",
                    "Jet,  SNOW"
            },
            {
                    "Heli, SUN ",
                    "Heli, RAIN",
                    "Heli, FOG ",
                    "Heli, SNOW"
            },
            {
                    "Ball, SUN ",
                    "Ball, RAIN",
                    "Ball, FOG ",
                    "Ball, SNOW"
            }
    };

    private static int[][][] coords = {
            {
                    {0, 10, 2},
                    {0, 5, 0},
                    {0, 1, 0},
                    {0, 0, -7}
            },
            {
                    {10, 0, 2},
                    {5, 0, 0},
                    {1, 0, 0},
                    {0, 0, -12}
            },
            {
                    {2, 0, 4},
                    {0, 0, -5},
                    {0, 0, -3},
                    {0, 0, -15}
            }
    };

    private static int indexOf(String[] arr, String e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public static int getLongitude(String f, String w) {
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return coords[i][j][0];
    }

    public static int getLatitude(String f, String w) {
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return coords[i][j][1];
    }

    public static int getHeight(String f, String w) {
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return coords[i][j][2];
    }

    public static String getMessage(String f, String w) {
        int i = indexOf(flyables, f);
        int j = indexOf(weather, w);
        return msg[i][j];
    }
}