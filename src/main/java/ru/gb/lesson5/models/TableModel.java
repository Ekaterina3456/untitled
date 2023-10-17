package ru.gb.lesson5.models;

import ru.gb.lesson5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TableModel implements Model {

    private Collection<Table> tables;

    /**
     * Получить все столки
     *
     * @return
     */

    @Override
    public Collection<Table> loadTables() {
        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         номер столика
     * @param name            Имя
     */

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : loadTables()) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика.");
    }

    /**
     * TODO: Разработать самостоятельно
     * Изменить бронь столика
     * @param oldReservation номер старого резерва (для снятия)
     * @param reservationDate дата резерва столика
     * @param tableNo номер столика
     * @param name Имя
     */

    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        Table oldreserv = new Table();
        Reservation tab = new Reservation(reservationDate, name);
        if (tab.getId() == oldReservation + 1) {
            oldreserv.getReservations().remove(name);
            for (Table table : tables){
                if (table.getNo() == tableNo){
                    table.getReservations().add(tab);
                    return tab.getId();
                }
            }
        }
        throw new RuntimeException("Некорректный номер столика.");
    }
}
