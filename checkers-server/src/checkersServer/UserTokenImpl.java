package checkersServer;

import checkersApi.UserToken;

public class UserTokenImpl implements UserToken {
	
	private static final long serialVersionUID = 1L;

	private static int number = 0;
	
	private int myNumber;
	
	public UserTokenImpl() {
		this.myNumber = number;
		
		number++;
	}

	@Override
	public int getNum() {
		return number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + myNumber;
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
		UserTokenImpl other = (UserTokenImpl) obj;
		if (myNumber != other.myNumber)
			return false;
		return true;
	}
	
	

}
