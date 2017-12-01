package tr.edu.sehir.sockets;

import java.io.Serializable;

public class Message1 implements Serializable {
    private static final long serialVersionUID = -5399605122490343339L;

    private Integer a;
    private Integer b;
    private Integer Result;

    public Message1(Integer firstNumber, Integer secondNumber ){
        this.a = firstNumber;
        this.b = secondNumber;
    }

    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }

    public void setResult(Integer x, Integer y)  {
        Result = x.intValue() * y.intValue() ;
    }

    public Integer getResult() {
        return Result;
    }
}
