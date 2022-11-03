import java.util.*;
public class SeeingStarsSimulator {
   public static void main(String[]args)
   {
   double totalOfTrials = 0;
         double fastestTime = 3000;
   for(int a = 0; a < 10000; a++) {
      int sun = 50;
      double totalTime = 0;

      int numSunsFallen = 0;
      double nextSunFromSky = Math.min(9.50, 4.25 + (numSunsFallen * .1)) + (Math.random() * 2.75);
      double sunSkyTime = 0;
      double sunflowerRecharge = 0;
      double starfruitRecharge = 0;
      List<Double> Sunflowers = new ArrayList<>();
      int starfruits = 0;
      while (starfruits < 14) {
       if(sunSkyTime>=nextSunFromSky) {//checking if sun from sky is available
         sun+= 25;
         sunSkyTime = 0;
         numSunsFallen++;
         nextSunFromSky = Math.min(9.50, 4.25 + (numSunsFallen * .1)) + (Math.random() * 2.75);
      }
               for(int i =0;i<Sunflowers.size();i++) {
            if(Sunflowers.get(i) <= 0.0)
            {
                sun += 25;
               Sunflowers.set(i,Math.random()*1.5+23.5);
            }
            Sunflowers.set(i,Sunflowers.get(i) - 0.01);
        }
        if(sun >= 50 && sunflowerRecharge < 0 && Sunflowers.size() < 13) {
        Sunflowers.add(Math.random()*9.5+3);
        sun -= 50;
        sunflowerRecharge = 7.5;
        }
        if(((sun >= 125 && Sunflowers.size() > 11)  || sun >= 175) && starfruitRecharge < 0) {
        starfruits++;
        sun -= 125;
        starfruitRecharge = 7.5;
        }
                totalTime+=0.01;
        sunSkyTime += 0.01;
        starfruitRecharge -= 0.01;
        sunflowerRecharge -= 0.01;
      }
      totalOfTrials += totalTime + 10;
      if(totalTime+10 < fastestTime) {
      fastestTime = totalTime+10;
      }
      }
      System.out.println(totalOfTrials/10000.0);
      System.out.println(fastestTime);
      }
}