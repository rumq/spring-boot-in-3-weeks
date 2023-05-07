package demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bankService")
public class BankServiceImpl2 implements BankService {

	// Can use field DI:
	@Autowired
	private BankRepository repository;

	// Or can use constructor DI:
    /*
    private BankRepository repository;

    @Autowired
    public BankServiceImpl(BankRepository repository) {
        this.repository = repository;
    }
	*/

	
    @Override
	public void depositIntoAccount(int accountId, double amount) {
		System.out.printf("In BankServiceImpl2.depositIntoAccount(%d, %.2f)\n", accountId, amount);
		repository.update(accountId, amount);
	}

	@Override
	public void withdrawFromAccount(int accountId, double amount) {
		System.out.printf("In BankServiceImpl2.withdrawFromAccount(%d, %.2f)\n", accountId, amount);
		repository.update(accountId, -amount);
	}

	@Override
	public void transferFunds(int fromAccountId, int toAccountId, double amount) {
		System.out.printf("In BankServiceImpl2.transferFunds(%d, %d, %.2f)\n", fromAccountId, toAccountId, amount);
		repository.update(fromAccountId, -amount);
		repository.update(toAccountId, +amount);
	}
}
