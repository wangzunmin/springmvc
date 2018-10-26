package springmvc.mvctest.rest.exception;

public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8800034641955870528L;
	private Integer bno;

	public BookNotFoundException(Integer bno) {
		this.bno = bno;
	}

	public Integer getBno() {
		return bno;
	}
	
	
}
