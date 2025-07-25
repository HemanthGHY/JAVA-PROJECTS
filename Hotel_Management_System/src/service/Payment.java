package service;
public class Payment {
    
    // enum Status {
    //     BALANCE,
    //     PAID;
    //     }
    private String paymentId;
    // private Status paymentStatus;
    private double totalAmount;
    private double advanceAmount;
    private double balanceAmount;

    // public String getBalanceAmount(String id,Guest g) {
    //     return balanceAmount;
    // }
    public void setStatusPaid(){
        this.balanceAmount = 0;
        this.advanceAmount = 0;
    }
    public double getBalanceAmount(){
        return balanceAmount;
    }
    // public Payment(String paymentId,double totalAmount){
    //     this.paymentId = paymentId;
    //     // this.paymentStatus = 1;
    //     this.totalAmount = totalAmount;
    //     this.balanceAmount = totalAmount;
    // }
    public Payment(String paymentId, double totalAmount, double advanceAmount) {
        this.paymentId = paymentId;
        // this.paymentStatus = paymentStatus;
        this.totalAmount = totalAmount;
        this.advanceAmount = advanceAmount;
        this.balanceAmount = totalAmount - advanceAmount;

    }
    @Override
    public String toString(){
        return "Payment{" + "paymentId='" + paymentId + '\'' + ", totalAmount=" + totalAmount + ", advance Amount=" + advanceAmount + ", balanceAmount=" + balanceAmount + '}';
    }
    public String getpaymentId() {
        return this.paymentId;
    }
}
