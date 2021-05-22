package kodlamaio.northwind.core.utilities.results;

public class SucessDataResult<T> extends DataResult<T> {

	public SucessDataResult(T data, String message) {
		super(data, true, message);
	}
	
	public SucessDataResult(T data) {
		super(data, true);
	}
	
	public SucessDataResult(String message) {
		super(null, true, message);
	}
	
	public SucessDataResult() {
		super(null, true);
	}
}
