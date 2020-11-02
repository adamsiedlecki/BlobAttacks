import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class BlobAttacksMain {

    // zadanie https://www.youtube.com/watch?v=6cmDr79htaY&list=PLKmH7u1gA9hr0U59uCEDhr_G2Yn2yV0M5&index=8
    public static void main(String[] args) {

        BigDecimal blobWeight = BigDecimal.TEN;
        BigDecimal ammunitionLeft = new BigDecimal("250000");
        LocalDateTime currentTime = LocalDateTime.of(2018,1,1,12,0);


        while(!currentTime.isEqual(LocalDateTime.of(2018,1,1,15,59))){
            currentTime = currentTime.plusMinutes(1);
            blobWeight = blobWeight.add(blobWeight.multiply(new BigDecimal("0.04")));
        }

        System.out.println("Do przybycia wojska: "+blobWeight);
        //LocalDateTime currentTime = LocalDateTime.of(2018,1,1,16,0);


        while(blobWeight.compareTo(BigDecimal.TEN)>=0){

            // wojsko
            ammunitionLeft = ammunitionLeft.subtract(new BigDecimal("12"));
            blobWeight = blobWeight.subtract(blobWeight.multiply(new BigDecimal("0.82")));
            currentTime = currentTime.plusMinutes(30);

            if(blobWeight.compareTo(BigDecimal.TEN)<0){
                break;
            }
            currentTime = currentTime.plusMinutes(5);

            ///////////////////////// przerwa 5min
            for (int i = 0; i < 5; i++) {
                blobWeight = blobWeight.add(blobWeight.multiply(new BigDecimal("0.04")));

            }
            currentTime = currentTime.plusMinutes(5);

            ///////// policja przez 10 min, nie skutkuje niczym
            ammunitionLeft = ammunitionLeft.subtract(new BigDecimal("1"));
            currentTime = currentTime.plusMinutes(10);

            ////////////// przerwa
            for (int i = 0; i < 10; i++) {
                blobWeight = blobWeight.add(blobWeight.multiply(new BigDecimal("0.04")));


            }
            currentTime = currentTime.plusMinutes(10);

        }
        System.out.println("Blob ma: "+blobWeight.setScale(4, RoundingMode.HALF_UP)+" kg! o czasie "+currentTime+" ; stan amunicji: "+ammunitionLeft+" kg");
        // wynik będzie 23:29

    }


}
