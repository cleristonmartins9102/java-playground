package sup;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        CreateAccountDTO accountData = new CreateAccountDTO();
        accountData.id = "01";
        accountData.firstName = "Cleriston";
        AccountRepository repository = new AccountRepository(() ->  "Invalid email provided");
        try {
            repository.save(accountData);
        } catch (Exception e) {
            System.out.println("Test");
            throw new RuntimeException(e);
        }
    }
}
