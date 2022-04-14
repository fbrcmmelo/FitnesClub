package model;

public class SingleClubMember extends Member{
    private int club;

    public SingleClubMember(char pMemberType, int pMemberID, String pName, Double pFees, int club) {
        super(pMemberType, pMemberID, pName, pFees);
        this.club = club;
    }

    public int getClub() {
        return club;
    }

    public void setClub(int club) {
        this.club = club;
    }

    @Override
    public String toString() {
        super.toString();
        return "S,"
                +this.getMemberID()+","
                +this.getName()+","
                +this.getfees()+","+
                +this.getClub()+"\n";
    }
    
}
