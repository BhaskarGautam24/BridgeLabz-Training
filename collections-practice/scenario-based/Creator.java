import java.util.*;
public class Creator{

    public static List<CreatorStats> EngagementBoard=new ArrayList<>();
    public void RegisterCreator(CreatorStats record){
        EngagementBoard.add(record);
    }
    public HashMap<String,Integer> GetTopPostCounts(List<CreatorStats> records,double likeThreshold){

        HashMap<String,Integer> map=new HashMap<>();

        for(CreatorStats cs:records){

            int count=0;

            for(double likes:cs.WeeklyLikes){
                if(likes>=likeThreshold){
                    count++;
                }
            }

            if(count>0){
                map.put(cs.CreatorName,count);
            }
        }
        return map;
    }
    public double CalculateAverageLikes(){

        double totalLikes=0;
        int totalWeeks=0;

        for(CreatorStats cs:EngagementBoard){
            for(double likes:cs.WeeklyLikes){
                totalLikes=totalLikes+likes;
                totalWeeks++;
            }
        }
        if(totalWeeks==0){
            return 0;
        }
        return totalLikes/totalWeeks;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Program obj=new Program();

        while(true){
            System.out.println();
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice=sc.nextInt();
            sc.nextLine();

            if(choice==1){

                CreatorStats cs=new CreatorStats();

                System.out.println("Enter Creator Name:");
                cs.CreatorName=sc.nextLine();

                cs.WeeklyLikes=new double[4];
                System.out.println("Enter weekly likes (Week 1 to 4):");

                for(int i=0;i<4;i++){
                    cs.WeeklyLikes[i]=sc.nextDouble();
                }
                obj.RegisterCreator(cs);
                System.out.println("Creator registered successfully");

            }else if(choice==2){
                System.out.println("Enter like threshold:");
                double threshold=sc.nextDouble();

                HashMap<String,Integer> result=
                        obj.GetTopPostCounts(EngagementBoard,threshold);

                if(result.isEmpty()){
                    System.out.println("No top-performing posts this week");
                }else{
                    for(String name:result.keySet()){
                        System.out.println(name+" - "+result.get(name));
                    }
                }
            }else if(choice==3){

                double avg=obj.CalculateAverageLikes();
                System.out.println("Overall average weekly likes: "+(int)avg);

            }else if(choice==4){

                System.out.println("Logging off - Keep Creating with StreamBuzz!");
                break;
            }
        }
    }
}
class CreatorStats{
    public String CreatorName;
    public double[] WeeklyLikes;
}
