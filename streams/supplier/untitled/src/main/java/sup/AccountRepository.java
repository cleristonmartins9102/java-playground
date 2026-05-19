package sup;

import java.util.function.Supplier;

public class AccountRepository {
    Supplier<String> emailValidatorMessage;
    public AccountRepository(Supplier<String> emailValidatorMessage) {
        this.emailValidatorMessage = emailValidatorMessage;
    }
    public void save(CreateAccountDTO accountData) {
        if (accountData.email == null) {
            throw new Error(this.emailValidatorMessage.get());
        } else {
            // Save
        }
    }
}
