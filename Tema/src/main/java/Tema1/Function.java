package Tema1;

import Tema1.Hotel.Hotel;
import Tema1.Hotel.Room;

import java.util.ArrayList;
import java.util.List;

public class Function {

    public static int[] freeRooms(Room aRoom) {


        int nDouble = aRoom.getNumberOfDoubleRoom();
        int nTriple = aRoom.getNumberOfTripleRoom();


        int[] freeRoom;
        freeRoom = new int[nDouble + nTriple];

        for (int i = 0; i < nDouble; i++) {
            freeRoom[i] = 2;
        }
        for (int i = nDouble; i < nDouble + nTriple; i++) {
            freeRoom[i] = 3;
        }

        return freeRoom;

    }


}
