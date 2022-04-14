package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import model.Member;
import model.MultiClubMember;
import model.SingleClubMember;

public class FileHandler {

  public LinkedList<Member> readFile() {
    LinkedList<Member> m = new LinkedList<>();
    String line;
    String[] splitLine;
    Member mem;

    try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {

      line = reader.readLine();

      while (line != null) {
        splitLine = line.split(",");

        if (splitLine[0].equals("S")) {
          mem = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2],
              Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
        } else {
          mem = new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2],
              Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4].trim()));
        }
        m.add(mem);
        line = reader.readLine();
      }
    } catch (IOException e) {
      System.out.println("Problem to read the file, error: " + e.getMessage());
      e.printStackTrace();
    }
    return m;
  }

  public void appendFile(String mem) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("member.csv", true))) {
      writer.write(mem + "\n");
      writer.newLine();
    } catch (IOException e) {
      System.out.println("Problem to write in the file, error: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public void overwriteFile(LinkedList<Member> m) {
    String s;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp"))) {
      for (Member mem : m) {
        s = mem.toString();
        writer.write(s + "\n");
        writer.newLine();
      }
    } catch (IOException e) {
      System.out.println("Problem to overwrite the File, error: " + e.getMessage());
      e.printStackTrace();
    }
    try {
      File f = new File("members.csv");
      File tf = new File("members.temp");

      tf.renameTo(f);
      f.delete();
    } catch (Exception e) {
      System.out.println("Problems to rename the temp file, error: " + e.getMessage());
    }
  }
}
