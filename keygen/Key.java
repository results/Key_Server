package keygen;
  
/**
 * Represents a key
 * @author John
 *
 */
public class Key {
 
	private String key;
	private String purchaser;
	private String purchaseDate;
	private String purchaseIP;
	private String expirationDate;
	private String use;
	private int itemID;
	private int membershipLength;
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public  String getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(String string) {
		this.purchaser = string;
	}

	public  String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public String getPurchaseIP() {
		return purchaseIP;
	}

	public void setPurchaseIP(String purchaseIP) {
		this.purchaseIP = purchaseIP;
	} 

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}
	
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public int getMembershipLength() {
		return membershipLength;
	}

	public void setMembershipLength(int membershipLength) {
		this.membershipLength = membershipLength;
	}
	
	@Override
	public String toString() {
	   return "thisFormat [Purchaser=" + this.getPurchaser() + ", Purchase Date=" + this.getPurchaseDate() + ""
	   		+ ", Purchase IP="+ this.getPurchaseIP() + ", Expiration Date="+ this.getExpirationDate() + ""+ ","
	   		+ ", Use="+ this.getUse() + " Item ID="+ this.getItemID() + ","+ " Membership Length="+ this.getMembershipLength() + "]";
	}
}