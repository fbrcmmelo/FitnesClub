package model;

public class Member{
    
    private char memberType;
    private int memberID;
    private String name;
    private Double fees;

    public Member(char pMemberType, int pMemberID, String pName, Double pFees){
        super();
        this.memberType = pMemberType;
        this.memberID = pMemberID;
        this.name = pName;
        this.fees = pFees;
    }

    public Member(){}

    /**
     * @return char return the memberType
     */
    public char getMemberType() {
        return memberType;
    }

    /**
     * @param memberType the memberType to set
     */
    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    /**
     * @return int return the memberID
     */
    public int getMemberID() {
        return memberID;
    }

    /**
     * @param memberID the memberID to set
     */
    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Double return the fees
     */
    public Double getfees() {
        return fees;
    }

    /**
     * @param fees the fees to set
     */
    public void setfees(Double fees) {
        this.fees = fees;
    }

    // @Override
    // public String toString(){
    //     return "MemberType: " + this.memberType +
    //            " MemberID: " + this.memberID +
    //            " Name: " + this.name + 
    //            " Fees: " + this.fees;
    // }        

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("MemberType: ");
        sb.append(this.memberType).append("\n");
        sb.append("MemberID: ");
        sb.append(this.memberID).append("\n");
        sb.append("Name: ");
        sb.append(this.name).append("\n");
        sb.append("fees: ");
        sb.append(this.fees).append("\n");
        return sb.toString(); 
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fees == null) ? 0 : fees.hashCode());
        result = prime * result + memberID;
        result = prime * result + memberType;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (fees == null) {
            if (other.fees != null)
                return false;
        } else if (!fees.equals(other.fees))
            return false;
        if (memberID != other.memberID)
            return false;
        if (memberType != other.memberType)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }        
}