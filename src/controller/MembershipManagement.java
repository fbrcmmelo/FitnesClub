package controller;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import model.Member;
import model.MultiClubMember;
import model.SingleClubMember;
import service.Calculator;

public class MembershipManagement {

    final private Scanner reader = new Scanner(System.in);

    public int getInput() {
        int input = 0;

        while (input == 0) {
            try {
                System.out.println("Enter a number: \n");
                input = reader.nextInt();

                if (input == 0) {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                reader.nextLine();
                System.out.println("Problems with entered number 0, error: " + e.getMessage());
            }
        }
        return input;
    }

    public void printClubOptions() {
        System.out.println("1)Club Mercury \n" +
                "2)Club Neptune \n" +
                "3)Club Jupter \n" +
                "4)Multi Clubs");
    }

    public int getChoice() {
        int choice = 0;

        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("===============================");
        System.out.println("\n1)Add Member" +
                "\n2)Remove Member" +
                "\n3)Display Member Information");
        System.out.println("Please, select an option (or enter -1 to exit): ");
        choice = reader.nextInt();

        if (choice == -1) {
            return 0;
        }
        return choice;
    }

    public String addMembers(LinkedList<Member> m) {
        String name, mem;
        int club, memberID;
        double fess;
        Member mbr;
        Calculator<Integer> cal;

        System.out.println("Enter your name: ");
        name = reader.next();

        printClubOptions();
        System.out.println("Please select the member's ClubID: ");
        club = getInput();

        while (club < 1 && club > 4) {

            System.out.println("Invalid club's option input");
            System.out.println("Try again");
            club = getInput();

        }

        if (m.size() > 0) {

            memberID = m.getLast().getMemberID() + 1;

        } else {

            memberID = 1;

        }

        if (club != 4) {

            cal = (n) -> {
                if (n == 1) {
                    return 900;
                } else if (n == 2) {
                    return 950;
                } else if (n == 3) {
                    return 1000;
                } else {
                    return -1;
                }
            };

            fess = cal.calculateFees(club);

            mbr = new SingleClubMember('S', memberID, name, fess, club);
            m.add(mbr);
            mem = mbr.toString();

            System.out.println("\n The SingleClubMember was added successufuly ");

        } else {

            cal = (n) -> {
                switch (n) {
                    case 4:
                        return 1200;
                    default:
                        return -1;
                }
            };

            fess = cal.calculateFees(club);

            mbr = new MultiClubMember('M', memberID, name, fess, 100);
            m.add(mbr);
            mem = mbr.toString();

            System.out.println("\n The MulticlubMember was added successufuly ");

        }
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberID;

        System.out.println("Enter the member ID that you want to remove: ");
        memberID = reader.nextInt();

        m.forEach(mem -> {
            if (mem.getMemberID() == memberID) {
                
                int i = m.indexOf(mem);
                m.remove(i);
                System.out.println("Member was exlcued successufuly");
                return;
            }
            System.out.println("MemberID not found");

        });
    }

    public void printMemberInformation(LinkedList<Member> m) {

        int memberID;

        System.out.println("Enter the Member ID to display your informations: ");
        memberID = reader.nextInt();

        for (int i = 0; i< m.size(); i++) {  
            if (m.get(i).getMemberID() == memberID) {              
                String [] memberInfo = m.get(i).toString().split(",");
                System.out.println("\n\nMember ID: " + memberInfo[1]);
                System.out.println("Member Name: " + memberInfo[2]);
                System.out.println("Membership Fees: " + memberInfo[3]);

                if (memberInfo[0].equals("S")) {
                    System.out.println("Club ID: " + memberInfo[4]);
                } else {
                    System.out.println("Membership Points: " + memberInfo[4]);
                }
                return;
            } 
            System.out.println("Member not found");
        }
    }
        // for (Member mem : m) {
        // if (mem.getMemberID() == memberID) {
        // int i = m.indexOf(mem);
        // m.remove(i);

        // System.out.println("Member: " + mem.getName() + ", ID: " + memberID + " was
        // exclued successufuly" );
        // }
        // }
}
