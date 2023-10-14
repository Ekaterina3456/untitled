package ru.gb.lesson5;

import ru.gb.lesson5.models.Reservation;
import ru.gb.lesson5.models.Table;
import ru.gb.lesson5.models.TableModel;
import ru.gb.lesson5.presenters.BookingPresenter;
import ru.gb.lesson5.presenters.Model;
import ru.gb.lesson5.presenters.View;
import ru.gb.lesson5.views.BookingView;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 3, "Станислав");
        view.changeReservationTable(1001, new Date(), 4, "Пётр");
    }
}
