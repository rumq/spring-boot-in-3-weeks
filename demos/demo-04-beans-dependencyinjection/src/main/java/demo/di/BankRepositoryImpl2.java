package demo.di;

import org.springframework.stereotype.Repository;

@Repository
public class BankRepositoryImpl2 implements BankRepository {

	@Override
	public void update(int accountId, double amount) {
		System.out.printf("\tIn RepositoryImpl2.update(%d, %.2f)\n", accountId, amount);
	}
}
