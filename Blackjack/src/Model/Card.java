package Model;

public class Card {

	//***************************************** Variables *********************************************
	/** The Card type*/
	private CardType cType;
	/** The Card value*/
	private int cValue;

	//***************************************** Constructors ******************************************
	/**
	 * Full C'tor. 
	 */
		public Card (CardType type,int value){
			this.setcType(type);
			this.setcValue(value);
		}
	
	/**
	 * @return the cType
	 */
	public CardType getcType() {
		return cType;
	}
	
	/**
	 * @param cType the cType to set
	 */
	public void setcType(CardType cType) {
		this.cType = cType;
	}
	
	/**
	 * @return the cValue
	 */
	public int getcValue() {
		return cValue;
	}
	
	/**
	 * @param cValue the cValue to set
	 */
	public void setcValue(int cValue) {
		this.cValue = cValue;
	}
	
	/*
	 * HashCode with value + type
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cType == null) ? 0 : cType.hashCode());
		result = prime * result + cValue;
		return result;
	}
	
	/* 
	 * Equals with value + type
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cType != other.cType)
			return false;
		if (cValue != other.cValue)
			return false;
		return true;
	}
	
	
	
}
