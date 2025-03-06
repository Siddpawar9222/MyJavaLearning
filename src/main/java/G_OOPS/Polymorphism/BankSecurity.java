package G_OOPS.Polymorphism;

class BankSecurity {
    // Static method for user authentication (Resolved at compile time)
    static boolean authenticateUser(String username, String password) {
        return "admin".equals(username) && "securePass123".equals(password);
    }
}
