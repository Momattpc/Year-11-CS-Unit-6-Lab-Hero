public class Hero {
    private final String name;
    private int hitPoints;

    private String winner = "";

    public Hero(String name){
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName(){
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }
   @Override
    public String toString(){
        return "Hero{name='" + getName() + "', hitPoints=" + getHitPoints() + "}";
   }
   public void attack(Hero opps){
        double RNG = Math.random();
        if (RNG < 0.5){
            opps.hitPoints -=10;
        }
        else {
            hitPoints -=10;
        }
   }
   public void senzuBean(){
        hitPoints = 100;
   }
   private void fightUntilTheDeathHelper(Hero opps){
        while (opps.hitPoints != 0 && hitPoints > 0 || hitPoints != 0 && opps.hitPoints > 0) {
            attack(opps);
        }
   }
   public String fightUntilTheDeath(Hero opps){
        senzuBean();
        opps.senzuBean();
        fightUntilTheDeathHelper(opps);

        return getName() + " : " + getHitPoints() + opps.getName() + " : " + opps.getHitPoints();
   }
   private int[] nFightsToTheDeathHelper(Hero opps, int n){
        int heroWins = 0;
        int oppWins = 0;

        int[] wins = new int[2];
        while (n > 0){
            senzuBean();
            opps.senzuBean();
            fightUntilTheDeath(opps);
            if (hitPoints == 0){
                oppWins++;
            }
            else {
                heroWins++;
            }
            n-=1;


        }
       senzuBean();
       opps.senzuBean();
        if (oppWins > heroWins){
            winner = opps.getName() + "wins!";
        }
        else if (oppWins < heroWins){
            winner = getName() + "wins!";
        }
        else if (oppWins == heroWins){
            winner = "OMG! It was actually a draw!";
       }
        wins[0] = heroWins;
        wins[1] = oppWins;
    return wins;

   }
   public String nFightsToTheDeath(Hero opps, int n){
       int[] wins = nFightsToTheDeathHelper(opps, n);
       senzuBean();
       opps.senzuBean();
        return getName() + " : " + wins[0] + " wins" + "\n" + opps.getName() + " : " + wins[1] + " wins " + "\n" + winner;
   }
   public void dramaticFightToTheDeath(Hero opps) throws InterruptedException {
        while (opps.hitPoints != 0 && hitPoints > 0 || hitPoints != 0 && opps.hitPoints > 0) {
           attack(opps);
           Thread.sleep(1000);
           toString();
       }


   }

}
