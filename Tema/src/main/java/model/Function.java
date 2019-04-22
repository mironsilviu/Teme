package model;


import model.hotel.Room;

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
