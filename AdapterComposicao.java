import java.math.BigDecimal;

/**
 * @author Roberto de Souza - github.com/rabbittrix
 */
// --------------- Client ---------------
public class AdapterComposicao {
    public static void main(String[] args) {
        ProceedPayment credito = new BankPaymentCredit();
        credito.debitar(new BigDecimal("100"));

    }
}
// ------------------ Target --------------------

interface ProceedPayment {
    void debitar(BigDecimal valor);

    void creditar(BigDecimal valor);
}

// ------------------ Adapter -------------------

class BankPaymentCredit implements ProceedPayment {
    SdkOutSideConsumed2 sdkOutSideConsumed2 = new SdkOutSideConsumed2();
    // SdkOutSideConsumed sdkOutSideConsumed = new SdkOutSideConsumed();

    public void debitar(BigDecimal valor) {
        sdkOutSideConsumed2.authorize(valor);
        sdkOutSideConsumed2.capture(valor);
    }

    public void creditar(BigDecimal valor) {
        sdkOutSideConsumed2.credit(valor);
    }

}

// ---------------- Adaptee --------------------

class SdkOutSideConsumed2 {
    public void authorize(BigDecimal valor) {
        // Authorize
    }

    public void capture(BigDecimal valor) {
        // Capture
    }

    public void credit(BigDecimal valor) {
        // Credit
    }
}