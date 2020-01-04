package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        int i,j;
        if ( data [0] == true)
            for (i = 0; i < data.length; i++) {
                if (data[i] == false )
                    result = false;
             }
        if ( data [0] == false)
            for (j = 0; j < data.length; j++) {
                if (data[j] == true )
                    result = false;
        }
        return result;
    }
}
