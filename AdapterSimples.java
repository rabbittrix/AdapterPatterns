import java.math.BigDecimal;

/**
 * @author Roberto de Souza - github.com/rabbittrix
 */
// --------------- Client ---------------
public class AdapterSimples {
    public static void main(String[] args) {
        BankPaymentCredit credito = new BankPaymentCredit();
        credito.debitar(new BigDecimal("100"));

    }
}

// ------------------ Adapter -------------------

class BankPaymentCredit { // você tem acesso! é sua!
    SdkOutSideConsumed sdkOutSideConsumed = new SdkOutSideConsumed();

    public void debitar(BigDecimal valor) {
        sdkOutSideConsumed.authorize(valor);
        sdkOutSideConsumed.capture(valor);
    }

    public void creditar(BigDecimal valor) {
        sdkOutSideConsumed.credit(valor);
    }

}

// ---------------- Adaptee --------------------

class SdkOutSideConsumed { // SDK fechada! você não tem acesso!
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