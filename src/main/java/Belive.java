import java.time.LocalDate;


//class Payment {
//    public void processPayment(double amount) {
//        System.out.println("Processing generic payment of $" + amount);
//    }
//}

//class CreditCardPayment extends Payment {
//    @Override
//    public void processPayment(double amount) {
//        System.out.println("Processing credit card payment of $" + amount);
//    }
//}

//class PayPalPayment extends Payment {
//    @Override
//    public void processPayment(double amount) {
//        System.out.println("Processing PayPal payment of $" + amount);
//    }
//}


class TechEazy {
    private String tenantEntityId = "lms";
    private String tenantId = "tech_eazy";

    public String getTenantEntityId() {
        return tenantEntityId;
    }

    public void setTenantEntityId(String tenantEntityId) {
        this.tenantEntityId = tenantEntityId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String toString() {
        return "TechEazy{" +
                "tenantEntityId='" + tenantEntityId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                '}';
    }
}

class User extends TechEazy {
    private String email;
    private LocalDate createDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "techEazy createDate " + super.getTenantEntityId() + "\\" +
                "email='" + email + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}

class User1 extends TechEazy {
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


@FunctionalInterface
interface MyCustomFI {
    String doSomething(String expression);
}


public class Belive {
    public static void main(String[] args) {

//        String paymentType =  "CreditCardPayment" ; // Your-payment-type-coming-from-client-side
//        double amount = 0.0;    // Your-amount-type-coming-from-client-side;
//
//        Payment payement ;
//
//        if(paymentType.equalsIgnoreCase("CreditCardPayment")){
//             payement = new CreditCardPayment();
//        }else if(paymentType.equalsIgnoreCase("PayPalPayment")) {
//             payement = new PayPalPayment();
//        }else {
//             payement = new Payment() ;
//        }
//
//        payement.processPayment(amount);

//     User user = new User();
//     user.setEmail("Hello");
//     user.setCreateDate(LocalDate.now());
//        System.out.println(user);

        MyCustomFI myCustomFI = expression -> expression ;
        myCustomFI.doSomething("Hello");


    }
}
/*
https://leetcode.com/problems/grumpy-bookstore-owner/solutions/
https://leetcode.com/problems/sum-of-square-numbers/description/
https://leetcode.com/problems/most-profit-assigning-work/description/
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/submissions/1293747751/
https://leetcode.com/problems/count-number-of-nice-subarrays/description/?envType=daily-question&envId=2024-06-22
https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?envType=daily-question&envId=2024-06-23
https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/description/
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/?envType=daily-question&envId=2024-06-25
https://leetcode.com/problems/balance-a-binary-search-tree/description/?envType=daily-question&envId=2024-06-26
https://leetcode.com/problems/find-center-of-star-graph/description/
https://leetcode.com/problems/maximum-total-importance-of-roads/description/
https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/
https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/description/
https://leetcode.com/problems/number-of-atoms/description/
https://leetcode.com/problems/maximum-score-from-removing-substrings/description/
https://leetcode.com/problems/robot-collisions/description/
2096. Step-By-Step Directions From a Binary Tree Node to Another
https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
 */