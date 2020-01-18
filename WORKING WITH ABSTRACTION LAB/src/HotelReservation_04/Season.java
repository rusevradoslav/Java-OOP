package HotelReservation_04;

public enum Season {
    Autumn(1), Spring(2), Winter(3), Summer(4);


    private final int seasonIndex;

    Season(int index) {
        this.seasonIndex = index;

    }

    public int getIndex() {
        return this.seasonIndex;
    }
}
