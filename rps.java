import java.util.*;
public class rps{
    public static void main(String args[]){

        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        int d = 0;
        int w = 0;
        int l = 0;

        int r = 0;
        int p = 1;
        int s = 2;

        System.out.print("Rock = 0\nPaper = 1\nScissor = 2\n");

        for(int i=0 ; i<3 ; i++){


            int c = rd.nextInt(3);
            System.out.print( "\nEnter ur " + (i+1) + " Choice :");
            
            int h = sc.nextInt();

            if(h<0 || h>2){
                System.out.println("Invalid input");
                break;
            }

            if(c==0) System.out.println("Computer chooses rock");
            else if(c==1) System.out.println("Computer chooses paper");
            else System.out.println("Computer chooses scissor");



            if(h == c){
                System.out.println("Draw");
                d++;
            }else if(h==0 && c==1 || h==1 && c==2 || h==2 && c==0){
                System.out.println("Computer Wins!");
                l++;
            }else{
                System.out.println("You win !");
                w++;
            }
        }

        System.out.println("===========RESULT==========");
        System.out.println("Computer win = " + l);
        System.out.println("User win = " + w);
        System.out.println("Draw = " + d);
    }
}