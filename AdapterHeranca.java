import java.math.BigDecimal;

/**
 * @author Roberto de Souza - github.com/rabbittrix
 */
// --------------- Client ---------------
public class AdapterHeranca {
    public static void main(String[] args) {
        PaymentProceed credito = new BankPaymentCredit();
        credito.debitar(new BigDecimal("100"));

    }
}

// ------------------ Target --------------------

interface PaymentProceed {
    void debitar(BigDecimal valor);

    void creditar(BigDecimal valor);

}
// ------------------ Adapter (Proxy) -------------------

class BankPaymentCredit extends SdkOutSideConsumed implements PaymentProceed {
    public void debitar(BigDecimal valor) {
        super.authorize(valor);
        super.capture(valor);
    }

    public void creditar(BigDecimal valor) {
        super.credit(valor);
    }
    /*
     * @Override
     * void authorize(BigDecimal valor){
     * // mudou o comportamento - e não é mais two way
     * }
     */
}

// ---------------- Adaptee --------------------

class SdkOutSideConsumed {
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