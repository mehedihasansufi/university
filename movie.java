class InvalidSeatException extends Exception{
    public InvalidSeatException(String message){
        super(message);
    }
}
class MovieTheater{
    private boolean[] seats;

    public MovieTheater(int total_seats){
        seats=new boolean[total_seats];
    }
    public void bookSeat(int seatNumber) throws InvalidSeatException{
        if(seatNumber<1 || seatNumber>seats.length){
            throw new InvalidSeatException("Error: Seat number " + seatNumber + " is invalid!");
        }
        if(seats[seatNumber-1]){
            throw new InvalidSeatException("Error: Seat number "+seatNumber+"Seat Already booked");
        }
        seats[seatNumber-1]=true;
        System.out.println("Seat "+seatNumber+" booked Successfully");
    }
}



public class Movie {
    public static void main(String[] args) {
        MovieTheater movieTheater=new MovieTheater(5);
        try{

            movieTheater.bookSeat(3);
            movieTheater.bookSeat(6);
            movieTheater.bookSeat(3);
        }catch (InvalidSeatException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Program continues after exception handling.");

    }
}
