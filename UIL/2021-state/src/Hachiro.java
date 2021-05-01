import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Hachiro {
    public static void main(String[] args) throws IOException
    {
        Scanner scan = new Scanner(new File("hachiro.dat"));
        int num = scan.nextInt();
        HashMap<String, Team> teams = new HashMap<String, Team>();

        // int array formatting is Wins, Ties, Losses, Points, Goal Differential
        // Wins - 0
        // Ties - 1
        // Losses - 2
        // Points - 3
        // Goal Diff - 4

        for (int i_=0; i_<num; i_++)
        {
            String hname = scan.next();
            int hscore = scan.nextInt();
            String vname = scan.next();
            int vscore = scan.nextInt();

            if (!teams.containsKey(hname))
            {
                teams.put(hname, new Team(hname));
            }
            if (!teams.containsKey(vname))
            {
                teams.put(vname, new Team(vname));
            }

            if (hscore>vscore)
            {
                // if home won, home += wins and visit += losses
                teams.get(hname).wins++;
                teams.get(vname).losses++;
                teams.get(hname).points+=3;
            }
            else if (vscore>hscore)
            {
                // if visit won, home += losses and visit += wins
                teams.get(hname).losses++;
                teams.get(vname).wins++;
                teams.get(vname).points+=3;
            }
            else if (hscore==vscore)
            {
                // if tied update both tied
                teams.get(hname).ties++;
                teams.get(vname).ties++;
                teams.get(hname).points++;
                teams.get(vname).points++;
            }

            //update goal differentials
            teams.get(hname).gd+=hscore-vscore;
            teams.get(vname).gd+=vscore-hscore;
        }

        ArrayList<Team> teamList = new ArrayList<>();
        for (String teamName: teams.keySet())
        {
            teamList.add(teams.get(teamName));
        }

        //teamList is an array of Team objects. sort this ascending by wins, and then by GD.

        System.out.println("6A District 33 Soccer Table");
        System.out.printf("%-8s%3s%3s%3s%3s%4s\n", "Team", "W", "T", "L", "P", "GD");
        for (Team team : teamList)
        {
            System.out.printf("%-8s%3s%3s%3s%3s%4s\n", team.name, team.wins, team.ties, team.losses, team.points, team.gd);
        }
    }

    public static class Team
    {
        public int wins = 0;
        public int ties = 0;
        public int losses = 0;
        public int points = 0;
        public int gd = 0;
        public String name;

        public Team(String name)
        {
            this.name = name;
        }
    }

//    static class teamCompare implements Comparable<Team> {
//        public int compareTo(Team a1, Team a2) {
//            if (a1.wins>a2.wins)
//            {
//                return -1;
//            }
//            else if (a1.wins<a2.wins)
//            {
//                return 1;
//            }
//            else if (a1.wins==a2.wins)
//            {
//                if (a1.gd>a2.gd)
//                {
//                    return -1;
//                }
//                else if (a1.gd<a2.gd)
//                {
//                    return 1;
//                }
//            }
//        }
//    }

}




