import java.util.LinkedList;

import controller.MembershipManagement;
import model.Member;
import utils.FileHandler;

public class App {
    public static void main(String[] args) throws Exception {
        FileHandler fh = new FileHandler();
        MembershipManagement msm = new MembershipManagement();

        LinkedList<Member> m = fh.readFile();
        int choice = msm.getChoice();
        String mem;

        while (choice != 0) {

            switch (choice) {
                case 1:
                    mem = msm.addMembers(m);
                    fh.appendFile(mem);
                    break;
                case 2:
                    msm.removeMember(m);
                    fh.overwriteFile(m);
                    break;
                case 3:
                    msm.printMemberInformation(m);
                    break;
                default:
                    System.out.println("You have selected an invalid number's option \n\n");
                    break;
            }
            choice = msm.getChoice();
        }
        System.out.println("Bye");
    }
}
