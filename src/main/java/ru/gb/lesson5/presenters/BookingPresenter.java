package ru.gb.lesson5.presenters;

import ru.gb.lesson5.models.Table;
import ru.gb.lesson5.models.TableModel;
import ru.gb.lesson5.views.BookingView;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {

    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */

    private Collection<Table> loadTables() {
        return model.loadTables();
    }

    /**
     * Отобразить список столиков
     */

    public void updateUIShowTables() {
        view.showTables(loadTables());
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер бронирования
     */

    protected void updateUIShowReservationTableResult(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя клиента
     */

    @Override
    public void oneReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int revervationNo = model.reservationTable(orderDate, tableNo, name);
            updateUIShowReservationTableResult(revervationNo);
        }
        catch (RuntimeException e) {
            updateUIShowReservationTableResult(-1);
        }
    }

    @Override
    public void newChangedReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try{
            int reservationNewNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
            updateUIShowReservationTableResult(reservationNewNo);
        }
        catch (RuntimeException e) {
            updateUIShowReservationTableResult(-1);
        }

    }
}
