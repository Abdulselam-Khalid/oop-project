  public interface Payment {
    boolean processPayment(double amount);
}

    class CreditCardPayment implements Payment {
        @Override
        public boolean processPayment(double amount) {
            // Process credit card payment
            return true;  // Simulate payment success
        }
    }

    class PaparaPayment implements Payment {
        @Override
        public boolean processPayment(double amount) {
            // Process Papara payment
            return true;  // Simulate payment success
}
    }

