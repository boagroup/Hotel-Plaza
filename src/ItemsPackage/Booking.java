package ItemsPackage;

import java.util.Date;

public class Booking extends Item {
    protected Room room;
    protected Guest guest;
    protected Date checkInDate;
    protected Date checkOutDate;
    protected int stayPeriod; // number of days
    protected double cost; // total amount in DKK

    public Booking(Room room, Guest guest) {
        this.room = room;
        this.guest = guest;
        generateTags();
    }

    public Booking(Room room, Guest guest, Date checkInDate) {
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        generateTags();
    }

    public Booking(Room room, Guest guest, Date checkInDate, Date checkOutDate, int stayPeriod, double cost) {
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.stayPeriod = stayPeriod;
        this.cost = cost;
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
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", stayPeriod=" + stayPeriod +
                ", cost=" + cost +
                '}';
    }

    // Getters

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
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

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setStayPeriod(int stayPeriod) {
        this.stayPeriod = stayPeriod;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
