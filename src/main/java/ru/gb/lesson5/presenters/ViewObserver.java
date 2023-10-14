package ru.gb.lesson5.presenters;

import java.util.Date;

public interface ViewObserver {

    void oneReservationTable(Date orderDate, int tableNo, String name);

    void newChangedReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
