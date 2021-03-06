package ItemsPackage;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Booking extends Item implements Serializable {
    protected Room room;
    protected Guest guest;
    protected LocalDate checkInDate;
    protected LocalDate checkOutDate;
    protected int stayPeriod; // number of days
    protected double cost; // total amount in DKK
    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Booking(){}

    public Booking(Room room, Guest guest) {
        this.room = room;
        this.guest = guest;
        generateTags();
    }

    public Booking(Room room, Guest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

        generateTags();
    }

    public boolean search() {
        return false;
    }

    public void generateTags() {
        this.tag =
                room + " "
                + guest + " "
                + checkInDate + " "
                + checkOutDate + " "
                + stayPeriod + " "
                + cost;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "room=" + room +
                ", guest=" + guest +
                ", checkInDate=" + (checkInDate == null? "null" : checkInDate.format(formatter)) +
                ", checkOutDate=" + (checkOutDate == null? "null" : checkOutDate.format(formatter)) +
                ", stayPeriod=" + stayPeriod +
                ", cost=" + cost +
                '}';
    }

    public boolean edit(Scanner sc) {
        System.out.println("1. Check-in LocalDate: " + (checkInDate==null?"Not chosen!": checkInDate.format(formatter)));
        System.out.println("2. Check-out LocalDate: " + (checkOutDate==null?"Not chosen!": checkOutDate.format(formatter)));
        System.out.println("3 Go back");
        switch (sc.nextLine()) {
            case "1":
                    try {
                        System.out.println("Please enter the Check-in LocalDate: ");
                        checkInDate = LocalDate.parse(sc.nextLine(),formatter);
                        if (checkOutDate != null) {
                            if (checkInDate.isAfter(checkOutDate)) {
                                checkInDate = null;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Incorrect Date Format!");
                    }
                break;
            case "2":
                    try {
                        System.out.println("Please enter the Check-out LocalDate: ");
                        checkOutDate = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        if (checkInDate != null) {
                            if (checkOutDate.isBefore(checkInDate)) {
                                checkOutDate = null;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Incorrect Date Format!");
                    }
                break;
            default:
                return false;
        }
        return true;
    }
    // Getters

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getStayPeriod() {
        return stayPeriod;
    }

    public double getCost() {
        return cost;
    }

    // Setters

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setStayPeriod(int stayPeriod) {
        this.stayPeriod = stayPeriod;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
