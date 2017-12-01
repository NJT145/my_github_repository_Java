package tr.edu.sehir;

import java.io.Serializable;

public class Order implements Serializable {

    private static final long serialVersionUID = -5399605122490343339L;

    public Order(String mealName1, float mealCost1) {
        this.mealName = mealName1;
        this.mealCost = mealCost1;
    }
    private String mealName;
    private float mealCost;
    private String result;
    public String getMealName() { return this.mealName; }
    public float getMealCost() { return this.mealCost; }
    public String getOrderResult() { return this.result; }
    public void setOrderResult(String result1) { this.result = result1; }
}
