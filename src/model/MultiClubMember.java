package model;

public class MultiClubMember extends Member {
    private int memberShipPoints;

    public MultiClubMember(char pMemberType, int pMemberID, String pName, Double pFees, int memberShipPoints) {
        super(pMemberType, pMemberID, pName, pFees);
        this.memberShipPoints = memberShipPoints;
    }

    
    public int getMemberShipPoints() {
        return memberShipPoints;
    }
    
    public void setMemberShipPoints(int memberShipPoints) {
        this.memberShipPoints = memberShipPoints;
    }
    
    @Override
    public String toString() {
        super.toString();
        return "M,"
        +this.getMemberID()+","
        +this.getName()+","
        +this.getfees()+","+
        +this.getMemberShipPoints()+"\n";
    }
}
