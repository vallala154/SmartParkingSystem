import java.util.Scanner;

import model.ParkingSession;
import model.*;
import repository.SessionRepository;
import repository.SlotRepository;
import repository.UserRepository;
import service.AuthService;
import service.ParkingService;
import util.ConsoleAnimator;

public class Main {

    public static void main(String[] args){

        ConsoleAnimator.startup();

        Scanner sc = new Scanner(System.in);

        UserRepository userRepo = new UserRepository();
        SlotRepository slotRepo = new SlotRepository();
        SessionRepository sessionRepo = new SessionRepository();

        AuthService authService = new AuthService(userRepo);
        ParkingService parkingService = new ParkingService(slotRepo,sessionRepo);

        while(true){

            System.out.println("1 Register");
            System.out.println("2 Login");
            System.out.println("3 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if(choice==1){

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Password: ");
                String password = sc.nextLine();

                if(authService.register(email,password)){
                    System.out.println("Registered successfully\n");
                }else{
                    System.out.println("User already exists\n");
                }

            }
            else if(choice==2){

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Password: ");
                String password = sc.nextLine();

                User user = authService.login(email,password);

                if(user==null){
                    System.out.println("Invalid login\n");
                    continue;
                }

                System.out.println("Login successful\n");

                ParkingSession activeSession = null;

                while(true){

                    System.out.println("\n1 Park Vehicle");
                    System.out.println("2 End Parking");
                    System.out.println("3 Logout");

                    int op = sc.nextInt();
                    sc.nextLine();

                    if(op==1){

                        parkingService.displaySlots();

                        System.out.print("Select Slot: ");
                        String slot = sc.nextLine();

                        activeSession = parkingService.startParking(user.getEmail(),slot);

                        if(activeSession==null){
                            System.out.println("Slot unavailable");
                        }else{
                            System.out.println("Parking started at "+activeSession.getStartTime().toLocalTime());
                        }

                    }

                    else if(op==2){

                        if(activeSession!=null){
                            parkingService.endParking(activeSession);
                            activeSession=null;
                        }else{
                            System.out.println("No active parking session");
                        }

                    }

                    else if(op==3){
                        break;
                    }
                }
            }
            else{
                System.exit(0);
            }
        }
    }
}