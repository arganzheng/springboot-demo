package life.arganzheng.study.springboot.exception;

public class StudentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 104524045529552538L;

    public StudentNotFoundException(String exception) {
        super(exception);
    }
}
