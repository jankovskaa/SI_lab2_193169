import java.util.*;
public class SILab2 {

    public static List<Integer> function(List<Time> timesList) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < timesList.size(); i++) { // a
            int hr = timesList.get(i).getHours();
            int min = timesList.get(i).getMinutes();
            int sec = timesList.get(i).getSeconds();
            if (hr < 0 || hr > 24){ // b
                if (hr < 0){ // c
                    throw new RuntimeException("The hours are smaller than the minimum"); //d
                }
                else {
                    throw new RuntimeException("The hours are grater than the maximum"); //e
                }
            }
            else if (hr < 24) { // f
                if (min < 0 || min > 59) //g
                    throw new RuntimeException("The minutes are not valid!"); //h
                else { // i
                    if (sec >= 0 && sec <= 59) // j
                        result.add(hr * 3600 + min * 60 + sec); // k
                    else // l
                        throw new RuntimeException("The seconds are not valid");
                }
            }
            else if (hr == 24 && min == 0 && sec == 0) { // m
                result.add(hr * 3600 + min * 60 + sec); // n
            }
            else { // o
                throw new RuntimeException("The time is greater than the maximum");
            }
        }
        return result; // p
    } // q
}
